package com.example.datastore_and_fetch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText Eventname , Description, Imageurl, Organizername, Timimg, Date;

    Button btnRegister , showdata, uploadimage;


    DatabaseReference df;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Eventname = findViewById(R.id.FullName);
        Description = findViewById(R.id.Description);
        Imageurl = findViewById(R.id.imageurl);
        Organizername = findViewById(R.id.organizername);
        Timimg = findViewById(R.id.timimg);
        uploadimage = findViewById(R.id.btnuploadimage);
        Date = findViewById(R.id.date);
        showdata = findViewById(R.id.btnshowdata);
        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),retrivedata.class);
                startActivity(intent);
            }
        });
        btnRegister = findViewById(R.id.btnRegister);
        df = FirebaseDatabase.getInstance().getReference().child("EventsCreated");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertEventdata();
            }
        });



        //upload image

        uploadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }




    private void insertEventdata() {

        String eventname = Eventname.getText().toString();
        String description = Description.getText().toString();
        String imageurl = Imageurl.getText().toString();
        String organizername = Organizername.getText().toString();
        String timimg = Timimg.getText().toString();
        String date = Date.getText().toString();

        eventcreationhelperclass help = new eventcreationhelperclass(eventname,description,imageurl,organizername,timimg,date);

        df.child(eventname).setValue(help);
        Toast.makeText(this, "entered data perfectly", Toast.LENGTH_SHORT).show();

    }
}