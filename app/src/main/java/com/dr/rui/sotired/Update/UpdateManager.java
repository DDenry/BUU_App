package com.dr.rui.sotired.Update;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by rui on 2016/12/13.
 */

public class UpdateManager {
    private static UpdateManager manager;

    static {
        manager = new UpdateManager();
    }

    private ThreadPoolExecutor threadPoolExecutor;
    private UpdateDownloadRequest request;

    private UpdateManager() {
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public static UpdateManager getInstance() {
        return manager;
    }

    public void startDownloads(String downloadUrl, String localPath, UpdateDownloadListener listener) {
        if (request != null) {
            return;
        }
        checkLocalFilePath(localPath);
        //
        request = new UpdateDownloadRequest(downloadUrl, localPath, listener);
        Future<?> future = threadPoolExecutor.submit(request);
    }

    //用来检查文件路径是否存在
    private void checkLocalFilePath(String path) {
        File dir = new File(path.substring(0, path.lastIndexOf("/") + 1));

        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
