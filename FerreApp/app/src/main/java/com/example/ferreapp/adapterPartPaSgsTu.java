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

public class adapterPartPaSgsTu extends RecyclerView.Adapter<adapterPartPaSgsTu.MyViewHolderPartPaSgsTu>{

    private Context contextPartPaSgsTu;
    private List<modelerApp> liPartPaSgsTuList;

    public class MyViewHolderPartPaSgsTu extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartPaSgsTu(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPartPaSgsTu(Context contextPartPaSgsTu, List<modelerApp> liPartPaSgsTuList) {
        this.contextPartPaSgsTu = contextPartPaSgsTu;
        this.liPartPaSgsTuList = liPartPaSgsTuList;
    }
    @NonNull
    @Override
    public MyViewHolderPartPaSgsTu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartPaSgsTu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartPaSgsTu holder, int position) {
        final modelerApp modeler = liPartPaSgsTuList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartPaSgsTu)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartPaSgsTu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartPaSgsTu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartPaSgsTuList.size();
    }


}
