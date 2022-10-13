package com.example.inplicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button locbtn, urlbtn, txtbtn;
    private final static String WEBSITE_URL ="";
    private final static String LOCATION_URL ="https://www.google.es/maps/place/";
    private final static String TEXT_URL ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        locbtn = findViewById(R.id.locbtn);
        urlbtn = findViewById(R.id.urlbtn);
        txtbtn = findViewById(R.id.txtbtn);


        locbtn.setOnClickListener(this);
        urlbtn.setOnClickListener(this);
        txtbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        switch(view.getId()){
            case R.id.locbtn:
                String location="";
                EditText editTextLoc=(EditText) findViewById((R.id.editTextLoc));
                location = editTextLoc.getText().toString();
                location = LOCATION_URL + location;
                intent.setData(Uri.parse(location));
                startActivity(intent);

                break;
            case R.id.urlbtn:
                String url;
                EditText editTexturl = (EditText) findViewById(R.id.editTextLoc);
                url=editTexturl.getText().toString();
                intent.setData(Uri.parse(url));
                startActivity(intent);



                break;
            case R.id.txtbtn:

                break;
        }

    }
}