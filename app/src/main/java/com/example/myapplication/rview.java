package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class rview extends AppCompatActivity {
    RecyclerView rView;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rview);
        String[] dataset = {"a"};
        Bitmap[] imageSet = new Bitmap[0];
        try {
            imageSet = new Bitmap[]{Parse.StringToBitMap(new BitmapFromURL().execute("https://www.pakainfo.com/wp-content/uploads/2021/09/image-url-for-testing.jpg").get())};
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rView = (RecyclerView) findViewById(R.id.rview);
        adapter = new CustomAdapter(dataset,imageSet);
        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(adapter);
    }}
