package com.dr.rui.sotired.Util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by rui on 2015/8/8.
 */
public class VideoViewSize extends VideoView {
    public VideoViewSize(Context context) {
        super(context);
    }

    public VideoViewSize(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoViewSize(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int with = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, widthMeasureSpec - 200);
        setMeasuredDimension(with, height);
    }

}
