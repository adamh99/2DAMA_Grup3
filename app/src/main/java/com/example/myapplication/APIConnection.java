package com.example.myapplication;

import android.os.AsyncTask;

public class APIConnection extends AsyncTask<String, Void, String> {

    String api;

    public APIConnection(String api_url){
        api = api_url;
    }

    @Override
    protected String doInBackground(String... strings) {

        return null;
    }

    public boolean auth(String mail, String pass){

        return false;
    }
}
