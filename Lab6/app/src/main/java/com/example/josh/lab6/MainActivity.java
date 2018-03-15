package com.example.josh.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.josh.lab6.database.StudentBaseHelper;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentBaseHelper mStudDB = new StudentBaseHelper(getApplicationContext());
    }
}
