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

public class adapterPartCoPiAzPi extends RecyclerView.Adapter<adapterPartCoPiAzPi.MyViewHolderPartCoPiAzPi> {
    private Context contextPartCoPiAzPi;
    private List<modelerApp> liPartCoPiAzPi;

    public class MyViewHolderPartCoPiAzPi extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderPartCoPiAzPi(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartCoPiAzPi(Context contextPartCoPiAzPi, List<modelerApp> liPartCoPiAzPi) {
        this.contextPartCoPiAzPi = contextPartCoPiAzPi;
        this.liPartCoPiAzPi = liPartCoPiAzPi;
    }

    @NonNull
    @Override
    public MyViewHolderPartCoPiAzPi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartCoPiAzPi(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartCoPiAzPi holder, int position) {
        final modelerApp modeler = liPartCoPiAzPi.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartCoPiAzPi)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoPiAzPi, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoPiAzPi, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartCoPiAzPi.size();
    }

}
