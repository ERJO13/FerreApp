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

import com.example.ferreapp.databinding.ActivityPartCoSagDesBinding;

import java.util.ArrayList;
import java.util.List;

public class partCoSagDes extends AppCompatActivity {

    private ActivityPartCoSagDesBinding binding;
    private List<modelerApp> liPartCoSagDes;
    private adapterPartCoSagDes adapPartCoSagDes;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartCoSagDesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liPartCoSagDes = new ArrayList<>();
        adapPartCoSagDes = new adapterPartCoSagDes(this,liPartCoSagDes);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapPartCoSagDes);

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

        };
        modelerApp a = new modelerApp(
                "Cespol tipo p", partB[0]);
        liPartCoSagDes.add(a);
        a = new modelerApp("Cespol con contracanasta", partB[1]);
        liPartCoSagDes.add(a);
        a = new modelerApp("Cespol de bote", partB[2]);
        liPartCoSagDes.add(a);
        a = new modelerApp("Cespol de cilindro", partB[3]);
        liPartCoSagDes.add(a);
        a = new modelerApp("Cespol flexible", partB[4]);
        liPartCoSagDes.add(a);

        adapPartCoSagDes.notifyDataSetChanged();
    }
    private void InsertDataIntoCardsHer() {
        // add the cards data
        int[] partB = new int[]{
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
                R.drawable.enconstruccion,
        };
        modelerApp a = new modelerApp(
                "Sellador", partB[0]);
        liPartCoSagDes.add(a);
        a = new modelerApp("Llave Stillson", partB[1]);
        liPartCoSagDes.add(a);
        a = new modelerApp("llave inglesa", partB[2]);
        liPartCoSagDes.add(a);

        adapPartCoSagDes.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}