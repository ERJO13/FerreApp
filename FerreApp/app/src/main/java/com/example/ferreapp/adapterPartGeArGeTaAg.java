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

public class adapterPartGeArGeTaAg extends RecyclerView.Adapter<adapterPartGeArGeTaAg.MyViewHolderPartGeArGeTaAg> {
    private Context contextPartGeArGeTaAg;
    private List<modelerApp> liPartGeArGeTaAg;

    public class MyViewHolderPartGeArGeTaAg extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartGeArGeTaAg(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartGeArGeTaAg(Context contextPartGeArGeTaAg, List<modelerApp> liPartGeArGeTaAg) {
        this.contextPartGeArGeTaAg = contextPartGeArGeTaAg;
        this.liPartGeArGeTaAg = liPartGeArGeTaAg;
    }
    @NonNull
    @Override
    public MyViewHolderPartGeArGeTaAg onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartGeArGeTaAg(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartGeArGeTaAg holder, int position) {
        final modelerApp modeler = liPartGeArGeTaAg.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartGeArGeTaAg)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGeTaAg, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGeTaAg, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartGeArGeTaAg.size();
    }
}
