package com.dr.rui.sotired.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

public class Fragment_Music_Tutti extends Fragment {

    private ImageView imageView_test_music_tutti_choice_1;
    private ImageView imageView_test_music_tutti_choice_2;
    private ImageView imageView_test_music_tutti_choice_3;
    private ImageView imageView_test_music_tutti_choice_4;

    private TextView textView_test_music_tutti_question_id;
    private TextView textView_test_music_tutti_question;

    private boolean[] state = new boolean[4];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_tutti, container, false);
        textView_test_music_tutti_question_id = (TextView) view.findViewById(R.id.textView_test_music_tutti_question_id);
        textView_test_music_tutti_question = (TextView) view.findViewById(R.id.textView_test_music_tutti_question);

        imageView_test_music_tutti_choice_1 = (ImageView) view.findViewById(R.id.imageView_test_music_tutti_choice_1);
        imageView_test_music_tutti_choice_2 = (ImageView) view.findViewById(R.id.imageView_test_music_tutti_choice_2);
        imageView_test_music_tutti_choice_3 = (ImageView) view.findViewById(R.id.imageView_test_music_tutti_choice_3);
        imageView_test_music_tutti_choice_4 = (ImageView) view.findViewById(R.id.imageView_test_music_tutti_choice_4);
        //
        init();
        initArrState();
        String id = getArguments().getString("id");
        String question = getArguments().getString("question");
        int[] answer = getArguments().getIntArray("answer");

        return view;
    }

    private void init() {
        imageView_test_music_tutti_choice_1.setOnClickListener(new onClickListener());
        imageView_test_music_tutti_choice_2.setOnClickListener(new onClickListener());
        imageView_test_music_tutti_choice_3.setOnClickListener(new onClickListener());
        imageView_test_music_tutti_choice_4.setOnClickListener(new onClickListener());
    }

    private void initArrState() {
        for (int i = 0; i < 4; i++) {
            state[i] = false;
        }
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageView_test_music_tutti_choice_1:
                    state[0] = !state[0];
                    if (state[0])
                        imageView_test_music_tutti_choice_1.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.ic_btn_search));
                    else
                        imageView_test_music_tutti_choice_1.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.app_icon));
                    break;
                case R.id.imageView_test_music_tutti_choice_2:
                    state[1] = !state[1];
                    if (state[1])
                        imageView_test_music_tutti_choice_2.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.ic_btn_search));
                    else
                        imageView_test_music_tutti_choice_2.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.app_icon));
                    break;
                case R.id.imageView_test_music_tutti_choice_3:
                    state[2] = !state[2];
                    if (state[2])
                        imageView_test_music_tutti_choice_3.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.ic_btn_search));
                    else
                        imageView_test_music_tutti_choice_3.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.app_icon));
                    break;
                case R.id.imageView_test_music_tutti_choice_4:
                    state[3] = !state[3];
                    if (state[3])
                        imageView_test_music_tutti_choice_4.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.ic_btn_search));
                    else
                        imageView_test_music_tutti_choice_4.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.app_icon));
                    break;
            }
        }
    }
}
