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

import com.example.ferreapp.databinding.ActivityCompGeArGeBinding;

import java.util.ArrayList;
import java.util.List;

public class compGeArGe extends AppCompatActivity {

    private ActivityCompGeArGeBinding binding;
    private List<modelerApp> liCompGeArGe;
    private adapterCompGeArGe adapCompGeArGe;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCompGeArGeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liCompGeArGe = new ArrayList<>();
        adapCompGeArGe = new adapterCompGeArGe(this,liCompGeArGe);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapCompGeArGe);

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
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,

        };
        modelerApp a = new modelerApp(
                "Puerta", partB[0]);
        liCompGeArGe.add(a);
        a = new modelerApp("Persianas", partB[1]);
        liCompGeArGe.add(a);
        a = new modelerApp("Cerradura", partB[2]);
        liCompGeArGe.add(a);
        a = new modelerApp("Enchufes de luz", partB[3]);
        liCompGeArGe.add(a);
        a = new modelerApp("Lamparas de techo", partB[4]);
        liCompGeArGe.add(a);
        a = new modelerApp("Pintar una casa", partB[5]);
        liCompGeArGe.add(a);
        a = new modelerApp("Resanar pared", partB[6]);
        liCompGeArGe.add(a);
        a = new modelerApp("Mosquitero", partB[7]);
        liCompGeArGe.add(a);


        adapCompGeArGe.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}