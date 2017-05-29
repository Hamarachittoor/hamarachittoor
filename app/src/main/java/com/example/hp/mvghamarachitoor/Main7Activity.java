package com.example.hp.mvghamarachitoor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Main7Activity extends AppCompatActivity {
    AutoCompleteTextView C1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        String [] text= {"B.V Reddy Colony",
                "Darga" ,
                "Durga Nagar Colony",
                "Ganganapalli" ,
                "Greamspet",
                "Goolingspet" ,
                "Industrial Estate" ,
                "Janakarapalli",
                "Kajoor",
                "Kattamanchi" ,
                "Kongareddy Palli" ,
                "Mittoor" ,
                "Ram Nagar Colony" ,
                "Santhapet"};
        C1=(AutoCompleteTextView)findViewById(R.id.C1);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,text);
        C1.setAdapter(adapter);

    }
}
