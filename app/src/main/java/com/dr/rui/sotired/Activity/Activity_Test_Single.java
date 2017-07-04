package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dr.rui.sotired.Fragment.Fragment_Music_Solo;
import com.dr.rui.sotired.Fragment.Fragment_Test_Result;
import com.dr.rui.sotired.R;


public class Activity_Test_Single extends Activity implements Fragment_Music_Solo.CallBackValue {
    private Button button_previous;
    private Button button_next;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment[] arr;

    private boolean state = true;
    private int number = 0;
    private int count = 10;
    private int[] chosen_answer;
    private int[] correct_answer;

    private TextView textView_test_type;
    private TextView textView_test_guide;
    private TextView textView_test_guide1;
    private TextView textView_test_guide2;
    private TextView textView_test_guide3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_test_single);
        //
        init();

        arr = new Fragment[count + 1];
        chosen_answer = new int[count];
        correct_answer = new int[count];
        for (int i = 0; i < count; i++) chosen_answer[i] = -1;
        //
        new loadQuestion().execute();
    }

    private void init() {
        textView_test_type = (TextView) findViewById(R.id.textView_test_type);
        textView_test_guide = (TextView) findViewById(R.id.textView_test_guide);
        textView_test_guide1 = (TextView) findViewById(R.id.textView_test_guide1);
        textView_test_guide2 = (TextView) findViewById(R.id.textView_test_guide2);
        textView_test_guide3 = (TextView) findViewById(R.id.textView_test_guide3);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/msyhbd.ttc");
        textView_test_guide.setTypeface(typeFace);
        textView_test_guide1.setTypeface(typeFace);
        textView_test_guide2.setTypeface(typeFace);
        textView_test_guide3.setTypeface(typeFace);

        textView_test_guide.setText("\t\t首页");
        textView_test_guide1.setText(">自我评测");
        textView_test_guide2.setText(">专项练习(题型分类)");
        textView_test_guide3.setText(">耳聪目慧");

        textView_test_guide.setOnClickListener(new onClickListener());
        textView_test_guide1.setOnClickListener(new onClickListener());
        textView_test_guide2.setOnClickListener(new onClickListener());
        textView_test_guide3.setOnClickListener(new onClickListener());

        button_previous = (Button) findViewById(R.id.button_test_solo_previous);
        button_previous.setOnClickListener(new onClickListener());
        button_next = (Button) findViewById(R.id.button_test_solo_next);
        button_next.setOnClickListener(new onClickListener());
    }

    //接收Fragment的回调,保存所选答案
    @Override
    public void SendChosenAnswer(int number, int chosen_answer) {
        if (chosen_answer != -1)
            this.chosen_answer[number] = chosen_answer;
    }

    //保存所有问题正确答案
    @Override
    public void SendCorrectAnswer(int number, int correct_answer) {
        this.correct_answer[number] = correct_answer;
    }

    private void hideFragment() {
        for (int i = 0; i < count; i++) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(arr[i]).commit();
        }
    }

    private class onClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_test_solo_previous:
                    if (number > 0) {
                        //
                        hideFragment();
                        number--;
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.show(arr[number]).commit();

                        if (number == 0) button_previous.setVisibility(View.GONE);
                        if (number == count - 2) button_next.setText("下一题");
                        if (number == count - 1) {
                            button_next.setVisibility(View.VISIBLE);
                            button_previous.setText("上一题");
                            button_next.setText("下一题");
                            //
                            number = 0;
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.show(arr[number]).commit();
                            button_previous.setVisibility(View.GONE);
                        }
                    }
                    break;
                case R.id.button_test_solo_next:
                    number++;
                    //
                    hideFragment();
                    if (number < count) {
                        if (number == 1) button_previous.setVisibility(View.VISIBLE);
                        if (number == count - 1) {
                            //首次提交
                            if (state)
                                button_next.setText("提交");
                            else
                                button_next.setText("查看提交结果");
                        }
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.show(arr[number]).commit();
                    }
                    if (number == count) {
                        new loadResultFragment().execute();
                        state = false;
                        button_next.setVisibility(View.GONE);
                        button_previous.setVisibility(View.VISIBLE);
                        button_previous.setText("返回");
                    }
                    break;

                //
                case R.id.textView_test_guide:
                    Intent intent = new Intent(Activity_Test_Single.this, Activity_First_Page.class);
                    startActivity(intent);
                    break;
                case R.id.textView_test_guide1:
                    Intent intent1 = new Intent(Activity_Test_Single.this, Activity_Test_Choice.class);
                    startActivity(intent1);
                    break;
                case R.id.textView_test_guide2:
                    Activity_Test_Single.this.finish();
                    break;

            }
        }
    }

    private class loadResultFragment extends AsyncTask<Void, Void, Boolean> {

        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_Test_Single.this).setTitle("系统消息").setMessage("正在计算结果……").create();
            alertDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            //
            Bundle bundle = new Bundle();
            bundle.putIntArray("correct", correct_answer);
            bundle.putIntArray("chosen", chosen_answer);
            Fragment_Test_Result fragment_test_result = new Fragment_Test_Result();
            fragment_test_result.setArguments(bundle);
            arr[count] = fragment_test_result;
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.linearLayout_test_solo, arr[count], "Fragment" + count).commit();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            hideFragment();
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(arr[count]).commit();

            alertDialog.dismiss();
        }
    }

    private class loadQuestion extends AsyncTask<Void, Void, Boolean> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_Test_Single.this).setTitle("系统消息").setMessage("正在加载……").create();
            alertDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            for (int i = 0; i < count; i++) {
                Bundle bundle = new Bundle();
                bundle.putInt("number", i);
                Fragment_Music_Solo fragment_music_solo = new Fragment_Music_Solo();
                fragment_music_solo.setArguments(bundle);
                arr[i] = fragment_music_solo;
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.linearLayout_test_solo, arr[i], "Fragment" + i).commit();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            alertDialog.dismiss();
            hideFragment();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(arr[0]).commit();
        }
    }
}
