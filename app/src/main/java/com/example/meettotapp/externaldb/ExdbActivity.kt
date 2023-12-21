package com.example.meettotapp.externaldb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.meettotapp.R
import com.example.meettotapp.helper.DbHelper

class ExdbActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exdb)
        var button =findViewById<Button>(R.id.button)

        button.setOnClickListener {
            var db =ExDatabase(this)
            db.readData()
        }
    }
}