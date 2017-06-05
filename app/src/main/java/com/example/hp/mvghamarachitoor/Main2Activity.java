package com.example.hp.mvghamarachitoor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private ActionBarDrawerToggle mtoggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        mtoggle=new ActionBarDrawerToggle(this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        drawer.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FirebaseApp.initializeApp(this);



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            Intent intent= new Intent (this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        else{
           // FirebaseAuth.getInstance().signOut();
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement
        if (mtoggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }









    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();

        if (id == R.id.nav_contact) {

   Intent intent = new Intent(this,contact.class);
            startActivity(intent);


            // Handle the camera action
        }  else if (id == R.id.nav_about) {
            Intent intent = new Intent(this,about.class);
            startActivity(intent);}
             else if (id == R.id.nav_feedback) {
                Intent intent = new Intent(this,feedback.class);
                startActivity(intent);
        } else if (id == R.id.nav_vision) {
            Intent intent = new Intent(this,vision.class);
            startActivity(intent);

        }


        else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "No more difficulties to find a rented houses in your locality. Do Download our Application \"Hamara Chittoor\"!: https://play.google.com/store/apps/details?id=com.example.hp.mvghamarachitoor");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
