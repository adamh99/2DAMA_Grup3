package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void findTrashClicked(View v){
        Intent intent = new Intent(this, rview.class);
        startActivity(intent);
    }
    public void newTrashClicked(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}