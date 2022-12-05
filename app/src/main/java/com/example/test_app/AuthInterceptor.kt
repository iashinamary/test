package com.example.test_app

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        if (request.header("Authentication-required") != null) {
            request = request.newBuilder()
                .addHeader("username", "l12345678")
                .addHeader("password", "p12345678")
                .build()
        }

        return chain.proceed(request)
    }
}