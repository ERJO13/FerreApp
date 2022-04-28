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

import com.example.ferreapp.databinding.ActivityPartBaEsEsBinding;

import java.util.ArrayList;
import java.util.List;

public class partBaEsEs extends AppCompatActivity {

    private ActivityPartBaEsEsBinding binding;
    private List<modelerApp> liPartBaEsEs;
    private adapterPartBaEsEs adapPartBaEsEs;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartBaEsEsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartBaEsEs = new ArrayList<>();
        adapPartBaEsEs= new adapterPartBaEsEs(this,liPartBaEsEs);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartBaEsEs);

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
                R.drawable.asiento_bano,
                R.drawable.cuello_cera,
                R.drawable.tornillos_bano,

        };
        modelerApp a = new modelerApp(
                "Asiento", partB[0]);
        liPartBaEsEs.add(a);
        a = new modelerApp("Cuello", partB[1]);
        liPartBaEsEs.add(a);
        a = new modelerApp("Tornillos", partB[2]);
        liPartBaEsEs.add(a);

        adapPartBaEsEs.notifyDataSetChanged();
    }

    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.destornillador_plano,
                R.drawable.cemento_blanco,

        };
        modelerApp a = new modelerApp(
                "Destornillador plano", partB[0]);
        liPartBaEsEs.add(a);
        a = new modelerApp("Cemento blanco", partB[1]);
        liPartBaEsEs.add(a);

        adapPartBaEsEs.notifyDataSetChanged();
    }
    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}