package com.cibertec.proyecto.ui.Libro

import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.proyecto.model.entities.Libro
import com.cibertec.proyecto_dami.R
import kotlinx.android.synthetic.main.dialog_libro.view.*
import kotlinx.android.synthetic.main.fragment_libro.*
import kotlinx.android.synthetic.main.item_libro.*
import kotlinx.android.synthetic.main.item_libro.view.*

class FragmentoLibro: Fragment() {


    private lateinit var viewModelLibro: ViewModelLibro

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_libro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelLibro = run {
            ViewModelProviders.of(this).get(ViewModelLibro::class.java)
        }

        registrarLibro.setOnClickListener {
           registerLibro()
        }


        configurationComponents()



    }

    companion object {
        fun newInstance(): FragmentoLibro = FragmentoLibro()
    }

    private fun configurationComponents() {
        val adapter = AdapterLibro()
        recyclerLibro.adapter = adapter
        recyclerLibro.layoutManager = LinearLayoutManager(activity)

        viewModelLibro.libro?.observe(viewLifecycleOwner) { libro ->
            if (libro.isNotEmpty()) {
                libro?.let {
                    adapter.setLibro(it)
                }
            }
        }
    }
    private fun registerLibro(){

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_libro, null)
        val titleAlertNote = "Registrar"
        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle(titleAlertNote)
        val mAlertDialog = mBuilder.show()
        mDialogView.btnCreate.setOnClickListener{

            mAlertDialog.dismiss()

            val tituloLibro = mDialogView.edtTituloLibro.text.toString()
            val autorLibro = mDialogView.edtAutorLibro.text.toString()
            val descripcionLibro = mDialogView.edtDescriptionLibro.text.toString()

            var libro = Libro(tituloLibro, autorLibro,descripcionLibro)
            viewModelLibro.saveLibro(libro)

        }
    }







}
