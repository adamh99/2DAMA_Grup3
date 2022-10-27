package com.example.myapplication;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    //Nuestra URL base
    private static final String API_URL = "";
    //Parametro para pasar el user
    private static final String USERNAME = "username";
    //Parametro para pasar el pass
    private static final String PASSWORD = "password";

    static boolean validateCredentials(String credentials){ //credentials es username/email y pass separado por espacio
        boolean res = false;
        String username = credentials.split(" ")[0];
        String pass = credentials.split(" ")[1];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            Uri builtURI = Uri.parse(API_URL).buildUpon()
                    .appendQueryParameter(USERNAME, username)
                    .appendQueryParameter(PASSWORD, pass)
                    .build();
            URL requestURL = new URL(builtURI.toString());

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Get the InputStream.
            InputStream inputStream = urlConnection.getInputStream();

            // El primer byte te dice si la auth ha salido bien o no. SIN TESTEAR
            res = inputStream.read() != 0;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

}
