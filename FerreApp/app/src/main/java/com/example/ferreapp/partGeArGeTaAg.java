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

import com.example.ferreapp.databinding.ActivityPartGeArGeTaAgBinding;

import java.util.ArrayList;
import java.util.List;

public class partGeArGeTaAg extends AppCompatActivity {

    private ActivityPartGeArGeTaAgBinding binding;

    private List<modelerApp> liPartGeArGeTaAg;
    private adapterPartGeArGeTaAg adapPartGeArGeTaAg;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartGeArGeTaAgBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartGeArGeTaAg = new ArrayList<>();
        adapPartGeArGeTaAg = new adapterPartGeArGeTaAg(this,liPartGeArGeTaAg);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartGeArGeTaAg);

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

        };
        modelerApp a = new modelerApp(
                "Menos 10 cm", partB[0]);
        liPartGeArGeTaAg.add(a);
        a = new modelerApp("Mas de 10 cm", partB[1]);
        liPartGeArGeTaAg.add(a);
        adapPartGeArGeTaAg.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Cemento blanco", partB[0]);
        liPartGeArGeTaAg.add(a);
        a = new modelerApp("Paleta", partB[1]);
        liPartGeArGeTaAg.add(a);
        a = new modelerApp("Llana", partB[2]);
        liPartGeArGeTaAg.add(a);
        adapPartGeArGeTaAg.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}