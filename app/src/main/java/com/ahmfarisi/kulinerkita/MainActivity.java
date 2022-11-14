package com.ahmfarisi.kulinerkita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bnvKulinerKita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bukaFragment(new FragmentBeranda());
        getSupportActionBar().setTitle("Beranda");

        bnvKulinerKita = findViewById(R.id.bnv_kuliner_kita);
        bnvKulinerKita.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_beranda:
                        bukaFragment(new FragmentBeranda());
                        getSupportActionBar().setTitle("Beranda");
                        return true;
                    case R.id.menu_disukai:
                        bukaFragment(new FragmentDisukai());
                        getSupportActionBar().setTitle("Disukai");
                        return true;
                    case R.id.menu_keranjang:
                        bukaFragment(new FragmentKeranjang());
                        getSupportActionBar().setTitle("Keranjang");
                        return true;
                }
                return false;
            }
        });
    }

    private void bukaFragment(Fragment FRG){
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fl_container, FRG);
        FT.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_profil:
                Intent pindah = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(pindah);
                break;
            case R.id.menu_logout:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}