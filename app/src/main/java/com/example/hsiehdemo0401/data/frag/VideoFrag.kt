package com.example.hsiehdemo0401.data.frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.hsiehdemo0401.R
import com.example.hsiehdemo0401.databinding.FragVideoBinding

const val TAG = "qq"
class VideoFrag : Fragment() {

    private lateinit var binding: FragVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_video, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        * TODO: play video by ExoPlayer
        *
        * val exoPlayer = ExoPlayer.Builder(requireContext()).build().apply {
                    val uri = "https://storage.googleapis.com/pst-framy/vdo/${id}.mp4"
                    setMediaItem(MediaItem.fromUri(uri))
                    playWhenReady = true
                    prepare()
                }

                binding.playerView.apply {
                    player = exoPlayer
                    useController = true
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                }
        *
        * */

        /* LiveData
       val dataLive = MutableLiveData("Hello").apply {
           observe(this@MainActivity) {
               binding.tv.text = it
           }
       }

       binding.tv.setOnClickListener {
           dataLive.value = "world"
       }*/

        /* ViewModel
        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        viewModel.function()*/

        /* Flow
        lifecycleScope.launch {

           flow {
                for (i in 0..2) {
                    Log.e(TAG, "delay: $i")
                    kotlinx.coroutines.delay(1000)
                }

                emit("www")
            }
            .flowOn(Dispatchers.IO)
            .collect {
                Log.e(TAG, "collect: $it")
            }
        }*/

        /* StateFlow
        val stateFlow = MutableStateFlow("qq")
        //stateFlow.value = "" // StateFlow can hold values

        lifecycleScope.launch {
            stateFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collectLatest {
                    Log.e(TAG, "collect of stateFlow: $it")
                }
        }*/

        /* SharedFlow
        val sharedFlow = MutableSharedFlow<String>() // 不要求觀察者在觀察那刻就收到消息

        binding.tv.setOnClickListener {
            lifecycleScope.launch {
                sharedFlow.emit("shared")
            }
        }

        lifecycleScope.launch {
            sharedFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collectLatest {
                    Log.e(TAG, "collect of sharedFlow: $it")
                }
        }*/

    }


}