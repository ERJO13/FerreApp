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

public class adapterPatSagCon extends RecyclerView.Adapter<adapterPatSagCon.MyViewHolderPatSagCon>{

    private Context contextPatSagCon;
    private List<modelerApp> liPatSagConList;



    public class MyViewHolderPatSagCon extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPatSagCon(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPatSagCon(Context contextPatSagCon, List<modelerApp> liPatSagConList) {
        this.contextPatSagCon = contextPatSagCon;
        this.liPatSagConList = liPatSagConList;
    }
    @NonNull
    @Override
    public MyViewHolderPatSagCon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPatSagCon(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPatSagCon holder, int position) {
        final modelerApp modeler = liPatSagConList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPatSagCon)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagCon, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagCon, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liPatSagConList.size();
    }
}
