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

public class adapterPartBaLaDes extends RecyclerView.Adapter<adapterPartBaLaDes.MyViewHolderPartBaLaDes> {
    private Context contextPartBaLaDes;
    private List<modelerApp> liPartBaLaDes;

    public class MyViewHolderPartBaLaDes extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartBaLaDes(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartBaLaDes(Context contextPartBaLaDes, List<modelerApp> liPartBaLaDes) {
        this.contextPartBaLaDes = contextPartBaLaDes;
        this.liPartBaLaDes = liPartBaLaDes;
    }
    @NonNull
    @Override
    public MyViewHolderPartBaLaDes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartBaLaDes(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartBaLaDes holder, int position) {
        final modelerApp modeler = liPartBaLaDes.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartBaLaDes)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaLaDes, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaLaDes, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartBaLaDes.size();
    }
}
