package com.example.knuckleboxing_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import com.example.knuckleboxing_app.model.User;
import com.example.knuckleboxing_app.model.UserRepository;

public class LoginActivity extends AppCompatActivity implements Serializable {
    Button confirm_login_btn;
    TextView username_login_tv, password_login_tv;
    private UserRepository mRepository;
    private LiveData<List<User>> mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bariableakSortu();
        confirm_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logAction();
            }
        });
    }


    public void bariableakSortu() {
        confirm_login_btn = findViewById(R.id.confirm_login_btn);
        username_login_tv = findViewById(R.id.username_et);
        password_login_tv = findViewById(R.id.password_et);
    }


    public void logAction() {

        Intent to_content = new Intent(LoginActivity.this, ContentActivity.class);
        String login_user = username_login_tv.getText().toString();
        String login_password = password_login_tv.getText().toString();
        mRepository = new UserRepository(this);
        mUser = mRepository.getAllUsers();
        for (User user : mUser.getValue()) {
            if (user.usuario.equals(login_user) || user.contraseña.equals(login_password)) {
                startActivity(to_content);
            } else {
                Toast.makeText(this, "Errorea, Sartu datu egokiak mesedez", Toast.LENGTH_SHORT).show();
            }
        }


    }


}