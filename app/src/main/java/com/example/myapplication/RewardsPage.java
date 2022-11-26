package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RewardsPage extends AppCompatActivity {

    ArrayList<Reward> rewardslist;
    RecyclerView recyclerRewards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards_page);

        rewardslist = new ArrayList<>();
        recyclerRewards= findViewById(R.id.rewardsid);
        recyclerRewards.setLayoutManager(new LinearLayoutManager(this));

        fillrewards();

        Rewardadapter adapter = new Rewardadapter(rewardslist);
        recyclerRewards.setAdapter(adapter);

    }
    private void fillrewards(){
        rewardslist.add(new Reward("Cadira", "Cadira de plastic reciclat 100exp", R.drawable.cadira));
        rewardslist.add(new Reward("Taula", "Taula de plastic reciclat 200exp", R.drawable.taula));
        rewardslist.add(new Reward("Banc", "Banc de plastic reciclat 300exp", R.drawable.banco));
        rewardslist.add(new Reward("Columpi", "Columpi de plastic reciclat 400exp", R.drawable.columpi));


    }
}