package com.example.knuckleboxing_app.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.knuckleboxing_app.R;
import com.example.knuckleboxing_app.model.DBTaskGetUserList;
import com.example.knuckleboxing_app.model.User;
import com.example.knuckleboxing_app.model.UserDatabase;

public class MainActivity extends AppCompatActivity {

    private LiveData<List<User>> mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button loginbtn = findViewById(R.id.login_btn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    toLogin();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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


    public void toLogin() throws ExecutionException, InterruptedException {

        UserDatabase db = UserDatabase.getInstance(getApplicationContext());
        DBTaskGetUserList task = new DBTaskGetUserList(db.userDao());
        task.execute();
        List<User> userList = task.get(); // aqui se obtiene el resultado
        Intent toLogin = new Intent(MainActivity.this, LoginActivity.class);
        if (userList != null) {
            startActivity(toLogin);

        } else {
            Toast.makeText(this, "Momentu honetan ez dago konturik sortuta", Toast.LENGTH_SHORT).show();
        }
    }

    public void toSignUp() {
        Intent signupActivity = new Intent(MainActivity.this, SignupActivity.class);
        startActivity((signupActivity));
    }


}