package com.example.josh.lab6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class StudentBaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "studentBase.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StudentDbSchema.StudentTable.Cols.TABLE_NAME + " (" +
                    StudentDbSchema.StudentTable.Cols._ID + " INTEGER PRIMARY KEY," +
                    StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTID + " TEXT," +
                    StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTNAME + " TEXT," +
                    StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTGRADE + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + StudentDbSchema.StudentTable.Cols.TABLE_NAME;


    public StudentBaseHelper(Context context) {
        super(context, DATABASE_NAME, null  , VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}