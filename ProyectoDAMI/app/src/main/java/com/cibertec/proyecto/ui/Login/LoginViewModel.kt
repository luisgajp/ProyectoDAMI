package com.cibertec.proyecto.ui.Login

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel:ViewModel() {
    private val repository = LoginRepository()
    private lateinit var auth: FirebaseAuth
    private val disposable = CompositeDisposable()

    val userLoginServiceResponse = MutableLiveData<Boolean>()

    fun login(email: String, pass: String) {
        if (email.isNotEmpty() && pass.isNotEmpty()) {
            loginFirebase(email, pass)
        }
    }

    private fun loginFirebase(email: String, pass: String) {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(Activity()) { task ->
                if (task.isSuccessful) {
                    Log.v("Login", "Login Completo")
                    userLoginServiceResponse.value = true
                } else {
                    Log.v("Login", "Login Fallido")
                    userLoginServiceResponse.value = false
                }
            }


    }
}