package com.example.ferreapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class adapterCompAzSag extends RecyclerView.Adapter<adapterCompAzSag.MyViewHolderCompAzSag> {
    private Context contextCompAzSag;
    private List<modelerApp> liCompCompAzSag;


    public class MyViewHolderCompAzSag extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderCompAzSag(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterCompAzSag(Context contextCompAzSag, List<modelerApp> liCompCompAzSag) {
        this.contextCompAzSag = contextCompAzSag;
        this.liCompCompAzSag = liCompCompAzSag;
    }


    @NonNull
    @Override
    public MyViewHolderCompAzSag onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderCompAzSag(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCompAzSag holder, int position) {
        final modelerApp modeler = liCompCompAzSag.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompAzSag)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompAzSag, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompAzSag, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liCompCompAzSag.size();
    }
    private void pasoPart(modelerApp model, View view){
        Intent intOpc =((Activity)contextCompAzSag).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);

        if(model.getName().contentEquals("Tinaco")){
            Intent i = new Intent(view.getContext(), partAzSagTin.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Tuberia")){
            Intent i = new Intent(view.getContext(), partAzSagTu.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
    }



}
