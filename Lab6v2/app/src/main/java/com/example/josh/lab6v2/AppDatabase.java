package com.example.josh.lab6v2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Josh on 3/15/2018.
 */

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase INSTANCE;
    // public abstract StudentDao studentModel();
    public static AppDatabase getInMemoryDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public static void destroyInstance()
    {
        INSTANCE = null;
    }
    /*
    private static final AppDatabase ourInstance = new AppDatabase();

    public static AppDatabase getInstance() {
        return ourInstance;
    }

    private AppDatabase() {
    }*/
    public abstract StudentDao studentDao();

}
