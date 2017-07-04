package com.dr.rui.sotired.Fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dr.rui.sotired.Activity.Activity_Test_Special;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

public class Fragment_Main_SelfCheck extends Fragment {

    private ImageView imageView_main_selfCheck_zhuanxiang;
    private ImageView imageView_main_selfCheck_zonghe;

    public static Fragment_Main_SelfCheck newInstance() {
        Fragment_Main_SelfCheck fragment = new Fragment_Main_SelfCheck();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_self_check, container, false);
        imageView_main_selfCheck_zhuanxiang = (ImageView) view.findViewById(R.id.imageView_main_selfCheck_zhuanxiang);
        imageView_main_selfCheck_zhuanxiang.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.zhuanxianglianxi));
        imageView_main_selfCheck_zonghe = (ImageView) view.findViewById(R.id.imageView_main_selfCheck_zonghe);
        imageView_main_selfCheck_zonghe.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.zongheceshi));
        imageView_main_selfCheck_zhuanxiang.setOnClickListener(new onClickListener());
        imageView_main_selfCheck_zonghe.setOnClickListener(new onClickListener());
        return view;
    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.imageView_main_selfCheck_zhuanxiang:
                    intent = new Intent(getActivity(), Activity_Test_Special.class);
                    break;
                case R.id.imageView_main_selfCheck_zonghe:
                    intent = new Intent(getActivity(), Activity_Test_Special.class);
                    break;
            }
            //
            startActivity(intent);
        }
    }
}
