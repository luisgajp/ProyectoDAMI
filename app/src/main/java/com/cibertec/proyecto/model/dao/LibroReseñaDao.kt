package com.cibertec.proyecto.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cibertec.proyecto.model.entities.Libro

@Dao
interface LibroReseñaDao {

    @Insert
    fun insert(libro: Libro)

    @Update
    fun update(libro: Libro)
    @Query("UPDATE table_libro SET titulo_libro=:titulo, autor_libro=:autor,descripcion_libro=:descripcion where id_libro=:libroId ")
    fun update(titulo: String, autor: String,descripcion:String, libroId: Int)

    @Delete
    fun delete(libro: Libro)
    @Query("DELETE FROM table_libro WHERE id_libro=:libroId")
    fun delete(libroId: Int)

    @Query ("SELECT * FROM table_libro")
    fun listLibro(): LiveData<List<Libro>>
}