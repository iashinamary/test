package com.example.test_app

import androidx.room.Room
import com.example.test_app.api.Api
import com.example.test_app.api.ApiService
import com.example.test_app.models.DataBase
import com.example.test_app.repository.Repository
import com.example.test_app.ui.MainActivityViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val authClient: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(AuthInterceptor("l12345678", "p12345678"))
    .build()
val module = module{


    single {
        Retrofit.Builder()
            .baseUrl("http://api-test.tdera.ru/api/")
            .client(authClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<DataBase>{
        Room.databaseBuilder(androidContext(), DataBase::class.java, "DB").allowMainThreadQueries().build()
    }

    single {
        get<Retrofit>().create(Api::class.java)
    }


    viewModel {
        MainActivityViewModel(get(), get())
    }

    single {
        get<DataBase>().getDao()
    }

    single {
        ApiService(get())
    }


    single {
        Repository(get<DataBase>().getDao())
    }


}