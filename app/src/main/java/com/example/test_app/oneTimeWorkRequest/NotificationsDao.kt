package com.example.test_app.oneTimeWorkRequest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface NotificationsDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertNotification()
}