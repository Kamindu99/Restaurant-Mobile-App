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
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_table:
                        Toast.makeText(getApplicationContext(), "Table booking Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_contactus:
                        Toast.makeText(getApplicationContext(), "contact us Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_aboutus:
                        Toast.makeText(getApplicationContext(), "about us Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
                return false;
            }
        });

        recyclerView=findViewById(R.id.recyclehome);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        foodList=new ArrayList<>();
        foodList.add(new FoodModel(R.drawable.friderice,"Fried Rice","1000"));
        foodList.add(new FoodModel(R.drawable.koththu,"Koththu","2000"));
        foodList.add(new FoodModel(R.drawable.biriyani,"Biriyani","3000"));
        foodList.add(new FoodModel(R.drawable.noodles,"Noodles","4000"));
        foodList.add(new FoodModel(R.drawable.friderice,"Fried Rice","1000"));
        foodList.add(new FoodModel(R.drawable.koththu,"Koththu","2000"));
        foodList.add(new FoodModel(R.drawable.biriyani,"Biriyani","3000"));
        foodList.add(new FoodModel(R.drawable.noodles,"Noodles","4000"));
        foodList.add(new FoodModel(R.drawable.friderice,"Fried Rice","1000"));
        foodList.add(new FoodModel(R.drawable.koththu,"Koththu","2000"));
        foodList.add(new FoodModel(R.drawable.biriyani,"Biriyani","3000"));
        foodList.add(new FoodModel(R.drawable.noodles,"Noodles","4000"));
        foodList.add(new FoodModel(R.drawable.friderice,"Fried Rice","1000"));
        foodList.add(new FoodModel(R.drawable.koththu,"Koththu","2000"));
        foodList.add(new FoodModel(R.drawable.biriyani,"Biriyani","3000"));
        foodList.add(new FoodModel(R.drawable.noodles,"Noodles","4000"));
        foodList.add(new FoodModel(R.drawable.friderice,"Fried Rice","1000"));
        foodList.add(new FoodModel(R.drawable.koththu,"Koththu","2000"));
        foodList.add(new FoodModel(R.drawable.biriyani,"Biriyani","3000"));
        foodList.add(new FoodModel(R.drawable.noodles,"Noodles","4000"));

        FoodAdapter adapter=new FoodAdapter(foodList,this);
        recyclerView.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
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