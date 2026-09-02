package com.example.myapplication.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtTitulo = findViewById<EditText>(R.id.edtTitulo)
        val edtDiretor = findViewById<EditText>(R.id.edtDiretor)
        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)
        val recyclerFilmes = findViewById<RecyclerView>(R.id.recyclerFilmes)

        val listaFilmes = mutableListOf<Filme>()

        val adapter = FilmeAdapter(listaFilmes)

        recyclerFilmes.layoutManager = GridLayoutManager(this, 2)
        recyclerFilmes.adapter = adapter

        btnAdicionar.setOnClickListener {

            val titulo = edtTitulo.text.toString()
            val diretor = edtDiretor.text.toString()

            if (titulo.isNotEmpty() && diretor.isNotEmpty()) {

                val filme = Filme(titulo, diretor)

                listaFilmes.add(filme)

                adapter.notifyItemInserted(listaFilmes.size - 1)

                edtTitulo.text.clear()
                edtDiretor.text.clear()
            }
        }
    }
}