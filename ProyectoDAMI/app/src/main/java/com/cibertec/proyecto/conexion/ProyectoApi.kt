package com.cibertec.proyecto.conexion

import com.cibertec.cibertecapp.network.request.LoginRequest
import com.cibertec.cibertecapp.network.request.RegisterRequest
import com.cibertec.cibertecapp.network.response.LoginResponse
import com.cibertec.cibertecapp.network.response.RegisterResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ProyectoApi {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

    @POST("users")
    fun register(@Body registerRequest: RegisterRequest): Single<RegisterResponse>
}