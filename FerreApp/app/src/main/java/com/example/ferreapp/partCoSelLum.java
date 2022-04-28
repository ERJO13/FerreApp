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

import com.example.ferreapp.databinding.ActivityPartCoSelLumBinding;

import java.util.ArrayList;
import java.util.List;

public class partCoSelLum extends AppCompatActivity {

    private ActivityPartCoSelLumBinding binding;
    private List<modelerApp> liPartCoSelLum;
    private adapterPartCoSelLum adapPartCoSelLum;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPartCoSelLumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartCoSelLum = new ArrayList<>();
        adapPartCoSelLum = new adapterPartCoSelLum(this,liPartCoSelLum);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartCoSelLum);

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
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Plafón", partB[0]);
        liPartCoSelLum.add(a);
        a = new modelerApp("Cable", partB[1]);
        liPartCoSelLum.add(a);
        a = new modelerApp("Foco", partB[2]);
        liPartCoSelLum.add(a);
        a = new modelerApp("Socket", partB[3]);
        liPartCoSelLum.add(a);

        adapPartCoSelLum.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "Pinzas de corte", partB[0]);
        liPartCoSelLum.add(a);
        a = new modelerApp("Destornillador de cruz", partB[1]);
        liPartCoSelLum.add(a);
        a = new modelerApp("Multimetro", partB[2]);
        liPartCoSelLum.add(a);
        a = new modelerApp("Cinta de aislar", partB[2]);
        liPartCoSelLum.add(a);
        adapPartCoSelLum.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}