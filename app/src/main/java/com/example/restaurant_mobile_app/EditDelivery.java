package com.example.restaurant_mobile_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditDelivery extends AppCompatActivity {

    EditText name,phone,address1,address2,address3,email;
    Button btnUpdate;
    Delivery delivery;
    DatabaseReference dbRef;
    long maxID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delivery);
        setTitle("Edit Delivery Details");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name=findViewById(R.id.edtxt_name2);
        phone=findViewById(R.id.edtxt_phone2);
        address1=findViewById(R.id.edtxt_address_1);
        address2=findViewById(R.id.edtxt_address_2);
        address3=findViewById(R.id.edtxt_address3_3);
        email=findViewById(R.id.edtxt_email2);

        btnUpdate=findViewById(R.id.btn_editdelivery);

        delivery=new Delivery();

        dbRef= FirebaseDatabase.getInstance("https://restaurant-mobile-app-f72d8-default-rtdb.firebaseio.com/").getReference().child("Delivery");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxID=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Intent receve = getIntent();
        Bundle page1= receve.getBundleExtra("ABC");
        String mzge1 = page1.getString("Extra1");
        String mzge2 = page1.getString("Extra2");
        String mzge3 = page1.getString("Extra3");
        String mzge4 = page1.getString("Extra4");
        String mzge5 = page1.getString("Extra5");
        String mzge6 = page1.getString("Extra6");

        name.setText(mzge1);
        phone.setText(mzge2);
        address1.setText(mzge3);
        address2.setText(mzge4);
        address3.setText(mzge5);
        email.setText(mzge6);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference upRef= FirebaseDatabase.getInstance().getReference().child("Delivery");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Del1")) {
                            try {
                                delivery.setName(name.getText().toString().trim());
                                delivery.setPhone(Integer.parseInt(phone.getText().toString().trim()));
                                delivery.setAddress1(address1.getText().toString().trim());
                                delivery.setAddress2(address2.getText().toString().trim());
                                delivery.setAddress3(address3.getText().toString().trim());
                                delivery.setEmail(email.getText().toString().trim());

                                dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("Del1");
                                dbRef.setValue(delivery);
                                Toast.makeText(getApplicationContext(), "SuccessFully Update", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(EditDelivery.this,OrderComplete.class);
                                startActivity(intent);

                            }

                            catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalide No", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No sourse to Update",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


    }

}