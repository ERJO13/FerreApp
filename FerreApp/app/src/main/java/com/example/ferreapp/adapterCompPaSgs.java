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

public class adapterCompPaSgs extends RecyclerView.Adapter<adapterCompPaSgs.MyViewHolderPaSgs> {
    private Context contextCompPaSgs;
    private List<modelerApp> liCompPaSgsList;

    public class MyViewHolderPaSgs extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderPaSgs(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterCompPaSgs(Context contextCompPaSgs, List<modelerApp> liCompPaSgsList) {
        this.contextCompPaSgs = contextCompPaSgs;
        this.liCompPaSgsList = liCompPaSgsList;
    }

    @NonNull
    @Override
    public MyViewHolderPaSgs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPaSgs(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPaSgs holder, int position) {
        final modelerApp modeler = liCompPaSgsList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompPaSgs)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompPaSgs, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompPaSgs, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liCompPaSgsList.size();
    }
    private void pasoPart(modelerApp model, View view){
        Intent intOpc =((Activity)contextCompPaSgs).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);
        if(model.getName().contentEquals("Tuberias")){
            Intent i = new Intent(view.getContext(), partPaSgsTu.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Llaves de paso")){
            Intent i = new Intent(view.getContext(), partPaSgsLlaPa.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Mangueras")){
            Intent i = new Intent(view.getContext(), partPaSgsMa.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Reguladores")){
            Intent i = new Intent(view.getContext(), partPaSgsRe.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Pigtail")){
            Intent i = new Intent(view.getContext(), partPaSgsPig.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }

    }
}
