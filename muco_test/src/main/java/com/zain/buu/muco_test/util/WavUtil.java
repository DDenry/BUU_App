package com.zain.buu.muco_test.util;

import android.util.Log;

/**
 * Created by Zain on 2016/3/28.
 * <p>
 * wav音频文件处理工具
 */
public class WavUtil {


    //头文件部分位置相加
    public static int[] AddWavHeadDataLength(int[] head, int[] addhead) {

        int[] headR = new int[head.length];
        int add_flag = 0;

        for (int i = 0; i < head.length; i++) {
            Log.d("zain", "head[" + i + "]：" + head[i]);
            Log.d("zain", "addhead[" + i + "]：" + addhead[i]);
            headR[i] = head[i] + addhead[i];
            Log.d("zain", "headR[" + i + "]：" + headR[i]);


            if (add_flag == 1) {
                headR[i] += add_flag;
                add_flag = 0;
            }

            if (headR[i] > 255) {
                headR[i] -= 255;
                add_flag = 1;
            }

        }

        if (add_flag == 1) {
            Log.e("zain", "文件长度超出最大范围了");
        }


        return headR;
    }


    //将int型转换为byte型
    public static byte[] intToBytes(int ints[]) {

        int k = 0;
        byte[] b = new byte[ints.length];

        for (int i = 0; i < ints.length; i++, k += 2) {
            b[i] = (byte) ints[i];    //低位

            Log.d("zain", "b[" + i + "]:" + b[i]);
        }

        return b;
    }


}
