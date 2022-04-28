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

public class adapterPartBaLaLle extends RecyclerView.Adapter<adapterPartBaLaLle.MyViewHolderPartBaLaLle> {
    private Context contextPartBaLaLle;
    private List<modelerApp> liPartBaLaLle;

    public class MyViewHolderPartBaLaLle extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartBaLaLle(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartBaLaLle(Context contextPartBaLaLle, List<modelerApp> liPartBaLaLle) {
        this.contextPartBaLaLle = contextPartBaLaLle;
        this.liPartBaLaLle = liPartBaLaLle;
    }
    @NonNull
    @Override
    public MyViewHolderPartBaLaLle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartBaLaLle(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartBaLaLle holder, int position) {
        final modelerApp modeler = liPartBaLaLle.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartBaLaLle)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaLaLle, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaLaLle, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartBaLaLle.size();
    }

}
