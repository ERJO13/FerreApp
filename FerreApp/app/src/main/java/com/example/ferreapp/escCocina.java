package com.example.ferreapp;

import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;

import com.example.ferreapp.databinding.ActivityEscCocinaBinding;

import java.util.ArrayList;
import java.util.List;

public class escCocina extends AppCompatActivity {

    private ActivityEscCocinaBinding binding;

    private List<modelerApp> liCompCoList;
    private adapterEscCo adapCompCo;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEscCocinaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        recyclerView = findViewById(R.id.recycler_escenario);
        liCompCoList = new ArrayList<>();
        adapCompCo = new adapterEscCo(this,liCompCoList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapCompCo);

        // preparing the data
        InsertDataIntoCards();


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
                "Sistema de agua", partB[0]);
        liCompCoList.add(a);
        a = new modelerApp("Sistema de gas", partB[1]);
        liCompCoList.add(a);
        a = new modelerApp("Sistema electrico", partB[2]);
        liCompCoList.add(a);
        a = new modelerApp("Piso", partB[3]);
        liCompCoList.add(a);

        adapCompCo.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}