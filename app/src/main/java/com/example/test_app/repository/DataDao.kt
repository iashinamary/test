package com.example.test_app.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.test_app.models.Data
import com.example.test_app.models.DataEntity

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addData(data: DataEntity)

    @Query("SELECT * FROM data ORDER BY timeStamp DESC")
    fun getAllData() : LiveData<List<DataEntity>>

    @Transaction
    suspend fun select(idRecord: Int){
        removeSelect()
        selectById(idRecord)
    }

    @Query("UPDATE data SET isChecked = 0")
    suspend fun removeSelect()

    @Query("UPDATE data SET isChecked = 1 WHERE id_record =:id")
    suspend fun selectById(id: Int)

    @Query("SELECT * FROM data WHERE isChecked == 1 LIMIT 1")
    suspend fun getSelectedItem(): DataEntity?

    @Query("UPDATE data SET isChecked = 0 WHERE id_record =:idRecord")
    suspend fun unselectById(idRecord: Int)
}