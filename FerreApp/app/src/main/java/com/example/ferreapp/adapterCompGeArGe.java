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

public class adapterCompGeArGe extends RecyclerView.Adapter<adapterCompGeArGe.MyViewHolderCompGeArGe> {
    private Context contextCompGeArGe;
    private List<modelerApp> liCompGeArGe;

    public class MyViewHolderCompGeArGe extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderCompGeArGe(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterCompGeArGe(Context contextCompGeArGe, List<modelerApp> liCompGeArGe) {
        this.contextCompGeArGe = contextCompGeArGe;
        this.liCompGeArGe = liCompGeArGe;
    }
    @NonNull
    @Override
    public MyViewHolderCompGeArGe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderCompGeArGe(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCompGeArGe holder, int position) {
        final modelerApp modeler = liCompGeArGe.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompGeArGe)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompGeArGe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompGeArGe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liCompGeArGe.size();
    }
    private void pasoPart(modelerApp model, View view){
        Intent intOpc =((Activity)contextCompGeArGe).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);
        if(model.getName().contentEquals("Puerta")){
            Intent i = new Intent(view.getContext(), partGeArGePu.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Persianas")){
            Intent i = new Intent(view.getContext(), partGeArGePer.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Cerradura")){
            Intent i = new Intent(view.getContext(), partGeArGeCe.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Enchufes de luz")){
            Intent i = new Intent(view.getContext(), partGeArGeEnLu.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Lamparas de techo")){
            Intent i = new Intent(view.getContext(), partGeArGeLamTe.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Pintar una casa")){
            Intent i = new Intent(view.getContext(), partGeArGePinCa.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);;
        }
        else if (model.getName().contentEquals("Resanar pared")){
            Intent i = new Intent(view.getContext(), partGeArGeTaAg.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Mosquitero")){
            Intent i = new Intent(view.getContext(), partGeArGeMos.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
    }

}
