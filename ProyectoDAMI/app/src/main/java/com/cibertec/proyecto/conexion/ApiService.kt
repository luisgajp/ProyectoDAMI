package com.cibertec.proyecto.conexion

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val url = "https://reqres.in/api/"
    val apiService = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProyectoApi::class.java)

}