package com.example.pasarvalores;

import static java.lang.Short.valueOf;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    int z1,z2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        recibirDatos();
        int resultado = z1+z2;
        TextView resulttext= (TextView)findViewById(R.id.textView);
        resulttext.setText(resultado);
    }
    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        int z1 = valueOf(extras.getString("zenb1"));
        int z2 = valueOf(extras.getString("zenb2"));


    }
}
