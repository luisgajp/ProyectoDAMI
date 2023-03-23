package com.cibertec.proyecto.ui.Catalogo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.proyecto_dami.R

class CatalogoViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_catalago,parent,false)) {

    private var imgcatalogo: ImageView? = null
    private var txttitulo: TextView? = null
    private var txtdes: TextView? = null
    private var imgcarrito: ImageView? = null

    init{
        imgcatalogo = itemView.findViewById(R.id.primero)
        txttitulo = itemView.findViewById(R.id.texto)
        txtdes = itemView.findViewById(R.id.precio)
        imgcarrito = itemView.findViewById(R.id.car)
    }

    fun bind(image1: Int, titulo: String, des: String, image2: Int){
        imgcatalogo?.setImageResource(image1)
        txttitulo?.text = titulo
        txtdes?.text = des
        imgcarrito?.setImageResource(image2)
    }




}