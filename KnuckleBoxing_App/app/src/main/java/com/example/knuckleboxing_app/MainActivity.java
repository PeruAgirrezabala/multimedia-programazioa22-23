package com.example.knuckleboxing_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;

import model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginbtn = findViewById(R.id.login_btn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toLogin();
            }
        });
        Button signupbtn = findViewById(R.id.signup_btn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSignUp();
            }
        });


    }


    public void toLogin() {
        User user = (User) getIntent().getSerializableExtra("usuario1");
        if (getIntent().getSerializableExtra("usuario1") != null) {
            User user1 = (User) getIntent().getSerializableExtra("usuario1");
            Intent loginactivity = new Intent(MainActivity.this, LoginActivity.class);
            loginactivity.putExtra("usuario1", (Serializable) user);
            startActivity(loginactivity);
        } else {
            Toast.makeText(MainActivity.this, "bete erabiltzailea mesedez", Toast.LENGTH_SHORT).show();
        }
    }

    public void toSignUp() {
        Intent signupActivity = new Intent(MainActivity.this, SignupActivity.class);
        startActivity((signupActivity));
    }


}