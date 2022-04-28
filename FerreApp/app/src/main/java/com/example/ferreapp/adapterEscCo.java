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

public class adapterEscCo extends RecyclerView.Adapter<adapterEscCo.MyViewHolderCo>{
    private Context contextCompCo;
    private List<modelerApp> liPartCoList;

    public class MyViewHolderCo extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderCo(@NonNull View itemView) {
            super(itemView);
            /*Initialize the view*/
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterEscCo(Context contextCompCo, List<modelerApp> liPartCoList) {
        this.contextCompCo = contextCompCo;
        this.liPartCoList = liPartCoList;
    }

    @NonNull
    @Override
    public MyViewHolderCo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderCo(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCo holder, int position) {
        final modelerApp modeler = liPartCoList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompCo)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler,view);
                Toast.makeText(contextCompCo, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler,view);
                Toast.makeText(contextCompCo, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return liPartCoList.size();
    }

    private void pasoComp(modelerApp model, View view){
        Intent intOpc =((Activity)contextCompCo).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);

        if(model.getName().contentEquals("Sistema de gas")){
            Intent i = new Intent(view.getContext(), compCoSgs.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Sistema de agua")){
            Intent i = new Intent(view.getContext(), compCoSag.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Sistema electrico")){
            Intent i = new Intent(view.getContext(), compCoSel.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Piso")){
            Intent i = new Intent(view.getContext(), compCoPiAz.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }

    }
}
