package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class BitmapFromURL extends AsyncTask<String, Void, String> {



    public BitmapFromURL(){

    }

    @Override
    protected String doInBackground(String... strings) {

        Bitmap btm = NetworkUtils.bitmapFromPath(strings[0]);

        return Parse.BitMapToString(btm);
    }


}