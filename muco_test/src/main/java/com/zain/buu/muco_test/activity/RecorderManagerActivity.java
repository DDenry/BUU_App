package com.zain.buu.muco_test.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.zain.buu.muco_test.R;
import com.zain.buu.muco_test.entity.Recorder_Amr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Zain on 2016/4/7.
 * <p/>
 * 录音管理页
 */
public class RecorderManagerActivity extends Activity implements View.OnClickListener {

    private List<Recorder_Amr> recorders = new ArrayList<>(); //录音集合
    private ListView myList; //录音列表布局
    private Button back; //返回按钮
    private Intent intent; //跳转页面意图
    private Adapter listAdapter; //录音列表适配器
    private MediaPlayer mediaPlayer; //音乐播放器
    private File mFile; //音频文件地址
    private int play_flag = 0; //播放标志位
    private List<MediaPlayer> mediaPlayers = new ArrayList<>(); //播放器列表


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setContentView(R.layout.mrecorder_layout);

        initRecorders();    //初始化录音列表
        initView(); //初始化布局
    }

    /**
     * 初始化音频播放器
     */
    private void initMid(String name) {
        mFile = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //获取SD卡对应的存储目录
            File sd = Environment.getExternalStorageDirectory();
            try {
                mFile = new File(sd.getCanonicalPath().toString() + "/muco_sound"); //获取音频文件夹

                mediaPlayer = new MediaPlayer();    //新建一个播放器实体
                mediaPlayers.add(mediaPlayer);  //加入播放器列表
                mediaPlayer.setDataSource(mFile.getPath() + "/" + name);  //获取录音文件

                mediaPlayer.prepare(); //音频播放准备
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化View
     */
    private void initView() {

        myList = (ListView) findViewById(R.id.mrecorder_list); //获取录音列表布局
        listAdapter = new Adapter(RecorderManagerActivity.this); //初始化适配器
        myList.setAdapter(listAdapter); //录音列表设置适配器
        back = (Button) findViewById(R.id.back); //获取返回按钮
        back.setOnClickListener(this); //为返回按钮设置监听事件
    }


    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) { //返回按钮点击事件
        int id = v.getId();
        if (id == R.id.back) {
            intent = new Intent(RecorderManagerActivity.this, MainActivity.class); //获取意图Activity
            startActivity(intent); //启动跳转
            closePlay(); //关闭正在播放的音频
            finish(); //销毁该Activity
        }
        /*
        switch (v.getId()) {
            case R.id.back:
                intent = new Intent(RecorderManagerActivity.this, MainActivity.class); //获取意图Activity
                startActivity(intent); //启动跳转
                closePlay(); //关闭正在播放的音频
                finish(); //销毁该Activity
                break;
        }*/
    }


    /**
     * 关闭音频
     */
    public void closePlay() {
        if (play_flag == 1) {
            play_flag = 0;
            for (MediaPlayer mediaPlayer : mediaPlayers) {  //遍历所有播放器实体
                mediaPlayer.pause();    //暂停音乐
                mediaPlayer.release();  //释放资源
                mediaPlayers.remove(mediaPlayer);   //移除该播放器实体
            }

        }
    }

    /**
     * 初始化录音数据
     */
    private void initRecorders() {

        File sdCardDir; //sd卡路径
        File files = null; //文件夹路径

        //获取SD卡对应的存储目录
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //获取SD卡对应的存储目录
            sdCardDir = Environment.getExternalStorageDirectory();
            try {
                files = new File(sdCardDir.getCanonicalPath().toString() + "/muco_sound");  //获得录音文件夹
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!files.exists()) {    //防止目录不存在
                files.mkdirs();
            }

            //获取当前目录下的所有子项
            File[] subs = files.listFiles();

            for (File sub : subs) { //遍历所有音频文件获取录音实体，把录音实体放入录音列表中
                Recorder_Amr r = new Recorder_Amr(sub.getName()); //构造录音实体
                recorders.add(r); //把实体放入列表
            }

        }
    }

    /**
     * 适配器
     */
    private class Adapter extends BaseAdapter {

        Context context;
        LayoutInflater inflater;

        public Adapter(Context context) {
            this.context = context;
            inflater = (LayoutInflater) this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public int getCount() {
            return recorders.size();
        }

        @Override
        public Object getItem(int position) {
            return recorders.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {    //第一次在加载这个第一屏数据的时候调用
                convertView = inflater.inflate(R.layout.mrecorder_item_layout, null);
                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.mrecorder_name);
                holder.play = (Button) convertView.findViewById(R.id.mrecorder_play);
                holder.delete = (Button) convertView.findViewById(R.id.mrecorder_delete);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag(); //再次加载直接获得实体
            }

            holder.name.setText(recorders.get(position).getName()); //显示录音文件的名字

            //删除该项
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    File dfile;
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        //获取SD卡对应的存储目录
                        File sd = Environment.getExternalStorageDirectory();
                        try {
                            dfile = new File(sd.getCanonicalPath().toString() + "/muco_sound/" + recorders.get(position).getName());    //获取录音文件
                            dfile.delete(); //删除该文件
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    closePlay(); //关闭正在播放的音频

                    recorders.remove(position);
                    listAdapter.notifyDataSetChanged();
                }
            });
            //播放该项
            holder.play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    closePlay(); //关闭正在播放的音频
                    initMid(recorders.get(position).getName());
                    mediaPlayer.start(); //开始播放
                    play_flag = 1;
                }
            });

            return convertView;
        }

    }

    /**
     * 用于保存view的静态资源
     */
    class ViewHolder {
        private TextView name;
        private Button play;
        private Button delete;
    }
}