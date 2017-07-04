package com.zain.buu.muco_test.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zain.buu.muco_test.R;
import com.zain.buu.muco_test.entity.Music;
import com.zain.buu.muco_test.entity.Piano_Key;
import com.zain.buu.muco_test.util.PianoUtil;
import com.zain.buu.muco_test.util.WavUtil;
import com.zain.buu.muco_test.view.DrawSelectView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Zain on 2016/3/25.
 * <p>
 * 钢琴页
 */
public class PianoActivity extends Activity {

    private static ArrayList<Piano_Key> wPiano_keys = new ArrayList<>();    //白 琴键 实体集合
    private static ArrayList<Piano_Key> bPiano_keys = new ArrayList<>();    //黑 琴键 实体集合
    private static HashMap<Integer, Piano_Key> piano_keyHashMap = new HashMap<>();   //所有琴键图片哈希图
    private static int no = 0;  //琴键静态类加载判断标志位
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
    private static byte[] buffer = null;  //缓存器
    private static String[] texts = new String[]{ //学习模式琴键列表
            "0", "C4", "D4", "E4", "F4", "G4", "A4", "B4"
            //0   1      2       3      4      5      6       7
    };
    private static List<Music> musics = new ArrayList<>();
    private static int[] textsId = new int[]{ //学习模式简谱列表
            1, 1, 5, 5, 6, 6, 5,
            4, 4, 3, 3, 2, 2, 1,
            5, 5, 4, 4, 3, 3, 2,
            5, 5, 4, 4, 3, 3, 2,
            1, 1, 5, 5, 6, 6, 5,
            4, 4, 3, 3, 2, 2, 1,
            0, 0, 0, 0
    };
    private final String FILE_NAME = "/k1.wav"; //设置合成后文件名字
    private View view;  //View布局
    private LayoutInflater mInflater;   //布局管理器
    //琴键的布局加载部分
    private ImageView img;  //琴键图片
    private TextView text;  //白 琴键-文字布局
    private int[] mImgIds;  //白 琴键图片集合
    private int[] bImgIds;  //黑 琴键图片集合
    private int[] wIds; //白键 id集合
    private int[] bIds; //黑键 id集合
    private int[] txtIds;   //白 琴键-文字id集合
    private int[] mImgIds_d;  //白 琴键图片-按下集合
    private int[] bImgIds_d;  //黑 琴键图片-按下集合
    private int[] wMusics; //白 琴键音乐集合
    private int[] bMusics; //黑 琴键音乐集合
    private String[] txt;   //白 琴键文字集合
    private Piano_Key piano_key; //琴键实体
    private HorizontalScrollView hsv;   //琴键滑动布局显示部分
    private LinearLayout mGallery;  //琴键滑动全部部分的布局文件 包括超出显示屏部分
    private LinearLayout bGallery;  //黑键
    //小滑块部分
    private LinearLayout topLeft;   //向左最大按钮
    private LinearLayout topRight;  //向右最大按钮
    private LinearLayout oneLeft;   //向左最大按钮
    private LinearLayout oneRight;  //向右最大按钮
    private DrawSelectView AllSelectImg;    //小琴键滑动条布局文件
    private SoundPool soundPool;    //音乐池
    private HashMap<Integer, Integer> soundMap = new HashMap<>();    //音乐哈希图
    private Bitmap bitmap;  //小琴键滑动条的bitmap重构图
    private float udX;  //琴键 按下
    private float udXm; //琴键 滑动中按下
    private int rebuildCont = 0;  //重构bitmap锁 一次
    private Button mainBack; //返回主菜单
    private Intent intent;  //意图器
    private int[] wavHead;  //存储wav文件44位头数据
    private int[] wavHead08;    //从下个地址开始到文件尾的总字节数 07 06 05 04
    private int[] wavHead44;    //DATA总数据长度字节 43 42 41 40
    private int[] wavHead08All; //合成后头文件8
    private int[] wavHead44All; //合成后头文件44
    private AudioTrack audioTrack;  //音乐采样器
    private FileInputStream fis = null; //文件输入流
    private int pcmlen = 0;   //pcm部分长度
    //录音部分
    private ImageView luyinButtom;  //录音按钮
    private int luyinFlag = 0;  //录音开关
    private File soundFile; //音乐的文件
    private MediaRecorder mediaRecorder;    //录音控制器
    private EditText fileNameEditText;  //保存文件名文本
    private TextView luyinBegin;    //录音开始文字
    private Chronometer ch; //录音计时器
    private ProgressBar progressBar;    //缓冲进度条
    private RelativeLayout loading; //缓存界面
    private ImageView studyOn;  //学习模式按钮
    private RelativeLayout studyOnTop;  //学习模式头布局
    private int study_flag = 0; //学习模式开关
    private TextView studyText1;    //学习模式简谱1
    private TextView studyText2;    //学习模式简谱2
    private TextView studyText3;    //学习模式简谱3
    private TextView studyText4;    //学习模式简谱4
    private Music music;    //简谱实体
    private int t = 0;  //简谱计数器
    private int c;  //按键实体寄存器
    private int c_e;    //临时按钮实体寄存器
    /**
     * 多线程处理函数
     */
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x111) {    //加载完毕部分
                progressBar.setVisibility(View.GONE);   //隐藏加载进度条
                loading.setVisibility(View.GONE); //隐藏加载界面
            } else if (msg.what == 0x112) { //第一次开启学习模式部分


                //初始化简谱
                studyText1.setText(String.valueOf(textsId[t]));
                studyText2.setText(String.valueOf(textsId[t + 1]));
                studyText3.setText(String.valueOf(textsId[t + 2]));
                studyText4.setText(String.valueOf(textsId[t + 3]));

                //找到简谱1键位
                for (Piano_Key pianoKey : piano_keyHashMap.values()) {
                    if (pianoKey.getTxt().equals(musics.get(textsId[t]).getKey())) {
                        c = pianoKey.getId();   //记录简谱1键位实体
                        final Piano_Key p = pianoKey;
                        //滑动至学习按键位置
                        hsv.post(new Runnable() {
                            @Override
                            public void run() {
                                while (BL == 0 || SL == 0) {    //等待页面加载
                                }
                                Log.e("zain", "学习模式开启完毕");
                                hsv.smoothScrollTo(p.getCount() * 100, 0);
                                bLeft = p.getCount() * 100 * SL / BL;
                                DrawSelectView.setDLeft(bLeft);
                                AllSelectImg.invalidate();
                            }
                        });

                        break;
                    }
                }

                //设置简谱1按键实体的背景
                ImageView imageView = (ImageView) findViewById(c);
                imageView.setBackgroundResource(R.drawable.w_s);

            } else if (msg.what == 0x113) { //按键中-学习模式
                if (c == c_e) {  //判断当前按下键是否与学习键位一致
                    t++;    //切换简谱

                    //改变简谱，0时不显示该位简谱
                    if (textsId[t + 1] != 0) {
                        studyText2.setText(String.valueOf(textsId[t + 1]));
                    } else {
                        studyText2.setText("");
                    }

                    if (textsId[t + 2] != 0) {
                        studyText3.setText(String.valueOf(textsId[t + 2]));
                    } else {
                        studyText3.setText("");
                    }

                    if (textsId[t + 3] != 0) {
                        studyText4.setText(String.valueOf(textsId[t + 3]));
                    } else {
                        studyText4.setText("");
                    }

                    if (textsId[t] != 0) {
                        studyText1.setText(String.valueOf(textsId[t]));

                        //找到简谱1键位
                        for (Piano_Key pianoKey : piano_keyHashMap.values()) {
                            if (pianoKey.getTxt().equals(musics.get(textsId[t]).getKey())) {
                                c = pianoKey.getId();//记录简谱1键位实体
                                break;
                            }
                        }
                        //设置简谱1按键实体的背景
                        ImageView imageView = (ImageView) findViewById(c);
                        imageView.setBackgroundResource(R.drawable.w_s);

                    } else {    //学习模式完毕
                        studyText1.setText("");
                        studyEnd(); //关闭学习模式
                    }

                } else {
                    Log.e("zain", "0x113出错了或者弹错了");
                }
            }
        }
    };

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

    /**
     * wav音乐合成函数
     *
     * @param id
     */
    void readRawFile(int[] id) {

        wavHead = new int[44];
        wavHead44 = new int[4];
        wavHead08 = new int[4];

        Resources resources = this.getResources();
        InputStream is = null;
        RandomAccessFile raf = null;

        wavHead08All = new int[4];
        wavHead44All = new int[4];

        int line;
        int head;
        byte buffer[];

        Log.d("zain", "开始合成楼~");

        try {
            //---------    开始循环    --------//
            //循环要合成的音乐
            for (int d = 0; d < id.length; d++) {
                head = 0;   //head指针置0
                is = resources.openRawResource(id[d]);  //获取要合成音频的字节输入流

                /*
                 * 1 head部分 获取wav 44位 头数据 0~43
                 */
                for (head = 0; head < 44; head++) {
                    wavHead[head] = is.read();

                    //a 获取 第5~8位数据 07 06 05 04 表示WAV文件从下个地址开始到文件尾的总字节数
                    if (head >= 4 && head <= 7) {
                        wavHead08[head - 4] = wavHead[head];
                    }

                    //b 获取 第41~44位数据 43 42 41 40 表示WAV文件长度
                    if (head >= 40) {
                        wavHead44[head - 40] = wavHead[head];
                    }
                }

                //获取第一个数据的数据头 需要改变的位置
                if (d == 0) {
                    wavHead44All = wavHead44;
                    wavHead08All = wavHead08;
                } else {
                    //叠加 数据头 要改变的数据
                    wavHead44All = WavUtil.AddWavHeadDataLength(wavHead44All, wavHead44);
                    wavHead08All = WavUtil.AddWavHeadDataLength(wavHead08All, wavHead44);
                }

                /*
                 * 2 data部分 获取所有数据
                 */
                buffer = new byte[is.available()]; //数据部分的有效数据，开缓存区
                is.read(buffer);    //读取data部分数据

                while ((line = is.read()) != -1) {
                    Log.e("zain", "又没到末尾？ " + line);
                }
                //每次关闭输入流
                is.close();

                /*
                 * 3 开始写入每次合成数据到文件
                 */

                //写入SD卡的新wav文件
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    //获取SD卡对应的存储目录
                    File sdCardDir = Environment.getExternalStorageDirectory();
                    //获取文件位置
                    final File targetFile = new File(sdCardDir.getCanonicalPath() + FILE_NAME);
                    //如果文件不存在新建一个文件
                    if (!targetFile.exists()) {
                        targetFile.createNewFile();
                    }
                    //开启输入流
                    raf = new RandomAccessFile(targetFile, "rw");
                    //移动文件指针到最后
                    raf.seek(targetFile.length());
                    //开始写入
                    if (d == 0) raf.write(WavUtil.intToBytes(wavHead));    //在最开始写入一个头文件
                    raf.write(buffer);

                    //移动指针到头文件位置
                    raf.seek(4);
                    raf.write(WavUtil.intToBytes(wavHead08All));
                    raf.seek(40);
                    raf.write(WavUtil.intToBytes(wavHead44All));

                    raf.close();
                }

                Log.d("zain", "第" + d + "次合成完毕");

            }
            //---------    循环结束    --------//

            Log.d("zain", "终于合成完了。。。~");

        } catch (IOException e) {
            Log.e("zain", "write file", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.e("zain", "close file", e);
                }
            }
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    Log.e("zain", "close file", e);
                }
            }

        }
    }

    /**
     * 生命周期：重启
     */
    protected void onResume() {
        super.onResume();


        loading.setVisibility(View.VISIBLE);    //显示加载界面

        //起一个线程，与UI线程分开，加载音频用的
        new Thread(new Runnable() {

            @Override
            public void run() {

                Log.d("zain", "T start");
                for (Piano_Key pianoKey : wPiano_keys) {
                    soundMap.put(pianoKey.getId(), soundPool.load(getBaseContext(), pianoKey.getSound(), 1));
                }
                for (Piano_Key pianoKey : bPiano_keys) {
                    soundMap.put(pianoKey.getId(), soundPool.load(getBaseContext(), pianoKey.getSound(), 1));
                }
                Log.d("zain", "T over");
                handler.sendEmptyMessage(0x111);    //发送加载完信息

            }
        }).start();

    }

    /**
     * 学习模式关闭函数
     */
    private void studyEnd() {
        Log.d("zain", "学习结束");
        study_flag = 0;
        studyOn.setBackgroundResource(R.mipmap.study_on);
        studyOnTop.setVisibility(View.GONE);
        c = 0;
        t = 0;
    }

    /**
     * 学习模式开启函数
     */
    private void studyStart() {
        Log.d("zain", "开启学习模式");
        study_flag = 1; //设置开关
        studyOn.setBackgroundResource(R.mipmap.study_stop);
        studyOnTop.setVisibility(View.VISIBLE);
        t = 0;
        handler.sendEmptyMessage(0x112);    //发送开启请求

    }

    /**
     * 生命周期：毁灭
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        studyEnd(); //关闭学习模式
    }

    /**
     * 读取wav音乐并播放（播放失败，需要写底层）
     *
     * @return
     */
    private String read() {

        int f = 0;
        int[] s = new int[44];

        try {
            //获取SD卡对应的存储目录
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                //获取SD卡对应的存储目录
                File sdCardDir = Environment.getExternalStorageDirectory();
                //获取指定文件对应的输入流
                fis = new FileInputStream(sdCardDir.getCanonicalPath() + FILE_NAME);
                //fis.skip(0x2c);

//                for(f=0;f<s.length;f++) {
//                    s[f] = fis.read();
//                    Log.d("zain","s["+f+"]："+s[f]);
//                }

                //Log.d("zain","fis.available()" + fis.available());
                //audioBytes = new byte[fis.available()];
                //mLen = (short) fis.read(audioBytes);

                //System.out.println("write pcm data");
                //audioTrack.write(audioBytes, 0, audioBytes.length);


                buffer = new byte[1024 * 1024 * 2];
                int len = fis.read(buffer);
                pcmlen = 0;
                pcmlen += buffer[0x2b];
                pcmlen = pcmlen * 256 + buffer[0x2a];
                pcmlen = pcmlen * 256 + buffer[0x29];
                pcmlen = pcmlen * 256 + buffer[0x28];

                int channel = buffer[0x17];
                channel = channel * 256 + buffer[0x16];

                //initAudioPlayer();

                audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
                        channel,
                        AudioFormat.ENCODING_PCM_16BIT,
                        pcmlen,
                        AudioTrack.MODE_STATIC);

                audioTrack.write(buffer, 0x2C, pcmlen);//往track中写数据
                audioTrack.play();

                audioTrack.stop();

                return null;
            }


        } catch (Exception e) {
            Log.e("zain", "read" + e);
            return null;
        } finally {

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return null;
    }

    /**
     * 生命周期：创建
     *
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setContentView(R.layout.piano_layout);

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

        //学习模式判断
        if (intent.getStringExtra("zain").equals("study")) {
            studyStart();   //开启学习模式
        }


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
     * 触摸事件 钢琴按键部分
     */
    private void setOnTouchImg(ImageView img) {

        img.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(final View v, MotionEvent event) {
                int action = event.getAction();
                rebuildBitmap();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        udX = event.getX();
                        TouchSwitch(v, "down"); //按下时
                        break;

                    case MotionEvent.ACTION_MOVE:
                        udXm = event.getX();
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
     * 按钮点击事件
     */
    private void setOnClick() {

        //学习模式按钮点击事件
        studyOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (study_flag == 0) {
                    studyStart();   //开启学习模式
                } else {
                    ImageView imageView = (ImageView) findViewById(c);
                    imageView.setBackgroundResource(piano_keyHashMap.get(c).getImg());
                    studyEnd(); //关闭学习模式
                }

            }
        });


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
                intent = new Intent(PianoActivity.this, MainActivity.class);
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
                        Toast.makeText(PianoActivity.this, "SD卡不存在，请插入SD卡！", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(PianoActivity.this, "录音状态管理的stop状态出错了，不是音频为空就是不存在", Toast.LENGTH_SHORT).show();
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
        new AlertDialog.Builder(PianoActivity.this)
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
        soundPool = new SoundPool(88, AudioManager.STREAM_SYSTEM, 5);

        if (no != 1) { //防止静态资源加载重复

            mImgIds = PianoUtil.initWImgIds(); //白键图片
            bImgIds = PianoUtil.initBImgIds(); //黑键图片
            wIds = PianoUtil.initWIds(); //白键id
            bIds = PianoUtil.initBIds(); //黑键id
            txtIds = PianoUtil.initTxtIds();    //白键-文字id
            wMusics = PianoUtil.initWMusic(); //白键音乐
            bMusics = PianoUtil.initBMusic(); //黑键音乐
            mImgIds_d = PianoUtil.initWImgIds_d(); //白键图片-按下
            bImgIds_d = PianoUtil.initBImgIds_d(); //白键图片-按下
            txt = PianoUtil.initTxt();  //白键文字

            for (int i = 0; i < texts.length; i++) {  //初始化简谱实体
                music = new Music(i, texts[i]);
                musics.add(music);
            }


            for (int i = 0; i < wIds.length; i++) { //添加白键map
                piano_key = new Piano_Key(wIds[i], mImgIds[i], wMusics[i], mImgIds_d[i], txtIds[i], txt[i], i);
                wPiano_keys.add(piano_key);
                piano_keyHashMap.put(piano_key.getId(), piano_key);
            }

            for (int i = 0; i < bIds.length; i++) { //添加黑键map
                piano_key = new Piano_Key(bIds[i], bImgIds[i], bMusics[i], bImgIds_d[i], 0, "", i);
                bPiano_keys.add(piano_key);
                piano_keyHashMap.put(piano_key.getId(), piano_key);
            }
        }
        no = 1;
    }


    /**
     * 初始化view
     */
    private void initView() {

        //小滑块滑动
        AllSelectImg = (DrawSelectView) findViewById(R.id.key_piano_all_select_img);    //小滑块组件
        topLeft = (LinearLayout) findViewById(R.id.topLeft);    //向左最大按钮
        topRight = (LinearLayout) findViewById(R.id.topRight);  //向右最大按钮
        oneLeft = (LinearLayout) findViewById(R.id.oneLeft);    //向左按钮
        oneRight = (LinearLayout) findViewById(R.id.oneRight);  //向右按钮

        //琴键
        hsv = (HorizontalScrollView) findViewById(R.id.myhsv1); //琴键滑动布局显示部分
        mGallery = (LinearLayout) findViewById(R.id.id_gallery); //琴键滑动全部部分的布局文件 包括超出显示屏部分
        bGallery = (LinearLayout) findViewById(R.id.id_gallery_black); //黑键

        //录音
        luyinButtom = (ImageView) findViewById(R.id.luyin_buttom);  //录音按钮
        luyinBegin = (TextView) findViewById(R.id.luyin_flag);  //录音开始提示
        ch = (Chronometer) findViewById(R.id.ch);   //计时器显示控件

        //其他
        mainBack = (Button) findViewById(R.id.main_back); //返回首页按钮
        progressBar = (ProgressBar) findViewById(R.id.myProGressBar);   //缓存页面
        loading = (RelativeLayout) findViewById(R.id.loading);  //缓存进度条

        studyOn = (ImageView) findViewById(R.id.study_on);  //学习模式按钮
        studyOnTop = (RelativeLayout) findViewById(R.id.study_on_top);  //学习模式头布局
        studyText1 = (TextView) findViewById(R.id.study_text1); //学习模式简谱1
        studyText2 = (TextView) findViewById(R.id.study_text2); //学习模式简谱2
        studyText3 = (TextView) findViewById(R.id.study_text3); //学习模式简谱3
        studyText4 = (TextView) findViewById(R.id.study_text4); //学习模式简谱4


        /**
         * 白键布局加载：
         *
         * 循环52次
         */
        for (Piano_Key pianoKey : wPiano_keys) {
            view = mInflater.inflate(R.layout.piano_key_item_layout, mGallery, false); //获取布局加载器
            img = (ImageView) view.findViewById(R.id.img_key);  //获取每一个图片组件
            text = (TextView) view.findViewById(R.id.txt_key);  //获取每一个文字组件
            text.setText(pianoKey.getTxt());    //设置每一个文字组件
            text.setId(pianoKey.getTId());  //设置每一个文字组件 id
            img.setBackgroundResource(pianoKey.getImg()); //设置每一个图片组件 背景
            img.setId(pianoKey.getId());  //设置每一个图片组件 id
            setOnTouchImg(img); //设置每一个图片组件 触碰事件
            mGallery.addView(view); //将布局添加到mGallery布局中
        }


        /**
         * 黑键布局加载：
         *
         * 循环52次 36个键
         */
        for (int i = 0, j = 0; i < 51; i++) {
            Piano_Key pianoKey;

            if (((i - 4) % 7 != 0) && ((i - 1) % 7 != 0)) {

                if (j >= bPiano_keys.size()) {
                    Log.e("zain", "黑键数量超过界限了");
                    continue;
                }
                pianoKey = bPiano_keys.get(j);  //获取黑键实体
                j++;
            } else {
                view = mInflater.inflate(R.layout.piano_key_item_black_layout, bGallery, false); //获取布局加载器
                img = (ImageView) view.findViewById(R.id.black_item_img);  //获取每一个图片组件
                img.setBackground(null); //设置背景为空
                bGallery.addView(view); //将布局添加到mGallery布局中
                continue; //此处无黑键，跳过
            }

            view = mInflater.inflate(R.layout.piano_key_item_black_layout, bGallery, false); //获取布局加载器
            img = (ImageView) view.findViewById(R.id.black_item_img);  //获取每一个图片组件
            img.setBackgroundResource(pianoKey.getImg()); //设置每一个图片组件 背景
            img.setId(pianoKey.getId());  //设置每一个图片组件 id
            setOnTouchImg(img); //设置每一个图片组件 触碰事件
            bGallery.addView(view); //将布局添加到mGallery布局中

        }
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
                view.setBackgroundResource(piano_keyHashMap.get(id).getImg_d());    //改变按键图片
                soundPool.play(soundMap.get(piano_keyHashMap.get(id).getId()), 1, 1, 0, 0, 1);  //播放按键音频
                //Log.d("zain", "id：" + piano_keyHashMap.get(id).getId()); //测试用
                Log.d("zain", "id：" + piano_keyHashMap.get(id).getCount());

                break;

            //抬起事件
            case "up":
                view.setBackgroundResource(piano_keyHashMap.get(id).getImg());  //改变按键图片
                if (study_flag == 1) {  //是否开启学习模式判断
                    c_e = piano_keyHashMap.get(id).getId(); //获取当前键位
                    handler.sendEmptyMessage(0x113);
                }
                break;
        }
    }

}
