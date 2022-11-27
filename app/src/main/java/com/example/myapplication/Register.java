package com.example.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.net.HttpURLConnection;


public class Register extends AsyncTask<String, Void, String> {



    public Register(){
        //toast te debería decir el resultado de la autentificación

    }

    @Override
    protected String doInBackground(String... strings) {
        String res = "";
        boolean success = NetworkUtils.register(strings[0]);
        if(success) res = "Usuari creat";
        return res;
    }


}
