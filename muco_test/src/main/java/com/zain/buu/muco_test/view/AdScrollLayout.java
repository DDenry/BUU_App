package com.zain.buu.muco_test.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zain.buu.muco_test.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Zain on 2016/3/20.
 * <p>
 * 主活动，主界面，
 * 上方广告栏
 */
public class AdScrollLayout extends LinearLayout {

    private ViewPager viewPager_Ad; //广告栏布局
    private ImageView imgOne;   //第一张图片
    private ImageView imgTwo;   //第一张图片
    private ImageView imgThree;   //第一张图片
    private ImageView imgFour;   //第一张图片
    /**
     * 多线程服务函数
     */
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 100:
                    int index = msg.getData().getInt("index");
                    initPic(index);
                    break;
            }
        }

    };
    private Timer timer;   //计时器
    private TimerTask timerTask;   //计时任务
    private int index = 0;    //当前页面的具体的滑动的位置

    /**
     * 构造函数
     *
     * @param context
     * @param attributeSet
     */
    public AdScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    /**
     * 初始化布局页面
     */
    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());    //创建布局构造器
        View view = inflater.inflate(R.layout.ad_scroll, this);  //创建新布局
        findView(view); //获取布局文件
        viewPager_Ad.setOnPageChangeListener(new ViewPagerChangeListener());    //设置页面切换监听
        initPic(0); //图片切换器
    }

    /**
     * 获取布局文件
     *
     * @param view
     */
    private void findView(View view) {
        viewPager_Ad = (ViewPager) view.findViewById(R.id.myViewPage_ad);
        imgOne = (ImageView) view.findViewById(R.id.imgOne);
        imgTwo = (ImageView) view.findViewById(R.id.imgTwo);
        imgThree = (ImageView) view.findViewById(R.id.imgThree);
        imgFour = (ImageView) view.findViewById(R.id.imgFour);
    }


    //需要一个方法：通过时间，来动态的使用ViewPage，实现页面切换功能
    public void setPageFromTime(int delayTime) {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                hand();
                index++;
                if (index == 4) {
                    index = 0;
                }
            }
        };
        timer.schedule(timerTask, delayTime, delayTime);
    }

    /**
     * 发送数据
     */
    protected void hand() {
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        Message msg = new Message();
        msg.setData(bundle);
        msg.what = 100;
        handler.sendMessage(msg);
    }

    /**
     * 定时的更新页面
     *
     * @param index2 当前页面应该更新的一个位置
     */
    protected void initPic(int index2) {
        //1.更新页面
        viewPager_Ad.setCurrentItem(index2);

        switch (index2) {
            case 0: //表示是当前页面的一个位置
                //2.更新下面点的位置
                imgOne.setBackgroundResource(R.mipmap.point_selected);
                imgTwo.setBackgroundResource(R.mipmap.point_normal);
                imgThree.setBackgroundResource(R.mipmap.point_normal);
                imgFour.setBackgroundResource(R.mipmap.point_normal);

                break;

            case 1:
                imgOne.setBackgroundResource(R.mipmap.point_normal);
                imgTwo.setBackgroundResource(R.mipmap.point_selected);
                imgThree.setBackgroundResource(R.mipmap.point_normal);
                imgFour.setBackgroundResource(R.mipmap.point_normal);
                break;

            case 2:
                imgOne.setBackgroundResource(R.mipmap.point_normal);
                imgTwo.setBackgroundResource(R.mipmap.point_normal);
                imgThree.setBackgroundResource(R.mipmap.point_selected);
                imgFour.setBackgroundResource(R.mipmap.point_normal);
                break;

            case 3:
                imgOne.setBackgroundResource(R.mipmap.point_normal);
                imgTwo.setBackgroundResource(R.mipmap.point_normal);
                imgThree.setBackgroundResource(R.mipmap.point_normal);
                imgFour.setBackgroundResource(R.mipmap.point_selected);
                break;
        }
    }

    //返回广告栏自定义界面布局
    public ViewPager getViewPage() {
        return viewPager_Ad;
    }

    /**
     * 页面切换监听函数
     */
    private class ViewPagerChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int id) {
            index = id;
            hand();
        }
    }

}
