package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;
import com.zain.buu.muco_test.activity.MainActivity;

public class Activity_Test_Choice extends Activity {
    public static int Signal_Choice = 0;
    private ImageView imageView_choice_zhuanxiang;
    private ImageView imageView_choice_zonghe;
    private TextView textView_guide;
    private TextView textView_guide1;

    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_activity__choice);
        LinearLayout linearLayout = (LinearLayout) this.getLayoutInflater().inflate(R.layout.activity_test_choice, null);
        //relativeLayout.setBackground(BackGround.setBackGround(Activity_Choice.this));
        //linearLayout.setBackgroundResource(R.drawable.yinfu);
        setContentView(linearLayout);
        //
        init();
    }

    //
    private void init() {
        //
        textView_guide = (TextView) findViewById(R.id.textView_test_guide);
        textView_guide1 = (TextView) findViewById(R.id.textView_test_guide1);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/msyhbd.ttc");
        textView_guide.setTypeface(typeFace);
        textView_guide1.setTypeface(typeFace);
        textView_guide.setText("\t\t首页");
        textView_guide.setOnClickListener(new onClickListener());
        textView_guide1.setText(">自我评测");

        imageView_choice_zhuanxiang = (ImageView) findViewById(R.id.imageView_choice_zhuanxiang);
        imageView_choice_zhuanxiang.setOnClickListener(new onClickListener());
        imageView_choice_zonghe = (ImageView) findViewById(R.id.imageView_choice_zonghe);
        imageView_choice_zonghe.setOnClickListener(new onClickListener());

        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
//        imageView_ziwopingjia.setOnClickListener(new Activity_Choice.onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new onClickListener());


        imageView_choice_zhuanxiang.setImageBitmap(Image.readBitMap(Activity_Test_Choice.this, R.drawable.zhuanxianglianxi));
        imageView_choice_zonghe.setImageBitmap(Image.readBitMap(Activity_Test_Choice.this, R.drawable.zongheceshi));

    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.imageView_choice_zhuanxiang:
                    //专项练习
                    intent = new Intent(Activity_Test_Choice.this, Activity_Test_Special.class);
                    break;
                case R.id.imageView_choice_zonghe:
                    //综合练习
                    intent = new Intent(Activity_Test_Choice.this, Activity_Test_Special.class);
                    break;
                case R.id.imageView_yueqizhishi:
                    intent = new Intent(Activity_Test_Choice.this, Activity_Choice.class);
                    startActivity(intent);
                    //
                    System.gc();
                    break;
                case R.id.imageView_ziwopingjia:
                    //intent = new Intent(Activity_Test_Choice.this, Activity_Test.class);
                    break;
                case R.id.imageView_moniyanzou:
                    intent = new Intent(Activity_Test_Choice.this, MainActivity.class);
                    break;
                case R.id.imageView_guanyuwomen:
                    intent = new Intent(Activity_Test_Choice.this, Activity_About_Us.class);
                    break;

                case R.id.textView_test_guide:
                    intent = new Intent(Activity_Test_Choice.this, Activity_First_Page.class);
                    break;
            }
            startActivity(intent);
        }
    }

}
