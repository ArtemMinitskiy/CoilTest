package com.example.coiltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.coiltest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
//            image.load("https://avatars.githubusercontent.com/u/52722434?s=200&v=4") {
////                crossfade(5000)
//                crossfade(true)
//                placeholder(R.drawable.ic_launcher_background)
//                transformations(CircleCropTransformation())
//            }

            val imageLoader = ImageLoader(this@MainActivity)
            val request = ImageRequest.Builder(this@MainActivity)
                .data("https://avatars.githubusercontent.com/u/52722434?s=200&v=4")
                .target { drawable ->
                    // Handle the result.
                    image.setImageDrawable(drawable)
                }
                .build()
            imageLoader.enqueue(request)
        }

    }
}