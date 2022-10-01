package com.example.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
class Student {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "name")
    var name = ""

    @ColumnInfo(name = "email")
    var email = ""

    @ColumnInfo(name = "phone")
    var phone = ""


    constructor(id:Int,name:String,email:String,phone:String) {
        this.id = id
        this.name = name
        this.email = email
        this.phone = phone
    }
}