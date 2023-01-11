package com.example.knuckleboxing_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

import model.User;

public class ContentActivity extends AppCompatActivity implements Serializable {
    Button map_btn, logOut_btn;
    TextView primer_entrenamiento_tv, segundo_entrenamiento_tv;
    User user1;
    private final static String LOCATION = "https://www.google.com/maps/search/?api=1&query=Smithfield+Boxing+Club";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        bariableakSortu();
        //experientziaren arabera entrenamendu ezberdina esleitu
        if (user1.experiencia) {
            primer_entrenamiento_tv.setText(R.string.lunes);
            segundo_entrenamiento_tv.setText(R.string.miercoles);

        } else {
            primer_entrenamiento_tv.setText(R.string.martes);
            segundo_entrenamiento_tv.setText(R.string.jueves);
        }
        logOut_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOutAction();
            }
        });
        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapara();
            }
        });

    }

    //botoia sakatzean mapara eramateko
    public void mapara() {

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(LOCATION));
        startActivity(intent);
    }

    //kontutik ateratzeko eta hasirara bueltatzeko

    public void logOutAction() {
        Intent intent = new Intent(ContentActivity.this, MainActivity.class);
        intent.putExtra("usuario1", user1);
        startActivity(intent);
    }


    //aldagaiei balioak eman
    public void bariableakSortu() {
        map_btn = findViewById(R.id.map_btn);
        logOut_btn = findViewById((R.id.logOut_btn));
        primer_entrenamiento_tv = findViewById(R.id.training_tv);
        segundo_entrenamiento_tv = findViewById(R.id.training2_tv);
        user1 = (User) getIntent().getSerializableExtra("usuario1");

    }
}