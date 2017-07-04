package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dr.rui.sotired.R;

public class Activity_Test_Position extends Activity {

    private TextView textView_test_position_choice_1;
    private TextView textView_test_position_choice_2;
    private TextView textView_test_position_choice_3;

    private TextView textView_test_position_choice_A;
    private TextView textView_test_position_choice_B;
    private TextView textView_test_position_choice_C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__test__position);

        textView_test_position_choice_1 = (TextView) findViewById(R.id.textView_test_position_choice_1);
        textView_test_position_choice_2 = (TextView) findViewById(R.id.textView_test_position_choice_2);
        textView_test_position_choice_3 = (TextView) findViewById(R.id.textView_test_position_choice_3);

        textView_test_position_choice_A = (TextView) findViewById(R.id.textView_test_position_choice_A);
        textView_test_position_choice_B = (TextView) findViewById(R.id.textView_test_position_choice_B);
        textView_test_position_choice_C = (TextView) findViewById(R.id.textView_test_position_choice_C);
        //
        initTextColor();
        //
        textView_test_position_choice_A.setOnClickListener(new Activity_Test_Position.onClickListener());
        textView_test_position_choice_B.setOnClickListener(new Activity_Test_Position.onClickListener());
        textView_test_position_choice_C.setOnClickListener(new Activity_Test_Position.onClickListener());
        textView_test_position_choice_1.setOnClickListener(new Activity_Test_Position.onClickListener());
        textView_test_position_choice_2.setOnClickListener(new Activity_Test_Position.onClickListener());
        textView_test_position_choice_3.setOnClickListener(new Activity_Test_Position.onClickListener());
    }

    private void initTextColor() {
        textView_test_position_choice_A.setBackgroundResource(R.drawable.unselected);
        textView_test_position_choice_B.setBackgroundResource(R.drawable.unselected);
        textView_test_position_choice_C.setBackgroundResource(R.drawable.unselected);
    }

    //
    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //
            initTextColor();
            switch (v.getId()) {
                case R.id.textView_test_position_choice_A:
                    textView_test_position_choice_A.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_position_choice_B:
                    textView_test_position_choice_B.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_position_choice_C:
                    textView_test_position_choice_C.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_position_choice_1:
                    textView_test_position_choice_A.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_position_choice_2:
                    textView_test_position_choice_B.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_position_choice_3:
                    textView_test_position_choice_C.setBackgroundResource(R.drawable.selected);
                    break;
            }
        }
    }

}
