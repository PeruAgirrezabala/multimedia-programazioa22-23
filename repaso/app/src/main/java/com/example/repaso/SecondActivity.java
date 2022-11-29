package com.example.repaso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

    public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
        Button bueltatubtn;
        int zenb1,zenb2,emaitza;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.second_activity);

            bueltatubtn=findViewById(R.id.button2);
            bueltatubtn.setOnClickListener(this);

        }
        public void onClick(View view){
            Intent intent2 = new Intent(this,MainActivity.class);
            String a=getIntent().getStringExtra("lehen_zenbakia");
            zenb1=Integer.parseInt(a);
            String b =getIntent().getStringExtra("bigarren_zenbakia");
            zenb2=Integer.parseInt(b);
            emaitza=zenb1+zenb2;
            intent2.putExtra("emaitza",emaitza);
            startActivity(intent2);

        }
}
