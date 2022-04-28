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
import android.widget.Toast;

import com.example.ferreapp.databinding.ActivityEscenariosBinding;

import java.util.ArrayList;
import java.util.List;

public class escenarios extends AppCompatActivity {

    private ActivityEscenariosBinding binding;

    private List<modelerApp> escList;
    private adapterEsc adapterEsc;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEscenariosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        recyclerView = findViewById(R.id.recycler_escenario);
        escList = new ArrayList<>();
        adapterEsc = new adapterEsc(this,escList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterEsc);

        //Intent i = getIntent();
        //boolean b = i.getBooleanExtra("decideEsc",true);
        //Toast.makeText(getApplicationContext(), "La decision "+b, Toast.LENGTH_LONG).show();

        // preparing the data
        InsertDataIntoCards();
    }

    private void InsertDataIntoCards() {
    // add the cards data
        int[] escenarios = new int[]{
            R.drawable.azotea,
            R.drawable.bano,
            R.drawable.cocina,
            R.drawable.patio,
            R.drawable.general,

        };

        modelerApp a = new modelerApp(
                            "Azotea", escenarios[0]);
        escList.add(a);
        a = new modelerApp("Baño", escenarios[1]);
        escList.add(a);
        a = new modelerApp("Cocina", escenarios[2]);
        escList.add(a);
        a = new modelerApp("Patio", escenarios[3]);
        escList.add(a);
        a = new modelerApp("General", escenarios[4]);
        escList.add(a);
        adapterEsc.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}