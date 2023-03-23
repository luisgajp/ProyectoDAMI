package com.cibertec.proyecto.ui.Registro

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore



class RegisterViewModel: ViewModel() {

    private lateinit var  auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    val userRegisterServiceResponse = MutableLiveData<Boolean>()

    fun register(name: String, lastname: String, email: String, pass:String){
        if(email.isNotEmpty() && pass.isNotEmpty()){
            registerFirebase(name, lastname, email, pass)
        }
    }

    private fun registerFirebase(name: String, lastname: String, email: String, pass: String){
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(Activity()){task->
                if(task.isSuccessful){
                    val userID = task.result?.user?.uid
                    if(userID != null){
                        registerFirestore(userID, name, lastname, email)
                    }
                }else{
                    Log.v("Registro", "Fallo en el Registro")
                    Log.v("Registro", task.exception?.message.toString())
                    userRegisterServiceResponse.value = false
                }
            }
    }

    private fun registerFirestore(uid: String, name: String, lastname: String, email: String){
        firestore = FirebaseFirestore.getInstance()
        val usuario = UserRegister(name, lastname, email)
        firestore.collection("usuarios").document(uid).set(usuario)
            .addOnCompleteListener(Activity()){ task ->
                userRegisterServiceResponse.value = task.isSuccessful
            }
    }


}