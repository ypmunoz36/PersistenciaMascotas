package com.yuryco.identidad.vista.activities;

import com.yuryco.identidad.Adapter.MascotaAdaptador;
import com.yuryco.identidad.Pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasFavoritasActivityView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearMascotaAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);
}
