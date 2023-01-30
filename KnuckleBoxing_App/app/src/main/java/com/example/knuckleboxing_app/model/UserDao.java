package com.example.knuckleboxing_app.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


//This Java code defines a DAO (Data Access Object) interface for accessing the User data stored in the SQLite database

// The DAO uses Room annotations to define methods for inserting, querying, and deleting User objects
@Dao
public interface UserDao {

    //The insertUser method is used to insert one or more User objects into the database
    @Insert
    void insertUser(User... users);
    //The getAllUsers method is used to retrieve a list of all User objects from the database
    @Query("SELECT * FROM user")
    List<User> getAllUsers();


    //The delete method is used to delete a single User object from the database.
    @Delete
    void delete(User user);




}