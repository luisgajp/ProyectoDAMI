package com.cibertec.proyecto.ui.Maps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.proyecto_dami.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity: AppCompatActivity(), OnMapReadyCallback {

    private val btn: Button = findViewById(R.id.btnmapa)

    private lateinit var map:GoogleMap
    private lateinit var viewModel: MapsViewModel

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView((R.layout.activity_maps))

        viewModel = ViewModelProvider(this).get(MapsViewModel::class.java)
        viewModel.getPlacesFireStore()



        btn.setOnClickListener{
            val intent: Intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMap)
            as SupportMapFragment
        mapFragment.getMapAsync(this)

        viewModel.listStoreMutable.observe(this) { listPaisesFirebase ->
            if(listPaisesFirebase.isNotEmpty()){
                for (pais in listPaisesFirebase){
                    val name = pais.nombre

                    val posicion = pais.posicion

                    val positionMarker = LatLng(posicion.latitude, posicion.longitude)
                    map.addMarker(
                        MarkerOptions()
                            .position(positionMarker)
                            .title(name)
                            )
                }
            }

        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
    map = googleMap
        map.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(
                this, R.raw.style_json
            )
        )

        //lat: -9.189967
        //long:  -75.015152
        val positionMarker = LatLng(-9.189967, -75.015152)
        map.addMarker(
            MarkerOptions()
                .position(positionMarker)
                //.title("Ciudad de Lima")
        )

        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(positionMarker, 5f),
            4000,
            null
        )

        map.uiSettings.isRotateGesturesEnabled = false
        map.uiSettings.isZoomControlsEnabled = true

    }
}