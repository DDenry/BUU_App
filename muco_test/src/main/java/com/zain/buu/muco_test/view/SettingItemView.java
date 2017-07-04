package com.zain.buu.muco_test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zain.buu.muco_test.R;

/**
 * Created by Zain on 2016/3/22.
 * <p>
 * 主活动中的设置页面中的
 * 每一栏自定义布局
 */
public class SettingItemView extends LinearLayout {

    private ImageView imageView_Left;   //左边图片
    private ImageView imageView_Right;  //右边图片
    private TextView textView;  //中间文字

    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(); //初始化布局
    }

    /**
     * 初始化布局
     */
    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());    //创建布局加载器
        View view = inflater.inflate(R.layout.set_main_item_layout, this);  //创建一个新的布局
        findView(view); //获取布局文件
    }

    /**
     * 获取布局文件
     *
     * @param view
     */
    private void findView(View view) {
        imageView_Left = (ImageView) view.findViewById(R.id.log_left);
        imageView_Right = (ImageView) view.findViewById(R.id.log_right);
        textView = (TextView) view.findViewById(R.id.text_set);
    }


    /**
     * 属性的get\set方法
     *
     * @return
     */
    public TextView getTextView() {
        return textView;
    }

    public void setTextView(String text) {
        textView.setText(text);
    }

    public ImageView getImageView_Left() {
        return imageView_Left;
    }

    public void setImageView_Left(int img) {
        imageView_Left.setBackgroundResource(img);
    }

    public ImageView getImageView_Right() {
        return imageView_Right;
    }

    public void setImageView_Right(int img) {
        imageView_Right.setBackgroundResource(img);
    }


}
