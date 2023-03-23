package com.cibertec.proyecto.ui.Catalogo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.proyecto.ui.Libro.SwipeDeleteLibros
import com.cibertec.proyecto_dami.R
import kotlinx.android.synthetic.main.activity_libros.*

class FragmentCatalogo: Fragment() {

    private val listaCat = mutableListOf(
                Catalogo(R.drawable.iliada,"Iliada","Precio: S/. 10.00",R.drawable.carrito),
                Catalogo(R.drawable.hercules,"Hercules","Precio: S/. 25.00",R.drawable.carrito),
                Catalogo(R.drawable.perfume,"El Perfume","Precio: S/. 16.00",R.drawable.carrito),
                Catalogo(R.drawable.principito,"El Principito","Precio: S/. 30.00",R.drawable.carrito),
        Catalogo(R.drawable.hobbit,"El Hobbit","Precio: S/. 50.00",R.drawable.carrito),
        Catalogo(R.drawable.gallinazos,"Los Gallinazos Sin Pluma","Precio: S/. 12.50",R.drawable.carrito),
        Catalogo(R.drawable.crimenycas,"Crimen y Castigo","Precio: S/. 7.00",R.drawable.carrito),
        Catalogo(R.drawable.harry,"Harry y Potter","Precio: S/. 9.20",R.drawable.carrito),
        Catalogo(R.drawable.milucha,"Mi Lucha","Precio: S/. 19.60",R.drawable.carrito),
        Catalogo(R.drawable.nacatita,"Ña Catita","Precio: S/. 8.80",R.drawable.carrito),
        Catalogo(R.drawable.paco,"Paco Yunke","Precio: S/. 2.00",R.drawable.carrito),
        Catalogo(R.drawable.romeo,"Romeo y Julieta","Precio: S/. 9.80",R.drawable.carrito)

        )



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_libros,container, false)
    }

    companion object{
        fun newInstance(): FragmentCatalogo = FragmentCatalogo()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerCat?.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = CatalogoAdapter(listaCat)

        }

        val swipeDeleteLibros = object : SwipeDeleteLibros(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                listaCat.removeAt(position)
                recyclerCat.adapter?.notifyItemRemoved(position)


            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeDeleteLibros)
        itemTouchHelper.attachToRecyclerView(recyclerCat)


    }


}

