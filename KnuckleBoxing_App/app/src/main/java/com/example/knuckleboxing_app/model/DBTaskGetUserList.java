package com.example.knuckleboxing_app.model;

import android.os.AsyncTask;

import java.util.List;

public class DBTaskGetUserList extends AsyncTask<Void, Void, List<User>> {
    private UserDao userDao;

    public DBTaskGetUserList(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected List<User> doInBackground(Void... voids) {
        // Perform database operation in the background
        return userDao.getAllUsers();
    }

    @Override
    protected void onPostExecute(List<User> users) {
        // Update the UI with the results on the main thread
        super.onPostExecute(users);
    }
}
