package com.cibertec.cibertecapp.network.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("email")
    var correo: String,
    @SerializedName("password")
    var clave: String
)
