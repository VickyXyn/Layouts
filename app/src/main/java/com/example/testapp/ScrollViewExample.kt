package com.example.testapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ScrollviewExampleBinding

data class Animal(val name: String, val sound: String)

class ScrollViewExample: AppCompatActivity() {

    private lateinit var binding: ScrollviewExampleBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimalAdapter
    private val animalList = mutableListOf<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ScrollviewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AnimalAdapter(animalList)
        recyclerView.adapter = adapter

        binding.buttonAdd.setOnClickListener {
            addAnimal()
        }
    }

    private fun addAnimal() {
        val animalName = binding.editTextAnimal.text.toString()
        val animalSound = binding.editTextSound.text.toString()

        if (animalName.isNotBlank() && animalSound.isNotBlank()) {
            animalList.add(Animal(animalName, animalSound))
            adapter.notifyItemInserted(animalList.size - 1)

            binding.editTextAnimal.text.clear()
            binding.editTextSound.text.clear()
        }
    }
}

class AnimalAdapter(private val animalList: List<Animal>) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewAnimal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = "${animalList[position].name}: ${animalList[position].sound}"
    }

    override fun getItemCount(): Int = animalList.size
}