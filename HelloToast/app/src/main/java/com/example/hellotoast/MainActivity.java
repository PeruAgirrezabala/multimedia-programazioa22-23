package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private int mCount=0;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Lehen beharrezkoa castinga egitea orain ez
    //mShowCount= (TextView)findViewById(R.id.show_count)
        mShowCount = findViewById(R.id.textView);
    }
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void countUp(View view){
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        }
    }
