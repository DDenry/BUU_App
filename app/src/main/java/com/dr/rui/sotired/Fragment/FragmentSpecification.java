package com.dr.rui.sotired.Fragment;

import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

/**
 * Created by rui on 2015/5/16.
 */
public class FragmentSpecification extends Fragment {

    private ImageButton imageButton_structure;
    private ImageButton imageButton_history;
    private ImageButton imageButton_position;

    private ImageView imageView_structure;
    private View popWindow;
    private PopupWindow mPopupWindow;
    private WindowManager.LayoutParams lp;

    private ImageView imageView_title;
    private ImageView imageView_pop;
    private TextView textView_pop;
    private ScrollView scrollView_pop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spe, container, false);
        lp = getActivity().getWindow().getAttributes();
        //
        initPopupWindow();
        //
        //
        imageButton_structure = (ImageButton) view.findViewById(R.id.imageButton_structure);
        imageButton_history = (ImageButton) view.findViewById(R.id.imageButton_history);
        imageButton_position = (ImageButton) view.findViewById(R.id.imageButton_position);

        //
        imageButton_structure.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.structure));
        imageButton_history.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.history1));
        imageButton_position.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.position1));

        imageButton_structure.setOnClickListener(new buttonOnClickListener());
        imageButton_history.setOnClickListener(new buttonOnClickListener());
        imageButton_position.setOnClickListener(new buttonOnClickListener());
        return view;
    }

    public void initPopupWindow() {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        //
        popWindow = LayoutInflater.from(getActivity()).inflate(R.layout.pop_up_window, null);
        imageView_title = (ImageView) popWindow.findViewById(R.id.imageView_title);
        imageView_pop = (ImageView) popWindow.findViewById(R.id.imageView_pop);
        scrollView_pop = (ScrollView) popWindow.findViewById(R.id.scrollView_pop);
        textView_pop = (TextView) popWindow.findViewById(R.id.textView_pop);
        //
        mPopupWindow = new PopupWindow(popWindow, dm.widthPixels - 80, 3 * dm.heightPixels / 4, true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new PaintDrawable());
        mPopupWindow.setOnDismissListener(new popUpWindowOnDismissListener());
    }

    public class buttonOnClickListener implements View.OnClickListener

    {

        @Override
        public void onClick(View v) {
            lp.alpha = 0.5f;
            getActivity().getWindow().setAttributes(lp);
            mPopupWindow.showAtLocation(imageButton_structure, Gravity.CENTER, 0, 0);
            scrollView_pop.setVisibility(View.VISIBLE);
            imageView_pop.setVisibility(View.VISIBLE);
            switch (v.getId()) {
                //
                case R.id.imageButton_structure:
                    imageView_title.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.structure));
                    imageView_pop.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.struct));
                    textView_pop.setText("\t箫由一根竹管做成，较曲笛长，上端留有竹节，下端和管内去节中空，吹口开在上端边沿，由此处吹气发音。在箫管中部，正面开有五个音孔，背面开有一个音孔。\n");
                    break;
                //
                case R.id.imageButton_history:
                    imageView_pop.setVisibility(View.GONE);
                    imageView_title.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.history1));
                    textView_pop.setText("历史：\n\t\t\t箫的产生，其历史可以追根溯源到远古时期。中国考古学表明，目前出土文物中发现了有距今七千多年的骨质发生器，考古学家称之为“骨哨”。箫曾在中国音乐史上经历过多年的辉煌时代。周代，曾将我国古代乐器分为“八音”，它们分别是金，石，丝，竹，匏，土，革，木八类乐器，其中“竹”就是指箫和箎。竹就是排箫的前身。");
                    break;
                case R.id.imageButton_position:
                    imageView_title.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.position1));
                    imageView_pop.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.position));
                    scrollView_pop.setVisibility(View.GONE);
                    break;
            }
        }
    }

    public class popUpWindowOnDismissListener implements PopupWindow.OnDismissListener {

        @Override
        public void onDismiss() {
            lp.alpha = 1.0f;
            getActivity().getWindow().setAttributes(lp);
        }
    }
}
