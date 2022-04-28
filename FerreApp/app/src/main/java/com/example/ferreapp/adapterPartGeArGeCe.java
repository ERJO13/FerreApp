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

public class adapterPartGeArGeCe  extends RecyclerView.Adapter<adapterPartGeArGeCe.MyViewHolderPartGeArGeCe> {
    private Context contextPartGeArGeCe;
    private List<modelerApp> liPartGeArGeCe;

    public class MyViewHolderPartGeArGeCe extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartGeArGeCe(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartGeArGeCe(Context contextPartGeArGeCe, List<modelerApp> liPartGeArGeCe) {
        this.contextPartGeArGeCe = contextPartGeArGeCe;
        this.liPartGeArGeCe = liPartGeArGeCe;
    }
    @NonNull
    @Override
    public MyViewHolderPartGeArGeCe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartGeArGeCe(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartGeArGeCe holder, int position) {
        final modelerApp modeler = liPartGeArGeCe.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartGeArGeCe)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGeCe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGeCe, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartGeArGeCe.size();
    }

}
