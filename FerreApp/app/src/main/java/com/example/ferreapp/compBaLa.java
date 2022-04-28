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

import com.example.ferreapp.databinding.ActivityCompBaLaBinding;

import java.util.ArrayList;
import java.util.List;

public class compBaLa extends AppCompatActivity {

    private ActivityCompBaLaBinding binding;
    private List<modelerApp> liPartBaLa;
    private adapterCompBaLa adapPartBaLa;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCompBaLaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        recyclerView = findViewById(R.id.recycler_escenario);
        liPartBaLa = new ArrayList<>();
        adapPartBaLa = new adapterCompBaLa(this,liPartBaLa);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartBaLa);

        // preparing the data
        InsertDataIntoCards();
    }
    private void InsertDataIntoCards() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.lavabo,
                R.drawable.desague,
                R.drawable.llenado,
        };
        modelerApp a = new modelerApp(
                "Lavabo", partB[0]);
        liPartBaLa.add(a);
        a = new modelerApp("Drenado", partB[1]);
        liPartBaLa.add(a);
        a = new modelerApp("Llenado", partB[2]);
        liPartBaLa.add(a);

        adapPartBaLa.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }

}