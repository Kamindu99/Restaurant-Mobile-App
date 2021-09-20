package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle("Payment");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView=(TextView)findViewById(R.id.tv_payPrice);
        Intent receve = getIntent();
        String total = receve.getStringExtra("total");

        textView.setText(total);
    }
    public void gotoPaymentComplete (View view) {
        Context context = getApplicationContext();
        CharSequence message = "Payment Successfull";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
        toast.show();

        Intent intent = new Intent(Payment.this, PaymentComplete.class);
        startActivity(intent);
    }
}