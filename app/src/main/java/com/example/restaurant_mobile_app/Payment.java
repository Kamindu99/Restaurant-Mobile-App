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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Payment extends AppCompatActivity {
    EditText ed_name;
    EditText ed_mobileno;
    TextView tv_payprice;
    EditText ed_no;
    EditText ed_date;
    EditText ed_valid;
    Button id_btnpay;
    DatabaseReference dbRef;
    Pay pay;
    long maxID;

    private void clearControls(){
        ed_name.setText("");
        ed_mobileno.setText("");
        tv_payprice.setText("");
        ed_no.setText("");
        ed_date.setText("");
        ed_valid.setText("");


    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle("Payment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ed_name = findViewById(R.id.ed_name);
        ed_mobileno = findViewById(R.id.ed_mobileno);
        tv_payprice = findViewById(R.id.tv_payPrice);

        ed_no = findViewById(R.id.ed_no);
        ed_date = findViewById(R.id.ed_date);
        ed_valid = findViewById(R.id.ed_valid);
        id_btnpay = findViewById(R.id.id_btnpay);

        pay = new Pay();
        dbRef = FirebaseDatabase.getInstance("https://restaurant-mobile-app-26aef-default-rtdb.firebaseio.com/").getReference().child("Payment");
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

        id_btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(TextUtils.isEmpty(ed_name.getText().toString())){
                        ed_name.setError("Name Can't be Empty !");
                        ed_name.requestFocus();
                    }

                    else if (TextUtils.isEmpty(ed_mobileno.getText().toString())){
                        ed_mobileno.setError("Mobile Number Can't be Empty !");
                        ed_mobileno.requestFocus();
                    }
                    else if(TextUtils.getTrimmedLength(ed_mobileno.getText()) != 10){
                        ed_mobileno.setError("Mobile no must have 10 digits!");
                        ed_mobileno.requestFocus();
                    }



                    else if(TextUtils.isEmpty(tv_payprice.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Price", Toast.LENGTH_SHORT).show();

                    else if (TextUtils.isEmpty(ed_no.getText().toString())){
                        ed_no.setError("Card Number Can't be Empty !");
                        ed_no.requestFocus();
                    }
                    else if(TextUtils.getTrimmedLength(ed_no.getText()) != 12){
                        ed_no.setError("Card no must have 12 digits!");
                        ed_no.requestFocus();
                    }




                    else if (TextUtils.isEmpty(ed_date.getText().toString())){
                        ed_date.setError("Date Can't be Empty !");
                        ed_date.requestFocus();
                    }


                    else if (TextUtils.isEmpty(ed_valid.getText().toString())){
                        ed_valid.setError("CVV Can't be Empty !");
                        ed_valid.requestFocus();
                    }
                    else if(TextUtils.getTrimmedLength(ed_valid.getText()) != 3){
                        ed_valid.setError("Cvv must have 3 digits!");
                        ed_valid.requestFocus();
                    }





                    else{
                        pay.setName(ed_name.getText().toString().trim());
                        pay.setMobileno(Integer.parseInt(ed_mobileno.getText().toString().trim()));
                        pay.setAmount(tv_payprice.getText().toString().trim());
                        pay.setCardno(Long.parseLong(ed_no.getText().toString().trim()));
                        pay.setDate(ed_date.getText().toString().trim());
                        pay.setCvv(Integer.parseInt(ed_valid.getText().toString().trim()));

                        //dbRef.push().setValue(pay);
                        String id="Pay"+(maxID+1);
                        dbRef.child(String.valueOf(id)).setValue(pay);
                        Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Payment.this, PaymentComplete.class);
                        String mzge= id;
                        Bundle extras = new Bundle();
                        extras.putString("Extra",mzge);
                        intent.putExtras(extras);
                        startActivity(intent);

                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Enter valid mobile number", Toast.LENGTH_SHORT).show();
                }
            }
        });





        TextView textView=(TextView)findViewById(R.id.tv_payPrice);
        Intent receve = getIntent();
        String total = receve.getStringExtra("total");

        textView.setText(total);
    }

}
