package com.example.meettotapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DAO {

    @Insert fun insertData(model: StudentModel)
    @Update fun updateData(model: StudentModel)
    @Delete fun deleteData(model: StudentModel)
    @Query("SELECT * FROM std")
    fun redaData() : List<StudentModel>
}