package com.example.restaurant_mobile_app;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewBooking extends AppCompatActivity {



    private EditText tname, name, nic, date, time;

    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking);
        setTitle("View Table Booking");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;
        dbHandler = new DbHandler(context);

        tname = findViewById(R.id.view_tname);
        name = findViewById(R.id.view_name);
        nic = findViewById(R.id.view_nic);
        date = findViewById(R.id.view_date);
        time = findViewById(R.id.view_time);


        final String id = getIntent().getStringExtra("id");
        Booking tbooking = dbHandler.getSingleBooking(Integer.parseInt(id));

        tname.setText(tbooking.getTname());
        name.setText(tbooking.getName());
        nic.setText(tbooking.getNic());
        date.setText(tbooking.getDate());
        time.setText(tbooking.getTime());



    }
}