package com.example.knuckleboxing_app.model;

import android.os.AsyncTask;

import java.util.List;
//extends the AsyncTask class and performs the database operation of getting all users from the userDao in the background thread.
public class DBTaskGetUserList extends AsyncTask<Void, Void, List<User>> {
    private UserDao userDao;

    public DBTaskGetUserList(UserDao userDao) {
        this.userDao = userDao;
    }

    //The results are then returned
    @Override
    protected List<User> doInBackground(Void... voids) {
        // Perform database operation in the background
        return userDao.getAllUsers();
    }
    //method to update the UI on the main thread.
    @Override
    protected void onPostExecute(List<User> users) {
        // Update the UI with the results on the main thread
        super.onPostExecute(users);
    }
}
