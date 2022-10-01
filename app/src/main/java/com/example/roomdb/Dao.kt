package com.example.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {

    @Insert
    fun insertData(std : Student)

    @Delete
    fun deleteData(std: Student)

    @Query("SELECT * From student")
    fun readData() : List<Student>

}