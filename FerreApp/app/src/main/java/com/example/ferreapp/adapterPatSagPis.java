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

public class adapterPatSagPis extends RecyclerView.Adapter<adapterPatSagPis.MyViewHolderPatSagPis>{
    private Context contextPatSagPis;
    private List<modelerApp> liPatSagPis;

    public class MyViewHolderPatSagPis extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPatSagPis(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPatSagPis(Context contextPatSagPis, List<modelerApp> liPatSagPis) {
        this.contextPatSagPis = contextPatSagPis;
        this.liPatSagPis = liPatSagPis;
    }
    @NonNull
    @Override
    public MyViewHolderPatSagPis onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPatSagPis(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPatSagPis holder, int position) {
        final modelerApp modeler = liPatSagPis.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPatSagPis)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagPis, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagPis, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liPatSagPis.size();
    }
}
