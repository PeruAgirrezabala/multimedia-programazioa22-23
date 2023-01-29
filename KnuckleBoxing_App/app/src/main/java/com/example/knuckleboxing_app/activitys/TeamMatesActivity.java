package com.example.knuckleboxing_app.activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.knuckleboxing_app.R;
import com.example.knuckleboxing_app.model.DBTaskGetUserList;
import com.example.knuckleboxing_app.model.User;
import com.example.knuckleboxing_app.model.UserDatabase;
import com.example.knuckleboxing_app.model.UserListAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TeamMatesActivity extends AppCompatActivity {
    private UserListAdapter userListAdapter;
    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_mates);
        initRecyclerView();
        try {
            loadUserList();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        button_back=findViewById(R.id.button2);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_content = new Intent(TeamMatesActivity.this, ContentActivity.class);
                startActivity(to_content);
            }
        });



    }
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);
    }

    private void loadUserList() throws ExecutionException, InterruptedException {
        UserDatabase db = UserDatabase.getInstance(this.getApplicationContext());
        DBTaskGetUserList newTask = new DBTaskGetUserList(db.userDao());
        newTask.execute();
        List<User> userList = newTask.get(); // aqui se obtiene el resultado
        userListAdapter.setUserList(userList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            try {
                loadUserList();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}