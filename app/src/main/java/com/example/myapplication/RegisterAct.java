package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class RegisterAct extends AppCompatActivity {
    private static final String LOG_TAG =
            RegisterAct.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void dashboard(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }


}