package com.yuryco.identidad.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuryco.identidad.Pojo.Mascota;
import com.yuryco.identidad.R;

import java.util.ArrayList;

public class MascotaAdaptadorPerfil extends RecyclerView.Adapter<MascotaAdaptadorPerfil.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    // constructor
    public MascotaAdaptadorPerfil(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Damos vida a mi  layout cardView, inflar el layout y los pasara al view holder para el
        // obtenga los view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota_perfil,
                parent,false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        // pasamos la lista de obj , se setean los valores de los objetos, se invoca uno a uno
        // los elementos, asocia cada elementos de lso lista con cada view
        final Mascota m = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(m.getFoto());
        mascotaViewHolder.tvnRaitingCV.setText(""+m.getNumRaiting());
    }

    /**
     * Cantidad de elementos que contiene mi lista
     * @return Int
     */
    @Override
    public int getItemCount() {
        return mascotas.size();
    }
    //estp es Clase view holder ayuda a crear los views y asociarlo a un objeto

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoCV;
        private TextView tvnRaitingCV;
        // TODO imagen del hueso amarrillo necesario ???

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoCV    = itemView.findViewById(R.id.imgFotoCV);
            tvnRaitingCV = itemView.findViewById(R.id.tvnRaitingCV);
        }
    }
}
