package com.example.datastore_and_fetch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class retrivedata extends AppCompatActivity {

    ListView myList;
    List<eventcreationhelperclass> studentlist;

    DatabaseReference df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrivedata);

        myList = findViewById(R.id.myListView);
        studentlist = new ArrayList<>();

        df = FirebaseDatabase.getInstance().getReference("EventsCreated");
        df.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                studentlist.clear();
                for(DataSnapshot studentDatasnap: snapshot.getChildren()){
                    eventcreationhelperclass student = studentDatasnap.getValue(eventcreationhelperclass.class);
                    studentlist.add(student);
                }
                retriveadapter retriveadapter = new retriveadapter(retrivedata.this,studentlist);
                myList.setAdapter(retriveadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}