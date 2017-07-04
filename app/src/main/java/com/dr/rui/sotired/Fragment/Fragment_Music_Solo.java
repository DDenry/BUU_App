package com.dr.rui.sotired.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.rui.sotired.DataBase.QuestionsInfo;
import com.dr.rui.sotired.Entity.Question;
import com.dr.rui.sotired.R;

import java.io.IOException;


public class Fragment_Music_Solo extends Fragment {
    final AnimationSet animationSet = new AnimationSet(true);
    //定义动作，自身旋转359°
    final RotateAnimation rotateAnimation = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f);
    private TextView textView_test_single_question;
    private TextView textView_test_single_choice_1;
    private TextView textView_test_single_choice_2;
    private TextView textView_test_single_choice_3;
    private TextView textView_test_single_choice_A;
    private TextView textView_test_single_choice_B;
    private TextView textView_test_single_choice_C;
    private ImageView imageView_test_single_music;
    private MediaPlayer mediaPlayer;
    private CallBackValue callBackValue;
    private int chosen_answer = -1;
    private int correct_answer = -1;
    private int number;
    private String url;
    private Boolean edit = true;
    private ProgressDialog progressDialog;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callBackValue = (CallBackValue) getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("I'm", " " + number + " Resume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("I'm", " " + number + " Start");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("I'm", " " + number + " Pause");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_solo, container, false);

        Log.i("I'm", " " + number + " CreateView");

        number = getArguments().getInt("number");

        imageView_test_single_music = (ImageView) view.findViewById(R.id.imageView_test_single_music);
        imageView_test_single_music.setOnClickListener(new onClickListener());

        textView_test_single_question = (TextView) view.findViewById(R.id.textView_test_single_question);

        textView_test_single_choice_1 = (TextView) view.findViewById(R.id.textView_test_single_choice_1);
        textView_test_single_choice_2 = (TextView) view.findViewById(R.id.textView_test_single_choice_2);
        textView_test_single_choice_3 = (TextView) view.findViewById(R.id.textView_test_single_choice_3);

        textView_test_single_choice_A = (TextView) view.findViewById(R.id.textView_test_music_choice_A);
        textView_test_single_choice_B = (TextView) view.findViewById(R.id.textView_test_music_choice_B);
        textView_test_single_choice_C = (TextView) view.findViewById(R.id.textView_test_music_choice_C);
        //
        initTextColor();
        //
        textView_test_single_choice_A.setOnClickListener(new onClickListener());
        textView_test_single_choice_B.setOnClickListener(new onClickListener());
        textView_test_single_choice_C.setOnClickListener(new onClickListener());
        textView_test_single_choice_1.setOnClickListener(new onClickListener());
        textView_test_single_choice_2.setOnClickListener(new onClickListener());
        textView_test_single_choice_3.setOnClickListener(new onClickListener());

        //
        init();
        //
        loadQuestion(number);
        //
        callBackValue.SendCorrectAnswer(number, correct_answer);
        return view;
    }

    private void initTextColor() {
        textView_test_single_choice_A.setBackgroundResource(R.drawable.unselected);
        textView_test_single_choice_B.setBackgroundResource(R.drawable.unselected);
        textView_test_single_choice_C.setBackgroundResource(R.drawable.unselected);
    }

    private void init() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("系统消息！");
        progressDialog.setMessage("音乐正在加载……");
        //
        progressDialog.setCancelable(true);

        //
        //
        animationSet.setDuration(50000);
        //平均速率
        animationSet.setInterpolator(new LinearInterpolator());

        animationSet.setFillAfter(true);
        //循环次数（-1代表一直循环）
        rotateAnimation.setRepeatCount(-1);
        //设置动作
        animationSet.addAnimation(rotateAnimation);
    }

    private void loadQuestion(int number) {
        Question question = new QuestionsInfo().loadQuestionInfo(0, number);
        textView_test_single_question.setText("\t\t\t" + (number + 1) + "、" + question.getTitle());
        textView_test_single_choice_1.setText(question.getChoice1());
        textView_test_single_choice_2.setText(question.getChoice2());
        textView_test_single_choice_3.setText(question.getChoice3());
        correct_answer = question.getAnswer();
        url = question.getUrl();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (hidden) {
            imageView_test_single_music.clearAnimation();
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            callBackValue.SendChosenAnswer(number, chosen_answer);
        }
    }

    public interface CallBackValue {
        void SendChosenAnswer(int number, int chosen_answer);

        void SendCorrectAnswer(int number, int correct_answer);
    }

    //
    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //
            initTextColor();
            switch (v.getId()) {
                case R.id.textView_test_music_choice_A:
                    chosen_answer = 0;
                    textView_test_single_choice_A.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_music_choice_B:
                    chosen_answer = 1;
                    textView_test_single_choice_B.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_music_choice_C:
                    chosen_answer = 2;
                    textView_test_single_choice_C.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_single_choice_1:
                    chosen_answer = 0;
                    textView_test_single_choice_A.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_single_choice_2:
                    chosen_answer = 1;
                    textView_test_single_choice_B.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_single_choice_3:
                    chosen_answer = 2;
                    textView_test_single_choice_C.setBackgroundResource(R.drawable.selected);
                    break;
                //
                case R.id.imageView_test_single_music:
                    if (mediaPlayer == null)
                        new playMusic().execute();
                    else {
                        imageView_test_single_music.clearAnimation();

                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    break;
            }
        }
    }

    //
    private class playMusic extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            imageView_test_single_music.setAnimation(animationSet);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.start();
                        progressDialog.dismiss();
                        //
                        imageView_test_single_music.startAnimation(animationSet);
                    }
                });
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        imageView_test_single_music.clearAnimation();
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                        //
                        cancel(true);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}