package com.example.knuckleboxing_app.activitys;

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
import java.util.concurrent.ExecutionException;

import com.example.knuckleboxing_app.R;
import com.example.knuckleboxing_app.model.DBTaskAddUser;
import com.example.knuckleboxing_app.model.DBTaskGetUserList;
import com.example.knuckleboxing_app.model.User;
import com.example.knuckleboxing_app.model.UserDao;
import com.example.knuckleboxing_app.model.UserDatabase;

public class SignupActivity extends AppCompatActivity implements Serializable {
    Button crear_btn;
    TextView usuario_tv, contraseña_tv;
    RadioButton male_btn, female_btn, other_btn;
    CheckBox experience_cb;
    RadioGroup sexo_rg;
    public int male_rb_id, female_rb_id, other_rb_id;

    private LiveData<List<User>> mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        variableakSortu();
        int target_id = sexo_rg.getCheckedRadioButtonId();
        crear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    singUpAction();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }


    public void singUpAction() throws ExecutionException, InterruptedException {
        if (danaBeteta()) {
            boolean exist = false;
            String username = usuario_tv.getText().toString();
            String password = contraseña_tv.getText().toString();
            int target_id = sexo_rg.getCheckedRadioButtonId();
            RadioButton target_rb = findViewById(target_id);
            String gender = target_rb.getText().toString();
            Boolean experiencia = experience_cb.isChecked();
            User user = new User(username, password, gender, experiencia);
            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            UserDatabase db = UserDatabase.getInstance(getApplicationContext());
            DBTaskGetUserList task = new DBTaskGetUserList(db.userDao());
            task.execute();
            List<User> userList = task.get(); // aqui se obtiene el resultado
            for (User loopUser : userList) {
                if (loopUser.equals(user)) {
                    exist = true;
                }
            }
            insertAction(user, exist);
            startActivity(intent);


        }
    }

    public void insertAction(User user, boolean exist) {
        UserDatabase db = UserDatabase.getInstance(this.getApplicationContext());
        if (exist != true) {
           DBTaskAddUser dbTaskAddUser= new DBTaskAddUser(db.userDao(),user);
           dbTaskAddUser.execute();
        } else {
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