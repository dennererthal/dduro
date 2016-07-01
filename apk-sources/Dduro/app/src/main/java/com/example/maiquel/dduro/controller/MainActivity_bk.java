//http://www.tutorialspoint.com/android/android_camera.htm

package com.example.maiquel.dduro.controller;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

import com.example.maiquel.dduro.R;

public class MainActivity_bk extends AppCompatActivity
{
    Button bt_dduro;
    ImageView iv_camera;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bk);

        bt_dduro = (Button) findViewById(R.id.bt_dduro);
        iv_camera = (ImageView) findViewById(R.id.iv_camera);


        bt_dduro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {   //método auto gerado
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap pic = (Bitmap) data.getExtras().get("data");

        iv_camera.setImageBitmap(pic);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
