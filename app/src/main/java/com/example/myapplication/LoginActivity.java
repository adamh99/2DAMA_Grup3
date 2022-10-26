package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginButtonClicked(View v){
        TextView usernameField = findViewById(R.id.usernameField);
        String username = usernameField.getText().toString();

        TextView passwordField = findViewById(R.id.passwordField);
        String password = usernameField.getText().toString();

        Log.d("debug",username+" "+password);

    }
}