package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void findTrashClicked(View v){
        Intent intent = new Intent(this, rview.class);
        startActivity(intent);
    }
    public void newTrashClicked(View v){
        Intent intent = new Intent(this, NewP.class);
        startActivity(intent);
    }

    public void Rewards(View view) {
        Intent intent = new Intent(this, RewardsPage.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);

        return true;
    }


    /*/public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Test", Toast.LENGTH_SHORT);

            case R.id.item2:
                Toast.makeText(this,"Test", Toast.LENGTH_SHORT);

            case R.id.item3:
                Toast.makeText(this,"Test", Toast.LENGTH_SHORT);

        }
        return super.onOptionsItemSelected(item);/*/

}