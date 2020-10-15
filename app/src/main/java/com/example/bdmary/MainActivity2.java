package com.example.bdmary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerViewEstudiante;
    private RecyclerViewAdaptador adaptadorEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerViewEstudiante=(RecyclerView)findViewById(R.id.recyclerViewEstudiante);
        recyclerViewEstudiante.setLayoutManager(new LinearLayoutManager(this));

        baseDatos baseDatos=new baseDatos(getApplicationContext());

        adaptadorEstudiante=new RecyclerViewAdaptador(baseDatos.mostrarEstudiantes());
        recyclerViewEstudiante.setAdapter(adaptadorEstudiante);
    }

}