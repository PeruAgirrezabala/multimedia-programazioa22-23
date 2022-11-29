package com.example.kalkulagalua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    float emaitza;
    public static final String EXTRA_REPLY = "Emaitza";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button zati = findViewById(R.id.btnZati);
        Button bider = findViewById(R.id.btnBider);
        Button gehi = findViewById(R.id.btnGehi);
        Button ken = findViewById(R.id.btnKen);

        //eragiketa 0 = bider
        bider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eragiketa(0);
                returnReply();
            }
        });
        //eragiketa 1 = zati
        zati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eragiketa(1);
                returnReply();
            }

        });

        ken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eragiketa(2);
                returnReply();
            }

        });

        gehi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eragiketa(3);
                returnReply();
            }
        });
    }

    private void eragiketa(int i) {

        Intent intent = getIntent();
        String zenbakia1 = intent.getStringExtra(MainActivity.EXTRA_ZBK1);
        String zenbakia2 = intent.getStringExtra(MainActivity.EXTRA_ZBK2);

        switch(i)
        {
            case 0: emaitza = Integer.parseInt(zenbakia1) * Integer.parseInt(zenbakia2);
                break;
            case 1:emaitza = Float.valueOf(zenbakia1) / Float.valueOf(zenbakia2);
                break;
            case 2:emaitza = Integer.parseInt(zenbakia1) - Integer.parseInt(zenbakia2);
                break;
            case 3:emaitza = Integer.parseInt(zenbakia1) + Integer.parseInt(zenbakia2);
                break;
        }

    }
    public void returnReply(){
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,String.valueOf(emaitza));
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}