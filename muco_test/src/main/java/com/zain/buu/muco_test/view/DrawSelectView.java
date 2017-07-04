package com.zain.buu.muco_test.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.zain.buu.muco_test.R;

/**
 * Created by Zain on 2016/3/25.
 * <p>
 * 钢琴界面
 * 自定义小滑块组件
 * 使用重绘功能
 */
public class DrawSelectView extends View {

    private static float left = 0;  //左边距
    private static float top = 0;  //顶边距
    private static int wid = 200;  //宽
    private static int hei = 70;  //高
    //定义并创建画笔
    Paint p = new Paint();
    private int cont = 0; //防超计数器
    //第一次重绘小滑块布局
    private Bitmap bitmap = Bitmap.createScaledBitmap(
            BitmapFactory.decodeResource(getResources(), R.mipmap.all_key_kuang_min),
            wid, hei, true);

    //构造函数
    public DrawSelectView(Context context, AttributeSet set) {
        super(context, set);
    }

    public static float getDLeft() {
        return left;
    }

    public static void setDLeft(float dLeft) {
        left = dLeft;
    }

    public static float getDTop() {
        return top;
    }

    public static void setWid(int wid1) {
        wid = wid1;
    }

    //重绘事件
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (cont < 5) {  //防超
            bitmap = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(getResources(), R.mipmap.all_key_kuang_min),
                    wid, hei, true);
            cont++;
        }

        canvas.drawBitmap(bitmap, left, top, p);    //重绘
        Log.d("zain", "DSV left ：" + left); //调试
    }

}
