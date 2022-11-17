package com.example.test_app.utils.data.api

import com.example.test_app.utils.models.Data
import retrofit2.http.GET

interface Api {

    @GET("/getdocumentlist")
    suspend fun getInfo(): Data
}