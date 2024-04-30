package com.example.hsiehdemo0401

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hsiehdemo0401.data.pager_adapter.MyPagerAdapter
import com.example.hsiehdemo0401.data.viewmodel.MyViewModel
import com.example.hsiehdemo0401.databinding.ActivityMainBinding
import com.example.hsiehdemo0401.ui.frag.FragOne
import com.example.hsiehdemo0401.ui.frag.FragTwo

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

        viewModel.randomLive.observe(this) {
            binding.textView.text = "$it"
        }


    }
}