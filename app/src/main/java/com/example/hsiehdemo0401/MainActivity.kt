package com.example.hsiehdemo0401

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hsiehdemo0401.data.viewmodel.MyViewModel
import com.example.hsiehdemo0401.databinding.ActivityMainBinding
import com.example.hsiehdemo0401.ui.adapter.ModelAdapter

const val TAG = "qq"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MyViewModel>()

    private val myAdapter = ModelAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }


        viewModel.getModel()
        viewModel.modelLive.observe(this) {
            val body = it.body()
            body?.let { model ->
                myAdapter.list = model.data.items
                Log.e(TAG, "model: $it")
            }
        }




    }


}