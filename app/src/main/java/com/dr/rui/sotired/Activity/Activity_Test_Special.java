package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dr.rui.sotired.Fragment.Fragment_Test_Special_Instrument_Type;
import com.dr.rui.sotired.Fragment.Fragment_Test_Special_Question_Type;
import com.dr.rui.sotired.R;

public class Activity_Test_Special extends Activity {

    private TextView textView_guide;
    private TextView textView_guide1;
    private TextView textView_guide2;

    private LinearLayout linearLayout_test;
    private TextView textView_test_music;
    private TextView textView_test_question;

    private Fragment_Test_Special_Instrument_Type fragment_test_special_instrument;
    private Fragment_Test_Special_Question_Type fragment_test_special_question;
    private FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        init();
    }

    private void init() {

        textView_guide = (TextView) findViewById(R.id.textView_test_guide);
        textView_guide1 = (TextView) findViewById(R.id.textView_test_guide1);
        textView_guide2 = (TextView) findViewById(R.id.textView_test_guide2);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/msyhbd.ttc");
        textView_guide.setTypeface(typeFace);
        textView_guide1.setTypeface(typeFace);
        textView_guide2.setTypeface(typeFace);

        textView_guide.setText("\t\t首页");
        textView_guide1.setText(">自我评测");
        textView_guide2.setText(">专项选择(乐器分类)");

        textView_guide.setOnClickListener(new onClickListener());
        textView_guide1.setOnClickListener(new onClickListener());
        textView_guide2.setOnClickListener(new onClickListener());

        linearLayout_test = (LinearLayout) findViewById(R.id.linearLayout_test);
        textView_test_music = (TextView) findViewById(R.id.textView_test_music);
        textView_test_question = (TextView) findViewById(R.id.textView_test_question);
        textView_test_music.setOnClickListener(new onClickListener());
        textView_test_question.setOnClickListener(new onClickListener());

        fragment_test_special_instrument = new Fragment_Test_Special_Instrument_Type();
        fragment_test_special_question = new Fragment_Test_Special_Question_Type();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, fragment_test_special_instrument);
        fragmentTransaction.add(R.id.frameLayout, fragment_test_special_question);
        fragmentTransaction.show(fragment_test_special_instrument).hide(fragment_test_special_question).commit();
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (v.getId()) {
                case R.id.textView_test_music:
                    textView_test_music.setTextColor(Color.WHITE);
                    textView_test_question.setTextColor(Color.BLACK);
                    linearLayout_test.setBackgroundResource(R.drawable.select_musical);
                    fragmentTransaction.hide(fragment_test_special_question).show(fragment_test_special_instrument).commit();
                    textView_guide2.setText(">专项选择(乐器分类)");
                    break;
                case R.id.textView_test_question:
                    textView_test_music.setTextColor(Color.BLACK);
                    textView_test_question.setTextColor(Color.WHITE);
                    linearLayout_test.setBackgroundResource(R.drawable.select_questions);
                    fragmentTransaction.hide(fragment_test_special_instrument).show(fragment_test_special_question).commit();
                    textView_guide2.setText(">专项选择(题型分类)");
                    break;
                case R.id.textView_test_guide:
                    Intent intent = new Intent(Activity_Test_Special.this, Activity_First_Page.class);
                    startActivity(intent);
                    break;
                case R.id.textView_test_guide1:
                    Activity_Test_Special.this.finish();
                    break;
            }
        }
    }
}
