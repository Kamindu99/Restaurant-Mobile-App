package com.example.restaurant_mobile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TableList extends AppCompatActivity {

    RecyclerView recyclerView2;
    List<TableModel> tableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

        recyclerView2=findViewById(R.id.recycletable);

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setHasFixedSize(true);

        tableList=new ArrayList<>();
        tableList.add(new TableModel(R.drawable.table1,"2 Chair Table","500"));
        tableList.add(new TableModel(R.drawable.table2,"3 Chair Table","700"));
        tableList.add(new TableModel(R.drawable.table3,"4 Chair Table","800"));
        tableList.add(new TableModel(R.drawable.table4,"5 Chair Table","1000"));
        tableList.add(new TableModel(R.drawable.table1,"6 Chair Table","1200"));
        tableList.add(new TableModel(R.drawable.table2,"Family Table","1500"));
        tableList.add(new TableModel(R.drawable.table3,"Drinking Table","2000"));
        tableList.add(new TableModel(R.drawable.table4,"Birthday Table","2500"));
        tableList.add(new TableModel(R.drawable.table1,"Cuple Table","800"));

        TableAdapter adapter=new TableAdapter(tableList,this);
        recyclerView2.setAdapter(adapter);





    }
}