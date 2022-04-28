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

public class adapterPatSagLlagPa extends RecyclerView.Adapter<adapterPatSagLlagPa.MyViewHolderPatSagLlagPa>{
    private Context contextPatSagLlagPa;
    private List<modelerApp> liPatSagLlagPaList;


    public class MyViewHolderPatSagLlagPa extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPatSagLlagPa(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPatSagLlagPa(Context contextPatSagLlagPa, List<modelerApp> liPatSagLlagPaList) {
        this.contextPatSagLlagPa = contextPatSagLlagPa;
        this.liPatSagLlagPaList = liPatSagLlagPaList;
    }

    @NonNull
    @Override
    public MyViewHolderPatSagLlagPa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPatSagLlagPa(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPatSagLlagPa holder, int position) {
        final modelerApp modeler = liPatSagLlagPaList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPatSagLlagPa)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagLlagPa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagLlagPa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPatSagLlagPaList.size();
    }

}
