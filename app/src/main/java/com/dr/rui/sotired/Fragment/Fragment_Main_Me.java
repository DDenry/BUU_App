package com.dr.rui.sotired.Fragment;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dr.rui.sotired.Activity.Activity_Main;
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
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.moments.WechatMoments;

public class Fragment_Main_Me extends Fragment {
    private Button button_weiboShare;
    private Button button_wechatShare;
    private CircleImageView circleImageView;
    private TextView textView_test;
    private Bitmap bitmap;
    private Platform platform;
    private UserInfo userInfo;
    private Handler handler;
    private View linearLayout_me_login;
    private ImageView imageView_weibo;
    private ImageView imageView_wechat;
    private ImageView imageView_qq;
    private TextView textView_friend;

    public static Fragment_Main_Me newInstance() {
        Fragment_Main_Me fragment = new Fragment_Main_Me();
        return fragment;
    }

    /*public Fragment_Main_Me(Handler handler) {
        this.handler = handler;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_me, container, false);
        //
        linearLayout_me_login = view.findViewById(R.id.linearLayout_me_login);
        linearLayout_me_login.setBackgroundResource(R.drawable.bg_red);
        textView_friend = (TextView) view.findViewById(R.id.textView_friend);
        //
        ShareSDK.initSDK(getActivity());
        //
        circleImageView = (CircleImageView) view.findViewById(R.id.circleImageView);
        textView_test = (TextView) view.findViewById(R.id.textView_test);
        //
        imageView_weibo = (ImageView) view.findViewById(R.id.imageView_weibo);
        imageView_weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Login(0).execute();
            }
        });
        imageView_wechat = (ImageView) view.findViewById(R.id.imageView_wechat);
        imageView_wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Login(1).execute();
            }
        });
        imageView_qq = (ImageView) view.findViewById(R.id.imageView_qq);
        imageView_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Login(2).execute();
            }
        });

        //微博登录
        button_weiboShare = (Button) view.findViewById(R.id.button_weiboShare);
        button_weiboShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getTag().toString()) {
                    case "LogIn":
                        new Login(0).execute();
                        break;
                    case "LogOut":
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //如果已经授权
                                if (platform.isAuthValid()) {
                                    platform.removeAccount(true);
                                }
                                //重置界面
                                initLogIn();
                            }
                        });
                        break;
                }
            }
        });
        //微信登录
        button_wechatShare = (Button) view.findViewById(R.id.button_wechatShare);
        button_wechatShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getTag().toString()) {
                    case "LogIn":
                        new Login(1).execute();
                        break;
                    case "LogOut":
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //如果已经授权
                                if (platform.isAuthValid()) {
                                    platform.removeAccount(true);
                                }
                                //重置界面
                                initLogIn();
                            }
                        });
                        break;
                }
            }
        });

        handler = new Handler() {
        };
        return view;
    }

    private void initLogIn() {
        textView_test.setText("请登录");
        textView_friend.setText("");
        circleImageView.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.app));
        //
        button_weiboShare.setTag("LogIn");
        button_weiboShare.setText("微博登录");

        button_wechatShare.setTag("LogIn");
        button_wechatShare.setText("微信登录");
        //
        linearLayout_me_login.setVisibility(View.VISIBLE);
        //
        Toast.makeText(getActivity(), "已经注销登录！", Toast.LENGTH_SHORT).show();
        //
        Activity_Main.LoginState = false;
    }

    //
    private class Login extends AsyncTask {
        private int type;

        private Login(int type) {
            this.type = type;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //
            switch (type) {
                //新浪微博登录
                case 0:
                    platform = ShareSDK.getPlatform(SinaWeibo.NAME);
                    platform.setPlatformActionListener(new PlatformActionListener() {
                        @Override
                        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                            Log.i("onComplete", "!");

                            Log.i("UserInfo:", platform.getDb().exportData());
                            //{"userID":"3119024633","icon":"http:\/\/tva4.sinaimg.cn\/crop.0.0.1328.1328.1024\/b9e889f9jw8eyoezg2ys9j210w10w0va.jpg","expiresTime":1494355888299,"token":"2.00vmGF6D0H7CVc00c0c2779bheSQIE","nickname":"DDenry_","resume":"It ended when I made the end.","secretType":"0","gender":"0","snsregat":"1358419387000","shareCount":"319","remind_in":"2678905","snsUserUrl":"http:\/\/weibo.com\/u\/3119024633","secret":"","favouriteCount":"170","followerCount":"94","expiresIn":2678905}
                            userInfo = new UserInfo();
                            //解析回调JSON数据
                            try {
                                JSONObject jsonObject = new JSONObject(platform.getDb().exportData());
                                userInfo.setNickName(jsonObject.getString("nickname"));
                                userInfo.setGender((jsonObject.getInt("gender") == 0 ? "男" : "女"));
                                userInfo.setIcon_url(jsonObject.getString("icon"));
                                userInfo.setFriends(jsonObject.getString("followerCount"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            //
                            try {
                                URL url = new URL(userInfo.getIcon_url());
                                bitmap = BitmapFactory.decodeStream(url.openStream());
//                        handler.sendEmptyMessage(1);
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        circleImageView.setImageBitmap(bitmap);
                                    }
                                });
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Message msg = new Message();
                            msg.what = 0;
                            msg.obj = userInfo;
                            //handler.sendMessage(msg);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    //
                                    linearLayout_me_login.setVisibility(View.GONE);
                                    //
                                    button_weiboShare.setText("注销登录");
                                    button_weiboShare.setTag("LogOut");
                                    textView_test.setText(userInfo.getNickName());
                                    textView_friend.setText(userInfo.getFriends());
                                    //
                                    Toast.makeText(getActivity(), "微博登录成功！", Toast.LENGTH_SHORT).show();
                                    //标识登录成功
                                    Activity_Main.LoginState = true;
                                }
                            });
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
                    break;
                //微信登录
                case 1:
                    platform = ShareSDK.getPlatform(WechatMoments.NAME);
                    platform.setPlatformActionListener(new PlatformActionListener() {
                        @Override
                        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                            Log.i("onComplete", "!");
                            Log.i("UserInfo:", platform.getDb().exportData());
                            userInfo = new UserInfo();
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
//                        handler.sendEmptyMessage(1);
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        circleImageView.setImageBitmap(bitmap);
                                    }
                                });
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    //
                                    button_wechatShare.setText("注销微信登录");
                                    button_wechatShare.setTag("LogOut");
                                    textView_test.setText(userInfo.getNickName());
                                    textView_friend.setText(userInfo.getFriends());
                                    //
                                    Toast.makeText(getActivity(), "微信登录成功！", Toast.LENGTH_SHORT).show();
                                    //
                                    Activity_Main.LoginState = true;
                                }
                            });
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
                    break;
                case 2:
                    platform = ShareSDK.getPlatform(QQ.NAME);
                    platform.setPlatformActionListener(new PlatformActionListener() {
                        @Override
                        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                            Log.i("onComplete", "!");
                            Log.i("UserInfo:", platform.getDb().exportData());
                            userInfo = new UserInfo();
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
//                        handler.sendEmptyMessage(1);
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        circleImageView.setImageBitmap(bitmap);
                                    }
                                });
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    //
                                    button_wechatShare.setText("注销QQ登录");
                                    button_wechatShare.setTag("LogOut");
                                    textView_test.setText(userInfo.getNickName());
                                    textView_friend.setText(userInfo.getFriends());
                                    //
                                    Toast.makeText(getActivity(), "微信QQ成功！", Toast.LENGTH_SHORT).show();
                                    //
                                    Activity_Main.LoginState = true;
                                }
                            });
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
                    break;
            }
        }

        @Override
        protected Object doInBackground(Object[] params) {
            //
            platform.showUser(null);
            return null;
        }
    }
}
