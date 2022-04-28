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

public class adapterEscAz extends RecyclerView.Adapter<adapterEscAz.MyViewHolderAz>{

    private Context contextCompAz;
    private List<modelerApp> liPartAzList;


    public class MyViewHolderAz extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderAz(@NonNull View itemView) {
            super(itemView);
            /*Initialize the view*/
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/


    public adapterEscAz(Context contextCompAz, List<modelerApp> liPartAzList) {
        this.contextCompAz = contextCompAz;
        this.liPartAzList = liPartAzList;
    }

    /*Step 3: Methods of adapter*/
    @NonNull
    @Override
    public MyViewHolderAz onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderAz(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderAz holder, int position) {
        final modelerApp modeler = liPartAzList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompAz)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompAz, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompAz, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liPartAzList.size();
    }
    private void pasoPart(modelerApp model, View view){
        Intent intOpc =((Activity)contextCompAz).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);
        if(model.getName().contentEquals("Sistema de gas")){
            Intent i = new Intent(view.getContext(), compAzSgs.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Sistema de agua")){
            Intent i = new Intent(view.getContext(), compAzSag.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }

    }
}
