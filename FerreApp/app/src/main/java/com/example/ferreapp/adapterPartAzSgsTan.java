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

public class adapterPartAzSgsTan extends RecyclerView.Adapter<adapterPartAzSgsTan.MyViewHolderPartAzSgsTan> {
    private Context contextPartAzSgsTan;
    private List<modelerApp> liPartAzSgsTan;

    public class MyViewHolderPartAzSgsTan extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartAzSgsTan(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartAzSgsTan(Context contextPartAzSgsTan, List<modelerApp> liPartAzSgsTan) {
        this.contextPartAzSgsTan = contextPartAzSgsTan;
        this.liPartAzSgsTan = liPartAzSgsTan;
    }

    @NonNull
    @Override
    public MyViewHolderPartAzSgsTan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartAzSgsTan(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartAzSgsTan holder, int position) {
        final modelerApp modeler = liPartAzSgsTan.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartAzSgsTan)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartAzSgsTan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartAzSgsTan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartAzSgsTan.size();
    }
}
