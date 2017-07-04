package com.dr.rui.sotired.Util;

import android.app.Application;

/**
 * Created by rui on 2015/6/29.
 */
public class ContextUtil extends Application {
    private static ContextUtil instance;

    public static ContextUtil getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
    }
}
