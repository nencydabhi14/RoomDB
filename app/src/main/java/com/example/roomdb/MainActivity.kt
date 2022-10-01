package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        var roomDB = RoomDB.createRoomDB(this)

        mainBinding.txt.setOnClickListener {

            var std1 = Student(0,"Android","abc@gmail.com","1234567891")
            roomDB.studentDao().insertData(std1)
        }
    }
}