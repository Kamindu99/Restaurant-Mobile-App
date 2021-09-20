package com.example.restaurant_mobile_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewPayment extends AppCompatActivity {
    TextView tv_name;
    TextView tv_type;
    TextView tv_amount;
    TextView tv_number;
    TextView tv_date;
    TextView tv_cvv;
    Button btnview;
    DatabaseReference dbRef;
    Pay pay;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_payment);
        setTitle("View Payment Details");

        tv_name = findViewById(R.id.tv_name);
        tv_type = findViewById(R.id.tv_type);
        tv_amount = findViewById(R.id.tv_amount);
        tv_number = findViewById(R.id.tv_number);
        tv_date = findViewById(R.id.tv_date);
        tv_cvv = findViewById(R.id.tv_cvv);
        btnview = findViewById(R.id.btnview);

        pay = new Pay();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent receve = getIntent();
        Bundle page1= receve.getBundleExtra("ABC");
        String msgzg = page1.getString("Extra");

        id=msgzg;


        dbRef = FirebaseDatabase.getInstance("https://restaurant-mobile-app-26aef-default-rtdb.firebaseio.com/").getReference().child("Payment").child(id);
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                if(snapshot.hasChildren()){
                    tv_name.setText(snapshot.child("name").getValue().toString());
                    tv_type.setText(snapshot.child("mobileno").getValue().toString());
                    tv_amount.setText(snapshot.child("amount").getValue().toString());
                    tv_number.setText(snapshot.child("cardno").getValue().toString());
                    tv_date.setText(snapshot.child("date").getValue().toString());
                    tv_cvv.setText(snapshot.child("cvv").getValue().toString());

                }
                else
                    Toast.makeText(getApplicationContext(), "No payment to display", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError databaseError) {

            }
        });
    }

    public void gotopaymentcmplete(View view){
        Intent intent = new Intent(this, PaymentComplete.class);
        startActivity(intent);
    }
}



