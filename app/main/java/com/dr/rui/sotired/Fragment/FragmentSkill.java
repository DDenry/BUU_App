package com.dr.rui.sotired.Fragment;

import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.dr.rui.sotired.Activity.Activity_Instrument;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util.BackGround;
import com.dr.rui.sotired.Util_Image.Image;

import java.io.File;
import java.io.IOException;

import static android.media.MediaPlayer.*;

/**
 * Created by rui on 2015/5/16.
 */
public class FragmentSkill extends Fragment implements SurfaceHolder.Callback {
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private SlidingDrawer slidingDrawer;
    private ImageView imageView_drawer;
    private TextView textView_promote;
    public static MediaPlayer mediaPlayer;
    //public static ImageView imageView_play;
    private TextView textView_skill;
    private ScrollView scrollView;
    private String uri;

    //
    public static VideoView videoView;

    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_skill, container, false);
        //view.setBackgroundResource(R.drawable.blue_bc);
        //
        //uri = "";
        //textView_promote = (TextView) view.findViewById(R.id.textView_promote);
        /*scrollView = (ScrollView) view.findViewById(R.id.scrollView);
        //文字背景
        scrollView.setBackgroundResource(R.drawable.gray);
        textView_skill = (TextView) view.findViewById(R.id.textView_skill);
        textView_skill.setText("\t\t\t\t箫的演奏姿势有站式和坐式两种，演奏时一定要保持身体的自然状态。\n（一）站式\n\t\t\t\t独奏或重奏时一般采用站式。两臂自然向前，两手持箫，手指自然弯曲，胸部和腰部要直，但不能挺胸鼓肚，头部向前但不能前倾更不能后仰。双肩和双肘自然下垂，切忌耸肩。箫放在嘴上时与身体约成45度角，因为角度太小了容易低头，太大了又容易扬颈，这样不但姿势不雅，也影响呼吸。两腿站定，两脚稍稍分开，身体重心落于两腿之间。\n（二）坐式\n\t\t\t\t合奏或伴奏时一般采用坐式。坐式上半身和站式完全相同。座椅高低要合适，切忌一条腿架在另一条腿上，这样不但姿势不雅，同时也影响正常呼吸。吹箫姿势是最符合人体生理结构特点的，因此持箫最基本的原则就是要保持人体自然状态，便能很快掌握正确的演奏姿势。");
        slidingDrawer = (SlidingDrawer) view.findViewById(R.id.slidingDrawer);
        slidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                textView_promote.setVisibility(View.INVISIBLE);
                imageView_drawer.setImageResource(R.drawable.down);
            }
        });
        slidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                textView_promote.setVisibility(View.VISIBLE);
                imageView_drawer.setImageResource(R.drawable.up);
            }
        });
        imageView_drawer = (ImageView) view.findViewById(R.id.imageView_drawer);
        imageView_drawer.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.up));
*/
        //
        if (Activity_Instrument.Signal == 0) {
            int position_blow = Activity_Instrument.position;
            int position_1 = Activity_Instrument.position_1;
            //民族乐器
            if (position_1 == 0) {
                switch (position_blow) {
                    //箫
                    case 0:
                        uri = "http://7xkqzu.com1.z0.glb.clouddn.com/myvideo.mp4";
                        break;
                    //笙
                    case 1:
                        uri = "http://7xkqzu.com1.z0.glb.clouddn.com/video_sheng.mp4";
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
                        uri = "http://7xkqzu.com1.z0.glb.clouddn.com/video_duandi.mp4";
                        break;
                    //长笛
                    case 1:
                        uri = "http://7xkqzu.com1.z0.glb.clouddn.com/video_changdi.mp4";
                        break;
                }

            }
        }


        //VideoView播放视频
        videoView = (VideoView) view.findViewById(R.id.videoView);
        videoView.setVideoPath(uri);

        //视频图片
        videoView.setBackgroundResource(R.drawable.xiao_video);

        MediaController mediaControlerOBJ = new MediaController(getActivity());
        mediaControlerOBJ.setAnchorView(videoView);
        videoView.setMediaController(mediaControlerOBJ);
        videoView.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("INFORMATION", "Prepared!");
                handler.post(runnable);
            }
        });
        videoView.setOnTouchListener(new onTouchListener());
        //


        videoView.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //
                videoView.getBackground().setAlpha(255);
                textView_promote.setText("单击窗体以播放视频");
                handler.removeCallbacks(runnable);
            }
        });
        //videoView.start();
        //imageView_play = (ImageView) view.findViewById(R.id.imageView_play);
        //imageView_play.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.circle_play));

        //
        /*surfaceView = (SurfaceView) view.findViewById(R.id.surfaceView);
        //surfaceView.setBackgroundResource(R.drawable.xiao);

        surfaceView.setOnTouchListener(new onTouchListener());
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(320, 220);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);*/
        //
        runnable = new Runnable() {
            @Override
            public void run() {
                //
                if (videoView != null) {
                    if (videoView.isPlaying()) {
                        textView_promote.setText("正在播放");
                    } else textView_promote.setText("单击窗体以播放视频");
                }
                handler.postDelayed(runnable, 500);
            }
        };
        return view;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDisplay(surfaceHolder);
                try {
                    mediaPlayer.setDataSource("http://7xkqzu.com1.z0.glb.clouddn.com/《绿野仙踪》%20陈悦%20洞箫演奏.mp4");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp = null;
                        //imageView_play.setVisibility(View.VISIBLE);
                    }
                });
            }
        }
        ).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public class onTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                /*case R.id.surfaceView:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        if (mediaPlayer.isPlaying()) {
                            //暂停
                            mediaPlayer.pause();

                            //imageView_play.setVisibility(View.VISIBLE);

                            Toast.makeText(getActivity(), "视频暂停", Toast.LENGTH_SHORT).show();
                        } else {
                            //播放
                            mediaPlayer.start();
                            //当视频播放时设置surfaceView背景透明
                            surfaceView.getBackground().setAlpha(0);

                            //imageView_play.setVisibility(View.INVISIBLE);

                            Toast.makeText(getActivity(), "视频播放", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;*/
                case R.id.videoView:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        //判断视频是否正在播放
                        if (videoView.isPlaying()) {
                            Log.i("INFORMATION", "isPlaying");
                        } else {
                            videoView.start();
                            videoView.getBackground().setAlpha(0);

                            //
                            RelativeLayout.LayoutParams layoutParams =
                                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                            videoView.setLayoutParams(layoutParams);
                        }


                        break;
                    }
            }
            return false;
        }
    }

}
