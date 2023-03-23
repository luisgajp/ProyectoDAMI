package com.cibertec.proyecto.ui.Catalogo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.proyecto_dami.R

class CatalogoActivity : AppCompatActivity(){


    private var recyclerCatalogo: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_catalogo)

        recyclerCatalogo = findViewById(R.id.recyclerCatalogo)

        recyclerCatalogo?.apply {
            layoutManager = LinearLayoutManager(context)
          //  ADAPTER
        }

    }
}