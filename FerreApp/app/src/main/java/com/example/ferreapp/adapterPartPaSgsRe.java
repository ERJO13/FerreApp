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

public class adapterPartPaSgsRe extends RecyclerView.Adapter<adapterPartPaSgsRe.MyViewHolderPartPaSgsRe>{

    private Context contextPartPaSgsRe;
    private List<modelerApp> liPartPaSgsReList;

    public class MyViewHolderPartPaSgsRe extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartPaSgsRe(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPartPaSgsRe(Context contextPartPaSgsRe, List<modelerApp> liPartPaSgsReList) {
        this.contextPartPaSgsRe = contextPartPaSgsRe;
        this.liPartPaSgsReList = liPartPaSgsReList;
    }


    @NonNull
    @Override
    public MyViewHolderPartPaSgsRe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartPaSgsRe(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartPaSgsRe holder, int position) {
        final modelerApp modeler = liPartPaSgsReList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartPaSgsRe)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartPaSgsRe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartPaSgsRe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartPaSgsReList.size();
    }


}
