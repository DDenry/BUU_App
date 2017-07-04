package com.dr.rui.sotired.Fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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
import android.widget.TextView;

import com.dr.rui.sotired.Activity.Activity_Instrument;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util.CircleProgress;
import com.dr.rui.sotired.Util_Image.Image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rui on 2015/9/6.
 */
public class FragmentMusic_2 extends Fragment {
    public static MediaPlayer mediaPlayer = null;
    private static boolean flag = false;
    String url_1 = "";
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private List<View> view_list = new ArrayList<>();
    private TextView textView_single;
    private TextView textView_tutti;
    private TextView textView_music_single;
    private ProgressDialog progressDialog;
    //
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //
            switch (msg.what) {
                //
                case 0:
                    //
                    progressDialog.dismiss();
                    break;
            }
        }
    };
    //
    private ImageButton imageButton_play_music;
    private CircleProgress circleProgress;
    private ImageView imageView_vinyl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_2, container, false);
        //
        textView_single = (TextView) view.findViewById(R.id.textView_single);
        textView_single.setOnClickListener(new onClickListener());
        textView_tutti = (TextView) view.findViewById(R.id.textView_tutti);
        textView_tutti.setOnClickListener(new onClickListener());

        //
        View view_single = inflater.inflate(R.layout.fragment_music_single, container, false);
        imageButton_play_music = (ImageButton) view_single.findViewById(R.id.imageButton_play_music);
        imageButton_play_music.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.circle_play_big));
        imageButton_play_music.setOnClickListener(new onClickListener());

        imageView_vinyl = (ImageView) view_single.findViewById(R.id.imageView_vinyl);
        imageView_vinyl.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.vinyl_record_disc));
        circleProgress = (CircleProgress) view_single.findViewById(R.id.circleProgress);

        textView_music_single = (TextView) view_single.findViewById(R.id.textView_music_single);

        View view_tutti = inflater.inflate(R.layout.fragment_music_tutti, container, false);

        view_list.add(view_single);
        view_list.add(view_tutti);


        //
        if (Activity_Instrument.Signal == 0) {
            int position_blow = Activity_Instrument.position;
            int position_1 = Activity_Instrument.position_1;
            //民族乐器
            if (position_1 == 0) {
                switch (position_blow) {
                    //箫
                    case 0:
                        url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/箫_独奏.mp3";
                        textView_music_single.setText("\t\t\t\t\t箫的音色柔和，典雅，低音区发音深沉，弱奏时很有特色。中音区音色圆润、优美；高音区发音紧张。");
                        break;
                    //笙
                    case 1:
                        url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_sheng.mp3";
                        textView_music_single.setText("\t\t\t\t\t笙的音色明亮甜美，高音清脆透明，中音柔和丰满，低音浑厚低沉，音量较大。而且在中国传统吹管乐器中，也是唯一能够吹出和声的乐器。");
                        break;
                    //埙
                    case 2:

                        break;
                }
            }
            //西洋乐器
            else {
                //
                switch (position_blow) {
                    //短笛
                    case 0:
                        url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_duandi.mp3";
                        textView_music_single.setText("");
                        break;
                    //长笛
                    case 1:
                        textView_music_single.setText("");
                        url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_changdi.mp3";
                        break;
                }

            }
        }


        //viewPager
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_music);
        //
        viewPager.setCurrentItem(0);
        textView_single.setTextColor(Color.BLUE);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        textView_single.setTextColor(Color.BLUE);
                        textView_tutti.setTextColor(Color.WHITE);
                        break;
                    case 1:
                        textView_single.setTextColor(Color.WHITE);
                        textView_tutti.setTextColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //pagerAdapter
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return view_list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view1 = view_list.get(position);
                container.addView(view1);
                return view1;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(view_list.get(position));
            }
        };
        viewPager.setAdapter(pagerAdapter);
        return view;
    }

    public class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                //
                case R.id.textView_single:
                    textView_single.setTextColor(Color.BLUE);
                    textView_tutti.setTextColor(Color.WHITE);
                    viewPager.setCurrentItem(0);
                    break;
                //
                case R.id.textView_tutti:
                    textView_single.setTextColor(Color.WHITE);
                    textView_tutti.setTextColor(Color.BLUE);
                    viewPager.setCurrentItem(1);
                    break;

                //
                case R.id.imageButton_play_music:
                    //
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

                    circleProgress.setType(CircleProgress.ARC);
                    //
                    if (flag == false) {
                        //
                        if (mediaPlayer == null) {
                            //
                            mediaPlayer = new MediaPlayer();
                            //
                            progressDialog = new ProgressDialog(getActivity()).show(getActivity(), "系统消息", "音乐正在加载……", false, false);
                            //
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        //
                                        mediaPlayer.setDataSource(url_1);
                                        //
                                        mediaPlayer.prepare();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();//

                            //
                            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mp) {
                                    //音乐播放
                                    mp.start();
                                    //绑定旋转动作
                                    imageView_vinyl.setAnimation(animationSet);
                                    //
                                    imageButton_play_music.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.circle_pause_big));
                                    //
                                    AsyncTask asyncTask = new AsyncTask<Integer, Integer, Integer>() {

                                        @Override
                                        protected Integer doInBackground(Integer... params) {
                                            //
                                            for (int i = 0; i <= 100; i += 2) {
                                                publishProgress(i);
                                                try {
                                                    Thread.sleep(500);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            return null;
                                        }

                                        @Override
                                        protected void onProgressUpdate(Integer... values) {
                                            super.onProgressUpdate(values);
                                            circleProgress.setmSubCurProgress(values[0]);
                                        }

                                        @Override
                                        protected void onPostExecute(Integer integer) {
                                            circleProgress.setmSubCurProgress(0);
                                            //
                                            imageView_vinyl.clearAnimation();
                                            //
                                            if (getActivity() != null) {
                                                Log.i("getActivity:", "" + getActivity().toString());
                                                if (getActivity().toString().contains("Activity_Instrument"))
                                                    imageButton_play_music.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.circle_play_big));
                                            }
                                            if (mediaPlayer != null) {
                                                mediaPlayer.release();
                                                mediaPlayer = null;
                                            }
                                            flag = false;
                                            super.onPostExecute(integer);
                                        }
                                    }.execute(0);

                                    //
                                    handler.sendEmptyMessage(0);

                                }
                            });
                            //
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if (mediaPlayer != null) {
                                        //
                                        //
                                        if (!mediaPlayer.isPlaying()) {
                                            //
                                            progressDialog.dismiss();
                                            //
                                            new AlertDialog.Builder(getActivity()).setTitle("系统消息").setMessage("网络异常，请稍后再试！").show();
                                            //
                                            mediaPlayer.release();
                                            //
                                            mediaPlayer = null;
                                        }
                                    }
                                }
                            }, 6000);

                            //
                            mediaPlayer
                                    .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            //
                                            mediaPlayer.release();
                                            //
                                            mediaPlayer = null;
                                        }
                                    });
                        }
                        //
                        flag = true;

                        //asyncTask.execute(0);

                    } else {
                        //
                        flag = false;
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }
                        circleProgress.setmSubCurProgress(0);
                        //
                        imageView_vinyl.clearAnimation();
                        imageButton_play_music.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.circle_play_big));
                    }

                    break;
            }
        }
    }
}

