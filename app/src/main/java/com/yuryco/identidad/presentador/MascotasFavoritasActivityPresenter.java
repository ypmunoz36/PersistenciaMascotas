package com.yuryco.identidad.presentador;

import android.content.Context;

import com.yuryco.identidad.Pojo.Mascota;
import com.yuryco.identidad.db.ConstructorMascotas;
import com.yuryco.identidad.vista.activities.IMascotasFavoritasActivityView;
import com.yuryco.identidad.vista.fragments.IHomeFragmentView;

import java.util.ArrayList;

public class MascotasFavoritasActivityPresenter implements IMascotasFavoritasActivityPresenter{
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas ;
    private Context context;
    private IMascotasFavoritasActivityView iMascotasFavoritasActivityView;

    public MascotasFavoritasActivityPresenter(IMascotasFavoritasActivityView iMascotasFavoritasActivityView, Context context) {
        this.iMascotasFavoritasActivityView = iMascotasFavoritasActivityView;
        this.context           = context;
        obtenerCincoMascotas();
    }

    @Override
    public void obtenerCincoMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerCincoMascotas();
        mostrarCincoMascotasRV();
    }

    @Override
    public void mostrarCincoMascotasRV() {
        iMascotasFavoritasActivityView.inicializarAdaptadorRV(iMascotasFavoritasActivityView.crearMascotaAdaptador(mascotas));
        iMascotasFavoritasActivityView.generarLinearLayoutVertical();
    }
}
