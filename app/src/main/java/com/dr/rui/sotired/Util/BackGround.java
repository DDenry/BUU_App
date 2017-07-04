package com.dr.rui.sotired.Util;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

/**
 * Created by rui on 2015/7/10.
 */
public class BackGround {
    public static Drawable setBackGround(Context context) {
        Drawable drawable = new BitmapDrawable(Image.readBitMap(context, R.drawable.yinfu));
        return drawable;
    }
}
