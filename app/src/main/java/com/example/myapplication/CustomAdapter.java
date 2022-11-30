package com.example.myapplication;


import android.graphics.Bitmap;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localDataSet;
    private Bitmap[] imageSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        public ViewHolder(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.textViewR);
            imageView = (ImageView) view.findViewById(R.id.imageView3);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }
    }


    public CustomAdapter(String[] dataSet, Bitmap[] imageSet) {
        localDataSet = dataSet;
        this.imageSet = imageSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        viewHolder.getTextView().setText(localDataSet[position]);
        viewHolder.getImageView().setImageBitmap(imageSet[position]);

    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
