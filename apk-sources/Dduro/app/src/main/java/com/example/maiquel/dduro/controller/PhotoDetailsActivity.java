package com.example.maiquel.dduro.controller;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.maiquel.dduro.R;

public class PhotoDetailsActivity extends AppCompatActivity {
    private Button bt_dduro_details;
    private EditText textfield_title, textfield_local, textfield_description;
    private ImageView imageDetailsMiniature;

    private LocationManager locationManager;

    private com.example.maiquel.dduro.model.data.Location pic_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);

        initComponents();
    }

    private void initComponents() {
        imageDetailsMiniature = (ImageView) findViewById(R.id.imageDetailsMiniature);
        bt_dduro_details = (Button) findViewById(R.id.bt_dduro_details);
        textfield_title = (EditText) findViewById(R.id.textfield_title);
        textfield_local = (EditText) findViewById(R.id.textfield_local);
        textfield_description = (EditText) findViewById(R.id.textfield_description);
        pic_location = new com.example.maiquel.dduro.model.data.Location(null, null);

        Bundle outBundle = this.getIntent().getExtras().getBundle("bundle");
        Bitmap pic = (Bitmap) outBundle.get("image");
        imageDetailsMiniature.setImageBitmap(pic);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                pic_location.setLatitude(location.getLatitude() + "");
                pic_location.setLongitude(location.getLongitude() + "");

                textfield_local.setText("Lat " + pic_location.getLatitude() + " Long " + pic_location.getLongitude());
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
                System.out.println("OIIII");
            }

            public void onProviderEnabled(String provider) {
                System.out.println("OOOI");

            }

            public void onProviderDisabled(String provider) {
                System.out.println("OIIII");
            }
        };

// Register the listener with the Location Manager to receive location updates
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            System.out.println("OII");
        } else {
            try {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            } catch (Exception e) {
                System.out.println("PAU NO GPS");
            }
        }

    }
}
