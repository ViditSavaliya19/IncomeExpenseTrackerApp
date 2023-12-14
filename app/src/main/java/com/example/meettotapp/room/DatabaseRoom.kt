package com.example.meettotapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(StudentModel::class), version = 1, exportSchema = false)
public abstract class DatabaseRoom : RoomDatabase() {


    abstract fun dao(): DAO

    companion object {

        var db: DatabaseRoom? = null
        fun getDB(context: Context): DatabaseRoom {
            return db ?: createDB(context)
        }

        fun createDB(context: Context): DatabaseRoom {
            return Room.databaseBuilder(
                context.applicationContext,
                DatabaseRoom::class.java,
                "mydb"
            ).allowMainThreadQueries().build()
        }
    }

}