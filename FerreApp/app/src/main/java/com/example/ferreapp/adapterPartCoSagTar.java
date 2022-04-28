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

public class adapterPartCoSagTar extends RecyclerView.Adapter<adapterPartCoSagTar.MyViewHolderPartCoSagTar> {
    private Context contextPartCoSagTar;
    private List<modelerApp> liPartCoSagTar;

    public class MyViewHolderPartCoSagTar extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartCoSagTar(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartCoSagTar(Context contextPartCoSagTar, List<modelerApp> liPartCoSagTar) {
        this.contextPartCoSagTar = contextPartCoSagTar;
        this.liPartCoSagTar = liPartCoSagTar;
    }


    @NonNull
    @Override
    public MyViewHolderPartCoSagTar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartCoSagTar(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartCoSagTar holder, int position) {
        final modelerApp modeler = liPartCoSagTar.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartCoSagTar)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartCoSagTar, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartCoSagTar, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartCoSagTar.size();
    }

}
