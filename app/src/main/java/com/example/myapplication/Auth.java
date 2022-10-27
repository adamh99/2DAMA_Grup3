package com.example.myapplication;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.net.HttpURLConnection;

public class Auth extends AsyncTask<String, Void, String> {



    public Auth(){
    //toast te debería decir el resultado de la autentificación

    }

    @Override
    protected String doInBackground(String... strings) {
        String res = "No autentificado";
        boolean success = NetworkUtils.validateCredentials(strings[0]);
        if(success) res = "Autentificado con éxito";
        return res;
    }


}
