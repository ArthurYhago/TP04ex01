package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class FilmeAdapter(
    private val listaFilmes: MutableList<Filme>
) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitulo: TextView = itemView.findViewById(R.id.txtTituloFilme)
        val txtDiretor: TextView = itemView.findViewById(R.id.txtDiretorFilme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)

        return FilmeViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = listaFilmes[position]

        holder.txtTitulo.text = filme.titulo
        holder.txtDiretor.text = "Diretor: ${filme.diretor}"
    }

    override fun getItemCount(): Int {
        return listaFilmes.size
    }
}