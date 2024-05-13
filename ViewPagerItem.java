package com.example.crimereportn;

public class ViewPagerItem {

    int imageID;
    String heading, description,datetime;

    public ViewPagerItem(int imageID, String heading, String datetime,String description) {
        this.imageID = imageID;
        this.heading = heading;

        this.datetime= datetime;
        this.description = description;
    }
}