package com.example.josh.lab6v2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Josh on 3/15/2018.
 */

@Entity
public class Student {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "STUDID")
    private String studentID;

    @ColumnInfo(name = "STUDNAME")
    private String studentName;

    @ColumnInfo(name = "STUDGRADE")
    private String studentGrade;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }
}
