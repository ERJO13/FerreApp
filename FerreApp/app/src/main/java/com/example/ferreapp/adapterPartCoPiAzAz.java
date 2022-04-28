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

public class adapterPartCoPiAzAz extends RecyclerView.Adapter<adapterPartCoPiAzAz.MyViewHolderPartCoPiAzAz> {
    private Context contextPartCoPiAzAz;
    private List<modelerApp> liPartCoPiAzAz;

    public class MyViewHolderPartCoPiAzAz extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderPartCoPiAzAz(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartCoPiAzAz(Context contextPartCoPiAzAz, List<modelerApp> liPartCoPiAzAz) {
        this.contextPartCoPiAzAz = contextPartCoPiAzAz;
        this.liPartCoPiAzAz = liPartCoPiAzAz;
    }
    @NonNull
    @Override
    public MyViewHolderPartCoPiAzAz onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartCoPiAzAz(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartCoPiAzAz holder, int position) {
        final modelerApp modeler = liPartCoPiAzAz.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartCoPiAzAz)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoPiAzAz, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoPiAzAz, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartCoPiAzAz.size();
    }
}
