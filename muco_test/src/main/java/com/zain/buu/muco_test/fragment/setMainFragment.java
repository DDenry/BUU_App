package com.zain.buu.muco_test.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zain.buu.muco_test.R;
import com.zain.buu.muco_test.view.SettingItemView;

/**
 * Created by Zain on 2016/3/20.
 * <p>
 * Fragment
 * 设置界面碎片
 */
public class setMainFragment extends Fragment {

    ICallbackLister2 callbackLister = null;
    private SettingItemView xiyangPage; //西洋乐器布局
    private SettingItemView minzuPage; //民族乐器布局
    private SettingItemView happyPage; //快乐学习布局
    private SettingItemView luyinPage; //录音布局
    private SettingItemView pianoPage; //钢琴布局
    private LinearLayout pianoOutLine; //钢琴下划线布局
    private SettingItemView guqinPage; //钢琴布局
    private LinearLayout guqinOutLine; //钢琴下划线布局

    /**
     * 创建View函数
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.set_main_fragment, container, false);   //获取新布局
        findView(view); //获取布局文件
        return view;    //返回View
    }

    /**
     * 获取布局文件
     *
     * @param view
     */
    private void findView(View view) {
        xiyangPage = (SettingItemView) view.findViewById(R.id.xiyangPage);
        minzuPage = (SettingItemView) view.findViewById(R.id.minzuPage);
        happyPage = (SettingItemView) view.findViewById(R.id.happyPage);
        luyinPage = (SettingItemView) view.findViewById(R.id.luyinPage);
        pianoPage = (SettingItemView) view.findViewById(R.id.pianoPage);
        pianoOutLine = (LinearLayout) view.findViewById(R.id.pianoPage_outline);
        guqinPage = (SettingItemView) view.findViewById(R.id.guqinPage);
        guqinOutLine = (LinearLayout) view.findViewById(R.id.guqinPage_outline);
    }

    public void setOnCallbackLister(ICallbackLister2 callbackLister) {
        this.callbackLister = callbackLister;
    }

    /**
     * 接口实现强转函数
     *
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof ICallbackLister2)) {
            throw new IllegalStateException("必须实现接口");
        }

        callbackLister = (ICallbackLister2) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbackLister = null;
    }

    /**
     * 活动创建时
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData(); //初始化数据
        setOnclick();   //设置点击监听
        setOnTouch();   //设置触摸监听

    }

    /**
     * 触摸监听事件
     */
    private void setOnTouch() {
        //民族乐器触摸事件
        minzuPage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        v.setBackgroundColor(Color.BLUE);   //按下颜色变化
                        break;

                    case MotionEvent.ACTION_UP:
                        v.setBackground(null);  //抬起颜色变化
                        if (guqinPage.getVisibility() == View.GONE) {   //古琴不显示时
                            guqinPage.setVisibility(View.VISIBLE); //设置古琴显示
                            guqinOutLine.setVisibility(View.VISIBLE);
                            minzuPage.setImageView_Right(R.mipmap.log_right_open); //切换民族乐器右边图片
                        } else {
                            guqinPage.setVisibility(View.GONE);    //设置古琴不显示
                            guqinOutLine.setVisibility(View.GONE);
                            minzuPage.setImageView_Right(R.mipmap.log_right_close); //切换民族乐器右边图片
                        }
                        break;
                }

                return true;
            }
        });

        //西洋乐器触摸事件
        xiyangPage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        v.setBackgroundColor(Color.BLUE);   //按下颜色变化
                        break;

                    case MotionEvent.ACTION_UP:
                        v.setBackground(null);  //抬起颜色变化
                        if (pianoPage.getVisibility() == View.GONE) {   //钢琴不显示时
                            pianoPage.setVisibility(View.VISIBLE); //设置钢琴显示
                            pianoOutLine.setVisibility(View.VISIBLE);
                            xiyangPage.setImageView_Right(R.mipmap.log_right_open); //切换西洋乐器右边图片
                        } else {
                            pianoPage.setVisibility(View.GONE);    //设置钢琴不显示
                            pianoOutLine.setVisibility(View.GONE);
                            xiyangPage.setImageView_Right(R.mipmap.log_right_close); //切换西洋乐器右边图片
                        }
                        break;
                }

                return true;
            }
        });
    }

    /**
     * 点击事件设置
     */
    private void setOnclick() {

        //古琴点击
        guqinPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackLister.click2("guqin");
            }
        });

        //钢琴点击
        pianoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackLister.click2("piano");
            }
        });

        //快乐学习点击
        happyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackLister.click2("happy");
            }
        });

        //录音点击
        luyinPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackLister.click2("luyin");
            }
        });


    }

    /**
     * 初始化数据
     */
    private void initData() {
        xiyangPage.setTextView("西洋乐器");
        xiyangPage.setImageView_Left(R.mipmap.xiyang_set);
        xiyangPage.setImageView_Right(R.mipmap.log_right_close);

        pianoPage.setTextView("钢琴");
        pianoPage.setImageView_Left(R.mipmap.piano_page);
        //pianoPage.setImageView_Right(R.mipmap.log_right_close);
        pianoPage.setVisibility(View.GONE);

        minzuPage.setTextView("民族乐器");
        minzuPage.setImageView_Left(R.mipmap.minzu_set);
        minzuPage.setImageView_Right(R.mipmap.log_right_close);

        guqinPage.setTextView("古琴");
        guqinPage.setImageView_Left(R.mipmap.guqin_set);
        //guqinPage.setImageView_Right(R.mipmap.log_right_close);
        guqinPage.setVisibility(View.GONE);

        happyPage.setTextView("快乐学习");
        happyPage.setImageView_Left(R.mipmap.happy_page);
        //happyPage.setImageView_Right(R.mipmap.log_right_close);

        luyinPage.setTextView("录音管理");
        luyinPage.setImageView_Left(R.mipmap.luyin_page);
        //luyinPage.setImageView_Right(R.mipmap.log_right_close);

    }

    //回传监听事件
    public interface ICallbackLister2 {
        void click2(String name);
    }

}
