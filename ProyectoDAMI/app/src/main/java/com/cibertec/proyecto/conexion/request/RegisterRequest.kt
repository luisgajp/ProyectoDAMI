package com.cibertec.cibertecapp.network.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("name")
    var nombre: String,
    @SerializedName("job")
    var puesto: String
)
