package com.example.josh.lab6;

/**
 * Created by Josh on 3/14/2018.
 */

public class Student {


    public Student() {
    }

    public Student(String id, String name, String grade) {
        mStudID = id;
        mStudName = name;
        mStudGrade = grade;

    }

    public String getStudID() {
        return mStudID;
    }

    public void setStudID(String mStudID) {
        this.mStudID = mStudID;
    }

    public String getStudName() {
        return mStudName;
    }

    public void setStudName(String mStudName) {
        this.mStudName = mStudName;
    }

    public String getStudGrade() {
        return mStudGrade;
    }

    public void setmtudGrade(String mStudGrade) {
        this.mStudGrade = mStudGrade;
    }

    private String mStudID;
    private String mStudName;
    private String mStudGrade;


}
