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

import com.example.ferreapp.databinding.ActivityPartCoSagLleBinding;

import java.util.ArrayList;
import java.util.List;

public class partCoSagLle extends AppCompatActivity {

    private ActivityPartCoSagLleBinding binding;
    private List<modelerApp> liPartCoSagLle;
    private adapterPartCoSagLle adapPartCoSagLle;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartCoSagLleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartCoSagLle = new ArrayList<>();
        adapPartCoSagLle = new adapterPartCoSagLle(this,liPartCoSagLle);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartCoSagLle);

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
                "Manguera de aluminio", partB[0]);
        liPartCoSagLle.add(a);
        a = new modelerApp("Llave angular de paso", partB[1]);
        liPartCoSagLle.add(a);
        a = new modelerApp("Mezcladora", partB[2]);
        liPartCoSagLle.add(a);
        a = new modelerApp("Monomando", partB[3]);
        liPartCoSagLle.add(a);
        adapPartCoSagLle.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Teflón", partB[0]);
        liPartCoSagLle.add(a);
        a = new modelerApp("Llave stillson", partB[1]);
        liPartCoSagLle.add(a);
        a = new modelerApp("Llave inglesa", partB[2]);
        liPartCoSagLle.add(a);
        a = new modelerApp("Destornillador de cruz", partB[3]);
        liPartCoSagLle.add(a);
        adapPartCoSagLle.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}