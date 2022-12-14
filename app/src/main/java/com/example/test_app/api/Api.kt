package com.example.test_app.api

import com.example.test_app.models.Data
import com.example.test_app.models.Elements
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers


interface Api {
    @GET("getdocumentlist")
    suspend fun getInfo(): Elements
}