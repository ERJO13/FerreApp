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

public class adapterPartBaEsTan extends RecyclerView.Adapter<adapterPartBaEsTan.MyViewHolderPartBaEsTan> {
    private Context contextPartBaEsTan;
    private List<modelerApp> liPartBaEsTan;

    public class MyViewHolderPartBaEsTan extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartBaEsTan(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartBaEsTan(Context contextPartBaEsTan, List<modelerApp> liPartBaEsTan) {
        this.contextPartBaEsTan = contextPartBaEsTan;
        this.liPartBaEsTan = liPartBaEsTan;
    }

    @NonNull
    @Override
    public MyViewHolderPartBaEsTan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartBaEsTan(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartBaEsTan holder, int position) {
        final modelerApp modeler = liPartBaEsTan.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartBaEsTan)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaEsTan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartBaEsTan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartBaEsTan.size();
    }


}
