package com.zain.buu.muco_test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Zain on 2016/3/21.
 * <p>
 * ScrollView
 * 主活动的主界面
 * 整体纵向滑动自定义布局
 */
public class MyScrollView extends ScrollView {

    private float xStartLocation;   //x轴起始位置
    private float yStartLocation;   //y轴起始位置
    private float xDistance;    //x轴移动距离
    private float yDistance;    //y轴移动距离

    public MyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }


    //事件分发
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    //事件拦截
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:   //当手指按下的一个事件
                xStartLocation = event.getX();  //获取x轴起始位置
                yStartLocation = event.getY();  //获取y轴起始位置
                break;

            case MotionEvent.ACTION_MOVE:   //y移动
                float xCurrentLocation = event.getX();  //获取x轴移动后位置
                float yCurrentLocation = event.getY();  //获取y轴移动后位置

                //移动距离绝对值累加
                xDistance += Math.abs(xCurrentLocation - xStartLocation);
                yDistance += Math.abs(yCurrentLocation - yStartLocation);

                xStartLocation = xCurrentLocation;
                yStartLocation = yCurrentLocation;

                if (xDistance > yDistance) { //取消纵向滑动
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(event);  //启动事件

    }


}
