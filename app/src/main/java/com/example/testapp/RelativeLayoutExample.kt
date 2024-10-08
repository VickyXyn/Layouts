package com.example.testapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.RelativeLayoutExampleBinding


class RelativeLayoutExample: AppCompatActivity() {

    private lateinit var binding: RelativeLayoutExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RelativeLayoutExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.button1
        val textView = binding.textView1

        button.setOnClickListener {
            textView.text = "Nada dá certo!"
        }
    }
}