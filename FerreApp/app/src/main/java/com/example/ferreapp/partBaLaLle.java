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

import com.example.ferreapp.databinding.ActivityPartBaLaLleBinding;

import java.util.ArrayList;
import java.util.List;

public class partBaLaLle extends AppCompatActivity {

    private ActivityPartBaLaLleBinding binding;
    private List<modelerApp> liPartBaLaLle;
    private adapterPartBaLaLle adapPartBaLaLle;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartBaLaLleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartBaLaLle = new ArrayList<>();
        adapPartBaLaLle= new adapterPartBaLaLle(this,liPartBaLaLle);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartBaLaLle);

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
                "Llave angular de paso", partB[0]);
        liPartBaLaLle.add(a);
        a = new modelerApp("Mangueras de lavabo", partB[1]);
        liPartBaLaLle.add(a);
        a = new modelerApp("Monomando", partB[2]);
        liPartBaLaLle.add(a);
        a = new modelerApp("Mezcladora", partB[3]);
        liPartBaLaLle.add(a);
        adapPartBaLaLle.notifyDataSetChanged();
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
                "Llave Stillson", partB[0]);
        liPartBaLaLle.add(a);
        a = new modelerApp("Llave inglesa", partB[1]);
        liPartBaLaLle.add(a);
        a = new modelerApp("Destornillador de cruz", partB[2]);
        liPartBaLaLle.add(a);
        a = new modelerApp("Teflón", partB[3]);
        liPartBaLaLle.add(a);
        adapPartBaLaLle.notifyDataSetChanged();
    }



    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}