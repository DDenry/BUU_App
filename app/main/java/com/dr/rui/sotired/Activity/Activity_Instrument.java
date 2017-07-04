package com.dr.rui.sotired.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.dr.rui.sotired.Fragment.FragmentMusic;
import com.dr.rui.sotired.Fragment.FragmentMusic_1;
import com.dr.rui.sotired.Fragment.FragmentMusic_2;
import com.dr.rui.sotired.Fragment.FragmentSkill;
import com.dr.rui.sotired.Fragment.FragmentSpecification;
import com.dr.rui.sotired.Fragment.FragmentSpecification_1;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util.BackGround;
import com.dr.rui.sotired.Util_Image.Image;
import com.dr.rui.sotired.Util_Image.LoadImage;
import com.flaviofaria.kenburnsview.KenBurnsView;

public class Activity_Instrument extends FragmentActivity {

    public static int Signal = 0;
    public static int position = 0;
    public static int position_1 = 0;
    private ToggleButton button_specification;
    private ToggleButton button_music;
    private ToggleButton button_skill;

    private KenBurnsView kenBurnsView_instrument;
    private LinearLayout linearLayout;

    private ImageView imageView_xiao;
    private ImageView imageView_title;
    private ImageView imageView_back;

    private TextView textView_instrument_brief;

    public static int position_wooden;
    FragmentSpecification_1 fragmentSpecification;
    FragmentMusic_2 fragmentMusic;
    FragmentSkill fragmentSkill;

    FragmentTransaction fragmentTransaction;

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //动态设置布局
        //RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_activity_instrument, null);
        //设置布局的背景
//        relativeLayout.setBackgroundDrawable(BackGround.setBackGround(Activity_Instrument.this));
        //绑定布局
        setContentView(R.layout.activity_instrument);

        //跳转
        Intent intent = getIntent();
        int position_blow = Integer.parseInt(intent.getStringExtra("position_blow"));
        int position_type = Integer.parseInt(intent.getStringExtra("position_type"));
        position = position_blow;
        position_1 = position_type;
        //初始化
        init();

        //由吹界面传来参数
        if (Signal == 0) {
            //获取位置
            //position_blow = Integer.parseInt(intent.getStringExtra("position_blow"));
            //民族乐器
            if (position_type == 0) {
                switch (position_blow) {
                    //箫
                    case 0:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        //imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.xiao1));
                        imageView_xiao.setImageBitmap(Image.decodeSampledBitmapFromResource(getResources(), R.drawable.xiao1, 90, 60));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        textView_instrument_brief.setText("\t\t\t\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。为单管、竖吹，历史悠久，音色圆润轻柔，幽静典雅，适于独奏和重奏。");
                        //kenBurnsView_instrument.resume();
                        //即时释放内存
                        System.gc();
                        System.runFinalization();
                        //new LoadImage().showImageByThread(kenBurnsView_instrument, "http://pic2.filec2c.com/doimg/McGray/1209fd44/");
                        //new LoadImage().showImageByThread(kenBurnsView_instrument,"http://pic2.filec2c.com/doimg/McGray/1209fd44/");
                        break;
                    //笙
                    case 1:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        //imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.sheng));
                        imageView_xiao.setImageBitmap(Image.decodeSampledBitmapFromResource(getResources(), R.drawable.xiao1, 90, 60));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        textView_instrument_brief.setText("\t\t\t\t\t笙，吹孔簧鸣乐器，起源于中国，是世界上最早使用自由簧的乐器。发音清越、高雅、音质柔和、歌唱性强，具有中国民间色彩。\n");
                        //即时释放内存
                        System.gc();
                        System.runFinalization();
                        //kenBurnsView_instrument.setImageBitmap(bitmap);
                        break;
                    //埙
                    case 2:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        textView_instrument_brief.setText("\t\t\t\t\t笙，吹孔簧鸣乐器，起源于中国，是世界上最早使用自由簧的乐器。发音清越、高雅、音质柔和、歌唱性强，具有中国民间色彩。\n");
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.xun));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        System.gc();
                        System.runFinalization();
                        break;
                    //竹笛
                    case 3:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        System.gc();
                        System.runFinalization();
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.zhudi));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        break;
                    //唢呐
                    case 4:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        System.gc();
                        System.runFinalization();
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.suona));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        break;
                    //巴乌
                    case 5:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        System.gc();
                        System.runFinalization();
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.bawu));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        break;
                }
            }
            //西洋乐器
            else {
                switch (position_blow) {
                    //短笛
                    case 0:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        System.gc();
                        System.runFinalization();
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.duandi));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        textView_instrument_brief.setText("\t\t\t\t\t短笛，是音域最高的木管乐器，是长笛家族的一种变种乐器，也是交响乐队中音域最高的乐器之一。");
                        break;
                    //长笛
                    case 1:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        System.gc();
                        System.runFinalization();
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.changdi));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        textView_instrument_brief.setText("\t\t\t\t\t长笛，木管乐器，是现代管弦乐和室乐中主要的高音旋律乐器，外型是一根开有数个音孔的圆柱型长管。早期的长笛是乌木或者椰木制，现代多使用金属的材质，比如普通的镍银合金到专业型的银合金，9K和14K金等。\n");
                        break;
                    //小号
                    case 2:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        System.gc();
                        System.runFinalization();
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.xiaohao));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        textView_instrument_brief.setText("\t\t\t\t\t长笛，木管乐器，是现代管弦乐和室乐中主要的高音旋律乐器，外型是一根开有数个音孔的圆柱型长管。早期的长笛是乌木或者椰木制，现代多使用金属的材质，比如普通的镍银合金到专业型的银合金，9K和14K金等。\n");
                        break;
                    //短号
                    case 3:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        System.gc();
                        System.runFinalization();
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.duanhao));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        textView_instrument_brief.setText("\t\t\t\t\t短号，铜管乐器。短号是小号的变形乐器，通常只用于军乐队和舞厅乐队，很少用于管弦乐队。另外还有降E调短号，使用较少。\n");
                        break;
                    //长号
                    case 4:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        System.gc();
                        System.runFinalization();
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.changhao));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        textView_instrument_brief.setText("\t\t\t\t\t长笛，木管乐器，是现代管弦乐和室乐中主要的高音旋律乐器，外型是一根开有数个音孔的圆柱型长管。早期的长笛是乌木或者椰木制，现代多使用金属的材质，比如普通的镍银合金到专业型的银合金，9K和14K金等。\n");
                        break;
                    //圆号
                    case 5:
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                        System.gc();
                        System.runFinalization();
                        //
                        imageView_xiao.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.yuanhao));
                        imageView_title.setImageBitmap(Image.readBitMap(Activity_Instrument.this, R.drawable.title_xiao));
                        textView_instrument_brief.setText("\t\t\t\t\t圆号，唇振动气鸣乐器，又称法国号，英语french horn。铜管乐器，铜制螺旋形管身，漏斗状号嘴，喇叭口较大，通常有4个键。圆号被称作交响乐中的乐器之王。圆号声音柔和，丰满；和木管，弦乐器的声音能很好地融合。在交响乐队中 ，通常使用4支圆号。\n\n");
                        break;
                }
            }

        }

        //由吹界面传来参数
        if (Signal == 1) {

        }
        //由木管界面传来参数
        if (Signal == 4) {
            //获取所选木管界面下的位置
            position_wooden = Integer.parseInt(intent.getStringExtra("position_wooden"));
            switch (position_wooden) {
                case 0:
                    break;
                case 1:
                    break;
            }
        }
    }

    private void init() {
        button_specification = (ToggleButton) findViewById(R.id.button_specification);
        button_music = (ToggleButton) findViewById(R.id.button_music);
        button_skill = (ToggleButton) findViewById(R.id.button_skill);

        textView_instrument_brief = (TextView) findViewById(R.id.textView_instrument_brief);
        //kenBurnsView_instrument = (KenBurnsView) findViewById(R.id.kenBurnsView_instrument);
        //kenBurnsView_instrument.setImageResource(R.drawable.logo);
        imageView_xiao = (ImageView) findViewById(R.id.imageView_xiao);
        //
        imageView_title = (ImageView) findViewById(R.id.imageView_title);
        //
        /*imageView_back = (ImageView) findViewById(R.id.imageView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity_Instrument.this.finish();
            }
        });*/

        //
        /*imageView_back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imageView_back.getDrawable().setAlpha(150);
                } else imageView_back.getDrawable().setAlpha(255);
                return false;
            }
        });*/

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        fragmentSpecification = new FragmentSpecification_1();

        //
        fragmentMusic = new FragmentMusic_2();
        fragmentSkill = new FragmentSkill();

        button_specification.setOnCheckedChangeListener(new buttonOnCheckedChangeListener());
        button_music.setOnCheckedChangeListener(new buttonOnCheckedChangeListener());
        button_skill.setOnCheckedChangeListener(new buttonOnCheckedChangeListener());
    }

    //
    public class buttonOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            fragmentTransaction = Activity_Instrument.this.getSupportFragmentManager().beginTransaction();
            switch (buttonView.getId()) {
                case R.id.button_specification:
                    if (isChecked) {
                        button_specification.setChecked(true);
                        button_music.setChecked(false);
                        button_skill.setChecked(false);

                        linearLayout.setVisibility(View.GONE);
                        if (fragmentSpecification.isAdded())
                            fragmentTransaction.show(fragmentSpecification);
                        else fragmentTransaction.add(R.id.fragmentLayout, fragmentSpecification);
                        fragmentTransaction.hide(fragmentMusic).hide(fragmentSkill).show(fragmentSpecification);
                        fragmentTransaction.commit();
                    } else {
                        button_specification.setChecked(false);
                        if (!button_specification.isChecked() && !button_music.isChecked() && !button_skill.isChecked()) {
                            fragmentTransaction.hide(fragmentSpecification);
                            linearLayout.setVisibility(View.VISIBLE);
                            fragmentTransaction.commit();
                        }
                    }
                    break;
                case R.id.button_music:
                    if (isChecked) {
                        button_music.setChecked(true);
                        button_specification.setChecked(false);
                        button_skill.setChecked(false);
                        linearLayout.setVisibility(View.GONE);
                        if (fragmentMusic.isAdded())
                            fragmentTransaction.show(fragmentMusic);
                        else fragmentTransaction.add(R.id.fragmentLayout, fragmentMusic);
                        fragmentTransaction.hide(fragmentSpecification).hide(fragmentSkill).show(fragmentMusic);
                        fragmentTransaction.commit();
                    } else {
                        button_music.setChecked(false);
                        //判断音频是否存在
//                        if(FragmentMusic.mediaPlayer!=null){
//                            FragmentMusic.mediaPlayer.stop();
//                            FragmentMusic.mediaPlayer = null;
//                        }
                        //
                        if (!button_specification.isChecked() && !button_music.isChecked() && !button_skill.isChecked()) {
                            fragmentTransaction.hide(fragmentMusic);
                            linearLayout.setVisibility(View.VISIBLE);
                            fragmentTransaction.commit();
                        }
                    }
                    break;
                case R.id.button_skill:
                    if (isChecked) {
                        button_skill.setChecked(true);
                        button_specification.setChecked(false);
                        button_music.setChecked(false);
                        linearLayout.setVisibility(View.GONE);
                        if (fragmentSkill.isAdded()) fragmentTransaction.show(fragmentSkill);
                        else fragmentTransaction.add(R.id.fragmentLayout, fragmentSkill);
                        fragmentTransaction.hide(fragmentSpecification).hide(fragmentMusic).show(fragmentSkill);
                        fragmentTransaction.commit();
                    } else {
                        button_skill.setChecked(false);
                        //
                        FragmentSkill.videoView.pause();

                        //FragmentSkill.imageView_play.setVisibility(View.VISIBLE);

                        //Toast.makeText(Activity_Instrument.this,"视频暂停",Toast.LENGTH_SHORT).show();
                        //
                        if (!button_specification.isChecked() && !button_music.isChecked() && !button_skill.isChecked()) {
                            fragmentTransaction.hide(fragmentSkill);
                            linearLayout.setVisibility(View.VISIBLE);
                            fragmentTransaction.commit();
                        }
                    }
                    break;
            }
        }
    }

    //
    public class buttonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            linearLayout.setVisibility(View.GONE);
            fragmentTransaction = Activity_Instrument.this.getSupportFragmentManager().beginTransaction();

            switch (v.getId()) {
                case R.id.button_specification:
//                    if (fragmentSpecification.isAdded())
//                        fragmentTransaction.show(fragmentSpecification);
//                    else fragmentTransaction.add(R.id.fragmentLayout, fragmentSpecification);
//                    fragmentTransaction.hide(fragmentMusic).hide(fragmentSkill).show(fragmentSpecification);
//                    fragmentTransaction.commit();
                    new fragmentAsynctask().execute(fragmentSpecification);
                    break;
                case R.id.button_music:
//                    if (fragmentMusic.isAdded()) fragmentTransaction.show(fragmentMusic);
//                    else fragmentTransaction.add(R.id.fragmentLayout, fragmentMusic);
//                    fragmentTransaction.hide(fragmentSpecification).hide(fragmentSkill).show(fragmentMusic);
//                    fragmentTransaction.commit();
                    new fragmentAsynctask().execute(fragmentMusic);
                    break;
                case R.id.button_skill:
//                    if (fragmentSkill.isAdded()) fragmentTransaction.show(fragmentSkill);
//                    else fragmentTransaction.add(R.id.fragmentLayout, fragmentSkill);
//                    fragmentTransaction.hide(fragmentSpecification).hide(fragmentMusic).show(fragmentSkill);
//                    fragmentTransaction.commit();
                    new fragmentAsynctask().execute(fragmentSkill);
                    break;
            }
        }
    }

    //异步加载Fragment，继承AsyncTask
    class fragmentAsynctask extends AsyncTask<Fragment, Void, FragmentTransaction> {
        @Override
        protected FragmentTransaction doInBackground(Fragment... params) {
            switch (params[0].toString()) {
                case "fragmentSpecification":
                    if (params[0].isAdded()) fragmentTransaction.show(params[0]);
                    else fragmentTransaction.add(R.id.fragmentLayout, fragmentSpecification);
                    fragmentTransaction.hide(fragmentMusic).hide(fragmentSkill).show(fragmentSpecification);
                    break;
                case "fragmentMusic":
                    if (params[0].isAdded()) fragmentTransaction.show(params[0]);
                    else fragmentTransaction.add(R.id.fragmentLayout, fragmentMusic);
                    fragmentTransaction.hide(fragmentSpecification).hide(fragmentSkill).show(fragmentMusic);
                    break;
                case "fragmentSkill":
                    if (params[0].isAdded()) fragmentTransaction.show(params[0]);
                    else fragmentTransaction.add(R.id.fragmentLayout, fragmentSkill);
                    fragmentTransaction.hide(fragmentSpecification).hide(fragmentMusic).show(fragmentSkill);
                    break;
            }
            fragmentTransaction.commit();
            return fragmentTransaction;
        }

        @Override
        protected void onPostExecute(FragmentTransaction fragmentTransaction) {
            super.onPostExecute(fragmentTransaction);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //if (bitmap != null) bitmap.recycle();
        if (FragmentMusic_2.mediaPlayer != null && FragmentMusic_2.mediaPlayer.isPlaying()) {
            FragmentMusic_2.mediaPlayer.stop();
            FragmentMusic_2.mediaPlayer.release();
            FragmentMusic_2.mediaPlayer = null;
        }
        if (FragmentSkill.videoView != null) {
            FragmentSkill.videoView.resume();
            FragmentSkill.videoView = null;
        }
        System.gc();
        System.runFinalization();
        Log.i("On Destroyed!", "!!!!!!!!!!");
    }
}
