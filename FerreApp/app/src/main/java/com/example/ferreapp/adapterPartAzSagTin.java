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

public class adapterPartAzSagTin extends RecyclerView.Adapter<adapterPartAzSagTin.MyViewHolderPartAzSagTin> {
    private Context contextPartAzSagTin;
    private List<modelerApp> liPartAzSagTin;

    public class MyViewHolderPartAzSagTin extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartAzSagTin(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartAzSagTin(Context contextPartAzSagTin, List<modelerApp> liPartAzSagTin) {
        this.contextPartAzSagTin = contextPartAzSagTin;
        this.liPartAzSagTin = liPartAzSagTin;
    }

    @NonNull
    @Override
    public MyViewHolderPartAzSagTin onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartAzSagTin(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartAzSagTin holder, int position) {
        final modelerApp modeler = liPartAzSagTin.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartAzSagTin)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartAzSagTin, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartAzSagTin, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartAzSagTin.size();
    }
}
