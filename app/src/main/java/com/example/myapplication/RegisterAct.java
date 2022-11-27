package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class RegisterAct extends AppCompatActivity {
    private static final String LOG_TAG =
            RegisterAct.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



    }


    public void enter(View view) throws ExecutionException, InterruptedException {
        TextView usernameField = findViewById(R.id.nom);

        TextView passwordField = findViewById(R.id.password);
        TextView emailField = findViewById(R.id.email);
        if(new Register().execute(usernameField.getText().toString()+" "
                +passwordField.getText().toString()+" "+emailField.getText().toString()).get()=="Usuari creat"){
            Intent intent = new Intent(this, dashboard.class);
            startActivity(intent);
        } else {
            Toast toast= Toast.makeText(getApplicationContext(),"Dades incorrectes",Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}