package com.example.knuckleboxing_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.io.Serializable;
import java.util.List;

import com.example.knuckleboxing_app.model.User;
import com.example.knuckleboxing_app.model.UserRepository;

public class MainActivity extends AppCompatActivity {
    private UserRepository mRepository;
    private LiveData<List<User>> mUser;

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

        mRepository = new UserRepository(getApplicationContext());
        mUser = mRepository.getAllUsers();
        Intent toLogin = new Intent(MainActivity.this, LoginActivity.class);
        if (mUser != null) {
            startActivity(toLogin);

        } else {
            Toast.makeText(this, "Lehenik eta behin kontua sortu behar duzu", Toast.LENGTH_SHORT).show();
        }
    }

    public void toSignUp() {
        Intent signupActivity = new Intent(MainActivity.this, SignupActivity.class);
        startActivity((signupActivity));
    }


}