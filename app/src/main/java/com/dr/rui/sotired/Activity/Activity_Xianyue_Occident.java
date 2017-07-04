package com.dr.rui.sotired.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.dr.rui.sotired.R;
import com.zain.buu.muco_test.activity.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity_Xianyue_Occident extends ActionBarActivity {
    private TextView textView_guide;
    private TextView textView_guide1;
    private TextView textView_guide2;
    private TextView textView_guide3;

    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;

    private ImageView imageView_search;

    private ListView listView_xianyue_occident;
    private SimpleAdapter simpleAdapter_occident;
    private ArrayList<HashMap<String, Object>> listItem_occident;


    private int[] pic = new int[]{R.drawable.shuqin, R.drawable.xiaotiqin, R.drawable.zhongtiqin, R.drawable.datiqin, R.drawable.diyintiqin, R.drawable.mujita, R.drawable.dianjita, R.drawable.dianbeisi};
    private String[] name = new String[]{"竖琴", "小提琴", "中提琴", "大提琴", "低音提琴", "木吉他", "电吉他", "电贝司"};
    private String[] brief = new String[]{"\t\t\t\t竖琴，世界上最古老的拨弦乐器之一，交响乐队以及歌舞剧中特殊的色彩性乐器。", "\t\t\t\t小提琴，一种四弦擦奏弦鸣乐器，“乐器皇后”的美誉，是现代弦乐组中最主要的乐器。", "\t\t\t\t中提琴，擦奏弦鸣乐器，提琴族中的中音乐器，外形及结构与小提琴基本相同，形体略大。", "\t\t\t\t大提琴，大提琴是西洋三大独奏乐器之一，是指大型的提琴之意。", "\t\t\t\t低音提琴又称倍大提琴。提琴家族中体积最大、发音最低的弓弦乐器。它是乐队中音响的支柱。", "\t\t\t\t木吉他", "\t\t\t\t电吉他是一种拨弦乐器，琴体使用新硬木制成。配有音量、音调调音器以及颤音结构等装置。", "\t\t\t\t电贝司，又称为贝斯吉他、低音吉他，简称贝斯，现代摇滚乐团组合的主要乐器。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_blow_nation);
        imageView_search = (ImageView) findViewById(R.id.imageView_search);
        imageView_search.setOnClickListener(new onClickListener());

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/msyhbd.ttc");
        textView_guide = (TextView) findViewById(R.id.textView_guide);
        textView_guide1 = (TextView) findViewById(R.id.textView_guide1);
        textView_guide2 = (TextView) findViewById(R.id.textView_guide2);
        textView_guide3 = (TextView) findViewById(R.id.textView_guide3);
        textView_guide.setTypeface(typeFace);
        textView_guide1.setTypeface(typeFace);
        textView_guide2.setTypeface(typeFace);
        textView_guide3.setTypeface(typeFace);

        textView_guide.setText("\t\t首页");
        textView_guide1.setText(">乐器知识");
        textView_guide2.setText(">西洋乐器");
        textView_guide3.setText(">弦乐");

        //
        init();

        textView_guide.setOnClickListener(new onClickListener());
        textView_guide1.setOnClickListener(new onClickListener());
        textView_guide2.setOnClickListener(new onClickListener());

        listView_xianyue_occident = (ListView) findViewById(R.id.listView_blow_nation);
        listItem_occident = new ArrayList<>();
        simpleAdapter_occident = new SimpleAdapter(this, listItem_occident, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
        new LoadListView().execute();
        listView_xianyue_occident.setOnItemClickListener(new onItemClickListener());
    }

    //
    private void init() {
        //
        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new Activity_Xianyue_Occident.onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new Activity_Xianyue_Occident.onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new Activity_Xianyue_Occident.onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new Activity_Xianyue_Occident.onClickListener());
    }

    private class LoadListView extends AsyncTask<Void, Void, SimpleAdapter> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_Xianyue_Occident.this).setTitle("系统消息").setMessage("正在加载……").create();
            alertDialog.show();
        }

        @Override
        protected SimpleAdapter doInBackground(Void... params) {
            for (int i = 0; i < name.length; i++) {
                HashMap<String, Object> map_nation = new HashMap<>();
                //
                map_nation.put("Pic", pic[i]);
                map_nation.put("Name", name[i]);
                map_nation.put("Brief", brief[i]);
                //Log.i("INFORMATION:", "" + i);
                listItem_occident.add(map_nation);
            }
            //
            return null;
        }

        @Override
        protected void onPostExecute(SimpleAdapter map_nation) {
            listView_xianyue_occident.setAdapter(simpleAdapter_occident);
            alertDialog.dismiss();
        }
    }

    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_Xianyue_Occident.this, Activity_Instrument_1.class);
            intent.putExtra("position_item", "" + position);
            //西洋乐器-弦乐
            intent.putExtra("signal_type", "" + 4);
            startActivity(intent);
        }
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.imageView_yueqizhishi:
                    intent = new Intent(Activity_Xianyue_Occident.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_ziwopingjia:
                    intent = new Intent(Activity_Xianyue_Occident.this, Activity_Test_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_moniyanzou:
                    intent = new Intent(Activity_Xianyue_Occident.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_guanyuwomen:
                    intent = new Intent(Activity_Xianyue_Occident.this, Activity_About_Us.class);
                    startActivity(intent);
                    break;

                case R.id.imageView_search:
                    intent = new Intent(Activity_Xianyue_Occident.this, Activity_Search.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide:
                    intent = new Intent(Activity_Xianyue_Occident.this, Activity_First_Page.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide1:
                    intent = new Intent(Activity_Xianyue_Occident.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide2:
                    Activity_Xianyue_Occident.this.finish();
                    break;
            }
            //
            System.gc();
        }
    }
}
