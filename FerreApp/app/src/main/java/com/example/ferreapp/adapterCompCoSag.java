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

public class adapterCompCoSag extends RecyclerView.Adapter<adapterCompCoSag.MyViewHolderCompCoSag> {
    private Context contextCompCoSag;
    private List<modelerApp> liCompCoSag;

    public class MyViewHolderCompCoSag extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderCompCoSag(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterCompCoSag(Context contextCompCoSag, List<modelerApp> liCompCoSag) {
        this.contextCompCoSag = contextCompCoSag;
        this.liCompCoSag = liCompCoSag;
    }
    @NonNull
    @Override
    public MyViewHolderCompCoSag onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderCompCoSag(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCompCoSag holder, int position) {
        final modelerApp modeler = liCompCoSag.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompCoSag)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompCoSag, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompCoSag, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liCompCoSag.size();
    }
    private void pasoPart(modelerApp model, View view) {
        Intent intOpc =((Activity)contextCompCoSag).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);

        if (model.getName().contentEquals("Tarja")) {
            Intent i = new Intent(view.getContext(), partCoSagTar.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Desague")) {
            Intent i = new Intent(view.getContext(), partCoSagDes.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Llenado")) {
            Intent i = new Intent(view.getContext(), partCoSagLle.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }

    }
}
