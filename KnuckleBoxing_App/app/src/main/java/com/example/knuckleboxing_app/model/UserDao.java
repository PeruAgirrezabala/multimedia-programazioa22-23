package com.example.knuckleboxing_app.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {


    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);




}