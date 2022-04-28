package com.example.ferreapp;

import android.content.res.Resources;
import android.os.Bundle;

import com.example.ferreapp.databinding.ActivityCompBaReBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

public class compBaRe extends AppCompatActivity {

    private ActivityCompBaReBinding binding;
    private List<modelerApp> liPartBaReList;
    private adapterCompBaRe adapPartBaRe;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCompBaReBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        recyclerView = findViewById(R.id.recycler_escenario);
        liPartBaReList = new ArrayList<>();
        adapPartBaRe = new adapterCompBaRe(this,liPartBaReList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartBaRe);

        // preparing the data
        InsertDataIntoCards();
    }
    private void InsertDataIntoCards() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.regadera,
                R.drawable.area_regadera,
        };
        modelerApp a = new modelerApp(
                "Tuberia", partB[0]);
        liPartBaReList.add(a);
        a = new modelerApp("Extra", partB[1]);
        liPartBaReList.add(a);

        adapPartBaRe.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}