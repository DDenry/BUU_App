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

public class Activity_blow_occident extends Activity {

    private TextView textView_navigation;
    private ListView listView_blow_nation;
    private SimpleAdapter simpleAdapter_nation;
    private ArrayList<HashMap<String, Object>> listItem_nation;

    private int[] pic = new int[]{R.drawable.changdi, R.drawable.duandi, R.drawable.xun, R.drawable.zhudi, R.drawable.suona, R.drawable.gray};
    private String[] name = new String[]{"短笛", "长笛", "小号", "短号", "长号", "圆号", "大号", "大管", "单簧管", "双簧管", "英国管", "萨克斯", "次中音号"};
    private String[] brief = new String[]{"\t\t短笛，吹奏气鸣木管乐器。是音域最高的木管乐器，也是交响乐队中音域最高的乐器之一。", "\t\t长笛，气鸣吹奏木管乐器，是现代管弦乐和室乐中主要的高音旋律乐器，也是重要的独奏乐器。", "\t\t小号，俗称小喇叭，属铜管乐器，是铜管乐器家族中音域最高的乐器。", "\t\t短号，铜管乐器。短号是小号的变形乐器，通常只用于军乐队和舞厅乐队，很少用于管弦乐队。", "\t\t长号是瑶、壮、苗、彝、哈尼、布依、土家、维吾尔、汉等族唇振气鸣乐器。被称为“爵士乐之王”。", "\t\t圆号，唇振动气鸣乐器，又称法国号。圆号被称作交响乐中的乐器之王。", "\t\t大号，是一种管乐、管弦乐队中音域最低的铜管乐器。大号在乐队中主要担任低音部和声或节奏，很少用于独奏。", "\t\t大管又称巴松管，来自意大利文的原意为“一捆柴”——非常形象。大管为双簧气鸣乐器，是双簧管族中的次中音与低音乐器。", "\t\t单簧管，又称黑管或克拉管，有管弦乐队中的“演说家”和木管乐器中的“戏剧女高音”之称。", "\t\t双簧管，管弦乐器。双簧管在乐队中常担任主要旋律的演奏，", "\t\t英国管，木管乐器，属于双簧管体系中的一种变种。又称中音双簧族乐器。", "\t\t萨克斯,是萨克斯风的简称，分有上低音萨克斯、中音萨克斯、次中音萨克斯、高音萨克斯。", "\t\t次中音号，铜管乐器，又名“瓦格纳大号” ，与其名字类似，是一种中音偏高音铜管乐器。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_blow_nation);

        textView_navigation = (TextView) findViewById(R.id.textView_navigation);
        textView_navigation.setText("西洋乐器->吹");
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
            alertDialog = new AlertDialog.Builder(Activity_blow_occident.this).setTitle("系统消息").setMessage("正在加载……").create();
            alertDialog.show();
        }

        @Override
        protected SimpleAdapter doInBackground(Void... params) {
            for (int i = 0; i < name.length; i++) {
                HashMap<String, Object> map_nation = new HashMap<>();
                //
                map_nation.put("Pic", pic[0]);
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

    private class onItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Activity_blow_occident.this, Activity_Instrument_1.class);
            intent.putExtra("position_item", "" + position);
            //西洋乐器-吹
            intent.putExtra("signal_type", "" + 0);
            startActivity(intent);
        }
    }
}
