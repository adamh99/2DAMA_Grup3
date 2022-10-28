package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//esta activity solo deberia salir la primera vez que abras la app
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void screenClicked(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}