package com.pranav.caprimul.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pranav.caprimul.models.CarsEntity;

@Database(entities = CarsEntity.class,version = 1, exportSchema = false)
public abstract class RoomDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "database";
    private static RoomDataBase database;

    public synchronized static RoomDataBase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDataBase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract CarsDao mainDao();
}
