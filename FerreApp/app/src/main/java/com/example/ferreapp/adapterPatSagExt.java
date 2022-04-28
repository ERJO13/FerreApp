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

public class adapterPatSagExt extends RecyclerView.Adapter<adapterPatSagExt.MyViewHolderPatSagExt>{
    private Context contextPatSagExt;
    private List<modelerApp> liPatSagExtList;


    public class MyViewHolderPatSagExt extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPatSagExt(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterPatSagExt(Context contextPatSagExt, List<modelerApp> liPatSagExtList) {
        this.contextPatSagExt = contextPatSagExt;
        this.liPatSagExtList = liPatSagExtList;
    }

    @NonNull
    @Override
    public MyViewHolderPatSagExt onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPatSagExt(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPatSagExt holder, int position) {
        final modelerApp modeler = liPatSagExtList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPatSagExt)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagExt, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPatSagExt, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPatSagExtList.size();
    }
}
