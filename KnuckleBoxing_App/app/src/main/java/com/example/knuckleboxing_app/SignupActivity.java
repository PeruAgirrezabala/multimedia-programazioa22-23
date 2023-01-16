package com.example.knuckleboxing_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import com.example.knuckleboxing_app.model.User;
import com.example.knuckleboxing_app.model.UserRepository;

public class SignupActivity extends AppCompatActivity implements Serializable {
    Button crear_btn;
    TextView usuario_tv, contraseña_tv;
    RadioButton male_btn, female_btn, other_btn;
    CheckBox experience_cb;
    RadioGroup sexo_rg;
    public int male_rb_id, female_rb_id, other_rb_id;

    private  UserRepository mRepository;

    private  List<User> mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        variableakSortu();
        int target_id = sexo_rg.getCheckedRadioButtonId();
        crear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singUpAction();
            }
        });


    }


    public void singUpAction() {
        if (danaBeteta() == true) {
            boolean exist = false;
            String username = usuario_tv.getText().toString();
            String password = contraseña_tv.getText().toString();
            int target_id = sexo_rg.getCheckedRadioButtonId();
            RadioButton target_rb = findViewById(target_id);
            String gender = target_rb.getText().toString();
            Boolean experiencia = experience_cb.isChecked();
            User user = new User(username, password, gender, experiencia);
            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            //intent.putExtra("usuario1", (Serializable) user);
            //startActivity(intent);
            mRepository = new UserRepository(this);
            mUser= mRepository.getAllUsers();
            for (User loopUser : mUser) {
                if(loopUser.equals(user)){
                    exist=true;
                }
            }
            insertAction(user,exist);
            startActivity(intent);


        }
    }
    public void insertAction (User user,boolean exist){
        mRepository = new UserRepository(this);
        mUser= mRepository.getAllUsers();
        if(exist = true){
            mRepository.insert(user);
        }else{
            Toast.makeText(this, "jada erabiltzailea existitzen da", Toast.LENGTH_SHORT).show();
        }
    }



    public void variableakSortu() {
        crear_btn = findViewById(R.id.signup_crearcuenta_btn);
        usuario_tv = findViewById(R.id.signup_user_ed);
        contraseña_tv = findViewById(R.id.signup_password_ed);
        sexo_rg = findViewById(R.id.signup_genre_rg);
        male_btn = findViewById(R.id.signup_male_rb);
        female_btn = findViewById(R.id.signup_female_rb);
        other_btn = findViewById(R.id.signup_other_rb);
        experience_cb = findViewById(R.id.checkBox);
        male_rb_id = male_btn.getId();
        female_rb_id = female_btn.getId();
        other_rb_id = other_btn.getId();
    }

    //kontua sortu aurretik ea datu guztiak dauden egiaztatu
    public boolean danaBeteta() {
        boolean beteta = true;
        if (usuario_tv.getText() == null) {
            beteta = false;
            Toast.makeText(this, "bete erabiltzailea mesedez", Toast.LENGTH_SHORT).show();
        }
        if (contraseña_tv.getText() == null) {
            beteta = false;
            Toast.makeText(this, "bete pasahitza mesedez", Toast.LENGTH_SHORT).show();
        }
        if (sexo_rg.getCheckedRadioButtonId() == -1) {
            beteta = false;
            Toast.makeText(this, "sexua aukeratu", Toast.LENGTH_SHORT).show();

        }
        return beteta;

    }


}