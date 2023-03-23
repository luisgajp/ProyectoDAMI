package com.cibertec.proyecto.ui.Catalogo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CatalogoAdapter(private val list: List<Catalogo>): RecyclerView.Adapter<CatalogoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CatalogoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CatalogoViewHolder, position: Int) {
        val cat = list[position]
        holder.bind(cat.image1, cat.titulo, cat.des, cat.image2)
    }

    override fun getItemCount(): Int = list.size


}