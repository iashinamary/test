package com.example.test_app.utils.data.api

class ApiService(private val api: Api) {

    suspend fun getInfo(limit: Int) = api.getInfo()

}