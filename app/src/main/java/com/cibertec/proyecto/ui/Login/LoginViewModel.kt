package com.cibertec.proyecto.ui.Login

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cibertec.cibertecapp.network.response.LoginResponse
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel:ViewModel() {
    private val repository = LoginRepository()
    private lateinit var auth: FirebaseAuth
    private val disposable = CompositeDisposable()

    val userLoginServiceResponse = MutableLiveData<Boolean>()

    fun login(email: String, pass: String) {
        if (email.isNotEmpty() && pass.isNotEmpty()) {
            loginR(email, pass)
        }
    }

    private fun loginR(email: String, pass: String){
        disposable.add(
            repository.login(email, pass)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<LoginResponse>(){
                    override fun onSuccess(t: LoginResponse) {
                        userLoginServiceResponse.value = true
                    }
                    override fun onError(e: Throwable) {
                        Log.v("Login", e.message.toString())
                        userLoginServiceResponse.value = false
                    }
                }
                )
        )
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