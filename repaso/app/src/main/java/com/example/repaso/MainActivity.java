package com.example.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button sendbtn;
    EditText zenb1,zenb2;
    TextView emaitza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendbtn= findViewById(R.id.button);
        zenb1=findViewById(R.id.zenbtxt1);
        zenb2=findViewById(R.id.zenbtxt2);
        sendbtn.setOnClickListener(this);
        if(!getIntent().getStringExtra(("emaitza")).isEmpty())
        {
            emaitza.setText(getIntent().getStringExtra(("emaitza")));

        }


    }
    @Override
    public void onClick(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("lehen_zenbakia",zenb1.getText().toString());
        intent.putExtra("bigarren_zenbakia",zenb2.getText().toString());
        startActivity(intent);
    }

}