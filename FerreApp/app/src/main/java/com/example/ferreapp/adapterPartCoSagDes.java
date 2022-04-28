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

public class adapterPartCoSagDes extends RecyclerView.Adapter<adapterPartCoSagDes.MyViewHolderPartCoSagDes> {
    private Context contextPartCoSagDes;
    private List<modelerApp> liPartCoSagDes;


    public class MyViewHolderPartCoSagDes extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartCoSagDes(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartCoSagDes(Context contextPartCoSagDes, List<modelerApp> liPartCoSagDes) {
        this.contextPartCoSagDes = contextPartCoSagDes;
        this.liPartCoSagDes = liPartCoSagDes;
    }

    @NonNull
    @Override
    public MyViewHolderPartCoSagDes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartCoSagDes(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartCoSagDes holder, int position) {
        final modelerApp modeler = liPartCoSagDes.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartCoSagDes)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartCoSagDes, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartCoSagDes, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartCoSagDes.size();
    }
}
