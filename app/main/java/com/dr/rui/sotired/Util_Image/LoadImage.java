package com.dr.rui.sotired.Util_Image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.dr.rui.sotired.Activity.Activity_Instrument;
import com.dr.rui.sotired.Util.ContextUtil;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rui on 2015/6/24.
 */
public class LoadImage {
    private KenBurnsView kenBurnsView;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            kenBurnsView.setImageBitmap((Bitmap) msg.obj);
        }
    };
    public void showImageByThread(KenBurnsView kenBurnsView, final String url){
        this.kenBurnsView=kenBurnsView;
        new Thread(){
            @Override
            public void run() {
                super.run();
                Bitmap bitmap = getBitmapFromURL(url);
                Message message = Message.obtain();
                message.obj=bitmap;
                handler.sendMessage(message);
            }
        }.start();
    }
    public Bitmap getBitmapFromURL(String urlString){

        // 从内存缓存中获取图片
        ImageMemoryCache memoryCache = new ImageMemoryCache(ContextUtil.getInstance());
        ImageFileCache fileCache = new ImageFileCache();
        Bitmap result = memoryCache.getBitmapFromCache(urlString);
        if (result == null) {
            // 文件缓存中获取
            result = fileCache.getImage(urlString);
            if (result == null) {
                // 从网络获取
                result = ImageGetFromHttp.downloadBitmap(urlString);
                if (result != null) {
                    fileCache.saveBitmap(result, urlString);
                    memoryCache.addBitmapToCache(urlString, result);
                }
            } else {
                // 添加到内存缓存
                memoryCache.addBitmapToCache(urlString, result);
            }
        }
        return result;
    }
}
