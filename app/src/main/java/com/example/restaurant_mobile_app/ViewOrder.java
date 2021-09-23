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

public class ViewOrder extends AppCompatActivity {

    TextView name,phone,address1,address2,address3,email,headname;
    Button btnBack,btncancel;
    Delivery delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        setTitle("View Order Details");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name=findViewById(R.id.tv_disName);
        phone=findViewById(R.id.tv_disPhone);
        address1=findViewById(R.id.tv_disAddress1);
        address2=findViewById(R.id.tv_disAddress2);
        address3=findViewById(R.id.tv_disAddress3);
        email=findViewById(R.id.tv_disEmail);
        headname=findViewById(R.id.headname);

        btnBack=findViewById(R.id.btn_viewBack);
        btncancel=findViewById(R.id.btn_canclorder);
        delivery=new Delivery();

        final String id = getIntent().getStringExtra("id");

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child(id);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.hasChildren()){
                    name.setText(snapshot.child("name").getValue().toString());
                    phone.setText(snapshot.child("phone").getValue().toString());
                    address1.setText(snapshot.child("address1").getValue().toString());
                    address2.setText(snapshot.child("address2").getValue().toString());
                    address3.setText(snapshot.child("address3").getValue().toString());
                    email.setText(snapshot.child("email").getValue().toString());
                    headname.setText(snapshot.child("name").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"No sourse to Display",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference upRef=FirebaseDatabase.getInstance().getReference().child("Delivery");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(id)){
                            DatabaseReference deleteRef=FirebaseDatabase.getInstance().getReference().child("Delivery").child(id);
                            deleteRef.removeValue();
                            Toast.makeText(getApplicationContext(),"Order Cancel Successfull",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ViewOrder.this, PaymentComplete.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No sourse to Cancel",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewOrder.this,EditDelivery.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


    }
}