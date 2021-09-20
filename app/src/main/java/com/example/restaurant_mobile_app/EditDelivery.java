package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EditDelivery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delivery);
        setTitle("Edit Delivery Details");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView text1=findViewById(R.id.edtxt_name2);
        TextView text2=findViewById(R.id.edtxt_phone2);
        TextView text3=findViewById(R.id.edtxt_address_1);
        TextView text4=findViewById(R.id.edtxt_address_2);
        TextView text5=findViewById(R.id.edtxt_address3_3);
        TextView text6=findViewById(R.id.edtxt_email2);

        Intent receve = getIntent();
        Bundle page1= receve.getBundleExtra("ABC");
        String mzge1 = page1.getString("Extra1");
        String mzge2 = page1.getString("Extra2");
        String mzge3 = page1.getString("Extra3");
        String mzge4 = page1.getString("Extra4");
        String mzge5 = page1.getString("Extra5");
        String mzge6 = page1.getString("Extra6");

        text1.setText(mzge1);
        text2.setText(mzge2);
        text3.setText(mzge3);
        text4.setText(mzge4);
        text5.setText(mzge5);
        text6.setText(mzge6);

    }


    public void gotocomplete (View view){
        Context context = getApplicationContext();
        CharSequence message = "Your Details Updated";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,100);
        toast.show();

        Intent intent = new Intent(this,OrderComplete.class);
        startActivity(intent);
    }

    public void gotoback (View view){

        Intent intent = new Intent(this,OrderComplete.class);
        startActivity(intent);
    }
}