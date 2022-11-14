package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class rview extends AppCompatActivity {
    RecyclerView rView;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rview);
        String[] dataset = {"a","b","c","d","e","f","h"};
        rView = (RecyclerView) findViewById(R.id.rview);
        adapter = new CustomAdapter(dataset);
        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(adapter);
    }
}