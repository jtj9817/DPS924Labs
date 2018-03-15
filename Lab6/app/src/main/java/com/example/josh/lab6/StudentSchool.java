package com.example.josh.lab6;

/**
 * Created by Josh on 3/14/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.josh.lab6.database.StudentBaseHelper;
import com.example.josh.lab6.database.StudentDbSchema;

import java.util.ArrayList;
import java.util.List;


/* Creates the database for the students */

public class StudentSchool {
    private static StudentSchool mStudentSchool;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    private StudentSchool(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new StudentBaseHelper(mContext).getWritableDatabase();
    }

    public void addStudent(Student student){
        ContentValues values = getContentValues(student);
        mDatabase.insert(StudentDbSchema.StudentTable.NAME,null, values );
    }

    public List<Student> getStudents(){
        return new ArrayList<>();
    }

    public Student getStudent(String id){
        return null;
    }

    private static ContentValues getContentValues(Student student){
        ContentValues values = new ContentValues();
        values.put(StudentDbSchema.StudentTable.Cols.STUDID, student.getStudID());
        values.put(StudentDbSchema.StudentTable.Cols.STUDNAME, student.getStudName());
        values.put(StudentDbSchema.StudentTable.Cols.GRADE, student.getStudGrade());

        return values;
    }
}
