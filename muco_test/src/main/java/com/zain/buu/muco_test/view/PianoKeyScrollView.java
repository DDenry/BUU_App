package com.zain.buu.muco_test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by Zain on 2016/3/25.
 * <p>
 * HorizontalScrollView
 * 琴键滑动部分，自定义滑动布局
 */
public class PianoKeyScrollView extends HorizontalScrollView {

    //常用位置变量
    private float xStartLocation;
    private float yStartLocation;
    private float xDistance;
    private float yDistance;

    //构造函数
    public PianoKeyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //事件分发
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    //事件拦截
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

}
