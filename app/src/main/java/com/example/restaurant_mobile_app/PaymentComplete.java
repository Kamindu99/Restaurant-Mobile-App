package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class PaymentComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_complete);
        setTitle("Payment Confirmation");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void gotoView (View view) {
        Context context = getApplicationContext();
        CharSequence message = "View Paymet Details";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
        toast.show();

        Intent intent2= getIntent();
        Bundle bundle=intent2.getExtras();


        Intent intent = new Intent(PaymentComplete.this, ViewPayment.class);
        intent.putExtra("ABC",bundle);
        startActivity(intent);
    }

    public void gotoDelivery(View view) {
        Context context = getApplicationContext();
        CharSequence message = "Enter Your Delivery Details";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
        toast.show();

        Intent intent2= getIntent();
        Bundle bundle=intent2.getExtras();
        Intent intent = new Intent(PaymentComplete.this, DeliveryOrder.class);
        intent.putExtra("ABC",bundle);
        startActivity(intent);
    }

    public void gotoHome(View view) {
        Context context = getApplicationContext();
        CharSequence message = "Order Your Favourite Food item";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
        toast.show();

        Intent intent = new Intent(PaymentComplete.this, MainActivity.class);
        startActivity(intent);
    }


}