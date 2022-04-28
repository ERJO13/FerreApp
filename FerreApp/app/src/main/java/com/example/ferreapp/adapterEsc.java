package com.example.ferreapp;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class adapterEsc extends
        RecyclerView.Adapter<adapterEsc.MyViewHolder>{

    private Context contextEsc;
    private List<modelerApp> escList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            /*Initialize the view*/
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    /*Strp 2:  Variables and constructors*/

    public adapterEsc(Context contextEsc, List<modelerApp> escList) {
        this.contextEsc = contextEsc;
        this.escList = escList;
    }

    /*Step 3: Implementing Methods*/

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards_style, viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final modelerApp modeler = escList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextEsc)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler,view);
                Toast.makeText(contextEsc, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoComp(modeler,view);
                Toast.makeText(contextEsc, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }
    private void pasoComp(modelerApp model, View view){
        //pasat el intento
        Intent intOpc =((Activity)contextEsc).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);

        if(model.getName().contentEquals("Azotea")){
            Intent i = new Intent(view.getContext(), escAzotea.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);

        }
        else if (model.getName().contentEquals("Baño")){
            Intent i = new Intent(view.getContext(), escBathroom.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Cocina")){
            Intent i = new Intent(view.getContext(), escCocina.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("General")){
            Intent i = new Intent(view.getContext(), escGeneral.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Jardín")){
            Intent i = new Intent(view.getContext(), escJardin.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Patio")){
            Intent i = new Intent(view.getContext(), escPatio.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }

    }


    @Override
    public int getItemCount() {
        return escList.size();
    }
}
