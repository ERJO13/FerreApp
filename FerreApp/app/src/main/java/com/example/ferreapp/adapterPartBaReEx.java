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

public class adapterPartBaReEx extends RecyclerView.Adapter<adapterPartBaReEx.MyViewHolderPartBaReEx> {
    private Context contextPartBaReEx;
    private List<modelerApp> liPartBaReEx;

    public class MyViewHolderPartBaReEx extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderPartBaReEx(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartBaReEx(Context contextPartBaReEx, List<modelerApp> liPartBaReEx) {
        this.contextPartBaReEx = contextPartBaReEx;
        this.liPartBaReEx = liPartBaReEx;
    }

    @NonNull
    @Override
    public MyViewHolderPartBaReEx onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartBaReEx (itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartBaReEx holder, int position) {
        final modelerApp modeler = liPartBaReEx.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartBaReEx)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartBaReEx, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartBaReEx, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartBaReEx.size();
    }

}
