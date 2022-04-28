package com.example.ferreapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.ferreapp.databinding.ActivityEscBathroomBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class escBathroom extends AppCompatActivity {

    private ActivityEscBathroomBinding binding;
    private List<modelerApp> liPartBList;
    private adapterEscB adapPartB;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEscBathroomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        recyclerView = findViewById(R.id.recycler_escenario);
        liPartBList = new ArrayList<>();
        adapPartB = new adapterEscB(this,liPartBList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartB);
        //Intent i = getIntent();
        //boolean b = i.getBooleanExtra("decide", true);
        //Toast.makeText(getApplicationContext(), "La decision "+b, Toast.LENGTH_LONG).show();

        // preparing the data
        InsertDataIntoCards();


    }
    private void InsertDataIntoCards() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.area_escusado,
                R.drawable.area_regadera,
                R.drawable.area_lavabo,

        };

        modelerApp a = new modelerApp(
                "Area de escusado", partB[0]);
        liPartBList.add(a);
        a = new modelerApp("Area de regadera", partB[1]);
        liPartBList.add(a);
        a = new modelerApp("Area de lavabo", partB[2]);
        liPartBList.add(a);

        adapPartB.notifyDataSetChanged();
    }



    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }

}