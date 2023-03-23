package com.cibertec.proyecto.ui.Libro

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.cibertec.proyecto.model.entities.Libro
import kotlinx.coroutines.launch

class ViewModelLibro(application: Application):AndroidViewModel(application) {


    private val repository = RepositoryLibro(application)
    //Listando datos
    val libro = repository.getLibro()

    //Registrar
    fun saveLibro(libro: Libro){
        viewModelScope.launch {
            repository.insertLibro(libro)
        }
    }

    // Atualizar
    fun updateLibro(libro: Libro) {
        viewModelScope.launch {
            repository.updateLibro(libro)
        }
    }

    // Eliminar
    fun deleteLibro(libro: Libro) {
        viewModelScope.launch {
            repository.deleteLibro(libro)
        }
    }
}