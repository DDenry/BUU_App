package com.zain.buu.muco_test.util;

import com.zain.buu.muco_test.R;

/**
 * Created by Zain on 2016/3/30.
 * <p>
 * 钢琴活动的处理工具
 */
public class PianoUtil {

    private static int[] wImgIds; //白键图片
    private static int[] bImgIds; //黑键图片
    private static int[] wids; //白键ids
    private static int[] bids; //黑键ids
    private static int[] wMusics; //白键音频
    private static int[] bMusics; //黑键音频
    private static int[] wImgIds_d; //白键图片-按下
    private static int[] bImgIds_d; //黑键图片-按下
    private static String[] txt;    //白键-文字
    private static int[] txtIds;    //白键-文字ids

    //加载-白键文字
    public static String[] initTxt() {
        txt = new String[]{
                "A0", "B0", "C1", "D1", "E1", "F1", "G1",
                "A1", "B1", "C2", "D2", "E2", "F2", "G2",
                "A2", "B2", "C3", "D3", "E3", "F3", "G3",
                "A3", "B3", "C4", "D4", "E4", "F4", "G4",
                "A4", "B4", "C5", "D5", "E5", "F5", "G5",
                "A5", "B5", "C6", "D6", "E6", "F6", "G6",
                "A6", "B6", "C7", "D7", "E7", "F7", "G7",
                "A7", "B7", "C8"
        };
        return txt;
    }

    //加载白键图片 52个
    public static int[] initWImgIds() {
        wImgIds = new int[]{
                R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w,

                R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w,

                R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w,

                R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w,

                R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w,

                R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w,

                R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w, R.drawable.w,
                R.drawable.w, R.drawable.w,

                R.drawable.w, R.drawable.w,
                R.drawable.w
        };

        return wImgIds;
    }

    //加载白键图片-按下 52个
    public static int[] initWImgIds_d() {
        wImgIds_d = new int[]{
                R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d,

                R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d,

                R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d,

                R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d,

                R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d,

                R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d,

                R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d, R.drawable.w_d,

                R.drawable.w_d, R.drawable.w_d,
                R.drawable.w_d
        };

        return wImgIds_d;
    }

    //加载黑键图片 36个
    public static int[] initBImgIds() {
        bImgIds = new int[]{

                R.drawable.b, R.drawable.b,
                R.drawable.b, R.drawable.b, R.drawable.b,

                R.drawable.b, R.drawable.b,
                R.drawable.b, R.drawable.b, R.drawable.b,

                R.drawable.b, R.drawable.b,
                R.drawable.b, R.drawable.b, R.drawable.b,

                R.drawable.b, R.drawable.b,
                R.drawable.b, R.drawable.b, R.drawable.b,

                R.drawable.b, R.drawable.b,
                R.drawable.b, R.drawable.b, R.drawable.b,

                R.drawable.b, R.drawable.b,
                R.drawable.b, R.drawable.b, R.drawable.b,

                R.drawable.b, R.drawable.b,
                R.drawable.b, R.drawable.b, R.drawable.b,

                R.drawable.b
        };

        return bImgIds;
    }

    //加载黑键-按下图片 36个
    public static int[] initBImgIds_d() {
        bImgIds_d = new int[]{

                R.drawable.b_d, R.drawable.b_d,
                R.drawable.b_d, R.drawable.b_d, R.drawable.b_d,

                R.drawable.b_d, R.drawable.b_d,
                R.drawable.b_d, R.drawable.b_d, R.drawable.b_d,

                R.drawable.b_d, R.drawable.b_d,
                R.drawable.b_d, R.drawable.b_d, R.drawable.b_d,

                R.drawable.b_d, R.drawable.b_d,
                R.drawable.b_d, R.drawable.b_d, R.drawable.b_d,

                R.drawable.b_d, R.drawable.b_d,
                R.drawable.b_d, R.drawable.b_d, R.drawable.b_d,

                R.drawable.b_d, R.drawable.b_d,
                R.drawable.b_d, R.drawable.b_d, R.drawable.b_d,

                R.drawable.b_d, R.drawable.b_d,
                R.drawable.b_d, R.drawable.b_d, R.drawable.b_d,

                R.drawable.b_d
        };
        return bImgIds_d;
    }

    //加载白键ids数组
    public static int[] initWIds() {
        wids = new int[]{
                R.id.w1, R.id.w2, R.id.w3, R.id.w4, R.id.w5,
                R.id.w6, R.id.w7, R.id.w8, R.id.w9, R.id.w10,

                R.id.w11, R.id.w12, R.id.w13, R.id.w14, R.id.w15,
                R.id.w16, R.id.w17, R.id.w18, R.id.w19, R.id.w20,

                R.id.w21, R.id.w22, R.id.w23, R.id.w24, R.id.w25,
                R.id.w26, R.id.w27, R.id.w28, R.id.w29, R.id.w30,

                R.id.w31, R.id.w32, R.id.w33, R.id.w34, R.id.w35,
                R.id.w36, R.id.w37, R.id.w38, R.id.w39, R.id.w40,

                R.id.w41, R.id.w42, R.id.w43, R.id.w44, R.id.w45,
                R.id.w46, R.id.w47, R.id.w48, R.id.w49, R.id.w50,

                R.id.w51, R.id.w52
        };
        return wids;
    }

    //加载黑键ids数组
    public static int[] initBIds() {
        bids = new int[]{
                R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5,
                R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10,

                R.id.b11, R.id.b12, R.id.b13, R.id.b14, R.id.b15,
                R.id.b16, R.id.b17, R.id.b18, R.id.b19, R.id.b20,

                R.id.b21, R.id.b22, R.id.b23, R.id.b24, R.id.b25,
                R.id.b26, R.id.b27, R.id.b28, R.id.b29, R.id.b30,

                R.id.b31, R.id.b32, R.id.b33, R.id.b34, R.id.b35,
                R.id.b36
        };
        return bids;
    }

    //加载-白键文字ids数组
    public static int[] initTxtIds() {
        txtIds = new int[]{
                R.id.t1, R.id.t2, R.id.t3, R.id.t4, R.id.t5,
                R.id.t6, R.id.t7, R.id.t8, R.id.t9, R.id.t10,

                R.id.t11, R.id.t12, R.id.t13, R.id.t14, R.id.t15,
                R.id.t16, R.id.t17, R.id.t18, R.id.t19, R.id.t20,

                R.id.t21, R.id.t22, R.id.t23, R.id.t24, R.id.t25,
                R.id.t26, R.id.t27, R.id.t28, R.id.t29, R.id.t30,

                R.id.t31, R.id.t32, R.id.t33, R.id.t34, R.id.t35,
                R.id.t36, R.id.t37, R.id.w38, R.id.w39, R.id.w40,

                R.id.t41, R.id.t42, R.id.t43, R.id.t44, R.id.t45,
                R.id.t46, R.id.t47, R.id.t48, R.id.t49, R.id.t50,

                R.id.t51, R.id.t52
        };
        return txtIds;
    }

    //加载白键音频
    public static int[] initWMusic() {
        wMusics = new int[]{
                R.raw.mw1, R.raw.mw2, R.raw.mw3, R.raw.mw4, R.raw.mw5,
                R.raw.mw6, R.raw.mw7, R.raw.mw8, R.raw.mw9, R.raw.mw10,

                R.raw.mw11, R.raw.mw12, R.raw.mw13, R.raw.mw14, R.raw.mw15,
                R.raw.mw16, R.raw.mw17, R.raw.mw18, R.raw.mw19, R.raw.mw20,

                R.raw.mw21, R.raw.mw22, R.raw.mw23, R.raw.mw24, R.raw.mw25,
                R.raw.mw26, R.raw.mw27, R.raw.mw28, R.raw.mw29, R.raw.mw30,

                R.raw.mw31, R.raw.mw32, R.raw.mw33, R.raw.mw34, R.raw.mw35,
                R.raw.mw36, R.raw.mw37, R.raw.mw38, R.raw.mw39, R.raw.mw40,

                R.raw.mw41, R.raw.mw42, R.raw.mw43, R.raw.mw44, R.raw.mw45,
                R.raw.mw46, R.raw.mw47, R.raw.mw48, R.raw.mw49, R.raw.mw50,

                R.raw.mw51, R.raw.mw52
        };
        return wMusics;
    }

    //加载黑键音频
    public static int[] initBMusic() {
        bMusics = new int[]{
                R.raw.mb1, R.raw.mb2, R.raw.mb3, R.raw.mb4, R.raw.mb5,
                R.raw.mb6, R.raw.mb7, R.raw.mb8, R.raw.mb9, R.raw.mb10,

                R.raw.mb11, R.raw.mb12, R.raw.mb13, R.raw.mb14, R.raw.mb15,
                R.raw.mb16, R.raw.mb17, R.raw.mb18, R.raw.mb19, R.raw.mb20,

                R.raw.mb21, R.raw.mb22, R.raw.mb23, R.raw.mb24, R.raw.mb25,
                R.raw.mb26, R.raw.mb27, R.raw.mb28, R.raw.mb29, R.raw.mb30,

                R.raw.mb31, R.raw.mb32, R.raw.mb33, R.raw.mb34, R.raw.mb35,
                R.raw.mb36
        };
        return bMusics;
    }


}
