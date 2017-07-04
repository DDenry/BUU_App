package com.zain.buu.muco_test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Zain on 2016/3/21.
 * <p>
 * 主活动的主界面
 * 自定义可滑动列表
 */
public class MyGridVIew extends GridView {

    //构造函数
    public MyGridVIew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /**
     * 确定尺寸的
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int exPectHeight = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, exPectHeight);
    }


}
