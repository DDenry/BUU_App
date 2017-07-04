package com.dr.rui.sotired.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dr.rui.sotired.R;

public class Fragment_Test_Result extends Fragment {

    private TextView textView_test_correct_1;
    private TextView textView_test_correct_2;
    private TextView textView_test_correct_3;
    private TextView textView_test_correct_4;
    private TextView textView_test_correct_5;
    private TextView textView_test_correct_6;
    private TextView textView_test_correct_7;
    private TextView textView_test_correct_8;
    private TextView textView_test_correct_9;
    private TextView textView_test_correct_10;

    private TextView textView_test_result_1;
    private TextView textView_test_result_2;
    private TextView textView_test_result_3;
    private TextView textView_test_result_4;
    private TextView textView_test_result_5;
    private TextView textView_test_result_6;
    private TextView textView_test_result_7;
    private TextView textView_test_result_8;
    private TextView textView_test_result_9;
    private TextView textView_test_result_10;


    private int[] correct_answer;
    private int[] chosen_answer;
    private boolean[] state;
    private int number;

    private int row = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_result, container, false);
        //GridLayout gridLayout_corrent = (GridLayout) view.findViewById(R.id.gridLayout_correct);

        correct_answer = getArguments().getIntArray("correct");
        chosen_answer = getArguments().getIntArray("chosen");

        number = correct_answer.length;
        state = new boolean[number];

        //
        /*if (number % 5 == 0) row = number / 5;
        else row = number / 5 + 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < (number - 5 * (i + 1) < 0 ? number % 5 : 5); j++) {
                TextView textView = new TextView(getActivity());
                textView.setText("haha");
                textView.setGravity(Gravity.CENTER);

                GridLayout.Spec rowSpec = GridLayout.spec(i, 1);
                GridLayout.Spec columnSpec = GridLayout.spec(j, 1);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
                gridLayout_corrent.addView(textView, params);
            }
        }*/


        textView_test_correct_1 = (TextView) view.findViewById(R.id.textView_test_correct_1);
        textView_test_correct_2 = (TextView) view.findViewById(R.id.textView_test_correct_2);
        textView_test_correct_3 = (TextView) view.findViewById(R.id.textView_test_correct_3);
        textView_test_correct_4 = (TextView) view.findViewById(R.id.textView_test_correct_4);
        textView_test_correct_5 = (TextView) view.findViewById(R.id.textView_test_correct_5);
        textView_test_correct_6 = (TextView) view.findViewById(R.id.textView_test_correct_6);
        textView_test_correct_7 = (TextView) view.findViewById(R.id.textView_test_correct_7);
        textView_test_correct_8 = (TextView) view.findViewById(R.id.textView_test_correct_8);
        textView_test_correct_9 = (TextView) view.findViewById(R.id.textView_test_correct_9);
        textView_test_correct_10 = (TextView) view.findViewById(R.id.textView_test_correct_10);


        textView_test_correct_1.setText(transAnswer(correct_answer[0]));
        textView_test_correct_2.setText(transAnswer(correct_answer[1]));
        textView_test_correct_3.setText(transAnswer(correct_answer[2]));
        textView_test_correct_4.setText(transAnswer(correct_answer[3]));
        textView_test_correct_5.setText(transAnswer(correct_answer[4]));
        textView_test_correct_6.setText(transAnswer(correct_answer[5]));
        textView_test_correct_7.setText(transAnswer(correct_answer[6]));
        textView_test_correct_8.setText(transAnswer(correct_answer[7]));
        textView_test_correct_9.setText(transAnswer(correct_answer[8]));
        textView_test_correct_10.setText(transAnswer(correct_answer[9]));

        textView_test_result_1 = (TextView) view.findViewById(R.id.textView_test_result_1);
        textView_test_result_2 = (TextView) view.findViewById(R.id.textView_test_result_2);
        textView_test_result_3 = (TextView) view.findViewById(R.id.textView_test_result_3);
        textView_test_result_4 = (TextView) view.findViewById(R.id.textView_test_result_4);
        textView_test_result_5 = (TextView) view.findViewById(R.id.textView_test_result_5);
        textView_test_result_6 = (TextView) view.findViewById(R.id.textView_test_result_6);
        textView_test_result_7 = (TextView) view.findViewById(R.id.textView_test_result_7);
        textView_test_result_8 = (TextView) view.findViewById(R.id.textView_test_result_8);
        textView_test_result_9 = (TextView) view.findViewById(R.id.textView_test_result_9);
        textView_test_result_10 = (TextView) view.findViewById(R.id.textView_test_result_10);

        textView_test_result_1.setText(transAnswer(chosen_answer[0]));
        textView_test_result_2.setText(transAnswer(chosen_answer[1]));
        textView_test_result_3.setText(transAnswer(chosen_answer[2]));
        textView_test_result_4.setText(transAnswer(chosen_answer[3]));
        textView_test_result_5.setText(transAnswer(chosen_answer[4]));
        textView_test_result_6.setText(transAnswer(chosen_answer[5]));
        textView_test_result_7.setText(transAnswer(chosen_answer[6]));
        textView_test_result_8.setText(transAnswer(chosen_answer[7]));
        textView_test_result_9.setText(transAnswer(chosen_answer[8]));
        textView_test_result_10.setText(transAnswer(chosen_answer[9]));

        //
        compareAnswer();
        //
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView_test_result_1.setBackgroundResource(state[0] == true ? R.drawable.selected : R.drawable.unselected);
                textView_test_result_2.setBackgroundResource(state[1] == true ? R.drawable.selected : R.drawable.unselected);
                textView_test_result_3.setBackgroundResource(state[2] == true ? R.drawable.selected : R.drawable.unselected);
                textView_test_result_4.setBackgroundResource(state[3] == true ? R.drawable.selected : R.drawable.unselected);
                textView_test_result_5.setBackgroundResource(state[4] == true ? R.drawable.selected : R.drawable.unselected);
                textView_test_result_6.setBackgroundResource(state[5] == true ? R.drawable.selected : R.drawable.unselected);
                textView_test_result_7.setBackgroundResource(state[6] == true ? R.drawable.selected : R.drawable.unselected);
                textView_test_result_8.setBackgroundResource(state[7] == true ? R.drawable.selected : R.drawable.unselected);
                textView_test_result_9.setBackgroundResource(state[8] == true ? R.drawable.selected : R.drawable.unselected);
                textView_test_result_10.setBackgroundResource(state[9] == true ? R.drawable.selected : R.drawable.unselected);
            }
        });
        return view;
    }

    private String transAnswer(int answer) {
        String str = "未选择";
        if (answer == -1) str = "未选择";
        else if (answer == 0) str = "A";
        else if (answer == 1) str = "B";
        else if (answer == 2) str = "C";
        else if (answer == 3) str = "D";
        return str;
    }

    //
    private void compareAnswer() {
        for (int i = 0; i < number; i++) {
            state[i] = chosen_answer[i] == correct_answer[i];
        }
    }
}
