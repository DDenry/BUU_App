package com.dr.rui.sotired.Update;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.dr.rui.sotired.R;

import java.io.File;

/**
 * Created by rui on 2016/12/13.
 */

public class UpdateService extends Service {
    private String apkURL;
    private String filePath;
    private NotificationManager notificationManager;
    private Notification notification;


    @Override
    public void onCreate() {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        filePath = Environment.getExternalStorageDirectory() + "/buu/musical_instrument/北京联合大学——乐器百科.apk";
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            notifyUser("检查失败！", "系统消息", 0);
            stopSelf();
        }
        apkURL = intent.getStringExtra("apkUrl");
        notifyUser("开始下载更新... ...", "系统消息", 0);

        startDownload();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    private void startDownload() {
        UpdateManager.getInstance().startDownloads(apkURL, filePath, new UpdateDownloadListener() {
            @Override
            public void onStarted() {
                Toast.makeText(getBaseContext(), "开始下载!", Toast.LENGTH_SHORT).show();
                Log.i("ServiceStart:", "开始下载");
            }

            @Override
            public void onProgressChanged(int progress, String downloadLength) {
                //Log.i("ServiceProgressChanged:",""+progress);
                notifyUser("正在下载更新~", "系统消息", progress);
            }

            @Override
            public void onFinished(float completeSize, String downloadUrl) {
                Log.i("ServiceFinished:", "下载完成");
                Toast.makeText(getBaseContext(), "下载完成!", Toast.LENGTH_LONG).show();
                notifyUser("更新下载完成！", "系统消息", 100);
                stopSelf();
            }

            @Override
            public void onFailure() {
                Log.i("ServiceFailure:", "下载失败");
                notifyUser("更新下载失败！", "系统消息", -1);
                Toast.makeText(getBaseContext(), "更新下载失败!", Toast.LENGTH_LONG).show();
                stopSelf();
            }
        });
    }

    //更新Notification
    private void notifyUser(String result, String reason, int progress) {
        //
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.app_icon).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.app_icon)).setContentTitle(getString(R.string.app_name));
        //
        builder.setContentInfo(progress < 100 ? "已下载：" + progress + "%" : "下载完成~点击安装！");
        if (progress >= 0 && progress <= 100) builder.setProgress(100, progress, false);
        else {
            builder.setContentInfo("下载失败！请重新打开应用").setProgress(0, 0, false);
        }
        //builder.setAutoCancel(true);
        builder.setOngoing(true);
        builder.setWhen(System.currentTimeMillis());
        builder.setTicker(result);
        if (progress >= 100) {
            builder.setOngoing(false);
            builder.setContentIntent(getContentIntent());
            builder.setAutoCancel(true);
        } else {
            builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT));
        }

        notification = builder.build();
        notificationManager.notify(0, notification);
    }

    private PendingIntent getContentIntent() {
        File apkFile = new File(filePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Uri.parse("file://" + apkFile.getAbsolutePath())
        intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }
}
