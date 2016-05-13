package com.example.maiquel.dduro.view;

import android.graphics.Bitmap;

/**
 * Created by Rp on 3/16/2016.
 */
public class OccurrenceListView
{
    private Bitmap image;
    private String title;
    private String desc;
    private  String date;


    public OccurrenceListView(Bitmap image, String title, String desc, String date) {
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.date = date;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}


