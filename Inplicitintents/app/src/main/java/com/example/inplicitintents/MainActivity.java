package com.example.inplicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

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
                intent.setAction(Intent.ACTION_SEND);
                // Always use string resources for UI text.
                // This says something like "Share this photo with"
                String title = getResources().getString(R.string.chooser_title);
                // Create intent to show the chooser dialog
                Intent chooser = Intent.createChooser(intent, title);

                // Verify the original intent will resolve to at least one activity
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
               // String url;
               // EditText editTexturl = (EditText) findViewById(R.id.editTexturl);
                //url=editTexturl.getText().toString();
               // intent.setData(Uri.parse(url));
                //startActivity(intent);



                break;
            case R.id.txtbtn:

                //String txt;
                //EditText editText = (EditText) findViewById(R.id.editText);
                //txt=editText.getText().toString();
                //String minetype="text/plain";
                //new ShareCompat.IntentBuilder(this)
                  //      .setType(minetype)
                    //            .setChooserTitle("share this text with: ")
                      //                  .setText(txt)
                        //                        .startChooser();
                //intent.setData(Uri.parse(txt));
                //startActivity(intent);
                //break;
                intent.setAction(Intent.ACTION_SEND);
                EditText editText = (EditText)findViewById(R.id.editText);
                String txt=editText.getText().toString();
                intent.putExtra(Intent.EXTRA_TEXT,txt);
                intent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(intent,null);
                        startActivity(shareIntent);
                break;
        }

    }
}