package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddBooking extends AppCompatActivity {


    private EditText tname,name, nic, date;
    private Button add;
    private DbHandler dbHandler;
    private Context context;
    private TimePickerDialog picker;
    private EditText eText;
    private DatePickerDialog picker1;
    private EditText dte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_booking);
        setTitle("Add Table Booking");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tname = findViewById(R.id.add_tname);
        name = findViewById(R.id.add_name);
        nic = findViewById(R.id.add_nic);
        eText= findViewById(R.id.add_time);
        eText.setInputType(InputType.TYPE_NULL);
        dte=(EditText) findViewById(R.id.add_date);
        dte.setInputType(InputType.TYPE_NULL);


        tname.setText(getIntent().getExtras().getString("table_name"));


        add = findViewById(R.id.add_button);
        context = this;

        dbHandler = new DbHandler(context);


        dte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker1 = new DatePickerDialog(AddBooking.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dte.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker1.show();
            }
        });


        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                picker = new TimePickerDialog(AddBooking.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                eText.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });






        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(tname.getText())){

                    tname.setError("Table Type Can't be Empty !");
                    tname.requestFocus();
                }
                else if(TextUtils.isEmpty(name.getText())){
                    name.setError("Name Can't be Empty !");
                    name.requestFocus();
                }

                else if(TextUtils.getTrimmedLength(name.getText()) < 4){
                    name.setError("Name must have atleast 4 letters !");
                    name.requestFocus();
                }


                else if(TextUtils.isEmpty(nic.getText())){
                    nic.setError("NIC Can't be Empty !");
                    nic.requestFocus();
                }


                else if(TextUtils.getTrimmedLength(nic.getText()) < 8){
                    nic.setError("Enter a valid NIC !");
                    nic.requestFocus();
                }

                else {
                    String tableName = tname.getText().toString();
                    String userName = name.getText().toString();
                    String userNic = nic.getText().toString();
                    String uDate = dte.getText().toString();
                    String uTime = eText.getText().toString();

                    Booking tbooking = new Booking(tableName, userName, userNic, uDate, uTime);
                    dbHandler.addBooking(tbooking);

                    startActivity(new Intent(context,BookingAll.class));
                }
            }
        });

    }
}