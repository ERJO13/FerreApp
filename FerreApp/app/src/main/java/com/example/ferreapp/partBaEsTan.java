package com.example.ferreapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;

import com.example.ferreapp.databinding.ActivityPartBaEsTanBinding;

import java.util.ArrayList;
import java.util.List;

public class partBaEsTan extends AppCompatActivity {

    private ActivityPartBaEsTanBinding binding;
    private List<modelerApp> liPartBaEsTan;
    private adapterPartBaEsTan adapPartBaEsTan;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartBaEsTanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartBaEsTan = new ArrayList<>();
        adapPartBaEsTan= new adapterPartBaEsTan(this,liPartBaEsTan);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartBaEsTan);

        // preparing the data
        Intent i = getIntent();
        boolean b = i.getBooleanExtra("decide", true);

        if(b){
            InsertDataIntoCards();}
        else{
            InsertDataIntoCardsHer();
        }
    }
    private void InsertDataIntoCards() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.sapo,
                R.drawable.flotador,
                R.drawable.enconstruccion,
                R.drawable.manguera_metalica,
                R.drawable.llave_paso,

        };
        modelerApp a = new modelerApp(
                "Sapo", partB[0]);
        liPartBaEsTan.add(a);
        a = new modelerApp("Flotador", partB[1]);
        liPartBaEsTan.add(a);
        a = new modelerApp("Valvula de llenado", partB[2]);
        liPartBaEsTan.add(a);
        a = new modelerApp("Manguera de aluminio", partB[3]);
        liPartBaEsTan.add(a);
        a = new modelerApp("Llave de paso", partB[4]);
        liPartBaEsTan.add(a);

        adapPartBaEsTan.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.teflon,
                R.drawable.inglesa,
                R.drawable.destornillador_plano,
        };
        modelerApp a = new modelerApp(
                "Teflón", partB[0]);
        liPartBaEsTan.add(a);
        a = new modelerApp("Llave inglesa", partB[1]);
        liPartBaEsTan.add(a);
        a = new modelerApp("Destornillador plano", partB[2]);
        liPartBaEsTan.add(a);

        adapPartBaEsTan.notifyDataSetChanged();
    }

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}