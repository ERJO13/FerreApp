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

public class adapterPartCoSagLle extends RecyclerView.Adapter<adapterPartCoSagLle.MyViewHolderPartCoSagLle> {
    private Context contextPartCoSagLle;
    private List<modelerApp> liPartCoSagLle;

    public class MyViewHolderPartCoSagLle extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartCoSagLle(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartCoSagLle(Context contextPartCoSagLle, List<modelerApp> liPartCoSagLle) {
        this.contextPartCoSagLle = contextPartCoSagLle;
        this.liPartCoSagLle = liPartCoSagLle;
    }
    @NonNull
    @Override
    public MyViewHolderPartCoSagLle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartCoSagLle(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartCoSagLle holder, int position) {
        final modelerApp modeler = liPartCoSagLle.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartCoSagLle)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartCoSagLle, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartCoSagLle, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartCoSagLle.size();
    }


}
