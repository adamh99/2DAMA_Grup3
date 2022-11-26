package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Rewardadapter extends RecyclerView.Adapter<Rewardadapter.ViewHolderRewards> {
    ArrayList<Reward> listaRewards;
    public Rewardadapter(ArrayList<Reward> listaRewards) {
        this.listaRewards = listaRewards;
    }



    @NonNull
    @Override
    public ViewHolderRewards onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_rewards,null,false);
        return new ViewHolderRewards(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRewards holder, int position) {
        holder.etiname.setText(listaRewards.get(position).getName());
        holder.etiinfo.setText(listaRewards.get(position).getInfo());
        holder.foto.setImageResource(listaRewards.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listaRewards.size();
    }

    public class ViewHolderRewards extends RecyclerView.ViewHolder {

        TextView etiname,etiinfo;
        ImageView foto;

        public ViewHolderRewards(@NonNull View itemView) {
            super(itemView);
            etiname= (TextView) itemView.findViewById(R.id.idnom);
            etiinfo = (TextView) itemView.findViewById(R.id.idDescripcio);
            foto = (ImageView) itemView.findViewById(R.id.foto);
        }
    }
}
