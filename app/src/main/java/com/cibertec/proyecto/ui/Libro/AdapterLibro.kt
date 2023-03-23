package com.cibertec.proyecto.ui.Libro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.proyecto.model.entities.Libro

class AdapterLibro: RecyclerView.Adapter<ViewHolderLibro>() {

    private var libroList = emptyList<Libro>()


    fun  setLibro(libro: List<Libro>){
        this.libroList = libro
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = libroList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLibro {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolderLibro(inflater,parent)
    }

    //


    override fun onBindViewHolder(holder: ViewHolderLibro, position: Int) {
        val libro :Libro = libroList[position]
        holder.bind(libro)
    }



}