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

public class adapterPatSagLla extends RecyclerView.Adapter<adapterPatSagLla.MyViewHolderPatSagLla>{
    private Context contextPatSagLla;
    private List<modelerApp> liPatSagLlaList;


    public class MyViewHolderPatSagLla extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPatSagLla(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPatSagLla(Context contextPatSagLla, List<modelerApp> liPatSagLlaList) {
        this.contextPatSagLla = contextPatSagLla;
        this.liPatSagLlaList = liPatSagLlaList;
    }

    @NonNull
    @Override
    public MyViewHolderPatSagLla onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPatSagLla(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPatSagLla holder, int position) {
        final modelerApp modeler = liPatSagLlaList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPatSagLla)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagLla, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagLla, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPatSagLlaList.size();
    }
}
