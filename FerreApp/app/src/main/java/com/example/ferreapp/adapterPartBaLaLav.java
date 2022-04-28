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

public class adapterPartBaLaLav extends RecyclerView.Adapter<adapterPartBaLaLav.MyViewHolderPartBaLaLav> {

    private Context contextPartBaLaLav;
    private List<modelerApp> liPartBaLaLav;

    public class MyViewHolderPartBaLaLav extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartBaLaLav(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartBaLaLav(Context contextPartBaLaLav, List<modelerApp> liPartBaLaLav) {
        this.contextPartBaLaLav = contextPartBaLaLav;
        this.liPartBaLaLav = liPartBaLaLav;
    }
    @NonNull
    @Override
    public MyViewHolderPartBaLaLav onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartBaLaLav(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartBaLaLav holder, int position) {
        final modelerApp modeler = liPartBaLaLav.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartBaLaLav)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaLaLav, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaLaLav, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartBaLaLav.size();
    }
}
