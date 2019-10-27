package com.example.kkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class googlemap : AppCompatActivity() {
    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_googlemap)
        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
            googleMap.isMyLocationEnabled = true

            val location1 = LatLng(24.793607, 120.991078)
            val location2 = LatLng(24.792607, 120.990078)
            val location3 = LatLng(24.792507, 120.991278)
            val location4 = LatLng(24.792307, 120.992078)
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,16f))
            googleMap.addMarker(MarkerOptions().position(location1).title("hi").icon(BitmapDescriptorFactory.fromResource(R.drawable.ha)))
            googleMap.addMarker(MarkerOptions().position(location2).title("hi").icon(BitmapDescriptorFactory.fromResource(R.drawable.a)))
            googleMap.addMarker(MarkerOptions().position(location3).title("hi").icon(BitmapDescriptorFactory.fromResource(R.drawable.b)))
            googleMap.addMarker(MarkerOptions().position(location4).title("hi").icon(BitmapDescriptorFactory.fromResource(R.drawable.c)))
        })
    }
}