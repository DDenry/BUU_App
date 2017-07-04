package com.dr.rui.sotired.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dr.rui.sotired.R;

public class Fragment_Test_Item extends Fragment {

    private View view;
    //test_single
    private TextView textView_test_single_choice_1;
    private TextView textView_test_single_choice_2;
    private TextView textView_test_single_choice_3;

    private int a[] = new int[4];

    public Fragment_Test_Item() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        switch (0) {
            case 0:
                view = inflater.inflate(R.layout.activity_activity_test_single, container, false);
                //
                textView_test_single_choice_1 = (TextView) view.findViewById(R.id.textView_test_single_choice_1);
                textView_test_single_choice_2 = (TextView) view.findViewById(R.id.textView_test_single_choice_2);
                textView_test_single_choice_3 = (TextView) view.findViewById(R.id.textView_test_single_choice_3);

                //
                textView_test_single_choice_1.setOnClickListener(new onClickListener());
                textView_test_single_choice_2.setOnClickListener(new onClickListener());
                textView_test_single_choice_3.setOnClickListener(new onClickListener());
                //
                initTextColor();

                break;
            case 1:
                view = inflater.inflate(R.layout.activity_activity__tan, container, false);
                break;
            case 2:
                view = inflater.inflate(R.layout.activity_activity_la_nation, container, false);
                break;
            case 3:
                view = inflater.inflate(R.layout.activity_activity_blow_occident, container, false);
                break;
            default:
                break;

        }
        return view;
    }

    //


    //
    private void initTextColor() {
        textView_test_single_choice_1.setTextColor(Color.RED);
        textView_test_single_choice_2.setTextColor(Color.RED);
        textView_test_single_choice_3.setTextColor(Color.RED);
    }

    //
    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //
            initTextColor();
            switch (v.getId()) {
                case R.id.textView_test_single_choice_1:
                    textView_test_single_choice_1.setTextColor(Color.GREEN);
                    break;
                case R.id.textView_test_single_choice_2:
                    textView_test_single_choice_2.setTextColor(Color.GREEN);
                    break;
                case R.id.textView_test_single_choice_3:
                    textView_test_single_choice_3.setTextColor(Color.GREEN);
                    break;
            }
        }
    }
}
