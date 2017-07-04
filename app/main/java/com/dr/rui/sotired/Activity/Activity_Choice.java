package com.dr.rui.sotired.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

public class Activity_Choice extends Activity {
    public static int Signal_Choice = 0;
    private ImageView imageView_choice_nation;
    private ImageView imageView_choice_occident;
    private TextView textView_guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_activity__choice);
        LinearLayout linearLayout = (LinearLayout) this.getLayoutInflater().inflate(R.layout.activity_activity__choice, null);
        //relativeLayout.setBackground(BackGround.setBackGround(Activity_Choice.this));
        //linearLayout.setBackgroundResource(R.drawable.yinfu);
        setContentView(linearLayout);

        textView_guide = (TextView) findViewById(R.id.textView_guide);
        textView_guide.setText("\t首页 >" + " 选择");

        imageView_choice_nation = (ImageView) findViewById(R.id.imageView_choice_nation);
        imageView_choice_nation.setOnClickListener(new onClickListener());
        imageView_choice_occident = (ImageView) findViewById(R.id.imageView_choice_occident);
        imageView_choice_occident.setOnClickListener(new onClickListener());

        imageView_choice_nation.setImageBitmap(Image.readBitMap(Activity_Choice.this, R.drawable.pic_choice_nation));
        imageView_choice_occident.setImageBitmap(Image.readBitMap(Activity_Choice.this, R.drawable.pic_choice_occident));
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Activity_Choice.this, Activity_Encyclopedia.class);
            switch (v.getId()) {
                case R.id.imageView_choice_nation:
                    //民族
                    //intent.putExtra("Code", "" + 0);
                    Signal_Choice = 0;
                    break;
                case R.id.imageView_choice_occident:
                    //西洋
                    //intent.putExtra("Code", "" + 1);
                    Signal_Choice = 1;
                    break;
            }
            startActivity(intent);
        }
    }

}
