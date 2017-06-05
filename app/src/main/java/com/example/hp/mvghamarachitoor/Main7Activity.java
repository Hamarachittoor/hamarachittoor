package com.example.hp.mvghamarachitoor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class Main7Activity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        spinner=(Spinner)findViewById(R.id.C1);
        String[] text = {"Select", "B.V Reddy Colony",
                "Darga",
                "Durga Nagar Colony",
                "Ganganapalli",
                "Greamspet",
                "Goolingspet",
                "Industrial Estate",
                "Iruvaram",
                "Janakarapalli",
                "Kajoor",
                "Kattamanchi",
                "Kongareddy Palli",
                "Lakshmi Nagar Colony",
                "Mittoor",
                "Murukambattu",
                "Prasanth Nagar",
                "Ram Nagar Colony",
                "Sai Nagar Colony",
                "SBI Colony",
                "Santhapet"


        };
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,text);
        spinner.setAdapter(adapter);

    }
}
