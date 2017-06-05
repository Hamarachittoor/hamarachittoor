package com.example.hp.mvghamarachitoor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Main6Activity extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        //-----------------Submit Button------------------------------
        final EditText f1 = (EditText) findViewById(R.id.C2);
        final EditText f2 = (EditText) findViewById(R.id.C3);
        final EditText f3 = (EditText) findViewById(R.id.C4);
        final EditText f4 = (EditText) findViewById(R.id.editText);
        final EditText f5 = (EditText) findViewById(R.id.editText1);
        spinner = (Spinner) findViewById(R.id.C1);
        Button submitbutton = (Button) findViewById(R.id.Q1);
        submitbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(f1.getText().toString().trim().length() == 0){
                    f1.setError("Cannot be empty");
                }else if(f2.getText().toString().trim().length() == 0){
                    f2.setError("Cannot be empty");
                }else if(f3.getText().toString().trim().length() == 0){
                    f3.setError("Cannot be empty");
                }else if(f4.getText().toString().trim().length() == 0){
                    f4.setError("Cannot be empty");
                }else{
                    // WHEN THERE ARE NO EMPTY FIELDS,EXECUTE AS REQUIRED
                    String name = f3.getText().toString();
                    String locality=spinner.getSelectedItem().toString();
                    String rent = f2.getText().toString();
                    String address = f1.getText().toString();
                    String contact = f4.getText().toString();
                    String referral = f5.getText().toString();

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(locality);

                    Map<String, String> map = new HashMap<String, String>();

                    map.put("Name", name);
                    map.put("Locality", locality);
                    map.put("Address", address);
                    map.put("Rent", rent);
                    map.put("Contact", contact);

                    if(referral.length()!=0){
                        map.put("Referral",referral);
                    }

                    myRef.push().setValue(map);

                    Toast.makeText(Main6Activity.this, "Successfully Entered Details to Database", Toast.LENGTH_SHORT).show();



                }
                }
        });




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

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, text);
        spinner.setAdapter(adapter);

    }
}
