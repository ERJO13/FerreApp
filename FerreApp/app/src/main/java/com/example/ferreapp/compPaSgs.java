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

import com.example.ferreapp.databinding.ActivityCompPaSgsBinding;

import java.util.ArrayList;
import java.util.List;

public class compPaSgs extends AppCompatActivity {

    private ActivityCompPaSgsBinding binding;
    private List<modelerApp> liCompPaSgsList;
    private adapterCompPaSgs adapCompPaSgs;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCompPaSgsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        recyclerView = findViewById(R.id.recycler_escenario);
        liCompPaSgsList = new ArrayList<>();
        adapCompPaSgs = new adapterCompPaSgs(this,liCompPaSgsList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapCompPaSgs);

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
        };
        modelerApp a = new modelerApp(
                "Tuberias", partB[0]);
        liCompPaSgsList.add(a);
        a = new modelerApp("Llaves de paso", partB[1]);
        liCompPaSgsList.add(a);
        a = new modelerApp("Reguladores", partB[2]);
        liCompPaSgsList.add(a);
        a = new modelerApp("Mangueras", partB[3]);
        liCompPaSgsList.add(a);
        a = new modelerApp("Pigtail", partB[4]);
        liCompPaSgsList.add(a);

        adapCompPaSgs.notifyDataSetChanged();
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }


}