package com.dr.rui.sotired.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.rui.sotired.DataBase.QuestionsInfo;
import com.dr.rui.sotired.Entity.Question;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

public class Fragment_Instrument_Recognition extends Fragment {

    private TextView textView_test_recognition_choice_1;
    private TextView textView_test_recognition_choice_2;
    private TextView textView_test_recognition_choice_3;
    private TextView textView_test_recognition_choice_4;

    private TextView textView_test_recognition_choice_A;
    private TextView textView_test_recognition_choice_B;
    private TextView textView_test_recognition_choice_C;
    private TextView textView_test_recognition_choice_D;

    private TextView textView_test_recognition_question;

    private ImageView imageView_test_recognition;
    private Fragment_Instrument_Recognition.CallBackValue callBackValue;
    private int chosen_answer = -1;
    private int correct_answer = -1;
    private int number;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callBackValue = (CallBackValue) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instrument_recognition, container, false);
        number = getArguments().getInt("number");

        textView_test_recognition_choice_1 = (TextView) view.findViewById(R.id.textView_test_recognition_choice_1);
        textView_test_recognition_choice_2 = (TextView) view.findViewById(R.id.textView_test_recognition_choice_2);
        textView_test_recognition_choice_3 = (TextView) view.findViewById(R.id.textView_test_recognition_choice_3);
        textView_test_recognition_choice_4 = (TextView) view.findViewById(R.id.textView_test_recognition_choice_4);

        textView_test_recognition_choice_A = (TextView) view.findViewById(R.id.textView_test_recognition_choice_A);
        textView_test_recognition_choice_B = (TextView) view.findViewById(R.id.textView_test_recognition_choice_B);
        textView_test_recognition_choice_C = (TextView) view.findViewById(R.id.textView_test_recognition_choice_C);
        textView_test_recognition_choice_D = (TextView) view.findViewById(R.id.textView_test_recognition_choice_D);

        imageView_test_recognition = (ImageView) view.findViewById(R.id.imageView_test_recognition);
        textView_test_recognition_question = (TextView) view.findViewById(R.id.textView_test_recognition_question);

        textView_test_recognition_choice_1.setOnClickListener(new onClickListener());
        textView_test_recognition_choice_2.setOnClickListener(new onClickListener());
        textView_test_recognition_choice_3.setOnClickListener(new onClickListener());
        textView_test_recognition_choice_4.setOnClickListener(new onClickListener());
        textView_test_recognition_choice_A.setOnClickListener(new onClickListener());
        textView_test_recognition_choice_B.setOnClickListener(new onClickListener());
        textView_test_recognition_choice_C.setOnClickListener(new onClickListener());
        textView_test_recognition_choice_D.setOnClickListener(new onClickListener());

        //
        loadQuestion(number);
        //
        callBackValue.SendCorrectAnswer(number, correct_answer);
        return view;
    }

    //
    private void initTextColor() {
        textView_test_recognition_choice_A.setBackgroundResource(R.drawable.unselected);
        textView_test_recognition_choice_B.setBackgroundResource(R.drawable.unselected);
        textView_test_recognition_choice_C.setBackgroundResource(R.drawable.unselected);
        textView_test_recognition_choice_D.setBackgroundResource(R.drawable.unselected);
    }

    private void loadQuestion(int number) {
        Question question = new QuestionsInfo().loadQuestionInfo(3, number);
        textView_test_recognition_question.setText("\t\t\t" + (number + 1) + "、" + question.getTitle());
        textView_test_recognition_choice_1.setText(question.getChoice1());
        textView_test_recognition_choice_2.setText(question.getChoice2());
        textView_test_recognition_choice_3.setText(question.getChoice3());
        textView_test_recognition_choice_4.setText(question.getChoice4());
        imageView_test_recognition.setImageBitmap(Image.readBitMap(getActivity(), getResources().getIdentifier(question.getDrawableStr(), "drawable", getActivity().getPackageName())));
        correct_answer = question.getAnswer();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        callBackValue.SendChosenAnswer(number, chosen_answer);
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
                case R.id.textView_test_recognition_choice_A:
                    chosen_answer = 0;
                    textView_test_recognition_choice_A.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_recognition_choice_B:
                    chosen_answer = 1;
                    textView_test_recognition_choice_B.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_recognition_choice_C:
                    chosen_answer = 2;
                    textView_test_recognition_choice_C.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_recognition_choice_D:
                    chosen_answer = 3;
                    textView_test_recognition_choice_D.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_recognition_choice_1:
                    chosen_answer = 0;
                    textView_test_recognition_choice_A.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_recognition_choice_2:
                    chosen_answer = 1;
                    textView_test_recognition_choice_B.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_recognition_choice_3:
                    chosen_answer = 2;
                    textView_test_recognition_choice_C.setBackgroundResource(R.drawable.selected);
                    break;
                case R.id.textView_test_recognition_choice_4:
                    chosen_answer = 3;
                    textView_test_recognition_choice_D.setBackgroundResource(R.drawable.selected);
                    break;
            }
        }
    }
}
