package com.example.test_app.api

class ApiService(private val api: Api) {

    companion object{
        const val login = "l12345678"
        const val password = "p12345678"
    }

    suspend fun getInfo() = api.getInfo()

}