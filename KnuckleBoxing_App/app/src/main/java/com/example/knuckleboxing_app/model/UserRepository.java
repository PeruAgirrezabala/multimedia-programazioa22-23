package com.example.knuckleboxing_app.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository implements UserDao {
    private final LiveData<List<User>> mUsersList;
    private final UserDao mUserDao;


    public UserRepository(Context context) {
        UserDatabase db = UserDatabase.getInstance(context);
        mUserDao = db.userDao();
        mUsersList =  mUserDao.getAll();
    }

    public LiveData<List<User>> getAll() {
        return mUsersList;
    }

    public void insert(User user) {
        UserDatabase.dbExecutor.execute(
                () -> mUserDao.insert(user)
        );
    }
}
