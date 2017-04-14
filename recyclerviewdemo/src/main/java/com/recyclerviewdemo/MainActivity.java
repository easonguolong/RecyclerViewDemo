package com.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView mRV;
    public MyAdapter adapter;
    public List<String> mData;

    private Toolbar mToolbar;

    private RecyclerView.LayoutManager mLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerlayout);
        initToolbar();
        mData = new ArrayList<String>();
        for(int i=0;i<50;i++){
            mData.add("Eason-"+i);
        }
        mRV = (RecyclerView)findViewById(R.id.mrecycleView);
        mLy = new LinearLayoutManager(this);
        mRV.setLayoutManager(mLy);
        adapter = new MyAdapter(mData);
        mRV.setAdapter(adapter);
        mRV.addOnItemTouchListener(new RecyclerViewClickListener(this,mRV, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               Toast.makeText(MainActivity.this,"Click "+mData.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //adapter.removeData(position);
                Toast.makeText(MainActivity.this,"Long Click "+mData.get(position),Toast.LENGTH_SHORT).show();
            }
        }));
    }

    public void initToolbar(){
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("EasonRV");
        mToolbar.setSubtitle("demo");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
    }

}
