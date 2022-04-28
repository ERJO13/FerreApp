package com.example.ferreapp;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class adapterEscB extends RecyclerView.Adapter<adapterEscB.MyViewHolderBa>{

    private Context contextPartB;
    private List<modelerApp> liPartBList;


    public class MyViewHolderBa extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderBa(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    /*Strp 2:  Variables and constructors*/

    public adapterEscB(Context contextPartB, List<modelerApp> liPartBList) {
        this.contextPartB = contextPartB;
        this.liPartBList = liPartBList;
    }

    /*Step 3: Implementing Methods*/

    @NonNull
    @Override
    public MyViewHolderBa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderBa(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderBa holder, int position) {
        final modelerApp modeler = liPartBList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartB)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler, view);
                Toast.makeText(contextPartB, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler, view);
                Toast.makeText(contextPartB, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartBList.size();
    }
    private void pasoComp(modelerApp model, View view){
        Intent intOpc =((Activity)contextPartB).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);

        if(model.getName().contentEquals("Area de escusado")){
            Intent i = new Intent(view.getContext(), compBaEs.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Area de regadera")){
            Intent i = new Intent(view.getContext(), compBaRe.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Area de lavabo")){
            Intent i = new Intent(view.getContext(), compBaLa.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
    }





}
