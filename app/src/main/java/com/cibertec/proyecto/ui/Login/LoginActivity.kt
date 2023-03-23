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
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class LoginActivity: AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    private val list = mutableListOf<CarouselItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem("https://p4.wallpaperbetter.com/wallpaper/609/599/817/books-cover-books-literature-wallpaper-preview.jpg"))
        list.add(CarouselItem("https://www.caracteristicas.co/wp-content/uploads/2018/12/don-quijote-1-scaled-e1584976940187.jpg"))
        list.add(CarouselItem("https://i.ytimg.com/vi/NWtTV2BU_Mg/mqdefault.jpg"))
        list.add(CarouselItem("https://trome.pe/resizer/7MPLihjpYL9zmZRxyoH-XGy6YG4=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/T7PQUUVTJBDAFC77MXFQOWHETA.png"))
        list.add(CarouselItem("https://fondosmil.com/fondo/1674.jpg"))
        list.add(CarouselItem("https://p4.wallpaperbetter.com/wallpaper/60/114/371/books-vintage-4k-book-ultra-hd-wallpaper-preview.jpg"))
        carousel.addData(list)

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