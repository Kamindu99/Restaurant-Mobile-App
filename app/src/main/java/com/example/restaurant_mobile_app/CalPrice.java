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
    TextView foodName,foodprice,total;
    EditText quntity;
    Button GoPayment;

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
        quntity=findViewById(R.id.inputquntity);
        GoPayment=findViewById(R.id.food_detail_btn);

        foodImg.setImageResource(getIntent().getExtras().getInt("Image_id"));
        foodName.setText(getIntent().getExtras().getString("food_name"));
        foodprice.setText(getIntent().getExtras().getString("food_price"));

        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!foodprice.getText().toString().equals("") &&!quntity.getText().toString().equals(""))
                {
                    int temp1 = Integer.parseInt(foodprice.getText().toString());
                    int temp2 = Integer.parseInt(quntity.getText().toString());
                    total.setText(String.valueOf(temp1*temp2));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        foodprice.addTextChangedListener(textWatcher);
        quntity.addTextChangedListener(textWatcher);

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

                TextView textView=(TextView)findViewById(R.id.total);

                String totalp= textView.getText().toString();
                intent.putExtra("total",totalp);
                startActivity(intent);
                }


        });
    }

    }