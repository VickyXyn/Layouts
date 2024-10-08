package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.ConstraintLayoutExampleBinding
import kotlin.random.Random

class ConstraintLayoutExample: AppCompatActivity() {

    private lateinit var binding: ConstraintLayoutExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ConstraintLayoutExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        binding.button1.setOnClickListener {
            exibirNumeroAleatorio()
        }
    }

    private fun gerarNumeroAleatorio(): Int {
        return Random.nextInt(1, 100)
    }

    private fun exibirNumeroAleatorio() {
        val numeroAleatorio = gerarNumeroAleatorio()
        binding.textView1.text = "Número Aleatório: $numeroAleatorio"
    }
}

