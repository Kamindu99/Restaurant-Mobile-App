package com.example.restaurant_mobile_app;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<FoodModel> foodList;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Food Home");

        nav=findViewById(R.id.navmenuview);
        drawerLayout=findViewById(R.id.food_drawer);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                int id =item.getItemId();
                if (id==R.id.nav_home){
                    Toast.makeText(getApplicationContext(), "This is Home Page", Toast.LENGTH_LONG).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity( new Intent(MainActivity.this,MainActivity.class));
                }
                else  if(id ==R.id.nav_table){
                    Toast.makeText(getApplicationContext(), "This is Table Booking Page", Toast.LENGTH_LONG).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity( new Intent(MainActivity.this,TableList.class));
                }
                else  if(id ==R.id.nav_contactus){
                    Toast.makeText(getApplicationContext(), "This is ContactUs Page", Toast.LENGTH_LONG).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity( new Intent(MainActivity.this,AllInquiry.class));
                }
                else  if(id ==R.id.nav_aboutus){
                    Toast.makeText(getApplicationContext(), "This is AboutUs Page", Toast.LENGTH_LONG).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity( new Intent(MainActivity.this,AboutUs.class));
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        recyclerView=findViewById(R.id.recyclehome);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        foodList=new ArrayList<>();
        foodList.add(new FoodModel(R.drawable.friderice,"Fried Rice","300"));
        foodList.add(new FoodModel(R.drawable.koththu,"Koththu","350"));
        foodList.add(new FoodModel(R.drawable.biriyani,"Biriyani","450"));
        foodList.add(new FoodModel(R.drawable.noodles,"Noodles","200"));
        foodList.add(new FoodModel(R.drawable.cheesebur,"Cheese Burger","600"));
        foodList.add(new FoodModel(R.drawable.idi,"String Hopper","150"));
        foodList.add(new FoodModel(R.drawable.crabcurry,"Lagoon Crab Curry","400"));
        foodList.add(new FoodModel(R.drawable.seafoodfriedrice,"Seafood Fried Rice","650"));
        foodList.add(new FoodModel(R.drawable.hotdog,"Chicken Hot Dog","350"));
        foodList.add(new FoodModel(R.drawable.vegitablenoodles,"Vegetable Noodles","180"));
        foodList.add(new FoodModel(R.drawable.soup,"Wonton Egg Noodle Soup","150"));
        foodList.add(new FoodModel(R.drawable.chickenwings,"Spicy Chicken Wings","400"));
        foodList.add(new FoodModel(R.drawable.sawan,"Full Sawan","1400"));
        foodList.add(new FoodModel(R.drawable.pizza2,"Vegetable Pizza","1300"));
        foodList.add(new FoodModel(R.drawable.piz,"Chicken Pizza","1500"));
        foodList.add(new FoodModel(R.drawable.hawaiianpizza,"Hawaiian Pizza","1600"));
        foodList.add(new FoodModel(R.drawable.nasigoreng,"Nasi Goreng ","480"));



        FoodAdapter adapter=new FoodAdapter(foodList,this);
        recyclerView.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item){
        int id =item.getItemId();
        if (id==R.id.nav_home){
            startActivity( new Intent(MainActivity.this,AboutUs.class));
        }
        else  if(id ==R.id.nav_aboutus){

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void gototablebook (View view){
        Intent intent = new Intent(this,TableList.class);
        startActivity(intent);
    }
    public void gotoabout (View view){
        Intent intent = new Intent(this,AboutUs.class);
        startActivity(intent);
    }

}