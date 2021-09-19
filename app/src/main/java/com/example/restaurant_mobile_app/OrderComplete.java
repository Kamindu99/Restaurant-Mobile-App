package com.example.restaurant_mobile_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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