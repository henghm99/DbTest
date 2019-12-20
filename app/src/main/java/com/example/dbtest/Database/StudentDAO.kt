package com.example.dbtest.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Query("SELECT * FROM student")
    fun getAll(): List<Student>

    @Insert
    fun insert(vararg s : Student)

}