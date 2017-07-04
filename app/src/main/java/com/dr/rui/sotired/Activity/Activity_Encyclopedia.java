package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;
import com.zain.buu.muco_test.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class Activity_Encyclopedia extends Activity {

    public static int choice = 0;

    private ViewPager viewPager_encyclopedia;
    private PagerAdapter pagerAdapter;
    private List<View> view = new ArrayList<>();

    private ImageView imageView_search;

    private ImageView imageView_yanzoufangshi;
    private ImageView imageView_fashengyuanli;
    private ImageView imageView_yueduipeizhi;

    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;

//    private CircleMenuLayout circleMenuLayout_yuedui;
//    private CircleMenuLayout circleMenuLayout_fasheng;

//    private ImageButton imageButton_blow;
//    private ImageButton imageButton_la;
//    private ImageButton imageButton_tan;
//    private ImageButton imageButton_qiao;

    private ImageView imageButton_blow;
    private ImageView imageButton_la;
    private ImageView imageButton_tan;
    private ImageView imageButton_qiao;

    //
    private ImageView imageView_daji;
    private ImageView imageView_muguan;
    private ImageView imageView_xianyue;
    private ImageView imageView_tongguan;
    private ImageView imageView_jianpan;

    private ImageView imageView_qiming;
    private ImageView imageView_xuanming;
    private ImageView imageView_timing;
    private ImageView imageView_moming;
    private ImageView imageView_dianming;


    //
    private ImageView imageView_qiming1;
    private ImageView imageView_xuanming1;
    private ImageView imageView_timing1;
    private ImageView imageView_moming1;
    private ImageView imageView_dianming1;

    private TextView textView_guide;
    private TextView textView_guide1;
    private TextView textView_guide2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia_1);
        //
        System.gc();
        //
        init();

    }

    private void init() {
        imageView_search = (ImageView) findViewById(R.id.imageView_search);
        imageView_search.setOnClickListener(new onClickListener());
        //
        textView_guide = (TextView) findViewById(R.id.textView_guide);
        textView_guide1 = (TextView) findViewById(R.id.textView_guide1);
        textView_guide2 = (TextView) findViewById(R.id.textView_guide2);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/msyhbd.ttc");
        textView_guide.setTypeface(typeFace);
        textView_guide1.setTypeface(typeFace);
        textView_guide2.setTypeface(typeFace);
        textView_guide.setOnClickListener(new onClickListener());
        textView_guide1.setOnClickListener(new onClickListener());

        //
        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new onClickListener());

//        imageView_back = (ImageView) findViewById(R.id.imageView_back);
//        imageView_back.setOnClickListener(new onClickListener());
        //
        imageView_yanzoufangshi = (ImageView) findViewById(R.id.imageView_yanzoufangshi);
        imageView_yueduipeizhi = (ImageView) findViewById(R.id.imageView_yueduipeizhi);
        imageView_fashengyuanli = (ImageView) findViewById(R.id.imageView_fashengyuanli);

        imageView_yanzoufangshi.setOnClickListener(new onClickListener());
        imageView_yueduipeizhi.setOnClickListener(new onClickListener());
        imageView_fashengyuanli.setOnClickListener(new onClickListener());
        //
        viewPager_encyclopedia = (ViewPager) findViewById(R.id.viewPager_encyclopedia);
        viewPager_encyclopedia.setCurrentItem(0);
        imageView_yanzoufangshi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yanzoufangshi_1));
        imageView_yueduipeizhi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yueduipeizhi_0));
        imageView_fashengyuanli.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.fashengyuanli_0));
        viewPager_encyclopedia.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //position=viewPager_encyclopedia.getCurrentItem();
                if (Activity_Choice.Signal_Choice == 0) {
                    //民族乐器分类
                    switch (position) {
                        case 0:
                            imageView_yanzoufangshi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yanzoufangshi_1));
                            imageView_fashengyuanli.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yueduipeizhi_0));
                            break;
                        case 1:
                            imageView_yanzoufangshi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yanzoufangshi_0));
                            imageView_fashengyuanli.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.fashengyuanli_1));
                            break;
                    }
                } else {
                    //西洋乐器分类
                    switch (position) {
                        case 0:
                            imageView_yanzoufangshi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yanzoufangshi_1));
                            imageView_fashengyuanli.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.fashengyuanli_0));
                            imageView_yueduipeizhi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yueduipeizhi_0));
                            break;
                        case 1:
                            imageView_yanzoufangshi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yanzoufangshi_0));
                            imageView_yueduipeizhi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yueduipeizhi_1));
                            imageView_fashengyuanli.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.fashengyuanli_0));
                            break;
                        case 2:
                            imageView_yanzoufangshi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yanzoufangshi_0));
                            imageView_yueduipeizhi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yueduipeizhi_0));
                            imageView_fashengyuanli.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.fashengyuanli_1));
                            break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        LayoutInflater inflater = LayoutInflater.from(this);
        //
        View yanzoufangshi = inflater.inflate(R.layout.playways_1, null);
        View yueduipeizhi = inflater.inflate(R.layout.band_maches_1, null);
//        View fashengyuanli = inflater.inflate(R.layout.sound_principle_1, null);
        View fashengyuanli2 = inflater.inflate(R.layout.sound_principle_2, null);

        //将布局添加到ViewPager
        view.add(yanzoufangshi);
        view.add(yueduipeizhi);
//        view.add(fashengyuanli);
        view.add(fashengyuanli2);

        pagerAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view1 = view.get(position);
                container.addView(view1);
                return view1;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(view.get(position));
            }

            @Override
            public int getCount() {
                return view.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
        viewPager_encyclopedia.setAdapter(pagerAdapter);

        //演奏方式

        imageButton_blow = (ImageView) yanzoufangshi.findViewById(R.id.imageButton_blow);
        //imageButton_blow.setOnTouchListener(new onTouchListener());
        imageButton_blow.setOnClickListener(new onClickListener());
        imageButton_la = (ImageView) yanzoufangshi.findViewById(R.id.imageButton_la);

        imageButton_la.setOnTouchListener(new onTouchListener());
        imageButton_la.setOnClickListener(new onClickListener());
        imageButton_tan = (ImageView) yanzoufangshi.findViewById(R.id.imageButton_tan);

        imageButton_tan.setOnTouchListener(new onTouchListener());
        imageButton_tan.setOnClickListener(new onClickListener());
        imageButton_qiao = (ImageView) yanzoufangshi.findViewById(R.id.imageButton_qiao);

        imageButton_qiao.setOnTouchListener(new onTouchListener());
        imageButton_qiao.setOnClickListener(new onClickListener());


        //
        //乐队配置
        imageView_daji = (ImageView) yueduipeizhi.findViewById(R.id.imageView_daji);
        imageView_daji.setOnTouchListener(new onTouchListener());
        imageView_daji.setOnClickListener(new onClickListener());
        imageView_muguan = (ImageView) yueduipeizhi.findViewById(R.id.imageView_muguan);
        imageView_muguan.setOnTouchListener(new onTouchListener());
        imageView_muguan.setOnClickListener(new onClickListener());
        imageView_xianyue = (ImageView) yueduipeizhi.findViewById(R.id.imageView_xianyue);
        imageView_xianyue.setOnTouchListener(new onTouchListener());
        imageView_xianyue.setOnClickListener(new onClickListener());
        imageView_tongguan = (ImageView) yueduipeizhi.findViewById(R.id.imageView_tongguan);
        imageView_tongguan.setOnTouchListener(new onTouchListener());
        imageView_tongguan.setOnClickListener(new onClickListener());
        imageView_jianpan = (ImageView) yueduipeizhi.findViewById(R.id.imageView_jianpan);
        //imageView_jianpan.setOnTouchListener(new onTouchListener());
        //imageView_jianpan.setOnClickListener(new onClickListener());

        //发声原理
        //
        imageView_moming1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_moming1);
        imageView_moming1.setOnTouchListener(new onTouchListener());
        imageView_moming1.setOnClickListener(new onClickListener());
        imageView_qiming1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_qiming1);
        imageView_qiming1.setOnTouchListener(new onTouchListener());
        imageView_qiming1.setOnClickListener(new onClickListener());
        imageView_xuanming1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_xuanming1);
        imageView_xuanming1.setOnTouchListener(new onTouchListener());
        imageView_xuanming1.setOnClickListener(new onClickListener());
        imageView_timing1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_timing1);
        imageView_timing1.setOnTouchListener(new onTouchListener());
        imageView_timing1.setOnClickListener(new onClickListener());
        imageView_dianming1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_dianming1);
        imageView_dianming1.setOnTouchListener(new onTouchListener());
        imageView_dianming1.setOnClickListener(new onClickListener());

        //
        /*imageView_qiming = (ImageView) fashengyuanli.findViewById(R.id.imageView_qiming);
        imageView_qiming.setOnTouchListener(new onTouchListener());
        imageView_qiming.setOnClickListener(new onClickListener());
        imageView_xuanming = (ImageView) fashengyuanli.findViewById(R.id.imageView_xuanming);
        imageView_xuanming.setOnTouchListener(new onTouchListener());
        imageView_xuanming.setOnClickListener(new onClickListener());
        imageView_timing = (ImageView) fashengyuanli.findViewById(R.id.imageView_timing);
        imageView_timing.setOnTouchListener(new onTouchListener());
        imageView_timing.setOnClickListener(new onClickListener());
        imageView_moming = (ImageView) fashengyuanli.findViewById(R.id.imageView_moming);
        imageView_moming.setOnTouchListener(new onTouchListener());
        imageView_moming.setOnClickListener(new onClickListener());
        imageView_dianming = (ImageView) fashengyuanli.findViewById(R.id.imageView_dianming);
        imageView_dianming.setOnTouchListener(new onTouchListener());
        imageView_dianming.setOnClickListener(new onClickListener());*/
        //
        //
        if (Activity_Choice.Signal_Choice == 0) {
            textView_guide.setText("\t\t首页");
            textView_guide1.setText(">乐器知识");
            textView_guide2.setText(">民族乐器");
            //
            imageView_dianming1.setVisibility(View.GONE);
            view.remove(yueduipeizhi);
            pagerAdapter.notifyDataSetChanged();
            imageView_yueduipeizhi.setVisibility(View.INVISIBLE);

            //民族 演奏方式
            imageButton_blow.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.blow_nation));
            imageButton_la.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.la_nation));
            imageButton_tan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.tan_nation));
            imageButton_qiao.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.qiao_nation));

            //民族 发声原理
            imageView_moming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.moming_nation));
            imageView_qiming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.qiming_nation));
            imageView_xuanming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xianming_nation));
            imageView_timing1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.timing_nation));
            // imageView_dianming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.minzufashengyuanlixianming));
        } else {
            textView_guide.setText("\t\t首页");
            textView_guide1.setText(">乐器知识");
            textView_guide2.setText(">西洋乐器");

            imageView_jianpan.setVisibility(View.GONE);

            //西洋 演奏方式
            imageButton_blow.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.blow_occidant));
            imageButton_la.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.la_occidant));
            imageButton_tan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.tan_occidant));
            imageButton_qiao.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.qiao_occidant));
            //西洋 乐队配置
            imageView_daji.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.daji_occidant));
            imageView_muguan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.muguan_occidant));
            imageView_xianyue.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xianyue_occidant));
            imageView_tongguan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.tongguan_occidant));
            //imageView_jianpan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.jianpan));
            //西洋 发声原理
            imageView_moming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.guming_occidant));
            imageView_qiming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.qiming_occidant));
            imageView_xuanming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xianming_occidant));
            imageView_timing1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.timing_occidant));
            imageView_dianming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.dianming_occidant));
        }

        /*final String[] itemTexts = new String[]{"弦乐", "木管", "铜管", "打击", "键盘"};
        int[] itemImages = new int[]{R.drawable.xianyue, R.drawable.muguan, R.drawable.tongguan, R.drawable.daji, R.drawable.jianpan};
        circleMenuLayout_yuedui = (CircleMenuLayout) yueduipeizhi.findViewById(R.id.circle_Menu_Layout_yuedui);
        circleMenuLayout_yuedui.setMenuItemIconsAndTexts(itemImages, itemTexts);
        circleMenuLayout_yuedui.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                Toast.makeText(Activity_Encyclopedia.this, "" + itemTexts[pos], Toast.LENGTH_SHORT).show();
                switch (pos) {
                    //键盘
                    case 0:

                        break;
                    //打击
                    case 1:
                        break;
                    //弦乐
                    case 2:
                        break;
                    //木管
                    case 3:
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_WoodenPipe.class);
                        startActivity(intent);
                        break;
                    //铜管
                    case 4:
                        break;
                }
            }

            @Override
            public void itemCenterClick(View view) {

            }
        });


        //发声原理
        final String[] itemText = new String[]{"弦鸣", "体鸣", "电鸣", "膜鸣", "气鸣"};
        int[] itemImage = new int[]{R.drawable.xianming, R.drawable.timing, R.drawable.dianming, R.drawable.moming, R.drawable.qiming};
        circleMenuLayout_fasheng = (CircleMenuLayout) fashengyuanli.findViewById(R.id.circle_Menu_Layout_fasheng);
        circleMenuLayout_fasheng.setMenuItemIconsAndTexts(itemImage, itemText);
        circleMenuLayout_fasheng.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                Toast.makeText(Activity_Encyclopedia.this, "" + itemTexts[pos], Toast.LENGTH_SHORT).show();
                switch (pos) {
                    //弦鸣
                    case 0:
                        break;
                    //体鸣
                    case 1:
                        break;
                    //电鸣
                    case 2:
                        break;
                    //膜鸣
                    case 3:
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_WoodenPipe.class);
                        startActivity(intent);
                        break;
                    //气鸣
                    case 4:
                        break;
                }
            }

            @Override
            public void itemCenterClick(View view) {

            }
        });*/
        //
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.gc();
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return super.onKeyDown(keyCode, event);
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.imageView_yueqizhishi:
                    intent = new Intent(Activity_Encyclopedia.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_ziwopingjia:
                    intent = new Intent(Activity_Encyclopedia.this, Activity_Test_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_moniyanzou:
                    intent = new Intent(Activity_Encyclopedia.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_guanyuwomen:
                    intent = new Intent(Activity_Encyclopedia.this, Activity_About_Us.class);
                    startActivity(intent);
                    break;
                //搜索
                case R.id.imageView_search:
                    intent = new Intent(Activity_Encyclopedia.this, Activity_Search.class);
                    startActivity(intent);
                    break;

                case R.id.imageView_yanzoufangshi:
                    viewPager_encyclopedia.setCurrentItem(0);
                    break;
                case R.id.imageView_yueduipeizhi:
                    viewPager_encyclopedia.setCurrentItem(1);
                    break;
                case R.id.imageView_fashengyuanli:
                    viewPager_encyclopedia.setCurrentItem(2);
                    break;
                //
                case R.id.textView_guide:
                    Intent intent1 = new Intent(Activity_Encyclopedia.this, Activity_First_Page.class);
                    startActivity(intent1);
                    break;
                //
                case R.id.textView_guide1:
                    Activity_Encyclopedia.this.finish();
                    break;

                //吹
                case R.id.imageButton_blow:
                    //民族乐器-吹
                    if (Activity_Choice.Signal_Choice == 0) {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Blow_Nation.class);
                        //startActivity(intent);
                    }
                    //西洋乐器-吹
                    else {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Blow_Occident.class);
                        //startActivity(intent);
                    }
                    System.gc();
                    startActivity(intent);
                    break;
                //拉
                case R.id.imageButton_la:
                    //民族乐器-拉
                    if (Activity_Choice.Signal_Choice == 0) {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_La_Nation.class);
                        //startActivity(intent);
                    }
                    //西洋乐器-拉
                    else {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_La_Occident.class);
                        //startActivity(intent);
                    }
                    System.gc();
                    startActivity(intent);
                    break;
                //弹
                case R.id.imageButton_tan:
                    //民族乐器-弹
                    if (Activity_Choice.Signal_Choice == 0) {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Tan_Nation.class);
                        //startActivity(intent);
                    }
                    //西洋乐器-弹
                    else {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Tan_Occident.class);
                        //startActivity(intent);
                    }
                    System.gc();
                    startActivity(intent);
                    break;
                //打
                case R.id.imageButton_qiao:
                    //民族乐器-打
                    if (Activity_Choice.Signal_Choice == 0) {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Da_Nation.class);
                        //startActivity(intent);
                    }
                    //西洋乐器-打
                    else {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Da_Occident.class);
                        //startActivity(intent);
                    }
                    System.gc();
                    startActivity(intent);
                    break;
                //弦鸣
                case R.id.imageView_xuanming1:
                    //民族乐器-弦鸣
                    if (Activity_Choice.Signal_Choice == 0) {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Xianming_Nation.class);
                        //startActivity(intent);
                    }
                    //西洋乐器-弦鸣
                    else {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Xianming_Occident.class);
                        //startActivity(intent);
                    }
                    //
                    System.gc();
                    startActivity(intent);
                    break;
                //气鸣
                case R.id.imageView_qiming1:
                    //民族乐器-气鸣
                    if (Activity_Choice.Signal_Choice == 0) {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Qiming_Nation.class);
                    }
                    //西洋乐器-气鸣
                    else {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Qiming_Occident.class);
                    }
                    System.gc();
                    startActivity(intent);
                    break;
                //体鸣
                case R.id.imageView_timing1:
                    //民族乐器-体鸣
                    if (Activity_Choice.Signal_Choice == 0) {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Timing_Nation.class);
                    }
                    //西洋乐器-体鸣
                    else {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Timing_Occident.class);
                    }
                    System.gc();
                    startActivity(intent);
                    break;
                //膜鸣
                case R.id.imageView_moming1:
                    //民族乐器-膜鸣
                    if (Activity_Choice.Signal_Choice == 0) {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Moming_Nation.class);
                    }
                    //西洋乐器-膜鸣
                    else {
                        intent = new Intent(Activity_Encyclopedia.this, Activity_Moming_Occident.class);
                    }
                    System.gc();
                    startActivity(intent);
                    break;
                //电鸣
                case R.id.imageView_dianming1:
                    //西洋乐器-电鸣
                    intent = new Intent(Activity_Encyclopedia.this, Activity_Dianming_Occident.class);
                    System.gc();
                    startActivity(intent);
                    break;
                //西洋乐器-弦乐
                case R.id.imageView_xianyue:
                    intent = new Intent(Activity_Encyclopedia.this, Activity_Xianming_Occident.class);
                    System.gc();
                    startActivity(intent);
                    break;
                //西洋乐器-木管
                case R.id.imageView_muguan:
                    intent = new Intent(Activity_Encyclopedia.this, Activity_Muguan_Occident.class);
                    System.gc();
                    startActivity(intent);
                    break;
                //西洋乐器-打击
                case R.id.imageView_daji:

                    break;
                //西洋乐器-铜管
                case R.id.imageView_tongguan:

                    break;
            }
        }
    }

    //
    public class onTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                //
                case R.id.imageButton_blow:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageButton_blow.getDrawable().setAlpha(100);
                        v.invalidate();
                    } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                        imageButton_blow.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
                //
                case R.id.imageButton_la:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageButton_la.getDrawable().setAlpha(100);
                        v.invalidate();
                    } else {
                        imageButton_la.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
                //
                case R.id.imageButton_tan:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageButton_tan.getDrawable().setAlpha(100);
                        v.invalidate();
                    } else {
                        imageButton_tan.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
                //
                case R.id.imageButton_qiao:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageButton_qiao.getDrawable().setAlpha(100);
                        v.invalidate();
                    } else {
                        imageButton_qiao.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
            }
            return false;
        }
    }

}
