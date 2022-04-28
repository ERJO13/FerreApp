package com.example.ferreapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adapterEscGe extends RecyclerView.Adapter<adapterEscGe.MyViewHolderGe>{

    private Context contextCompGe;
    private List<modelerApp> liCompGeList;


    public class MyViewHolderGe extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderGe(@NonNull View itemView) {
            super(itemView);
            /*Initialize the view*/
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterEscGe(Context contextCompGe, List<modelerApp> liCompGeList) {
        this.contextCompGe = contextCompGe;
        this.liCompGeList = liCompGeList;
    }

    @NonNull
    @Override
    public MyViewHolderGe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderGe(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderGe holder, int position) {
        final modelerApp modeler = liCompGeList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompGe)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler,view);
                Toast.makeText(contextCompGe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler,view);
                Toast.makeText(contextCompGe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liCompGeList.size();
    }

    private void pasoComp(modelerApp model, View view){
        Intent intOpc =((Activity)contextCompGe).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);
        if(model.getName().contentEquals("Area general")){
            Intent i = new Intent(view.getContext(),compGeArGe.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);;
        }
    }


}
