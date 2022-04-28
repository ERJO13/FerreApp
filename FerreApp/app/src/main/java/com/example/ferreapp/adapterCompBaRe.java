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

public class adapterCompBaRe extends RecyclerView.Adapter<adapterCompBaRe.MyViewHolderBaRe> {
    private Context contextPartBaRe;
    private List<modelerApp> liPartBaReList;

    public class MyViewHolderBaRe extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderBaRe(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterCompBaRe(Context contextPartBaRe, List<modelerApp> liPartBaReList) {
        this.contextPartBaRe = contextPartBaRe;
        this.liPartBaReList = liPartBaReList;
    }


    @NonNull
    @Override
    public MyViewHolderBaRe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderBaRe(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderBaRe holder, int position) {
        final modelerApp modeler = liPartBaReList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartBaRe)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextPartBaRe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextPartBaRe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liPartBaReList.size();
    }
    private void pasoPart(modelerApp model, View view){
        Intent intOpc =((Activity)contextPartBaRe).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);

        if(model.getName().contentEquals("Tuberia")){
            Intent i = new Intent(view.getContext(), partBaReTu.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Extra")){
            Intent i = new Intent(view.getContext(), partBaReEx.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
    }


}
