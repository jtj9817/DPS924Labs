package com.example.josh.lab6.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Josh on 3/13/2018.
 */

import com.example.josh.lab6.database.StudentDbSchema.StudentTable;

public class StudentBaseHelper extends SQLiteOpenHelper{
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "studentBase.db";
    public StudentBaseHelper(Context context) {
        super(context, DATABASE_NAME, null  , VERSION);
    }
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StudentTable.Cols.TABLE_NAME + " (" +
                    StudentTable.Cols._ID + " INTEGER PRIMARY KEY," +
                    StudentTable.Cols.STUDID + " TEXT," +
                    StudentTable.Cols.STUDNAME + " TEXT," +
                    StudentTable.Cols.GRADE + " TEXT)";



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + StudentTable.NAME + " ("
                + " _id INTEGER PRIMARY KEY, " +
                StudentTable.Cols.STUDID + ", " +
                StudentTable.Cols.GRADE + ", " +
                StudentTable.Cols.STUDNAME + ")");
        /* db.execSQL(SQL_CREATE_ENTRIES); */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
