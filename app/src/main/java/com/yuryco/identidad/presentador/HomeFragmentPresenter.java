package com.yuryco.identidad.presentador;

import android.content.Context;

import com.yuryco.identidad.Pojo.Mascota;
import com.yuryco.identidad.db.ConstructorMascotas;
import com.yuryco.identidad.vista.fragments.IHomeFragmentView;

import java.util.ArrayList;

public class HomeFragmentPresenter implements IHomeFragmentPresenter {
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas ;
    private Context context;
    private IHomeFragmentView iHomeFragmentView;

    public HomeFragmentPresenter(IHomeFragmentView iHomeFragmentView, Context context) {
        this.iHomeFragmentView = iHomeFragmentView;
        this.context           = context;
        obtenerTodasMascotas();
    }

    @Override
    public void obtenerTodasMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerTodosDatos();
        mostrarTodasMascotasRV();
    }

    @Override
    public void mostrarTodasMascotasRV() {
        iHomeFragmentView.inicializarAdaptadorRV(iHomeFragmentView.crearMascotaAdaptador(mascotas));
        iHomeFragmentView.generarLinearLayoutVertical();
    }
}
