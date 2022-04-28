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

public class adapterPatSagMan extends RecyclerView.Adapter<adapterPatSagMan.MyViewHolderPatSagMan>{
    private Context contextPatSagMan;
    private List<modelerApp> liPatSagManList;


    public class MyViewHolderPatSagMan extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPatSagMan(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPatSagMan(Context contextPatSagMan, List<modelerApp> liPatSagManList) {
        this.contextPatSagMan = contextPatSagMan;
        this.liPatSagManList = liPatSagManList;
    }
    @NonNull
    @Override
    public MyViewHolderPatSagMan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPatSagMan(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPatSagMan holder, int position) {
        final modelerApp modeler = liPatSagManList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPatSagMan)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagMan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagMan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liPatSagManList.size();
    }
}
