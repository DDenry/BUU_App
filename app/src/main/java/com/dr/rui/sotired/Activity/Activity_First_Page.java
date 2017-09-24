package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.dr.rui.sotired.DataBase.DBManager;
import com.dr.rui.sotired.Entity.Instrument;
import com.dr.rui.sotired.Entity.UpdateInfo;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Update.UpdateService;
import com.zain.buu.muco_test.activity.MainActivity;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Activity_First_Page extends Activity {

    //
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    //检查更新
                    UpdateVersion();
                    break;
                case 1:
                    Toast.makeText(getBaseContext(), "加载完毕", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
    private ListView listView_information;
    private SimpleAdapter adapter;
    private ArrayList<HashMap<String, Object>> list_item;
    private TextView textView_guide;
    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;
    private ImageView imageView_search;
    private int[] pic = new int[]{R.drawable.info_1, R.drawable.info_2, R.drawable.info_3, R.drawable.info_4, R.drawable.info_5};
    private String[] url = new String[]{"https://piao.damai.cn/118782.html", "https://piao.damai.cn/118776.html", "https://piao.damai.cn/118724.html", "http://ticket.chncpa.org/product-1031984.html", "http://ticket.chncpa.org/product-1031988.html"};
    private String[] name = new String[]{"管弦乐团音乐会", "经典歌曲音乐会", "金色童年", "郎朗钢琴独奏音乐会", "维也纳交响乐团音乐会"};
    private String[] info = new String[]{"演出时间： 2017.04.21\n演出地点：国家大剧院\n演出时常：以现场为准", "演出时间： 2017.05.04\n演出地点：国家大剧院\n演出时常：以现场为准", "演出时间： 2017.06.03\n演出地点：国家大剧院\n演出时常：以现场为准", "演出时间： 2017.04.08\n演出地点：国家大剧院\n演出时常：约120分钟", "演出时间： 2017.04.06\n演出地点：国家大剧院\n演出时常：约120分钟"};

    //
    public static UpdateInfo getUpdateInfo(InputStream is) throws Exception {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(is, "utf-8");//设置解析的数据源
        int type = parser.getEventType();
        UpdateInfo info = new UpdateInfo();//实体
        while (type != XmlPullParser.END_DOCUMENT) {
            switch (type) {
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    if ("version".equals(parser.getName())) {
                        info.setVersion(parser.nextText()); //获取版本号
                    } else if ("url".equals(parser.getName())) {
                        info.setUrl(parser.nextText()); //获取要升级的APK文件
                    } else if ("description".equals(parser.getName())) {
                        info.setDescription(parser.nextText()); //获取该文件的信息
                    }
                    break;
                default:
                    break;
            }
            type = parser.next();
        }
        return info;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__first__page);
        //
        System.gc();
        //
        init();

        //
        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("Pic", pic[i]);
            map.put("Name", name[i]);
            map.put("Brief", info[i]);
            list_item.add(map);
        }
        listView_information.setAdapter(adapter);
        listView_information.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Activity_First_Page.this, Activity_Browse_News.class);
                intent.putExtra("content_url", url[position]);
                startActivity(intent);
            }
        });
    }

    private void init() {
        //检查更新
        new Thread(new CheckVersionTask()).start();

        //异步加载数据库
        //new loadInfoFormDataBase().execute();


        textView_guide = (TextView) findViewById(R.id.textView_guide);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/msyhbd.ttc");
        //textView_guide.setText("\t\t首页");
        textView_guide.setTypeface(typeFace);

        listView_information = (ListView) findViewById(R.id.listView_information);
        listView_information.setCacheColorHint(0);
        list_item = new ArrayList<>();
        adapter = new SimpleAdapter(this, list_item, R.layout.list_instrument, new String[]{"Pic", "Name", "Brief"}, new int[]{R.id.imageView_instrument, R.id.textView_name, R.id.textView_brief});
        //
        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new onClickListener());

        imageView_search = (ImageView) findViewById(R.id.imageView_search);
        imageView_search.setOnClickListener(new onClickListener());
    }

    //
    private String getVersionName() throws Exception {

        PackageManager packageManager = getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
        return packageInfo.versionName;
    }

    private void UpdateVersion() {
        AlertDialog dialog = new AlertDialog.Builder(this).setMessage("是否下载更新？").setTitle("系统消息").setPositiveButton("下载", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Activity_First_Page.this, UpdateService.class);
                intent.putExtra("apkUrl", getResources().getString(R.string.server_apk_url));
                startService(intent);
            }
        }).setNegativeButton("取消", null).show();
    }

    //
    private class loadInfoFormDataBase extends AsyncTask<Void, Void, DBManager> {

        @Override
        protected DBManager doInBackground(Void... params) {
            DBManager dbManager = new DBManager(getBaseContext());
            //SQLiteDatabase dataBass = dbHelper.getWritableDatabase();
            //"insert into 表名（列名，……） values （值，……）";

            //String sql = "CREATE TABLE IF NOT EXISTS instrument_info(instrument_name text primary key,instrument_class text);";
            //String str = "insert into instrument_info(instrument_name,instrument_class) values (\"箫\",\"民族乐器\")";
            //dataBass.execSQL(sql);
            //dataBass.execSQL(str);
            //dataBass.execSQL("DROP TABLE IF EXISTS instrument_info");
            //dataBass.close();
            return dbManager;
        }

        @Override
        protected void onPostExecute(DBManager dbManager) {
            //
            SQLiteDatabase readData = dbManager.DBManager(getPackageName());
            Instrument instrument = dbManager.query(readData, new String[]{"instrument_name", "instrument_class"}, null, null);
            Log.i("Instrument:", instrument.getName());
        }

        @Override
        protected void finalize() throws Throwable {
            handler.sendEmptyMessage(1);
        }
    }

    //
    public class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.imageView_yueqizhishi:
                    intent = new Intent(Activity_First_Page.this, Activity_Choice.class);
                    break;
                case R.id.imageView_ziwopingjia:
                    intent = new Intent(Activity_First_Page.this, Activity_Test_Choice.class);
                    break;
                case R.id.imageView_moniyanzou:
                    intent = new Intent(Activity_First_Page.this, MainActivity.class);
                    break;
                case R.id.imageView_guanyuwomen:
                    intent = new Intent(Activity_First_Page.this, Activity_About_Us.class);
                    break;
                //
                case R.id.imageView_search:
                    intent = new Intent(Activity_First_Page.this, Activity_Search.class);
                    break;
            }
            //
            System.gc();
            startActivity(intent);
        }
    }

    //
    public class CheckVersionTask implements Runnable {
        private UpdateInfo info;

        public void run() {
            try {
                //从资源文件获取服务器 地址
                String path = getResources().getString(R.string.server_version_url);
                //包装成url的对象
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                InputStream is = conn.getInputStream();
                //
                info = getUpdateInfo(is);

                if (info.getVersion().equals(getVersionName())) {
                    Log.i("VersionInfo:", "版本号相同无需升级");
                } else {
                    Log.i("VersionInfo:", "版本号不同 ,提示用户升级 ");
                    //
                    handler.sendEmptyMessage(0);
                }
            } catch (Exception e) {
                // 待处理
            }
        }
    }
}
