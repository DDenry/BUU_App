package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
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

/**
 * Created by rui on 2015/9/18.
 */
public class Activity_la_nation extends Activity {

    private TextView textView_navigation;
    //
    //private int[] pic = new int[]{R.drawable.erhu, R.drawable.gaohu};
    private int[] pic = new int[]{R.drawable.erhu, R.drawable.gaohu, R.drawable.banhu, R.drawable.sanxian, R.drawable.matouqin};
    private String[] name = new String[]{"二胡", "高胡", "板胡", "三弦", "马头琴"};
    private String[] brief = new String[]{"\t\t二胡，又名“胡琴”，是我国独具魅力的拉弦乐器。", "\t\t高胡，民族拉弦乐器。高胡是“高音二胡”的简称，常用两腿夹着琴筒的一部分演奏。", "\t\t板胡，民族拉弦乐器。音色高昂、坚实，具有很强的穿透力，是北方戏曲、说唱的主要伴奏乐器。", "\t\t三弦，民族拨弦乐器，又称“弦子”，侧抱于怀演奏。", "\t\t马头琴是中国少数民族——蒙古族拉弦乐器，是一种两弦的弦乐器，为蒙古族人民喜爱的乐器。"};

    private ListView listView_la_nation;
    private SimpleAdapter simpleAdapter_nation;
    private ArrayList<HashMap<String, Object>> listItem_nation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_blow_nation);

        listView_la_nation = (ListView) findViewById(R.id.listView_blow_nation);

        textView_navigation = (TextView) findViewById(R.id.textView_navigation);
        textView_navigation.setText("民族乐器->拉");



        listItem_nation = new ArrayList<>();
        simpleAdapter_nation = new SimpleAdapter(this, listItem_nation, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
        new LoadListView().execute();

        listView_la_nation.setOnItemClickListener(new onItemClickListener());


    }

    private class LoadListView extends AsyncTask<Void, Void, SimpleAdapter> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_la_nation.this).setTitle("系统消息").setMessage("正在加载……").create();
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
            listView_la_nation.setAdapter(simpleAdapter_nation);
            alertDialog.dismiss();
        }
    }

    //
    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_la_nation.this, Activity_Instrument_1.class);
            intent.putExtra("position_item", "" + position);
            //民族乐器-吹
            intent.putExtra("signal_type", "" + 1);
            startActivity(intent);
        }
    }
}
