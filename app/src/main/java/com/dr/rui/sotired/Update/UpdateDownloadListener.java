package com.dr.rui.sotired.Update;

/**
 * Created by rui on 2016/12/13.
 */

public interface UpdateDownloadListener {
    void onStarted();

    void onProgressChanged(int progress, String downloadLength);

    void onFinished(float completeSize, String downloadUrl);

    void onFailure();
}
