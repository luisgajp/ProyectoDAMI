package com.cibertec.cibertecapp.network.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("name")
    var name: String,
    @SerializedName("job")
    var job: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("createdAt")
    var createdAt: String
)
