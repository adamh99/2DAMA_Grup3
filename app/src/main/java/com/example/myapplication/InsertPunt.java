package com.example.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.net.HttpURLConnection;


public class InsertPunt extends AsyncTask<String, Void, String> {


    public InsertPunt() {

    }

    @Override
    protected String doInBackground(String... strings) {
        String res = "";
        boolean success = NetworkUtils.insertPunt(strings[0]);
        if (success) res = "Punt creat";
        return res;
    }

}