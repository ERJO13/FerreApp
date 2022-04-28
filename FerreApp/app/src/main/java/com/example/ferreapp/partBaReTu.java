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

import com.example.ferreapp.databinding.ActivityPartBaReTuBinding;

import java.util.ArrayList;
import java.util.List;

public class partBaReTu extends AppCompatActivity {

    private ActivityPartBaReTuBinding binding;
    private List<modelerApp> liPartBaReTu;
    private adapterPartBaReTu adapPartBaReTu;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartBaReTuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartBaReTu= new ArrayList<>();
        adapPartBaReTu = new adapterPartBaReTu(this,liPartBaReTu);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartBaReTu);

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
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "Teflón", partB[0]);
        liPartBaReTu.add(a);
        a = new modelerApp("Llave stillson", partB[1]);
        liPartBaReTu.add(a);
        a = new modelerApp("Llave inglesa", partB[2]);
        liPartBaReTu.add(a);
        adapPartBaReTu.notifyDataSetChanged();
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
                "Regadera", partB[0]);
        liPartBaReTu.add(a);
        a = new modelerApp("Brazo", partB[1]);
        liPartBaReTu.add(a);
        a = new modelerApp("Llaves soldables", partB[2]);
        liPartBaReTu.add(a);
        a = new modelerApp("Manerales", partB[3]);
        liPartBaReTu.add(a);
        a = new modelerApp("Monomando", partB[4]);
        liPartBaReTu.add(a);

        adapPartBaReTu.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}