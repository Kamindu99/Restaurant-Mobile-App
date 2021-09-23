package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderComplete extends AppCompatActivity {

    Button viewordr,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        setTitle("Order Confirmation");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewordr=findViewById(R.id.btn_orderview);
        home=findViewById(R.id.btn_home);

        viewordr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = getIntent().getStringExtra("id");
                Intent intent = new Intent(OrderComplete.this,ViewOrder.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderComplete.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }

}