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

public class adapterPartGeArGeMos extends RecyclerView.Adapter<adapterPartGeArGeMos.MyViewHolderPartGeArGeMos> {
    private Context contextPartGeArGeMos;
    private List<modelerApp> liPartGeArGeMos;

    public class MyViewHolderPartGeArGeMos extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartGeArGeMos(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartGeArGeMos(Context contextPartGeArGeMos, List<modelerApp> liPartGeArGeMos) {
        this.contextPartGeArGeMos = contextPartGeArGeMos;
        this.liPartGeArGeMos = liPartGeArGeMos;
    }

    @NonNull
    @Override
    public MyViewHolderPartGeArGeMos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartGeArGeMos(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartGeArGeMos holder, int position) {
        final modelerApp modeler = liPartGeArGeMos.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartGeArGeMos)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGeMos, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGeMos, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartGeArGeMos.size();
    }

}

