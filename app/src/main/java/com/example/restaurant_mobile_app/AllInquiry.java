package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class AllInquiry extends AppCompatActivity {

    private Button add;
    private ListView listView;
    Context context;
    private List<Inquiry> inquiries;
    private DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_inquiry);
        setTitle("Contact Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;

        dbHandler = new DatabaseHandler(context);
        add = findViewById(R.id.add);
        listView = findViewById(R.id.inquirylist);


        inquiries = new ArrayList<>();

        inquiries = dbHandler.getAllInquiries();
        InquiryAdapter adapter = new InquiryAdapter(context,R.layout.single_inquiry,inquiries);
        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddInquiry.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Inquiry inquiry = inquiries.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(inquiry.getSubject());
                builder.setMessage("Are you sure want to Edit or Delete this Inquiry?");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dbHandler.deleteInquiry(inquiry.getId());
                        Toast.makeText(getApplicationContext(), "Inquiry delete successfully", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(context,AllInquiry.class));

                    }
                });
                builder.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,EditInquiry.class);
                        intent.putExtra("id",String.valueOf(inquiry.getId()));
                        startActivity(intent);
                    }
                });
                builder.show();

            }
        });

    }
}