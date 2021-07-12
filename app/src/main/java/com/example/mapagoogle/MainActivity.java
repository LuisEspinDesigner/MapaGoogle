package com.example.mapagoogle;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    GoogleMap mapa;
    FloatingActionsMenu FloatMenu;
    FloatingActionButton mapnormal, mapsatelite, mapterrestre, maphibrido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatMenu = findViewById(R.id.grupomenu);
        mapnormal = findViewById(R.id.mapnormal);
        mapsatelite = findViewById(R.id.mapsatelital);
        mapterrestre = findViewById(R.id.mapterreno);
        maphibrido = findViewById(R.id.maphibrido);
        mapnormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                FloatMenu.collapse();
            }
        });
        mapsatelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                FloatMenu.collapse();
            }
        });
        maphibrido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                FloatMenu.collapse();
            }
        });
        mapterrestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapa.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                FloatMenu.collapse();
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa = googleMap;
        LatLng Quevedo = new LatLng(-1.0247031, -79.464449);
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(Quevedo, 14));
        mapa.setInfoWindowAdapter(new InfoAdapter(MainActivity.this));
        mapa.setOnMarkerClickListener(this);
        LatLng facultadEmpresariales = new LatLng(-1.0122321051743568, -79.47053223678434);
        marcador(facultadEmpresariales);
    }

    private void marcador(LatLng posicion) {
        MarkerOptions opMark = new MarkerOptions().position(posicion).draggable(true);
        mapa.addMarker(opMark);
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        marker.showInfoWindow();
        Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT).show();
        return false;
    }
}