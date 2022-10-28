package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.prefs.Preferences;

//esta actividad no tiene layout, solo sirve para ver si el usuario es nuevo o no y enseñarle la bienvenida o directamente el login
public class EntryActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent;
        if(firstTime()){
            intent = new Intent(this, WelcomeActivity.class);
        }else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
    }
    public boolean firstTime(){
        boolean firstTime = true;
        sharedPreferences = getPreferences(MODE_PRIVATE);

        if(sharedPreferences.contains("welcomed")){
            firstTime = false;
        }else {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("welcomed", true);
            edit.commit();
        }
        return firstTime;
    }
}