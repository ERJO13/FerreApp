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

public class adapterPartAzSagTu extends RecyclerView.Adapter<adapterPartAzSagTu.MyViewHolderPartAzSagTu> {
    private Context contextPartAzSagTu;
    private List<modelerApp> liPartAzSagTu;

    public class MyViewHolderPartAzSagTu extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartAzSagTu(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartAzSagTu(Context contextPartAzSagTu, List<modelerApp> liPartAzSagTu) {
        this.contextPartAzSagTu = contextPartAzSagTu;
        this.liPartAzSagTu = liPartAzSagTu;
    }

    @NonNull
    @Override
    public MyViewHolderPartAzSagTu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartAzSagTu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartAzSagTu holder, int position) {
        final modelerApp modeler = liPartAzSagTu.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartAzSagTu)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartAzSagTu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartAzSagTu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartAzSagTu.size();
    }
}
