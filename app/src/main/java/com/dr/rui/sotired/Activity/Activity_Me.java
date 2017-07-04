package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dr.rui.sotired.Entity.UserInfo;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.CircleImageView;
import com.dr.rui.sotired.Util_Image.Image;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;

public class Activity_Me extends Activity {
    private Button button_testShare;
    private CircleImageView circleImageView;
    private TextView textView_test;
    private Bitmap bitmap;
    private Platform weibo;
    //
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    //
                    button_testShare.setText("注销登录");
                    button_testShare.setTag("LogOut");
                    UserInfo userInfo = (UserInfo) msg.obj;
                    textView_test.setText(userInfo.getNickName());
                    //
                    Toast.makeText(Activity_Me.this, "微博登录成功！", Toast.LENGTH_SHORT).show();
                    break;
                //设置用户Icon
                case 1:
                    circleImageView.setImageBitmap(bitmap);
                    break;

            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        //
        ShareSDK.initSDK(Activity_Me.this);
        //
        circleImageView = (CircleImageView) findViewById(R.id.circleImageView);
        textView_test = (TextView) findViewById(R.id.textView_test);
        circleImageView.setImageBitmap(Image.readBitMap(Activity_Me.this, R.drawable.img1));
        button_testShare = (Button) findViewById(R.id.button_weiboShare);
        button_testShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getTag().toString()) {
                    case "LogIn":
                        new Login().execute();
                        break;
                    case "LogOut":
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //如果已经授权
                                if (weibo.isAuthValid()) {
                                    weibo.removeAccount(true);
                                }
                                //重置界面
                                initLogIn();
                            }
                        });
                        break;

                }
            }
        });
    }

    private void initLogIn() {
        textView_test.setText("请登录");
        circleImageView.setImageBitmap(Image.readBitMap(Activity_Me.this, R.drawable.app));
        //
        button_testShare.setTag("LogIn");
        button_testShare.setText("微博登录");
        //
        Toast.makeText(Activity_Me.this, "已经注销登录！", Toast.LENGTH_SHORT).show();
    }

    //
    private class Login extends AsyncTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            weibo = ShareSDK.getPlatform(Activity_Me.this, SinaWeibo.NAME);
            weibo.setPlatformActionListener(new PlatformActionListener() {
                @Override
                public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                    Log.i("onComplete", "!");
                    Log.i("UserInfo:", platform.getDb().exportData());
                    //{"userID":"3119024633","icon":"http:\/\/tva4.sinaimg.cn\/crop.0.0.1328.1328.1024\/b9e889f9jw8eyoezg2ys9j210w10w0va.jpg","expiresTime":1494355888299,"token":"2.00vmGF6D0H7CVc00c0c2779bheSQIE","nickname":"DDenry_","resume":"It ended when I made the end.","secretType":"0","gender":"0","snsregat":"1358419387000","shareCount":"319","remind_in":"2678905","snsUserUrl":"http:\/\/weibo.com\/u\/3119024633","secret":"","favouriteCount":"170","followerCount":"94","expiresIn":2678905}
                    UserInfo userInfo = new UserInfo();
                    //解析回调JSON数据
                    try {
                        JSONObject jsonObject = new JSONObject(platform.getDb().exportData());
                        userInfo.setNickName(jsonObject.getString("nickname"));
                        userInfo.setGender((jsonObject.getInt("gender") == 0 ? "男" : "女"));
                        userInfo.setIcon_url(jsonObject.getString("icon"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //
                    try {
                        URL url = new URL(userInfo.getIcon_url());
                        bitmap = BitmapFactory.decodeStream(url.openStream());
                        handler.sendEmptyMessage(1);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Message msg = new Message();
                    msg.what = 0;
                    msg.obj = userInfo;
                    handler.sendMessage(msg);
                }

                @Override
                public void onError(Platform platform, int i, Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public void onCancel(Platform platform, int i) {
                    Log.i("onCancel", "!");
                }
            });
        }

        @Override
        protected Object doInBackground(Object[] params) {
            //
            weibo.showUser(null);
            return null;
        }
    }
}
