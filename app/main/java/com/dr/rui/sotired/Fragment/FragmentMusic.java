package com.dr.rui.sotired.Fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dr.rui.sotired.Activity.Activity_Instrument;
import com.dr.rui.sotired.Entity.Instrument;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util.BackGround;
import com.dr.rui.sotired.Util_Image.Image;

import java.io.IOException;


/**
 * Created by rui on 2015/5/16.
 */
public class FragmentMusic extends Fragment {
    private ImageButton imageButton_single_play;
    private ImageButton imageButton_tutti_play;

    private ImageView imageView_title;
    private TextView textView_single_song_name;
    public static MediaPlayer mediaPlayer = null;
    private ProgressDialog progressDialog;
    private String url;
    private String url_1;
    private String url_2;

    private TextView textView_music_brief;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        //view.setBackgroundResource(R.drawable.blue_bc);
        imageButton_single_play = (ImageButton) view.findViewById(R.id.imageButton_single_play);
        imageButton_tutti_play = (ImageButton) view.findViewById(R.id.imageButton_tutti_play);
        imageView_title = (ImageView) view.findViewById(R.id.imageView_title);

        textView_single_song_name = (TextView) view.findViewById(R.id.textView_single_song_name);
        textView_single_song_name.setVisibility(View.INVISIBLE);
        imageButton_single_play.setOnClickListener(new buttonOnClickListener());
        imageButton_tutti_play.setOnClickListener(new buttonOnClickListener());

        textView_music_brief = (TextView) view.findViewById(R.id.textView_music_brief);
        //吹
        if (Activity_Instrument.Signal == 0) {
            int position_blow = Activity_Instrument.position;
            switch (position_blow) {
                //箫
                case 0:
                    imageView_title.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.xiao));
                    textView_music_brief.setText("\t\t\t箫的音色柔和，典雅，低音区发音深沉，弱奏时很有特色。中音区音色圆润、优美；高音区发音紧张。");
                    //独奏外链地址
                    url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/箫_独奏.mp3";
                    //合奏外链地址
                    url_2 = "http://7xkqzu.com1.z0.glb.clouddn.com/红楼梦%20-%20葬花吟%20-%20萧%20电视剧.mp3";
                    break;
                //笙
                case 1:
                    url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/笙_独奏.mp3";
                    url_2 = "http://7xkqzu.com1.z0.glb.clouddn.com/绣荷包.mp3";
                    imageView_title.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.sheng));
                    textView_music_brief.setText("笙的音色明亮甜美，高音清脆透明，中音柔和丰满，低音浑厚低沉，音量较大。而且在中国传统吹管乐器中，也是唯一能够吹出和声的乐器。\n" +
                            "笙的音色与箫、笛、管比起来，缺乏个性，音质也较为浮泛，穿透力较差，深度和力度不够，但它却是一个很好的伴奏乐器和合奏乐器。     传统笙则有分调性，技巧华丽，表现力强，较适合独奏，笙独奏曲多半也是为传统笙而写。\n");
                    break;
                //
                case 2:
                    imageView_title.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.xun));
                    break;
            }
        }


        return view;
    }

    //新建Handler
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //接收消息进行处理
            switch (msg.what) {
                //音乐加载
                case 0:
                    //进度对话框消失
                    progressDialog.dismiss();
                    break;
            }
        }
    };

    //按钮事件监听
    public class buttonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            final AnimationSet animationSet = new AnimationSet(true);
            //定义动作，自身旋转359°
            final RotateAnimation rotateAnimation = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            //
            animationSet.setDuration(5000);
            //平均速率
            animationSet.setInterpolator(new LinearInterpolator());
            //循环次数（-1代表一直循环）
            rotateAnimation.setRepeatCount(-1);
            //设置动作
            animationSet.addAnimation(rotateAnimation);

            //按钮点击事件
            switch (v.getId()) {

                //独奏
                case R.id.imageButton_single_play:
                    //判断播放器状态
                    if (mediaPlayer == null) {
                        //为空时实例化播放器对象
                        mediaPlayer = new MediaPlayer();
                        //弹出进度对话框
                        progressDialog = new ProgressDialog(getActivity()).show(getActivity(), "系统消息", "音乐正在加载……", false, false);
                        //新建线程加载网络MP3
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    //设置网络音频URL
                                    mediaPlayer.setDataSource(url_1);
                                    //播放器start之前必须调用prepare方法
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();//线程开启

                        //播放器设置prepare监听
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                //加载完成后进行播放
                                mp.start();
                                //向handler发送消息
                                handler.sendEmptyMessage(0);
                                //设置按钮图标
                                imageButton_single_play.setImageResource(R.drawable.circle_pause_big);
                                //向imageButton绑定旋转动作
                                imageButton_single_play.setAnimation(animationSet);
                                //显示文字信息
                                textView_single_song_name.setVisibility(View.VISIBLE);
                                textView_single_song_name.setText("平湖秋月");

                            }
                        });
                        //该线程用来处理加载时间，6s还未加载成功则弹出提示
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (mediaPlayer != null) {
                                    //判断播放器的播放状态
                                    //播放器未播放
                                    if (!mediaPlayer.isPlaying()) {
                                        //进度对话框消失
                                        progressDialog.dismiss();
                                        //弹出提示，网络繁忙
                                        new AlertDialog.Builder(getActivity()).setTitle("系统消息").setMessage("网络异常，请稍后再试！").show();
                                        //释放播放器资源
                                        mediaPlayer.release();
                                        //重置播放器为null
                                        mediaPlayer = null;
                                    }
                                }
                            }
                        }, 6000);

                        //播放器播放完成后的监听
                        mediaPlayer
                                .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        // TODO Auto-generated method stub
                                        //释放播放器资源
                                        mediaPlayer.release();
                                        //重置播放器为null
                                        mediaPlayer = null;
                                        //改变按钮图标
                                        imageButton_single_play.setImageResource(R.drawable.circle_play_big);
                                        //取消按钮图标动作
                                        imageButton_single_play.clearAnimation();
                                        //设置文字信息为空
                                        textView_single_song_name.setVisibility(View.VISIBLE);
                                        textView_single_song_name.setText("");
                                    }
                                });
                    }
                    //mediaPlayer不为空
                    else {
                        //播放器停止
                        mediaPlayer.stop();
                        //释放播放器资源
                        mediaPlayer.release();
                        //重置播放器为null
                        mediaPlayer = null;

                        //改变按钮图标
                        imageButton_single_play.setImageResource(R.drawable.circle_play_big);
                        //取消按钮图标动作
                        imageButton_single_play.clearAnimation();
                        //改变按钮图标
                        imageButton_tutti_play.setImageResource(R.drawable.circle_play_big);
                        //取消按钮图标动作
                        imageButton_tutti_play.clearAnimation();
                        //设置文字信息为空
                        textView_single_song_name.setVisibility(View.INVISIBLE);
                        textView_single_song_name.setText("");
                    }
                    break;

                //合奏按钮
                case R.id.imageButton_tutti_play:
                    //判断MediaPlayer
                    //如果mediaPlayer不存在
                    if (mediaPlayer == null) {
                        //为空时实例化播放器对象
                        mediaPlayer = new MediaPlayer();
                        //弹出进度对话框
                        progressDialog = new ProgressDialog(getActivity()).show(getActivity(), "系统消息", "音乐正在加载……", false, false);
                        //新建线程加载网络MP3
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    //设置网络音频URL
                                    mediaPlayer.setDataSource(url_2);
                                    //播放器start之前必须调用prepare方法
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();//线程开启

                        //播放器设置prepare监听
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                //加载完成后进行播放
                                mp.start();
                                //向handler发送消息
                                handler.sendEmptyMessage(0);
                                //设置按钮图标
                                imageButton_tutti_play.setImageResource(R.drawable.circle_pause_big);
                                //向imageButton绑定旋转动作
                                imageButton_tutti_play.setAnimation(animationSet);
                                //显示文字信息
                                textView_single_song_name.setVisibility(View.VISIBLE);
                                textView_single_song_name.setText("叹香菱—红楼梦");

                            }
                        });
                        //该线程用来处理加载时间，6s还未加载成功则弹出提示
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (mediaPlayer != null) {
                                    //判断播放器的播放状态
                                    //播放器未播放
                                    if (!mediaPlayer.isPlaying()) {
                                        //进度对话框消失
                                        progressDialog.dismiss();
                                        //弹出提示，网络繁忙
                                        new AlertDialog.Builder(getActivity()).setTitle("系统消息").setMessage("网络异常，请稍后再试！").show();
                                        //释放播放器资源
                                        mediaPlayer.release();
                                        //重置播放器为null
                                        mediaPlayer = null;
                                    }
                                }
                            }
                        }, 5000);

                        //播放器播放完成后的监听
                        mediaPlayer
                                .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        // TODO Auto-generated method stub
                                        //释放播放器资源
                                        mediaPlayer.release();
                                        //重置播放器为null
                                        mediaPlayer = null;
                                        //改变按钮图标
                                        imageButton_tutti_play.setImageResource(R.drawable.circle_play_big);
                                        //取消按钮图标动作
                                        imageButton_tutti_play.clearAnimation();


                                        //设置文字信息为空
                                        textView_single_song_name.setVisibility(View.VISIBLE);
                                        textView_single_song_name.setText("");
                                    }
                                });
                    }
                    //mediaPlayer不为空
                    else {
                        //播放器停止
                        mediaPlayer.stop();
                        //释放播放器资源
                        mediaPlayer.release();
                        //重置播放器为null
                        mediaPlayer = null;
                        if (imageButton_single_play.getAnimation() == null) {
                            //改变按钮图标
                            imageButton_tutti_play.setImageResource(R.drawable.circle_play_big);
                            //取消按钮图标动作
                            imageButton_tutti_play.clearAnimation();
                            //设置文字信息为空
                            textView_single_song_name.setVisibility(View.INVISIBLE);
                            textView_single_song_name.setText("");
                        } else {
                            //
                            imageButton_single_play.setImageResource(R.drawable.circle_play_big);
                            imageButton_single_play.clearAnimation();
                            textView_single_song_name.setVisibility(View.INVISIBLE);
                        }
                    }
                    break;
            }
        }
    }
}
