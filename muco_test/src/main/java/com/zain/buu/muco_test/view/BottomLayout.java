package com.zain.buu.muco_test.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zain.buu.muco_test.R;

/**
 * Created by Zain on 2016/3/20.
 * <p/>
 * 主活动的底部栏自定义布局
 */
public class BottomLayout extends LinearLayout {

    ICallbackLister callbackLister = null;    //创建监听接口
    private RelativeLayout mocuLayout;  //主界面按钮
    private RelativeLayout setLayout;   //设置界面按钮
    private LayoutInflater inflater;    //布局控制器

    //构造函数
    public BottomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(); //初始化布局
    }

    //初始化布局
    private void initView() {
        inflater = LayoutInflater.from(getContext());   //创建布局构造器
        View view = inflater.inflate(R.layout.bottom_layout, this);  //创建新布局
        findView(view); //获取布局文件
        setOnclick();   //设置点击事件
        initData(); //初始化数据
    }

    //获取组件
    public void findView(View view) {
        mocuLayout = (RelativeLayout) view.findViewById(R.id.mucoLayout);
        setLayout = (RelativeLayout) view.findViewById(R.id.setLayout);
    }

    //获取监听
    public void setOnclick() {
        mocuLayout.setOnClickListener(new listener());
        setLayout.setOnClickListener(new listener());
    }

    //初始化
    public void initData() {
        //主界面布局部分
        mocuLayout.findViewById(R.id.tabImg).setBackgroundResource(R.mipmap.muco_logo);
        TextView txt = (TextView) mocuLayout.findViewById(R.id.tabText);
        txt.setText("乐器");
        txt.setTextColor(Color.BLUE);

        //设置界面布局部分
        setLayout.findViewById(R.id.tabImg).setBackgroundResource(R.mipmap.image_tabbar_button_more);
        TextView txt1 = (TextView) setLayout.findViewById(R.id.tabText);
        txt1.setText("设置");
        txt1.setTextColor(Color.WHITE);

    }

    //切换图片
    public void initPic(int i) {
        switch (i) {
            case 0: //点击主界面按钮时
                //设置该组件点击后事件
                mocuLayout.findViewById(R.id.tabImg).setBackgroundResource(R.mipmap.muco_logo);
                TextView txt = (TextView) mocuLayout.findViewById(R.id.tabText);
                txt.setTextColor(Color.BLUE);

                //设置其他组件事件
                setLayout.findViewById(R.id.tabImg).setBackgroundResource(R.mipmap.image_tabbar_button_more);
                TextView txt1 = (TextView) setLayout.findViewById(R.id.tabText);
                txt1.setTextColor(Color.WHITE);

                break;

            case 1: //点击设置界面按钮时
                //设置该组件点击后事件
                setLayout.findViewById(R.id.tabImg).setBackgroundResource(R.mipmap.image_tabbar_button_more_down);
                TextView txt2 = (TextView) setLayout.findViewById(R.id.tabText);
                txt2.setTextColor(Color.BLUE);

                //设置其他组件事件
                mocuLayout.findViewById(R.id.tabImg).setBackgroundResource(R.mipmap.muco_logo_hui);
                TextView txt3 = (TextView) mocuLayout.findViewById(R.id.tabText);
                txt3.setTextColor(Color.WHITE);
                break;

        }
    }

    //配置监听接口函数
    public void setOnCallbackLister(ICallbackLister callbackLister) {
        this.callbackLister = callbackLister;
    }

    //回传监听事件
    public interface ICallbackLister {
        void click(int id);
    }

    //监听事件
    private class listener implements OnClickListener {

        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.mucoLayout) {//1.点击更换图标
                initPic(0);
            } else if (id == R.id.setLayout) {//1.点击更换图标
                initPic(1);
            }
            /*
            switch (view.getId()) {
                case R.id.mucoLayout:
                    //1.点击更换图标
                    initPic(0);
                    break;

                case R.id.setLayout:
                    //1.点击更换图标
                    initPic(1);
                    break;
            }*/

            //2.实现页面切换
            //触发回传事件
            callbackLister.click(view.getId());
        }

    }


}
