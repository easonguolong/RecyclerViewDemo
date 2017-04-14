package com.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/04/14.
 */

public class RecyclerViewClickListener implements RecyclerView.OnItemTouchListener {


    private OnItemClickListener mListener;
    private GestureDetector mGestureDetector;  //手势监测

    //内部接口，定义点击方法以及长按方法
    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public RecyclerViewClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View childview = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if(childview!=null&& mListener !=null){
                    mListener.onItemClick(childview,recyclerView.getChildLayoutPosition(childview));
                    return  true;
                }
                return false;
            }
            @Override
            public void onLongPress(MotionEvent e) {
                View childview = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if(childview!=null&& mListener !=null){
                    mListener.onItemLongClick(childview,recyclerView.getChildLayoutPosition(childview));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//        int x = (int)e.getX();
//        int y = (int)e.getY();
//        switch (e.getAction()){
//            /*  如果是ACTION_DOWN事件，那么记录当前按下的位置，
//            *  记录当前的系统时间。
//            */
//            case MotionEvent.ACTION_DOWN:
//                mLastDownX =x;
//                mLastDownY =y;
//                mDownTime = System.currentTimeMillis();
//                isMove = false;
//                break;
//            /**
//             *  如果是ACTION_MOVE事件，此时根据TouchSlop判断用户在按下的时候是否滑动了，
//             *  如果滑动了，那么接下来将不处理点击事件
//             */
//            case MotionEvent.ACTION_MOVE:
//                if(Math.abs(x - mLastDownX)>touchSlop || Math.abs(y - mLastDownY)>touchSlop){
//                    isMove = true;
//                }
//                break;
//            /**
//             *  如果是ACTION_UP事件，那么根据isMove标志位来判断是否需要处理点击事件；
//             *  根据系统时间的差值来判断是哪种事件，如果按下事件超过1s，则认为是长按事件，
//             *  否则是单击事件。
//             */
//            case MotionEvent.ACTION_UP:
//                if(isMove){
//                    break;
//                }
//                if((System.currentTimeMillis()-mDownTime)>1000){
//                    isLongPressUp = true;
//                }else{
//                    isSingleTapUp = true;
//                }
//                break;
//        }
//        if(isSingleTapUp){
//            //根据触摸坐标来获取childview
//            View childview = rv.findChildViewUnder(e.getX(),e.getY());
//            isSingleTapUp = false;
//            if(childview!=null){
//                mListener.onItemClick(childview,rv.getChildLayoutPosition(childview));
//                return true;
//            }
//            return false;
//        }
//        if(isLongPressUp){
//            View childview = rv.findChildViewUnder(e.getX(),e.getY());
//            isLongPressUp = false;
//            if(childview != null){
//                mListener.onItemLongClick(childview, rv.getChildLayoutPosition(childview));
//                return true;
//            }
//            return false;
//        }
        //把事件交给GestureDetector处理
        if(mGestureDetector.onTouchEvent(e)){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
