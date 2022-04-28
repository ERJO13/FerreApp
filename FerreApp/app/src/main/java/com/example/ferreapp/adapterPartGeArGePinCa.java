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

public class adapterPartGeArGePinCa extends RecyclerView.Adapter<adapterPartGeArGePinCa.MyViewHolderPartGeArGePinCa> {
    private Context contextPartGeArGePinCa;
    private List<modelerApp> liPartGeArGePinCa;

    public class MyViewHolderPartGeArGePinCa extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;


        public MyViewHolderPartGeArGePinCa(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    /*Strp 2:  Variables and constructors*/

    public adapterPartGeArGePinCa(Context contextPartGeArGePinCa, List<modelerApp> liPartGeArGePinCa) {
        this.contextPartGeArGePinCa = contextPartGeArGePinCa;
        this.liPartGeArGePinCa = liPartGeArGePinCa;
    }

    @NonNull
    @Override
    public MyViewHolderPartGeArGePinCa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPartGeArGePinCa(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPartGeArGePinCa holder, int position) {
        final modelerApp modeler = liPartGeArGePinCa.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextPartGeArGePinCa)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGePinCa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contextPartGeArGePinCa, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liPartGeArGePinCa.size();
    }


}
