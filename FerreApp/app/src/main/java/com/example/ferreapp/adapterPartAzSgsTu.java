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

public class adapterPartAzSgsTu extends RecyclerView.Adapter<adapterPartAzSgsTu.MyViewHolderPartAzSgsTu> {
    private Context contextPartAzSgsTu;
    private List<modelerApp> liPartAzSgsTu;

    public class MyViewHolderPartAzSgsTu extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartAzSgsTu(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartAzSgsTu(Context contextPartAzSgsTu, List<modelerApp> liPartAzSgsTu) {
        this.contextPartAzSgsTu = contextPartAzSgsTu;
        this.liPartAzSgsTu = liPartAzSgsTu;
    }

    @NonNull
    @Override
    public MyViewHolderPartAzSgsTu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartAzSgsTu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartAzSgsTu holder, int position) {
        final modelerApp modeler = liPartAzSgsTu.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartAzSgsTu)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartAzSgsTu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartAzSgsTu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartAzSgsTu.size();
    }


}
