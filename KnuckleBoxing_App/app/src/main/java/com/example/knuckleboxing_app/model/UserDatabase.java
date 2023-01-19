package com.example.knuckleboxing_app.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static final String DATABASE_NAME = "db_user";

    private static UserDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static UserDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(), UserDatabase.class,
                                    DATABASE_NAME).addCallback(mRoomCallback).build();
                }
            }
        }
        return INSTANCE;
    }
    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                UserDao dao = INSTANCE.userDao();

                User user1 = new User("proba","proba","otro",true);
                User user2 = new User("admin","admin", "otro",false);

                dao.insertUser(user1);
                dao.insertUser(user2);
            });
        }
    };
}
