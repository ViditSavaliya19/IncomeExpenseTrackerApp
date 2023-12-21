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
        var btnUpdateData=findViewById<Button>(R.id.btnUpdateData)
        var btnDeleteData=findViewById<Button>(R.id.btnDeleteData)


        var db =getDB(this)
        btnInsertData.setOnClickListener {
            var studentModel =StudentModel(0,"Hello","123456","Surat")
            db.dao().insertData(studentModel)
        }

        btnUpdateData.setOnClickListener {

            var model = StudentModel(1,"Ayush","70455215","Vapi")
            db.dao().updateData(model)
        }

        btnDeleteData.setOnClickListener {

            var model = StudentModel(1,"hello","70455215","vapi")
            db.dao().deleteData(model)
        }
    }
}