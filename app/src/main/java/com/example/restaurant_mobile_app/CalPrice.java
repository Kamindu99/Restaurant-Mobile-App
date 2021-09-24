package com.example.restaurant_mobile_app;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CalPrice extends AppCompatActivity {
    ImageView foodImg;
    TextView foodName,foodprice,total,value,schage,tax,ftotal;
    Button GoPayment,plus,minus;
    int count =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_price);
        setTitle("Select Quantity");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        foodImg=findViewById(R.id.food_detail_img);
        foodName=findViewById(R.id.food_detail_name);
        foodprice=findViewById(R.id.food_detail_price);
        total=findViewById(R.id.total);
        value=findViewById(R.id.value);
        schage=findViewById(R.id.schage);
        tax=findViewById(R.id.taxTxt);
        ftotal=findViewById(R.id.ftotal);

        GoPayment=findViewById(R.id.food_detail_btn);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);

        foodImg.setImageResource(getIntent().getExtras().getInt("Image_id"));
        foodName.setText(getIntent().getExtras().getString("food_name"));
        foodprice.setText(getIntent().getExtras().getString("food_price"));


        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!foodprice.getText().toString().equals("") &&!value.getText().toString().equals(""))
                {
                    int temp1 = Integer.parseInt(foodprice.getText().toString());
                    int temp2 = Integer.parseInt(value.getText().toString());
                    total.setText("Rs. "+String.valueOf(temp1*temp2));
                    ftotal.setText("Rs. "+String.valueOf((temp1*temp2*108)/100));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        foodprice.addTextChangedListener(textWatcher);
        value.addTextChangedListener(textWatcher);

        GoPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence message = "Pay total price";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                toast.show();

                Intent intent = new Intent(CalPrice.this, Payment.class);

                TextView textView=(TextView)findViewById(R.id.ftotal);

                String totalp= textView.getText().toString();
                intent.putExtra("total",totalp);
                intent.putExtra("fname",getIntent().getExtras().getString("food_name"));
                intent.putExtra("fImg",getIntent().getExtras().getInt("Image_id"));
                startActivity(intent);
                }


        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                value.setText(""+ count);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<=1) count=1;
                else count--;
                value.setText(""+count);
            }
        });


    }


    }