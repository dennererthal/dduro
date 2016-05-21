package com.example.maiquel.dduro.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maiquel.dduro.R;
import com.example.maiquel.dduro.model.data.Location;
import com.example.maiquel.dduro.model.data.Occurrence;
import com.example.maiquel.dduro.model.data.User;
import com.example.maiquel.dduro.view.ListViewAdapter;
import com.example.maiquel.dduro.view.OccurrenceListView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{

    ListView listview;

    Button bt_dduro;
    ImageView iv_camera;

    private ArrayList<OccurrenceListView> beans;
    private ListViewAdapter listViewAdapter;
    private ArrayList<Occurrence> occurrences = new ArrayList<Occurrence>();


    Typeface font1, font2;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        User usuario = new User("Geromel", "02633466095", "geromel@gremio.com", "pass1234", 'A');
        Location location = new Location("-29.971155", "-51.19613");
        java.util.Date date = new Date(2016, 5, 7);
        Drawable photo = getDrawable(R.drawable.vaca);


        Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.vaca);

        Occurrence ocurrence = new Occurrence(-1, usuario, location, "Vaca presa no poste, não sei como foi parar lá", date, img, "url da imagem", 'A');
        occurrences.add(ocurrence);


        bt_dduro = (Button) findViewById(R.id.bt_dduro);
        iv_camera = (ImageView) findViewById(R.id.iv_camera);


        bt_dduro.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

            }
        });

        updateContent();
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {   //método auto gerado
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap pic = (Bitmap) data.getExtras().get("data");
        //iv_camera.setImageBitmap(pic);


        Occurrence oc = pullOccurrenceDetails(pic);



        // constrói objeto json para envio
        JSONObject occurrenceJson = new JSONObject();

        try
        {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            pic.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream .toByteArray();
            String imageBase64 = Base64.encodeToString(byteArray, Base64.DEFAULT);

            occurrenceJson.put("description", oc.getDescription());
            occurrenceJson.put("date",oc.getDate().getTime());
            occurrenceJson.put("location",oc.getLocation().toString());
            //occurrenceJson.put("image",imageBase64);

           // sendToServer(occurrenceJson);
        }

        catch ( Exception e )
        {
            e.printStackTrace();
        }


        occurrences.add(oc);

        updateContent();

    }

    private void updateContent()
    {
        listview = (ListView) findViewById(R.id.listview);
        beans = new ArrayList<OccurrenceListView>();

/*        for (int i= 0; i< Title.length; i++) {

            OccurrenceListView beanclass = new OccurrenceListView(Image[i], Title[i], Desc[i], Date[i]);
            beans.add(beanclass);

        }*/

        for ( int i = occurrences.size() - 1; i >= 0; i-- )
        {
            Occurrence oc = occurrences.get(i);

            OccurrenceListView occurrenceListView = new OccurrenceListView(oc.getImage(), oc.getDescription(), oc.getUser().toString(), oc.getDate().toString());
            beans.add(occurrenceListView);
        }

        listViewAdapter = new ListViewAdapter(MainActivity.this, beans);

        listview.setAdapter(listViewAdapter);

        font1 = Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/Montserrat-Bold.ttf");
        font2 = Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/Montserrat-Regular.ttf");

        TextView no1 = (TextView) findViewById(R.id.no1);
        no1.setTypeface(font1);
        TextView no2 = (TextView) findViewById(R.id.no2);
        no2.setTypeface(font1);
        TextView no3 = (TextView) findViewById(R.id.no3);
        no3.setTypeface(font1);


        TextView comment = (TextView) findViewById(R.id.comment);
        comment.setTypeface(font2);
        TextView channel = (TextView) findViewById(R.id.channel);
        channel.setTypeface(font2);
        TextView bookmark = (TextView) findViewById(R.id.bookmark);
        bookmark.setTypeface(font2);
        TextView name = (TextView) findViewById(R.id.name);
        name.setTypeface(font1);
        TextView photographer = (TextView) findViewById(R.id.photographer);
        photographer.setTypeface(font2);
    }


    @Override protected void onDestroy()
    {
        super.onDestroy();
    }

    public void sendToServer(JSONObject occurrenceJson) throws Exception
    {
        int TIMEOUT_MILLISEC = 10000;  // = 10 seconds
        HttpParams httpParams = new BasicHttpParams();
        httpParams.setParameter("occurrence", occurrenceJson);
        HttpClient client = new DefaultHttpClient(httpParams);

        HttpPost post = new HttpPost("http://192.168.43.37:8080/Server/Occurrence");
        post.setEntity(new ByteArrayEntity(occurrenceJson.toString().getBytes("UTF8")));
        client.execute(post);
    }

    public Occurrence pullOccurrenceDetails(Bitmap pic)
    {
        Intent detailsActivity = new Intent(this, PhotoDetailsActivity.class);

        Bundle inBundle = new Bundle();
        inBundle.putParcelable("image",pic);
        detailsActivity.putExtras(inBundle);

        startActivityForResult(detailsActivity,1);

        Bundle outBundle = detailsActivity.getExtras();

        User usuario = new User("Ludi", "02633466095", "ludi@gremio.com", "pass1234", 'A');
        Location location = new Location("-29.971155", "-51.19613");
        java.util.Date date = new Date(2016, 10, 3);

        Occurrence oc = new Occurrence(-1, usuario, location, "Vaca presa no poste, não sei como foi parar lá", date, pic, "URL", 'A');

        return oc;

    }
}
