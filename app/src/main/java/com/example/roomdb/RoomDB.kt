package com.example.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Student::class], version = 1)
abstract class RoomDB : RoomDatabase() {

    abstract fun studentDao(): Dao

    companion object {

        fun createRoomDB(context: Context): RoomDB {

            return Room.databaseBuilder(context.applicationContext, RoomDB::class.java, "MyDB")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }

    }

}