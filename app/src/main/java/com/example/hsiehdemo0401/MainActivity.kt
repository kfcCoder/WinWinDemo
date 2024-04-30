package com.example.hsiehdemo0401

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hsiehdemo0401.data.pager_adapter.MyPagerAdapter
import com.example.hsiehdemo0401.data.viewmodel.MyViewModel
import com.example.hsiehdemo0401.databinding.ActivityMainBinding
import com.example.hsiehdemo0401.ui.frag.FragOne
import com.example.hsiehdemo0401.ui.frag.FragTwo
import com.example.hsiehdemo0401.ui.retrofit.WinWinRetrofit
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

const val TAG = "qq"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragList = listOf(FragOne(), FragTwo())
        val pagerAdapter = MyPagerAdapter(fragList, supportFragmentManager, lifecycle)
        binding.verticalPager.adapter = pagerAdapter

//        viewModel.modelLive.observe(this) {
//            val body = it.body()
//            body?.let {
//                Log.e(TAG, "model: $it")
//            }
//        }

        val api = WinWinRetrofit.getApi
        GlobalScope.launch {
            val response = api.getModel()
            val body = response.body()
            Log.e(TAG, "onCreate: $body")
        }


    }


}