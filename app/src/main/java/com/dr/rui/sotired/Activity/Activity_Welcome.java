package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

public class Activity_Welcome extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__welcome);

        imageView = (ImageView) findViewById(R.id.imageView_welcome);
        imageView.setImageBitmap(Image.readBitMap(this, R.drawable.blue_welcome));

        //
        int memory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.i("TAG", "Max memory is " + memory);

        //
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //跳转到百科界面
                Intent intent = new Intent(Activity_Welcome.this, Activity_First_Page.class);
                startActivity(intent);
                //回收bitmap以释放内存
                Image.readBitMap(Activity_Welcome.this, R.drawable.blue_welcome).recycle();
                System.gc();
                //关闭当前页面
                try {
                    this.finalize();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                finish();
            }
        }, 3000);
    }
}
