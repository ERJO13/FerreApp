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

public class adapterCompCoSel extends RecyclerView.Adapter<adapterCompCoSel.MyViewHolderCompCoSel> {
    private Context contextCompCoSel;
    private List<modelerApp> liCompCoSel;

    public class MyViewHolderCompCoSel extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderCompCoSel(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterCompCoSel(Context contextCompCoSel, List<modelerApp> liCompCoSel) {
        this.contextCompCoSel = contextCompCoSel;
        this.liCompCoSel = liCompCoSel;
    }
    @NonNull
    @Override
    public MyViewHolderCompCoSel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderCompCoSel(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCompCoSel holder, int position) {
        final modelerApp modeler = liCompCoSel.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompCoSel)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompCoSel, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompCoSel, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liCompCoSel.size();
    }
    private void pasoPart(modelerApp model, View view) {
        Intent intOpc =((Activity)contextCompCoSel).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);

        if (model.getName().contentEquals("Campana")) {
            Intent i = new Intent(view.getContext(), partCoSelCam.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Contacto/Apagador")) {
            Intent i = new Intent(view.getContext(), partCoSelCon.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Iluminación")) {
            Intent i = new Intent(view.getContext(), partCoSelLum.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }

    }
}
