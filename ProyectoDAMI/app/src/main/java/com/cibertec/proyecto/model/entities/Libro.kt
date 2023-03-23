package com.cibertec.proyecto.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_libro")
data class Libro(


   @ColumnInfo(name = "titulo_libro")
   val titulo:String,

   @ColumnInfo(name = "autor_libro")
   val autor: String,

   @ColumnInfo(name = "descripcion_libro")
   val descripcion:String

){

   @PrimaryKey(autoGenerate = true)
   @ColumnInfo(name = "id_libro")
   var libroId: Int = 0

}