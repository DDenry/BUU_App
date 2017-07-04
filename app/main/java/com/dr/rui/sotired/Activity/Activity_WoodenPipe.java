package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dr.rui.sotired.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity_WoodenPipe extends Activity {

    private ListView listView_nation;
    private ListView listView_occident;
    private ArrayList<HashMap<String, Object>> listItem;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__wooden_pipe);

        init();
        //
        HashMap<String, Object> map = new HashMap<>();
        map.put("图片", R.drawable.xiao);
        for (int i = 0; i < 6; i++) {
            listItem.add(map);
        }
        listView_nation.setAdapter(simpleAdapter);
        listView_occident.setAdapter(simpleAdapter);

        listView_nation.setOnItemClickListener(new onItemClickListener());
    }

    private void init() {
        listView_nation = (ListView) findViewById(R.id.listView_wooden_nation);
        listView_occident = (ListView) findViewById(R.id.listView_wooden_occident);
        listItem = new ArrayList<>();
        simpleAdapter = new SimpleAdapter(this, listItem, R.layout.list_instrument, new String[]{"图片"}, new int[]{R.id.imageView_instrument});
    }

    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //
            Intent intent = new Intent(Activity_WoodenPipe.this, Activity_Instrument.class);
            intent.putExtra("position_wooden", "" + position);
            //设置标识为4
            Activity_Instrument.Signal = 4;
            startActivity(intent);
        }
    }
}
