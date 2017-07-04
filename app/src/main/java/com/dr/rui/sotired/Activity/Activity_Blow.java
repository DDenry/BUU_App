package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dr.rui.sotired.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity_Blow extends Activity {

    private ListView listView_nation;
    private ImageView imageView_blow;

    private ArrayList<HashMap<String, Object>> listItem_nation;
    private ArrayList<HashMap<String, Object>> listItem_occident;

    private SimpleAdapter simpleAdapter_nation;
    private SimpleAdapter simpleAdapter_occident;

    private int[] pic = new int[]{R.drawable.xiao, R.drawable.music, R.drawable.play};
    private String[] name = new String[]{"箫", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //动态设置布局
        LinearLayout linearLayout = (LinearLayout) this.getLayoutInflater().inflate(R.layout.activity_activity__blow, null);
        setContentView(linearLayout);
        //初始化控件
        init();
        //实例化HashMap，添加ListView的内容
        HashMap<String, Object> map_nation = new HashMap<>();
        map_nation.put("图片", pic[0]);
        //map_nation.put("名称", name[0]);
        //map_nation.put("简介", "   箫，古代用于宫廷雅乐边棱音气鸣乐器。“八音”分类属竹。音阶（音域）：xxxxxxxxxxxxxxxxxx");
        listItem_nation.add(map_nation);
        listItem_nation.add(map_nation);

        //民族乐器列表
        listView_nation.setAdapter(simpleAdapter_nation);

        //
        listView_nation.setOnItemClickListener(new onItemClickListener());
    }

    private void init() {

        //imageView_blow = (ImageView) findViewById(R.id.imageView_blow);
        //imageView_blow.setImageBitmap(Image.readBitMap(Activity_Blow.this, R.drawable.blow_title));
        listView_nation = (ListView) findViewById(R.id.listView_nation);

        listItem_nation = new ArrayList<>();
        listItem_occident = new ArrayList<>();
//        simpleAdapter_nation = new SimpleAdapter(this, listItem_nation, R.layout.list_instrument, new String[]{"图片", "名称", "简介"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
//        simpleAdapter_occident = new SimpleAdapter(this, listItem_occident, R.layout.list_instrument, new String[]{"图片"}, new int[]{R.id.imageView_instrument});
        simpleAdapter_nation = new SimpleAdapter(this, listItem_nation, R.layout.list_item, new String[]{"图片"}, new int[]{R.id.imageView_list_item});

    }

    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_Blow.this, Activity_Instrument.class);
            intent.putExtra("position_blow", "" + position);
            //设置标识为0
            Activity_Instrument.Signal = 0;
            startActivity(intent);
        }
    }
}
