package com.dr.rui.sotired.Update;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

/**
 * Created by rui on 2016/12/13.
 */

public class UpdateDownloadRequest implements Runnable {
    private String downloadUrl;
    private String localFilePath;
    private UpdateDownloadListener downloadListener;
    private boolean isDownloading = false;
    private float currentLength;
    private DownloadResponseHandler downloadResponseHandler;

    public UpdateDownloadRequest(String downloadUrl, String localFilePath, UpdateDownloadListener downloadListener) {
        this.downloadListener = downloadListener;
        this.downloadUrl = downloadUrl;
        this.localFilePath = localFilePath;
        this.isDownloading = true;
        this.downloadResponseHandler = new DownloadResponseHandler();
    }


    private void makeRequest() throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            URL url = new URL(downloadUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.connect();
            currentLength = connection.getContentLength();
            Log.i("currentLength:", "" + currentLength);
            if (!Thread.currentThread().isInterrupted()) {
                downloadResponseHandler.sendResponseMessage(connection.getInputStream());
            } else Log.i("Thread0:", "Interrupted!");
        } else Log.i("Thread1:", "Interrupted!");
    }

    @Override
    public void run() {
        try {
            //
            makeRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getTwoPointFloatStr(float value) {
        DecimalFormat fnum = new DecimalFormat("0.00");
        return fnum.format(value);

    }

    public enum FailureCode {
        UnkonwnHost, Socket, SocketTimeout, ConnectTimeout, IO, HttpResponse, JSON, Interrupted
    }

    public class DownloadResponseHandler {
        protected static final int SUCCESS_MESSAGE = 0;
        protected static final int FAILURE_MESSAGE = 1;
        protected static final int START_MESSAGE = 2;
        protected static final int FINISH_MESSAGE = 3;
        protected static final int NETWORK_OFF = 4;
        protected static final int PROGRESS_CHANGED = 5;

        private long mCompleteSize = 0;
        private int progress = 0;
        private Handler handler;

        public DownloadResponseHandler() {
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    handleSelfMessage(msg);
                }
            };
        }

        protected void sendFinishMessage() {
            sendMessage(obtainMessage(FINISH_MESSAGE, null));
        }

        private void sendProgressChangedMessage(int progress) {
            //
            sendMessage(obtainMessage(PROGRESS_CHANGED, new Object[]{progress}));
        }

        protected void sendFailureMessage(FailureCode failureCode) {
            sendMessage(obtainMessage(FAILURE_MESSAGE, new Object[]{failureCode}));
        }

        protected void sendMessage(Message msg) {
            if (handler != null) {
                handler.sendMessage(msg);
            } else handleSelfMessage(msg);
        }


        //
        protected Message obtainMessage(int responseMessage, Object response) {
            Message msg = null;
            if (handler != null) {
                msg = handler.obtainMessage(responseMessage, response);
            } else {
                msg = Message.obtain();
                msg.what = responseMessage;
                msg.obj = response;
            }
            return msg;
        }

        protected void handleSelfMessage(Message msg) {
            Object[] response;
            switch (msg.what) {
                case FAILURE_MESSAGE:
                    response = (Object[]) msg.obj;
                    handleFailureMessage((FailureCode) response[0]);
                    break;
                case PROGRESS_CHANGED:
                    response = (Object[]) msg.obj;
                    handleProgressChangedMessage(((Integer) response[0]).intValue());
                    break;
                case FINISH_MESSAGE:
                    onFinish();
                    break;
            }
        }

        protected void handleProgressChangedMessage(int progress) {
            downloadListener.onProgressChanged(progress, "");
        }

        protected void handleFailureMessage(FailureCode failureCode) {
            onFailure(failureCode);
        }

        public void onFinish() {
            downloadListener.onFinished(mCompleteSize, "");
        }

        public void onFailure(FailureCode failureCode) {
            downloadListener.onFailure();
        }

        void sendResponseMessage(InputStream is) {
            RandomAccessFile randomAccessFile = null;
            mCompleteSize = 0;
            byte[] buffer = new byte[1024];
            int length = -1;
            int limit = 0;
            try {
                randomAccessFile = new RandomAccessFile(localFilePath, "rwd");
                while ((length = is.read(buffer)) != -1) {
                    if (isDownloading) {
                        randomAccessFile.write(buffer, 0, length);
                        mCompleteSize += length;
                        if (mCompleteSize < currentLength) {
                            Log.i("mCompleteSize:", "" + mCompleteSize);
                            progress = (int) (Float.parseFloat(getTwoPointFloatStr((Float.parseFloat("" + 100.0 * mCompleteSize) / currentLength))));
                            //更新Notification频率
                            if (limit % 30 == 0 && progress <= 100) {
                                sendProgressChangedMessage(progress);
                            }
                            limit++;
                        }
                    }
                }
                sendFinishMessage();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                sendFailureMessage(FailureCode.IO);
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (randomAccessFile != null) randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    sendFailureMessage(FailureCode.IO);
                }
            }
        }
    }
}