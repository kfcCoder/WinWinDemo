package com.example.hsiehdemo0401.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DemoRetrofit {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://bas.playsee.dev/test1.0/backstage/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getApi by lazy {
        retrofit.create(DemoApi::class.java)
    }


}