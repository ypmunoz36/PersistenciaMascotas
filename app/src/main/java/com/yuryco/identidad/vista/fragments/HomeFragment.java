package com.yuryco.identidad.vista.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuryco.identidad.Adapter.MascotaAdaptador;
import com.yuryco.identidad.Pojo.Mascota;
import com.yuryco.identidad.R;
import com.yuryco.identidad.presentador.HomeFragmentPresenter;
import com.yuryco.identidad.presentador.IHomeFragmentPresenter;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements IHomeFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IHomeFragmentPresenter  iHomeFragmentPresenter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rvMascotas = v.findViewById(R.id.rvMascotas);

        iHomeFragmentPresenter= new HomeFragmentPresenter(this,getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearMascotaAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador  = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
        rvMascotas.setAdapter(mascotaAdaptador);
    }
}