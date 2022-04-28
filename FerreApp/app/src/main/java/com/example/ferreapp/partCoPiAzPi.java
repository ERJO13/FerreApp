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

import com.example.ferreapp.databinding.ActivityPartCoPiAzPiBinding;

import java.util.ArrayList;
import java.util.List;

public class partCoPiAzPi extends AppCompatActivity {

    private ActivityPartCoPiAzPiBinding binding;
    private List<modelerApp> liPartCoPiAzPi;
    private adapterPartCoPiAzPi adapPartCoPiAzPi;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartCoPiAzPiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartCoPiAzPi = new ArrayList<>();
        adapPartCoPiAzPi = new adapterPartCoPiAzPi(this,liPartCoPiAzPi);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartCoPiAzPi);

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
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Pisos", partB[0]);
        liPartCoPiAzPi.add(a);
        a = new modelerApp("Pegapiso", partB[1]);
        liPartCoPiAzPi.add(a);
        a = new modelerApp("Junteador", partB[2]);
        liPartCoPiAzPi.add(a);
        adapPartCoPiAzPi.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "Corta-azulejo", partB[0]);
        liPartCoPiAzPi.add(a);
        a = new modelerApp("Crucetas", partB[1]);
        liPartCoPiAzPi.add(a);
        a = new modelerApp("Nivel", partB[2]);
        liPartCoPiAzPi.add(a);
        a = new modelerApp("Paleta", partB[3]);
        liPartCoPiAzPi.add(a);
        adapPartCoPiAzPi.notifyDataSetChanged();
    }

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}
