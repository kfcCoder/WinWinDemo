package com.example.hsiehdemo0401.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response


class MyViewModel : ViewModel() {

    init {
        getRandomNumber()
    }

    // random
    private val _randomLive = MutableLiveData<Int>()
    val randomLive: LiveData<Int> = _randomLive

    fun getRandomNumber() {
        viewModelScope.launch {
            val random = (0..9).random()
            delay(2000)
            _randomLive.postValue(random)
        }
    }

}