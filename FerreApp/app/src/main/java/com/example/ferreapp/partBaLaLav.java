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

import com.example.ferreapp.databinding.ActivityPartBaLaLavBinding;

import java.util.ArrayList;
import java.util.List;

public class partBaLaLav extends AppCompatActivity {

    private ActivityPartBaLaLavBinding binding;
    private List<modelerApp> liPartBaLaLav;
    private adapterPartBaLaLav adapPartBaLaLav;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartBaLaLavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartBaLaLav = new ArrayList<>();
        adapPartBaLaLav= new adapterPartBaLaLav(this,liPartBaLaLav);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartBaLaLav);

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

        };
        modelerApp a = new modelerApp(
                "Porta-Lavabo", partB[0]);
        liPartBaLaLav.add(a);
        a = new modelerApp("Lavabo", partB[1]);
        liPartBaLaLav.add(a);
        a = new modelerApp("Pedestal", partB[2]);
        liPartBaLaLav.add(a);


        adapPartBaLaLav.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "Taquetes 3/16", partB[0]);
        liPartBaLaLav.add(a);
        a = new modelerApp("Rotomartillo", partB[1]);
        liPartBaLaLav.add(a);
        a = new modelerApp("Broca 3/16", partB[2]);
        liPartBaLaLav.add(a);
        a = new modelerApp("Pijas", partB[3]);
        liPartBaLaLav.add(a);
        a = new modelerApp("Tubo de silicon", partB[4]);
        liPartBaLaLav.add(a);
        a = new modelerApp("Pistola para silicon", partB[5]);
        liPartBaLaLav.add(a);
        adapPartBaLaLav.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}