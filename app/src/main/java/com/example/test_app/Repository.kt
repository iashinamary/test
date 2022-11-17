package com.example.test_app

import androidx.lifecycle.LiveData
import com.example.test_app.models.Data

class Repository {

    fun getAllData() : LiveData<List<Data>>{

    }

    suspend fun addData(data: Data){

    }
}