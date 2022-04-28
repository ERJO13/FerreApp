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

public class adapterPartCoSelCon extends RecyclerView.Adapter<adapterPartCoSelCon.MyViewHolderPartCoSelCon> {
    private Context contextPartCoSelCon;
    private List<modelerApp> liPartCoSelCon;

    public class MyViewHolderPartCoSelCon extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderPartCoSelCon(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartCoSelCon(Context contextPartCoSelCon, List<modelerApp> liPartCoSelCon) {
        this.contextPartCoSelCon = contextPartCoSelCon;
        this.liPartCoSelCon = liPartCoSelCon;
    }
    @NonNull
    @Override
    public MyViewHolderPartCoSelCon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartCoSelCon(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartCoSelCon holder, int position) {
        final modelerApp modeler = liPartCoSelCon.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartCoSelCon)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoSelCon, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contextPartCoSelCon, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartCoSelCon.size();
    }

}
