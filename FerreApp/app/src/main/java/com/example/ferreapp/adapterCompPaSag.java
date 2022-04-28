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

public class adapterCompPaSag extends RecyclerView.Adapter<adapterCompPaSag.MyViewHolderPaSag> {
    private Context contextCompPaSag;
    private List<modelerApp> liCompPaSagList;

    public class MyViewHolderPaSag extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolderPaSag(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_obj);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public adapterCompPaSag(Context contextCompPaSag, List<modelerApp> liCompPaSagList) {
        this.contextCompPaSag = contextCompPaSag;
        this.liCompPaSagList = liCompPaSagList;
    }

    @NonNull
    @Override
    public MyViewHolderPaSag onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_style, parent,false);
        return new MyViewHolderPaSag(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPaSag holder, int position) {
        final modelerApp modeler = liCompPaSagList.get(position);

        holder.title.setText(modeler.getName());
        //display the image using glide
        Glide.with(contextCompPaSag)
                .load(modeler.getThumbnail())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompPaSag, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasoPart(modeler,view);
                Toast.makeText(contextCompPaSag, "Presionaste "+modeler.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return liCompPaSagList.size();
    }

    private void pasoPart(modelerApp model, View view){
        Intent intOpc =((Activity)contextCompPaSag).getIntent();
        boolean decide =intOpc.getBooleanExtra("decide",true);
        if(model.getName().contentEquals("Tuberias")){
            Intent i = new Intent(view.getContext(), partPatSagTu.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Llaves de paso")){
            Intent i = new Intent(view.getContext(), partPatSagLlagPa.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Llave")){
            Intent i = new Intent(view.getContext(), partPatSagLla.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Manguera")){
            Intent i = new Intent(view.getContext(), partPatSagMan.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Conectores")){
            Intent i = new Intent(view.getContext(), partPatSagCon.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Pistolas")){
            Intent i = new Intent(view.getContext(), partPatSagPis.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }
        else if (model.getName().contentEquals("Extras")){
            Intent i = new Intent(view.getContext(), partPatSagExt.class);
            i.putExtra("decide",decide);
            view.getContext().startActivity(i);
        }

    }

}
