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

public class adapterPartPaSgsMan extends RecyclerView.Adapter<adapterPartPaSgsMan.MyViewHolderPartPaSgsMan>{

    private Context contextPartPaSgsMan;
    private List<modelerApp> liPartPaSgsManList;

    public class MyViewHolderPartPaSgsMan extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartPaSgsMan(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPartPaSgsMan(Context contextPartPaSgsMan, List<modelerApp> liPartPaSgsManList) {
        this.contextPartPaSgsMan = contextPartPaSgsMan;
        this.liPartPaSgsManList = liPartPaSgsManList;
    }
    @NonNull
    @Override
    public MyViewHolderPartPaSgsMan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartPaSgsMan(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartPaSgsMan holder, int position) {
        final modelerApp modeler = liPartPaSgsManList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartPaSgsMan)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartPaSgsMan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartPaSgsMan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartPaSgsManList.size();
    }

}
