package com.zain.buu.muco_test.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zain.buu.muco_test.R;
import com.zain.buu.muco_test.entity.Guqin_Key;
import com.zain.buu.muco_test.util.GuqinUtil;
import com.zain.buu.muco_test.view.DrawSelectView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zain on 2016/4/18.
 */
public class GuqinActivity extends Activity {

    private static int bitmapwidth; //小琴键滑动条的bitmap重构图 宽度
    private static float bDX;   //小琴键滑动条 按下
    private static float bUX; //小琴键滑动条 滑动中按下
    private static float bLeft; //小琴键滑动条 左边距 用来重绘bitmap
    private static int BL;  //全部琴键布局的总长度
    private static int BS;  //琴键滑动布局的显示部分的长度 与屏幕分辨率高度部分相关
    private static int SL;  //小琴键背景宽度
    private static int SL_H;    //小琴键背景高度
    private static int SS;  //小琴键滑动条
    private static float keyX;  //琴键滑动位置设置
    private View view;  //View布局
    private LayoutInflater mInflater;   //布局管理器
    private ImageView img;  //琴键图片
    private Guqin_Key guqin_key; //琴键实体
    private Map<Integer, Guqin_Key> guqin_keyHashMap = new HashMap<>();
    private HorizontalScrollView hsv;   //琴键滑动布局显示部分
    private LinearLayout mGallery;  //琴键滑动全部部分的布局文件 包括超出显示屏部分
    //小滑块部分
    private LinearLayout topLeft;   //向左最大按钮
    private LinearLayout topRight;  //向右最大按钮
    private LinearLayout oneLeft;   //向左最大按钮
    private LinearLayout oneRight;  //向右最大按钮
    private DrawSelectView AllSelectImg;    //小琴键滑动条布局文件
    private SoundPool soundPool;    //音乐池
    private HashMap<Integer, Integer> soundMap = new HashMap<>();    //音乐哈希图
    private Bitmap bitmap;  //小琴键滑动条的bitmap重构图
    private int rebuildCont = 0;  //重构bitmap锁 一次

    private Button mainBack; //返回主菜单
    private Intent intent;  //意图器

    //录音部分
    private ImageView luyinButtom;  //录音按钮
    private int luyinFlag = 0;  //录音开关
    private File soundFile; //音乐的文件
    private MediaRecorder mediaRecorder;    //录音控制器
    private EditText fileNameEditText;  //保存文件名文本
    private TextView luyinBegin;    //录音开始文字
    private Chronometer ch; //录音计时器

    private ImageView studyOn;  //学习模式按钮
    private RelativeLayout studyOnTop;  //学习模式头布局
    private int study_flag = 0; //学习模式开关
    private TextView studyText1;    //学习模式简谱1
    private TextView studyText2;    //学习模式简谱2
    private TextView studyText3;    //学习模式简谱3
    private TextView studyText4;    //学习模式简谱4

    private int no = 0; //静态资源锁
    private int[] gImgIds;  //琴键图片集合
    private int[] gImgIds_d;  //琴键图片集合 按下
    private int[] gIds;  //琴键id集合
    private int[] gMusics;  //琴键音乐集合

    /**
     * scroll移动函数，外加滑动条移动
     *
     * @param hscroll
     * @param inner
     * @param flag
     */
    public static void scrollToBottom(final HorizontalScrollView hscroll, final View inner, final String flag) {
        Handler mHandler = new Handler();
        mHandler.post(new Runnable() {
            public void run() {
                //Log.d("zain", "inner.getWidth() ：" + inner.getWidth());
                //Log.d("zain", "hscroll.getWidth() ：" + hscroll.getWidth());
                if (hscroll == null || inner == null) {
                    return;
                }

                switch (flag) {

                    case "end":
                        int offset = inner.getMeasuredWidth() - hscroll.getWidth();
                        if (offset < 0) {
                            offset = 0;
                        }
                        hscroll.smoothScrollTo(offset, 0);
                        bLeft = SL - SS;
                        DrawSelectView.setDLeft(bLeft);
                        break;

                    case "start":
                        hscroll.smoothScrollTo(0, 0);
                        bLeft = 0;
                        DrawSelectView.setDLeft(bLeft);
                        break;

                    case "oneLeft":
                        bLeft = DrawSelectView.getDLeft() - 20;
                        if (bLeft < 0) {
                            bLeft = 0;
                        }
                        DrawSelectView.setDLeft(bLeft);
                        Log.d("zain", "bLeft * BL / SL :" + (int) (bLeft * BL / SL));
                        hscroll.smoothScrollTo((int) (bLeft * BL / SL), 0);
                        break;

                    case "oneRight":
                        bLeft = DrawSelectView.getDLeft() + 20;
                        if (bLeft > SL - SS) {
                            bLeft = SL - SS;
                        }
                        DrawSelectView.setDLeft(bLeft);
                        Log.d("zain", "bLeft * BL / SL :" + (int) (bLeft * BL / SL));
                        hscroll.smoothScrollTo((int) (bLeft * BL / SL), 0);
                        break;

                    default:
                        break;
                }
            }
        });
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setContentView(R.layout.guqin_layout);

        //接收上一个活动传过来的数据
        intent = getIntent();
        String a = intent.getStringExtra("zain");

        //布局加载器
        mInflater = LayoutInflater.from(this);
        initData(); //初始化数据
        initView(); //初始化布局


        //前期单引线程，获取布局的 BL SL BS
        mGallery.post(new Runnable() {
            @Override
            public void run() {
                BL = mGallery.getWidth();
                Log.d("zain", "BL" + BL);
            }
        });
        AllSelectImg.post(new Runnable() {
            @Override
            public void run() {
                SL = AllSelectImg.getWidth();
                SL_H = AllSelectImg.getHeight();
                Log.d("zain", "SL" + SL);
            }
        });
        hsv.post(new Runnable() {
            @Override
            public void run() {
                BS = hsv.getWidth();
                Log.d("zain", "BS" + BS);
            }
        });

        setOnClick();   //设置按键监听


        /**
         *  触摸事件 滑动条部分
         */
        AllSelectImg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View v, MotionEvent event) {
                rebuildBitmap();
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        bDX = event.getX();

                        //计算滚动条部分
                        if (bDX < bitmapwidth / 2) bDX = bitmapwidth / 2;   //左边距限制
                        if (bDX > v.getWidth() - bitmapwidth / 2)   //右边距限制
                            bDX = v.getWidth() - bitmapwidth / 2;
                        bLeft = bDX - bitmapwidth / 2;
                        //重绘小滑块
                        DrawSelectView.setDLeft(bLeft);

                        //计算按键部分
                        keyX = bLeft * BL / SL;
                        hsv.smoothScrollTo((int) keyX, 0);  //滑动琴键位置
                        break;

                    case MotionEvent.ACTION_MOVE:
                        bUX = event.getX();

                        //计算滚动条部分
                        if (bUX < bitmapwidth / 2) bUX = bitmapwidth / 2;    //左边距限制
                        if (bUX > v.getWidth() - bitmapwidth / 2)      //右边距限制
                            bUX = v.getWidth() - bitmapwidth / 2;
                        bLeft += bUX - bDX;
                        DrawSelectView.setDLeft(bLeft); //重绘小滑块
                        Log.d("zain", "bLeft ：" + bLeft);

                        //计算按键部分
                        keyX = bLeft * BL / SL;
                        hsv.smoothScrollTo((int) keyX, 0);  //滑动琴键位置

                        bDX = bUX;
                        break;

                }
                v.invalidate(); //调用重绘
                return true;
            }
        });


    }

    /**
     * bitmap初始化
     */
    private void rebuildBitmap() {

        if (rebuildCont == 1) {
            return;
        }

        //重新构造滑动条的bitmap
        bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getResources(), R.mipmap.all_key_kuang_min),
                SL * BS / BL,
                SL_H,
                true);
        bitmapwidth = bitmap.getWidth();
        //Log.d("zain", "AllSelectImg.getWidth() ：" + AllSelectImg.getWidth());

        //初始化要计算的属性
        SS = bitmapwidth;
        DrawSelectView.setWid(bitmapwidth);
        rebuildCont = 1;
    }

    /**
     * 按钮点击事件
     */
    private void setOnClick() {


        //向右最大按钮点击事件
        topRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rebuildBitmap();
                scrollToBottom(hsv, mGallery, "end");
                AllSelectImg.invalidate();
            }
        });

        //向左最大按钮点击事件
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rebuildBitmap();
                scrollToBottom(hsv, mGallery, "start");
                AllSelectImg.invalidate();
            }
        });

        //向左按钮点击事件
        oneLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rebuildBitmap();
                scrollToBottom(hsv, mGallery, "oneLeft");
                AllSelectImg.invalidate();
            }
        });

        //向右按钮点击事件
        oneRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rebuildBitmap();
                scrollToBottom(hsv, mGallery, "oneRight");
                AllSelectImg.invalidate();
            }
        });

        //回首页
        mainBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rebuildBitmap();
                intent = new Intent(GuqinActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //录音
        luyinButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (luyinFlag == 0) {   //录音开始
                    luyinFlag = 1;
                    v.setBackgroundResource(R.mipmap.muco_piano_top1_stop);
                    luyinBegin.setText("正在录音...");
                    luyinBegin.setTextColor(Color.RED);
                    //设置开始计时时间
                    ch.setBase(SystemClock.elapsedRealtime());
                    //启动计时器
                    ch.start();

                    if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        Toast.makeText(GuqinActivity.this, "SD卡不存在，请插入SD卡！", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    try {
                        //创建保存录音的音频文件
                        soundFile = new File(Environment.getExternalStorageDirectory().getCanonicalFile() + "/muco.amr");
                        mediaRecorder = new MediaRecorder();
                        //设置录音的声音来源
                        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        //设置录制的声音的输出格式（必须在设置声音编码格式之前设置）
                        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        //设置声音编码格式
                        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        //设置录音位置
                        mediaRecorder.setOutputFile(soundFile.getAbsolutePath());
                        Log.d("zain", "位置：" + soundFile.getAbsolutePath());
                        //准备录音
                        mediaRecorder.prepare();
                        //开始录音
                        mediaRecorder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {    //录音停止
                    v.setBackgroundResource(R.mipmap.muco_piano_top1_go);
                    luyinFlag = 0;

                    if (soundFile != null && soundFile.exists()) {
                        mediaRecorder.stop();
                        mediaRecorder.release();
                        mediaRecorder = null;
                    } else {
                        Toast.makeText(GuqinActivity.this, "录音状态管理的stop状态出错了，不是音频为空就是不存在", Toast.LENGTH_SHORT).show();
                    }
                    luyinBegin.setText("");
                    ch.stop();
                    ch.setText("00:00");

                    createAlert();
                }
            }
        });
    }

    /**
     * 创建存储对话框
     */
    private void createAlert() {
        //创建存储对话框
        view = getLayoutInflater().inflate(R.layout.luyin_layout, null);
        fileNameEditText = (EditText) view.findViewById(R.id.file_name);
        new AlertDialog.Builder(GuqinActivity.this)
                .setTitle("存储录音")    //设置标题
                .setView(view) //设置对话框显示
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Log.d("zain", "fileNameEditText.getText().toString()：" + fileNameEditText.getText().toString());
                        //创建存储音频的文件夹
                        File file1 = null;
                        try {
                            file1 = new File(Environment.getExternalStorageDirectory().getCanonicalFile() + "/muco_sound");
                            if (!file1.exists()) {    //防止目录不存在
                                file1.mkdirs();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //创建文件路径
                        File file = new File(file1 + "/" + fileNameEditText.getText().toString() + ".amr");
                        //修改文件名字
                        soundFile.renameTo(file);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除文件
                        soundFile.delete();
                    }
                })
                .setCancelable(false)
                .create().show();
    }

    /**
     * 初始化数据
     */
    private void initData() {

        //音乐池配置
        soundPool = new SoundPool(7, AudioManager.STREAM_SYSTEM, 5);

        if (no != 1) { //防止静态资源加载重复

            gImgIds = GuqinUtil.initGImgIds(); //图片
            gImgIds_d = GuqinUtil.initGImgIds_d(); //图片
            gIds = GuqinUtil.initGIds(); //id
            gMusics = GuqinUtil.initGMusics(); //音乐
        }

        for (int i = 0; i < gIds.length; i++) { //添加白键map
            guqin_key = new Guqin_Key(gIds[i], gImgIds[i], gImgIds_d[i], gMusics[i]);
            guqin_keyHashMap.put(guqin_key.getId(), guqin_key);
        }

        for (Guqin_Key guqin_key1 : guqin_keyHashMap.values()) {
            soundMap.put(guqin_key1.getId(), soundPool.load(getBaseContext(), guqin_key1.getSound(), 1));
        }

    }


    /**
     * 初始化view
     */
    private void initView() {

        //小滑块滑动
        AllSelectImg = (DrawSelectView) findViewById(R.id.key_guqin_all_select_img);    //小滑块组件
        topLeft = (LinearLayout) findViewById(R.id.topLeft);    //向左最大按钮
        topRight = (LinearLayout) findViewById(R.id.topRight);  //向右最大按钮
        oneLeft = (LinearLayout) findViewById(R.id.oneLeft);    //向左按钮
        oneRight = (LinearLayout) findViewById(R.id.oneRight);  //向右按钮

        //琴键
        hsv = (HorizontalScrollView) findViewById(R.id.myhsv1); //琴键滑动布局显示部分
        mGallery = (LinearLayout) findViewById(R.id.id_gallery_guqin); //琴键滑动全部部分的布局文件 包括超出显示屏部分


        //录音
        luyinButtom = (ImageView) findViewById(R.id.luyin_buttom);  //录音按钮
        luyinBegin = (TextView) findViewById(R.id.luyin_flag);  //录音开始提示
        ch = (Chronometer) findViewById(R.id.ch);   //计时器显示控件

        //其他
        mainBack = (Button) findViewById(R.id.main_back); //返回首页按钮

        studyOn = (ImageView) findViewById(R.id.study_on);  //学习模式按钮
        studyOnTop = (RelativeLayout) findViewById(R.id.study_on_top);  //学习模式头布局


        /**
         * 琴键布局加载：
         *
         * 循环7次
         */
        for (Guqin_Key g : guqin_keyHashMap.values()) {
            view = mInflater.inflate(R.layout.guqin_key_item_layout, mGallery, false); //获取布局加载器
            img = (ImageView) view.findViewById(R.id.guqin_item_img);  //获取每一个图片组件

            img.setBackgroundResource(g.getImg()); //设置每一个图片组件 背景
            view.setId(g.getId());
            setOnTouchImg(view); //设置每一个图片组件 触碰事件
            mGallery.addView(view); //将布局添加到mGallery布局中
        }


    }


    /**
     * 触摸事件 钢琴按键部分
     */
    private void setOnTouchImg(View v) {

        v.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(final View v, MotionEvent event) {
                int action = event.getAction();
                rebuildBitmap();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        TouchSwitch(v, "down"); //按下时
                        break;

                    case MotionEvent.ACTION_MOVE:
                        break;

                    case MotionEvent.ACTION_UP:
                        TouchSwitch(v, "up");   //抬起时
                        break;
                }

                return true;
            }
        });
    }


    /**
     * 触摸事件 钢琴键
     *
     * @param view
     */
    public void TouchSwitch(View view, String state) {

        int id = view.getId();
        switch (state) {

            //按下事件
            case "down":

                soundPool.play(soundMap.get(guqin_keyHashMap.get(id).getId()), 1, 1, 0, 0, 1);  //播放按键音频
                view.findViewById(id).setBackgroundResource(guqin_keyHashMap.get(id).getImg_d());

                break;

            //抬起事件
            case "up":
                view.setBackground(null);
                break;
        }
    }


}
