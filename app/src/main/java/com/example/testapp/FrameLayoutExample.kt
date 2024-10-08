package com.example.testapp

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.FrameLayoutExampleBinding

class FrameLayoutExample: AppCompatActivity() {

    private lateinit var binding: FrameLayoutExampleBinding
    private var currentImageIndex = 0
    private val images = listOf(R.drawable.ic_launcher, R.drawable.other_image)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FrameLayoutExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            currentImageIndex = (currentImageIndex + 1) % images.size
            binding.imageView.setImageResource(images[currentImageIndex])


            val fadeIn = ObjectAnimator.ofFloat(binding.imageView, "alpha", 0f, 1f)
            fadeIn.duration = 500
            fadeIn.start()
        }
    }
}

