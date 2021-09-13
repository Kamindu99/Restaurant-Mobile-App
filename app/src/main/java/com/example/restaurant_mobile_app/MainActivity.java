package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<FoodModel> foodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public void gototable (View view){
        Intent intent = new Intent(this,TableList.class);
        startActivity(intent);
    }


}