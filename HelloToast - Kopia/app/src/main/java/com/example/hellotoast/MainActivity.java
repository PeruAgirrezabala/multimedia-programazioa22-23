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
        public void showZero(View view){
            mCount=0;
            mShowCount.setText(Integer.toString(mCount));
        }
        @Override
        public void onStart(){

           Toast toast= Toast.makeText(this,"onStart()",Toast.LENGTH_LONG);
            toast.show();


            super.onStart();

        }
        @Override
        public void onResume(){
            Toast toast = Toast.makeText(this,"onResume()",Toast.LENGTH_LONG);
            toast.show();

            super.onResume();
        }
        @Override
        public void onStop(){
            Toast toast = Toast.makeText(this,"onStop()",Toast.LENGTH_LONG);
            toast.show();

            super.onStop();

        }
        @Override
        public void onRestart(){
            Toast toast = Toast.makeText(this,"onRestart()",Toast.LENGTH_LONG);
            toast.show();

            super.onRestart();

        }
        @Override
        public void onDestroy(){
            Toast toast = Toast.makeText(this, "onDestroy()",Toast.LENGTH_LONG);
            toast.show();

            super.onDestroy();

        }
        @Override
        public void onPause(){
            Toast toast = Toast.makeText(this,"onPause()",Toast.LENGTH_LONG);
            toast.show();

            super.onPause();

        }

    }
