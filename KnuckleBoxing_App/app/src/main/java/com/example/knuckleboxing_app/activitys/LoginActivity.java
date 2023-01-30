package com.example.knuckleboxing_app.activitys;

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
import java.util.concurrent.ExecutionException;

import com.example.knuckleboxing_app.R;
import com.example.knuckleboxing_app.model.DBTaskGetUserList;
import com.example.knuckleboxing_app.model.User;
import com.example.knuckleboxing_app.model.UserDatabase;
//The code is an implementation of a login activity in an Android app. It defines a LoginActivity class that extends AppCompatActivity and contains methods to handle a user's login process.
public class LoginActivity extends AppCompatActivity  {
    Button confirm_login_btn;
    TextView username_login_tv, password_login_tv;
    private LiveData<List<User>> mUser;
    private List<User> mListUser;

    //The code initializes UI components in onCreate method and sets a click listener for the login button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bariableakSortu();
        confirm_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    logAction();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void bariableakSortu() {
        confirm_login_btn = findViewById(R.id.confirm_login_btn);
        username_login_tv = findViewById(R.id.username_et);
        password_login_tv = findViewById(R.id.password_et);
    }

    //The listener calls the logAction method, which retrieves user input from the username and password text views and queries the user database for a matching user
    public void logAction() throws ExecutionException, InterruptedException {

        Intent to_content = new Intent(LoginActivity.this, ContentActivity.class);
        String login_user = username_login_tv.getText().toString();
        String login_password = password_login_tv.getText().toString();
        UserDatabase db = UserDatabase.getInstance(getApplicationContext());
        DBTaskGetUserList task = new DBTaskGetUserList(db.userDao());
        task.execute();
        List<User> userList = task.get(); // aqui se obtiene el resultado
        boolean login=false;

            for (User user : userList) {
                if (user.usuario.equals(login_user) || user.contraseña.equals(login_password)) {
                    login= true;
                    to_content.putExtra("usuarioLogeado", (Serializable) user);
                    startActivity(to_content);
                }

                }
                if(login == false) {
                    Toast.makeText(this, "Errorea, Sartu datu egokiak mesedez", Toast.LENGTH_SHORT).show();
                }
            }



    }


