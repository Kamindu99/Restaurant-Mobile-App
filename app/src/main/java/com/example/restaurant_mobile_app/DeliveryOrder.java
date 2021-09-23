package com.example.restaurant_mobile_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeliveryOrder extends AppCompatActivity {

    EditText name,phone,address1,address2,address3,email;
    Button btnsave;
    private DatabaseReference dbRef;
    Delivery delivery;
    long maxID;
    TextView fname;
    ImageView fImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_order);
        setTitle("Deliver Order");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name =findViewById(R.id.edtxt_name);
        phone=findViewById(R.id.edtxt_phone);
        address1=findViewById(R.id.edtxt_address1);
        address2=findViewById(R.id.edtxt_address2);
        address3=findViewById(R.id.edtxt_address3);
        email=findViewById(R.id.edtxt_email);
        fname=findViewById(R.id.tv_foodNameD);
        fImg=findViewById(R.id.img_fImg);

        String ffname =getIntent().getBundleExtra("ABC").getString("foodname");
        fname.setText("You Order "+ffname);
        fImg.setImageResource(getIntent().getBundleExtra("ABC").getInt("foodImg"));

        btnsave=findViewById(R.id.btn_deliveryCnfrm);

        delivery=new Delivery();

        dbRef= FirebaseDatabase.getInstance().getReference().child("Delivery");
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

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (TextUtils.isEmpty(name.getText().toString())){
                        name.setError("Name Can't be Empty !");
                    name.requestFocus();
                    }
                    else if(TextUtils.isEmpty(phone.getText().toString()))
                    {
                        phone.setError("Phone Can't be Empty !");
                        phone.requestFocus();
                    }
                    else if (TextUtils.getTrimmedLength(phone.getText()) != 10){
                        phone.setError("Mobile number should have 10 digits !");
                        phone.requestFocus();
                    }
                    else if(TextUtils.isEmpty(address1.getText().toString()))
                    {
                        address1.setError("Address Can't be Empty !");
                        address1.requestFocus();
                    }
                    else if(TextUtils.isEmpty(email.getText().toString()))
                    {
                        email.setError("Email Can't be Empty !");
                        email.requestFocus();
                    }

                    else{
                        delivery.setName(name.getText().toString().trim());
                        delivery.setPhone(Long.parseLong(phone.getText().toString().trim()));
                        delivery.setAddress1(address1.getText().toString().trim());
                        delivery.setAddress2(address2.getText().toString().trim());
                        delivery.setAddress3(address3.getText().toString().trim());
                        delivery.setEmail(email.getText().toString().trim());

                        //dbRef.push().setValue(std);
                        // dbRef.child(txtID.getText().toString().trim()).setValue(std);

                        String id="Delivery_0"+(maxID+1);
                        dbRef.child(String.valueOf(id)).setValue(delivery);
                        Toast.makeText(getApplicationContext(),"Successfull Added! You Can Edit Your Details within 5Min! ",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(DeliveryOrder.this,OrderComplete.class);
                        intent.putExtra("id",id);
                        startActivity(intent);

                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalide Phone Number",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}