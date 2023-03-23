package com.cibertec.proyecto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cibertec.proyecto.model.dao.LibroReseñaDao
import com.cibertec.proyecto.model.entities.Libro

@Database(entities = [Libro::class], version = 1)
abstract class DataBaseLibro:RoomDatabase() {

    abstract fun libroReseñaDao():LibroReseñaDao

    companion object{
        private const val DATABASE_NAME = "DBReseñas_libros"


        @Volatile
        private var INSTANCE: DataBaseLibro? = null

        fun getInstance(context: Context):DataBaseLibro?{
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    DataBaseLibro::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}