package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.radioButton);
        btn2=findViewById(R.id.radioButton2);
        btn3=findViewById(R.id.radioButton3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.radioButton:
                Toast bat=Toast.makeText(this,"Peru",Toast.LENGTH_LONG);
                bat.show();
                break;
            case R.id.radioButton2:
                Toast bi=Toast.makeText(this,"Markel",Toast.LENGTH_LONG);
                bi.show();
                break;
            case R.id.radioButton3:
                Toast hiru=Toast.makeText(this,"Haritz",Toast.LENGTH_LONG);
                hiru.show();
                break;

        }
    }
}