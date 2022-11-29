package com.example.kalkulagalua;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText zenb1,zenb2;
    private Button hurrengoa;
    TextView emaitza;

    public static final String EXTRA_ZBK1 = "zbk1";
    public static final String EXTRA_ZBK2 = "zbk2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zenb1 = findViewById(R.id.txt1zbk);
        zenb2 =  findViewById(R.id.txt2zbk);
        hurrengoa = findViewById(R.id.btnJarraitu);
        emaitza = findViewById(R.id.emaitza);
        hurrengoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hurrengoa();
            }
        });
    }

    private void hurrengoa() {
        String zbk1 = String.valueOf(zenb1.getText());
        String zbk2 = String.valueOf(zenb2.getText());
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_ZBK1, zbk1);
        intent.putExtra(EXTRA_ZBK2, zbk2);
        activityResultLauncher.launch(intent);
    }

    ActivityResultLauncher<Intent> activityResultLauncher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                // There are no request codes
                Intent data = result.getData();
                String str = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                emaitza.setText(str);
            }
        }
    });
    }
