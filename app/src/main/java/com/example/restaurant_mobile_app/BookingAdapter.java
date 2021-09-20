package com.example.restaurant_mobile_app;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookingAdapter extends ArrayAdapter<Booking> {


    private Context context;
    private int resource;
    List<Booking> bookings;

    BookingAdapter(Context context, int resource, List<Booking> bookings){
        super(context,resource,bookings);
        this.context = context;
        this.resource = resource;
        this.bookings = bookings;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView tname = row.findViewById(R.id.tab);
        TextView time = row.findViewById(R.id.tt);


        Booking tbooking = bookings.get(position);
        tname.setText(tbooking.getTname());
        time.setText(tbooking.getDate());




        return row;
    }
}

