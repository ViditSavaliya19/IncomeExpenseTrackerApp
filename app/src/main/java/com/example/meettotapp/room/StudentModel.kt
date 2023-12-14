package com.example.meettotapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "std")
data class StudentModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var id: Int,
    @ColumnInfo var name: String,
    @ColumnInfo var mobile: String,
    @ColumnInfo var add: String
)
