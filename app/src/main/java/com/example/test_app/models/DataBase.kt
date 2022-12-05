package com.example.test_app.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test_app.repository.DataDao

@Database(
    version = 1,
    entities = [DataEntity::class]
)
abstract class DataBase : RoomDatabase() {
    abstract fun getDao(): DataDao
}