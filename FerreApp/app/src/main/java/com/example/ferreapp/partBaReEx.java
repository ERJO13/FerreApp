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

import com.example.ferreapp.databinding.ActivityPartBaReExBinding;

import java.util.ArrayList;
import java.util.List;

public class partBaReEx extends AppCompatActivity {

    private ActivityPartBaReExBinding binding;
    private List<modelerApp> liPartBaReEx;
    private adapterPartBaReEx adapPartBaReEx;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartBaReExBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartBaReEx= new ArrayList<>();
        adapPartBaReEx = new adapterPartBaReEx(this,liPartBaReEx);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartBaReEx);

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
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Tubo cortinero", partB[0]);
        liPartBaReEx.add(a);
        a = new modelerApp("Cortina", partB[1]);
        liPartBaReEx.add(a);
        a = new modelerApp("Canaleta", partB[2]);
        liPartBaReEx.add(a);
        a = new modelerApp("Puertas", partB[3]);
        liPartBaReEx.add(a);
        a = new modelerApp("Porta-rollo", partB[4]);
        liPartBaReEx.add(a);
        a = new modelerApp("Porta-jabón", partB[5]);
        liPartBaReEx.add(a);
        a = new modelerApp("Porta-toalla", partB[6]);
        liPartBaReEx.add(a);
        adapPartBaReEx.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Taquetes", partB[0]);
        liPartBaReEx.add(a);
        a = new modelerApp("Rotomartillo", partB[1]);
        liPartBaReEx.add(a);
        a = new modelerApp("Broca", partB[2]);
        liPartBaReEx.add(a);
        a = new modelerApp("Pijas", partB[3]);
        liPartBaReEx.add(a);
        a = new modelerApp("Silicon", partB[4]);
        liPartBaReEx.add(a);
        a = new modelerApp("Pistola de silicon", partB[5]);
        liPartBaReEx.add(a);
        adapPartBaReEx.notifyDataSetChanged();
    }



    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}