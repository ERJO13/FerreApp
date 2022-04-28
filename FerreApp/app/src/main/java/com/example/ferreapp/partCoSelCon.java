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

import com.example.ferreapp.databinding.ActivityPartCoSelConBinding;

import java.util.ArrayList;
import java.util.List;

public class partCoSelCon extends AppCompatActivity {

    private ActivityPartCoSelConBinding binding;
    private List<modelerApp> liPartCoSelCon;
    private adapterPartCoSelCon adapPartCoSelCon;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartCoSelConBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartCoSelCon = new ArrayList<>();
        adapPartCoSelCon = new adapterPartCoSelCon(this,liPartCoSelCon);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartCoSelCon);

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
                "Cable", partB[0]);
        liPartCoSelCon.add(a);
        a = new modelerApp("Alambre", partB[1]);
        liPartCoSelCon.add(a);
        a = new modelerApp("Placa", partB[2]);
        liPartCoSelCon.add(a);
        a = new modelerApp("Apagador", partB[3]);
        liPartCoSelCon.add(a);
        a = new modelerApp("Contacto", partB[4]);
        liPartCoSelCon.add(a);
        adapPartCoSelCon.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "Pinzas de corte", partB[0]);
        liPartCoSelCon.add(a);
        a = new modelerApp("Destornillador de cruz", partB[1]);
        liPartCoSelCon.add(a);
        a = new modelerApp("Multimetro", partB[2]);
        liPartCoSelCon.add(a);
        adapPartCoSelCon.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
        }
}
