package com.example.knuckleboxing_app.model;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private LiveData<List<User>> readAllData;
    private UserRepository repository;

    public UserViewModel(Application application){
        super(application);
        UserDao userdao = UserDatabase.getInstance(getApplication()).userDao();
        repository = new UserRepository((Context) userdao);
        readAllData = repository.getAllUsers();
    }
}
