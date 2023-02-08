package com.example.test_app

import android.util.Log
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val log : String, private val pass : String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", Credentials.basic(log, pass))
            .build()
        return chain.proceed(request)
    }
}