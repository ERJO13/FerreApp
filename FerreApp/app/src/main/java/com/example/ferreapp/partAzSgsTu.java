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

import com.example.ferreapp.databinding.ActivityPartAzSgsTuBinding;

import java.util.ArrayList;
import java.util.List;

public class partAzSgsTu extends AppCompatActivity {

    private ActivityPartAzSgsTuBinding binding;
    private List<modelerApp> liPartAzSgsTu;
    private adapterPartAzSgsTu adapPartAzSgsTu;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartAzSgsTuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartAzSgsTu = new ArrayList<>();
        adapPartAzSgsTu= new adapterPartAzSgsTu(this,liPartAzSgsTu);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartAzSgsTu);

        Intent i = getIntent();
        boolean b = i.getBooleanExtra("decide", true);

        if(b){
            InsertDataIntoCards();}
        else{
            InsertDataIntoCardsHer();
        }
        // preparing the data

    }
    private void InsertDataIntoCards() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Tubo de cobre", partB[0]);
        liPartAzSgsTu.add(a);
        a = new modelerApp("Tubo galvanizado", partB[1]);
        liPartAzSgsTu.add(a);
        a = new modelerApp("Regulador", partB[2]);
        liPartAzSgsTu.add(a);

        adapPartAzSgsTu.notifyDataSetChanged();
    }

    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Teflón", partB[0]);
        liPartAzSgsTu.add(a);
        a = new modelerApp("Segueta", partB[1]);
        liPartAzSgsTu.add(a);
        a = new modelerApp("Llave stillson", partB[2]);
        liPartAzSgsTu.add(a);

        adapPartAzSgsTu.notifyDataSetChanged();
    }
    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}