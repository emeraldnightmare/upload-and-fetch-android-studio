package com.example.datastore_and_fetch;

public class eventcreationhelperclass {

    String Eventname , Description, Imageurl, Organizername, Timimg, Date;

    public eventcreationhelperclass() {
    }

    public eventcreationhelperclass(String eventname, String description, String imageurl, String organizername, String timimg, String date) {
        Eventname = eventname;
        Description = description;
        Imageurl = imageurl;
        Organizername = organizername;
        Timimg = timimg;
        Date = date;
    }

    public void setEventname(String eventname) {
        Eventname = eventname;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }

    public void setOrganizername(String organizername) {
        Organizername = organizername;
    }

    public void setTimimg(String timimg) {
        Timimg = timimg;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEventname() {
        return Eventname;
    }

    public String getDescription() {
        return Description;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public String getOrganizername() {
        return Organizername;
    }

    public String getTimimg() {
        return Timimg;
    }

    public String getDate() {
        return Date;
    }
}
