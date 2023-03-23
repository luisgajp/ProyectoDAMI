package com.cibertec.proyecto.ui.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.proyecto.ui.Registro.RegisterActivity
import com.cibertec.proyecto.ui.menu.MenuPrincipal
import com.cibertec.proyecto_dami.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val actionBar = supportActionBar
        actionBar?.hide()

        btnIngresar.setOnClickListener {
            val email = lbEmail.text.toString()
            val pass = lbPass.text.toString()
            viewModel.login(email, pass)
        }
        btnRegistrar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        observerViewModel()
    }

    fun observerViewModel() {
        viewModel.userLoginServiceResponse.observe(this) { login ->
            if (login) {
                Log.v("Login", "Success")
                startActivity(Intent(this, MenuPrincipal::class.java))
                finish()
            }else{
                Log.v("Login", "Fallido")
                Toast.makeText(this, "Intentelo nuevamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}