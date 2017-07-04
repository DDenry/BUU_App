package com.dr.rui.sotired.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

public class Fragment_Test_Instrument extends Fragment {

    private ImageView imageView_test_chui;
    private ImageView imageView_test_la;
    private ImageView imageView_test_tan;
    private ImageView imageView_test_da;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment_test_music = inflater.inflate(R.layout.fragment_fragment__test__music, container, false);
        imageView_test_chui = (ImageView) fragment_test_music.findViewById(R.id.imageView_test_chui);
        imageView_test_la = (ImageView) fragment_test_music.findViewById(R.id.imageView_test_la);
        imageView_test_tan = (ImageView) fragment_test_music.findViewById(R.id.imageView_test_tan);
        imageView_test_da = (ImageView) fragment_test_music.findViewById(R.id.imageView_test_da);

        imageView_test_chui.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_blowing_n));
        imageView_test_la.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_pullstring_n));
        imageView_test_tan.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_plucked_n));
        imageView_test_da.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_percussion_n));

        imageView_test_chui.setOnTouchListener(new onTouchListener());
        imageView_test_la.setOnTouchListener(new onTouchListener());
        imageView_test_tan.setOnTouchListener(new onTouchListener());
        imageView_test_da.setOnTouchListener(new onTouchListener());

        imageView_test_chui.setOnClickListener(new onClickListener());
        imageView_test_la.setOnClickListener(new onClickListener());
        imageView_test_tan.setOnClickListener(new onClickListener());
        imageView_test_da.setOnClickListener(new onClickListener());
        return fragment_test_music;
    }

    private class onTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.imageView_test_chui:
                    if (event.getAction() == MotionEvent.ACTION_DOWN)
                        imageView_test_chui.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_blowing_h));
                    else
                        imageView_test_chui.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_blowing_n));
                    break;
                case R.id.imageView_test_la:
                    if (event.getAction() == MotionEvent.ACTION_DOWN)
                        imageView_test_la.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_pullstring_h));
                    else
                        imageView_test_la.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_pullstring_n));
                    break;
                case R.id.imageView_test_tan:
                    if (event.getAction() == MotionEvent.ACTION_DOWN)
                        imageView_test_tan.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_plucked_h));
                    else
                        imageView_test_tan.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_plucked_n));
                    break;
                case R.id.imageView_test_da:
                    if (event.getAction() == MotionEvent.ACTION_DOWN)
                        imageView_test_da.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_percussion_h));
                    else
                        imageView_test_da.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.icon_percussion_n));
                    break;
            }
            return false;
        }
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.i("Click:", "Enter");
            switch (v.getId()) {
                case R.id.imageView_test_chui:
                    break;
                case R.id.imageView_test_la:
                    break;
                case R.id.imageView_test_tan:
                    break;
                case R.id.imageView_test_da:
                    break;
            }
        }
    }
}
