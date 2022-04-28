package com.example.ferreapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adapterPartPaSgsLlaPa extends RecyclerView.Adapter<adapterPartPaSgsLlaPa.MyViewHolderPartPaSgsLlaPa>{

    private Context contextPartPaSgsLlaPa;
    private List<modelerApp> liPartPaSgsLlaPaList;

    public class MyViewHolderPartPaSgsLlaPa extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartPaSgsLlaPa(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPartPaSgsLlaPa(Context contextPartPaSgsLlaPa, List<modelerApp> liPartPaSgsLlaPaList) {
        this.contextPartPaSgsLlaPa = contextPartPaSgsLlaPa;
        this.liPartPaSgsLlaPaList = liPartPaSgsLlaPaList;
    }
    @NonNull
    @Override
    public MyViewHolderPartPaSgsLlaPa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartPaSgsLlaPa(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartPaSgsLlaPa holder, int position) {
        final modelerApp modeler = liPartPaSgsLlaPaList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartPaSgsLlaPa)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartPaSgsLlaPa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartPaSgsLlaPa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartPaSgsLlaPaList.size();
    }

}
