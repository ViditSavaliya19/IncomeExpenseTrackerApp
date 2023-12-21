package com.example.meettotapp.externaldb

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class ExDatabase(val context: Context?) : SQLiteOpenHelper(context, "StudentDb.db", null, 1) {
    var DB_PATH ="";
    override fun onCreate(db: SQLiteDatabase?) {}

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun checkDB() {
        DB_PATH = if (Build.VERSION.SDK_INT >= 17) {
            context!!.applicationInfo.dataDir + "/databases/"
        } else {
            "/data/data/" + context!!.packageName + "/databases/"
        }

        if (!(File(DB_PATH+"StudentDb.db").exists())) {
            copyDb()
        }
    }

    fun copyDb() {
        var db = readableDatabase
        var inputStream = context!!.assets.open("StudentDb.db")
        var outputStream = FileOutputStream(DB_PATH+"StudentDb.db")
        var bytes = ByteArray(1024)
        var length=0
        while(inputStream.read(bytes).also {  length = it }>0)
        {
            outputStream.write(bytes,0,length)
        }

        outputStream.flush()
        outputStream.close()
        inputStream.close()
    }


    @SuppressLint("Range")
    fun readData()
    {
        checkDB()
        var db = readableDatabase
        var query="SELECT * FROM std"
        var cursor = db.rawQuery(query,null)
        if(cursor.moveToFirst())
        {
            do {
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))
                var std = cursor.getString(cursor.getColumnIndex("std"))

                Log.e("Ex DB", "readData: $id $name $mobile $std" )

            }while (cursor.moveToNext())
        }
    }




}