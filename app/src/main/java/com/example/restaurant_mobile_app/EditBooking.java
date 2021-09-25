package com.example.restaurant_mobile_app;



import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class EditBooking extends AppCompatActivity {


    private EditText tname, name, nic, date, time;
    private Button edit;
    private DbHandler dbHandler;
    private Context context;
    private TextView tbname;
    private TimePickerDialog picker;

    private DatePickerDialog picker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_booking);
        setTitle("Edit Table Booking");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;
        dbHandler = new DbHandler(context);

        tname = findViewById(R.id.edit_tname);
        name = findViewById(R.id.edit_name);
        nic = findViewById(R.id.edit_nic);
        date = findViewById(R.id.edit_date);
        time = findViewById(R.id.edit_time);
        edit = findViewById(R.id.edit_button);
        tbname = findViewById(R.id.table_edit_detail_name);


        final String id = getIntent().getStringExtra("id");
        Booking tbooking = dbHandler.getSingleBooking(Integer.parseInt(id));

        tname.setText(tbooking.getTname());
        name.setText(tbooking.getName());
        nic.setText(tbooking.getNic());
        date.setText(tbooking.getDate());
        time.setText(tbooking.getTime());
        tbname.setText(tbooking.getTname());

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker1 = new DatePickerDialog(EditBooking.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override

                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker1.show();
            }
        });


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                picker = new TimePickerDialog(EditBooking.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                time.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });




        edit.setOnClickListener(new View.OnClickListener() {
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

                else if(TextUtils.getTrimmedLength(name.getText()) < 3){
                    name.setError("Name must have atleast 3 letters !");
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

                    String tnameText = tname.getText().toString();
                    String nameText = name.getText().toString();
                    String nicText = nic.getText().toString();
                    String dateText = date.getText().toString();
                    String timeText = time.getText().toString();

                    Booking tbooking = new Booking(Integer.parseInt(id), tnameText, nameText, nicText, dateText, timeText);
                    int state = dbHandler.updateSingleBooking(tbooking);
                    startActivity(new Intent(context,BookingAll.class));
                }
            }
        });


    }
}