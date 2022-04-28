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

import com.example.ferreapp.databinding.ActivityPartGeArGePinCaBinding;

import java.util.ArrayList;
import java.util.List;

public class partGeArGePinCa extends AppCompatActivity {

    private ActivityPartGeArGePinCaBinding binding;
    private List<modelerApp> liPartGeArGePinCa;
    private adapterPartGeArGePinCa adapPartGeArGePinCa;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartGeArGePinCaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartGeArGePinCa = new ArrayList<>();
        adapPartGeArGePinCa = new adapterPartGeArGePinCa(this,liPartGeArGePinCa);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartGeArGePinCa);

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
                "Pared despintada", partB[0]);
        liPartGeArGePinCa.add(a);

        adapPartGeArGePinCa.notifyDataSetChanged();
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
                "Pintura", partB[0]);
        liPartGeArGePinCa.add(a);
        a = new modelerApp("Espatula", partB[1]);
        liPartGeArGePinCa.add(a);
        a = new modelerApp("Brocha", partB[2]);
        liPartGeArGePinCa.add(a);
        a = new modelerApp("Rodillo", partB[3]);
        liPartGeArGePinCa.add(a);
        a = new modelerApp("Porta-Espatula", partB[4]);
        liPartGeArGePinCa.add(a);

        adapPartGeArGePinCa.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}