package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
private static final String LOG_TAG= LoginActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    /*/public void loginButtonClicked(View v){
        TextView usernameField = findViewById(R.id.usernameField);

        TextView passwordField = findViewById(R.id.passwordField);
        String credentials = usernameField.getText().toString() + " " + usernameField.getText().toString();

        new Auth().execute(credentials);

    }
    /*/





    public void signUp(View v){
        Intent intent = new Intent(this, RegisterAct.class );
        startActivity(intent);
    }

    public void login(View v) {
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }
}