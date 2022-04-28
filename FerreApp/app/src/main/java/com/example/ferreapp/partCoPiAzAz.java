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

import com.example.ferreapp.databinding.ActivityPartCoPiAzAzBinding;

import java.util.ArrayList;
import java.util.List;

public class partCoPiAzAz extends AppCompatActivity {

    private ActivityPartCoPiAzAzBinding binding;
    private List<modelerApp> liPartCoPiAzAz;
    private adapterPartCoPiAzAz adapPartCoPiAzAz;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartCoPiAzAzBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartCoPiAzAz = new ArrayList<>();
        adapPartCoPiAzAz = new adapterPartCoPiAzAz(this,liPartCoPiAzAz);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartCoPiAzAz);

        // preparing the data
        Intent i = getIntent();
        boolean b = i.getBooleanExtra("decide", true);

        if(b){
            InsertDataIntoCards();}
        else{
            InsertDataIntoCardsHer();
        }
    }

    private void InsertDataIntoCardsHer() {
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Corta-Azulejo", partB[0]);
        liPartCoPiAzAz.add(a);
        a = new modelerApp("Nivel", partB[1]);
        liPartCoPiAzAz.add(a);
        a = new modelerApp("Crucetas", partB[2]);
        liPartCoPiAzAz.add(a);
        a = new modelerApp("Esponjas", partB[3]);
        liPartCoPiAzAz.add(a);
        a = new modelerApp("Paletas", partB[4]);
        liPartCoPiAzAz.add(a);
        a = new modelerApp("Crucetas", partB[5]);
        liPartCoPiAzAz.add(a);
        adapPartCoPiAzAz.notifyDataSetChanged();
    }

    private void InsertDataIntoCards() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "Azulejo", partB[0]);
        liPartCoPiAzAz.add(a);
        a = new modelerApp("PegaAzulejo", partB[1]);
        liPartCoPiAzAz.add(a);
        a = new modelerApp("Junteador", partB[2]);
        liPartCoPiAzAz.add(a);
        adapPartCoPiAzAz.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}