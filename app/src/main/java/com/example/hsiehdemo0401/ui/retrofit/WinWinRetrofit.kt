package com.example.hsiehdemo0401.ui.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WinWinRetrofit {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/winwiniosapp/interview/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getApi by lazy {
        retrofit.create(WinWinApi::class.java)
    }


}