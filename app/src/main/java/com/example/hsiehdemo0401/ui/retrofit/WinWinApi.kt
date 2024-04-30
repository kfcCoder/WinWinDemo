package com.example.hsiehdemo0401.ui.retrofit

import com.example.hsiehdemo0401.ui.model.Model
import retrofit2.Response
import retrofit2.http.GET

interface WinWinApi {

    @GET("interview.json")
    suspend fun getModel(): Response<Model>
}