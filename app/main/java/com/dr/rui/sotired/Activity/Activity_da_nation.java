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

public class Activity_da_nation extends Activity {

    private TextView textView_navigation;




    private int[] pic = new int[]{R.drawable.bo, R.drawable.luo, R.drawable.paigu, R.drawable.dagu, R.drawable.muyu, R.drawable.yangqin};
    private String[] name = new String[]{"钹", "锣", "排鼓", "大鼓", "木鱼", "扬琴"};
    private String[] brief = new String[]{"\t\t钹，互击体鸣乐器，根据钹的大小及重量等不同，钹分为双光钹、水钹、京钹、小钹等几种。", "\t\t锣，民族打击乐器。锣在中国的民族乐队中占有非常重要的地位，而且应用范围很广泛。", "\t\t排鼓，鼓类乐器的新品种，属于打击乐器。", "\t\t大鼓是民族打击乐器，属于双面膜鸣乐器，古往今来，大鼓一直成为各族人民喜爱的民间乐器。", "\t\t木鱼，打击乐器,原为佛教“龚吹”（宗教歌曲）的民族乐器。", "\t\t扬琴，民族击弦乐器，是中国民族乐队中必不可少的乐器，与钢琴同宗。"};

    private ListView listView_da_nation;
    private SimpleAdapter simpleAdapter_nation;
    private ArrayList<HashMap<String, Object>> listItem_nation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_blow_nation);
        listView_da_nation = (ListView) findViewById(R.id.listView_blow_nation);

        textView_navigation = (TextView) findViewById(R.id.textView_navigation);
        textView_navigation.setText("民族乐器->打");



        listItem_nation = new ArrayList<>();
        simpleAdapter_nation = new SimpleAdapter(this, listItem_nation, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
        new LoadListView().execute();

        listView_da_nation.setOnItemClickListener(new onItemClickListener());
    }

    private class LoadListView extends AsyncTask<Void, Void, SimpleAdapter> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_da_nation.this).setTitle("系统消息").setMessage("正在加载……").create();
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
            listView_da_nation.setAdapter(simpleAdapter_nation);
            alertDialog.dismiss();
        }
    }

    //
    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_da_nation.this, Activity_Instrument_1.class);
            intent.putExtra("position_item", "" + position);
            //民族乐器-吹
            intent.putExtra("signal_type", "" + 3);
            startActivity(intent);
        }
    }
}
