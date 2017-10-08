package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dr.rui.sotired.DataBase.DBHelper;
import com.dr.rui.sotired.Entity.UpdateInfo;
import com.dr.rui.sotired.Fragment.Fragment_Main_Discovery;
import com.dr.rui.sotired.Fragment.Fragment_Main_Knowledge;
import com.dr.rui.sotired.Fragment.Fragment_Main_Knowledge_Instrument;
import com.dr.rui.sotired.Fragment.Fragment_Main_Me;
import com.dr.rui.sotired.Fragment.Fragment_Main_SelfCheck;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Update.UpdateService;
import com.zain.buu.muco_test.activity.MainActivity;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Activity_Main extends Activity implements Fragment_Main_Knowledge_Instrument.CallbackFromInstrument {

    public static boolean LoginState = false;
    private ImageView imageView_yueqizhishi;
    private ImageView imageView_ziwopingjia;
    private ImageView imageView_moniyanzou;
    private ImageView imageView_guanyuwomen;
    private ImageView imageView_search;
    private ProgressDialog progressDialog;
    private FragmentManager fragmentManager;
    private Fragment_Main_Knowledge fragment_main_knowledge;
    private Fragment_Main_SelfCheck fragment_main_selfCheck;
    private Fragment_Main_Discovery fragment_main_discovery;
    private Fragment_Main_Me fragment_main_me;
    private CallbackFromActivity callbackFromActivity;
    private DBHelper dbHelper;
    private boolean haveLogin;
    //
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.obj.toString()) {
                case "NoUpdate":
                    Toast.makeText(Activity_Main.this, "已是最新版本~", Toast.LENGTH_LONG).show();
                    break;
                case "UpdateVersion":
                    UpdateVersion();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Load
        dbHelper = DBHelper.getInstance(Activity_Main.this);
        handler.post(new Runnable() {
            @Override
            public void run() {
                dbHelper.getWritableDatabase();
//                dbHelper.deleteDatabase(Activity_Main.this);
                dbHelper.close();
            }
        });
        handler.post(new Runnable() {
            @Override
            public void run() {
                progressDialog = ProgressDialog.show(Activity_Main.this, "系统消息", "正在加载，请耐心等待~", false, false);
            }
        });
        //
        handler.post(new Runnable() {
            @Override
            public void run() {
                //
                new loadUI().execute();

            }
        });
    }

    @Override
    public void sendMessage(int type) {
        callbackFromActivity = fragment_main_knowledge;
        callbackFromActivity.receiveMessage(type);
    }

    //
    private void addListener() {
        imageView_search = (ImageView) findViewById(R.id.imageView_search);
        imageView_search.setOnClickListener(new onClickListener());
        imageView_yueqizhishi = (ImageView) findViewById(R.id.imageView_yueqizhishi);
        imageView_yueqizhishi.setOnClickListener(new onClickListener());
        imageView_ziwopingjia = (ImageView) findViewById(R.id.imageView_ziwopingjia);
        imageView_ziwopingjia.setOnClickListener(new onClickListener());
        imageView_moniyanzou = (ImageView) findViewById(R.id.imageView_moniyanzou);
        imageView_moniyanzou.setOnClickListener(new onClickListener());
        imageView_guanyuwomen = (ImageView) findViewById(R.id.imageView_guanyuwomen);
        imageView_guanyuwomen.setOnClickListener(new onClickListener());
        //
        handler.post(new Runnable() {
            @Override
            public void run() {
                imageView_yueqizhishi.setBackgroundColor(Color.GRAY);
            }
        });
    }

    //
    private void setImageBackground() {
        imageView_yueqizhishi.setBackgroundColor(Color.WHITE);
        imageView_ziwopingjia.setBackgroundColor(Color.WHITE);
        imageView_moniyanzou.setBackgroundColor(Color.WHITE);
        imageView_guanyuwomen.setBackgroundColor(Color.WHITE);
    }

    //
    private void HideAllFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(fragment_main_knowledge).hide(fragment_main_selfCheck).hide(fragment_main_discovery).hide(fragment_main_me).commit();
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
                Intent intent = new Intent(Activity_Main.this, UpdateService.class);
                intent.putExtra("apkUrl", getResources().getString(R.string.server_apk_url));
                startService(intent);
            }
        }).setNegativeButton("取消", null).show();
    }

    //
    public UpdateInfo getUpdateInfo(InputStream is) throws Exception {
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

    public interface CallbackFromActivity {
        void receiveMessage(int type);
    }

    //
    private class loadUI extends AsyncTask {
        @Override
        protected void onPreExecute() {
            Log.i("Test:", "PreExecute");
        }

        @Override
        protected Object doInBackground(Object[] params) {
            //
            fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //将首页模块全部以Fragment加载进来
            fragment_main_knowledge = Fragment_Main_Knowledge.newInstance();
            fragment_main_selfCheck = Fragment_Main_SelfCheck.newInstance();
            fragment_main_discovery = Fragment_Main_Discovery.newInstance();
            fragment_main_me = Fragment_Main_Me.newInstance();

            fragmentTransaction.add(R.id.frameLayout_activity_main, fragment_main_knowledge);
            fragmentTransaction.add(R.id.frameLayout_activity_main, fragment_main_selfCheck);
            fragmentTransaction.add(R.id.frameLayout_activity_main, fragment_main_discovery);
            fragmentTransaction.add(R.id.frameLayout_activity_main, fragment_main_me);
            //
            if (haveLogin)
                fragmentTransaction.hide(fragment_main_knowledge).hide(fragment_main_selfCheck).hide(fragment_main_discovery).show(fragment_main_me).commit();
            else
                //默认首次加载显示第一页
                fragmentTransaction.show(fragment_main_knowledge).hide(fragment_main_selfCheck).hide(fragment_main_discovery).hide(fragment_main_me).commitAllowingStateLoss();
            //添加监听事件
            addListener();
            return true;
        }

        @Override
        protected void onPostExecute(Object o) {
            //
            progressDialog.dismiss();
            Log.i("Test", "PostExecute");
            //加载完成后检测是否有版本更新
            new Thread(new CheckVersionTask()).start();
            //cancel(true);
        }
    }

    //
    private class onClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (v.getId()) {
                case R.id.imageView_yueqizhishi:
                    //
                    if (fragment_main_knowledge.isHidden()) {
                        HideAllFragment();
                        fragmentTransaction.show(fragment_main_knowledge).commit();
                        //
                        setImageBackground();
                        imageView_yueqizhishi.setBackgroundColor(Color.GRAY);
                    }
                    break;
                case R.id.imageView_ziwopingjia:
                    if (fragment_main_selfCheck.isHidden()) {
                        HideAllFragment();
                        fragmentTransaction.show(fragment_main_selfCheck).commit();
                        //
                        setImageBackground();
                        imageView_ziwopingjia.setBackgroundColor(Color.GRAY);
                    }
                    break;
                case R.id.imageView_moniyanzou:
                    /*intent = new Intent(Activity_Main.this, MainActivity.class);
                    startActivity(intent);*/
                    if (fragment_main_discovery.isHidden()) {
                        HideAllFragment();
                        fragmentTransaction.show(fragment_main_discovery).commit();
                        //
                        setImageBackground();
                        imageView_moniyanzou.setBackgroundColor(Color.GRAY);
                    }
                    break;
                case R.id.imageView_guanyuwomen:
                    if (fragment_main_me.isHidden()) {
                        HideAllFragment();
                        fragmentTransaction.show(fragment_main_me).commit();
                        //
                        setImageBackground();
                        imageView_guanyuwomen.setBackgroundColor(Color.GRAY);
                    }
                    break;
                case R.id.imageView_search:
                    intent = new Intent(Activity_Main.this, Activity_Search.class);
                    startActivity(intent);
                    break;
            }
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
                Message msg = new Message();
                if (info.getVersion().equals(getVersionName())) {
                    Log.i("VersionInfo:", "版本号相同无需升级");
                    msg.obj = "NoUpdate";
                } else {
                    Log.i("VersionInfo:", "版本号不同 ,提示用户升级 ");
                    //
                    msg.obj = "UpdateVersion";
                }
                //
                handler.sendMessage(msg);
            } catch (Exception e) {
                // 待处理
            }
        }
    }
}
