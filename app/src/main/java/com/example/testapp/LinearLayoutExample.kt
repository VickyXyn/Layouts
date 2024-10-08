package com.example.testapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.LinerLayoutExampleBinding

class LinearLayoutExample: AppCompatActivity() {

    private lateinit var binding: LinerLayoutExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LinerLayoutExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView: TextView = binding.textView1
        val button1: Button = binding.button1
        val button2: Button = binding.button2
        val button3: Button = binding.button3
        val button4: Button = binding.button4

        button1.setOnClickListener {
            textView.text = "Texto Alterado!"
        }

        button2.setOnClickListener {
            Toast.makeText(this, "Botão 2 clicado!", Toast.LENGTH_SHORT).show()
        }

        button3.setOnClickListener {
            binding.root.setBackgroundColor(Color.YELLOW)
        }

        button4.setOnClickListener {
            binding.root.setBackgroundColor(Color.WHITE)
            textView.text = "Resetar Texto"
        }
    }
}