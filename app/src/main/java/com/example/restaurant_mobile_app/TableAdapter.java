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

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder>{

    List<TableModel> table_List;
    private Context context;

    public TableAdapter(List<TableModel> tableList ,Context context) {
        table_List=tableList;
        this.context=context;
    }

    @NonNull
    @Override
    public TableAdapter.TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tableitem,parent,false);
        TableAdapter.TableViewHolder tableViewHolder=new TableAdapter.TableViewHolder(view);

        return tableViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TableAdapter.TableViewHolder holder, int position) {
        holder.tableImage.setImageResource(table_List.get(position).Image_id);
        holder.tablename.setText(table_List.get(position).name);
        holder.price.setText(table_List.get(position).price);

        holder.booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context.getApplicationContext(),AboutUs.class);
                intent.putExtra("Image_id",table_List.get(position).Image_id);
                intent.putExtra("table_name",table_List.get(position).name);
                intent.putExtra("table_price",table_List.get(position).price);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return table_List.size();
    }

    public class TableViewHolder extends RecyclerView.ViewHolder {

        TextView tablename,price;
        ImageView tableImage;
        RelativeLayout relativeLayout;
        Button booknow;
        public TableViewHolder(@NonNull  View itemView) {
            super(itemView);
            tablename=itemView.findViewById(R.id.tableName);
            price=itemView.findViewById(R.id.tableprice);
            tableImage=itemView.findViewById(R.id.tableImg);
            relativeLayout=itemView.findViewById(R.id.table_layout_id);
            booknow=itemView.findViewById(R.id.booknow);


        }
    }

}
