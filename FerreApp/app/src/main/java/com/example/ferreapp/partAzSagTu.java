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

import com.example.ferreapp.databinding.ActivityPartAzSagTuBinding;

import java.util.ArrayList;
import java.util.List;

public class partAzSagTu extends AppCompatActivity {

    private ActivityPartAzSagTuBinding binding;
    private List<modelerApp> liPartAzSagTu;
    private adapterPartAzSagTu adapPartAzSagTu;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartAzSagTuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartAzSagTu = new ArrayList<>();
        adapPartAzSagTu = new adapterPartAzSagTu(this,liPartAzSagTu);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartAzSagTu);

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
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "CPVC", partB[0]);
        liPartAzSagTu.add(a);
        a = new modelerApp("Coples", partB[1]);
        liPartAzSagTu.add(a);
        a = new modelerApp("Tees", partB[2]);
        liPartAzSagTu.add(a);
        a = new modelerApp("Codos", partB[3]);
        liPartAzSagTu.add(a);
        a = new modelerApp("adaptador macho", partB[4]);
        liPartAzSagTu.add(a);
        adapPartAzSagTu.notifyDataSetChanged();
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
        liPartAzSagTu.add(a);
        a = new modelerApp("Llave inglesa", partB[1]);
        liPartAzSagTu.add(a);
        a = new modelerApp("Segueta", partB[1]);
        liPartAzSagTu.add(a);
        adapPartAzSagTu.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}