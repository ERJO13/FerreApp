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

import com.example.ferreapp.databinding.ActivityPartGeArGeLamTeBinding;

import java.util.ArrayList;
import java.util.List;

public class partGeArGeLamTe extends AppCompatActivity {

    private ActivityPartGeArGeLamTeBinding binding;
    private List<modelerApp> liPartGeArGeLamTe;
    private adapterPartGeArGeLamTe adapPartGeArGeLamTe;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartGeArGeLamTeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartGeArGeLamTe = new ArrayList<>();
        adapPartGeArGeLamTe = new adapterPartGeArGeLamTe(this,liPartGeArGeLamTe);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartGeArGeLamTe);

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

        };
        modelerApp a = new modelerApp(
                "No enciende", partB[0]);
        liPartGeArGeLamTe.add(a);

        adapPartGeArGeLamTe.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "Multimetro", partB[0]);
        liPartGeArGeLamTe.add(a);
        a = new modelerApp("Pinzas de corte", partB[1]);
        liPartGeArGeLamTe.add(a);
        a = new modelerApp("Cinta de aislar", partB[2]);
        liPartGeArGeLamTe.add(a);

        adapPartGeArGeLamTe.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}