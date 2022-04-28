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

public class adapterPartGeArGePu extends RecyclerView.Adapter<adapterPartGeArGePu.MyViewHolderPartGeArGePu> {
    private Context contextPartGeArGePu;
    private List<modelerApp> liPartGeArGePu;

    public class MyViewHolderPartGeArGePu extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartGeArGePu(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartGeArGePu(Context contextPartGeArGePu, List<modelerApp> liPartGeArGePu) {
        this.contextPartGeArGePu = contextPartGeArGePu;
        this.liPartGeArGePu = liPartGeArGePu;
    }
    @NonNull
    @Override
    public MyViewHolderPartGeArGePu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartGeArGePu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartGeArGePu holder, int position) {
        final modelerApp modeler = liPartGeArGePu.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartGeArGePu)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGePu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGePu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartGeArGePu.size();
    }


}
