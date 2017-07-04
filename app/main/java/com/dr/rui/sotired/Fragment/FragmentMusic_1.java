package com.dr.rui.sotired.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

/**
 * Created by rui on 2015/8/26.
 */
public class FragmentMusic_1 extends Fragment {
    private TextView textView_song_name;
    private ImageButton imageButton_circle_play;
    private ImageButton imageButton_circle_forward;
    private ImageView imageView_animation;
    private Boolean play_signal = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_1, container, false);
        //
        textView_song_name = (TextView) view.findViewById(R.id.textView_song_name);

        imageButton_circle_play = (ImageButton) view.findViewById(R.id.imageButton_circle_play);
        imageButton_circle_forward = (ImageButton) view.findViewById(R.id.imageButton_circle_forward);

        //
        imageView_animation = (ImageView) view.findViewById(R.id.imageView_animation);


        imageButton_circle_play.setOnClickListener(new onClickListener());
        imageButton_circle_play.setOnTouchListener(new onTouchListener());
        return view;
    }

    public class onClickListener implements View.OnClickListener {

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

            switch (v.getId()) {
                case R.id.imageButton_circle_play:
                    //
                    if (!play_signal) {
                        //
                        imageButton_circle_play.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.circle_pause_big));
                        imageButton_circle_play.setAnimation(animationSet);
                        //
                        play_signal = true;
                    }
                    //
                    else {
                        imageView_animation.clearAnimation();
                        imageButton_circle_play.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.circle_play_big));
                        play_signal = false;
                    }
                    break;
                case R.id.imageButton_circle_forward:
                    break;
            }
        }
    }

    public class onTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.imageButton_circle_play:
                    if (event.getAction() == MotionEvent.ACTION_DOWN)
                        imageButton_circle_play.getDrawable().setAlpha(150);
                    else
                        imageButton_circle_play.getDrawable().setAlpha(255);
                    break;
            }
            return false;
        }
    }
}
