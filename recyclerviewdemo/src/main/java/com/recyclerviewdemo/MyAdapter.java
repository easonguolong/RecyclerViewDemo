package com.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.recyclerviewdemo.R.id.mText;


/**
 * Created by Administrator on 2017/04/14.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public List<String> mDataSet;
    public  MyAdapter(List<String> data){
        mDataSet = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextV.setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextV;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextV = (TextView)itemView.findViewById(mText);
        }
    }

    public void removeData(int position){
        mDataSet.remove(position);
        notifyItemRemoved(position);
    }

}
