package com.example.sqlroom;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
@Database(entities = {Personne.class}, version =1, exportSchema = false )
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase appDatabase;
    public static String DATABASE_NAME="personneDB";

    public synchronized static AppDatabase getInstance(Context context){
        if(appDatabase==null){
            appDatabase= Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return appDatabase;
    }
    public abstract PersonneDao personneDao();

}
