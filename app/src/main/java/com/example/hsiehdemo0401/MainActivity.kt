package com.example.hsiehdemo0401

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.hsiehdemo0401.data.frag.TAG
import com.example.hsiehdemo0401.data.pager_adapter.MyPagerAdapter
import com.example.hsiehdemo0401.data.viewmodel.MyViewModel
import com.example.hsiehdemo0401.databinding.ActivityMainBinding
import com.example.hsiehdemo0401.ui.frag.FragOne
import com.example.hsiehdemo0401.ui.frag.FragTwo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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

        viewModel.randomLive.observe(this) {
            binding.textView.text = "$it"
        }



    }
}