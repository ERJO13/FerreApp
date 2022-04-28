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

public class adapterPartGeArGePer extends RecyclerView.Adapter<adapterPartGeArGePer.MyViewHolderPartGeArGePer> {
    private Context contextPartGeArGePer;
    private List<modelerApp> liPartGeArGePer;

    public class MyViewHolderPartGeArGePer extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartGeArGePer(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartGeArGePer(Context contextPartGeArGePer, List<modelerApp> liPartGeArGePer) {
        this.contextPartGeArGePer = contextPartGeArGePer;
        this.liPartGeArGePer = liPartGeArGePer;
    }
    @NonNull
    @Override
    public MyViewHolderPartGeArGePer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartGeArGePer(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartGeArGePer holder, int position) {
        final modelerApp modeler = liPartGeArGePer.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartGeArGePer)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGePer, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGePer, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartGeArGePer.size();
    }


}
