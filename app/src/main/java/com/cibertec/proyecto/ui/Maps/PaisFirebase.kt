package com.cibertec.proyecto.ui.Maps

import com.google.firebase.firestore.GeoPoint

data class PaisFirebase(
    var nombre: String,
    var posicion: GeoPoint
)
