package com.example.josh.lab6;

import android.provider.BaseColumns;

/**
 * Created by Josh on 3/13/2018.
 */

public class StudentDbSchema {
    public static final class StudentTable{

        public static final class Cols implements BaseColumns{
            public static final String TABLE_NAME = "students";
            public static final String  COLUMN_NAME_STUDENTID= "studentID";
            public static final String COLUMN_NAME_STUDENTNAME = "studentName";
            public static final String COLUMN_NAME_STUDENTGRADE = "studentGrade";

        }
    }
}