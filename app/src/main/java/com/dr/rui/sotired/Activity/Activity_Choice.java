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

public class Activity_Choice extends Activity {
    public static int Signal_Choice = 0;
    private ImageView imageView_choice_nation;
    private ImageView imageView_choice_occident;
    private TextView textView_guide;
    private TextView textView_guide1;

    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;

    private ImageView imageView_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_activity__choice);
        LinearLayout linearLayout = (LinearLayout) this.getLayoutInflater().inflate(R.layout.activity_activity__choice, null);
        //relativeLayout.setBackground(BackGround.setBackGround(Activity_Choice.this));
        //linearLayout.setBackgroundResource(R.drawable.yinfu);
        setContentView(linearLayout);


        //
        imageView_search = (ImageView) findViewById(R.id.imageView_search);
        imageView_search.setOnClickListener(new onClickListener());

        textView_guide = (TextView) findViewById(R.id.textView_guide);
        textView_guide1 = (TextView) findViewById(R.id.textView_guide1);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/msyhbd.ttc");
        textView_guide.setTypeface(typeFace);
        textView_guide1.setTypeface(typeFace);
        textView_guide.setText("\t\t首页");
        textView_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity_Choice.this.finish();
            }
        });
        textView_guide1.setText(">乐器知识");
        imageView_choice_nation = (ImageView) findViewById(R.id.imageView_choice_nation);
        imageView_choice_nation.setOnClickListener(new onClickListener());
        imageView_choice_occident = (ImageView) findViewById(R.id.imageView_choice_occident);
        imageView_choice_occident.setOnClickListener(new onClickListener());

        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
//        imageView_yueqizhishi.setOnClickListener(new onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new onClickListener());

        imageView_choice_nation.setImageBitmap(Image.readBitMap(Activity_Choice.this, R.drawable.choice_nation));
        imageView_choice_occident.setImageBitmap(Image.readBitMap(Activity_Choice.this, R.drawable.choice_occident));
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.imageView_choice_nation:
                    //民族
                    //intent.putExtra("Code", "" + 0);
                    intent = new Intent(Activity_Choice.this, Activity_Encyclopedia.class);
                    Signal_Choice = 0;
                    break;
                case R.id.imageView_choice_occident:
                    //西洋
                    //intent.putExtra("Code", "" + 1);
                    intent = new Intent(Activity_Choice.this, Activity_Encyclopedia.class);
                    Signal_Choice = 1;
                    break;
                case R.id.imageView_yueqizhishi:
                    //intent = new Intent(Activity_Choice.this, Activity_Choice.class);
                    //startActivity(intent);
                    //
                    System.gc();
                    break;
                case R.id.imageView_ziwopingjia:
                    intent = new Intent(Activity_Choice.this, Activity_Test_Choice.class);
                    //startActivity(intent);
                    break;
                case R.id.imageView_moniyanzou:
                    System.gc();
                    intent = new Intent(Activity_Choice.this, MainActivity.class);
                    break;
                case R.id.imageView_guanyuwomen:
                    intent = new Intent(Activity_Choice.this, Activity_About_Us.class);
                    break;

                case R.id.imageView_search:
                    intent = new Intent(Activity_Choice.this, Activity_Search.class);
                    break;
            }
            startActivity(intent);
        }
    }

}
