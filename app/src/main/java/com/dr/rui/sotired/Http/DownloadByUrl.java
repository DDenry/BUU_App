package com.dr.rui.sotired.Http;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rui on 2016/12/17.
 */

public class DownloadByUrl {
    public void DownloadVersionTxt() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://7xkqzu.com1.z0.glb.clouddn.com/Version.txt");


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
