package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.telephony.SignalStrength;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;
import com.zhy.view.CircleMenuLayout;

import java.util.ArrayList;
import java.util.List;

public class Activity_Encyclopedia extends Activity {

    public static int choice = 0;

    private ViewPager viewPager_encyclopedia;
    private PagerAdapter pagerAdapter;
    private List<View> view = new ArrayList<>();

    private ImageView imageView_back;

    private ImageView imageView_yanzoufangshi;
    private ImageView imageView_fashengyuanli;
    private ImageView imageView_yueduipeizhi;


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


    //
    private ImageView imageView_qiming1;
    private ImageView imageView_xuanming1;
    private ImageView imageView_timing1;
    private ImageView imageView_moming1;
    private ImageView imageView_dianming1;

    private TextView textView_guide;

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
        //
        textView_guide = (TextView) findViewById(R.id.textView_guide);
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
                    switch (position) {
                        case 0:
                            imageView_yanzoufangshi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yanzoufangshi_1));
                            imageView_yueduipeizhi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yueduipeizhi_0));
                            break;
                        case 1:
                            imageView_yanzoufangshi.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.yanzoufangshi_0));
                            imageView_fashengyuanli.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.fashengyuanli_1));
                            break;
                    }
                } else {
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
        imageButton_blow.setOnTouchListener(new onTouchListener());
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
        imageView_jianpan.setOnTouchListener(new onTouchListener());
        imageView_jianpan.setOnClickListener(new onClickListener());

        //发声原理
        //
        imageView_qiming1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_qiming1);
        imageView_qiming1.setOnTouchListener(new onTouchListener());
        imageView_qiming1.setOnClickListener(new onClickListener());
        imageView_xuanming1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_xuanming1);
        imageView_xuanming1.setOnTouchListener(new onTouchListener());
        imageView_xuanming1.setOnClickListener(new onClickListener());
        imageView_timing1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_timing1);
        imageView_timing1.setOnTouchListener(new onTouchListener());
        imageView_timing1.setOnClickListener(new onClickListener());
        imageView_moming1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_moming1);
        imageView_moming1.setOnTouchListener(new onTouchListener());
        imageView_moming1.setOnClickListener(new onClickListener());
        imageView_dianming1 = (ImageView) fashengyuanli2.findViewById(R.id.imageView_dianming1);
        imageView_dianming1.setOnTouchListener(new onTouchListener());
        imageView_dianming1.setOnClickListener(new onClickListener());

        //
        /*imageView_qiming = (ImageView) yueduipeizhi.findViewById(R.id.imageView_qiming);
        imageView_qiming.setOnTouchListener(new onTouchListener());
        imageView_qiming.setOnClickListener(new onClickListener());
        imageView_xuanming = (ImageView) yueduipeizhi.findViewById(R.id.imageView_xuanming);
        imageView_xuanming.setOnTouchListener(new onTouchListener());
        imageView_xuanming.setOnClickListener(new onClickListener());
        imageView_timing = (ImageView) yueduipeizhi.findViewById(R.id.imageView_timing);
        imageView_timing.setOnTouchListener(new onTouchListener());
        imageView_timing.setOnClickListener(new onClickListener());
        imageView_moming = (ImageView) yueduipeizhi.findViewById(R.id.imageView_moming);
        imageView_moming.setOnTouchListener(new onTouchListener());
        imageView_moming.setOnClickListener(new onClickListener());
        imageView_dianming = (ImageView) yueduipeizhi.findViewById(R.id.imageView_dianming);
        imageView_dianming.setOnTouchListener(new onTouchListener());
        imageView_dianming.setOnClickListener(new onClickListener());*/
        //
        //
        if (Activity_Choice.Signal_Choice == 0) {
            //
            view.remove(yueduipeizhi);
            pagerAdapter.notifyDataSetChanged();

            imageView_yueduipeizhi.setVisibility(View.INVISIBLE);

            textView_guide.setText("\t首页 > 选择 > 民族乐器 ");
            //民族 演奏方式
            imageButton_blow.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.nationalchui));
            imageButton_la.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.nationalla));
            imageButton_tan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.nationaltan));
            imageButton_qiao.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.nationalqiao));

            //民族 发声原理
            imageView_qiming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.minzufashengyuanliguming));
            imageView_xuanming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.minzufashengyuanlitiming));
            imageView_timing1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.minzufashengyuanliqiming));
            imageView_moming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.minzufashengyuanlixianming));
            imageView_dianming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.minzufashengyuanlixianming));
        } else {

            textView_guide.setText("\t首页 > 选择 > 西洋乐器 ");
            //西洋 演奏方式
            imageButton_blow.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xiyangchui));
            imageButton_la.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xiyangla));
            imageButton_tan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xiyangtan));
            imageButton_qiao.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xiyangqiao));
            //西洋 乐队配置
            imageView_daji.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.daji));
            imageView_muguan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.daji));
            imageView_xianyue.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.daji));
            imageView_tongguan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.daji));
            imageView_jianpan.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.daji));
            //西洋 发声原理
            imageView_qiming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xiyangfashengyuanliguming));
            imageView_xuanming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xiyangfashengyuanlitiming));
            imageView_timing1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xiyangfashengyuanliqiming));
            imageView_moming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xiyangfashengyuanlidianming));
            imageView_dianming1.setImageBitmap(Image.readBitMap(Activity_Encyclopedia.this, R.drawable.xiyangfashengyuanlixianming));

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

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //返回
                case R.id.imageView_back:
                    Activity_Encyclopedia.this.finish();
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

                //吹
                case R.id.imageButton_blow:
                    //民族乐器-吹
                    if (Activity_Choice.Signal_Choice == 0) {
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_blow_nation.class);
                        startActivity(intent);
                    }
                    //西洋乐器-吹
                    else {
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_blow_occident.class);
                        startActivity(intent);
                    }
                    System.gc();
                    break;
                //拉
                case R.id.imageButton_la:
                    //民族乐器-拉
                    if (Activity_Choice.Signal_Choice == 0) {
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_la_nation.class);
                        startActivity(intent);
                    }
                    //西洋乐器-拉
                    else {
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_blow_occident.class);
                        startActivity(intent);
                    }
                    System.gc();
                    break;
                //弹
                case R.id.imageButton_tan:
                    //民族乐器-弹
                    if (Activity_Choice.Signal_Choice == 0) {
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_tan_nation.class);
                        startActivity(intent);
                    }
                    //西洋乐器-弹
                    else {
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_blow_occident.class);
                        startActivity(intent);
                    }
                    System.gc();
                    break;
                //打
                case R.id.imageButton_qiao:
                    //民族乐器-打
                    if (Activity_Choice.Signal_Choice == 0) {
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_da_nation.class);
                        startActivity(intent);
                    }
                    //西洋乐器-打
                    else {
                        Intent intent = new Intent(Activity_Encyclopedia.this, Activity_blow_occident.class);
                        startActivity(intent);
                    }
                    System.gc();
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
                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        imageButton_blow.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
                //
                case R.id.imageButton_la:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageButton_la.getDrawable().setAlpha(100);
                        v.invalidate();

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        imageButton_la.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
                //
                case R.id.imageButton_tan:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageButton_tan.getDrawable().setAlpha(100);
                        v.invalidate();

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        imageButton_tan.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
                //
                case R.id.imageButton_qiao:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageButton_qiao.getDrawable().setAlpha(100);
                        v.invalidate();

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        imageButton_qiao.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
            }
            return false;
        }
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

}
