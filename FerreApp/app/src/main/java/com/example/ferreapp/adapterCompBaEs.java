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

public class adapterCompBaEs extends RecyclerView.Adapter<adapterCompBaEs.MyViewHolderBaEs> {
    private Context contextPartBaEs;
    private List<modelerApp> liPartBaEsList;

    public class MyViewHolderBaEs extends RecyclerView.ViewHolder{

    public TextView title;
    public ImageView thumbnail;

    public MyViewHolderBaEs(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.name_obj);
        thumbnail = itemView.findViewById(R.id.thumbnail);
    }
}
/*Strp 2:  Variables and constructors*/
    public adapterCompBaEs(Context contextPartBaEs, List<modelerApp> liPartBaEsList) {
        this.contextPartBaEs = contextPartBaEs;
        this.liPartBaEsList = liPartBaEsList;
    }
    @NonNull
    @Override
    public MyViewHolderBaEs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderBaEs(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderBaEs holder, int position) {
        final modelerApp modeler = liPartBaEsList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartBaEs)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextPartBaEs, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextPartBaEs, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liPartBaEsList.size();
    }
    private void pasoPart(modelerApp model, View view){
        Intent intOpc =((Activity)contextPartBaEs).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);

        if(model.getName().contentEquals("Escusado")){
            Intent i = new Intent(view.getContext(), partBaEsEs.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Tanque")){
            Intent i = new Intent(view.getContext(), partBaEsTan.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
    }

}
