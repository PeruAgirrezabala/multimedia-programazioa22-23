package com.example.knuckleboxing_app.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private final List<User> mUsersList;
    private final UserDao mUserDao;


    public UserRepository(Context context) {
        UserDatabase db = UserDatabase.getInstance(context);
        mUserDao = db.userDao();
        mUsersList = (List<User>) mUserDao.getAll();
    }

    public List<User> getAllUsers() {
        return mUsersList;
    }

    public void insert(User user) {
        UserDatabase.dbExecutor.execute(
                () -> mUserDao.insert(user)
        );
    }
}
