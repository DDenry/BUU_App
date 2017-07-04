package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Activity_Tan extends Activity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private List<View> view = new ArrayList<>();

    private ImageView imageView_title;
    private ImageView imageView_back;

    private TextView textView_nation;
    private TextView textView_occident;

    private ImageView imageView_nation;
    private ImageView imageView_occident;

    private ListView listView_nation;
    private ListView listView_occident;
    private SimpleAdapter simpleAdapter_nation;
    private SimpleAdapter simpleAdapter_occident;
    private ArrayList<HashMap<String, Object>> listItem_nation;
    private ArrayList<HashMap<String, Object>> listItem_occident;

    //
    //private int[] pic = new int[]{R.drawable.erhu, R.drawable.gaohu};
    private int[] pic = new int[]{R.drawable.erhu, R.drawable.gaohu,R.drawable.banhu, R.drawable.sanxian, R.drawable.matouqin};
    private String[] name = new String[]{"二胡", "高胡", "板胡", "三弦", "马头琴"};
    private String[] brief = new String[]{"\t\t是民族拉弦乐器，乐队配置中属于弦乐器，其发声原理为弦鸣。", "\t\t是民族拉弦乐器，乐队配置中属于弦乐器，其发声原理为弦鸣。"};

    private int[] pic_occident = new int[]{R.drawable.xiaotiqin, R.drawable.zhongtiqin};
    private String[] name_occident = new String[]{"小提琴", "中提琴", "大提琴", "低音提琴"};
    private String[] brief_occident = new String[]{"\t\t是西洋拉弦乐器，乐队配置中属于弦乐器，其发声原理为弦鸣。", "\t\t是西洋拉弦乐器，乐队配置中属于弦乐器，其发声原理为弦鸣。"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__tan);
        //
        init();
        //
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
        viewPager.setAdapter(pagerAdapter);
    }

    //
    private void init() {
//        textView_nation = (TextView) findViewById(R.id.textView_nation);
//        textView_occident = (TextView) findViewById(R.id.textView_occident);
//        //
//        textView_nation.setOnClickListener(new onClickListener());
//        textView_occident.setOnClickListener(new onClickListener());
//        //
//        textView_nation.setOnTouchListener(new onTouchListener());
//        textView_occident.setOnTouchListener(new onTouchListener());

        imageView_nation = (ImageView) findViewById(R.id.imageView_nation);
        imageView_occident = (ImageView) findViewById(R.id.imageView_occident);
        //
        imageView_title = (ImageView) findViewById(R.id.imageView_title);
        imageView_title.setImageBitmap(Image.readBitMap(Activity_Tan.this, R.drawable.title_blow));

        imageView_back = (ImageView) findViewById(R.id.imageView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity_Tan.this.finish();
            }
        });

        //
        imageView_back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    imageView_back.getDrawable().setAlpha(150);
                else imageView_back.getDrawable().setAlpha(255);

                return false;
            }
        });

        LayoutInflater inflater = LayoutInflater.from(this);
        View list_nation = inflater.inflate(R.layout.view_pager_listview_nation, null);
        View list_occident = inflater.inflate(R.layout.view_pager_listview_occident, null);

        view.add(list_nation);
        view.add(list_occident);

        //
        listView_nation = (ListView) list_nation.findViewById(R.id.listView_nation);
        listView_nation.setCacheColorHint(0);
        listView_occident = (ListView) list_occident.findViewById(R.id.listView_occident);

        listItem_nation = new ArrayList<>();
        listItem_occident = new ArrayList<>();
        //
        simpleAdapter_nation = new SimpleAdapter(this, listItem_nation, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
        //simpleAdapter_nation = new SimpleAdapter(this, listItem_nation, R.layout.instrument_table_style, new String[]{"Pic_Left", "Name_Left", "Pic_Right", "Name_Right"}, new int[]{R.id.imageView_instrument_left, R.id.textView_instrument_left, R.id.imageView_instrument_right, R.id.textView_instrument_right});
        simpleAdapter_occident = new SimpleAdapter(this, listItem_occident, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});

        // 民族乐器
        for (int i = 0; i < name.length; i++) {
            HashMap<String, Object> map_nation = new HashMap<>();
            map_nation.put("Pic", R.drawable.gray);
            map_nation.put("Name", name[i]);
            map_nation.put("Brief", brief[0]);
            listItem_nation.add(map_nation);
        }
        //

        listView_nation.setAdapter(simpleAdapter_nation);

        //西洋乐器
        for (int i = 0; i < name_occident.length; i++) {
            HashMap<String, Object> map_occident = new HashMap<>();
            map_occident.put("Pic", R.drawable.gray);
            map_occident.put("Name", name_occident[i]);
            map_occident.put("Brief", brief_occident[0]);
            listItem_occident.add(map_occident);
        }

        listView_occident.setAdapter(simpleAdapter_occident);

        listView_nation.setOnItemClickListener(new onItemClickListener());
        listView_occident.setOnItemClickListener(new onItemClickListener());

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setCurrentItem(0);
        imageView_nation.setImageBitmap(Image.readBitMap(Activity_Tan.this, R.drawable.nation_inst1));

        //
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                position = viewPager.getCurrentItem();
                switch (position) {
                    //
                    case 0:
                        imageView_nation.setImageBitmap(Image.readBitMap(Activity_Tan.this, R.drawable.nation_inst1));
                        imageView_occident.setImageBitmap(Image.readBitMap(Activity_Tan.this, R.drawable.occident_inst));
                        break;
                    case 1:
                        imageView_nation.setImageBitmap(Image.readBitMap(Activity_Tan.this, R.drawable.nation_inst));
                        imageView_occident.setImageBitmap(Image.readBitMap(Activity_Tan.this, R.drawable.occident_inst1));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class onTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            return false;
        }
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //
            textView_nation.setTextColor(Color.WHITE);
            textView_occident.setTextColor(Color.WHITE);
            switch (v.getId()) {
                case R.id.imageView_nation:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.imageView_occident:
                    viewPager.setCurrentItem(1);
                    break;
            }
        }
    }

    //
    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_Tan.this, Activity_Instrument.class);
            intent.putExtra("position_blow", "" + position);
            intent.putExtra("position_type", "" + viewPager.getCurrentItem());
            //
            Activity_Instrument.Signal = 2;
            startActivity(intent);
        }
    }
}
