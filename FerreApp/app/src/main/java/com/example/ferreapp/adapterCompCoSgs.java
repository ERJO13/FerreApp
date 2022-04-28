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

public class adapterCompCoSgs extends RecyclerView.Adapter<adapterCompCoSgs.MyViewHolderCompCoSgs> {
    private Context contextCompCoSgs;
    private List<modelerApp> liCompCoSgs;

    public class MyViewHolderCompCoSgs extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderCompCoSgs(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterCompCoSgs(Context contextCompCoSgs, List<modelerApp> liCompCoSgs) {
        this.contextCompCoSgs = contextCompCoSgs;
        this.liCompCoSgs = liCompCoSgs;
    }
    @NonNull
    @Override
    public MyViewHolderCompCoSgs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderCompCoSgs(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCompCoSgs holder, int position) {
        final modelerApp modeler = liCompCoSgs.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompCoSgs)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler, view);
                Toast.makeText(contextCompCoSgs, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler, view);
                Toast.makeText(contextCompCoSgs, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liCompCoSgs.size();
    }
    private void pasoPart(modelerApp model, View view) {
        Intent intOpc =((Activity)contextCompCoSgs).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);
        if (model.getName().contentEquals("Tuberia")) {
            Intent i = new Intent(view.getContext(), partCoSgsTu.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Mangueras")) {
            Intent i = new Intent(view.getContext(), partCoSgsMan.class);
            i.putExtra("decision", model.getName().toString());
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }

    }


}
