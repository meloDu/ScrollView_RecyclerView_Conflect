package com.melo.scrollview_recyclerview_conflect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class HorizontalRecycleview extends RecyclerView {
    private float mLastXIntercept = 0f;
    private float mLastYIntercept = 0f;

    public HorizontalRecycleview(Context context) {
        super(context);
    }

    public HorizontalRecycleview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                //横坐标位移增量
                float deltaX = x - mLastXIntercept;
                //纵坐标位移增量
                float deltaY = y - mLastYIntercept;

                if (Math.abs(deltaX) < Math.abs(deltaY)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
        }
        mLastXIntercept = x;
        mLastYIntercept = y;

        return super.dispatchTouchEvent(ev);
    }


}
