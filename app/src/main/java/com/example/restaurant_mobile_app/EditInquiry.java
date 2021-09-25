package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditInquiry extends AppCompatActivity {

    private EditText name, email, subject, content;
    private Button edit;
    private DatabaseHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_inquiry);
        setTitle("Edit inquiry");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;
        dbHandler = new DatabaseHandler(context);

        name = findViewById(R.id.edit_name);
        email = findViewById(R.id.edit_email);
        subject = findViewById(R.id.edit_subject);
        content = findViewById(R.id.edit_content);
        edit = findViewById(R.id.edit_button);

        final String id = getIntent().getStringExtra("id");
        Inquiry inquiry = dbHandler.getSingleInquiry(Integer.parseInt(id));

        name.setText(inquiry.getName());
        email.setText(inquiry.getEmail());
        subject.setText(inquiry.getSubject());
        content.setText(inquiry.getContent());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(name.getText())) {

                    name.setError("Name Can't be Empty !");
                    name.requestFocus();
                } else if (TextUtils.isEmpty(email.getText())) {

                    email.setError("Email Can't be Empty !");
                    email.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {

                    email.setError("Invalid Email Address !");
                    email.requestFocus();
                }else if (TextUtils.isEmpty(subject.getText())) {

                    subject.setError("Subject Can't be Empty !");
                    subject.requestFocus();
                } else if (TextUtils.isEmpty(content.getText())) {

                    content.setError("Content Can't be Empty !");
                    content.requestFocus();
                } else {
                    String nameText = name.getText().toString();
                    String emailText = email.getText().toString();
                    String subjectText = subject.getText().toString();
                    String contentText = content.getText().toString();

                    Inquiry inquiry = new Inquiry(Integer.parseInt(id), nameText, emailText, subjectText, contentText);
                    int state = dbHandler.updateSingleInquiry(inquiry);
                    Toast.makeText(getApplicationContext(), "Update successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(context, AllInquiry.class));
                }
            }
        });


    }


}