package com.example.josh.lab6v2;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private AppDatabase studentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* AppDatabase studentdb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();*/
       studentDB = AppDatabase.getInMemoryDatabase(getApplicationContext());
       populateDb();
    }

    private static Student addStudent(final AppDatabase db, Student student)
    {
        db.studentDao().insertStudent(student);
        return student;
    }
    private void populateDb(){
        Student student1 = new Student();
        student1.setStudentID("001");
        student1.setStudentName("John Doe");
        student1.setStudentGrade("98");
        addStudent(studentDB, student1);
    }
}
