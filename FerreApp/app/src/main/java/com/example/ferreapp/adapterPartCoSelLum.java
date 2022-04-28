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

public class adapterPartCoSelLum extends RecyclerView.Adapter<adapterPartCoSelLum.MyViewHolderPartCoSelLum> {
    private Context contextPartCoSelLum;
    private List<modelerApp> liPartCoSelLum;


    public class MyViewHolderPartCoSelLum extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderPartCoSelLum(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartCoSelLum(Context contextPartCoSelLum, List<modelerApp> liPartCoSelLum) {
        this.contextPartCoSelLum = contextPartCoSelLum;
        this.liPartCoSelLum = liPartCoSelLum;
    }
    @NonNull
    @Override
    public MyViewHolderPartCoSelLum onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartCoSelLum(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartCoSelLum holder, int position) {
        final modelerApp modeler = liPartCoSelLum.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartCoSelLum)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoSelLum, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoSelLum, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartCoSelLum.size();
    }

}
