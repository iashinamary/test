package com.example.test_app.repository

import androidx.lifecycle.LiveData
import com.example.test_app.models.Data
import com.example.test_app.models.DataEntity

class Repository(private val dao: DataDao) {

    fun getAllData() : LiveData<List<Data>> = dao.getAllData()

    suspend fun addData(data: DataEntity) = dao.addData(data)
}