package com.example.knuckleboxing_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import model.User;

public class LoginActivity extends AppCompatActivity implements Serializable {
    Button confirm_login_btn;
    TextView username_login_tv, password_login_tv;

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

    //Aldagaiei balioak eman
    public void bariableakSortu() {
        confirm_login_btn = findViewById(R.id.confirm_login_btn);
        username_login_tv = findViewById(R.id.username_et);
        password_login_tv = findViewById(R.id.password_et);
    }
    //botoia sakatzean kontua ea sortuta dagoen egiaztatu


    public void logAction() {
        User user1 = (User) getIntent().getSerializableExtra("usuario1");
        String account_user = user1.usuario;
        String account_password = user1.contraseña;
        Intent intent = new Intent(LoginActivity.this, ContentActivity.class);
        String login_user = username_login_tv.getText().toString();
        String login_password = password_login_tv.getText().toString();
        if (account_user.contentEquals(login_user) && account_password.contentEquals(login_password)) {
            intent.putExtra("usuario1", (Serializable) user1);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "egiaztatu datuak ondo sartu dituzula", Toast.LENGTH_LONG).show();
        }
    }


}