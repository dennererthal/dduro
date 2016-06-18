package com.example.maiquel.dduro.controller;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maiquel.dduro.R;

import java.text.DecimalFormat;

public class PhotoDetailsActivity extends AppCompatActivity {
    private Button bt_dduro_details;
    private EditText textfield_description;
    private TextView textfield_local;
    private ImageView imageDetailsMiniature;

    private LocationManager locationManager;
    private Location gpsLocation;

    private com.example.maiquel.dduro.model.data.Location occurrenceLocation;
    private Bitmap occurrencePic;

    private Bundle outBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);

        initComponents();
    }

    private void initComponents() {
        imageDetailsMiniature = (ImageView) findViewById(R.id.imageDetailsMiniature);
        bt_dduro_details = (Button) findViewById(R.id.bt_dduro_details);
        textfield_local = (TextView) findViewById(R.id.textfield_local);
        textfield_description = (EditText) findViewById(R.id.textfield_description);
        occurrenceLocation = new com.example.maiquel.dduro.model.data.Location(null, null);


        outBundle = this.getIntent().getExtras().getBundle("bundle");
        occurrencePic = (Bitmap) outBundle.get("image");
        imageDetailsMiniature.setImageBitmap(occurrencePic);

        bt_dduro_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textfield_description.getText() == null) {
                    AlertDialog alertDialog = new AlertDialog.Builder(PhotoDetailsActivity.this).create();
                    alertDialog.setTitle(getResources().getString(R.string.title_error));
                    alertDialog.setMessage(getResources().getString(R.string.msg_fill_description));
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    occurrenceLocation.setLatitude(gpsLocation.getLatitude() + "");
                    occurrenceLocation.setLongitude(gpsLocation.getLongitude() + "");

                    outBundle.putString("location-lat", occurrenceLocation.getLatitude());
                    outBundle.putString("location-long", occurrenceLocation.getLongitude());
                    outBundle.putString("description", textfield_description.getText().toString());

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("bundle", outBundle);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            }
        });


        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                gpsLocation = location;

                DecimalFormat df = new DecimalFormat("#.######");
                Double lat = location.getLatitude();
                Double longe = location.getLongitude();

                String locationsText = "Lat " + df.format(lat) + " Long " + df.format(longe);
                textfield_local.setText(locationsText);
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
