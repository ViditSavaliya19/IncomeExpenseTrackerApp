package com.example.meettotapp.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.meettotapp.R
import com.example.meettotapp.room.DatabaseRoom.Companion.getDB

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        var btnInsertData=findViewById<Button>(R.id.btnInsertData)
        var db =getDB(this)
        btnInsertData.setOnClickListener {
            var studentModel =StudentModel(0,"Hello","123456","Surat")
            db.dao().insertData(studentModel)
        }
    }
}