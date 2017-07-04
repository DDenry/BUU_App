package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util.BackGround;
import com.dr.rui.sotired.Util_Image.Image;

public class Activity_MainPage extends Activity {

    private ImageButton imageButton_encyclopeadia;
    private ImageButton imageButton_test;
    private ImageButton imageButton_perform;
    private ImageButton imageButton_about;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_activity__main_page);
        RelativeLayout relativeLayout = (RelativeLayout) this.getLayoutInflater().inflate(R.layout.activity_activity__main_page, null);
        relativeLayout.setBackgroundDrawable(BackGround.setBackGround(Activity_MainPage.this));
        setContentView(relativeLayout);
        //
        init();

        //
        imageButton_encyclopeadia.setOnTouchListener(new onTouchListener());
        imageButton_encyclopeadia.setOnClickListener(new buttonOnClickListener());
    }

    private void init() {
        imageButton_encyclopeadia = (ImageButton) findViewById(R.id.imageButton_encyclopeadia);
        imageButton_encyclopeadia.setImageBitmap(Image.readBitMap(Activity_MainPage.this,R.drawable.encyclopaedia));
        imageButton_test= (ImageButton) findViewById(R.id.imageButton_test);
        imageButton_test.setImageBitmap(Image.readBitMap(Activity_MainPage.this,R.drawable.test));
        imageButton_perform= (ImageButton) findViewById(R.id.imageButton_perform);
        imageButton_perform.setImageBitmap(Image.readBitMap(Activity_MainPage.this,R.drawable.perform));
        imageButton_about= (ImageButton) findViewById(R.id.imageButton_about);
        imageButton_about.setImageBitmap(Image.readBitMap(Activity_MainPage.this,R.drawable.about));
    }


    //
    // 按两次返回键退出
    // @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class buttonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButton_encyclopeadia:
                    Intent intent = new Intent(Activity_MainPage.this, Activity_Indicator.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    //
    public class onTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.imageButton_encyclopeadia:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageButton_encyclopeadia.getDrawable().setAlpha(100);
                        v.invalidate();

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        imageButton_encyclopeadia.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
            }
            return false;
        }
    }
}
