package com.yuryco.identidad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuryco.identidad.Adapter.MascotaAdaptadorPerfil;
import com.yuryco.identidad.Pojo.Mascota;
import com.yuryco.identidad.R;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);
        rvMascotas = v.findViewById(R.id.rvMascotasGrid);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3,RecyclerView.VERTICAL,false);

        rvMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicilizarAdaptador();

        return v;
    }
    private void inicilizarAdaptador() {
        MascotaAdaptadorPerfil adaptador  = new MascotaAdaptadorPerfil(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas =new ArrayList<Mascota>();
        mascotas.add(new Mascota(1, "Catty ",3,  R.drawable.mascota1));
        mascotas.add(new Mascota(2,"Catty", 2 , R.drawable.mascota1));
        mascotas.add(new Mascota(3,"Catty", 1,  R.drawable.mascota1));
        mascotas.add(new Mascota(4,"Catty", 4,  R.drawable.mascota1));
        mascotas.add(new Mascota(5,"Catty", 2,  R.drawable.mascota1));
    }
}