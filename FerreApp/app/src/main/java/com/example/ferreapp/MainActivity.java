package com.example.ferreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPiezas = findViewById(R.id.btn_piezas);
        Button btnHerramientas = findViewById(R.id.btn_herramientas);

        btnPiezas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eleccion(btnPiezas);
            }
        });

        btnHerramientas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eleccion(btnHerramientas);
            }
        });

    }

    public void eleccion(Button b){
        boolean piezaHerra = true;  //true es pieza, false es herramienta
        String text = (String) b.getText();
        if (text.equals("Herramientas")) {
            piezaHerra = false;
        }
        Intent intento = new Intent(this,escenarios.class);
        //Toast.makeText(getApplicationContext(),""+ piezaHerra +" "+ text, Toast.LENGTH_SHORT).show();
        intento.putExtra("decide",piezaHerra);
        startActivity(intento);
    }
}