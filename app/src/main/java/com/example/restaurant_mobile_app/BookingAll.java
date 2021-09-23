package com.example.restaurant_mobile_app;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookingAll extends AppCompatActivity {

    private ListView listView;
    Context context;
    private List<Booking> bookings;
    private DbHandler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_all);
        setTitle("Table Booking");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;

        dbHandler = new DbHandler(context);

        listView = findViewById(R.id.inquirylist);


        bookings = new ArrayList<>();

        bookings = dbHandler.getAllBookings();
        BookingAdapter adapter = new BookingAdapter(context,R.layout.single_booking,bookings);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Booking tbooking = bookings.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(tbooking.getTime());
                builder.setMessage("Edit,View or Cancel Booking");

                builder.setPositiveButton("Cacel Booking", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dbHandler.deleteBooking(tbooking.getId());
                        startActivity(new Intent(context,BookingAll.class));

                    }
                });
                builder.setNegativeButton("Edit Booking", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,EditBooking.class);
                        intent.putExtra("id",String.valueOf(tbooking.getId()));
                        startActivity(intent);
                    }
                });
                builder.setNeutralButton("View Booking", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,ViewBooking.class);
                        intent.putExtra("id",String.valueOf(tbooking.getId()));
                        startActivity(intent);
                    }
                });

                builder.show();

            }
        });

    }
}