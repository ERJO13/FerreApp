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

public class adapterEscJa extends RecyclerView.Adapter<adapterEscJa.MyViewHolderJa>{

    private Context contextCompJa;
    private List<modelerApp> liPartJaList;

    public class MyViewHolderJa extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderJa(@NonNull View itemView) {
            super(itemView);
            /*Initialize the view*/
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterEscJa(Context contextCompJa, List<modelerApp> liPartJaList) {
        this.contextCompJa = contextCompJa;
        this.liPartJaList = liPartJaList;
    }

    @NonNull
    @Override
    public MyViewHolderJa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderJa(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderJa holder, int position) {
        final modelerApp modeler = liPartJaList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompJa)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextCompJa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextCompJa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartJaList.size();
    }

}
