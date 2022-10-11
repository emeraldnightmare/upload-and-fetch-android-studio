package com.example.datastore_and_fetch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class retriveadapter extends ArrayAdapter {

    private Activity mContext;
    List<eventcreationhelperclass> eventList;


    public retriveadapter(Activity mContext, List<eventcreationhelperclass> eventList) {

        super(mContext, R.layout.activity_retrivedata, eventList);
        this.mContext = mContext;
        this.eventList = eventList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        LayoutInflater inflater = mContext.getLayoutInflater();
        View eventListItem = inflater.inflate(R.layout.list_item, null, true);

         TextView Eventname = eventListItem.findViewById(R.id.Eventname);
        TextView Description = eventListItem.findViewById(R.id.description);
//        ImageView Imageurl = eventListItem.findViewById(R.id.Imageurl);
        TextView Organizername = eventListItem.findViewById(R.id.organizername);
        TextView Timimg = eventListItem.findViewById(R.id.Timimg);
        TextView Date = eventListItem.findViewById(R.id.Date);

        eventcreationhelperclass eventcreationhelperclass = eventList.get(position);

        Eventname.setText(eventcreationhelperclass.getEventname());
        Description.setText(eventcreationhelperclass.getDescription());
//        Imageurl.setImage(eventcreationhelperclass.getImageurl());
        Organizername.setText(eventcreationhelperclass.getOrganizername());
        Timimg.setText(eventcreationhelperclass.getTimimg());
        Date.setText(eventcreationhelperclass.getDate());

        return eventListItem;

    }

}
