package com.yuryco.identidad.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuryco.identidad.Pojo.Mascota;
import com.yuryco.identidad.R;
import com.yuryco.identidad.db.ConstructorMascotas;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    // constructor
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Damos vida a mi  layout cardView, inflar el layout y los pasara al view holder para el
        // obtenga los view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota,
                parent,false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        // pasamos la lista de obj , se setean los valores de los objetos, se invoca uno a uno
        // los elementos, asocia cada elementos de lso lista con cada view
        final Mascota m = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(m.getFoto());
        mascotaViewHolder.tvNombreCV.setText(m.getNombre());


        ConstructorMascotas cm = new ConstructorMascotas(activity);
        mascotaViewHolder.tvnRaitingCV.setText(""+cm.obtenerRatingMascota(m));

        mascotaViewHolder.btnRaitearCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Guarda el objeto de mascota en sqlite
                Toast.makeText(activity,"Diste like a "+ m.getNombre(),Toast.LENGTH_SHORT)
                        .show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darRaitMascota(m);
            }
        });
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
        private TextView tvNombreCV;
        private ImageButton btnRaitearCV;
        private TextView tvnRaitingCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoCV = itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV      = itemView.findViewById(R.id.tvNombreCV);
            btnRaitearCV    = itemView.findViewById(R.id.btnRaitearCV);
            tvnRaitingCV         = itemView.findViewById(R.id.tvnRaitingCV);
        }
    }
}
