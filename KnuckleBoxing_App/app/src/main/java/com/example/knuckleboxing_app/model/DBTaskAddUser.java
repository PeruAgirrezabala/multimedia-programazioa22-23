package com.example.knuckleboxing_app.model;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;
//This class is an AsyncTask that performs an insertion of a User object into the database
 public class DBTaskAddUser extends AsyncTask<Void, Void, User >{
    private UserDao userDao;
    private User user;

    public DBTaskAddUser(UserDao userDao,User user) {
        this.userDao = userDao;
        this.user = user;
    }
    //The doInBackground method inserts the User object into the database and returns it
    @Override
    protected User doInBackground(Void ...params) {
        // Perform database operation in the background
        userDao.insertUser(user);
        return user;

    }
    //onPostExecute method is not currently performing any action
    @Override
    protected void onPostExecute(User user) {
        // Update the UI with the results on the main thread
    }
}
