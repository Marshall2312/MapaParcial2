package com.example.mapaparcial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Define las tres ubicaciones en Colombia con coordenadas exactas
        val muellePuertoColombia = LatLng(10.989135, -74.960886) // Muelle de Puerto Colombia, Atlántico
        val ventanaAlMundo = LatLng(11.033080353803, -74.83140591226) // Ventana al Mundo, Barranquilla
        val estatuaShakira = LatLng(11.010011, -74.782075) // Estatua de Shakira, Barranquilla

        // Agregar marcadores al mapa
        mMap.addMarker(MarkerOptions().position(muellePuertoColombia).title("Muelle de Puerto Colombia"))
        mMap.addMarker(MarkerOptions().position(ventanaAlMundo).title("Ventana al Mundo"))
        mMap.addMarker(MarkerOptions().position(estatuaShakira).title("Estatua de Shakira"))

        // Mover la cámara a la primera ubicación con nivel de zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(muellePuertoColombia, 12f))
    }
} 