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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeliveryOrder extends AppCompatActivity {

    EditText name,phone,address1,address2,address3,email;
    Button btnsave;
    DatabaseReference dbRef;
    Delivery delivery;
    long maxID;

    private  void clearControls(){
        name.setText("");
        phone.setText("");
        address1.setText("");
        address2.setText("");
        address3.setText("");
        email.setText("");
    }



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

        btnsave=findViewById(R.id.btn_deliveryCnfrm);

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

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (TextUtils.isEmpty(name.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(phone.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Phone",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(address1.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Address1",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(address2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Address2",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(address3.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Address3",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(email.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Email",Toast.LENGTH_SHORT).show();

                    else{
                        delivery.setName(name.getText().toString().trim());
                        delivery.setPhone(Integer.parseInt(phone.getText().toString().trim()));
                        delivery.setAddress1(address1.getText().toString().trim());
                        delivery.setAddress2(address2.getText().toString().trim());
                        delivery.setAddress3(address3.getText().toString().trim());
                        delivery.setEmail(email.getText().toString().trim());

                        //dbRef.push().setValue(std);
                        // dbRef.child(txtID.getText().toString().trim()).setValue(std);

                        dbRef.child(String.valueOf("Del"+(maxID+1))).setValue(delivery);
                        Toast.makeText(getApplicationContext(),"Successfull Added! You Can Edit Your Details within 5Min! ",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(DeliveryOrder.this,OrderComplete.class);

                        String mzge1= name.getText().toString();
                        String mzge2= phone.getText().toString();
                        String mzge3= address1.getText().toString();
                        String mzge4= address2.getText().toString();
                        String mzge5= address3.getText().toString();
                        String mzge6= email.getText().toString();

                        Bundle extras = new Bundle();
                        extras.putString("Extra1",mzge1);
                        extras.putString("Extra2",mzge2);
                        extras.putString("Extra3",mzge3);
                        extras.putString("Extra4",mzge4);
                        extras.putString("Extra5",mzge5);
                        extras.putString("Extra6",mzge6);
                        intent.putExtras(extras);

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