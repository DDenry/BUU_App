package com.dr.rui.sotired.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.dr.rui.sotired.Activity.Activity_Instrument_1;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

public class Fragment_Main_Knowledge_Instrument extends Fragment {
    private int type;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imageView10;
    private ImageView imageView11;
    private ImageView imageView12;
    private ImageView imageView13;
    private ImageView imageView14;
    private ImageView imageView_back;

    private ImageView[] imageView;
    private int[][] resImageView;
    private String[][] instrument_name;

    private ScrollView scrollView_instrument;

    private CallbackFromInstrument callbackFromInstrument;

    public static Fragment_Main_Knowledge_Instrument newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        Fragment_Main_Knowledge_Instrument fragment = new Fragment_Main_Knowledge_Instrument();
        fragment.setArguments(args);
        //
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callbackFromInstrument = (CallbackFromInstrument) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_knowledge_instrument, container, false);
        //
        Bundle args = getArguments();
        this.type = args.getInt("type");

        imageView1 = (ImageView) view.findViewById(R.id.imageView1);
        imageView2 = (ImageView) view.findViewById(R.id.imageView2);
        imageView3 = (ImageView) view.findViewById(R.id.imageView3);
        imageView4 = (ImageView) view.findViewById(R.id.imageView4);
        imageView5 = (ImageView) view.findViewById(R.id.imageView5);
        imageView6 = (ImageView) view.findViewById(R.id.imageView6);
        imageView7 = (ImageView) view.findViewById(R.id.imageView7);
        imageView8 = (ImageView) view.findViewById(R.id.imageView8);
        imageView9 = (ImageView) view.findViewById(R.id.imageView9);
        imageView10 = (ImageView) view.findViewById(R.id.imageView10);
        imageView11 = (ImageView) view.findViewById(R.id.imageView11);
        imageView12 = (ImageView) view.findViewById(R.id.imageView12);
        imageView13 = (ImageView) view.findViewById(R.id.imageView13);
        imageView14 = (ImageView) view.findViewById(R.id.imageView14);
        imageView_back = (ImageView) view.findViewById(R.id.imageView15);

        imageView = new ImageView[]{imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView_back};
        //
        resImageView = new int[][]{
                //民族吹乐器
                {R.drawable.zhudi_circle, R.drawable.xiao_circle, R.drawable.sheng_circle, R.drawable.suona_circle, R.drawable.bawu_circle, R.drawable.hulusi_circle, R.drawable.xun_circle},
                //民族拉乐器
                {R.drawable.erhu_circle, R.drawable.gaohu_circle, R.drawable.banhu_circle, R.drawable.sanxian_circle, R.drawable.matouqin_circle},
                //民族弹乐器
                {R.drawable.ruan_circle, R.drawable.pipa_circle, R.drawable.yueqin_circle, R.drawable.guqin_circle, R.drawable.guzheng_circle},
                //民族打乐器
                {R.drawable.luo_circle, R.drawable.bo_circle, R.drawable.paigu_circle, R.drawable.dagu_circle, R.drawable.muyu_circle, R.drawable.yangqin_circle},
                //西洋吹乐器
                {R.drawable.changdi_circle, R.drawable.duandi_circle, R.drawable.danhuangguan_circle, R.drawable.shuanghuangguan_circle, R.drawable.yingguoguan_circle, R.drawable.sakesi_circle, R.drawable.daguan_circle, R.drawable.xiaohao_circle, R.drawable.duanhao_circle, R.drawable.changhao_circle, R.drawable.yuanhao_circle, R.drawable.cizhongyinhao_circle, R.drawable.dahao_circle},
                //西洋拉乐器
                {R.drawable.xiaotiqin_circle, R.drawable.zhongtiqin_circle, R.drawable.datiqin_circle, R.drawable.diyintiqin_circle},
                //西洋弹乐器
                {R.drawable.gangqin_circle, R.drawable.guanfengqin_circle, R.drawable.shuqin_circle, R.drawable.shoufengqin_circle, R.drawable.diangangqin_circle, R.drawable.dianjita_circle, R.drawable.dianbeisi_circle},
                //西洋敲乐器
                {R.drawable.dingyingu_circle, R.drawable.cha_circle, R.drawable.sanjiaotie_circle, R.drawable.shachui_circle, R.drawable.gangpianqin_circle, R.drawable.muqin_circle, R.drawable.jiazigu_circle}
        };
        //
        instrument_name = new String[][]{
                //民族吹乐器
                {"竹笛", "箫", "笙", "唢呐", "巴乌", "葫芦丝", "埙"},
                //民族拉乐器
                {"二胡", "高胡", "板胡", "三弦", "马头琴"},
                //民族弹乐器
                {"阮", "琵琶", "月琴", "古琴", "古筝"},
                //民族打乐器
                {"锣", "钹", "排鼓", "大鼓", "木鱼", "扬琴"},
                //西洋吹乐器
                {"长笛", "短笛", "单簧管", "双簧管", "英国管", "萨克斯", "大管", "小号", "短号", "长号", "圆号", "次中音号", "大号"},
                //西洋拉乐器
                {"小提琴", "中提琴", "大提琴", "低音提琴"},
                //西洋弹乐器
                {"钢琴", "管风琴", "竖琴", "手风琴", "电钢琴", "电吉他", "电贝司"},
                //西洋敲乐器
                {"定音鼓", "镲", "三角铁", "沙槌", "钢片琴", "木琴", "架子鼓"}
        };

        //
        scrollView_instrument = (ScrollView) view.findViewById(R.id.scrollView_instrument);
        //
        for (int i = 0; i < 15; i++) {
            if (i > resImageView[type].length) imageView[i].setVisibility(View.GONE);
            else if (i == resImageView[type].length) {
                imageView[i].setImageBitmap(Image.readBitMap(getActivity(), R.drawable.back_circle));
                //
                imageView[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //
                        callbackFromInstrument.sendMessage(type);
                        scrollView_instrument.scrollTo(0, 0);
                    }
                });
            } else {
                imageView[i].setImageBitmap(Image.readBitMap(getActivity(), resImageView[type][i]));
                imageView[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), Activity_Instrument_1.class);
                        for (int j = 0; j < instrument_name[type].length; j++) {
                            if (imageView[j].getId() == v.getId()) {
                                intent.putExtra("instrument_name", instrument_name[type][j]);
                                break;
                            }
                        }
                        startActivity(intent);
                    }
                });
            }
        }

        //
        switch (type) {
            //民族吹
            case 0:
                break;
            //民族拉
            case 1:
                break;
            //民族弹
            case 2:
                break;
            //民族打
            case 3:
                break;
            //西洋吹
            case 4:
                break;
            //西洋拉
            case 5:
                break;
            //西洋弹
            case 6:
                break;
            //西洋打
            case 7:
                break;
        }
        return view;
    }

    public interface CallbackFromInstrument {
        void sendMessage(int type);
    }
}
