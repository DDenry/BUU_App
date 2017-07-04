package com.dr.rui.sotired.Util_Image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.LruCache;
import android.widget.ImageView;

import com.dr.rui.sotired.R;

import java.io.InputStream;

/**
 * Created by rui on 2015/5/15.
 */
public class Image {
    // 以最省内存的方式读取本地资源的图片
    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        // 获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // 源图片的高度和宽度
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            // 一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    //
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {
        // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        // 调用上面定义的方法计算inSampleSize值
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        // 使用获取到的inSampleSize值再次解析图片
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
/*    //
    private LruCache<String, Bitmap> mMemoryCache;

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                //重写此方法来衡量每张图片的大小，默认返回图片数量
                return bitmap.getByteCount() / 1024;
            }
        };
        if (getBitmapFromMemory(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemory(String key) {
        return mMemoryCache.get(key);
    }
    public void loadBitmap(int resId, ImageView imageView) {
        final String imageKey = String.valueOf(resId);
        final Bitmap bitmap = getBitmapFromMemory(imageKey);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.drawable.music_bc);
            BitmapWorkerTask task = new BitmapWorkerTask(imageView);
            task.execute(resId);
        }
    }

    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        // 在后台加载图片。
        @Override
        protected Bitmap doInBackground(Integer... params) {
            final Bitmap bitmap = decodeSampledBitmapFromResource(
                    getResources(), params[0], 100, 100);
            addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
            return bitmap;
        }
    }*/
}

