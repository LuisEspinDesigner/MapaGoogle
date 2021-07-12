package com.example.mapagoogle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class InfoAdapter implements GoogleMap.InfoWindowAdapter {
    Context contxt;
    ImageView imageView;
    public InfoAdapter(Context context) {
        this.contxt=context;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        View infoVista = LayoutInflater.from(contxt).inflate(R.layout.infodesing,null);
        imageView= infoVista.findViewById(R.id.imageView);
        Glide.with(contxt).load("https://www.uteq.edu.ec/images/about/logo_fci.jpg").into(imageView);
        return infoVista;
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        return null;
    }
}
