package com.example.hp.mvghamarachitoor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void onR1Click(View v){
        Intent i = new Intent(Main3Activity.this,Main6Activity.class);
        startActivity(i);

    }

    public void onClickV1(View v){

        Intent i = new Intent(Main3Activity.this,Main7Activity.class);
        startActivity(i);

    }


}
