package com.zain.buu.muco_test.util;

import com.zain.buu.muco_test.R;

/**
 * Created by Zain on 2016/5/15.
 */
public class GuqinUtil {

    private static int[] gImgIds; //琴键图片
    private static int[] gImgIds_d; //琴键-按下图片
    private static int[] gIds; //琴键ids
    private static int[] gMusics; //琴键音频

    //加载琴键图片 7个
    public static int[] initGImgIds() {
        gImgIds = new int[]{
                R.mipmap.x1, R.mipmap.x1, R.mipmap.x1,
                R.mipmap.x1, R.mipmap.x1, R.mipmap.x1,
                R.mipmap.x1
        };
        return gImgIds;
    }

    //加载琴键图片 按下 7个
    public static int[] initGImgIds_d() {
        gImgIds_d = new int[]{
                R.mipmap.x1d, R.mipmap.x1d, R.mipmap.x1d,
                R.mipmap.x1d, R.mipmap.x1d, R.mipmap.x1d,
                R.mipmap.x1d
        };
        return gImgIds_d;
    }

    //加载琴键ids数组
    public static int[] initGIds() {
        gIds = new int[]{
                R.id.g1, R.id.g2, R.id.g3, R.id.g4, R.id.g5,
                R.id.g6, R.id.g7
        };
        return gIds;
    }


    //加载琴键音频
    public static int[] initGMusics() {
        gMusics = new int[]{
                R.raw.guqin1, R.raw.guqin2, R.raw.guqin3, R.raw.guqin4, R.raw.guqin5,
                R.raw.guqin6, R.raw.guqin7
        };
        return gMusics;
    }


}
