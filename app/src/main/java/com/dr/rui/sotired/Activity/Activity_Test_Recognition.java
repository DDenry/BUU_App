package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dr.rui.sotired.Fragment.Fragment_Instrument_Recognition;
import com.dr.rui.sotired.Fragment.Fragment_Test_Result;
import com.dr.rui.sotired.R;

public class Activity_Test_Recognition extends Activity implements Fragment_Instrument_Recognition.CallBackValue {

    private Button button_previous;
    private Button button_next;

    private boolean state = true;
    private int number = 0;
    //题目总数
    private int count = 10;
    private int[] chosen_answer;
    private int[] correct_answer;
    private Fragment[] arr;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__test__recognition);

        button_previous = (Button) findViewById(R.id.button_test_recognition_previous);
        button_next = (Button) findViewById(R.id.button_test_recognition_next);

        button_previous.setOnClickListener(new onClickListener());
        button_next.setOnClickListener(new onClickListener());

        //
        arr = new Fragment[count + 1];
        chosen_answer = new int[count];
        correct_answer = new int[count];
        for (int i = 0; i < count; i++) chosen_answer[i] = -1;

        new loadQuestion().execute();
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

    //
    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_test_recognition_previous:
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
                case R.id.button_test_recognition_next:
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
                        //
                        new loadResultFragment().execute();

                        state = false;
                        button_next.setVisibility(View.GONE);
                        button_previous.setVisibility(View.VISIBLE);
                        button_previous.setText("返回");
                    }
            }
        }
    }

    //
    private class loadResultFragment extends AsyncTask<Void, Void, Boolean> {

        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_Test_Recognition.this).setTitle("系统消息").setMessage("正在计算结果……").create();
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
            fragmentTransaction.add(R.id.linearLayout_recognition_content, arr[count], "Fragment" + count).commit();
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

    //
    private class loadQuestion extends AsyncTask<Void, Void, Boolean> {
        private AlertDialog alertDialog;

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            alertDialog = new AlertDialog.Builder(Activity_Test_Recognition.this).setTitle("系统消息").setMessage("正在加载……").create();
            alertDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            for (int i = 0; i < count; i++) {
                Bundle bundle = new Bundle();
                bundle.putInt("number", i);
                Fragment_Instrument_Recognition fragment_instrument_recognition = new Fragment_Instrument_Recognition();
                fragment_instrument_recognition.setArguments(bundle);
                arr[i] = fragment_instrument_recognition;
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.linearLayout_recognition_content, arr[i], "Fragment" + i).commit();
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
