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

public class adapterEscPa extends RecyclerView.Adapter<adapterEscPa.MyViewHolderPa>{
    private Context contextEscPa;
    private List<modelerApp> liEscPaList;

    public class MyViewHolderPa extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderPa(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterEscPa(Context contextEscPa, List<modelerApp> liEscPaList) {
        this.contextEscPa = contextEscPa;
        this.liEscPaList = liEscPaList;
    }

    @NonNull
    @Override
    public MyViewHolderPa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPa(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPa holder, int position) {
        final modelerApp modeler = liEscPaList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextEscPa)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler, view);
                Toast.makeText(contextEscPa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler, view);
                Toast.makeText(contextEscPa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liEscPaList.size();
    }

    private void pasoComp(modelerApp model, View view){
        Intent intOpc =((Activity)contextEscPa).getIntent();
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
