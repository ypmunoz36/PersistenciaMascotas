package com.yuryco.identidad;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.yuryco.identidad.Adapter.PageAdapter;
import com.yuryco.identidad.vista.fragments.HomeFragment;
import com.yuryco.identidad.vista.activities.MascotasFavoritasActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        toolbar =  findViewById(R.id.toolbar);
        tabLayout =  findViewById(R.id.tabLayout);
        viewPager =  findViewById(R.id.viewPager);
        setUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mPreferidos:
                Intent i = new Intent(this, MascotasFavoritasActivity.class);
                startActivity(i);
                break;
            case R.id.mContacto:
                Intent in = new Intent(this,ContactoActivity.class);
                startActivity(in);
                break;
            case R.id.mAcercaDe:
                Intent inte = new Intent(this,BioDesarrolladorActivity.class);
                startActivity(inte);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new PerfilFragment() );

        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_perro_64);
    }
}