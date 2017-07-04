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

public class Activity_Blow_Occident extends Activity {

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


    private int[] pic = new int[]{R.drawable.xiaohao, R.drawable.duandi, R.drawable.changdi, R.drawable.duanhao, R.drawable.changhao, R.drawable.yuanhao, R.drawable.dahao, R.drawable.daguan, R.drawable.danhuangguan, R.drawable.shuanghuangguan, R.drawable.yingguoguan, R.drawable.sakesi, R.drawable.cizhongyinhao};
    private String[] name = new String[]{"小号", "短笛", "长笛", "短号", "长号", "圆号", "大号", "大管", "单簧管", "双簧管", "英国管", "萨克斯", "次中音号"};
    private String[] brief = new String[]{"\t\t\t\t小号，俗称小喇叭，属铜管乐器，是铜管乐器家族中音域最高的乐器。", "\t\t\t\t短笛，吹奏气鸣木管乐器。是音域最高的木管乐器，也是交响乐队中音域最高的乐器之一。", "\t\t\t\t长笛，气鸣吹奏木管乐器，是现代管弦乐和室乐中主要的高音旋律乐器，也是重要的独奏乐器。", "\t\t\t\t短号，铜管乐器。短号是小号的变形乐器，通常只用于军乐队和舞厅乐队，很少用于管弦乐队。", "\t\t\t\t长号是瑶、壮、苗、彝、哈尼、布依、土家、维吾尔、汉等族唇振气鸣乐器。被称为“爵士乐之王”。", "\t\t\t\t圆号，唇振动气鸣乐器，又称法国号。圆号被称作交响乐中的乐器之王。", "\t\t\t\t大号，是一种管乐、管弦乐队中音域最低的铜管乐器。大号在乐队中主要担任低音部和声或节奏，很少用于独奏。", "\t\t\t\t大管又称巴松管，来自意大利文的原意为“一捆柴”——非常形象。大管为双簧气鸣乐器，是双簧管族中的次中音与低音乐器。", "\t\t\t\t单簧管，又称黑管或克拉管，有管弦乐队中的“演说家”和木管乐器中的“戏剧女高音”之称。", "\t\t\t\t双簧管，管弦乐器。双簧管在乐队中常担任主要旋律的演奏，是出色的独奏乐器，同时也善于合奏和伴奏。", "\t\t\t\t英国管，木管乐器，属于双簧管体系中的一种变种。又称中音双簧族乐器。音色比双簧管浓郁而苍凉比较含蓄内在，听起来如泣如诉。", "\t\t\t\t萨克斯,是萨克斯风的简称，分有上低音萨克斯、中音萨克斯、次中音萨克斯、高音萨克斯。", "\t\t\t\t次中音号，铜管乐器，又名“瓦格纳大号” ，与其名字类似，是一种中音偏高音铜管乐器。"};

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
        textView_guide3.setText(">吹");

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
    private void init() {
        //
        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new Activity_Blow_Occident.onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new Activity_Blow_Occident.onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new Activity_Blow_Occident.onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new Activity_Blow_Occident.onClickListener());
    }

    private class LoadListView extends AsyncTask<Void, Void, SimpleAdapter> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_Blow_Occident.this).setTitle("系统消息").setMessage("正在加载……").create();
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
            Intent intent = new Intent(Activity_Blow_Occident.this, Activity_Instrument_1.class);
            intent.putExtra("position_item", "" + position);
            //西洋乐器-吹
            intent.putExtra("signal_type", "" + 0);
            startActivity(intent);
        }
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.imageView_yueqizhishi:
                    intent = new Intent(Activity_Blow_Occident.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_ziwopingjia:
                    intent = new Intent(Activity_Blow_Occident.this, Activity_Test_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_moniyanzou:
                    intent = new Intent(Activity_Blow_Occident.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_guanyuwomen:
                    intent = new Intent(Activity_Blow_Occident.this, Activity_About_Us.class);
                    startActivity(intent);
                    break;
                case R.id.imageView_search:
                    intent = new Intent(Activity_Blow_Occident.this, Activity_Search.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide:
                    intent = new Intent(Activity_Blow_Occident.this, Activity_First_Page.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide1:
                    intent = new Intent(Activity_Blow_Occident.this, Activity_Choice.class);
                    startActivity(intent);
                    break;
                case R.id.textView_guide2:
                    Activity_Blow_Occident.this.finish();
                    break;
            }
            //
            System.gc();
        }
    }
}
