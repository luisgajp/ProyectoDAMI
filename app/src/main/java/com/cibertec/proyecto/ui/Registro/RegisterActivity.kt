package com.cibertec.proyecto.ui.Registro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.proyecto_dami.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.activity_registro.view.*

class RegisterActivity: AppCompatActivity() {

    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        val actionBar = supportActionBar
        actionBar?.hide()

        btnReg.setOnClickListener {
            val name = lbNombre.text.toString()
            val lastname = lbApellido.text.toString()
            val email = lbCorreo.text.toString()
            val pass = lbContraseña.text.toString()
            viewModel.register(name, lastname, email, pass)
        }

        observerViewModel()

    }

    fun observerViewModel(){
        viewModel.userRegisterServiceResponse.observe(this){ register ->
            if(register){
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Por favor revisar sus datos", Toast.LENGTH_SHORT).show()
            }

        }
    }

}