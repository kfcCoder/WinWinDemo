package com.example.hsiehdemo0401.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hsiehdemo0401.ui.model.Model
import com.example.hsiehdemo0401.ui.retrofit.WinWinRetrofit
import kotlinx.coroutines.launch
import retrofit2.Response


class MyViewModel : ViewModel() {

    init {
        //getModel()
    }

    private val api = WinWinRetrofit.getApi

    private val _modelLive = MutableLiveData<Response<Model>>()
    val modelLive: LiveData<Response<Model>> = _modelLive

    fun getModel() {
        viewModelScope.launch {
            val response = api.getModel()
            _modelLive.postValue(response)
        }
    }

}