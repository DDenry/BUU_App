package com.dr.rui.sotired.Fragment;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.rui.sotired.Activity.Activity_Instrument;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rui on 2015/8/11.
 */
public class FragmentSpecification_1 extends Fragment {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private List<View> view_list = new ArrayList<>();

    private TextView textView_struct;
    private TextView textView_history;
    private TextView textView_position;

    //spe_struct
    private ImageView imageView_title_struct;
    private ImageView imageView_spe_struct;
    private TextView textView_spe_struct;

    //spe_history
    private ImageView imageView_title_history;
    private TextView textView_spe_history;

    //spe_position
    private ImageView imageView_title_position;
    private ImageView imageView_spe_position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spe_1, container, false);
        //
        textView_struct = (TextView) view.findViewById(R.id.textView_struct_1);
        textView_history = (TextView) view.findViewById(R.id.textView_history_1);
        textView_position = (TextView) view.findViewById(R.id.textView_position_1);

        textView_struct.setOnTouchListener(new onTouchListener());
        textView_history.setOnTouchListener(new onTouchListener());
        textView_position.setOnTouchListener(new onTouchListener());

        //
        View spe_struct = inflater.inflate(R.layout.spe_struct, container, false);
        //

        //
        imageView_title_struct = (ImageView) spe_struct.findViewById(R.id.imageView_title_struct);
        imageView_title_struct.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.structure));
        //
        imageView_spe_struct = (ImageView) spe_struct.findViewById(R.id.imageView_spe_struct);

        //
        textView_spe_struct = (TextView) spe_struct.findViewById(R.id.textView_spe_struct);
        //
        View spe_history = inflater.inflate(R.layout.spe_history, container, false);
        //
        imageView_title_history = (ImageView) spe_history.findViewById(R.id.imageView_title_history);
        imageView_title_history.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.history1));
        //
        textView_spe_history = (TextView) spe_history.findViewById(R.id.textView_spe_history);

        //
        View spe_position = inflater.inflate(R.layout.spe_position, container, false);
        //
        imageView_title_position = (ImageView) spe_position.findViewById(R.id.imageView_title_position);
        imageView_title_position.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.position1));

        //
        imageView_spe_position = (ImageView) spe_position.findViewById(R.id.imageView_spe_position);
//
        //
        if (Activity_Instrument.Signal == 0) {
            Log.i("INFORMATION:", "Signal=0");
            int position_blow = Activity_Instrument.position;
            int position_1 = Activity_Instrument.position_1;

            Log.i("INFORMATION:", "" + position_blow);
            //民族乐器
            if (position_1 == 0) {
                switch (position_blow) {
                    //箫
                    case 0:
                        imageView_spe_struct.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.struct_xiao));
                        textView_spe_struct.setText("\t\t\t\t\t箫一般由竹子制成，吹孔在上端，较曲笛长，按“音孔”数量区分为六孔箫和八孔箫，八孔箫为现代改进的产物。全长70～78厘米，管身内径1.2～1.4厘米。六孔箫管中部正面开有5个音孔，背面有1个音孔，用以控制音的高低，起着美化音色增大音量的作用。\n" +
                                "    箫的定调不一，常见的为G调，还有F调、C调等。6个音孔全闭时，筒音为(d1)，通过超吹，音域由(d1～e3)，有两个八度另一个大二度。");
                        imageView_spe_position.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.position_xiao));
                        textView_spe_history.setText("\t\t\t\t\t箫的产生，其历史可以追根溯源到远古时期。中国考古学表明，目前出土文物中发现了有距今七千多年的骨质发生器，考古学家称之为“骨哨”。箫曾在中国音乐史上经历过多年的辉煌时代。周代，曾将我国古代乐器分为“八音”，它们分别是金，石，丝，竹，匏，土，革，木八类乐器，其中“竹”就是指箫和箎。竹就是排箫的前身。");
                        break;
                    //笙
                    case 1:
                        imageView_spe_struct.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.struct_sheng));
                        textView_spe_struct.setText("\t\t\t\t\t笙是由笙苗中簧片发声，吹气及吸气皆能发声，能奏和声。可分成高音笙、中音笙、低音笙、传统笙。\n" +
                                "      笙的构造比较复杂。它是由笙斗、吹嘴、笙苗（又称笙管）、笙角、簧片和腰箍等部件组成。 笙斗圆形，笙斗和吹嘴铜制，焊接后合为一体。笙管上端有长方形或亚铃形出音孔，下开圆形按音孔，下端与笙角相接。");
                        imageView_spe_position.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.position_sheng));
                        textView_spe_history.setText("笙在中国已经有几千年的历史，传说笙可以模仿凤凰的哭声，形状也很像收起翅膀的神鸟。在唐朝（公元618-907年）时，笙才逐渐转变为现在的形式。  笙是从十三簧到十七簧、十九、二十三簧，由簧少到簧多而发展。在传统器乐和昆曲里，笙常常被用作其它管乐器如笛子、唢呐的伴奏，为旋律加上纯四度或纯五度和音。在现代国乐团，笙可以担当旋律或伴奏的作用。");
                        break;
                    //埙
                    case 2:

                        break;
                }
            }
            //西洋乐器
            else {
                //
                switch (position_blow) {
                    //短笛
                    case 0:
                        imageView_spe_struct.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.struct_duandi));
                        textView_spe_struct.setText("\t\t\t\t\t短笛的长度是普通长笛的一半，管体由吹孔、唇垫、头部管、身管、按键、尾管等构成。");
                        imageView_spe_position.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.position_duandi));
                        textView_spe_history.setText("\t\t\t\t\t短笛的声音是高音域，最初常被用作伴奏乐器使用，作为“装饰”乐曲之用。但是，在巴洛克时期，已经出现了很多为短笛而写的协奏曲及独奏曲，其中包括佩尔西凯蒂（Persichetti）和韦瓦第（Vivaldi）等。其中最早将短笛运用于管弦乐团的作品，包括有贝多芬《第5号交响曲》。现在，短笛已成为交响乐团中的常规木管乐器，自浪漫乐派后期起，更常出现有短笛的独立声部。");
                        break;
                    //长笛
                    case 1:
                        imageView_spe_struct.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.struct_changdi));
                        textView_spe_struct.setText("\t\t\t\t\t长笛由笛头、笛尾和管身三部分组成。长笛是吹孔气鸣乐器，奏法繁多，表现力丰富，与弦乐、木管、铜管乐器亲和力强。");
                        imageView_spe_position.setImageBitmap(Image.readBitMap(getActivity(), R.drawable.position_changdi));
                        textView_spe_history.setText("\t\t\t\t\t长笛出现在4.2万到4.3万年前。19世纪初，随着特奥巴尔德·波姆发明的按键装置（后来亦被用于单簧管、双簧管和大管等），长笛完成了定型。据记载，长笛起源于欧洲，初名横笛。到了18世纪末、19世纪初，随着工业的不断发展，金属材料的长笛开始问世。1847年，德国人波姆经过多次试验，研制出了更符合科学原理的带有机械传动装置的长笛，它在音准、音色、音量及音域等方面，都比老式长笛有了革命性发展，极大地丰富了长笛的演奏技能。在海顿时期（1732-1809），长笛已成为交响乐队中的固定乐器。");
                        break;
                }

            }
        }


        //
        view_list.add(spe_struct);
        view_list.add(spe_history);
        view_list.add(spe_position);

        //viewPager
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_spe);
        viewPager.setCurrentItem(0);
        textView_struct.setTextColor(Color.BLUE);
        textView_struct.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                textView_struct.setTextColor(Color.WHITE);
                textView_struct.getPaint().setFlags(0);
                textView_history.setTextColor(Color.WHITE);
                textView_history.getPaint().setFlags(0);
                textView_position.setTextColor(Color.WHITE);
                textView_position.getPaint().setFlags(0);

                switch (position) {
                    //
                    case 0:
                        textView_struct.setTextColor(Color.BLUE);
                        textView_struct.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                        break;
                    //
                    case 1:
                        textView_history.setTextColor(Color.BLUE);
                        textView_history.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                        break;
                    //
                    case 2:
                        textView_position.setTextColor(Color.BLUE);
                        textView_position.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

        //pagerAdapter
        pagerAdapter = new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(view_list.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view1 = view_list.get(position);
                container.addView(view1);
                return view1;
            }

            @Override
            public int getCount() {
                return view_list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

        };
        viewPager.setAdapter(pagerAdapter);
        return view;
    }

    //OnTouchListener
    public class onTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.textView_struct_1:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.textView_history_1:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.textView_position_1:
                    viewPager.setCurrentItem(2);
                    break;
            }
            return false;
        }
    }
}
