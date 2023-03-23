package com.cibertec.proyecto.ui.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cibertec.proyecto.ui.Catalogo.FragmentCatalogo
import com.cibertec.proyecto.ui.Libro.FragmentoLibro
import com.cibertec.proyecto_dami.R
import kotlinx.android.synthetic.main.activity_menu.*


class MenuPrincipal:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

       //Cargar los fragmentos en el menú
        navigationView.setOnItemSelectedListener {
        item ->
        when(item.itemId){
            //Fragmentos de nuestro menú

            R.id.navigationPrincipal ->{

                return@setOnItemSelectedListener true
              
            }
            R.id.navigationCatalogo ->{
             val fragmentoCatalogo = FragmentCatalogo.newInstance()
                cargarFragmento(fragmentoCatalogo)
                return@setOnItemSelectedListener true
            }
            R.id.navigationLibro ->{
              val fragmentoLibro = FragmentoLibro.newInstance()
                cargarFragmento(fragmentoLibro)
                return@setOnItemSelectedListener true
            }

        }
            false
        }

    }

    private fun cargarFragmento(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}
