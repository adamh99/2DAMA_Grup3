package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Rview extends AppCompatActivity {
    ArrayList<String> listDatos;
    RecyclerView recycler;
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recyclerview);
    recycler = (RecyclerView)  findViewById(R.id.recyclerid);
    recycler.setLayoutManager(new LinearLayoutManager(this ));
    listDatos = new ArrayList<String>();

    for (int i=0; i<=50; i++){
        listDatos.add("Dato " +i+ " ");
    }
    AdapterDatos adapter = new AdapterDatos(listDatos);
    recycler.setAdapter(adapter);
    }
}
