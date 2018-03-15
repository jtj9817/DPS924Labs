package com.example.josh.lab6.database;

import android.provider.BaseColumns;

/**
 * Created by Josh on 3/13/2018.
 */

public class StudentDbSchema {
    public static final class StudentTable{
        public static final String NAME = "students";

        public static final class Cols implements BaseColumns{
            public static final String TABLE_NAME  = "STUDENTS";
            public static final String STUDID = "Student ID";
            public static final String STUDNAME = "Student Name";
            public static final String GRADE = "Student Grade";

        }
    }
}
