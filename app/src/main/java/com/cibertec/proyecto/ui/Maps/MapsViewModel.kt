package com.cibertec.proyecto.ui.Maps

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.math.log

class MapsViewModel:ViewModel() {

    private lateinit var firestore: FirebaseFirestore
    val listStoreMutable = MutableLiveData<List<PaisFirebase>>()

    fun getPlacesFireStore(){
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("Paises").get()

            .addOnSuccessListener { documentList ->

                val listPaises = arrayListOf<PaisFirebase>()
                for (document in documentList){
                    val nombre = document.getString("nombre").toString()
                    val posicion = document.getGeoPoint("posicion")
                    if (nombre != null && posicion != null) {
                        var itemPais = PaisFirebase(nombre, posicion)
                        listPaises.add(itemPais)
                    }
                }
                listStoreMutable.value = listPaises

            }

            .addOnFailureListener{

            }
    }

}