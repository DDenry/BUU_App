package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
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

public class Activity_Da_Occident extends Activity {

    private TextView textView_guide;
    private TextView textView_guide1;
    private TextView textView_guide2;
    private TextView textView_guide3;

    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;

    private ImageView imageView_search;

    private ListView listView_blow_occident;
    private SimpleAdapter simpleAdapter_occident;
    private ArrayList<HashMap<String, Object>> listItem_occident;


    private int[] pic = new int[]{R.drawable.cha, R.drawable.shachui, R.drawable.gray, R.drawable.gray, R.drawable.jiazigu, R.drawable.gangpianqin, R.drawable.sanjiaotie};
    private String[] name = new String[]{"镲", "沙槌", "木琴", "定音鼓", "架子鼓", "钢片琴", "三角铁"};
    private String[] brief = new String[]{"\t\t\t\t镲是一种汉族打击乐器，即小钹。或称镲子、铰子等。汉族民间常用类型一般为黄铜镲和铁镲两种。", "\t\t\t\t沙槌，亦称沙球，摇奏体鸣乐器，一般归于打击类。砂槌为典型的拉丁美洲节奏乐器，常用于拉丁美洲舞曲音乐之中。", "\t\t\t\t木琴", "\t\t\t\t定音鼓：膜鸣乐器。定音鼓是由一个铜制或黄铜制的共鸣胴，通常以两个以上为一组，演奏时使用两支前头包着毛毡的木制鼓棒。", "\t\t\t\t架子鼓：一套以鼓为主的组合性打击乐器。", "\t\t\t\t钢琴片，击奏体鸣乐器。用于管弦乐队和管乐队的打击乐器。形如小型钢琴的键盘乐器。", "\t\t\t\t三角铁    民族打击乐器。"};

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
        textView_guide3.setText(">敲");

        //
        init();
        textView_guide.setOnClickListener(new onClickListener());
        textView_guide1.setOnClickListener(new onClickListener());
        textView_guide2.setOnClickListener(new onClickListener());

        listView_blow_occident = (ListView) findViewById(R.id.listView_blow_nation);
        listItem_occident = new ArrayList<>();
        simpleAdapter_occident = new SimpleAdapter(this, listItem_occident, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
        new LoadListView().execute();
        listView_blow_occident.setOnItemClickListener(new onItemClickListener());
    }

    //
    //
    private void init() {
        //
        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new Activity_Da_Occident.onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new Activity_Da_Occident.onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new Activity_Da_Occident.onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new Activity_Da_Occident.onClickListener());
    }

    private class LoadListView extends AsyncTask<Void, Void, SimpleAdapter> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_Da_Occident.this).setTitle("系统消息").setMessage("正在加载……").create();
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
            listView_blow_occident.setAdapter(simpleAdapter_occident);
            alertDialog.dismiss();
        }
    }

    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_Da_Occident.this, Activity_Instrument_1.class);
            intent.putExtra("position_item", "" + position);
            //西洋乐器-拉
            intent.putExtra("signal_type", "" + 3);
            startActivity(intent);
        }
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.imageView_yueqizhishi:
                    intent = new Intent(Activity_Da_Occident.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_ziwopingjia:
                    intent = new Intent(Activity_Da_Occident.this, Activity_Test_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_moniyanzou:
                    intent = new Intent(Activity_Da_Occident.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_guanyuwomen:
                    intent = new Intent(Activity_Da_Occident.this, Activity_About_Us.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_search:
                    intent = new Intent(Activity_Da_Occident.this, Activity_Search.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide:
                    intent = new Intent(Activity_Da_Occident.this, Activity_First_Page.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide1:
                    intent = new Intent(Activity_Da_Occident.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide2:
                    Activity_Da_Occident.this.finish();
                    break;
            }
            //
            System.gc();
        }
    }
}
