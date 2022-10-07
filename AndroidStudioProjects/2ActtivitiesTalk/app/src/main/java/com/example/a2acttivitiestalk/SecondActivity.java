package com.example.a2acttivitiestalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "Ccom.example";
    private String mReply;
    private Button btn_reply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Informazioa jaso eta bistaratu
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        mReply = findViewById(R.id.editText_second);
        btn_reply = findViewById(R.id.button_second);
        btn_reply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                returnReply(v);
            }
        });

    }
    public void returnReply(View view){
        //erantzuna bidali bueltan
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}