package com.example.josh.lab6v2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Josh on 3/15/2018.
 */

@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    List<Student>  getAll();

    @Query("SELECT * FROM student WHERE uid IN (:userIds)")
    List<Student> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM student WHERE STUDID LIKE :studid")
    Student findByID(String studid);

    @Insert(onConflict = REPLACE)
    void insertStudent(Student ... students);

    @Delete
    void delete(Student student);

}
