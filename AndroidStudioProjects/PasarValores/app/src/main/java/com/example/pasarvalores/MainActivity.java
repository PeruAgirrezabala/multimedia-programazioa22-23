package com.example.pasarvalores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    TextView btn = (TextView) findViewById(R.id.button);

    btn.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            EditText zenb1 = findViewById(R.id.zenb1);
            EditText zenb2 = findViewById(R.id.zenb2);
            intent.putExtra("zenb1", (zenb1.getText().toString()));
            intent.putExtra("zenb2", (zenb1.getText().toString()));
            startActivity(intent);
        }


    });
}

}