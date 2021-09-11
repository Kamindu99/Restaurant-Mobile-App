package com.example.restaurant_mobile_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    List<FoodModel> food_List;
    private Context context;

    public FoodAdapter(List<FoodModel> foodList ,Context context) {
        food_List=foodList;
        this.context=context;
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditem,parent,false);
        FoodViewHolder foodViewHolder=new FoodViewHolder(view);

        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        holder.foodImage.setImageResource(food_List.get(position).Image_id);
        holder.foodname.setText(food_List.get(position).name);
        holder.price.setText(food_List.get(position).price);

        holder.paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context.getApplicationContext(),CalPrice.class);
                intent.putExtra("Image_id",food_List.get(position).Image_id);
                intent.putExtra("food_name",food_List.get(position).name);
                intent.putExtra("food_price",food_List.get(position).price);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return food_List.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        TextView foodname,price;
        ImageView foodImage;
        RelativeLayout relativeLayout;
        Button paynow;
        public FoodViewHolder(@NonNull  View itemView) {
            super(itemView);
            foodname=itemView.findViewById(R.id.foodName);
            price=itemView.findViewById(R.id.foodprice);
            foodImage=itemView.findViewById(R.id.foodImg);
            relativeLayout=itemView.findViewById(R.id.food_layout_id);
            paynow=itemView.findViewById(R.id.buynow);


        }
    }
}
