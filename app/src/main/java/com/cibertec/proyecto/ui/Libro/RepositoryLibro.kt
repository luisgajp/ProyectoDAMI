package com.cibertec.proyecto.ui.Libro

import android.app.Application
import androidx.lifecycle.LiveData
import com.cibertec.proyecto.database.DataBaseLibro
import com.cibertec.proyecto.model.dao.LibroReseñaDao
import com.cibertec.proyecto.model.entities.Libro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryLibro(application: Application) {


    private val libroReseñaDao:LibroReseñaDao? ? = DataBaseLibro.getInstance(application)?.libroReseñaDao()


    suspend fun  insertLibro(libro: Libro){
        processInsertLibro(libro)

    }

    private suspend fun processInsertLibro(libro: Libro){
        withContext(Dispatchers.Default){
            libroReseñaDao?.insert(libro)
        }
    }

    fun getLibro(): LiveData<List<Libro>>?{
        return libroReseñaDao?.listLibro()
    }

    suspend fun updateLibro(libro: Libro){
        processUpdateLibro(libro)
    }
    private suspend fun processUpdateLibro(libro: Libro){
        withContext(Dispatchers.Default){
            libroReseñaDao?.update(libro)
        }
    }


    suspend fun deleteLibro(libro: Libro) {
        processDeleteLibro(libro)
    }

    private suspend fun processDeleteLibro(libro: Libro) {
        withContext(Dispatchers.Default) {
            libroReseñaDao?.delete(libro)
        }
    }


}