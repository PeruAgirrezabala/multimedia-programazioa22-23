package com.example.a2acttivitiestalk;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void launchSecondActivity(){
        Log.d(LOG_TAG,"Button clicked!");

        String message=mMessageEditText.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra( EXTRA_MESSAGGE, message);

        startForResult.launch(intent);

    }
    ActivityResultLauncher startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result!=null && result.getResultCode()==RESULT_OK)
                if (result.getData()!=null && result.getData().getStringExtra(SecondActivity.EXTRA_REPLY)!=null){
                    String reply= result.getData().getStringExtra(SecondActivity.EXTRA_REPLY);
                    mReplyheadTextView.setVisibility(view.VISIBLE);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(view.Visible);
                }
            if(result!=null && result.getResultCode()==RESULT_CANCELED){
                Log.d(LOG_TAG,"Bigarren Activitya Cancelled")
            }
        }
    })
}