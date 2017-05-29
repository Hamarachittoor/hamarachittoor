package com.example.hp.mvghamarachitoor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onB1Click(View v){
        Intent i = new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(i);
    }

    public void onB2Click(View v){
        Intent i = new Intent(Main2Activity.this,Main4Activity.class);
        startActivity(i);
    }

    public void onB3Click(View v){
        Intent i = new Intent(Main2Activity.this,Main5Activity.class);
        startActivity(i);
    }
}
