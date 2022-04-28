package com.example.ferreapp;

import android.content.Context;
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

public class adapterPartCoSgsMan extends RecyclerView.Adapter<adapterPartCoSgsMan.MyViewHolderPartCoSgsMan> {
    private Context contextPartCoSgsMan;
    private List<modelerApp> liPartCoSgsMan;


    public class MyViewHolderPartCoSgsMan extends RecyclerView.ViewHolder{

    public TextView title;
    public ImageView thumbnail;


    public MyViewHolderPartCoSgsMan(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.name_obj);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartCoSgsMan(Context contextPartCoSgsMan, List<modelerApp> liPartCoSgsMan) {
        this.contextPartCoSgsMan = contextPartCoSgsMan;
        this.liPartCoSgsMan = liPartCoSgsMan;
    }
    @NonNull
    @Override
    public MyViewHolderPartCoSgsMan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartCoSgsMan(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartCoSgsMan holder, int position) {
        final modelerApp modeler = liPartCoSgsMan.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartCoSgsMan)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartCoSgsMan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartCoSgsMan, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartCoSgsMan.size();
    }

}
