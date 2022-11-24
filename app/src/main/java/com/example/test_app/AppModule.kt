package com.example.test_app

import com.example.test_app.api.Api
import com.example.test_app.api.ApiService
import com.example.test_app.repository.Repository
import com.example.test_app.ui.MainActivityViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val client = OkHttpClient.Builder().addInterceptor(BasicAuthInterceptor("l12345678", "l12345678")).build()
val module = module{

    single {
        Retrofit.Builder()
            .baseUrl("http://api-test.tdera.ru/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(Api::class.java)
    }

    single {
        ApiService(get())
    }

    viewModel {
        MainActivityViewModel(get(), get())
    }

    single {
        Repository()
    }
}