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

import com.example.ferreapp.databinding.ActivityPartCoSagTarBinding;

import java.util.ArrayList;
import java.util.List;

public class partCoSagTar extends AppCompatActivity {

    private ActivityPartCoSagTarBinding binding;
    private List<modelerApp> liPartCoSagTar;
    private adapterPartCoSagTar adapPartCoSagTar;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartCoSagTarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartCoSagTar = new ArrayList<>();
        adapPartCoSagTar = new adapterPartCoSagTar(this,liPartCoSagTar);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartCoSagTar);

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
                "1 cubeta con monomando", partB[0]);
        liPartCoSagTar.add(a);
        a = new modelerApp("2 cubetas con monomando", partB[1]);
        liPartCoSagTar.add(a);
        a = new modelerApp("1 cubeta con mezcladora", partB[2]);
        liPartCoSagTar.add(a);
        a = new modelerApp("2 cubetas con mezcladora", partB[3]);
        liPartCoSagTar.add(a);
        a = new modelerApp("1 cubeta y escurridor con monomando", partB[4]);
        liPartCoSagTar.add(a);
        a = new modelerApp("1 cubeta y escurridor con mezcladora", partB[5]);
        liPartCoSagTar.add(a);

        adapPartCoSagTar.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "Silicon transparente", partB[0]);
        liPartCoSagTar.add(a);
        a = new modelerApp("Pistola de silicon", partB[1]);
        liPartCoSagTar.add(a);
        adapPartCoSagTar.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}