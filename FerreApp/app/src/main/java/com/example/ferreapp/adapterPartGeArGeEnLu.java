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

public class adapterPartGeArGeEnLu extends RecyclerView.Adapter<adapterPartGeArGeEnLu.MyViewHolderPartGeArGeEnLu> {
    private Context contextPartGeArGeEnLu;
    private List<modelerApp> liPartGeArGeEnLu;


    public class MyViewHolderPartGeArGeEnLu extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartGeArGeEnLu(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartGeArGeEnLu(Context contextPartGeArGeEnLu, List<modelerApp> liPartGeArGeEnLu) {
        this.contextPartGeArGeEnLu = contextPartGeArGeEnLu;
        this.liPartGeArGeEnLu = liPartGeArGeEnLu;
    }
    @NonNull
    @Override
    public MyViewHolderPartGeArGeEnLu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartGeArGeEnLu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartGeArGeEnLu holder, int position) {
        final modelerApp modeler = liPartGeArGeEnLu.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartGeArGeEnLu)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGeEnLu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGeEnLu, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartGeArGeEnLu.size();
    }

}
