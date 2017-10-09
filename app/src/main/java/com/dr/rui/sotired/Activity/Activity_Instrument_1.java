package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.dr.rui.sotired.DataBase.InstrumentsInfo;
import com.dr.rui.sotired.Entity.Instrument;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Activity_Instrument_1 extends Activity {

    public static int position_item = 0;
    public static int signal_type = 0;
    public static VideoView videoView;
    private static boolean state;
    //
    final AnimationSet animationSet = new AnimationSet(true);
    //定义动作，自身旋转359°
    final RotateAnimation rotateAnimation = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f);
    private boolean isLike = false;
    private String[] audio = new String[4];
    private String[] audio_name = new String[4];
    private int count;
    private boolean flag = true;
    private boolean cancel = false;
    private String music_url = "";
    private String music_url_1 = "";
    private String music_url_2 = "";
    private String music_url_3 = "";
    private String music_name_1 = "";
    private String music_name_2 = "";
    private String music_name_3 = "";
    private String music_name_4 = "";
    private String video_url = "";
    private MediaPlayer mediaPlayer;
    private ProgressDialog progressDialog;
    private TextView textView_music_name;
    private TextView textView_music_type;
    private TextView textView_music_content;
    private TextView textView_skill;
    private ViewPager viewPager_spe;
    private PagerAdapter pagerAdapter;
    private List<View> view = new ArrayList<>();
    private ImageView imageView_search;
    private ImageView imageView_struct_1;
    private ImageView imageView_history_1;
    private ImageView imageView_position_1;
    private ImageView imageView_instrument_struct;
    private ImageView imageView_instrument_position;
    private ImageView imageView_spe_main;
    private ImageView imageView_music_play;
    private ImageView imageView_music_forward;
    private ImageView imageView_music_backward;
    private ImageView imageView_music_pic;
    private TextView textView_instrument_name;
    private TextView textView_instrument_position;
    private TextView textView_instrument_brief_0;
    private TextView textView_instrument_brief_1;
    private TextView textView_instrument_content;
    private TextView textView_guide;
    private TextView textView_guide1;
    private TextView textView_guide2;
    private TextView textView_guide3;
    private TextView textView_guide4;
    private ImageLoader imageLoader;

    private ImageView imageView_instrument_like;
    private String current_instrument_name;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    new playMusic().execute();
                    break;
                case 1:
                    progressDialog.dismiss();
                    break;
                case 2:
//                    progressDialog.dismiss();
                    handler.sendEmptyMessage(1);
                    new AlertDialog.Builder(Activity_Instrument_1.this).setTitle("系统消息").setMessage("网络异常，请稍后再试！").show();
                    //
                    imageView_music_pic.clearAnimation();
                    mediaPlayer.release();
                    break;
                case 3:
                    //
                    animationSet.setDuration(50000);
                    //平均速率
                    animationSet.setInterpolator(new LinearInterpolator());

                    animationSet.setFillAfter(true);
                    //循环次数（-1代表一直循环）
                    rotateAnimation.setRepeatCount(-1);
                    //设置动作
                    animationSet.addAnimation(rotateAnimation);
                    imageView_music_pic.setAnimation(animationSet);
                    imageView_music_pic.startAnimation(animationSet);
                    imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_pause_big));
                    break;

                case 4:
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
//                  mediaPlayer.release();
                        mediaPlayer.reset();
                        imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                        imageView_music_pic.clearAnimation();
                    }
                    break;
                case 5:
                    progressDialog.show();
                    break;
                //填充乐器内容
                case 6:
                    Instrument instrument = (Instrument) msg.obj;
                    fillContent(instrument);
                    break;
                //添加或者取消收藏
                case 7:
                    //
                    if (isLike)
                        Toast.makeText(Activity_Instrument_1.this, "已将乐器" + current_instrument_name + "添加到收藏夹！", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Activity_Instrument_1.this, "已将乐器" + current_instrument_name + "从收藏夹移除！", Toast.LENGTH_SHORT).show();
                    break;
                //提示暂未登录
                case 8:
                    Toast.makeText(Activity_Instrument_1.this, "请先登录~", Toast.LENGTH_SHORT).show();
                    break;
            }
            super.handleMessage(msg);
        }
    };
    //
    private PopupWindow mPopupWindow;
    private ImageView imageView_popwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument);

        //跳转
        Intent intent = getIntent();
        //
        if (intent.getStringExtra("position_item") != null) {
            position_item = Integer.parseInt(intent.getStringExtra("position_item"));
            signal_type = Integer.parseInt(intent.getStringExtra("signal_type"));
        } else {
            flag = false;
        }
        Log.i("INFORMATION:Position:", "position_item:" + position_item);
        Log.i("INFORMATION:Position:", "signal_type::" + signal_type);
        //
        init();
        //
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return view.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(view.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view1 = view.get(position);
                container.addView(view1);
                return view1;
            }
        };
        viewPager_spe.setAdapter(pagerAdapter);

        /*//
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/msyhbd.ttc");
        textView_guide.setTypeface(typeFace);
        textView_guide1.setTypeface(typeFace);
        textView_guide2.setTypeface(typeFace);
        textView_guide3.setTypeface(typeFace);
        textView_guide4.setTypeface(typeFace);
        Typeface typeFace1 = Typeface.createFromAsset(getAssets(), "fonts/msyh.ttc");
        textView_instrument_brief_0.setTypeface(typeFace1);
        textView_instrument_brief_1.setTypeface(typeFace1);
        textView_instrument_content.setTypeface(typeFace1);
        textView_instrument_position.setTypeface(typeFace1);
        textView_music_name.setTypeface(typeFace1);
        textView_music_type.setTypeface(typeFace1);
        textView_music_content.setTypeface(typeFace1);
        textView_skill.setTypeface(typeFace1);*/

        if (flag) {
            Message msg = new Message();
            msg.what = 6;
            //民族乐器类型
            if (Activity_Choice.Signal_Choice == 0) {
                //获取位置
                //position_blow = Integer.parseInt(intent.getStringExtra("position_blow"));
                //民族乐器-吹
                if (signal_type == 0) {
                    switch (position_item) {
                        //民族乐器-吹-箫.
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("箫");
                            break;
                        //民族乐器-吹-笙
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("笙");
                            break;
                        //民族乐器-吹-埙
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("埙");
                            break;
                        //民族乐器-吹-竹笛
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("竹笛");
                            break;
                        //民族乐器-吹-唢呐
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("唢呐");
                            break;
                        //民族乐器-吹-巴乌
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("巴乌");
                            break;
                        //民族乐器-吹-葫芦丝
                        case 6:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("葫芦丝");
                            break;
                    }
                }
                //民族乐器-拉
                if (signal_type == 1) {
                    switch (position_item) {
                        //民族乐器-拉-二胡
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("二胡");
                            break;
                        //民族乐器-拉-高胡
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("高胡");
                            break;
                        //民族乐器-拉-板胡
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("板胡");
                            break;
                        //民族乐器-拉-三弦
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("三弦");
                            break;
                        //民族乐器-拉-马头琴
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("马头琴");
                            break;
                    }
                }
                //民族乐器-弹
                if (signal_type == 2) {
                    switch (position_item) {
                        //民族乐器-弹-阮
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("阮");
                            break;
                        //民族乐器-弹-琵琶
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("琵琶");
                            break;
                        //民族乐器-弹-月琴
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("月琴");
                            break;
                        //民族乐器-弹-柳琴
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("柳琴");
                            break;
                        //民族乐器-弹-古琴
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("古琴");
                            break;
                        //民族乐器-弹-古筝
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("古筝");
                            break;
                    }
                }
                //民族乐器-打
                if (signal_type == 3) {
                    switch (position_item) {
                        //民族乐器-打-钹
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("钹");
                            break;
                        //民族乐器-打-锣
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("锣");
                            break;
                        //民族乐器-打-排鼓
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("排鼓");
                            break;
                        //民族乐器-打-大鼓
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大鼓");
                            break;
                        //民族乐器-打-木鱼
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("木鱼");
                            break;
                        //民族乐器-打-扬琴
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("扬琴");
                            break;
                    }
                }

                //民族乐器-弦鸣
                if (signal_type == 4) {
                    switch (position_item) {
                        //民族乐器-弦鸣-阮
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("阮");
                            break;
                        //民族乐器-弦鸣-二胡
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("二胡");
                            break;
                        //民族乐器-弦鸣-高胡
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("高胡");
                            break;
                        //民族乐器-弦鸣-板胡
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("板胡");
                            break;
                        //民族乐器-弦鸣-三弦
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("三弦");
                            break;
                        //民族乐器-弦鸣-扬琴
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("扬琴");
                            break;
                        //民族乐器-弦鸣-琵琶
                        case 6:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("琵琶");
                            break;
                        //民族乐器-弦鸣-月琴
                        case 7:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("月琴");
                            break;
                        //民族乐器-弦鸣-柳琴
                        case 8:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("柳琴");
                            break;
                        //民族乐器-弦鸣-古琴
                        case 9:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("古琴");
                            break;
                        //民族乐器-弦鸣-古筝
                        case 10:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("古筝");
                            break;
                        //民族乐器-弦鸣-马头琴
                        case 11:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("马头琴");
                            break;
                    }
                }
                //民族乐器-气鸣
                if (signal_type == 5) {
                    switch (position_item) {
                        //民族乐器-气鸣-箫
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("箫");
                            break;
                        //民族乐器-气鸣-笙
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("笙");
                            break;
                        //民族乐器-气鸣-埙
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("埙");
                            break;
                        //民族乐器-气鸣-竹笛
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("竹笛");
                            break;
                        //民族乐器-气鸣-唢呐
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("唢呐");
                            break;
                        //民族乐器-气鸣-巴乌
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("巴乌");
                            break;
                        //民族乐器-气鸣-葫芦丝
                        case 6:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("葫芦丝");
                            break;
                    }
                }
                //民族乐器-体鸣
                if (signal_type == 6) {
                    switch (position_item) {
                        //民族乐器-体鸣-锣
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("锣");
                            break;
                        //民族乐器-体鸣-钹
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("钹");
                            break;
                        //民族乐器-体鸣-木鱼
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("木鱼");
                            break;
                    }
                }

                //民族乐器-膜鸣
                if (signal_type == 7) {
                    switch (position_item) {
                        //民族乐器-膜鸣-排鼓
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("排鼓");
                            break;
                        //民族乐器-膜鸣-大鼓
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大鼓");
                            break;
                    }
                }
            }
            //西洋乐器类型
            else {
                //西洋乐器-吹
                if (signal_type == 0) {
                    switch (position_item) {
                        //西洋乐器-吹-小号
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("小号");
                            break;
                        //西洋乐器-吹-短笛
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("短笛");
                            /*
                            textView_guide.setText("\t\t乐器知识>分类>西洋乐器>吹>短笛");

                            music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_duandi.mp3";
                            video_url = "http://7xkqzu.com1.z0.glb.clouddn.com/video_duandi.mp4";

                            textView_instrument_name.setText("短笛");

                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.duandi));
                            //
                            //textView_instrument_brief_0.setText("\t\t\t\t短笛，吹奏气鸣木管乐器。短笛是长笛家族的一种变种乐器，名称来源自于意大利 “flauto piccolo”（缩小的长笛），是音域最高的木管乐器，也是交响乐队中音域最高的乐器之一。");
                            //结构
                            imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_duandi));
                            textView_instrument_brief_1.setText("\t\t\t\t短笛长约33cm，直径13mm，长度是普通长笛的一半。其发音原理是依靠管内空气振动发声。短笛可以是由木、金属、塑胶或化合物构成。");
                            //历史
                            textView_instrument_content.setText("\t\t\t\t早期的短笛是没有按键的，这亦是短笛常与另一种同样是横吹的鼓笛（fife）混淆的原因。短笛最初常被用作伴奏乐器，作为“装饰”乐曲之用。但是，在巴洛克时期，已经出现了很多为短笛而写的协奏曲及独奏曲，其中最早将短笛运用于管弦乐团的作品是贝多芬的《第5号交响曲》。现在，短笛已成为交响乐团中的常规木管乐器，自浪漫乐派后期起，更常出现有短笛的独立声部。");
                            //
                            textView_instrument_position.setText("\t\t\t\t位于指挥正前方、中提琴声部后面一排。");
                            imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_duandi));*/
                            break;
                        //西洋乐器-吹-长笛
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("长笛");
                            /*
                            music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_changdi.mp3";
                            video_url = "http://7xkqzu.com1.z0.glb.clouddn.com/video_changdi.mp4";

                            textView_instrument_name.setText("长笛");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.changdi));
                            //
                            textView_instrument_brief_1.setText("长笛，气鸣吹奏木管乐器，是现代管弦乐和室乐中主要的高音旋律乐器，也是重要的独奏乐器。");

                            imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_changdi));
                            textView_instrument_content.setText("\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。为单管、竖吹，历史悠久，音色圆润轻柔，幽静典雅，适于独奏和重奏。");


                            imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_changdi));*/
                            break;

                        //西洋乐器-吹-短号
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("短号");
                            /*
                            textView_guide.setText("\t\t乐器知识>分类>西洋乐器>吹>短号");
                            textView_instrument_name.setText("短号");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.duanhao));
                            //
                            textView_instrument_brief_1.setText("短号，铜管乐器。短号是小号的变形乐器，通常只用于军乐队和舞厅乐队，很少用于管弦乐队。另外还有降E调短号，使用较少。");
                            //
                            textView_instrument_content.setText("");*/
                            break;
                        //西洋乐器-吹-长号
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("长号");
                            /*
                            textView_instrument_name.setText("长号");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.changhao));
                            //
                            textView_instrument_brief_1.setText("长号是瑶、壮、苗、彝、哈尼、布依、土家、维吾尔、汉等族唇振气鸣乐器。被称为“爵士乐之王”。");*/
                            break;
                        //西洋乐器-吹-圆号
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("圆号");
                            /*
                            textView_instrument_name.setText("圆号");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yuanhao));
                            //
                            textView_instrument_brief_1.setText("圆号，唇振动气鸣乐器，又称法国号。圆号被称作交响乐中的乐器之王。");*/
                            break;
                        //西洋乐器-吹-大号
                        case 6:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大号");
                            /*
                            textView_instrument_name.setText("大号");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.dahao));
                            //
                            textView_instrument_brief_1.setText("大号，是一种管乐、管弦乐队中音域最低的铜管乐器。大号在乐队中主要担任低音部和声或节奏，很少用于独奏。");*/
                            break;
                        //西洋乐器-吹-大管
                        case 7:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大管");

                            /*textView_instrument_name.setText("大管");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.daguan));
                            //
                            textView_instrument_brief_1.setText("大管又称巴松管，来自意大利文的原意为“一捆柴”——非常形象。大管为双簧气鸣乐器，是双簧管族中的次中音与低音乐器。");
                            */
                            break;
                        //西洋乐器-吹-单簧管
                        case 8:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("单簧管");
                            /*textView_instrument_name.setText("单簧管");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.danhuangguan));
                            //
                            textView_instrument_brief_1.setText("单簧管，又称黑管或克拉管，有管弦乐队中的“演说家”和木管乐器中的“戏剧女高音”之称。");
                            */
                            break;
                        //西洋乐器-吹-双簧管
                        case 9:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("双簧管");
                            /*textView_instrument_name.setText("双簧管");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.shuanghuangguan));
                            //
                            textView_instrument_brief_1.setText("双簧管，管弦乐器。双簧管在乐队中常担任主要旋律的演奏，");*/
                            break;
                        //西洋乐器-吹-英国管
                        case 10:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("英国管");
                            /*textView_instrument_name.setText("英国管");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yingguoguan));
                            //
                            textView_instrument_brief_1.setText("英国管，木管乐器，属于双簧管体系中的一种变种。又称中音双簧族乐器。");*/
                            break;
                        //西洋乐器-吹-萨克斯
                        case 11:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("萨克斯");
                            /*textView_instrument_name.setText("萨克斯");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.gray));
                            //
                            textView_instrument_brief_1.setText("萨克斯,是萨克斯风的简称，分有上低音萨克斯、中音萨克斯、次中音萨克斯、高音萨克斯。");*/
                            break;
                        //西洋乐器-吹-次中音号
                        case 12:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("次中音号");
                            /*textView_instrument_name.setText("次中音号");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.cizhongyinhao));
                            //
                            textView_instrument_brief_1.setText("次中音号，铜管乐器，又名“瓦格纳大号” ，与其名字类似，是一种中音偏高音铜管乐器。");*/
                            break;
                    }
                }
                //西洋乐器-拉
                if (signal_type == 1) {
                    switch (position_item) {
                        //西洋乐器-拉-小提琴
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("小提琴");
                            /*textView_instrument_name.setText("小提琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("小提琴，一种四弦擦奏弦鸣乐器，有“乐器皇后”的美誉，它在器乐中占有极重要的位置，与钢琴、古典吉他并称为世界三大乐器。");
                            */
                            break;
                        //西洋乐器-拉-中提琴
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("中提琴");
                            /*textView_instrument_name.setText("中提琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("中提琴，擦奏弦鸣乐器，是提琴族中的中音乐器，外形及结构与小提琴基本相同，只是形体略大。");*/
                            break;
                        //西洋乐器-拉-大提琴
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大提琴");
                           /* textView_instrument_name.setText("大提琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("大提琴是西洋三大独奏乐器之一，是管弦乐队中必不可少的次中音或低音弦乐器，有“音乐贵妇”之称。");*/
                            break;
                        //西洋乐器-拉-低音提琴
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("低音提琴");
                            /*textView_instrument_name.setText("低音提琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("低音提琴，擦奏弦鸣乐器，又称倍大提琴。提琴家族中体积最大、发音最低的弓弦乐器。它是乐队中音响的支柱，基本节奏的基础。");
                            */
                            break;
                    }
                }
                //西洋乐器-弹
                if (signal_type == 2) {
                    switch (position_item) {
                        //西洋乐器-弹-钢琴
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("钢琴");
                            /*textView_instrument_name.setText("钢琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("钢琴，键盘敲弦乐器。钢琴因为它宽广的音域，绝美的音色，被称之“乐器之王”。");
                            */
                            break;
                        //西洋乐器-弹-竖琴
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("竖琴");
                            /*textView_instrument_name.setText("竖琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("竖琴，世界上最古老的拨弦乐器之一，交响乐队以及歌舞剧中特殊的色彩性乐器，主要担任和声伴奏和演奏滑奏式的装饰句。");
                            */
                            break;
                        //西洋乐器-弹-木吉他
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("木吉他");
                            /*textView_instrument_name.setText("木吉他");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("木吉他，西洋拨弦乐器。是纯粹的震动发声。在流行音乐、摇滚音乐、蓝调、民歌、佛朗明哥中，木吉他都被视为主要乐器。");
                            */
                            break;
                        //西洋乐器-弹-手风琴
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("手风琴");
                            /*textView_instrument_name.setText("手风琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("手风琴是一种既能够独奏，又能伴奏的簧片乐器，音高固定，易学易懂，体积小，携带方便。");
                            */
                            break;
                        //西洋乐器-弹-管风琴
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("管风琴");
                            /*textView_instrument_name.setText("管风琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("管风琴是一种键盘乐器，属于气鸣乐器类的混合型乐器。管风琴在欧洲乐器中占有统治地位，被称为乐器之王，在音乐艺术发展史上占有重要地位。");
                            */
                            break;
                        //西洋乐器-弹-簧风琴
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("簧风琴");
                            /*textView_instrument_name.setText("簧风琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("簧风琴是一种小型的键盘乐器，一般的簧风琴由压出空气发声，但是美式的簧风琴是由吸入空气发声，音色更加柔和。");
                           */
                            break;
                        //西洋乐器-弹-电吉他
                        case 6:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("电吉他");
                            /*textView_instrument_name.setText("电吉他");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("电吉他是一种拨弦乐器，配合效果器的使用，电吉他有很强的表现力，在现代音乐中有很重要的位置。");
                            */
                            break;
                        //西洋乐器-弹-电贝司
                        case 7:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("电贝司");
                            /*textView_instrument_name.setText("电贝司");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("电贝司，又称为贝斯吉他、低音吉他，简称贝斯，现代摇滚乐团组合的主要乐器。");
                            */
                            break;
                        //西洋乐器-弹-电钢琴
                        case 8:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("电钢琴");
                            /*textView_instrument_name.setText("电钢琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("暂无简介");
                            */
                            break;
                        //西洋乐器-弹-合成器
                        case 9:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("合成器");
                            /*textView_instrument_name.setText("合成器");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("合成器是一种以加法合成、减法合成、FM、physical modelling或相位调变等电子技术发声之电子乐器。");
                            */
                            break;
                    }
                }
                //西洋乐器-打
                if (signal_type == 3) {
                    switch (position_item) {
                        //西洋乐器-打-镲
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("镲");
                            /*textView_instrument_name.setText("镲");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("暂无简介");*/
                            break;
                        //西洋乐器-打-沙槌
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("沙槌");
                            /*textView_instrument_name.setText("沙槌");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("沙槌，摇奏体鸣乐器，亦称沙球。一般归于打击类。 演奏时发出“轻微沙沙声”。");
                            */
                            break;
                        //西洋乐器-打-木琴
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("木琴");
                            /*textView_instrument_name.setText("木琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("木琴，属竹木击奏体鸣乐器类，木琴是变音打击乐器，可用于独奏旋律。");
                            */
                            break;
                        //西洋乐器-打-定音鼓
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("定音鼓");
                            /*textView_instrument_name.setText("定音鼓");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("定音鼓，膜鸣乐器。定音鼓是打击乐器的一种，是一个铜制或黄铜制的共鸣胴，常用基本奏法有单奏及滚奏。");
                            */
                            break;
                        //西洋乐器-打-架子鼓
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("架子鼓");
                            /*textView_instrument_name.setText("架子鼓");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("架子鼓，一套以鼓为主的组合性打击乐器。是爵士乐队中十分重要的一种打击乐器。");*/

                            break;
                        //西洋乐器-打-钢片琴
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("钢片琴");
                            /*textView_instrument_name.setText("钢片琴");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("钢琴片，击奏体鸣乐器。用于管弦乐队和管乐队的打击乐器。形如小型钢琴的键盘乐器。");*/
                            break;
                        //西洋乐器-打-三角铁
                        case 6:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("三角铁");
                            /*textView_instrument_name.setText("三角铁");
                            //乐器主图
                            imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                            //
                            textView_instrument_brief_1.setText("三角铁，民族打击乐器 ，又称“三角铃”，是一种古老的打击乐器，是管乐队、管弦乐队、交响乐队乃至歌舞剧乐队中必不可少的打击乐器。");
                            */
                            break;

                    }
                }
                //西洋乐器-弦乐
                if (signal_type == 4) {
                    switch (position_item) {
                        //西洋乐器-弦乐-竖琴
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("竖琴");
                            break;
                        //西洋乐器-弦乐-小提琴
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("小提琴");
                            break;
                        //西洋乐器-弦乐-中提琴
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("中提琴");
                            break;
                        //西洋乐器-弦乐-大提琴
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大提琴");
                            break;
                        //西洋乐器-弦乐-低音提琴
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("低音提琴");
                            break;
                        //西洋乐器-弦乐-木吉他
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("木吉他");
                            break;
                    }
                }
                //西洋乐器-木管
                if (signal_type == 5) {
                    switch (position_item) {
                        //西洋乐器-木管-短笛
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("短笛");
                            break;
                        //西洋乐器-木管-长笛
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("长笛");
                            break;
                        //西洋乐器-木管-大管
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大管");
                            break;
                        //西洋乐器-木管-单簧管
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("单簧管");
                            break;
                        //西洋乐器-木管-双簧管
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("双簧管");
                            break;
                        //西洋乐器-木管-萨克斯
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("萨克斯");
                            break;
                        //西洋乐器-木管-英国管
                        case 6:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("英国管");
                            break;
                    }
                }
                //西洋乐器-铜管
                if (signal_type == 6) {
                    switch (position_item) {
                        //西洋乐器-铜管
                    }
                }
                /*//西洋乐器-键盘
                if (signal_type == 7) {
                    switch (position_item) {
                    }
                }*/
                //西洋乐器-打击
                if (signal_type == 8) {
                    switch (position_item) {
                    }
                }
                //西洋乐器-弦鸣
                if (signal_type == 9) {
                    switch (position_item) {
                        //西洋乐器-弦鸣-竖琴
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("竖琴");
                            break;
                        //西洋乐器-弦鸣-小提琴
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("小提琴");
                            break;
                        //西洋乐器-弦鸣-中提琴
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("中提琴");
                            break;
                        //西洋乐器-弦鸣-大提琴
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大提琴");
                            break;
                        //西洋乐器-弦鸣-低音提琴
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("低音提琴");
                            break;
                        //西洋乐器-弦鸣-木吉他
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("木吉他");
                            break;
                    }
                }

                //西洋乐器-气鸣
                if (signal_type == 10) {
                    switch (position_item) {
                        //西洋乐器-气鸣-短笛
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("短笛");
                            break;
                        //西洋乐器-气鸣-长笛
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("长笛");
                            break;
                        //西洋乐器-气鸣-小号
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("小号");
                            break;
                        //西洋乐器-气鸣-短号
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("短号");
                            break;
                        //西洋乐器-气鸣-长号
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("长号");
                            break;
                        //西洋乐器-气鸣-圆号
                        case 5:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("圆号");
                            break;
                        //西洋乐器-气鸣-大管
                        case 6:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大管");
                            break;
                        //西洋乐器-气鸣-大号
                        case 7:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("大号");
                            break;
                        //西洋乐器-气鸣-手风琴
                        case 8:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("手风琴");
                            break;
                        //西洋乐器-气鸣-簧风琴
                        case 9:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("簧风琴");
                            break;
                        //西洋乐器-气鸣-管风琴
                        case 10:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("管风琴");
                            break;
                        //西洋乐器-气鸣-单簧管
                        case 11:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("单簧管");
                            break;
                        //西洋乐器-气鸣-双簧管
                        case 12:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("双簧管");
                            break;
                        //西洋乐器-气鸣-英国管
                        case 13:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("英国管");
                            break;
                        //西洋乐器-气鸣-萨克斯
                        case 14:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("萨克斯");
                            break;
                        //西洋乐器-气鸣-次中音号
                        case 15:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("次中音号");
                            break;
                    }
                }
                //西洋乐器-体鸣
                if (signal_type == 11) {
                    switch (position_item) {
                        //西洋乐器-体鸣-镲
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("镲");
                            break;
                        //西洋乐器-体鸣-沙槌
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("沙槌");
                            break;
                        //西洋乐器-体鸣-木琴
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("木琴");
                            break;
                        //西洋乐器-体鸣-三角铁
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("三角铁");
                            break;
                        //西洋乐器-体鸣-钢片琴
                        case 4:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("钢片琴");
                            break;
                    }
                }
                //西洋乐器-膜鸣
                if (signal_type == 12) {
                    switch (position_item) {
                        //西洋乐器-膜鸣-定音鼓
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("定音鼓");
                            break;
                        //西洋乐器-膜鸣-架子鼓
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("架子鼓");
                            break;
                    }
                }
                //西洋乐器-电鸣
                if (signal_type == 13) {
                    switch (position_item) {
                        //西洋乐器-电鸣-电吉他
                        case 0:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("电吉他");
                            break;
                        //西洋乐器-电鸣-电贝司
                        case 1:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("电贝司");
                            break;
                        //西洋乐器-电鸣-电钢琴
                        case 2:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("电钢琴");
                            break;
                        //西洋乐器-电鸣-合成器
                        case 3:
                            msg.obj = new InstrumentsInfo().loadInstrumentInfo("合成器");
                            break;
                    }

                }
            }
            //
            handler.sendMessage(msg);
        } else {
            //
            current_instrument_name = getIntent().getStringExtra("instrument_name");
            fillContent(new InstrumentsInfo().loadInstrumentInfo(getIntent().getStringExtra("instrument_name")));
        }
    }

    private void init() {
        //
        imageView_search = (ImageView) findViewById(R.id.imageView_search);
        imageView_search.setOnClickListener(new onClickListener());

        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(this)
                .memoryCacheExtraOptions(480, 800) // maxwidth, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3)//线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(new BaseImageDownloader(this, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();//开始构建
        ImageLoader.getInstance().init(config);

        imageLoader = ImageLoader.getInstance();

        imageView_instrument_like = (ImageView) findViewById(R.id.imageView_instrument_like);
        imageView_instrument_like.setOnClickListener(new onClickListener());

        textView_guide = (TextView) findViewById(R.id.textView_guide);
        textView_guide1 = (TextView) findViewById(R.id.textView_guide1);
        textView_guide2 = (TextView) findViewById(R.id.textView_guide2);
        textView_guide3 = (TextView) findViewById(R.id.textView_guide3);
        textView_guide4 = (TextView) findViewById(R.id.textView_guide4);

        textView_guide.setOnClickListener(new onClickListener());
        textView_guide1.setOnClickListener(new onClickListener());
        textView_guide2.setOnClickListener(new onClickListener());
        textView_guide3.setOnClickListener(new onClickListener());


        progressDialog = new ProgressDialog(Activity_Instrument_1.this);
        progressDialog.setTitle("系统消息！");
        progressDialog.setMessage("内容正在加载……");
        //
        progressDialog.setCancelable(false);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("MediaPrepared!", "Enter");
                //
                mediaPlayer.start();
                textView_music_name.setText(audio_name[count]);
                //
                if (count < 2) textView_music_type.setText("独奏");
                else textView_music_type.setText("合奏");
                state = true;
                progressDialog.dismiss();
                handler.sendEmptyMessage(3);
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.reset();
                //mediaPlayer.release();
                imageView_music_pic.clearAnimation();
                imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
            }
        });

        //
        imageView_struct_1 = (ImageView) findViewById(R.id.imageView_struct_1);
        imageView_history_1 = (ImageView) findViewById(R.id.imageView_history_1);
        imageView_position_1 = (ImageView) findViewById(R.id.imageView_position_1);

        imageView_struct_1.setOnClickListener(new onClickListener());
        imageView_history_1.setOnClickListener(new onClickListener());
        imageView_position_1.setOnClickListener(new onClickListener());

        //
        LayoutInflater inflater = LayoutInflater.from(this);
        View spe = inflater.inflate(R.layout.fragment_spe_2, null);
        View music = inflater.inflate(R.layout.music, null);
        View skill = inflater.inflate(R.layout.fragment_skill, null);

        //spe
        textView_instrument_name = (TextView) spe.findViewById(R.id.textView_instrument_name);
        textView_instrument_position = (TextView) spe.findViewById(R.id.textView_instrument_position);
        textView_instrument_brief_0 = (TextView) spe.findViewById(R.id.textView_instrument_brief_0);
        textView_instrument_brief_1 = (TextView) spe.findViewById(R.id.textView_instrument_brief_1);
        textView_instrument_content = (TextView) spe.findViewById(R.id.textView_instrument_content);
        imageView_spe_main = (ImageView) spe.findViewById(R.id.imageView_spe_main);

        imageView_instrument_struct = (ImageView) spe.findViewById(R.id.imageView_instrument_struct);
        //
        imageView_instrument_struct.setOnClickListener(new onClickListener());
        imageView_instrument_position = (ImageView) spe.findViewById(R.id.imageView_instrument_position);

        //music
        textView_music_name = (TextView) music.findViewById(R.id.textView_music_name);

        textView_music_type = (TextView) music.findViewById(R.id.textView_music_type);
        textView_music_content = (TextView) music.findViewById(R.id.textView_music_content);

        imageView_music_play = (ImageView) music.findViewById(R.id.imageView_music_play);
        imageView_music_play.setOnClickListener(new onClickListener());
        imageView_music_forward = (ImageView) music.findViewById(R.id.imageView_music_forward);
        imageView_music_forward.setOnClickListener(new onClickListener());
        imageView_music_backward = (ImageView) music.findViewById(R.id.imageView_music_backward);
        imageView_music_backward.setOnClickListener(new onClickListener());
        imageView_music_pic = (ImageView) music.findViewById(R.id.imageView_music_pic_guangpan);
        imageView_music_pic.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.zhizhenguangpan));
        //设置音乐播放界面图片
        //imageView_music_pic.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.earphone));
        //skill
        textView_skill = (TextView) skill.findViewById(R.id.textView_skill);

        //VideoView播放视频
        videoView = (VideoView) skill.findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.show(0);

        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("VideoView:", "Prepared");
                videoView.start();
                progressDialog.dismiss();
            }
        });
        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (!videoView.isPlaying()) new playVideo().execute();
                }
                return false;
            }
        });

        view.add(spe);
        view.add(music);
        view.add(skill);
        //
        viewPager_spe = (ViewPager) findViewById(R.id.viewPager_spe);
        viewPager_spe.setCurrentItem(0);
        viewPager_spe.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    //
                    case 0:
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            //
                            imageView_music_pic.clearAnimation();
                            imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                        }
                        //
                        if (videoView.isPlaying()) videoView.pause();
                        imageView_struct_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jianjie1));
                        imageView_history_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yinyue));
                        imageView_position_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jiqiao));
                        break;
                    case 1:
                        if (videoView.isPlaying()) videoView.pause();
                        imageView_struct_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jianjie));
                        imageView_history_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yinyue1));
                        imageView_position_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jiqiao));
                        break;
                    case 2:
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            //
                            imageView_music_pic.clearAnimation();
                            imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                        }
                        imageView_struct_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jianjie));
                        imageView_history_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yinyue));
                        imageView_position_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jiqiao1));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //
    public void fillContent(Instrument instrument) {
        textView_guide.setText(instrument.getGuide());
        textView_guide1.setText(instrument.getGuide1());
        textView_guide2.setText(instrument.getGuide2());
        textView_guide3.setText(instrument.getGuide3());
        textView_guide4.setText(instrument.getGuide4());
        textView_instrument_name.setText(instrument.getName());
        //imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, instrument.getPic_spe()));
        imageLoader.displayImage("drawable://" + instrument.getPic_spe(), imageView_spe_main);
        textView_instrument_brief_1.setText(instrument.getBrief1());
        textView_instrument_brief_0.setText(instrument.getBrief0());
        music_url = instrument.getMusic_url1();
        music_url_1 = instrument.getMusic_url2();
        music_url_2 = instrument.getMusic_url3();
        music_url_3 = instrument.getMusic_url4();
        music_name_1 = instrument.getMusic_name1();
        music_name_2 = instrument.getMusic_name2();
        music_name_3 = instrument.getMusic_name3();
        music_name_4 = instrument.getMusic_name4();
        textView_music_content.setText(instrument.getMusic_content());
        video_url = instrument.getVideo_url();
        //imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, instrument.getPic_struct()));
        imageLoader.displayImage("drawable://" + instrument.getPic_struct(), imageView_instrument_struct);
        imageView_instrument_struct.setTag(instrument.getPic_struct());
        textView_instrument_content.setText(instrument.getContent());
        //imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, instrument.getPic_position()));
        imageLoader.displayImage("drawable://" + instrument.getPic_position(), imageView_instrument_position);
        textView_skill.setText(instrument.getSkill());
    }

    //
    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = true;
        if (mediaPlayer != null) {
            //
            mediaPlayer.stop();

            imageView_music_pic.clearAnimation();

            mediaPlayer.release();
            mediaPlayer = null;
        }
        //
        imageLoader.clearMemoryCache();
        imageLoader.clearDiskCache();
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //
                case R.id.imageView_search:
                    Intent intent = new Intent(Activity_Instrument_1.this, Activity_Search.class);
                    startActivity(intent);
                    break;
                //
                case R.id.imageView_instrument_like:
                    //如果已经登录
                    if (Activity_Main.LoginState) {
                        isLike = !isLike;
                        if (isLike)
                            imageView_instrument_like.setImageResource(R.drawable.btn_star_big_on_disable);
                        else
                            imageView_instrument_like.setImageResource(R.drawable.btn_star_big_off_disable);
                        //
                        handler.sendEmptyMessage(7);
                    }
                    //如果暂未登录
                    else {
                        handler.sendEmptyMessage(8);
                    }
                    break;
                case R.id.imageView_struct_1:
                    viewPager_spe.setCurrentItem(0);
                    break;
                case R.id.imageView_history_1:
                    viewPager_spe.setCurrentItem(1);
                    break;
                case R.id.imageView_position_1:
                    viewPager_spe.setCurrentItem(2);
                    break;

                //点击结构图放大
                case R.id.imageView_instrument_struct:
                    if (mPopupWindow == null || !mPopupWindow.isShowing()) {
                        LayoutInflater mLayoutInflater = (LayoutInflater) Activity_Instrument_1.this
                                .getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupwindwow = mLayoutInflater.inflate(
                                R.layout.image_popwindow, null);
                        imageView_popwindow = (ImageView) popupwindwow.findViewById(R.id.imageView_popwindow);
                        //imageView_popwindow.setImageDrawable(imageView_instrument_struct.getDrawable());
                        //imageView_popwindow.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, (int) imageView_instrument_struct.getTag()));

                        imageLoader.displayImage("drawable://" + (int) imageView_instrument_struct.getTag(), imageView_popwindow);

                        mPopupWindow = new PopupWindow(popupwindwow, Activity_Instrument_1.this.getWindowManager().getDefaultDisplay().getWidth(), Activity_Instrument_1.this.getWindowManager().getDefaultDisplay().getHeight(), true);
                        mPopupWindow.setOutsideTouchable(true);
                        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
                        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                //imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, (int) imageView_popwindow.getTag()));
                            }
                        });
                        mPopupWindow.showAtLocation(findViewById(R.id.imageView_instrument_struct), Gravity.CENTER, 0, 0);
                        //
                        imageView_popwindow.setOnClickListener(new onClickListener());
                    }
                    break;

                //
                case R.id.imageView_popwindow:
                    //点击放大的图片后消失
                    mPopupWindow.dismiss();
                    break;
                //播放按钮
                case R.id.imageView_music_play:
                    state = !state;
                    Log.i("State:", "" + state);
                    if (state) {
                        new playMusic().execute();
                    } else handler.sendEmptyMessage(4);
                    break;
                //下一首按钮
                case R.id.imageView_music_forward:
                    count++;
                    if (mediaPlayer != null) {
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
//                        mediaPlayer.release();
                            mediaPlayer.reset();
                            imageView_music_pic.clearAnimation();
                            imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                        }
                    }
                    //progressDialog.show
                    handler.sendEmptyMessage(0);
//                    new playMusic().execute();
                    break;
                //上一首按钮
                case R.id.imageView_music_backward:
                    count--;
                    if (mediaPlayer != null) {
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
//                        mediaPlayer.release();
                            mediaPlayer.reset();
                            imageView_music_pic.clearAnimation();
                            imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                        }
                    }
                    //progressDialog.show
                    handler.sendEmptyMessage(0);
//                    new playMusic().execute();
                    break;
                //
                case R.id.textView_guide:
                    Intent intent0 = new Intent(Activity_Instrument_1.this, Activity_First_Page.class);
                    startActivity(intent0);
                    //
                    Activity_Instrument_1.this.finish();
                    break;
                //
                case R.id.textView_guide1:
                    Intent intent1 = new Intent(Activity_Instrument_1.this, Activity_Choice.class);
                    startActivity(intent1);
                    break;
                //
                case R.id.textView_guide2:
                    Intent intent2 = new Intent(Activity_Instrument_1.this, Activity_Encyclopedia.class);
                    startActivity(intent2);
                    break;
                //
                case R.id.textView_guide3:
                    Activity_Instrument_1.this.finish();
                    break;
            }
        }
    }

    //
    private class playMusic extends AsyncTask<String, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            //
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer != null) {
                        if (!mediaPlayer.isPlaying() && progressDialog.isShowing()) {
                            cancel = true;
                            progressDialog.dismiss();
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            AlertDialog alertDialog = new AlertDialog.Builder(Activity_Instrument_1.this).setTitle("系统消息").setMessage("网络错误，请重试~").create();
                            alertDialog.show();
                        }
                    }
                }
            }, 8000);
            //mediaPlayer = new MediaPlayer();
        }

        @Override
        protected Boolean doInBackground(String... params) {

            if (count == audio.length) count = 0;
            if (count < 0) count = 3;
            Log.i("Count:", "" + count);
            audio[0] = music_url;
            audio[1] = music_url_1;
            audio[2] = music_url_2;
            audio[3] = music_url_3;

            audio_name[0] = music_name_1;
            audio_name[1] = music_name_2;
            audio_name[2] = music_name_3;
            audio_name[3] = music_name_4;
            try {
                //
                if (mediaPlayer == null) mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDataSource(audio[count]);
                //
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            //
            cancel(cancel);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }

    //
    private class playVideo extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            videoView.setVideoURI(Uri.parse(video_url));
            progressDialog.show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!videoView.isPlaying() && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        cancel(true);
                    }
                }
            }, 10000);
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            return true;
        }
    }
}
