package com.example.test_app

import com.example.test_app.api.Api
import com.example.test_app.api.ApiService
import com.example.test_app.ui.MainActivityViewModel
import com.google.gson.Gson
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val module = module {

    single {
        Retrofit.Builder().baseUrl("")
            .addConverterFactory(GsonConverterFactory.create()).build()
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