package com.openxu.rv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.openxu.rv.adapter.CommandRecyclerAdapter;
import com.openxu.rv.adapter.ViewHolder;
import com.openxu.rv.divider.GridDividerDecoration;

import java.util.ArrayList;
import java.util.List;

public class ActivityGridLayoutManagerHorizontal extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> dataList;
    private CommandRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();
        for(int i=1;i<=50;i++){
            dataList.add("item--"+i);
        }

        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager mGridtManager = new GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mGridtManager);
        adapter = new CommandRecyclerAdapter<String>
                (this, R.layout.item_grid_horizontal, dataList) {
            @Override
            public void convert(ViewHolder holder, String str) {
                holder.setText(R.id.tv_item, str);
            }
            @Override
            public void onItemClick(String str, int position) {
            }
        };
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new GridDividerDecoration(this));

    }
}
