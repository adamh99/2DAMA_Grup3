package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {



    ArrayList<String> listDatos;

    public AdapterDatos(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @androidx.annotation.NonNull
    @Override
    public AdapterDatos.ViewHolderDatos onCreateViewHolder(@NonNull @androidx.annotation.NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,null,false
        );

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @androidx.annotation.NonNull AdapterDatos.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView dato;
        public ViewHolderDatos(@NonNull @androidx.annotation.NonNull View itemView) {
            super(itemView);
            dato =(TextView) itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
}
