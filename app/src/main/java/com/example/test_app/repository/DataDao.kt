package com.example.test_app.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test_app.models.Data
import com.example.test_app.models.DataEntity

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addData(data: DataEntity)

    @Query("SELECT * FROM data")
    fun getAllData() : LiveData<List<Data>>
}