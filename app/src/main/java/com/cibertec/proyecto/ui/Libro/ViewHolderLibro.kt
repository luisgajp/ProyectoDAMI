package com.cibertec.proyecto.ui.Libro

import android.content.pm.PackageManager

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.proyecto.model.entities.Libro
import com.cibertec.proyecto_dami.R
import org.w3c.dom.Text


class ViewHolderLibro(inflater: LayoutInflater,parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_libro,parent,false)) {


    private var textTituloLibro: TextView? = null
    private var textAutorLibro: TextView? = null
    private var textDescripcionLibro: TextView? = null


    init {
        textTituloLibro = itemView.findViewById(R.id.textTituloLibro)
        textAutorLibro = itemView.findViewById(R.id.textAutor)
        textDescripcionLibro  = itemView.findViewById(R.id.textResumenLibro)


    }
    fun bind(libro: Libro) {
        textTituloLibro?.text = libro.titulo
        textAutorLibro?.text = libro.autor
        textDescripcionLibro?.text = libro.descripcion


    }



}