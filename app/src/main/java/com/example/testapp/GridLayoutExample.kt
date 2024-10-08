package com.example.testapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.GridLayoutExampleBinding
import android.widget.TextView
import android.view.LayoutInflater
import android.view.ViewGroup

class GridLayoutExample: AppCompatActivity() {

    private lateinit var binding: GridLayoutExampleBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TodoAdapter

    private val todos = listOf("Afazer 1", "Afazer 2", "Afazer 3", "Afazer 4", "Afazer 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = GridLayoutExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TodoAdapter(todos)

        binding.botaoLista.setOnClickListener {
            recyclerView.adapter = adapter
            recyclerView.visibility = View.VISIBLE
        }
    }
}

class TodoAdapter(private val todos: List<String>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.textView.text = todos[position]
    }

    override fun getItemCount(): Int = todos.size
}