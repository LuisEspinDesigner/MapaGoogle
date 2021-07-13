package com.example.mapagoogle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import org.json.JSONException;
import org.json.JSONObject;

public class InfoAdapter implements GoogleMap.InfoWindowAdapter {
    Context contxt;
    ImageView imageView;
    TextView titulo, decano, campus,correo;

    public InfoAdapter(Context context) {
        this.contxt = context;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        View infoVista = LayoutInflater.from(contxt).inflate(R.layout.infodesing, null);
        imageView = infoVista.findViewById(R.id.imageView);
        titulo = infoVista.findViewById(R.id.Titulo);
        decano = infoVista.findViewById(R.id.tvDecano);
        campus=infoVista.findViewById(R.id.campus);
        correo= infoVista.findViewById(R.id.correo);
        String jsontext = marker.getTitle();
        try {
            JSONObject json= new JSONObject(jsontext);
            titulo.setText(json.get("nombre").toString());
            decano.setText(json.get("decano").toString());
            campus.setText(json.get("campus").toString());
            correo.setText(json.get("correo").toString());
            Glide.with(contxt).load(json.get("imagen").toString()).into(imageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return infoVista;
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        return null;
    }
}
