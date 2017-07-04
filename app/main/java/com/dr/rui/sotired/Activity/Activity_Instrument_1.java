package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.dr.rui.sotired.Fragment.FragmentMusic_2;
import com.dr.rui.sotired.Fragment.FragmentSkill;
import com.dr.rui.sotired.R;
import com.dr.rui.sotired.Util_Image.Image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

/*public class Activity_Instrument_1 extends Activity implements SurfaceHolder.Callback {

    public static int position_item = 0;
    public static int signal_type = 0;

    private static boolean state = true;

    private String music_url = "";
    private String music_url_1 = "";
    private String video_url = "";
    private MediaPlayer mediaPlayer;
    private ProgressDialog progressDialog;

    private TextView textView_music_name;
    private TextView textView_skill;
    private TextView textView_music;

    private ViewPager viewPager_spe;
    private PagerAdapter pagerAdapter;
    private List<View> view = new ArrayList<>();

    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    public static VideoView videoView;

    private ImageView imageView_struct_1;
    private ImageView imageView_history_1;
    private ImageView imageView_position_1;

    private ImageView imageView_instrument_struct;
    private ImageView imageView_instrument_position;
    private ImageView imageView_spe_main;

    private ImageView imageView_music_play;
    private ImageView imageView_music_forward;
    private ImageView imageView_music_pic;

    private TextView textView_instrument_name;
    private TextView textView_instrument_brief_1;
    private TextView textView_instrument_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument);
        //
        //跳转
        Intent intent = getIntent();
        position_item = Integer.parseInt(intent.getStringExtra("position_item"));
        signal_type = Integer.parseInt(intent.getStringExtra("signal_type"));

        Log.i("INFORMATION:Position:", "position_item:" + position_item);
        Log.i("INFORMATION:Position:", "signal_type::" + signal_type);
        //
        init();

        //
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return view.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(view.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view1 = view.get(position);
                container.addView(view1);
                return view1;
            }
        };
        viewPager_spe.setAdapter(pagerAdapter);

        //
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/fonts.otf");
        textView_instrument_name.setTypeface(typeFace);
        //textView_instrument_brief_1.setTypeface(typeFace);
        //textView_instrument_content.setTypeface(typeFace);

        //民族乐器类型
        if (Activity_Choice.Signal_Choice == 0) {
            //获取位置
            //position_blow = Integer.parseInt(intent.getStringExtra("position_blow"));
            //民族乐器-吹
            if (signal_type == 0) {
                switch (position_item) {
                    //民族乐器-吹-箫
                    case 0:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xiao.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xiao.mp3";
                        video_url = "http://7xkqzu.com1.z0.glb.clouddn.com/video_xiao.mp4";

                        textView_instrument_name.setText("箫");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.xiao));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_xiao));
                        //历史
                        textView_instrument_content.setText("\t\t\t箫相传为舜所造。唐代以前指多管“箫”，即“排箫”，“八音”的“竹”就是排箫的前身。现今所称“箫”，指单管箫。魏晋南北朝时，箫已用于独奏、合奏，并在伴奏相和歌的乐队中使用。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_xiao));
                        //
                        textView_skill.setText("演奏技巧：箫的演奏姿势有站式和坐式两种，演奏时一定要保持身体的自然状态。\n（一）站式\n\t\t\t\t独奏或重奏时一般采用站式。两臂自然向前，两手持箫，手指自然弯曲，胸部和腰部要直，但不能挺胸鼓肚，头部向前但不能前倾更不能后仰。双肩和双肘自然下垂，切忌耸肩。箫放在嘴上时与身体约成45度角，因为角度太小了容易低头，太大了又容易扬颈，这样不但姿势不雅，也影响呼吸。两腿站定，两脚稍稍分开，身体重心落于两腿之间。\n（二）坐式\n\t\t\t\t合奏或伴奏时一般采用坐式。坐式上半身和站式完全相同。座椅高低要合适，切忌一条腿架在另一条腿上，这样不但姿势不雅，同时也影响正常呼吸。吹箫姿势是最符合人体生理结构特点的，因此持箫最基本的原则就是要保持人体自然状态，便能很快掌握正确的演奏姿势。\n");
                        break;
                    //民族乐器-吹-笙
                    case 1:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_sheng.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_sheng.mp3";
                        video_url = "http://7xkqzu.com1.z0.glb.clouddn.com/video_changdi.mp4";
                        textView_instrument_name.setText("笙");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.sheng));
                        //
                        textView_instrument_brief_1.setText("\t\t\t笙，吹孔簧鸣乐器，起源于中国，是世界上最早使用自由簧的乐器。");
                        //
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_sheng));

                        textView_instrument_content.setText("\t\t\t笙在中国已经有几千年的历史，传说笙可以模仿凤凰的哭声，形状也很像收起翅膀的神鸟。在唐朝(公元618-907年)，笙才逐渐转变为现在的形式。  笙是从十三簧到十七簧、十九、二十三簧，由簧少到簧多而发展。在传统器乐和昆曲里，笙常常被用作其它管乐器如笛子、唢呐的伴奏，为旋律加上纯四度或纯五度和音。在现代国乐团，笙可以担当旋律或伴奏的作用。");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sheng));
                        break;
                    //民族乐器-吹-埙
                    case 2:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xun.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xun.mp3";
                        video_url = "";

                        textView_instrument_name.setText("埙");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.xun));
                        //
                        textView_instrument_brief_1.setText("\t\t\t埙，亦称“陶埙”，是汉族特有的闭口吹奏乐器，在世界原始艺术史中占有重要的地位。");

                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_sheng));

                        textView_instrument_content.setText("\t\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。为单管、竖吹，历史悠久，音色圆润轻柔，幽静典雅，适于独奏和重奏。");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sheng));
                        break;
                    //民族乐器-吹-竹笛
                    case 3:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_zhudi.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_zhudi.mp3";
                        video_url = "";
                        textView_instrument_name.setText("竹笛");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.zhudi));
                        //
                        textView_instrument_brief_1.setText("\t\t\t竹笛，木管乐器家族中的吹孔膜鸣乐器类。竹笛在独奏和合奏中都很重要，也常出现在中国民族乐队中。");
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_zhudi));

                        textView_instrument_content.setText("\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。为单管、竖吹，历史悠久，音色圆润轻柔，幽静典雅，适于独奏和重奏。");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sheng));
                        break;
                    //民族乐器-吹-唢呐
                    case 4:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_suona.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_suona.mp3";

                        textView_instrument_name.setText("唢呐");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("唢呐，双簧片木管乐器。又名喇叭，小唢呐称海笛。在台湾民间称为鼓吹，广东地区亦将之称为“八音”。");

                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_suona));

                        break;
                    //民族乐器-吹-巴乌
                    case 5:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_bawu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_bawu.mp3";

                        textView_instrument_name.setText("巴乌");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("巴乌，哈尼、彝、傣、佤、布朗等族单簧气鸣乐器。流行于云南省红河、玉溪、思茅、西双版纳、临沧、德宏等地区。");

                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_bawu));
                        break;
                    //民族乐器-吹-葫芦丝
                    case 6:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_hulusi.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_hulusi.mp3";

                        textView_instrument_name.setText("葫芦丝");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.hulusi));
                        //
                        textView_instrument_brief_1.setText("葫芦丝又称“葫芦箫”是云南少数名族特有的民族管乐器之一，主要流传于云南省滇西傣族地区。");

                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_hulusi));
                        break;
                }
            }
            //民族乐器-拉
            if (signal_type == 1) {
                switch (position_item) {
                    //民族乐器-拉-二胡
                    case 0:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_erhu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_erhu.mp3";

                        textView_instrument_name.setText("二胡");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("二胡，又名“胡琴”，是我国独具魅力的拉弦乐器。");
                        break;
                    //民族乐器-拉-高胡
                    case 1:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_gaohu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_gaohu.mp3";

                        textView_instrument_name.setText("高胡");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("高胡，民族拉弦乐器。高胡是“高音二胡”的简称，常用两腿夹着琴筒的一部分演奏。");
                        break;
                    //民族乐器-拉-板胡
                    case 2:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_banhu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_banhu.mp3";

                        textView_instrument_name.setText("板胡");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("板胡，民族拉弦乐器。音色高昂、坚实，具有很强的穿透力，是北方戏曲、说唱的主要伴奏乐器。");
                        break;
                    //民族乐器-拉-三弦
                    case 3:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_sanxian.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_sanxian.mp3";

                        textView_instrument_name.setText("三弦");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("三弦，民族拨弦乐器，又称“弦子”，侧抱于怀演奏。");
                        break;
                    //民族乐器-拉-马头琴
                    case 4:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_matouqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_matouqin.mp3";

                        textView_instrument_name.setText("马头琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("马头琴是中国少数民族——蒙古族拉弦乐器，是一种两弦的弦乐器，为蒙古族人民喜爱的乐器。");
                        break;
                }
            }
            //民族乐器-弹
            if (signal_type == 2) {
                switch (position_item) {
                    //民族乐器-弹-阮
                    case 0:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_ruan.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_ruan.mp3";

                        textView_instrument_name.setText("阮");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("阮是一种汉族传统乐器，阮咸的简称。可用于独奏、重奏和歌舞伴奏或参加民族乐队演奏。");
                        break;
                    //民族乐器-弹-琵琶
                    case 1:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_pipa.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_pipa.mp3";

                        textView_instrument_name.setText("琵琶");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("琵琶，拨弦类弦鸣乐器，是我国历史悠久的重要民族乐器，被称为“弹拨乐器之王”");
                        break;
                    //民族乐器-弹-月琴
                    case 2:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_yueqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_yueqin.mp3";

                        textView_instrument_name.setText("月琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("月琴，民族弹拨弦乐。是从阮演变而来的乐器，月琴是京剧乐队三大伴奏乐器之一。");
                        break;
                    //民族乐器-弹-柳琴
                    case 3:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_liuqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_liuqin.mp3";

                        textView_instrument_name.setText("柳琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("柳琴，弹弦乐器。又称柳叶琴，金刚腿，土琵琶。汉族传统乐器。属唐代以来在民间流传的梨形音箱弹弦乐器之一。");
                        break;
                    //民族乐器-弹-古琴
                    case 4:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_guqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_guqin.mp3";

                        textView_instrument_name.setText("古琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("古琴，民族拨弦乐器，中国最古老的弹拨乐器之一。有3千年以上历史，属于八音中的丝。");
                        break;
                    //民族乐器-弹-古筝
                    case 5:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_guzheng.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_guzheng.mp3";

                        textView_instrument_name.setText("古筝");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("古筝，民族弹拨弦乐，是汉族民族传统乐器中的筝乐器，是中国独特的、重要的民族乐器之一。");
                        break;
                }
            }
            //民族乐器-打
            if (signal_type == 3) {
                switch (position_item) {
                    //民族乐器-打-钹
                    case 0:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_bo.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_bo.mp3";

                        textView_instrument_name.setText("钹");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("钹，互击体鸣乐器，根据钹的大小及重量等不同，钹分为双光钹、水钹、京钹、小钹等几种。");
                        break;
                    //民族乐器-打-锣
                    case 1:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_luo.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_luo.mp3";

                        textView_instrument_name.setText("锣");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("锣，民族打击乐器。锣在中国的民族乐队中占有非常重要的地位，而且应用范围很广泛。");
                        break;
                    //民族乐器-打-排鼓
                    case 2:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_paigui.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_paigu.mp3";

                        textView_instrument_name.setText("排鼓");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("排鼓，鼓类乐器的新品种，属于打击乐器。");
                        break;
                    //民族乐器-打-大鼓
                    case 3:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/dagu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_dagu.mp3";

                        textView_instrument_name.setText("大鼓");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("大鼓是民族打击乐器，属于双面膜鸣乐器，古往今来，大鼓一直成为各族人民喜爱的民间乐器。");
                        break;
                    //民族乐器-打-木鱼
                    case 4:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_muyu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_muyu.mp3";

                        textView_instrument_name.setText("木鱼");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("木鱼，打击乐器,原为佛教“龚吹”（宗教歌曲）的民族乐器。");
                        break;
                    //民族乐器-打-扬琴
                    case 5:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_yangqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_yangqin.mp3";

                        textView_instrument_name.setText("扬琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("扬琴，民族击弦乐器，是中国民族乐队中必不可少的乐器，与钢琴同宗。");
                        break;
                }
            }

*/
public class Activity_Instrument_1 extends Activity implements SurfaceHolder.Callback {

    public static int position_item = 0;
    public static int signal_type = 0;

    private static boolean state = true;

    private String music_url = "";
    private String music_url_1 = "";
    private String video_url = "";    private MediaPlayer mediaPlayer;
    private ProgressDialog progressDialog;

    private TextView textView_music_name;
    private TextView textView_skill;

    private ViewPager viewPager_spe;
    private PagerAdapter pagerAdapter;
    private List<View> view = new ArrayList<>();

    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    public static VideoView videoView;

    private ImageView imageView_struct_1;
    private ImageView imageView_history_1;
    private ImageView imageView_position_1;

    private ImageView imageView_instrument_struct;
    private ImageView imageView_instrument_position;
    private ImageView imageView_spe_main;

    private ImageView imageView_music_play;
    private ImageView imageView_music_forward;
    private ImageView imageView_music_pic;

    private TextView textView_instrument_name;
    private TextView textView_instrument_brief_1;
    private TextView textView_instrument_content;
    private TextView  textView_music1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument);
        //
        //跳转
        Intent intent = getIntent();
        position_item = Integer.parseInt(intent.getStringExtra("position_item"));
        signal_type = Integer.parseInt(intent.getStringExtra("signal_type"));

        Log.i("INFORMATION:Position:", "position_item:" + position_item);
        Log.i("INFORMATION:Position:", "signal_type::" + signal_type);
        //
        init();

        //
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return view.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(view.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view1 = view.get(position);
                container.addView(view1);
                return view1;
            }
        };
        viewPager_spe.setAdapter(pagerAdapter);

        //
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/fonts.otf");
        textView_instrument_name.setTypeface(typeFace);
        //textView_instrument_brief_1.setTypeface(typeFace);
        //textView_instrument_content.setTypeface(typeFace);

        //民族乐器类型
        if (Activity_Choice.Signal_Choice == 0) {
            //获取位置
            //position_blow = Integer.parseInt(intent.getStringExtra("position_blow"));
            //民族乐器-吹
            if (signal_type == 0) {
                switch (position_item) {
                    //民族乐器-吹-箫
                    case 0:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xiao.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xiao.mp3";
                        video_url = "http://7xkqzu.com1.z0.glb.clouddn.com/video_xiao.mp4";

                        textView_instrument_name.setText("箫");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.xiao));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_xiao));
                        //历史
                        textView_instrument_content.setText("\t\t\t箫相传为舜所造。唐代以前指多 管“箫”，即“排箫”，“八音”的“竹”就是排箫的前身。现今所称“箫”，指单管箫。魏晋南北朝时，箫已用于独奏、合奏，并在伴奏相和歌的乐队中使用。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_xiao));
                        //
                        textView_skill.setText("演奏技巧：箫的演奏姿势有站式和坐式两种，演奏时一定要保持身体的自然状态。\n（一）站式\n\t\t\t独奏或重奏时一般采用站式。两臂自然向前，两手持箫，手指自然弯曲，胸部和腰部要直，但不能挺胸鼓肚，头部向前但不能前倾更不能后仰。双肩和双肘自然下垂，切忌耸肩。箫放在嘴上时与身体约成45度角，因为角度太小了容易低头，太大了又容易扬颈，这样不但姿势不雅，也影响呼吸。两腿站定，两脚稍稍分开，身体重心落于两腿之间。\n（二）坐式\n\t\t\t\t合奏或伴奏时一般采用坐式。坐式上半身和站式完全相同。座椅高低要合适，切忌一条腿架在另一条腿上，这样不但姿势不雅，同时也影响正常呼吸。吹箫姿势是最符合人体生理结构特点的，因此持箫最基本的原则就是要保持人体自然状态，便能很快掌握正确的演奏姿势。\n");
                        break;
                    //民族乐器-吹-笙
                    case 1:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_sheng.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_sheng.mp3";
                        video_url = "http://7xpbat.com1.z0.glb.clouddn.com/video_sheng.mp4";
                        textView_instrument_name.setText("笙");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.sheng));
                        //
                        textView_instrument_brief_1.setText("\t\t\t笙是由笙苗中簧片发声，吹气及吸气皆能发声，能奏和声。可分成高音笙、中音笙、低音笙、传统笙。\n\t\t\t笙的构造比较复杂。它是由笙斗、吹嘴、笙苗（又称笙管）、笙角、簧片和腰箍等部件组成。 笙斗圆形，笙斗和吹嘴铜制，焊接后合为一体。笙管上端有长方形或亚铃形出音孔，下开圆形按音孔，下端与笙角相接。");
                        //
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_sheng));

                        textView_instrument_content.setText("\t\t\t笙在中国已经有几千年的历史，传说笙可以模仿凤凰的哭声，形状也很像收起翅膀的神鸟。在唐朝(公元618-907年)，笙才逐渐转变为现在的形式。  笙是从十三簧到十七簧、十九、二十三簧，由簧少到簧多而发展。在传统器乐和昆曲里，笙常常被用作其它管乐器如笛子、唢呐的伴奏，为旋律加上纯四度或纯五度和音。在现代国乐团，笙可以担当旋律或伴奏的作用。\n");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sheng));

                        textView_skill.setText("演奏技巧：演奏笙时，两手手掌将笙斗托住，右手中指和无名指插进笙苗的马蹄形缝隙中，用7个手指（右手4个、左手3个）按孔。每个手指兼管几个按孔，手指动作要灵敏，按孔要严密。笙的演奏技巧分为手指技巧和口内技巧，可奏出单音、和弦、抹音、滑音、顿音、花舌、呼舌、揉音和喉音等技巧，在笙上吹奏颤音是比较困难的。\n");

                        break;
                    //民族乐器-吹-埙
                    case 2:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xun.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xun.mp3";
                        video_url = "http://7xpbat.com1.z0.glb.clouddn.com/Xun.mp4";

                        textView_instrument_name.setText("埙");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.xun));
                        //
                        textView_instrument_brief_1.setText("\t\t\t埙，亦称“陶埙”，是汉族特有的闭口吹奏乐器，在世界原始艺术史中占有重要的地位。");

                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_sheng));

                        textView_instrument_content.setText("\t\t\t埙是中国最古老的吹奏乐器之一，大约有七千年的历史，起源与汉族先民的劳动生产活动有关，最初可能是先民们模仿鸟兽叫声而制作，用以诱捕猎物。后随社会进步而演化为单纯的乐器，并逐渐增加音孔，发展成可以吹奏曲调的旋律乐器。最初埙大多是用石头和骨头制作的，后来发展成为陶制的，形状也有多种，如扁圆形、椭圆形、球形、鱼形和梨形等，其中以梨形最为普遍。\n");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sheng));
                        textView_skill.setText("演奏技巧：埙的吹奏技巧可分为气吹和舌吹两类，然后和指法技巧构成了它的演奏技巧。\n\t\t\t\t气类吹奏技巧\n\t\t\t\t埙的气类吹奏技巧有长音、气震音、唇振音等，其中长音是埙吹奏技巧的基础，必须饱满圆润，响亮平稳无杂音。埙的常用技巧汇总起来可分为气、指、舌三大类：包括长音、气震音、指震音、唇震音、颤音、滑音、吐音、打音、空打音、循环换气、双吐循环换气、虚吹音等多种。\n\t\t\t\t 舌类吹奏技巧\n\t\t\t\t吐音是埙的一种常用演奏技巧。适于演奏热情欢快、激昂活泼的曲调，要求声音结实、干净、有弹性，节奏要均匀平稳。吐音分单吐音（包括单外吐、单内吐）、双吐、轻吐、气吐、唇吐等多种。\n\t\t\t\t单外吐（标记T）在保持正确吹奏口形的基础上舌头自然向上，微贴上唇内沿，呼气时迅速后缩，使气流冲入吹孔发出短促有力之声，类似“吐”音。\n\t\t\t\t单内吐（标记K）在保持正确吹奏口形的基础上，舌根部后缩堵住上腭，呼气时舌根部迅速前送，使气流冲入吹孔而发出短促有力之声，类似“库”音。\n\t\t\t\t双吐就是结合单内吐和单外吐，速度比单吐快一倍，其音类似“吐库”或“库吐”，适于演奏欢快、激昂的曲调。　吐音要求声音结实、干净、有弹性，节奏要均匀平稳。\n");
                        break;
                    //民族乐器-吹-竹笛
                    case 3:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_zhudi.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_zhudi.mp3";
                        video_url = "";
                        textView_instrument_name.setText("竹笛");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.zhudi));
                        //
                        textView_instrument_brief_1.setText("\t\t\t\t竹笛，木管乐器家族中的吹孔膜鸣乐器类。竹笛在独奏和合奏中都很重要，也常出现在中国民族乐队中。");
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_zhudi));

                        textView_instrument_content.setText("\t\t\t\t竹笛出现在中国汉代（公元前206年-公元220年），可能与中国早期乐器篪（chi）有关。\n");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sheng));
                        textView_skill.setText("演奏技巧：嘴唇自然闭合，双手捧着笛子两端，左手握笛头，右手握笛尾，将吹孔置于下嘴唇下沿，对准吹孔吹气。当气息冲出时，只让出小空隙使气息通过，并使成为一束气柱往吹孔下方斜着吹去。为使气息冲出时不将两唇冲开，而致气息散掉，两颊肌肉必须用劲，保持气息的出口很小。\n");
                        break;
                    //民族乐器-吹-唢呐
                    case 4:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_suona.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_suona.mp3";
                        video_url = "";
                        textView_instrument_name.setText("唢呐");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_content.setText("公元3世纪，唢呐由波斯、阿拉伯一带传入中国。西晋时期，新疆拜城克孜尔石窟第38窟中的伎乐壁画已有吹奏唢呐形象。在金、元时期，传到中国中原地区。曾译作“锁呐”“销呐”“苏尔奈”“锁奈”“唆哪”等名。明代后期，唢呐已在戏曲音乐中占有重要地位，用以伴奏唱腔、吹奏过场曲牌。而在以戏曲音乐为基础的民间器乐中，唢呐也成为离不开的乐器。到了近现代，唢呐成为中国各族人民使用颇广的乐器之一。2006年5月20日，唢呐艺术经国务院批准列入第一批国家级非物质文化遗产名录。\n");
                        textView_instrument_brief_1.setText("唢呐，双簧片木管乐器。又名喇叭，小唢呐称海笛。在台湾民间称为鼓吹，广东地区亦将之称为“八音”。");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sheng));
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_suona));
                        textView_skill.setText("演奏技巧：演奏唢呐往往比较费气，音越高耗的气量也就越大。“循环换气法”是最常见的演奏方法，这样的吹奏能使得气息总是饱满不息，可以使乐音不间断地长时间延续，甚至全曲一气呵成。吹奏唢呐，也需要一些技巧，要用手指把音孔完全按满。倘若音孔按不严，往往发出的声音就不准。唢呐的演奏技巧极为丰富，大致可分为口内技巧和手指技巧，在演奏中常常两者结合运用，其中有连奏、单吐、双吐、三吐、弹音、花舌、萧音、滑音、颤音、叠音和垫音等，还可以模仿飞禽和昆虫的鸣叫。\n");

                        break;
                    //民族乐器-吹-巴乌
                    case 5:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_bawu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_bawu.mp3";
                        video_url = "http://7xpbat.com1.z0.glb.clouddn.com/Bawu.mp4";
                        textView_instrument_name.setText("巴乌");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("巴乌，哈尼、彝、傣、佤、布朗等族单簧气鸣乐器。流行于云南省红河、玉溪、思茅、西双版纳、临沧、德宏等地区。");
                        textView_instrument_content.setText("巴乌流行于云南省红河、文山、思茅、西双版纳、临沧、德宏、广西壮族自治区融水、贵州省/黔东南和黔南等地。\n\t\t\t\t传统的巴乌，音域窄、音量小，但音色优雅。解放后几十年间，巴乌的研制改革工作一直在进行着，经过改革加键的巴乌，在保持传统巴乌浑厚柔美音色的前提下，扩大了音域、音量，并且还能调微，能转四个调，能奏出各种滑音、打音、吐音、颤音、飞指、抹音等技巧音。巴乌的创作曲目也更为开拓，它不仅可以演奏传统的地方风格曲目，还可移植外国乐曲，如日本的《北国之春》等。近几十年来，巴乌经专业工作者的不断改革，音色不变，音域扩大，音量增加，适于演奏宽广、抒情的音调。合奏时，它也可以作为高音乐器与低音乐器的桥梁。\n");
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_bawu));
                        textView_skill.setText("演奏技巧：演奏时，管身粗而长者横吹，细而短者竖吹。竖吹口含簧片，横吹将簧片置两唇间，右手食指、中指、无名指分别横按两管上三孔， 左手食指、中指、无名指分别横按两管下三孔，吹气鼓簧按孔发音，气流振动簧片并激发管内空气柱共鸣，用吐音方法吹奏，有滑音、打音、颤音、抹音、琶音、飞指等技巧，可用循环换气法奏长时值音符。\n");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sheng));
                        break;
                    //民族乐器-吹-葫芦丝
                    case 6:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_hulusi.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_hulusi.mp3";
                        video_url = "http://7xpbat.com1.z0.glb.clouddn.com/Hulusi.mp4";
                        textView_instrument_name.setText("葫芦丝");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.hulusi));
                        //
                        textView_instrument_brief_1.setText("\t\t\t葫芦丝又称“葫芦箫”是云南少数名族特有的民族管乐器之一，主要流传于云南省滇西傣族地区。");
                        textView_instrument_content.setText("\t\t\t葫芦丝的历史较为悠久，其渊源可追溯到先秦时代，它是由葫芦笙演进改造而成的。\n\t\t\t新中国成立后，中国民族音乐工作者对葫芦箫进行了不断的改革。1958年，云南省歌舞团首先把音域扩展为14个音。\n");

                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_hulusi));
                        textView_skill.setText("演奏技巧：\t\t\t演奏方法\n\t\t\t（一）右手无名指、中指、食指用第一节指肚分别开闭第一、二、三个音孔，拇指拖于主管下方。左手无名指、中指、食指用第一节指肚分别开闭，第四、第五、第六音孔，拇指开开位于主管前下方的第七音孔。\n\t\t\t（二）深呼吸、吸入的气尽可能多一些，吸气后、气息下沉，使气流在有控制的情况下有节制的均匀向外呼出，气息要平稳、不可忽强忽弱。\n\t\t\t\t（三）吹奏中， 高音时要用缓吹法（气流减小）低音时要用急吹法（气流加强）。\n");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sheng));
                        break;
                }
            }
            //民族乐器-拉
            if (signal_type == 1) {
                switch (position_item) {
                    //民族乐器-拉-二胡
                    case 0:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_erhu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_erhu.mp3";
                        video_url = "http://7xpbat.com1.z0.glb.clouddn.com/erhu.mp4";

                        textView_instrument_name.setText("二胡");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.erhu));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t二胡，又名“胡琴”，是我国独具魅力的拉弦乐器。根据琴筒情况分为四类：圆筒二胡、八角二胡、六角二胡、扁筒二胡。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_erhu));
                        //历史
                        textView_instrument_content.setText("\t\t\t二胡全长约66cm，木制琴身，中间部分是蛇皮，琴弦是丝绸或者动物的肠子。依靠琴弦的振动发声，琴筒是二胡的共鸣箱，琴杆是支撑琴弦、接指操作的重要支柱。二胡的定弦音高主要是靠琴轴来调节的，即拧转线轴来绷紧或放松弦，紧则音高，松则音低。\n\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_erhu));
                        //
                        textView_skill.setText("演奏技巧：\n\t\t\t左手持琴，以“虎口”骑在琴杆上，拇指略微弯曲，掌心成悬空状。整个左手应放松，小臂自然下垂，与琴杆大约构成45度左右的角度。二胡的演奏技巧是比较丰富的，主要分为指法和弓法两大类，有滑音、揉弦、颤音、跳弓、顿弓、拨弦等。\n");
                        break;
                    //民族乐器-拉-高胡
                    case 1:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_gaohu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_gaohu.mp3";
                        video_url = "http://7xpbat.com1.z0.glb.clouddn.com/gaohu.mp4";

                        textView_instrument_name.setText("高胡");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.gaohu));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t高胡由琴头，弦轴，千斤，琴杆，琴筒，托板，弓杆，弓弦，弓马尾等部分组成。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_gaohu));
                        //历史
                        textView_instrument_content.setText("\t\t\t起源于清朝末年的广东粤剧、潮剧过场音乐、民族和曲艺音乐。吕文成先生对二胡进行了改革，将丝弦改成钢弦，提高了乐器的定弦，同时首创了两腿夹着琴筒的适当部位进行演奏的独特方法。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_gaohu));
                        //
                        textView_skill.setText("演奏技巧：\n\t\t\t右手弓法多奏分弓，快速弓法用得较多。奏强拍时，多用推弓。左手指法主要由滑音和旋律中自由的垫指加花。广东音乐传统奏法，左手不用揉弦，而用压按弦和空弦震音。在演奏高胡时，演奏者两腿夹紧，用以控制音量及减少噪音。\n");
                        break;
                    //民族乐器-拉-板胡
                    case 2:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_banhu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_banhu.mp3";
                        video_url = "http://7xpbat.com1.z0.glb.clouddn.com/banhu.mp4";
                        textView_instrument_name.setText("板胡");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.banhu));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t板胡由内外弦轴、千金、琴杆、弓杆、弓毛、内外弦、码子、琴托、飘面、弦座构成。\n");
                        //结构图
                       /* imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_banhu));待加*/
                        //历史
                        textView_instrument_content.setText("\t\t\t板胡在中国大约有300多年的历史，它的名称是因为琴筒用薄木板粘成而得名的。最初，板胡主要流行于中国的北方地区，当地的许多地方戏曲和曲艺，比如像豫剧、河北梆子、评剧、秦腔等都是用板胡作为主要伴奏乐器的。新中国成立以后，在音乐工作者和乐器制作者的努力下，板胡的制作技术也有了很大的发展，使许多新品种加入了“板胡家族”。板胡得到很好的发展。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_gaohu));
                        //
                        textView_skill.setText("演奏技巧：\n\t\t\t平腿式,身体坐下，两腿自然分开，左脚稍向前，右脚靠后，板胡放在左大腿弯曲处稍外。这种姿势优点在于全身重心下移，腰腿部负担较小，演奏时活动范围大。\n\t\t\t架腿式，左腿架在右腿上或右腿架在左腿上，板胡放置于两腿与小腹交叉之间，这种演奏姿势是先辈秦腔板胡演奏琴师所推崇的，它的演奏效果也是有其长处的。重心稳定集中，和平腿式比较，各有特色。\n");
                        break;
                    //民族乐器-拉-三弦
                    case 3:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_sanxian.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_sanxian.mp3";
                        video_url = "http://7xpbat.com1.z0.glb.clouddn.com/sanxian.mp4";
                        textView_instrument_name.setText("三弦");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.sanxian));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t三弦柄很长，音箱方形，两面蒙皮，弦三根，三弦可分为琴头、琴杆和琴鼓三部分,由琴头、弦轴、山口、琴杆、鼓框、皮膜、琴马和琴弦等组成。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_sanxian));
                        //历史
                        textView_instrument_content.setText("\t\t\t秦朝时称为“弦鼗”。清毛其龄《西河词话》：“三弦起于秦时，本三十鼓鼓之制而改形易响，谓之鼓鼓，唐时乐人多习之，世以为胡乐，非也”。 三弦是北方大鼓书、苏州评弹等传统曲艺不可缺少的乐器。在南管音乐中，属于上四管乐器之一，是演出的基本组合。中国的三弦传入琉球后发展成三线；三线传入日本后，发展成三味线。在日本有把“三味线”称为“三弦”的习惯。\n\t\t\t中国汉族传统弹拨乐器，现代三弦是在传统三弦基础上改进而来，大三弦分60型、80型大三弦，分别于1960年和1980年研制成功，故而得名。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_sanxian));
                        //
                        textView_skill.setText("坐奏，琴身放在右大腿上，左手按把位，琴身呈45度。三弦弹奏方式，依大小三弦不同作区分，通常小三弦是使用拨片拨奏，大三弦戴假指甲弹奏。有弹、挑、双弹、双挑、扫、轮、搓等。\n");
                        break;
                    //民族乐器-拉-马头琴
                    case 4:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_matouqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_matouqin.mp3";
                        video_url = "http://7xpbat.com1.z0.glb.clouddn.com/matouqin.mp4";
                        textView_instrument_name.setText("马头琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.matouqin));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t马头琴由共鸣箱、琴头、琴杆、弦轴、琴马、琴弦和琴弓等部分组成。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_matouqin));
                        //历史
                        textView_instrument_content.setText("\t\t\t马头琴的历史悠久，从唐宋时期拉弦乐器奚琴发展演变而来。成吉思汗时（1155—1227）已流传民间。据《马可波罗游记》载，12世纪鞑靼人（蒙古族前身）中流行一种二弦琴，可能是其前身。明清时期用于宫廷乐队。马头琴是蒙古民族的代表性乐器，不但在中国和世界乐器在家族中占有一席之地，而且也是民间艺人，牧民家中所喜欢的乐器，马头琴所演奏的乐曲，具有深沉粗犷，激昂的特点，体现了蒙古民族的生产、生活和草原风格。\n");

                        //imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_gaohu));

                        textView_skill.setText("右手执弓时，以虎口夹住弓柄，食指、中指放在弓杆上，无名指和小指控制弓毛。右手弓法有长弓、半弓、短弓、跳弓、连弓、连跳弓、顿弓、打弓、击弓、碎弓和抖弓等，左手指法有弹音、挑音、颤音、打音、滑音、双音、拨弦、揉弦和泛音等技巧，许多装饰音都是由小指奏出的。\n");
                        break;
                }
            }
            //民族乐器-弹
            if (signal_type == 2) {
                switch (position_item) {
                    //民族乐器-弹-阮
                    case 0:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_ruan.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_ruan.mp3";

                        textView_instrument_name.setText("阮");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.ruan));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t阮由琴头、琴颈、琴身、弦轴、山口、琴品、琴码、缚弦和琴弦等部分组成。\n\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_ruan));
                        //历史
                        textView_instrument_content.setText("\t\t\t阮源于中亚，通过龟兹传入我国，在汉时称为秦琵琶，晋代阮咸擅弹此琴。元代，阮在民间广泛流传，成为人们喜爱的弹拨乐器。建国后，阮的改革和演奏艺术发展很快。20世纪50年代对阮进行了一系列改革，使阮具有高音、中音、次中音和低音4个声部，而自成一族。研制的新大阮，增大了共鸣箱和面、背板的拱度，加长了琴杆，面、背板的厚度由中央向四周逐渐减薄，面板里面粘贴“V”形音梁和周边挖“U”形槽，音孔改为对称的鸟形，造型美观，发音坚实、宏亮，音色纯厚圆润，显著增强了表现力，可供独奏使用。\n\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_ruan));

                        textView_skill.setText("右手的指法有弹、挑、勾、抹、扣、划、轮、拂、分、摇、扫、滚等30多种，左手指法也有泛、打、带、滑、推、拉、吟、纹等10多种，显著提高了阮的艺术表现力。\n");
                        break;
                    //民族乐器-弹-琵琶
                    case 1:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_pipa.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_pipa.mp3";

                        textView_instrument_name.setText("琵琶");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.pipa));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t琵琶为木制，音箱呈半梨形，上装四弦，原先是用丝线，现多用钢丝、钢绳、尼龙制成。颈与面板上设用以确定音位的“相”和“品” 。演奏时拨动琴弦使琴弦振动发声，通过共鸣箱放大音源。\n\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_pipa));
                        //历史
                        textView_instrument_content.setText("\t\t\t琵琶已经有二千多年的历史。最早被称为“琵琶”的乐器约在中国秦朝出现。历史上的所谓琵琶，并不仅指具有梨形共鸣箱的曲项琵琶，而是多种弹拨乐器的总称。其名“琵”，“琶”是根据演奏这些乐器的右手技法而来的。也就是说琵和琶原是两种弹奏手法的名称，琵是右手向前弹，琶是右手向后挑。到了南北朝时，从西域传来了一种梨形音箱、曲颈、四条弦的乐器，有人就把它和中国的琵琶结合起来，改制成新式琵琶。到了唐代（公元7-9世纪）琵琶的发展出现了一个高峰。当时上至宫廷乐队, 下至民间演唱都少不了琵琶, 随成为当时非常盛行的乐器, 而且在乐队处于领奏地位。经历代演奏者的改进，至今形制已经趋于统一，成为六相二十四品的四弦琵琶。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_pipa));

                        textView_skill.setText("琵琶演奏时左手各指按弦于相应品位处，右手戴赛璐璐（或玳瑁）等材料制成的假指甲拨弦发音。右手有弹、挑、夹弹、滚、双弹、轮等指法，左手有揉、吟、带起、捺打、等技巧。可演奏多种和音、和弦。\n");
                        break;
                    //民族乐器-弹-月琴
                    case 2:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_yueqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_yueqin.mp3";

                        textView_instrument_name.setText("月琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yueqin));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t月琴是琴弦振动发声，音箱呈满圆形，琴脖短小。全长62、音箱直径36.3厘米。琴颈和音箱边框用红木、紫檀木制，边框用六块规格一致的木板胶接而成，面板和背板桐木制。琴弦用丝弦、尼龙弦或尼龙缠钢丝弦。以钢丝尼龙弦的效果最好。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_yueqin));
                        //历史
                        textView_instrument_content.setText("\t\t\t起源于汉代，早在汉武帝时(公元前140年—前87年)，我国汉族已经创造发明了阮，但当时这种以“弹”和“挑”为主要演奏手法的乐器，都笼统地称为琵琶。月琴是从阮演变而来的乐器。当时月琴的形制与阮相近，后来逐渐变化。自晋代起就在民间流行，约从唐代起就有月琴之名，取其形圆似月、声如琴\n");

                        //imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_gaohu));

                        textView_skill.setText("演奏月琴时，将琴斜抱于胸前，左手持琴按弦，右手用食指或执拨片弹拨琴弦发音。月琴的演奏技巧很丰富，但通常右手为弹、拨、撮、长轮、扫弦等方法，左手为推、拉、揉、移指等方法。\n");
                        break;
                    //民族乐器-弹-柳琴
                    case 3:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_liuqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_liuqin.mp3";

                        textView_instrument_name.setText("柳琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.liuqin));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t柳琴的外形、构造、奏法均与琵琶相似。最早用柳木制，二或三弦。七或十品位，音域一个半八度。用细竹筒套于食指上弹奏。发声原理是手指拨弦而使琴弦产生振动。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_liuqin));
                        //历史
                        textView_instrument_content.setText("\t\t\t最早的柳琴，构造较简单，只有两条丝弦，7个用高粱秆做成的品位，音域很窄，仅有一个半八度，还不便转调。1958年底，第一代新型柳琴－－三弦柳琴诞生了。三弦柳琴由原来的两根弦变成了三根弦，音柱也由7个增加到24个。70年代，出现了第二代新型柳琴－－四弦高音柳琴。第二代新型柳琴除了在琴弦和音柱的数量上又有所增加外，最主要的变化是用竹子代替了高粱秆，用钢丝代替了丝弦。这些改革大大改善了柳琴各方面的性能，丰富了表现力。从而使柳琴结束了200余年来仅仅作为伴奏乐器的历史，走上了独奏乐器的发展道路。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_liuqin));

                        textView_skill.setText("演奏柳琴时，奏者端坐，将琴斜置于胸前，左手持琴按弦，右手执拨弹奏。演奏技巧右手有弹、挑、双弹、双挑、扫拂和轮奏等，左手有吟弦、打弦、带弦、推拉弦和泛音等，其指法符号均与琵琶的指法符号相同。柳琴可以演奏各种度数的和音与和弦。自然泛音灵敏清晰，效果良好。它的震音奏法也具特色，强奏时紧张热烈；弱奏时安静甜美。\n");
                        break;
                    //民族乐器-弹-古琴
                    case 4:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_guqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_guqin.mp3";

                        textView_instrument_name.setText("古琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.liuqin));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t琴一般长约三尺六寸五（约120—125公分），象征一年三百六十五天（一说象周天365度）。一般宽约六寸（20公分左右），厚约二寸（6公分左右）。琴体下部扁平，上部呈弧形凸起，分别象征天地，与古时的天圆地方之说相应。整体形状依凤身形而制成，其全身与凤身相应。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_liuqin));
                        //历史
                        textView_instrument_content.setText("\t\t\t19世纪20年代起为了与钢琴区别而改称古琴。初为5弦，汉朝起定制为7弦，且有标志音律的13个徽，亦为礼器和乐律法器。古琴是汉文化中地位最崇高的乐器，位列中国传统文化四艺“琴棋书画”之首，被文人视为高雅的代表，亦为文人吟唱时的伴奏乐器，自古以来一直是许多文人必备的知识和必修的科目。伯牙、钟子期以“高山流水”而成知音的故事流传至今；琴台被视为友谊的象征，大量诗词文赋中有琴的身影。2003年11月7日，古琴艺术被联合国教科文组织列入世界第2批人类非物质文化遗产代表作名录。2006年5月20日，中华人民共和国国务院将古琴列入第1批国家级非物质文化遗产名录，划分在“民间音乐”类，编号Ⅱ—34。");

                        //imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_gaohu));

                        textView_skill.setText("古琴的演奏以左手按弦取音，以右手弹弦出音。左手按弦之指的不同和手指按弦部位的不同均可造成音色的差异。左手按弦除偶用中指与食指外，最常用的是名指与大指；其按弦的部位亦有肉按与甲肉相半之按两种。一般说来，名指按弦其音温厚稳实，大指则清脆明亮；肉按者温厚稳实，甲肉相半者则清脆明亮。就右手的弹弦来说，其强弱变化的幅度十分宽广。由于古琴有效弦长，振幅广阔，故同样一种弹弦技法，可以弹出极轻柔飘忽的音，同时也可以弹出非常沉重刚烈的音，这全凭演奏者使用的力度如何。\n");
                        break;
                    //民族乐器-弹-古筝
                    case 5:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_guzheng.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_guzheng.mp3";

                        textView_instrument_name.setText("古筝");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.guzheng));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t筝主要由面板，底板、边板、筝首、筝尾、岳山、雁柱、琴钉、出音孔和筝弦等部位组成。筝的优劣取决于各部件材料质地及制作工艺。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_guzheng));
                        //历史
                        textView_instrument_content.setText("\t\t\t古筝是一件古老的民族乐器。唐宋时有弦十三根，后最多增至二十五弦。目前最常用的规格为21弦。通常古筝的型号用S163-21，S代表S形岳山，是筝父徐振高发明。163代表古筝长度为163厘米，21代表古筝弦数21根。自秦、汉以来，古筝从我国西北地区流传到全国各地，在不同地域逐渐形成了各具浓郁地方特色的九个流派，分别为：山东筝、河南筝、潮州筝、客家筝、浙江筝、福建筝、内蒙筝（即雅托葛）、朝鲜族的伽揶琴（即延边筝）和被称为真秦之声的陕西筝。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_guzheng));

                        textView_skill.setText("传统的常用演奏采用右手大、食、中、无名四指拨弦，弹奏旋律、掌握节奏，左手在筝柱左侧顺应弦的张力，控制弦音的变化，以调整音高、完善旋律。古筝的指法颇多，右手有勾、托、劈、挑、抹、剔、打、摇、撮等，左手有按、滑、揉、颤等。\n");
                        break;
                }
            }
            //民族乐器-打
            if (signal_type == 3) {
                switch (position_item) {
                    //民族乐器-打-钹
                    case 0:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_bo.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_bo.mp3";

                        textView_instrument_name.setText("钹");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.bo));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t钹用响铜制成，呈圆片形，中央半球形部分称碗或帽，碗根至钹片部分叫堂。两面为一副，相击后振动发音，声音洪亮浑厚。");
                        //结构图
                        //imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_bo));
                        //历史
                        textView_instrument_content.setText("\t\t\t钹源于西亚，最早在埃及、叙利亚，以后在波斯、罗马等古国都有流传；在东方，先见于印度，后而中亚，据《北帝书.神武记》记载，钹大约是在公元350年左右，随《天竺乐》传入我国中原。南北朝时有钹，6世纪初期，铜钹在北魏民间已很流行，并很早就在梵乐中使用。明清后成为戏曲的重要伴奏乐器。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_bo));

                        textView_skill.setText("演奏时，双手各持一面互击。有轻击、重击、磨击、扑击等手法。另有单击音，用小棰敲击单片钹沿，获其特殊音响效果，演唱者右手执钹，拇指上套一瓷环，可碰击钹的边缘作响，左手持一小棍敲击，以击节说唱。\n");
                        break;
                    //民族乐器-打-锣
                    case 1:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_luo.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_luo.mp3";

                        textView_instrument_name.setText("锣");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.luo));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t锣结构简单，由锣体、锣架(锣绳)、锣棰三部分组成。锣体铜制，因用“响铜”制成，故也有“响器”之称。锣体呈一圆盘形，四周以本身边框固定，用锣棰敲击中央部分振 动发音。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_luo));
                        //历史
                        textView_instrument_content.setText("\t\t\t最早使用铜锣的是居住在中国西南地区的少数民族，云南是中国古代铜鼓的发祥地。到了公元前二世纪左右，铜锣在战争中应用比较广泛，中国古代的军事术语“鸣金收兵”中的“金”就是古代铜锣的别称。到了宋代，锣在民间音乐形式“ 鼓板”中被应用。到了元代，除民间的迎赛神社常常鸣锣外，锣还是杂剧的主要伴奏乐器。近百年来，锣在地方戏曲、民间音乐、民间娱乐和节庆活动中被广泛应用。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_luo));

                        textView_skill.setText("大锣发音较低，锣边 钻孔系绳，左手提起或挂于架上，右手执棰击奏；小锣发音较高，锣面呈坡形，锣脐分大、中、小三种，有高音、中音和低音之分，锣边无孔，不系锣绳，以左手食指关节处提锣内缘 ，右手执锣板击奏；掌锣是锣中最小的一种，锣面平坦无脐，形如盘状，置于左手掌中，右手执锣板击奏；云锣是锣中可演奏旋律的乐器，由十面小锣组成，用绳系于木架上，左手执 架柄，右手用锣棰击奏 。\n");
                        break;
                    //民族乐器-打-排鼓
                    case 2:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_paigui.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_paigu.mp3";

                        textView_instrument_name.setText("排鼓");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.paigu));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t排鼓由鼓皮、鼓胆、鼓架、鼓棒组成。排鼓由五个大小不同、发音有别的鼓组成一套。鼓身高29至33.3厘米，上口面直径16.7至37厘米，下口面直径11.7至37厘米。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_paigu));
                        //历史
                        textView_instrument_content.setText("\t\t\t范晔的《后汉书·马援传》中有：“援好骑，善别名马，于交趾得骆越排鼓。” 这是对排鼓的最早记载。晋人裴渊在《广州记》中写道：“俚僚铸铜为鼓，鼓唯高大为贵， 面阔丈余。”房玄龄《晋书·南史》：“广州夷人，宝贵排鼓。”当时的广州地域很大，包括今两广绝大部分。骆越系秦汉以前百越民族中的一个部族，即今之壮族。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_paigu));

                        textView_skill.setText("排鼓的击鼓要领和动作与大鼓相同。手指、腕、臂的力量协调运动的发力之源来自腰部。换言之，腰部力量是敲击排鼓的发力之源。“人之驱，腰为中”腰部在行走，立走时起着平衡身体的作用，而发力时，则反映在大脑指挥下的力量储备，腰部力量为发力点。并使鼓皮自上而下地充分振动，（似乎要让大地发出声音，这就是通常所说的把声音打透）。用力方式主要体现于形式不同的触击速度；传力方式主要体现于触击手指或手部的支撑形式，这都是决定击鼓速度的关键的因素。\n");
                        break;
                    //民族乐器-打-大鼓
                    case 3:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/dagu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_dagu.mp3";

                        textView_instrument_name.setText("大鼓");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.dagu));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t大鼓是民族打击乐器，属于双面膜鸣乐器。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_dagu));
                        //历史
                        textView_instrument_content.setText("\t\t\t现代大鼓起源于古代土耳其，因此又称大军鼓，中世纪时传入欧洲。是军乐队、管弦乐队和交响乐队中最重要的打击乐器，几乎不作独奏，而是参与合奏或衬托乐队和声的伴奏乐器，但大鼓的地位非常重要，它不仅使乐队的低音声部更加充实、丰满，而且为整个乐队带来一种气势，\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_dagu));

                        textView_skill.setText("右手执槌（桴）打鼓，左手执槌敲吊钟，敲打的时候，必须注意“节拍、板眼”，不可错乱。  “手鼓”的拿法和敲法是：不敲时，两手捧持；椎横摆在鼓的外面，用两食指与两中指托住，两大指挟在鼓内，其余四指（两无名指与两小指）环摆着。敲击时左手持鼓，右手执槌。持鼓是以左手大指和食指，中指托之。执槌是以右手大指、食指和中指合持，向内敲之。另有一种如团扇形有柄的单面“手鼓”，则用左手握持其柄便可。 \n");
                        break;
                    //民族乐器-打-木鱼
                    case 4:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_muyu.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_muyu.mp3";

                        textView_instrument_name.setText("木鱼");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.muyu));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t筝主要由面板，底板、边板、筝首、筝尾、岳山、雁柱、琴钉、出音孔和筝弦等部位组成。筝的优劣取决于各部件材料质地及制作工艺。\n");
                        //结构图
                        //imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_muyu));
                        //历史
                        textView_instrument_content.setText("\t\t\t古筝是一件古老的民族乐器。唐宋时有弦十三根，后最多增至二十五弦。目前最常用的规格为21弦。通常古筝的型号用S163-21，S代表S形岳山，是筝父徐振高发明。163代表古筝长度为163厘米，21代表古筝弦数21根。自秦、汉以来，古筝从我国西北地区流传到全国各地，在不同地域逐渐形成了各具浓郁地方特色的九个流派，分别为：山东筝、河南筝、潮州筝、客家筝、浙江筝、福建筝、内蒙筝（即雅托葛）、朝鲜族的伽揶琴（即延边筝）和被称为真秦之声的陕西筝。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_muyu));

                        textView_skill.setText("传统的常用演奏采用右手大、食、中、无名四指拨弦，弹奏旋律、掌握节奏，左手在筝柱左侧顺应弦的张力，控制弦音的变化，以调整音高、完善旋律。古筝的指法颇多，右手有勾、托、劈、挑、抹、剔、打、摇、撮等，左手有按、滑、揉、颤等。\n");
                        break;
                    //民族乐器-打-扬琴
                    case 5:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_yangqin.mp3";
                        music_url_1 = "http://7xkqzu.com1.z0.glb.clouddn.com/hezou_yangqin.mp3";

                        textView_instrument_name.setText("扬琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yangqin));
                        //结构
                        textView_instrument_brief_1.setText("\t\t\t筝主要由面板，底板、边板、筝首、筝尾、岳山、雁柱、琴钉、出音孔和筝弦等部位组成。筝的优劣取决于各部件材料质地及制作工艺。\n");
                        //结构图
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_yangqin));
                        //历史
                        textView_instrument_content.setText("\t\t\t古筝是一件古老的民族乐器。唐宋时有弦十三根，后最多增至二十五弦。目前最常用的规格为21弦。通常古筝的型号用S163-21，S代表S形岳山，是筝父徐振高发明。163代表古筝长度为163厘米，21代表古筝弦数21根。自秦、汉以来，古筝从我国西北地区流传到全国各地，在不同地域逐渐形成了各具浓郁地方特色的九个流派，分别为：山东筝、河南筝、潮州筝、客家筝、浙江筝、福建筝、内蒙筝（即雅托葛）、朝鲜族的伽揶琴（即延边筝）和被称为真秦之声的陕西筝。\n");

                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_yangqin));

                        textView_skill.setText("传统的常用演奏采用右手大、食、中、无名四指拨弦，弹奏旋律、掌握节奏，左手在筝柱左侧顺应弦的张力，控制弦音的变化，以调整音高、完善旋律。古筝的指法颇多，右手有勾、托、劈、挑、抹、剔、打、摇、撮等，左手有按、滑、揉、颤等。\n");
                        break;
                }
            }

            //民族乐器-弦鸣
            if (signal_type == 9) {
                switch (position_item) {
                }
            }
            //民族乐器-体鸣
            if (signal_type == 10) {
                switch (position_item) {
                }
            }
            //民族乐器-气鸣
            if (signal_type == 11) {
                switch (position_item) {
                }
            }
            //民族乐器-膜鸣
            if (signal_type == 12) {
                switch (position_item) {
                }
            }
        }
        //西洋乐器类型
        else {
            //西洋乐器-吹
            if (signal_type == 0) {
                switch (position_item) {
                    //西洋乐器-吹-短笛
                    case 0:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_duandi.mp3";
                        video_url = "http://7xkqzu.com1.z0.glb.clouddn.com/video_duandi.mp4";

                        textView_instrument_name.setText("短笛");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("短笛，吹奏气鸣木管乐器。是音域最高的木管乐器，也是交响乐队中音域最高的乐器之一。");
                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_duandi));

                        textView_instrument_content.setText("\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。为单管、竖吹，历史悠久，音色圆润轻柔，幽静典雅，适于独奏和重奏。");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_duandi));
                        break;
                    //西洋乐器-吹-长笛
                    case 1:
                        music_url = "http://7xkqzu.com1.z0.glb.clouddn.com/duzou_changdi.mp3";
                        video_url = "http://7xkqzu.com1.z0.glb.clouddn.com/video_changdi.mp4";

                        textView_instrument_name.setText("长笛");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("长笛，气鸣吹奏木管乐器，是现代管弦乐和室乐中主要的高音旋律乐器，也是重要的独奏乐器。");

                        imageView_instrument_struct.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.struct_changdi));
                        textView_instrument_content.setText("\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。为单管、竖吹，历史悠久，音色圆润轻柔，幽静典雅，适于独奏和重奏。");
                        imageView_instrument_position.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.position_changdi));
                        break;
                    //西洋乐器-吹-小号
                    case 2:

                        textView_instrument_name.setText("小号");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("小号，俗称小喇叭，属铜管乐器，是铜管乐器家族中音域最高的乐器。");
                        break;
                    //西洋乐器-吹-短号
                    case 3:

                        textView_instrument_name.setText("短号");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("短号，铜管乐器。短号是小号的变形乐器，通常只用于军乐队和舞厅乐队，很少用于管弦乐队。");
                        break;
                    //西洋乐器-吹-长号
                    case 4:

                        textView_instrument_name.setText("长号");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("长号是瑶、壮、苗、彝、哈尼、布依、土家、维吾尔、汉等族唇振气鸣乐器。被称为“爵士乐之王”。");
                        break;
                    //西洋乐器-吹-圆号
                    case 5:

                        textView_instrument_name.setText("圆号");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("圆号，唇振动气鸣乐器，又称法国号。圆号被称作交响乐中的乐器之王。");
                        break;
                    //西洋乐器-吹-大号
                    case 6:
                        textView_instrument_name.setText("大号");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("大号，是一种管乐、管弦乐队中音域最低的铜管乐器。大号在乐队中主要担任低音部和声或节奏，很少用于独奏。");
                        break;
                    //西洋乐器-吹-大管
                    case 7:

                        textView_instrument_name.setText("大管");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("大管又称巴松管，来自意大利文的原意为“一捆柴”——非常形象。大管为双簧气鸣乐器，是双簧管族中的次中音与低音乐器。");
                        break;
                    //西洋乐器-吹-单簧管
                    case 8:

                        textView_instrument_name.setText("单簧管");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("单簧管，又称黑管或克拉管，有管弦乐队中的“演说家”和木管乐器中的“戏剧女高音”之称。");
                        break;
                    //西洋乐器-吹-双簧管
                    case 9:

                        textView_instrument_name.setText("双簧管");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("双簧管，管弦乐器。双簧管在乐队中常担任主要旋律的演奏，");
                        break;
                    //西洋乐器-吹-英国管
                    case 10:

                        textView_instrument_name.setText("英国管");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("英国管，木管乐器，属于双簧管体系中的一种变种。又称中音双簧族乐器。");
                        break;
                    //西洋乐器-吹-萨克斯
                    case 11:

                        textView_instrument_name.setText("萨克斯");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("萨克斯,是萨克斯风的简称，分有上低音萨克斯、中音萨克斯、次中音萨克斯、高音萨克斯。");
                        break;
                    //西洋乐器-吹-次中音号
                    case 12:

                        textView_instrument_name.setText("次中音号");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("次中音号，铜管乐器，又名“瓦格纳大号” ，与其名字类似，是一种中音偏高音铜管乐器。");
                        break;
                }
            }
            //西洋乐器-拉
            if (signal_type == 1) {
                switch (position_item) {
                    //西洋乐器-拉-小提琴
                    case 0:

                        textView_instrument_name.setText("小提琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("小提琴，一种四弦擦奏弦鸣乐器，有“乐器皇后”的美誉，它在器乐中占有极重要的位置，与钢琴、古典吉他并称为世界三大乐器。");
                        break;
                    //西洋乐器-拉-中提琴
                    case 1:

                        textView_instrument_name.setText("中提琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("中提琴，擦奏弦鸣乐器，是提琴族中的中音乐器，外形及结构与小提琴基本相同，只是形体略大。");
                        break;
                    //西洋乐器-拉-大提琴
                    case 2:

                        textView_instrument_name.setText("大提琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("大提琴是西洋三大独奏乐器之一，是管弦乐队中必不可少的次中音或低音弦乐器，有“音乐贵妇”之称。");
                        break;
                    //西洋乐器-拉-低音提琴
                    case 3:

                        textView_instrument_name.setText("低音提琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("低音提琴，擦奏弦鸣乐器，又称倍大提琴。提琴家族中体积最大、发音最低的弓弦乐器。它是乐队中音响的支柱，基本节奏的基础。");
                        break;
                }
            }
            //西洋乐器-弹
            if (signal_type == 2) {
                switch (position_item) {
                    //西洋乐器-弹-钢琴
                    case 0:

                        textView_instrument_name.setText("钢琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("钢琴，键盘敲弦乐器。钢琴因为它宽广的音域，绝美的音色，被称之“乐器之王”。");
                        break;
                    //西洋乐器-弹-竖琴
                    case 1:

                        textView_instrument_name.setText("竖琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("竖琴，世界上最古老的拨弦乐器之一，交响乐队以及歌舞剧中特殊的色彩性乐器，主要担任和声伴奏和演奏滑奏式的装饰句。");
                        break;
                    //西洋乐器-弹-木吉他
                    case 2:

                        textView_instrument_name.setText("木吉他");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("木吉他，西洋拨弦乐器。是纯粹的震动发声。在流行音乐、摇滚音乐、蓝调、民歌、佛朗明哥中，木吉他都被视为主要乐器。");
                        break;
                    //西洋乐器-弹-手风琴
                    case 3:

                        textView_instrument_name.setText("手风琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("手风琴是一种既能够独奏，又能伴奏的簧片乐器，音高固定，易学易懂，体积小，携带方便。");
                        break;
                    //西洋乐器-弹-管风琴
                    case 4:

                        textView_instrument_name.setText("管风琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("管风琴是一种键盘乐器，属于气鸣乐器类的混合型乐器。管风琴在欧洲乐器中占有统治地位，被称为乐器之王，在音乐艺术发展史上占有重要地位。");
                        break;
                    //西洋乐器-弹-簧风琴
                    case 5:

                        textView_instrument_name.setText("簧风琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("簧风琴是一种小型的键盘乐器，一般的簧风琴由压出空气发声，但是美式的簧风琴是由吸入空气发声，音色更加柔和。");
                        break;
                    //西洋乐器-弹-电吉他
                    case 6:

                        textView_instrument_name.setText("电吉他");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("电吉他是一种拨弦乐器，配合效果器的使用，电吉他有很强的表现力，在现代音乐中有很重要的位置。");
                        break;
                    //西洋乐器-弹-电贝司
                    case 7:

                        textView_instrument_name.setText("电贝司");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("电贝司，又称为贝斯吉他、低音吉他，简称贝斯，现代摇滚乐团组合的主要乐器。");
                        break;
                    //西洋乐器-弹-电钢琴
                    case 8:

                        textView_instrument_name.setText("电钢琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("暂无简介");
                        break;
                    //西洋乐器-弹-合成器
                    case 9:

                        textView_instrument_name.setText("合成器");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("合成器是一种以加法合成、减法合成、FM、physical modelling或相位调变等电子技术发声之电子乐器。");
                        break;
                }
            }
            //西洋乐器-打
            if (signal_type == 3) {
                switch (position_item) {
                    //西洋乐器-打-镲
                    case 0:

                        textView_instrument_name.setText("镲");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("暂无简介");
                        break;
                    //西洋乐器-打-沙槌
                    case 1:

                        textView_instrument_name.setText("沙槌");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("沙槌，摇奏体鸣乐器，亦称沙球。一般归于打击类。 演奏时发出“轻微沙沙声”。");
                        break;
                    //西洋乐器-打-木琴
                    case 2:

                        textView_instrument_name.setText("木琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("木琴，属竹木击奏体鸣乐器类，木琴是变音打击乐器，可用于独奏旋律。");
                        break;
                    //西洋乐器-打-定音鼓
                    case 3:

                        textView_instrument_name.setText("定音鼓");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("定音鼓，膜鸣乐器。定音鼓是打击乐器的一种，是一个铜制或黄铜制的共鸣胴，常用基本奏法有单奏及滚奏。");
                        break;
                    //西洋乐器-打-架子鼓
                    case 4:

                        textView_instrument_name.setText("架子鼓");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("架子鼓，一套以鼓为主的组合性打击乐器。是爵士乐队中十分重要的一种打击乐器。");
                        break;
                    //西洋乐器-打-钢片琴
                    case 5:

                        textView_instrument_name.setText("钢片琴");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("钢琴片，击奏体鸣乐器。用于管弦乐队和管乐队的打击乐器。形如小型钢琴的键盘乐器。");
                        break;
                    //西洋乐器-打-三角铁
                    case 6:

                        textView_instrument_name.setText("三角铁");
                        //乐器主图
                        imageView_spe_main.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.suona));
                        //
                        textView_instrument_brief_1.setText("三角铁，民族打击乐器 ，又称“三角铃”，是一种古老的打击乐器，是管乐队、管弦乐队、交响乐队乃至歌舞剧乐队中必不可少的打击乐器。");
                        break;

                }
            }
            //西洋乐器-弦乐
            if (signal_type == 4) {
                switch (position_item) {
                }
            }
            //西洋乐器-木管
            if (signal_type == 5) {
                switch (position_item) {
                }
            }
            //西洋乐器-铜管
            if (signal_type == 6) {
                switch (position_item) {
                }
            }
            //西洋乐器-键盘
            if (signal_type == 7) {
                switch (position_item) {
                }
            }
            //西洋乐器-打击
            if (signal_type == 8) {
                switch (position_item) {
                }
            }
            //西洋乐器-弦鸣
            if (signal_type == 9) {
                switch (position_item) {
                }
            }
            //西洋乐器-体鸣
            if (signal_type == 10) {
                switch (position_item) {
                }
            }
            //西洋乐器-气鸣
            if (signal_type == 11) {
                switch (position_item) {
                }
            }
            //西洋乐器-膜鸣
            if (signal_type == 12) {
                switch (position_item) {
                }
            }
        }
        videoView.setVideoPath(video_url);
    }

    private void init() {
        progressDialog = new ProgressDialog(Activity_Instrument_1.this);
        progressDialog.setTitle("系统消息！");
        progressDialog.setMessage("音乐正在加载……");

        //
        imageView_struct_1 = (ImageView) findViewById(R.id.imageView_struct_1);
        imageView_history_1 = (ImageView) findViewById(R.id.imageView_history_1);
        imageView_position_1 = (ImageView) findViewById(R.id.imageView_position_1);

        imageView_struct_1.setOnClickListener(new onClickListener());
        imageView_history_1.setOnClickListener(new onClickListener());
        imageView_position_1.setOnClickListener(new onClickListener());

        //
        LayoutInflater inflater = LayoutInflater.from(this);
        View spe = inflater.inflate(R.layout.fragment_spe_2, null);
        View music = inflater.inflate(R.layout.music, null);
        View skill = inflater.inflate(R.layout.fragment_skill, null);

        //spe
        textView_instrument_name = (TextView) spe.findViewById(R.id.textView_instrument_name);
        textView_instrument_brief_1 = (TextView) spe.findViewById(R.id.textView_instrument_brief_1);
        textView_instrument_content = (TextView) spe.findViewById(R.id.textView_instrument_content);
        imageView_spe_main = (ImageView) spe.findViewById(R.id.imageView_spe_main);

        imageView_instrument_struct = (ImageView) spe.findViewById(R.id.imageView_instrument_struct);
        imageView_instrument_position = (ImageView) spe.findViewById(R.id.imageView_instrument_position);

        //music
        textView_music_name = (TextView) music.findViewById(R.id.textView_music_name);
        textView_music1 = (TextView) music.findViewById(R.id.textView_music);

        imageView_music_play = (ImageView) music.findViewById(R.id.imageView_music_play);
        imageView_music_play.setOnClickListener(new onClickListener());
        imageView_music_forward = (ImageView) music.findViewById(R.id.imageView_music_forward);
        imageView_music_forward.setOnClickListener(new onClickListener());
        imageView_music_pic = (ImageView) music.findViewById(R.id.imageView_music_pic);

        //
        imageView_music_pic.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.earphone));
        //skill
        textView_skill = (TextView) skill.findViewById(R.id.textView_skill);

        //VideoView播放视频
        videoView = (VideoView) skill.findViewById(R.id.videoView);
        videoView.setOnTouchListener(new onTouchListener());
        //videoView.setVideoPath(video_url);
        //
        videoView.setBackgroundResource(R.drawable.xiao_video);

        MediaController mediaControlerOBJ = new MediaController(Activity_Instrument_1.this);
        mediaControlerOBJ.setAnchorView(videoView);
        videoView.setMediaController(mediaControlerOBJ);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("INFORMATION", "Prepared!");
                //videoView.start();
            }
        });

        view.add(spe);
        view.add(music);
        view.add(skill);
        //
        viewPager_spe = (ViewPager) findViewById(R.id.viewPager_spe);
        viewPager_spe.setCurrentItem(0);
        viewPager_spe.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    //
                    case 0:
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                        }
                        if (videoView != null) {
                            videoView.pause();
                        }
                        imageView_struct_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jianjie1));
                        imageView_history_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yinyue));
                        imageView_position_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jiqiao));
                        break;
                    case 1:
                        if (videoView != null) {
                            videoView.pause();
                        }
                        imageView_struct_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jianjie));
                        imageView_history_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yinyue1));
                        imageView_position_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jiqiao));
                        break;
                    case 2:
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                        }
                        imageView_struct_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jianjie));
                        imageView_history_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.yinyue));
                        imageView_position_1.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.jiqiao1));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDisplay(surfaceHolder);
                try {
                    mediaPlayer.setDataSource(video_url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp = null;
                        //imageView_play.setVisibility(View.VISIBLE);
                    }
                });
            }
        }
        ).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageView_struct_1:
                    viewPager_spe.setCurrentItem(0);
                    break;
                case R.id.imageView_history_1:
                    viewPager_spe.setCurrentItem(1);
                    break;
                case R.id.imageView_position_1:
                    viewPager_spe.setCurrentItem(2);
                    break;
                //播放按钮
                case R.id.imageView_music_play:
                    progressDialog.show();
                    if (mediaPlayer == null) {
                        //progressDialog = new ProgressDialog(Activity_Instrument_1.this).show(Activity_Instrument_1.this, "系统消息", "音乐正在加载……", false, false);
                        mediaPlayer = new MediaPlayer();

                        handler.sendEmptyMessage(0);

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mediaPlayer.reset();
                                mediaPlayer.release();
                                Log.i("State:", "Completed!");
                                imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                                textView_music_name.setText("");
                                mediaPlayer = null;
                            }
                        });
                        //
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //if (mediaPlayer != null) {
                                Log.i("STATE:", "" + mediaPlayer.isPlaying());
                                if (!mediaPlayer.isPlaying()) {
                                    handler.sendEmptyMessage(1);
                                    handler.sendEmptyMessage(2);
                                }
                                //}
                            }
                        }, 5000);
                    } else {
                        handler.sendEmptyMessage(1);
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                            textView_music_name.setText("");
                        }
                        mediaPlayer.reset();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    break;
                //下一首按钮
                case R.id.imageView_music_forward:

                    Log.i("Forward", "=======");
                    if (mediaPlayer == null) {
                        mediaPlayer = new MediaPlayer();
                    } else {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                        mediaPlayer = new MediaPlayer();
                    }
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayer.reset();
                            mediaPlayer.release();
                            Log.i("State:", "Completed!");
                            imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_play_big));
                            textView_music_name.setText("");
                            mediaPlayer = null;
                        }
                    });
                    //progressDialog = new ProgressDialog(Activity_Instrument_1.this).show(Activity_Instrument_1.this, "系统消息", "音乐正在加载……", false, true);
                    progressDialog.show();
                    handler.sendEmptyMessage(0);
                    break;
                //
                case R.id.videoView:
                    Log.i("Video:", "Click!");
                    videoView.start();
                    videoView.getBackground().setAlpha(0);
                    break;
            }
        }
    }

    private class onTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.videoView:
                    videoView.start();
                    videoView.getBackground().setAlpha(0);
                    break;
            }
            return false;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    try {
                        mediaPlayer.setDataSource(state ? music_url : music_url_1);
                        if (state) textView_music_name.setText("正在播放：独奏");
                        else textView_music_name.setText("正在播放：合奏");

                        //
                        if (state) state = false;
                        else state = true;
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                mediaPlayer.start();
                                handler.sendEmptyMessage(1);
                                imageView_music_play.setImageBitmap(Image.readBitMap(Activity_Instrument_1.this, R.drawable.circle_pause_big));
                            }
                        });
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    progressDialog.dismiss();
                    break;
                case 2:
                    new AlertDialog.Builder(Activity_Instrument_1.this).setTitle("系统消息").setMessage("网络异常，请稍后再试！").show();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    break;
            }
            super.handleMessage(msg);
        }
    };

    //
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        System.gc();
        System.runFinalization();
        Log.i("On Destroyed!", "!!!!!!!!!!");
    }
}
//

