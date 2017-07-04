package com.zain.buu.muco_test.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.zain.buu.muco_test.R;
import com.zain.buu.muco_test.fragment.mucoMainFragment;
import com.zain.buu.muco_test.fragment.mucoMainFragment.ICallbackLister1;
import com.zain.buu.muco_test.fragment.setMainFragment;
import com.zain.buu.muco_test.view.BottomLayout;
import com.zain.buu.muco_test.view.BottomLayout.ICallbackLister;


/**
 * Created by Zain on 2016/3/19.
 * <p/>
 * 首页
 */
public class MainActivity extends FragmentActivity implements ICallbackLister1, setMainFragment.ICallbackLister2 {

    BottomLayout bottomLayout;
    Intent intent;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setContentView(R.layout.main_layout);
        //初始化
        init();
    }

    /**
     * 页面的初始化
     */
    private void init() {
        viewPager = (ViewPager) findViewById(R.id.myViewPage); //碎片空间的布局
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        findView(); //获取控件
        setOnclick();   //设置监听
        viewPager.setOnPageChangeListener(new PageChangeListener());
    }

    //设置回调函数
    private void setOnclick() {
        bottomLayout.setOnCallbackLister(new MyCallBackLister());   //设置回调监听
    }

    /**
     * mucoMainFragment 回调函数 主碎片页面的
     *
     * @param id
     */
    @Override
    public void click(int id) {
        if (id == R.mipmap.muco_piano1) { //钢琴图片被点击，跳转到钢琴页面
            intent = new Intent(MainActivity.this, PianoActivity.class);
            intent.putExtra("zain", "no");
            startActivity(intent);
        } else if (id == R.mipmap.muco_guqin1) { //古琴图片被点击，跳转到古琴页面
            intent = new Intent(MainActivity.this, GuqinActivity.class);
            intent.putExtra("zain", "no");
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "尽请期待！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * setMainFragment 回调函数 设置碎片页面的
     *
     * @param name
     */
    @Override
    public void click2(String name) {
        switch (name) {

            case "piano":
                //跳转至钢琴页面
                intent = new Intent(MainActivity.this, PianoActivity.class);
                intent.putExtra("zain", "no");
                startActivity(intent);
                break;

            case "guqin":
                //跳转至钢琴页面
                intent = new Intent(MainActivity.this, GuqinActivity.class);
                intent.putExtra("zain", "no");
                startActivity(intent);
                break;

            case "happy":
                intent = new Intent(MainActivity.this, PianoActivity.class);
                intent.putExtra("zain", "study");
                startActivity(intent);
                break;

            case "luyin":
                //跳转至录音页面
                intent = new Intent(MainActivity.this, RecorderManagerActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    //获取组件
    private void findView() {
        bottomLayout = (BottomLayout) findViewById(R.id.BottomLayout_main);
    }

    /**
     * 页面切换监听
     */
    private class PageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int id) {    //页面选中监听
            bottomLayout.initPic(id);   //切换底部按钮图片
        }

    }

    /**
     * 拿到回调数据 底部按钮的
     */
    private class MyCallBackLister implements ICallbackLister {
        @Override
        //根据回调id判断加载那个碎片
        public void click(int id) {
            if (id == R.id.mucoLayout) {//1.点击更换图标
                viewPager.setCurrentItem(0);
            } else if (id == R.id.setLayout) {//1.点击更换图标
                viewPager.setCurrentItem(1);
            }
            /*
            switch (id) {
                case R.id.mucoLayout:
                    viewPager.setCurrentItem(0);
                    break;

                case R.id.setLayout:
                    viewPager.setCurrentItem(1);
                    break;
            }*/
        }
    }

    /**
     * 编写适配器 Fragment碎片适配器
     */
    private class MyFragmentAdapter extends FragmentPagerAdapter {

        public MyFragmentAdapter(android.support.v4.app.FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        //根据id返回碎片实体页
        public android.support.v4.app.Fragment getItem(int id) {
            switch (id) {
                case 0:
                    return new mucoMainFragment();

                case 1:
                    return new setMainFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        } //获取碎片数量
    }

}
