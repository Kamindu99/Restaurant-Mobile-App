package com.example.restaurant_mobile_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class TableList extends AppCompatActivity {

    RecyclerView recyclerView2;
    List<TableModel> tableList;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);
        setTitle("Table Booking");

        nav=findViewById(R.id.navmenuview2);
        drawerLayout=findViewById(R.id.table_drawer);

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
                    startActivity( new Intent(TableList.this,MainActivity.class));
                }
                else  if(id ==R.id.nav_table){
                    Toast.makeText(getApplicationContext(), "This is Table Booking Page", Toast.LENGTH_LONG).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity( new Intent(TableList.this,TableList.class));
                }
                else  if(id ==R.id.nav_contactus){
                    Toast.makeText(getApplicationContext(), "This is ContactUs Page", Toast.LENGTH_LONG).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity( new Intent(TableList.this,AllInquiry.class));
                }
                else  if(id ==R.id.nav_aboutus){
                    Toast.makeText(getApplicationContext(), "This is AboutUs Page", Toast.LENGTH_LONG).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity( new Intent(TableList.this,AboutUs.class));
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        recyclerView2=findViewById(R.id.recycletable);

        recyclerView2.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView2.setHasFixedSize(true);

        tableList=new ArrayList<>();
        tableList.add(new TableModel(R.drawable.table12,"2 Chair Table","Rs.200"));
        tableList.add(new TableModel(R.drawable.table3,"3 Chair Table","Rs.200"));
        tableList.add(new TableModel(R.drawable.table4,"4 Chair Table","Rs.200"));
        tableList.add(new TableModel(R.drawable.table5,"5 Chair Table","Rs.300"));
        tableList.add(new TableModel(R.drawable.table6,"6 Chair Table","Rs.300"));
        tableList.add(new TableModel(R.drawable.tablefam,"Family Table","Rs.400"));
        tableList.add(new TableModel(R.drawable.drinktable,"Drinking Table","Rs.400"));
        tableList.add(new TableModel(R.drawable.bdaytable,"Birthday Table","Rs.500"));
        tableList.add(new TableModel(R.drawable.tablegreen,"Green Room","Rs.1000"));

        TableAdapter adapter=new TableAdapter(tableList,this);
        recyclerView2.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pre_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.Bookings:
                Toast.makeText(getApplicationContext(), "Previous Bookings", Toast.LENGTH_LONG).show();
                startActivity( new Intent(TableList.this,BookingAll.class));
        }

        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}