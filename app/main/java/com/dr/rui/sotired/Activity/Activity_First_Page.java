package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dr.rui.sotired.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity_First_Page extends Activity {

    private ListView listView_information;
    private SimpleAdapter adapter;
    private ArrayList<HashMap<String, Object>> list_item;

    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;

    private int[] pic = new int[]{R.drawable.info_1, R.drawable.info_2, R.drawable.info_3, R.drawable.info_4, R.drawable.info_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__first__page);
        //
        System.gc();
        //
        init();
        //
        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("Pic", pic[i]);
            list_item.add(map);
        }
        listView_information.setAdapter(adapter);
    }

    private void init() {
        listView_information = (ListView) findViewById(R.id.listView_information);
        listView_information.setCacheColorHint(0);
        list_item = new ArrayList<>();
        adapter = new SimpleAdapter(this, list_item, R.layout.list_item, new String[]{"Pic"}, new int[]{R.id.imageView_list_item});
        //
        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new onClickListener());
    }

    public class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageView_yueqizhishi:
                    Intent intent = new Intent(Activity_First_Page.this, Activity_Choice.class);
                    startActivity(intent);
                    //
                    System.gc();
                    break;
                case R.id.imageView_ziwopingjia:
                    break;
                case R.id.imageView_moniyanzou:
                    break;
                case R.id.imageView_guanyuwomen:
                    break;
            }
        }
    }
}
