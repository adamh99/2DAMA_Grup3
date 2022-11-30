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


    public static final String API_URL = "http://192.168.18.212:3000/";
    private static String username = "";
    private static String pass = "";

    private static String email = "";


    static boolean validateCredentials(String credentials){ //credentials es username/email y pass separado por espacio
        boolean res = false;
        username = credentials.split(" ")[0];
        pass = credentials.split(" ")[1];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {

            URL requestURL = new URL(API_URL+"auth/"+username+"/"+pass);

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Get the InputStream.
            InputStream inputStream = urlConnection.getInputStream();

            // El primer byte te dice si la auth ha salido bien o no.
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
    public static boolean register(String userdata){
        boolean success = false;
        username = userdata.split(" ")[0];
        pass = userdata.split(" ")[1];
        email = userdata.split(" ")[2];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {

            URL requestURL = new URL(API_URL+"create/"+username+"/"+pass+"/"+email);

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Get the InputStream.
            InputStream inputStream = urlConnection.getInputStream();

            // El primer byte te dice si la auth ha salido bien o no.
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();

            if(reader.readLine().contains("Usuari creat"))
                success = true;

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
        return success;
    }

    public static boolean insertPunt(String puntData){
        boolean success = false;
        String latitud = puntData.split(";")[0];
        String longitud = puntData.split(";")[1];
        String nom = puntData.split(";")[2];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {

            URL requestURL = new URL(API_URL+"createProd/"+latitud+"/"+longitud+"/"+nom);

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Get the InputStream.
            InputStream inputStream = urlConnection.getInputStream();

            // El primer byte te dice si la auth ha salido bien o no
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();

            if(reader.readLine().contains("Punt creat"))
                success = true;

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
        return success;
    }
}

