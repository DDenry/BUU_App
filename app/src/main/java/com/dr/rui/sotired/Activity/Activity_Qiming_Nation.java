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

public class Activity_Qiming_Nation extends ActionBarActivity {
    private TextView textView_guide;
    private TextView textView_guide1;
    private TextView textView_guide2;
    private TextView textView_guide3;

    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;

    private ImageView imageView_search;

    private ListView listView_qiming_nation;
    private SimpleAdapter simpleAdapter_nation;
    private ArrayList<HashMap<String, Object>> listItem_nation;

    private int[] pic = new int[]{R.drawable.xiao, R.drawable.sheng, R.drawable.xun, R.drawable.zhudi, R.drawable.suona, R.drawable.bawu, R.drawable.hulusi};
    private String[] name = new String[]{"箫", "笙", "埙", "竹笛", "唢呐", "巴乌", "葫芦丝"};
    private String[] brief = new String[]{"\t\t\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。", "\t\t\t\t笙，吹孔簧鸣乐器，起源于中国，是世界上最早使用自由簧的乐器。", "\t\t\t\t埙，亦称“陶埙”，是汉族特有的闭口吹奏乐器，在世界原始艺术史中占有重要的地位。", "\t\t\t\t竹笛，木管乐器家族中的吹孔膜鸣乐器类。竹笛在独奏和合奏中都很重要，也常出现在中国民族乐队中。", "\t\t\t\t唢呐，双簧片木管乐器。又名喇叭，小唢呐称海笛。在台湾民间称为鼓吹，广东地区亦将之称为“八音”。", "\t\t\t\t巴乌，哈尼、彝、傣、佤、布朗等族单簧气鸣乐器。流行于云南省红河、玉溪、思茅、西双版纳、临沧、德宏等地区。", "\t\t\t\t葫芦丝又称“葫芦箫”是云南少数名族特有的民族管乐器之一，主要流传于云南省滇西傣族地区。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_blow_nation);
        listView_qiming_nation = (ListView) findViewById(R.id.listView_blow_nation);

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
        textView_guide3.setText(">气鸣");

        //
        init();

        textView_guide.setOnClickListener(new onClickListener());
        textView_guide1.setOnClickListener(new onClickListener());
        textView_guide2.setOnClickListener(new onClickListener());

        listItem_nation = new ArrayList<>();
        simpleAdapter_nation = new SimpleAdapter(this, listItem_nation, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
        new Activity_Qiming_Nation.LoadListView().execute();
        listView_qiming_nation.setOnItemClickListener(new onItemClickListener());
    }

    //
    private void init() {
        //
        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new Activity_Qiming_Nation.onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new Activity_Qiming_Nation.onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new Activity_Qiming_Nation.onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new Activity_Qiming_Nation.onClickListener());
    }

    private class LoadListView extends AsyncTask<Void, Void, SimpleAdapter> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_Qiming_Nation.this).setTitle("系统消息").setMessage("正在加载……").create();
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
            listView_qiming_nation.setAdapter(simpleAdapter_nation);
            alertDialog.dismiss();
        }
    }

    //
    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_Qiming_Nation.this, Activity_Instrument_1.class);
            //
            intent.putExtra("position_item", "" + position);
            //民族乐器-气鸣
            intent.putExtra("signal_type", "" + 5);
            startActivity(intent);
        }
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.imageView_yueqizhishi:
                    intent = new Intent(Activity_Qiming_Nation.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_ziwopingjia:
                    intent = new Intent(Activity_Qiming_Nation.this, Activity_Test_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_moniyanzou:
                    intent = new Intent(Activity_Qiming_Nation.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_guanyuwomen:
                    intent = new Intent(Activity_Qiming_Nation.this, Activity_About_Us.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_search:
                    intent = new Intent(Activity_Qiming_Nation.this, Activity_Search.class);
                    startActivity(intent);
                    break;

                case R.id.textView_guide:
                    intent = new Intent(Activity_Qiming_Nation.this, Activity_First_Page.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide1:
                    intent = new Intent(Activity_Qiming_Nation.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide2:
                    Activity_Qiming_Nation.this.finish();
                    break;
            }
            //
            System.gc();
        }
    }
}
