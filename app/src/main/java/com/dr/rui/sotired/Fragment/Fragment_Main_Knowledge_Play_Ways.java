package com.dr.rui.sotired.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

public class Fragment_Main_Knowledge_Play_Ways extends Fragment {
    private int type;
    private ImageView imageView;

    /*public Fragment_Main_Knowledge_Play_Ways(int type) {
        this.type = type;
    }*/
    public static Fragment_Main_Knowledge_Play_Ways newInstance(int type) {

        Bundle args = new Bundle();
        args.putInt("type", type);
        Fragment_Main_Knowledge_Play_Ways fragment = new Fragment_Main_Knowledge_Play_Ways();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_knowledge_play_ways, container, false);
        //
        Bundle args = getArguments();
        this.type = args.getInt("type");

        imageView = (ImageView) view.findViewById(R.id.imageView_main_knowledge_play_ways);
        switch (type) {
            //民族吹
            case 0:
                imageView.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.nationalchui));
                break;
            //民族拉
            case 1:
                imageView.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.nationalla));
                break;
            //民族弹
            case 2:
                imageView.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.nationaltan));
                break;
            //民族打
            case 3:
                imageView.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.nationalqiao));
                break;
            //西洋吹
            case 4:
                imageView.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.xiyangchui));
                break;
            //西洋拉
            case 5:
                imageView.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.xiyangla));
                break;
            //西洋弹
            case 6:
                imageView.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.xiyangtan));
                break;
            //西洋打
            case 7:
                imageView.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.xiyangqiao));
                break;
        }
        return view;
    }

}
