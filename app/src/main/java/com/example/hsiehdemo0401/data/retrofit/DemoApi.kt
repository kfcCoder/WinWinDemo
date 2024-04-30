package com.example.hsiehdemo0401.data.retrofit

import com.example.hsiehdemo0401.data.model.Result
import retrofit2.Response
import retrofit2.http.GET

interface DemoApi {

    @GET("exm1/")
    suspend fun getResult(): Response<Result>

}