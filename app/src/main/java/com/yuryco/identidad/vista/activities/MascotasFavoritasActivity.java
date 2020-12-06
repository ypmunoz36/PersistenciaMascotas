package com.yuryco.identidad.vista.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yuryco.identidad.Adapter.MascotaAdaptador;
import com.yuryco.identidad.Pojo.Mascota;
import com.yuryco.identidad.R;
import com.yuryco.identidad.presentador.IMascotasFavoritasActivityPresenter;
import com.yuryco.identidad.presentador.MascotasFavoritasActivityPresenter;

import java.util.ArrayList;

public class MascotasFavoritasActivity extends AppCompatActivity implements IMascotasFavoritasActivityView {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IMascotasFavoritasActivityPresenter iMascotasFavoritasActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);

        Toolbar miActionBar =  findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.favoritos);

        rvMascotas = findViewById(R.id.rvMascotasFav);

        iMascotasFavoritasActivityPresenter = new MascotasFavoritasActivityPresenter(this, this );
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearMascotaAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador  = new MascotaAdaptador(mascotas,this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
        rvMascotas.setAdapter(mascotaAdaptador);
    }
}