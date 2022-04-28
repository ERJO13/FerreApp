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

public class adapterPartBaEsEs extends RecyclerView.Adapter<adapterPartBaEsEs.MyViewHolderPartBaEsEs> {
    private Context contextPartBaEsEs;
    private List<modelerApp> liPartBaEsEs;

    public class MyViewHolderPartBaEsEs extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartBaEsEs(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartBaEsEs(Context contextPartBaEsEs, List<modelerApp> liPartBaEsEs) {
        this.contextPartBaEsEs = contextPartBaEsEs;
        this.liPartBaEsEs = liPartBaEsEs;
    }

    @NonNull
    @Override
    public MyViewHolderPartBaEsEs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartBaEsEs(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartBaEsEs holder, int position) {
        final modelerApp modeler = liPartBaEsEs.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartBaEsEs)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaEsEs, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaEsEs, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartBaEsEs.size();
    }

}
