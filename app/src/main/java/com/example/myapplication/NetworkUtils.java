package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    //Nuestra URL base
    public static final String API_URL = "http://192.168.1.135:3000/";
    //Parametro para pasar el user
    private static String username = "username";
    //Parametro para pasar el pass
    private static String pass = "password";

    static boolean validateCredentials(String credentials){ //credentials es username/email y pass separado por espacio
        boolean res = false;
        username = credentials.split(" ")[0];
        pass = credentials.split(" ")[1];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            /*Uri builtURI = Uri.parse(API_URL).buildUpon()
                    .appendQueryParameter(USERNAME, username)
                    .appendQueryParameter(PASSWORD, pass)
                    .build(); */
            URL requestURL = new URL(API_URL+"auth/"+username+"/"+pass);

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Get the InputStream.
            InputStream inputStream = urlConnection.getInputStream();

            // El primer byte te dice si la auth ha salido bien o no. SIN TESTEAR
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();

            if(reader.readLine().contains("\"auth\":true"))
                res = true;

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

    static public Bitmap bitmapFromPath(String path){
        InputStream in =null;
        Bitmap bmp=null;

        int responseCode = -1;
        try{

            URL url = new URL(path);//"http://192.xx.xx.xx/mypath/img1.jpg
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.connect();
            responseCode = con.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK)
            {
                //download
                in = con.getInputStream();
                bmp = BitmapFactory.decodeStream(in);
                in.close();

            }

        }
        catch(Exception ex){
            Log.e("Exception",ex.toString());
        }
        return bmp;
    }
}

