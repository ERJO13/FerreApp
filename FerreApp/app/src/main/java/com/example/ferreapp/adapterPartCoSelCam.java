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

public class adapterPartCoSelCam extends RecyclerView.Adapter<adapterPartCoSelCam.MyViewHolderPartCoSelCam> {
    private Context contextPartCoSelCam;
    private List<modelerApp> liPartCoSelCam;

    public class MyViewHolderPartCoSelCam extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderPartCoSelCam(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartCoSelCam(Context contextPartCoSelCam, List<modelerApp> liPartCoSelCam) {
        this.contextPartCoSelCam = contextPartCoSelCam;
        this.liPartCoSelCam = liPartCoSelCam;
    }
    @NonNull
    @Override
    public MyViewHolderPartCoSelCam onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartCoSelCam(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartCoSelCam holder, int position) {
        final modelerApp modeler = liPartCoSelCam.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartCoSelCam)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoSelCam, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoSelCam, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartCoSelCam.size();
    }
}
