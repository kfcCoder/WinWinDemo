package com.example.hsiehdemo0401.data.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hsiehdemo0401.data.frag.TAG


class MyViewModel : ViewModel() {

    fun function() {
        Log.e(TAG, "function: invoked")
    }

}