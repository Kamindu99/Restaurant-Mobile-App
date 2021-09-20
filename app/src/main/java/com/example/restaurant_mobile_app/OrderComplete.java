package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OrderComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        setTitle("Order Confirmation");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void gotoedit (View view){
        Intent intent2= getIntent();
        Bundle bundle=intent2.getExtras();
        Intent intent = new Intent(this,EditDelivery.class);
        intent.putExtra("ABC",bundle);


        startActivity(intent);
    }

    public void gotomenu (View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void gotoview (View view){
        Intent intent = new Intent(this,ViewOrder.class);
        startActivity(intent);
    }



}