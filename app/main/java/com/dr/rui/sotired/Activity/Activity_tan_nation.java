package com.dr.rui.sotired.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.dr.rui.sotired.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity_tan_nation extends Activity {
    private TextView textView_navigation;

    private ListView listView_blow_nation;
    private SimpleAdapter simpleAdapter_nation;
    private ArrayList<HashMap<String, Object>> listItem_nation;

    private int[] pic = new int[]{R.drawable.ruan, R.drawable.pipa, R.drawable.yueqin, R.drawable.guqin, R.drawable.guzheng};
    private String[] name = new String[]{"阮", "琵琶", "月琴", "古琴", "古筝"};
    private String[] brief = new String[]{"\t\t阮是一种汉族传统乐器，阮咸的简称。可用于独奏、重奏和歌舞伴奏或参加民族乐队演奏。", "\t\t琵琶，拨弦类弦鸣乐器，是我国历史悠久的重要民族乐器，被称为“弹拨乐器之王”", "\t\t月琴，民族弹拨弦乐。是从阮演变而来的乐器，月琴是京剧乐队三大伴奏乐器之一。", "\t\t古琴，民族拨弦乐器，中国最古老的弹拨乐器之一。有3千年以上历史，属于八音中的丝。", "\t\t古筝，民族弹拨弦乐，是汉族民族传统乐器中的筝乐器，是中国独特的、重要的民族乐器之一。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_blow_nation);

        textView_navigation = (TextView) findViewById(R.id.textView_navigation);
        textView_navigation.setText("民族乐器->弹");

        listView_blow_nation = (ListView) findViewById(R.id.listView_blow_nation);
        listItem_nation = new ArrayList<>();
        simpleAdapter_nation = new SimpleAdapter(this, listItem_nation, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
        new LoadListView().execute();
        listView_blow_nation.setOnItemClickListener(new onItemClickListener());
    }

    private class LoadListView extends AsyncTask<Void, Void, SimpleAdapter> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_tan_nation.this).setTitle("系统消息").setMessage("正在加载……").create();
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
                listItem_nation.add(map_nation);
            }
            //
            return null;
        }

        @Override
        protected void onPostExecute(SimpleAdapter map_nation) {
            listView_blow_nation.setAdapter(simpleAdapter_nation);
            alertDialog.dismiss();
        }
    }

    //
    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_tan_nation.this, Activity_Instrument_1.class);
            intent.putExtra("position_item", "" + position);
            //民族乐器-弹
            intent.putExtra("signal_type", "" + 2);
            startActivity(intent);
        }
    }

}
