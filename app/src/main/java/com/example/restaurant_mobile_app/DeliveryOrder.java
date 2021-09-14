package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeliveryOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_order);
        setTitle("Deliver Order");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void gotocomplete (View view){
        Context context = getApplicationContext();
        CharSequence message = "You Can Edit Your Details within 5Min";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,100);
        toast.show();

        Intent intent = new Intent(DeliveryOrder.this,OrderComplete.class);

        EditText editText1 = (EditText)findViewById(R.id.edtxt_name);
        EditText editText2 = (EditText)findViewById(R.id.edtxt_phone);
        EditText editText3 = (EditText)findViewById(R.id.edtxt_address1);
        EditText editText4 = (EditText)findViewById(R.id.edtxt_address2);
        EditText editText5 = (EditText)findViewById(R.id.edtxt_address3);
        EditText editText6 = (EditText)findViewById(R.id.edtxt_email);

        String mzge1= editText1.getText().toString();
        String mzge2= editText2.getText().toString();
        String mzge3= editText3.getText().toString();
        String mzge4= editText4.getText().toString();
        String mzge5= editText5.getText().toString();
        String mzge6= editText6.getText().toString();

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