package com.example.zenbakiabidali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edit1;
    private TextView txtHasierakoZenbakia;
    private TextView txtBueltatutakoZenbakia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{


        int zenbakiBerria = Integer.parseInt(getIntent().getStringExtra("zenbakiBerria")); //SecondActivity-an sartutako zenbakia
        int hasierakoZenbakia = Integer.parseInt(getIntent().getStringExtra("hasierakoZenbakia")); //MainActivity-an sartutako zenbakia

        txtHasierakoZenbakia = (TextView) findViewById(R.id.txtHasierakoZenbakia);
        txtHasierakoZenbakia.setText(hasierakoZenbakia);

        txtBueltatutakoZenbakia = (TextView) findViewById(R.id.txtBueltatutakoZenbakia);
        zenbakiBerria += hasierakoZenbakia;
        txtBueltatutakoZenbakia.setText(zenbakiBerria);
    } catch (Exception e){

        }

        edit1 = (EditText)findViewById(R.id.edit1);
    }

    public void Bidali(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("zenbakia", edit1.getText().toString());
        startActivity(intent);
    }
}