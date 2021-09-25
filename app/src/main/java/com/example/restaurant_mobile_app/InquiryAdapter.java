package com.example.restaurant_mobile_app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class InquiryAdapter extends ArrayAdapter<Inquiry> {

    private Context context;
    private int resource;
    List<Inquiry> inquiries;

    InquiryAdapter(Context context, int resource, List<Inquiry> inquiries){
        super(context,resource,inquiries);
        this.context = context;
        this.resource = resource;
        this.inquiries = inquiries;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView title = row.findViewById(R.id.subject);
        TextView desc = row.findViewById(R.id.des);

        Inquiry inquiry = inquiries.get(position);
        title.setText(inquiry.getSubject());
        desc.setText(inquiry.getContent());

        return row;
    }
}

