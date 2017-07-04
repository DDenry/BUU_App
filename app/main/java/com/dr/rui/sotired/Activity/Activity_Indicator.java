package com.dr.rui.sotired.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.TabContent.TabAdapter;
import com.viewpagerindicator.TabPageIndicator;


public class Activity_Indicator extends FragmentActivity {

    private TabPageIndicator tabPageIndicator;
    private ViewPager viewPager;
    private TabAdapter tabAdapter;
    private ImageButton imageButton_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_encyclopedia);

        //
        init();
    }

    private void init() {
        imageButton_search = (ImageButton) findViewById(R.id.imageButton_search);
        imageButton_search.setOnTouchListener(new onTouchListener());

        tabPageIndicator = (TabPageIndicator) findViewById(R.id.tabPageIndicator);
        tabPageIndicator.setVisibility(View.VISIBLE);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        tabAdapter = new TabAdapter(getSupportFragmentManager());
//       viewPager.setAdapter(tabAdapter);
//        tabPageIndicator.setViewPager(viewPager);
        new tabAdapterAsynctask().execute();
    }

    class tabAdapterAsynctask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            tabAdapter = new TabAdapter(getSupportFragmentManager());
            viewPager.setAdapter(tabAdapter);
            tabPageIndicator.setViewPager(viewPager);
            return null;
        }
    }

    public class onTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.imageButton_search:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageButton_search.getDrawable().setAlpha(50);
                        v.invalidate();
                        Intent intent = new Intent(Activity_Indicator.this, activity_blow_1.class);
                        startActivity(intent);
                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        imageButton_search.getDrawable().setAlpha(255);
                        v.invalidate();
                    }
                    break;
            }
            return false;
        }
    }
}
