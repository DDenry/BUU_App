package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dr.rui.sotired.R;

public class Activity_Test_Tutti extends Activity {

    private TextView textView_test_tutti_choice_1;
    private TextView textView_test_tutti_choice_2;
    private TextView textView_test_tutti_choice_3;
    private TextView textView_test_tutti_choice_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__test__tutti);
        //
        textView_test_tutti_choice_1 = (TextView) findViewById(R.id.textView_test_tutti_choice_1);
        textView_test_tutti_choice_2 = (TextView) findViewById(R.id.textView_test_tutti_choice_2);
        textView_test_tutti_choice_3 = (TextView) findViewById(R.id.textView_test_tutti_choice_3);
        textView_test_tutti_choice_4 = (TextView) findViewById(R.id.textView_test_tutti_choice_4);
        //
        initTextColor();
        //
        textView_test_tutti_choice_1.setOnClickListener(new onClickListener());
        textView_test_tutti_choice_2.setOnClickListener(new onClickListener());
        textView_test_tutti_choice_3.setOnClickListener(new onClickListener());
        textView_test_tutti_choice_4.setOnClickListener(new onClickListener());
    }

    //
    private void initTextColor() {
        textView_test_tutti_choice_1.setTextColor(Color.RED);
        textView_test_tutti_choice_2.setTextColor(Color.RED);
        textView_test_tutti_choice_3.setTextColor(Color.RED);
        textView_test_tutti_choice_3.setTextColor(Color.RED);
    }

    //
    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.textView_test_tutti_choice_1:
                    textView_test_tutti_choice_1.setTextColor(textView_test_tutti_choice_1.getCurrentTextColor() == Color.RED ? Color.GREEN : Color.RED);
                    break;
                case R.id.textView_test_tutti_choice_2:
                    textView_test_tutti_choice_2.setTextColor(textView_test_tutti_choice_2.getCurrentTextColor() == Color.RED ? Color.GREEN : Color.RED);
                    break;
                case R.id.textView_test_tutti_choice_3:
                    textView_test_tutti_choice_3.setTextColor(textView_test_tutti_choice_3.getCurrentTextColor() == Color.RED ? Color.GREEN : Color.RED);
                    break;
                case R.id.textView_test_tutti_choice_4:
                    textView_test_tutti_choice_4.setTextColor(textView_test_tutti_choice_4.getCurrentTextColor() == Color.RED ? Color.GREEN : Color.RED);
                    break;
            }
        }
    }
}
