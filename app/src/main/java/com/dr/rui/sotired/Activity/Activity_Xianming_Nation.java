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

public class Activity_Xianming_Nation extends ActionBarActivity {

    private TextView textView_guide;
    private TextView textView_guide1;
    private TextView textView_guide2;
    private TextView textView_guide3;

    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;

    private ImageView imageView_search;

    private ListView listView_xianming_nation;
    private SimpleAdapter simpleAdapter_nation;
    private ArrayList<HashMap<String, Object>> listItem_nation;

    private int[] pic = new int[]{R.drawable.ruan, R.drawable.erhu, R.drawable.gaohu, R.drawable.banhu, R.drawable.sanxian, R.drawable.yangqin, R.drawable.pipa, R.drawable.yueqin, R.drawable.liuqin, R.drawable.guqin, R.drawable.guzheng, R.drawable.matouqin};
    private String[] name = new String[]{"阮", "二胡", "高胡", "板胡", "三弦", "扬琴", "琵琶", "月琴", "柳琴", "古琴", "古筝", "马头琴"};
    private String[] brief = new String[]{"\t\t\t\t阮是一种汉族传统乐器，阮咸的简称。可用于独奏、重奏和歌舞伴奏或参加民族乐队演奏。", "\t\t\t\t二胡，又名“胡琴”，是我国独具魅力的拉弦乐器。", "\t\t\t\t高胡，民族拉弦乐器。高胡是“高音二胡”的简称，常用两腿夹着琴筒的一部分演奏。", "\t\t\t\t板胡，民族拉弦乐器。音色高昂、坚实，具有很强的穿透力，是北方戏曲、说唱的主要伴奏乐器。", "\t\t\t\t三弦，民族拨弦乐器，又称“弦子”，侧抱于怀演奏。”。", "\t\t\t\t扬琴，民族击弦乐器，是中国民族乐队中必不可少的乐器，与钢琴同宗。", "\t\t\t\t琵琶，拨弦类弦鸣乐器，是我国历史悠久的重要民族乐器，被称为“弹拨乐器之王”", "\t\t\t\t月琴，民族弹拨弦乐。是从阮演变而来的乐器，月琴是京剧乐队三大伴奏乐器之一。", "\t\t\t\t柳琴，内容待填充。", "\t\t\t\t古琴，民族拨弦乐器，中国最古老的弹拨乐器之一。有3千年以上历史，属于八音中的丝。", "\t\t\t\t古筝，民族弹拨弦乐，是汉族民族传统乐器中的筝乐器，是中国独特的、重要的民族乐器之一。", "\t\t\t\t马头琴是中国少数民族——蒙古族拉弦乐器，是一种两弦的弦乐器，为蒙古族人民喜爱的乐器。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_blow_nation);

        listView_xianming_nation = (ListView) findViewById(R.id.listView_blow_nation);

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
        textView_guide2.setText(">民族乐器");
        textView_guide3.setText(">弦鸣");

        //
        init();

        textView_guide.setOnClickListener(new onClickListener());
        textView_guide1.setOnClickListener(new onClickListener());
        textView_guide2.setOnClickListener(new onClickListener());

        listItem_nation = new ArrayList<>();
        simpleAdapter_nation = new SimpleAdapter(this, listItem_nation, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
        new LoadListView().execute();
        listView_xianming_nation.setOnItemClickListener(new onItemClickListener());
    }

    //
    private void init() {
        //
        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new Activity_Xianming_Nation.onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new Activity_Xianming_Nation.onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new Activity_Xianming_Nation.onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new Activity_Xianming_Nation.onClickListener());
    }

    private class LoadListView extends AsyncTask<Void, Void, SimpleAdapter> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_Xianming_Nation.this).setTitle("系统消息").setMessage("正在加载……").create();
            alertDialog.show();
        }

        @Override
        protected SimpleAdapter doInBackground(Void... params) {
            for (int i = 0; i < name.length; i++) {
                HashMap<String, Object> map_nation = new HashMap<>();
                map_nation.put("Pic", pic[i]);
                map_nation.put("Name", name[i]);
                map_nation.put("Brief", brief[i]);
                //Log.i("INFORMATION:", "" + i);
                listItem_nation.add(map_nation);
            }
            //
            return null;
        }

        @Override
        protected void onPostExecute(SimpleAdapter map_nation) {
            listView_xianming_nation.setAdapter(simpleAdapter_nation);
            alertDialog.dismiss();
        }
    }

    //
    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_Xianming_Nation.this, Activity_Instrument_1.class);
            //
            intent.putExtra("position_item", "" + position);
            //民族乐器-弦鸣
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
                    intent = new Intent(Activity_Xianming_Nation.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_ziwopingjia:
                    intent = new Intent(Activity_Xianming_Nation.this, Activity_Test_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_moniyanzou:
                    intent = new Intent(Activity_Xianming_Nation.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_guanyuwomen:
                    intent = new Intent(Activity_Xianming_Nation.this, Activity_About_Us.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_search:
                    intent = new Intent(Activity_Xianming_Nation.this, Activity_Search.class);
                    startActivity(intent);
                    break;

                case R.id.textView_guide:
                    intent = new Intent(Activity_Xianming_Nation.this, Activity_First_Page.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide1:
                    intent = new Intent(Activity_Xianming_Nation.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide2:
                    Activity_Xianming_Nation.this.finish();
                    break;
            }
            //
            System.gc();
        }
    }
}
