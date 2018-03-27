package com.example.josh.lab6;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addStdntBttn = (Button) findViewById(R.id.addStdntBttn);
        Button deleteStudentBttn = (Button) findViewById(R.id.deleteStdntBttn);
        Button viewStudentsBttn = (Button) findViewById(R.id.viewStdntBttn);
        Button findStudentBttn = (Button) findViewById(R.id.findStdntBttn);
        final EditText studentID = (EditText) findViewById(R.id.studentIdField);
        final EditText studentName = (EditText) findViewById(R.id.studentNameField);
        final EditText studentGrade = (EditText) findViewById(R.id.studentGradeField);

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        //Setup Database


        final StudentBaseHelper studentDBHelper = new StudentBaseHelper(getApplicationContext());
        final SQLiteDatabase studentDBWritable = studentDBHelper.getWritableDatabase();
        final SQLiteDatabase studentDBReadable = studentDBHelper.getReadableDatabase();

        //Test data for database population
        /*
        ContentValues values = new ContentValues();
        values.put(StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTID, "001");
        values.put(StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTNAME, "John Doe");
        values.put(StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTGRADE,  99);
        long newrowid = studentDBWritable.insert(StudentDbSchema.StudentTable.Cols.TABLE_NAME, null, values);
        */
        final String[] projection = {
                StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTID,
                StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTNAME,
                StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTGRADE
        };


        addStdntBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuffer studentsNames = new StringBuffer();

                String stdntName = studentName.getText().toString();
                String stdntID = studentID.getText().toString();
                String stdntGrade = studentGrade.getText().toString();
                if(stdntGrade.isEmpty() || stdntGrade.equals("")){
                    stdntGrade = "0";
                }
                Integer convertStdntGrade = Integer.parseInt(stdntGrade.toString());

                builder.setTitle("The following students have been added");
                builder.setCancelable(true);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                //Insert user values into database
                ContentValues values = new ContentValues();
                if(convertStdntGrade != 0 && !stdntName.isEmpty() && stdntName != null)
                {
                    values.put(StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTID, stdntID);
                    values.put(StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTNAME, stdntName);
                    values.put(StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTGRADE,  stdntGrade);
                    long newrowid = studentDBWritable.insert(StudentDbSchema.StudentTable.Cols.TABLE_NAME,
                           null, values);
                }

               else{
                    values.put(StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTID, stdntID);
                    values.put(StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTNAME, stdntName);
                    values.put(StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTGRADE,  convertStdntGrade);
                    long newrowid = studentDBWritable.insert(StudentDbSchema.StudentTable.Cols.TABLE_NAME,
                          null, values);
               }

                Cursor cursorLatest = studentDBReadable.query(StudentDbSchema.StudentTable.Cols.TABLE_NAME, projection,null,
                        null,null,null,null);
                int stdntIDIndex = cursorLatest.getColumnIndex("studentID");
                int stdntNameIndex = cursorLatest.getColumnIndex("studentName");
                int stdntGradeIndex = cursorLatest.getColumnIndex("studentGrade");
                cursorLatest.moveToLast();
                studentsNames.append((("ID " + cursorLatest.getString(stdntIDIndex) + " ,Name: " + cursorLatest.getString(stdntNameIndex)
                            + " ,Grade: " + Integer.toString(cursorLatest.getInt(stdntGradeIndex)) + "\n")));
                builder.setMessage(studentsNames.toString());
                AlertDialog dialog = builder.create();
                dialog.show();
                cursorLatest.close();
                studentID.setText("");
                studentName.setText("");
                studentGrade.setText("");
            }
        });

        viewStudentsBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("List of Students added");
                builder.setCancelable(true);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                StringBuffer studentsNames = new StringBuffer();
                //Cursor to retrieve all the students in the database
                Cursor cursorAll = studentDBReadable.query(StudentDbSchema.StudentTable.Cols.TABLE_NAME, projection,null,
                        null,null,null,null);
                int stdntIDIndex = cursorAll.getColumnIndex("studentID");
                int stdntNameIndex = cursorAll.getColumnIndex("studentName");
                int stdntGradeIndex = cursorAll.getColumnIndex("studentGrade");

                while (cursorAll.moveToNext()){
                    studentsNames.append((("ID " + cursorAll.getString(stdntIDIndex) + " ,Name: " + cursorAll.getString(stdntNameIndex)
                            + " ,Grade: " + Integer.toString(cursorAll.getInt(stdntGradeIndex)) + "\n")));
                }
                builder.setMessage(studentsNames.toString());
                AlertDialog dialog = builder.create();
                dialog.show();
                builder.setMessage(null);
                cursorAll.close();
                studentID.setText("");
                studentName.setText("");
                studentGrade.setText("");
            }
        });

        deleteStudentBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer deletedStudent = new StringBuffer();
                final String stdntID = studentID.getText().toString();

                builder.setCancelable(true);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                //Selection query to delete where entries are LIKE the provided STUDENTID
                String selection = StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTID + " LIKE ?";
                String deletionArgs[] = { stdntID };

                //Cursor Operations
                Cursor cursorDeleted = studentDBReadable.query(StudentDbSchema.StudentTable.Cols.TABLE_NAME, projection,selection,
                        deletionArgs,null,null,null);
                int stdntIDIndex = cursorDeleted.getColumnIndex("studentID");
                int stdntNameIndex = cursorDeleted.getColumnIndex("studentName");
                int stdntGradeIndex = cursorDeleted.getColumnIndex("studentGrade");
                while (cursorDeleted.moveToNext()){
                    deletedStudent.append((("ID " + cursorDeleted.getString(stdntIDIndex) + " ,Name: " + cursorDeleted.getString(stdntNameIndex)
                            + " ,Grade: " + Integer.toString(cursorDeleted.getInt(stdntGradeIndex)) + "\n")));
                }

                if(cursorDeleted.getCount() == 0)
                {
                    builder.setTitle("This student does not exist");
                }
                else if(cursorDeleted.getCount() > 0){
                    builder.setTitle("The following student has been deleted");
                    builder.setMessage(deletedStudent.toString());
                }
                AlertDialog dialog = builder.create();
                dialog.show();
                cursorDeleted.close();
                //Finally, delete the entries
                int deletedRows = studentDBWritable.delete(StudentDbSchema.StudentTable.Cols.TABLE_NAME, selection, deletionArgs);
                studentID.setText("");
                studentName.setText("");
                studentGrade.setText("");
            }

        });

        findStudentBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer foundStudent = new StringBuffer();
                final String stdntID = studentID.getText().toString();

                builder.setCancelable(true);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                //Selection query to delete where entries are LIKE the provided STUDENTID
                String selection = StudentDbSchema.StudentTable.Cols.COLUMN_NAME_STUDENTID + " LIKE ?";
                String deletionArgs[] = { stdntID };

                //Cursor Operations
                Cursor cursorFound= studentDBReadable.query(StudentDbSchema.StudentTable.Cols.TABLE_NAME, projection,selection,
                        deletionArgs,null,null,null);
                int stdntIDIndex = cursorFound.getColumnIndex("studentID");
                int stdntNameIndex = cursorFound.getColumnIndex("studentName");
                int stdntGradeIndex = cursorFound.getColumnIndex("studentGrade");
                while (cursorFound.moveToNext()){
                    foundStudent.append((("ID " + cursorFound.getString(stdntIDIndex) + " ,Name: " + cursorFound.getString(stdntNameIndex)
                            + " ,Grade: " + Integer.toString(cursorFound.getInt(stdntGradeIndex)) + "\n")));
                }

                if(cursorFound.getCount() == 0)
                {
                    builder.setTitle("This student does not exist");
                }
                else if(cursorFound.getCount() > 0){
                    builder.setTitle("Student Details:");
                    builder.setMessage(foundStudent.toString());
                }
                AlertDialog dialog = builder.create();
                dialog.show();
                cursorFound.close();
                studentID.setText("");
                studentName.setText("");
                studentGrade.setText("");
            }
        });

    }

}
