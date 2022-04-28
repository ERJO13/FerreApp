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

import com.example.ferreapp.databinding.ActivityPartPaSgsReBinding;

import java.util.ArrayList;
import java.util.List;

public class partPaSgsRe extends AppCompatActivity {

    private ActivityPartPaSgsReBinding binding;
    private List<modelerApp> liPartPaSgsRe;
    private adapterPartPaSgsRe adapPartPaSgsRe;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartPaSgsReBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartPaSgsRe = new ArrayList<>();
        adapPartPaSgsRe = new adapterPartPaSgsRe(this,liPartPaSgsRe);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartPaSgsRe);

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
                "Alta presión 1 via", partB[0]);
        liPartPaSgsRe.add(a);
        a = new modelerApp("Alta presión 2 vias", partB[1]);
        liPartPaSgsRe.add(a);
        a = new modelerApp("Baja presión 1 via", partB[2]);
        liPartPaSgsRe.add(a);
        a = new modelerApp("Baja presión 2 vias", partB[3]);
        liPartPaSgsRe.add(a);

        adapPartPaSgsRe.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Teflón", partB[0]);
        liPartPaSgsRe.add(a);
        a = new modelerApp("Llave stillson", partB[1]);
        liPartPaSgsRe.add(a);

        adapPartPaSgsRe.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}