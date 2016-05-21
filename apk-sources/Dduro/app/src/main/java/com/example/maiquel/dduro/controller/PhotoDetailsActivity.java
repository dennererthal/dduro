package com.example.maiquel.dduro.controller;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.maiquel.dduro.R;

public class PhotoDetailsActivity extends AppCompatActivity
{

    private ImageView imageDetailsMiniature;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);

        imageDetailsMiniature = (ImageView) findViewById(R.id.imageDetailsMiniature);

        Bundle outBundle = this.getIntent().getExtras().getBundle(null);

        Bitmap pic = (Bitmap) outBundle.get("image");

        imageDetailsMiniature.setImageBitmap(pic);
    }
}
