package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {
private static final String LOG_TAG= LoginActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void loginButtonClicked(View v) throws ExecutionException, InterruptedException {
        TextView usernameField = findViewById(R.id.usernameField);

        TextView passwordField = findViewById(R.id.passwordField);
        String credentials = usernameField.getText().toString() + " " + passwordField.getText().toString();

        if(new Auth().execute(credentials).get()=="Autentificado") {
            login();
        }else {
            Toast toast= Toast.makeText(getApplicationContext(),"L'usuari no existeix",Toast.LENGTH_SHORT);

            toast.show();  }

    }






    public void signUp(View v){
        Intent intent = new Intent(this, RegisterAct.class );
        startActivity(intent);
    }

    public void login() {
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }
}