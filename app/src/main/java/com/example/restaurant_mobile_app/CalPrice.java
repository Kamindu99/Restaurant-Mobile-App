package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CalPrice extends AppCompatActivity {
    ImageView foodImg;
    TextView foodName,foodprice,total;
    EditText quntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_price);

        foodImg=findViewById(R.id.food_detail_img);
        foodName=findViewById(R.id.food_detail_name);
        foodprice=findViewById(R.id.food_detail_price);
        total=findViewById(R.id.total);
        quntity=findViewById(R.id.inputquntity);

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



    }
}