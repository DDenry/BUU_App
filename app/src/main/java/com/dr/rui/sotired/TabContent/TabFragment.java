package com.dr.rui.sotired.TabContent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.dr.rui.sotired.Activity.Activity_La_Nation;
import com.dr.rui.sotired.Activity.Activity_WoodenPipe;
import com.dr.rui.sotired.Activity.activity_blow_1;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;
import com.zhy.view.CircleMenuLayout;

/**
 * Created by rui on 2015/5/15.
 */
@SuppressLint("ValidFragment")
public class TabFragment extends Fragment {
    private ImageButton imageButton_blow;
    private ImageButton imageButton_la;
    private ImageButton imageButton_tan;
    private ImageButton imageButton_qiao;

    private int position;

    private CircleMenuLayout circleMenuLayout;

    public TabFragment() {

    }

    public TabFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        //演奏方式
        if (position == 0) {
            view = inflater.inflate(R.layout.playways, container, false);
            Message message = new Message();
            message.what = position;
            message.obj = view;
            imageButton_blow = (ImageButton) view.findViewById(R.id.imageButton_blow);
            imageButton_blow.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.chui));
            imageButton_blow.setOnTouchListener(new onTouchListener());
            imageButton_blow.setOnClickListener(new buttonOnClickListener());
            imageButton_la = (ImageButton) view.findViewById(R.id.imageButton_la);
            imageButton_la.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.la));
            imageButton_la.setOnTouchListener(new onTouchListener());
            imageButton_la.setOnClickListener(new buttonOnClickListener());
            imageButton_tan = (ImageButton) view.findViewById(R.id.imageButton_tan);
            imageButton_tan.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.tan));
            imageButton_tan.setOnTouchListener(new onTouchListener());
            imageButton_tan.setOnClickListener(new buttonOnClickListener());
            imageButton_qiao = (ImageButton) view.findViewById(R.id.imageButton_qiao);
            imageButton_qiao.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.qiao));
            imageButton_qiao.setOnTouchListener(new onTouchListener());
            imageButton_qiao.setOnClickListener(new buttonOnClickListener());
        }
        //乐队配置
        if (position == 1) {
            view = inflater.inflate(R.layout.band_maches, container, false);
            final String[] itemTexts = new String[]{"弦乐", "木管", "铜管", "打击", "键盘"};
            int[] itemImages = new int[]{R.drawable.xianyue, R.drawable.muguan, R.drawable.tongguan, R.drawable.daji, R.drawable.jianpan};
            circleMenuLayout = (CircleMenuLayout) view.findViewById(R.id.circle_Menu_Layout_yuedui);
            circleMenuLayout.setMenuItemIconsAndTexts(itemImages, itemTexts);
            circleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
                @Override
                public void itemClick(View view, int pos) {
                    Toast.makeText(getActivity(), "" + itemTexts[pos], Toast.LENGTH_SHORT).show();
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
                            Intent intent = new Intent(getActivity(), Activity_WoodenPipe.class);
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
        }
        //发声原理
        if (position == 2) {
            view = inflater.inflate(R.layout.sound_principle, container, false);
            final String[] itemTexts = new String[]{"弦鸣", "体鸣", "电鸣", "膜鸣", "气鸣"};
            int[] itemImages = new int[]{R.drawable.xianming, R.drawable.timing, R.drawable.dianming, R.drawable.moming, R.drawable.qiming};
            circleMenuLayout = (CircleMenuLayout) view.findViewById(R.id.circle_Menu_Layout_fasheng);
            circleMenuLayout.setMenuItemIconsAndTexts(itemImages, itemTexts);
            circleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
                @Override
                public void itemClick(View view, int pos) {
                    Toast.makeText(getActivity(), "" + itemTexts[pos], Toast.LENGTH_SHORT).show();
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
                            Intent intent = new Intent(getActivity(), Activity_WoodenPipe.class);
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
            });
        }
        return view;
    }

    //
    public class buttonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //吹
                case R.id.imageButton_blow:
                    //
                    Intent intent = new Intent(getActivity(), activity_blow_1.class);
                    startActivity(intent);
                    break;
                //拉
                case R.id.imageButton_la:
                    Intent intent_la = new Intent(getActivity(), Activity_La_Nation.class);
                    startActivity(intent_la);
                    break;
                //弹
                case R.id.imageButton_tan:
                    break;
                //敲
                case R.id.imageButton_qiao:
                    break;
            }
        }
    }

    //
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
}
