package com.dr.rui.sotired.DataBase;

import com.dr.rui.sotired.Entity.Instrument;
import com.dr.rui.sotired.R;

import java.util.ArrayList;

/**
 * Created by rui on 2016/12/13.
 */

public class InstrumentsInfo {
    public ArrayList<String> getAllInstruments() {
        ArrayList<String> list = new ArrayList<>();
        list.add("箫");
        list.add("笙");
        list.add("埙");
        list.add("阮");
        list.add("小提琴");
        list.add("中提琴");
        list.add("大提琴");
        list.add("低音提琴");
        list.add("二胡");
        list.add("高胡");
        list.add("板胡");
        list.add("三弦");
        list.add("马头琴");
        list.add("琵琶");
        list.add("月琴");
//        list.add("柳琴");
        list.add("古筝");
        list.add("古琴");
//        list.add("木吉他");
        list.add("竖琴");
        list.add("扬琴");
        list.add("钢琴");
        list.add("簧风琴");
        list.add("手风琴");
//        list.add("管风琴");
        list.add("长笛");
        list.add("短笛");
        list.add("竹笛");
        list.add("单簧管");
        list.add("双簧管");
        list.add("英国管");
        list.add("大管");
        list.add("萨克斯");
        list.add("葫芦丝");
        list.add("唢呐");
        list.add("巴乌");
        list.add("短号");
        list.add("小号");
        list.add("长号");
        list.add("圆号");
        list.add("大号");
        list.add("次中音号");
        list.add("定音鼓");
        list.add("钹");
        list.add("锣");
        list.add("镲");
        list.add("三角铁");
        list.add("沙槌");
        list.add("排鼓");
        list.add("大鼓");
        list.add("架子鼓");
        list.add("钢片琴");
        list.add("木琴");
        list.add("木鱼");
        list.add("电吉他");
        list.add("电贝司");
        list.add("电钢琴");
//        list.add("合成器");
        return list;
    }

    //
    public Instrument[] AllInstrumentsInfo() {
        Instrument[] instruments = new Instrument[new InstrumentsInfo().getAllInstruments().size()];
        for (int i = 0; i < instruments.length; i++) {
            Instrument instrument = loadInstrumentInfo(new InstrumentsInfo().getAllInstruments().get(i));
            instruments[i] = instrument;
        }
        return instruments;
    }

    public Instrument loadInstrumentInfo(String name) {
        Instrument instrument = new Instrument();
        instrument.setGuide("\t\t首页");
        instrument.setGuide1(">乐器知识");
        switch (name) {
            case "箫":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">箫");
                instrument.setName("箫");
                instrument.setPic_spe(R.drawable.xiao);
                instrument.setPic_struct(R.drawable.struct_xiao);
                instrument.setBrief1("\t\t\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。");
                instrument.setBrief0("\t\t\t\t箫一般由竹子制成，吹孔在上端，较曲笛长，按“音孔”数量区分为六孔箫和八孔箫，八孔箫为现代改进的产物。全长70～78厘米，管身内径1.2～1.4厘米。六孔箫管中部正面开有5个音孔，背面有1个音孔，用以控制音的高低，起着美化音色增大音量的作用。");
                instrument.setContent("\t\t\t\t箫相传为舜所造。唐代以前指多 管“箫”，即“排箫”，“八音”的“竹”就是排箫的前身。现今所称“箫”，指单管箫。魏晋南北朝时，箫已用于独奏、合奏，并在伴奏相和歌的乐队中使用。 ");
                instrument.setPic_position(R.drawable.position_xiao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%99%88%E6%82%A6%20-%20%E5%B9%B3%E6%B9%96%E7%A7%8B%E6%9C%88%20-%20%E8%90%A7.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%BA%A2%E6%A5%BC%E6%A2%A6%20-%20%E8%91%AC%E8%8A%B1%E5%90%9F%20-%20%E8%90%A7%20%E7%94%B5%E8%A7%86%E5%89%A7.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%BA%A2%E6%A5%BC%E6%A2%A6%20-%20%E5%8F%B9%E9%A6%99%E8%8F%B1%20-%20A%20Sigh%20Of%20The%20Maid%20Xiangl%20%E8%90%A7.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《平湖秋月》");
                instrument.setMusic_name2("《红楼梦 - 葬花吟》");
                instrument.setMusic_name3("《红楼梦 - 叹香菱》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t箫的音色柔和，典雅，低音区，深沉而有共鸣，弱奏时很有特色，但发音比较困难。中音区，圆润而纤美，是常用音区。高音区，稍紧张，窄而明亮，较少用。超高音区，尖锐，干涩，极少用。箫的音量很弱，力度幅度变化不大，大约在最弱（ppp）~ 中强（mf）之间。箫的定调不一，常见的为G调，还有F调、C调等。6个音孔全闭时，筒音为（d1），通过超吹，音域由（d1～e3），有两个八度另一个大二度。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/video_xiao.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：箫的演奏姿势有站式和坐式两种，演奏时一定要保持身体的自然状态。\n" +
                        "（一）站式\n" +
                        "\t\t\t\t独奏或重奏时一般采用站式。两臂自然向前，两手持箫，手指自然弯曲，胸部和腰部要直，但不能挺胸鼓肚，头部向前但不能前倾更不能后仰。双肩和双肘自然下垂，切忌耸肩。箫放在嘴上时与身体约成45度角，因为角度太小了容易低头，太大了又容易扬颈，这样不但姿势不雅，也影响呼吸。两腿站定，两脚稍稍分开，身体重心落于两腿之间。\n" +
                        "（二）坐式\n" +
                        "\t\t\t\t合奏或伴奏时一般采用坐式。坐式上半身和站式完全相同。座椅高低要合适，切忌一条腿架在另一条腿上，这样不但姿势不雅，同时也影响正常呼吸。吹箫姿势是最符合人体生理结构特点的，因此持箫最基本的原则就是要保持人体自然状态，便能很快掌握正确的演奏姿势。\n");
                break;
            case "笙":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">笙");
                instrument.setName("笙");
                instrument.setPic_spe(R.drawable.sheng);
                instrument.setPic_struct(R.drawable.struct_sheng);
                instrument.setBrief1("\t\t\t\t笙，吹孔簧鸣乐器，起源于中国，是世界上最早使用自由簧的乐器。发音清越、高雅、音质柔和、歌唱性强，具有中国民间色彩。");
                instrument.setBrief0("\t\t\t\t笙是由笙苗中簧片发声，吹气及吸气皆能发声，能奏和声。可分成高音笙、中音笙、低音笙、传统笙。\n    笙的构造比较复杂。它是由笙斗、吹嘴、笙苗（又称笙管）、笙角、簧片和腰箍等部件组成。 笙斗圆形，笙斗和吹嘴铜制，焊接后合为一体。笙管上端有长方形或亚铃形出音孔，下开圆形按音孔，下端与笙角相接。\\n\"");
                instrument.setContent("\t\t\t\t笙在中国已经有几千年的历史，传说笙可以模仿凤凰的哭声，形状也很像收起翅膀的神鸟。在唐朝（公元618-907年）时，笙才逐渐转变为现在的形式。  笙是从十三簧到十七簧、十九、二十三簧，由簧少到簧多而发展。在传统器乐和昆曲里，笙常常被用作其它管乐器如笛子、唢呐的伴奏，为旋律加上纯四度或纯五度和音。在现代国乐团，笙可以担当旋律或伴奏的作用。");
                instrument.setPic_position(R.drawable.position_sheng);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%99%8F%E6%99%AF%E6%99%9F%20-%20%E6%99%8B%E8%B0%83%20-%20%E7%AC%99.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E4%B9%8C%E8%8B%8F%E9%87%8C%E8%88%B9%E6%AD%8C.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%BB%A3%E8%8D%B7%E5%8C%85.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("晏景晟 - 晋调 - 笙");
                instrument.setMusic_name2("《双鹤听泉》");
                instrument.setMusic_name3("《绣荷包》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t笙的音色明亮甜美，高音清脆透明，中音柔和丰满，低音浑厚低沉，音量较大。而且在中国传统吹管乐器中，也是唯一能够吹出和声的乐器。\n" +
                        "笙的音色与箫、笛、管比起来，缺乏个性，音质也较为浮泛，穿透力较差，深度和力度不够，但它却是一个很好的伴奏乐器和合奏乐器。传统笙则有分调性，技巧华丽，表现力强，较适合独奏，笙独奏曲多半也是为传统笙而写。\n");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/23Sheng.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏笙时，两手手掌将笙斗托住，右手中指和无名指插进笙苗的马蹄形缝隙中，用7个手指（右手4个、左手3个）按孔。每个手指兼管几个按孔，手指动作要灵敏，按孔要严密。\n" +
                        "笙的演奏技巧分为手指技巧和口内技巧，可奏出单音、和弦、抹音、滑音、顿音、花舌、呼舌、揉音和喉音等技巧，在笙上吹奏颤音是比较困难的。\n");
                break;
            case "埙":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">埙");
                instrument.setName("埙");
                instrument.setPic_spe(R.drawable.xun);
                instrument.setPic_struct(R.drawable.struct_xun);
                instrument.setBrief1("\t\t\t\t埙，亦称“陶埙”，是汉族特有的闭口吹奏乐器，在世界原始艺术史中占有重要的地位。");
                instrument.setBrief0("\t\t\t\t十孔埙的结构为一个类似空心球式的主体，有一个吹孔、九个发音孔。主体上端的是吹孔，正面设有七个发音孔，反面设有两个发音孔，底部呈平面。以陶制最为普通，也有石制和骨制等。");
                instrument.setContent("\t\t\t\t埙是中国最古老的吹奏乐器之一，大约有七千年的历史，起源与汉族先民的劳动生产活动有关，最初可能是先民们模仿鸟兽叫声而制作，用以诱捕猎物。后随社会进步而演化为单纯的乐器，并逐渐增加音孔，发展成可以吹奏曲调的旋律乐器。最初埙大多是用石头和骨头制作的，后来发展成为陶制的，形状也有多种，如扁圆形、椭圆形、球形、鱼形和梨形等，其中以梨形最为普遍。");
                instrument.setPic_position(R.drawable.position_xiao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%9F%99%E6%9B%B2%20%E5%AF%92%E6%B1%9F%E6%AE%8B%E9%9B%AA.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%9F%99%20-%20%E6%B0%B4%E9%BE%99%E5%90%9F.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《寒江残雪》");
                instrument.setMusic_name2("《埙 - 水龙吟》");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t埙，扁形的比圆形的容易吹奏发音，发音音量也有明显提高。不过同时越扁的埙的声音越有干涩的感觉,腔体越接近圆形的埙音色越柔润缓和，牛头埙底部圆，上部圆尖，容易吹奏，音色比扁埙柔润，比圆埙易吹，音量也大一些 。 ");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/21.%E5%A1%A4Xun.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：埙的吹奏技巧可分为气吹和舌吹两类，然后和指法技巧构成了它的演奏技巧。\n" +
                        "气类吹奏技巧 \n" +
                        "埙的气类吹奏技巧有长音、气震音、唇振音等，其中长音是埙吹奏技巧的基础，必须饱满圆润，响亮平稳无杂音。埙的常用技巧汇总起来可分为气、指、舌三大类：包括长音、气震音、指震音、唇震音、颤音、滑音、吐音、打音、空打音、循环换气、双吐循环换气、虚吹音等多种。\n" +
                        "舌类吹奏技巧\n" +
                        "吐音是埙的一种常用演奏技巧。适于演奏热情欢快、激昂活泼的曲调，要求声音结实、干净、有弹性，节奏要均匀平稳。吐音分单吐音（包括单外吐、单内吐）、双吐、轻吐、气吐、唇吐等多种。\n\n" +
                        "（一）单外吐（标记T\n" +
                        "\t\t\t在保持正确吹奏口形的基础上舌头自然向上，微贴上唇内沿，呼气时迅速后缩，使气流冲入吹孔发出短促有力之声，类似“吐”音。\n" +
                        "（二）单内吐（标记K）\n" +
                        "\t\t\t\t在保持正确吹奏口形的基础上，舌根部后缩堵住上腭，呼气时舌根部迅速前送，使气流冲入吹孔而发出短促有力之声，类似“库”音。\n" +
                        "（三）双吐\n" +
                        "\t\t\t\t双吐就是结合单内吐和单外吐，速度比单吐快一倍，其音类似“吐库”或“库吐”，适于演奏欢快、激昂的曲调。吐音要求声音结实、干净、有弹性，节奏要均匀平稳。\n");
                break;
            case "竹笛":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">竹笛");
                instrument.setName("竹笛");
                instrument.setPic_spe(R.drawable.zhudi);
                instrument.setPic_struct(R.drawable.struct_zhudi);
                instrument.setBrief1("\t\t\t\t竹笛，木管乐器家族中的吹孔膜鸣乐器类。起源于中国的单边吹奏的长笛。竹笛其中一个特点是它在膜孔上覆盖的薄膜，当吹奏竹笛时，薄膜振动，增加鼻音。竹笛在独奏和合奏中都很重要，也常出现在中国民族乐队中。");
                instrument.setBrief0("\t\t\t\t竹笛由一根竹管做成，里面去节中空成内膛，外呈圆柱形，在管身上开有1个吹孔、1个膜孔、6个音孔。管内空气振动发声。气流摩擦吹孔，进入笛身，震动笛膜，回响笛堂。");
                instrument.setContent("\t\t\t\t石器时代的人们因为不满足苇管单调的声音，所以在野兽的腿骨上打上洞，制造出的就是最原始的笛子——骨笛。笛子虽然短小简单，但它却有七千年的历史。大约在四千五百多年前的时候，笛子由骨制改为竹制。在公元前1世纪末汉武帝时，笛子称为“横吹”,它在当时的鼓吹乐中占有相当重要的地位。从7世纪开始，笛子又有了改进，增加了膜孔，使它的表现力有了很大的发展，并且演奏技术也发展到相当高的水平。到了10世纪，随着宋词元曲的崛起，笛子成了伴奏吟词唱曲的主要乐器，在民间戏曲以及少数民族剧种的乐队里，笛子也是不可缺少的乐器。");
                instrument.setPic_position(R.drawable.position_zhudi);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%96%8F%E7%9F%B3%E5%85%B0%E5%85%AE%28%E7%AB%B9%E7%AC%9B%E7%8B%AC%E5%A5%8F%E7%89%88%29%20-%20%E9%AD%8F%E5%B0%8F%E6%B6%B5.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%A4%AA%E6%B9%96%E6%98%A5%20Spring%20At%20The%20Tai-Lake%20-%20%E5%BC%A0%E7%BB%B4%E8%89%AF.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("疏石兰兮(竹笛独奏版) - 魏小涵");
                instrument.setMusic_name2("《太湖春》");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t竹笛有18个音（不包括变化音），用全按低音5的指法可以从低音5到超高音1。 中国笛子具有强烈的民族特色，发音动人婉回。笛子的表现力非常丰富，它既能演奏悠长、高亢的旋律，又能表现辽阔、宽广的情调，同时也可以奏出欢快华丽的舞曲和婉转优美的小调。可演奏出连音断音、颤音和滑音等色彩性音符，还可以表达不同的情绪。无论演奏舒缓、平和的旋律，还是演奏急促、跳跃的旋律，其独到之处都可从中领略。此外，笛子还擅长模仿大自然中的各种声音，把听众带入鸟语花香或高山流水的意境之中。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%90%B4%E6%99%B6%20%E6%96%AF%E5%BE%B7%E5%93%A5%E5%B0%94%E6%91%A9%E7%9A%87%E5%AE%B6%E9%9F%B3%E4%B9%90%E5%8E%85%E7%AC%9B%E5%AD%90%E7%8B%AC%E5%A5%8F%E2%80%9C%E6%98%A5%E5%88%B0%E6%B9%98%E6%B1%9F%E2%80%9D.flv");
                instrument.setSkill("\t\t\t\t演奏技巧：笛子的演奏由于技巧、地域的关系，简单形成两大流派，一为南派；一为北派。就技巧而言：南曲出手颤、叠、振、打；北曲拿手吐、滑、剁、花。吹笛子的姿势，分立式和坐式两种。\n" +
                        "（一）立式\n" +
                        "\t\t\t一般在独奏、重奏、齐奏时采用立式。\n" +
                        "（二）坐式\n" +
                        "\t\t\t\t在合奏或伴奏时，一般采用坐式。坐式上身与立式相同。坐位高低要适当，凳子太高、太低都会妨碍正常呼吸。坐式最好不要架腿，两脚分立才坐得稳定。\n");
                break;
            case "唢呐":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">唢呐");
                instrument.setName("唢呐");
                instrument.setPic_spe(R.drawable.suona);
                instrument.setPic_struct(R.drawable.struct_suona);
                instrument.setBrief1("\t\t唢呐，双簧片木管乐器。唢呐，又名喇叭，小唢呐称海笛。音色明亮，音量大，管身木制，成圆椎形，上端装有带哨子的铜管，下端套着一个铜制的喇叭口（称作碗）。在台湾民间称为鼓吹，广东地区亦将之称为“八音”。");
                instrument.setBrief0("\t\t唢呐由哨、气牌、芯子、杆和碗五部分构成，大约51cm长。在木制的锥形管上开八孔（前七后一），管的上端装有细铜管，铜管上端套有双簧的苇哨，木管上端有一铜质的碗状扩音器。唢呐虽有八孔，但第七孔音与筒音超吹音相同，第八孔音与第一孔音超吹音相同。\n" +
                        "唢呐活芯，其内管连有气牌和气嘴，并有螺栓槽，套上一弹簧，插在外管中，外管侧面有螺纹孔，再套上一个微调套管用螺栓螺母，从套管长孔穿过拧入螺纹孔，再进入内管的螺栓槽，用螺丝螺母调正内管之伸缩距离，嘴唇压缩气嘴以后，使内管缩短其音程，于是每个音孔可吹出半音，增加唢呐之音量范围，可吹奏各种变调乐曲。\n" +
                        "芯子是唢呐的重要部件之一，其上装哨片，下接主体管。传统的芯子为单管式，而活芯为活动套式，可以伸缩改变长度，复位靠弹簧的作用。\n");
                instrument.setContent("\t\t公元3世纪，唢呐由波斯、阿拉伯一带传入中国。西晋时期，新疆拜城克孜尔石窟第38窟中的伎乐壁画已有吹奏唢呐形象。在金、元时期，传到中国中原地区。曾译作“锁呐”“销呐”“苏尔奈”“锁奈”“唆哪”等名。明代后期，唢呐已在戏曲音乐中占有重要地位，用以伴奏唱腔、吹奏过场曲牌。而在以戏曲音乐为基础的民间器乐中，唢呐也成为离不开的乐器。到了近现代，唢呐成为中国各族人民使用颇广的乐器之一。2006年5月20日，唢呐艺术经国务院批准列入第一批国家级非物质文化遗产名录。 ");
                instrument.setPic_position(R.drawable.position_suona);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%94%A2%E5%91%90%20%E5%96%9C%E8%BF%8E%E6%98%A5%20Happy%20To%20Greet%20Spring.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%BE%A4%E6%98%9F%20-%20%E7%99%BE%E9%B8%9F%E6%9C%9D%E5%87%A4%20-%20%E5%94%A2%E5%91%90%E7%8B%AC%E5%A5%8F.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《一枝花》");
                instrument.setMusic_name2("《喜迎春》");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t唢呐的中、低音区音色豪放、刚劲，各种技巧都易于发挥，非常富有表现力；高音区紧张而尖锐，在乐队中应用要谨慎。 ");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏唢呐往往比较费气，音越高耗的气量也就越大。“循环换气法”是最常见的演奏方法，这样的吹奏能使得气息总是饱满不息，可以使乐音不间断地长时间延续，甚至全曲一气呵成。吹奏唢呐，也需要一些技巧，要用手指把音孔完全按满。倘若音孔按不严，往往发出的声音就不准。唢呐的演奏技巧极为丰富，大致可分为口内技巧和手指技巧，在演奏中常常两者结合运用，其中有连奏、单吐、双吐、三吐、弹音、花舌、萧音、滑音、颤音、叠音和垫音等，还可以模仿飞禽和昆虫的鸣叫。\n");
                break;
            case "巴乌":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">巴乌");
                instrument.setName("巴乌");
                instrument.setPic_spe(R.drawable.bawu);
                instrument.setPic_struct(R.drawable.struct_bawu);
                instrument.setBrief1("\t\t巴乌，簧管乐器，也叫“把乌”，流行于云南、广西壮族自治区、贵州黔东南和黔南等地。哈尼族称“各比”，彝族称“比鲁”或“乌勒”，侗族称“拜”，常用于独奏或为舞蹈和说唱伴奏。巴乌的品种较多，在哈尼族，有单管、双管之分，由于竹管长短、粗细的不同，还有高音、中音和低音巴乌之分。");
                instrument.setBrief0("\t\t巴乌全长30-60厘米，外形似箫，竹制，在近封闭端的管壁上，开有一个长方形吹口，管身八孔，前七后一，并与吹口成45 度。 管上端装有铜簧片，横吹上端，簧片振动而发音，音色优美。\n" +
                        "管身用细毛竹、青竹制，下端（或右端）开口，上端（或左端）留竹节或木塞封闭。上端管壁开长方形吹口，用蜂蜡粘一长方形竹或铜制簧片，簧舌呈三角形，有细蔑编制的活动簧套。管身开八孔（前七后一），与吹口成四十五度角。有的在下端开二至四个尾音孔。\n");
                instrument.setContent("\t\t传统的巴乌音域窄、音量小，但音色优雅。解放后几十年间，巴乌的研制改革工作一直在进行着，经过改革加键的巴乌，在保持传统巴乌浑厚柔美音色的前提下，扩大了音域、音量，适于演奏宽广、抒情的音调。此外，还能转四个调，能奏出各种滑音、打音、吐音、颤音、飞指、抹音等技巧音。");
                instrument.setPic_position(R.drawable.position_xiao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%EF%BC%88%E7%8B%AC%E5%A5%8F%EF%BC%89%E7%BE%8E%E4%B8%BD%E7%9A%84%E9%87%91%E5%AD%94%E9%9B%80--%E6%9D%9C%E8%81%AA%20.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E8%8A%82%E6%97%A5%E8%88%9E%E6%9B%B2%20-%20%E9%99%86%E6%98%A5%E9%BE%84.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%9D%8E%E5%BC%BA%20-%20%E5%82%A3%E4%B9%A1%E6%83%85%E6%AD%8C%20-%20%E5%B7%B4%E4%B9%8C.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("美丽的金孔雀");
                instrument.setMusic_name2("《节日舞曲》");
                instrument.setMusic_name3("《傣乡情歌》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t巴乌常用演奏抒情的、宽广的音调，亦可演奏技巧性强的华彩乐段。合奏时巴乌音色易和其它乐器融合在一起，因此可以作为高音乐器与低音乐器的桥梁。由于其音色柔美，常用于伴奏舞蹈、独奏等；在民间，巴乌常用于独奏、合奏或为舞蹈和叙事歌等说唱伴奏。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/22Bawu.mp4");
                instrument.setSkill("\t\t\t\t演奏时，管身粗而长者横吹，细而短者竖吹。竖吹口含簧片，横吹将簧片置两唇间，右手食指、中指、无名指分别横按两管上三孔，左手食指、中指、无名指分别横按两管下三孔，吹气鼓簧按孔发音，气流振动簧片并激发管内空气柱共鸣，用吐音方法吹奏，有滑音、打音、颤音、抹音、琶音、飞指等技巧，可用循环换气法奏长时值音符。");
                break;
            case "葫芦丝":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">葫芦丝");
                instrument.setName("葫芦丝");
                instrument.setPic_spe(R.drawable.hulusi);
                instrument.setPic_struct(R.drawable.struct_hulusi);
                instrument.setBrief1("\t\t葫芦丝，又称“葫芦箫”，民族管乐器。是云南少数民族特有的乐器之一。主要流传于云南省滇西傣族地区，在布朗族，德昂族等少数民族中也较为流行。");
                instrument.setBrief0("\t\t葫芦丝主要有三部分：1、葫芦；2、发音管；3、发音簧片。 由一个完整的天然葫芦、三根竹管和三枚金属簧片做成。整个葫芦做气箱，葫芦低部插进三根粗细不同的竹管，每根插入葫芦中的竹管部分，镶有一枚铜质或银质簧片，中间的竹管最粗，上面开着七个音孔，把它称为主管，两旁是附管，上面只设簧片，不开音孔（指传统葫芦丝），只能发出与主管的共鸣的和音。");
                instrument.setContent("\t\t葫芦丝的历史较为悠久，其渊源可追溯到先秦时代，它是由葫芦笙演进改造而成的。" +
                        "新中国成立后，中国民族音乐工作者对葫芦笙进行了不断的改革。1958年，云南省歌舞团首先把音域扩展为14个音。。 ");
                instrument.setPic_position(R.drawable.position_hulusi);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%9D%9C%E8%81%AA%20-%20%E6%9C%88%E5%85%89%E4%B8%8B%E7%9A%84%E5%87%A4%E5%B0%BE%E7%AB%B9%20-%20%E8%91%AB%E8%8A%A6%E4%B8%9D%E7%89%88%E7%BA%AF%E9%9F%B3%E4%B9%90.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%87%91%E8%89%B2%E7%9A%84%E5%AD%94%E9%9B%80.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《月光下的凤尾竹 》");
                instrument.setMusic_name2("《金色的孔雀》");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t葫芦丝音色独特优美，外观古朴，柔美，典雅，常用于吹奏山歌等民间曲调，最适于演奏旋律流畅的乐曲或舞曲，曲调中一般长音较多，合音丰富，乐声柔美和谐，能较好抒发演奏者的思想感情。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/Hulusi%20solo%20-%20%E8%91%AB%E8%8A%A6%E4%B8%9D%E7%8B%AC%E5%A5%8F.mp4");
                instrument.setSkill("\t\t\t\t\t\t\t\t\n" +
                        "（一）\n" +
                        "\t\t\t右手无名指、中指、食指用第一节指肚分别开闭第一、二、三个音孔，拇指拖于主管下方。左手无名指、中指、食指用第一节指肚分别开闭，第四、第五、第六音孔，拇指开开位于主管前下方的第七音孔。\n" +
                        "（二）\n" +
                        "\t\t\t\t深呼吸、吸入的气尽可能多一些，吸气后、气息下沉，使气流在有控制的情况下有节制的均匀向外呼出，气息要平稳、不可忽强忽弱。" +
                        "（三）\n" +
                        "\t\t\t\t吹奏中， 高音时要用缓吹法（气流减小）低音时要用急吹法（气流加强）。\n");
                break;
            case "二胡":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">拉");
                instrument.setGuide4(">二胡");
                instrument.setName("二胡");
                instrument.setPic_spe(R.drawable.erhu);
                instrument.setPic_struct(R.drawable.struct_erhu);
                instrument.setBrief1("\t\t二胡，又名“胡琴”，是我国独具魅力的拉弦乐器。根据琴筒情况分为四类：圆筒二胡、八角二胡、六角二胡、扁筒二胡。 ");
                instrument.setBrief0("\t\t二胡全长约66cm，木制琴身，中间部分是蛇皮，琴弦是丝绸或者动物的肠子。依靠琴弦的振动发声，琴筒是二胡的共鸣箱，琴杆是支撑琴弦、接指操作的重要支柱。二胡的定弦音高主要是靠琴轴来调节的，即拧转线轴来绷紧或放松弦，紧则音高，松则音低。");
                instrument.setContent("\t\t二胡，始于唐代，已有一千多年的历史。它最早发源于我国古代北部地区的一个少数民族，那时叫“奚琴”。在过去它主要流行于长江中下游一带，所以又称为南胡。到了近代，胡琴才更名为二胡。半个多世纪以来，二胡演奏水平已进入旺盛时期。由于刘天华先生扩大了二胡的音域范围，丰富了表现力，二胡从民间伴奏中脱颖出来，成为独特的独奏乐器。 ");
                instrument.setPic_position(R.drawable.position_erhu);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%98%BF%E7%82%B3%20-%20%E4%BA%8C%E6%B3%89%E6%98%A0%E6%9C%88%20-%20%E4%BA%8C%E8%83%A1%E7%8B%AC%E5%A5%8F%20%E8%92%8B%E5%B7%BD%E9%A3%8E%E6%BC%94%E5%A5%8F.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xiao.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("阿炳 - 二泉映月 - 二胡独奏 蒋巽风演奏");
                instrument.setMusic_name2("《阳关三叠》\t             作曲 无，古曲\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            演奏 闵惠芬");
                instrument.setMusic_name3("二胡独奏曲《赛马》\t\t\t \n" +
                        "作曲 黄海怀\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t         演奏 宋飞\n");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t：二胡发出的乐音有着丰富的表现力，它接近于人声的音色，既能表现深沉、凄惨的内容，也能描绘气势壮观的意境，成为一种富于歌唱性的乐器 ，有人还因此称它为“中国式小提琴”。由于二胡的音色听起来略带忧伤，因而善于表达深沉的情感。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/Erhu-Kongshanniaoyu.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：左手持琴，以“虎口”骑在琴杆上，拇指略微弯曲，掌心成悬空状。整个左手应放松，小臂自然下垂，与琴杆大约构成45度左右的角度。二胡的演奏技巧是比较丰富的，主要分为指法和弓法两大类，有滑音、揉弦、颤音、跳弓、顿弓、拨弦等。");
                break;
            case "高胡":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">拉");
                instrument.setGuide4(">高胡");
                instrument.setName("高胡");
                instrument.setPic_spe(R.drawable.gaohu);
                instrument.setPic_struct(R.drawable.struct_gaohu);
                instrument.setBrief1("\t\t高胡，民族拉弦乐器。高胡是“高音二胡”的简称，其形、构造、演奏弓法与技巧以及所用演奏符号均与二胡相同，只是琴筒（共鸣箱）比二胡略小，常用两腿夹着琴筒的一部分演奏。");
                instrument.setBrief0("\t\t高胡的构造、制作和用料与二胡基本相同，最大的区别是琴筒较细。由于高胡在二十世纪才刚刚诞生，因此，乐器制作家们在改造高胡的时候便少有顾虑和束缚。有的乐器制作家把早期高胡的圆形琴筒改为扁圆形状，使音量加大；有的乐器制作家还把两根弦的高胡改为三根弦，使乐器的音域向下扩展了五度。\n" +
                        "高胡是在二胡的基础上改革而成的，因此高胡的构造、制作以及用料都与二胡基本胡同。它的琴筒比二胡小，定音比二胡高四至五度，所以叫它高胡。外弦用钢丝弦，内弦用钢丝缠弦(也有用丝弦的)。拉时两腿夹琴筒，用以控制音量及减少沙音。音色清脆、嘹亮。高胡得到广泛的应用，现已成为民族乐队中的高音拉弦乐器。它用于合奏、伴奏和独奏。 但是，高胡与二胡在形制上还是有所区别是的：高胡琴筒比较细，形状是圆形的，有别于二胡的六边形，琴筒的后口不像二胡那样开有各种式样的音窗。\n");
                instrument.setContent("\t\t高胡起源于清朝末年的广东粤剧、潮剧过场音乐、民族和曲艺音乐。在二十世纪二十年代前后，\"广东音乐\"作曲家和演奏家吕文成先生对二胡进行了改革，将丝弦改成钢弦，提高了乐器的定弦，同时首创了两腿夹着琴筒的适当部位进行演奏的独特方法。由于高胡产生的时代很晚，因此，吕文成之后的乐器制作家们在改造高胡的时候便少有顾虑和束缚。\n" +
                        "在二十世纪70年代初期，有的乐器制作家根据椭圆形扬声器的声学原理，又把早期高胡的圆形琴筒改为扁圆形状，使乐器共鸣频率范围加宽、音量加大。另外，这种新型高胡的琴弦也比以前粗了，琴杆也由圆形杆改为椭圆形的扁杆。\n");
                instrument.setPic_position(R.drawable.position_gaohu);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%B9%B3%E6%B9%96%E7%A7%8B%E6%B0%B4%20-%20%E9%99%88%E8%80%80%E6%98%9F.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%9B%A8%E6%89%93%E8%8A%AD%E8%95%89%20-%20%E5%A7%9C%E5%85%8B%E7%BE%8E.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%80%9D%E5%BF%B5%20-%20%E4%BD%99%E5%85%B6%E4%BC%9F.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《平湖秋水》");
                instrument.setMusic_name2("《雨打芭蕉 - 姜克美》");
                instrument.setMusic_name3("《思念 - 余其伟》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("高胡的音色清脆、嘹亮，原是用来伴奏广东戏剧和演奏广东小曲的，也用于合奏、独奏。在现代大型民乐队中，高胡多作为高音乐器。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/09Gaohu.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：高胡的主要演奏技巧有：右手多奏分弓，快速弓法，推弓等。左手指法主要有各种滑音和旋律中自由的垫指加花，广东音乐传统奏法，左手不用揉弦，而用压按弦和空弦震音。在演奏高胡时，演奏者两腿加紧琴筒，用以控制音量及减少噪音。\n");
                break;
            case "板胡":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">拉");
                instrument.setGuide4(">板胡");
                instrument.setName("板胡");
                instrument.setPic_spe(R.drawable.banhu);
                instrument.setPic_struct(R.drawable.struct_banhu);
                instrument.setBrief1("\t\t箫的本义是“一种模拟风吹声的竹乐器”，古代用于宫廷雅乐边棱音气鸣乐器。");
                instrument.setBrief0("\t\t\t板胡缺少资料！！！！！！！！！！！！");
                instrument.setContent("\t\t箫相传为舜所造。唐代以前指多 管“箫”，即“排箫”，“八音”的“竹”就是排箫的前身。现今所称“箫”，指单管箫。魏晋南北朝时，箫已用于独奏、合奏，并在伴奏相和歌的乐队中使用。 ");
                instrument.setPic_position(R.drawable.position_xiao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%B2%B3%E5%8C%97%E8%8A%B1%E6%A2%86%E5%AD%90.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%A7%A6%E5%B7%9D%E8%A1%8C%20%28%E6%9D%BF%E8%83%A1%29%20-%20%E7%BE%A4%E6%98%9F.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%A7%A6%E8%85%94%E7%89%8C%E5%AD%90%E6%9B%B2%20%E6%9D%BF%E8%83%A1.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《河北花棒子》");
                instrument.setMusic_name2("《秦川行》");
                instrument.setMusic_name3("《秦腔牌子曲》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：\n ");
                break;
            case "三弦":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">拉");
                instrument.setGuide4(">三弦");
                instrument.setName("三弦");
                instrument.setPic_spe(R.drawable.sanxian);
                instrument.setPic_struct(R.drawable.struct_sanxian);
                instrument.setBrief1("\t\t三弦，又称弦子，中国传统弹拨乐器，其他少数民族也有类似三弦的乐器。柄很长，音箱方形，两面蒙皮，弦三根，侧抱于怀演奏。音色粗犷、豪放。可以独奏、合奏或伴奏，普遍用于民族器乐、戏曲音乐和说唱音乐。");
                instrument.setBrief0("\t\t三弦柄很长，音箱方形，两面蒙皮，弦三根，三弦可分为琴头、琴杆和琴鼓三部分,由琴头、弦轴、山口、琴杆、鼓框、皮膜、琴马和琴弦等组成。");
                instrument.setContent("\t\t秦朝时称为“弦鼗”。清毛其龄《西河词话》：“三弦起于秦时，本三十鼓鼓之制而改形易响，谓之鼓鼓，唐时乐人多习之，世以为胡乐，非也”。 三弦是北方大鼓书、苏州评弹等传统曲艺不可缺少的乐器。在南管音乐中，属于上四管乐器之一，是演出的基本组合。中国的三弦传入琉球后发展成三线；三线传入日本后，发展成三味线。在日本有把“三味线”称为“三弦”的习惯。 现代三弦是在传统三弦基础上改进而来，大三弦分60型、80型大三弦，分别于1960年和1980年研制成功，故而得名。 ");
                instrument.setPic_position(R.drawable.position_sanxian);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%A4%A7%E6%B5%AA%E6%B7%98%E6%B2%99%20-%20%E4%B8%89%E5%BC%A6.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%82%B2%E6%AC%A2%E4%BB%A4%20-%20%E5%91%A8%E6%B6%A6%E6%98%8E.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%95%BF%E9%97%A8%E6%80%A8%20-%20%E9%BB%84%E6%A1%82%E8%8A%B3.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《大浪淘沙》");
                instrument.setMusic_name2("《长门怨 - 黄桂芳》");
                instrument.setMusic_name3("《悲欢令 - 周润明》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t三弦是一种用途很广的弹弦乐器，它不仅可以独奏和参加民族乐队合奏，还多用于说唱和戏曲的伴奏，尤其在说唱音乐的伴奏方面演奏技巧已发展到较高水平。三弦分为大三线和小三弦，大三弦主要用来伴奏京剧等，小三弦用来伴奏一些地方戏种，如吕剧（山东地方戏）等。三弦的音色，高音坚实清脆，中音明亮圆润，低音丰满浑厚，音量较大。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：坐奏，琴身放在右大腿上，左手按把位，琴身呈45度。三弦弹奏方式，依大小三弦不同作区分，通常小三弦是使用拨片拨奏，大三弦戴假指甲弹奏。左手技法有板、粘、揉、扣、滑等，右手有弹、挑、双弹、双挑、滚、分、扫、砸、搓儿等技法。可自如地演奏大、小三度，纯四、五度和八度等双音，还可演奏三音组成的和弦，并可转调演奏。 \n");
                break;
            case "马头琴":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">马头琴");
                instrument.setName("马头琴");
                instrument.setPic_spe(R.drawable.matouqin);
                instrument.setPic_struct(R.drawable.struct_matouqin);
                instrument.setBrief1("\t\t马头琴是中国蒙古族拉弦乐器，是一种两弦的弦乐器，有梯形的琴身和雕刻成马头形状的琴柄。");
                instrument.setBrief0("\t\t马头琴由共鸣箱、琴头、琴杆、弦轴、琴马、琴弦和琴弓等部分。琴身木制，长约一米；有两根弦；共鸣箱呈梯形。");
                instrument.setContent("\t\t马头琴的历史悠久，从唐宋时期拉弦乐器奚琴演变而来。成吉思汗时（1155—1227）已流传民间。明清时期用于宫廷乐队。马头琴是蒙古民族的代表性乐器，不但在中国和世界乐器家族中占有一席之地，而且也是民间艺人和牧民们所喜欢的乐器，马头琴所演奏的乐曲，具有深沉粗犷，激昂的特点，体现了蒙古民族的生产、生活和草原风格。2006年5月20日，蒙古族马头琴音乐经国务院批准列入第一批国家级非物质文化遗产名录。2009年4月，蒙古族马头琴经国务院批准列入第一批国家级非物质文化遗产名录。布林为蒙古马头琴继承人。 ");
                instrument.setPic_position(R.drawable.position_xiao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%9F%AF%E5%8B%92%E4%BC%A6%E6%B2%B3%E4%B9%8B%E6%99%AF%20-%20%E6%89%8E%E7%99%BB%E5%B7%B4%E5%B7%B4%E5%9B%BE.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%99%BD%E9%A9%AC%20The%20White%20Horse%20-%20%E7%A9%86%E5%B7%B4%E7%89%B9%E5%B0%94.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E4%B9%8C%E5%B0%A4%E4%BB%A3%20Wuyudai%20-%20%E7%A9%86%E5%B7%B4%E7%89%B9%E5%B0%94.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《柯勒伦河之景》");
                instrument.setMusic_name2("《乌尤代 - 穆巴特尔》");
                instrument.setMusic_name3("《白马 - 穆巴特尔》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t马头琴声音圆润，低回宛转，音量较弱。具有独特的音色，柔和、浑厚而深沉，拉奏起来，特别洪阔、低沉而豪放，富有草原风味。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏马头琴时，通常采取坐姿，将琴箱夹于两腿中间，琴杆偏向左侧。右手执弓时，以虎口夹住弓柄，食指、中指放在弓杆上，无名指和小指控制弓毛。右手弓法有长弓、半弓、短弓、跳弓、连弓、连跳弓、顿弓、打弓、击弓、碎弓和抖弓等，左手指法有弹音、挑音、颤音、打音、滑音、双音、拨弦、揉弦和泛音等技巧，许多装饰音都是由小指奏出的。 \n");
                break;
            case "阮":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">阮");
                instrument.setName("阮");
                instrument.setPic_spe(R.drawable.ruan);
                instrument.setPic_struct(R.drawable.struct_ruan);
                instrument.setBrief1("\t\t阮是一种汉族传统乐器，阮咸的简称。相传西晋竹林七贤之一阮咸善弹此乐器，因而得名。可用于独奏、重奏和歌舞伴奏或参加民族乐队演奏。");
                instrument.setBrief0("\t\t阮意为长颈琵琶，形似今之月琴。结构是直柄木制圆形共鸣箱，四弦十二柱，竖抱用手弹奏。\n" +
                        "    琴头和琴颈是用两块硬质木料胶合而成，琴头顶端多饰以民族风格的雕刻，琴颈上粘有指板，指板上嵌有2 4个音品，品按十二平均律装置。琴身是一个呈扁圆形的共鸣箱，由面板、背板和框板胶合而成。在面板上胶有琴品和开有出音孔。弦轴有4个，除用普通弦轴外，也可用齿轮铜轴。琴弦使用丝弦、肠衣弦或金属弦。");
                instrument.setContent("\t\t阮的起源说法不一，据汉代至魏晋时期的文史资料记载，阮是汉民族自己创造的乐器。也有记载说阮源于中亚，通过龟兹传入我国，在汉时称为秦琵琶，晋代阮咸擅弹此琴。元代时在民间广泛流传，成为人们喜爱的弹拨乐器。\n" +
                        "20世纪50年代对阮进行了一系列改革，使阮具有高音、中音、次中音和低音4个声部，而自成一族。20世纪80年代研制的无品大阮，在琴箱中的高音区支有一根音柱，由于降低了山口和缚弦的高度，琴弦距指板较近，便于演奏。\n ");
                instrument.setPic_position(R.drawable.position_ruan);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xiao.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%A4%A9%E5%B1%B1%E4%B9%8B%E6%98%A5%20-%20%E9%98%AE%E4%BB%95%E6%98%A5.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E4%B8%AD%E5%9B%BD%E9%98%AE%E5%92%B8%E4%B9%90%E5%9B%A2%20-%20%E5%A4%A7%E9%98%AE%E4%B8%8E%E9%98%AE%E5%92%B8%EF%BC%9A%E4%B8%9D%E8%B7%AF%E9%A9%BC%E9%93%83.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("独奏");
                instrument.setMusic_name2("《天山之春 - 阮仕春》");
                instrument.setMusic_name3("《中国阮咸乐团 - 大阮与阮咸：丝路驼铃》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/16Daruan.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：阮多用拨片弹奏，经过演奏者的继承、实践、移植和创造，右手的指法有弹、挑、勾、抹、扣、划、轮、拂、分、摇、扫、滚等30多种，左手指法也有泛、打、带、滑、推、拉、吟、纹等10多种，显著提高了阮的艺术表现力。 \n");
                break;
            case "琵琶":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">琵琶");
                instrument.setName("琵琶");
                instrument.setPic_spe(R.drawable.pipa);
                instrument.setPic_struct(R.drawable.struct_pipa);
                instrument.setBrief1("\t\t琵琶，拨弦类弦鸣乐器，是我国历史悠久的重要民族乐器，被称为“弹拨乐器之王” 。琵琶音域广，演奏技巧为民族器乐之首，表现力更是民乐中最为丰富的乐器。");
                instrument.setBrief0("\t\t琵琶为木制，音箱呈半梨形，上装四弦，原先是用丝线，现多用钢丝、尼龙制成。颈与面板上设用以确定音位的“相”和“品” 。演奏时拨动琴弦使琴弦振动发声，通过共鸣箱放大音源。");
                instrument.setContent("\t\t琵琶已经有二千多年的历史，最早被称为“琵琶”的乐器约在中国秦朝出现。历史上的所谓琵琶，并不仅指具有梨形共鸣箱的曲项琵琶，而是多种弹拨乐器的总称。其名“琵”，“琶”是根据演奏这些乐器的右手技法而来的。也就是说琵和琶原是两种弹奏手法的名称，琵是右手向前弹，琶是右手向后挑。\n" +
                        "    到了南北朝时，从西域传来了一种梨形音箱、曲颈、四条弦的乐器，有人就把它和中国的琵琶结合起来，改制成新式琵琶。到了唐代（公元7-9世纪）琵琶的发展出现了一个高峰。当时上至宫廷乐队, 下至民间演唱都少不了琵琶, 随成为当时非常盛行的乐器, 而且在乐队处于领奏地位。经历代演奏者的改进，至今形制已经趋于统一，成为六相二十四品的四弦琵琶。\n\n ");
                instrument.setPic_position(R.drawable.position_pipa);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%8D%81%E9%9D%A2%E5%9F%8B%E4%BC%8F%20-%20%E7%90%B5%E7%90%B6%20-%20%E7%BA%AF%E9%9F%B3%E4%B9%90.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xiao.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《十面埋伏》");
                instrument.setMusic_name2("《紫竹调》");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t琵琶可独奏、伴奏、重奏、合奏。琵琶发声十分特殊，它的泛音在古今中外的各类乐器中居首位，不但音量大，而且音质清脆明亮。琵琶穿透力强，高音区明亮而富有刚性，中音区柔和而有润音，低音区音质淳厚。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/21Pipa.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：琵琶演奏时左手各指按弦于相应品位处，右手戴赛璐璐（或玳瑁）等材料制成的假指甲拨弦发音。右手有弹、挑、夹弹、滚、双弹、轮等指法，左手有揉、吟、带起、捺打、等技巧。可演奏多种和音、和弦。 \n");
                break;
            case "月琴":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">月琴");
                instrument.setName("月琴");
                instrument.setPic_spe(R.drawable.yueqin);
                instrument.setPic_struct(R.drawable.struct_yueqin);
                instrument.setBrief1("\t\t等待修改。");
                instrument.setBrief0("\t\t月琴是琴弦振动发声，音箱呈满圆形，琴脖短小。全长62厘米、音箱直径36.3厘米。琴颈和音箱边框用红木、紫檀木制，边框用六块规格一致的木板胶接而成，面板和背板桐木制。琴弦用丝弦、尼龙弦或尼龙缠钢丝弦。以钢丝尼龙弦的效果最好。");
                instrument.setContent("\t\t月琴起源于汉代，早在汉武帝时(公元前140年—前87年)，我国汉族已经创造发明了阮，但当时这种以“弹”和“挑”为主要演奏手法的乐器，都笼统地称为琵琶。月琴是从阮演变而来的乐器。当时月琴的形制与阮相近，后来逐渐变化。自晋代起就在民间流行，约从唐代起有月琴之名，取其形圆似月、声如琴。\n ");
                instrument.setPic_position(R.drawable.position_xiao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%9B%9B%E5%AD%A3%E6%98%A5%20-%20%E8%91%A3%E6%B7%BB%E6%9C%A8;%E8%91%A3%E5%BB%B6%E5%BA%AD%28%E6%9C%88%E7%90%B4%29.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%A4%9C%E6%B7%B1%E6%B2%89%20-%20%E9%9B%B7%E7%BE%A4%E5%AE%89.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%98%A5%E4%B9%8B%E5%BD%92%20-%20%E9%9B%B7%E7%BE%A4%E5%AE%89.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《四季春》");
                instrument.setMusic_name2("《夜深沉 - 雷群安》");
                instrument.setMusic_name3("《春之归 - 雷群安》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t月琴的音色悦耳、动听，高音清脆、中音明亮、低音丰满。音量较小，音色清脆柔和，适合抒情性的说唱，可以烘托故事的气氛。亦是少数民族劳动之余、夜晚自娱、讴歌心声的乐器。云南少数民族叫做“弦子”，是成年男子必备之物。月琴既是兄弟民族叠脚跳歌时不可缺少的伴奏乐器，又是小伙子抒发自己情思的特殊工具。由于它音色清脆悦耳，节奏鲜明，轻轻弹动，有如丝丝细雨；急促拨弄，犹如万马奔腾。小伙子们常常用优美的琴声，引来自己心爱的人。 ");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/34Yuqin.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏月琴时，将琴斜抱于胸前，左手持琴按弦，右手用食指或执拨片弹拨琴弦发音。月琴的演奏技巧很丰富，但通常右手为弹、拨、撮、长轮、扫弦等方法，左手为推、拉、揉、移指等方法。 \n");
                break;
            case "古琴":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">古琴");
                instrument.setName("古琴");
                instrument.setPic_spe(R.drawable.guqin);
                instrument.setPic_struct(R.drawable.struct_guqin);
                instrument.setBrief1("\t\t古琴，民族拨弦乐器，中国最古老的弹拨乐器之一。又称瑶琴、玉琴、丝桐和七弦琴，有三千年以上历史，属于八音中的丝。");
                instrument.setContent("\t\t古琴，自古“琴”为其特指，19世纪20年代起为了与钢琴区别而改称古琴。初为5弦，汉朝起定制为7弦，且有标志音律的13个徽，亦为礼器和乐律法器。古琴是汉文化中地位最崇高的乐器，位列中国传统文化四艺“琴棋书画”之首，被文人视为高雅的代表，亦为文人吟唱时的伴奏乐器，自古以来一直是许多文人必备的知识和必修的科目。伯牙、钟子期以“高山流水”而成知音的故事流传至今；琴台被视为友谊的象征，大量诗词文赋中有琴的身影。2003年11月7日，古琴艺术被联合国教科文组织列入世界第2批人类非物质文化遗产代表作名录。2006年5月20日，中华人民共和国国务院将古琴列入第1批国家级非物质文化遗产名录，划分在“民间音乐”类，编号Ⅱ—34。\n ");
                instrument.setPic_position(R.drawable.position_xiao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%8F%A4%E7%90%B4%20%E9%AB%98%E5%B1%B1%E6%B5%81%E6%B0%B4.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%BB%84%E8%8E%BA%E5%90%9F%20%E5%8F%A4%E7%90%B4%20%E7%AE%AB%E4%B8%8E%E7%90%B5%E7%90%B6.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%BE%9A%E4%B8%80%20-%20%E5%B9%B3%E6%B2%99%E8%90%BD%E9%9B%81%20-%20%E5%8F%A4%E7%90%B4%20%E8%90%A7%20%E7%BD%97%E5%AE%88%E8%AF%9A.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《高山流水》");
                instrument.setMusic_name2("《平沙落雁》");
                instrument.setMusic_name3("《黄莺吟》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t古琴的声音非常独特，听时能感到古琴的安静悠远。\n" +
                        "    古琴有三种音，散音、泛音、按音，都非常安静。散音松沉而旷远，令人起远古之思 ；其泛音则如天籁，有清冷入仙之感；按音则变化丰富，时如人语，细微悠长，时如人心之绪，缥缈多变。泛音似天，按音如人，散音则同大地，称为天地人三籁。因此古琴一器具三籁，既可状人情之思，也可达天地宇宙之理。 \n");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/13Guqin.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：。 \n");
                break;
            case "柳琴":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">柳琴");
                instrument.setName("柳琴");
                instrument.setPic_spe(R.drawable.liuqin);
                instrument.setPic_struct(R.drawable.struct_liuqin);
                instrument.setBrief1("\t\t柳琴是汉族传统弹拨乐器，又称柳叶琴、金刚腿或土琵琶。原流行于苏，鲁，皖等省，现流行于全国各地，以山东临沂及苏北一带为主。 属唐代以来在民间流传的梨形音箱弹弦乐器之一，其外形、构造、奏法均与阮相似。最早的柳琴，构造非常简单，由于柳琴的外形非常民间化，中国老百姓亲切地称它“土琵琶”。");
                instrument.setBrief0("\t\t从结构来看:\n" +
                        "1、琵琶音位由品和相组成，而柳琴只由品组成。\n" +
                        "2、其他的结构基本一样,但是柳琴都小很多。\n");
                instrument.setContent("\t\t柳琴原是用作柳琴戏，泗州戏等地方戏曲的伴奏及弹奏简单歌曲，发音响亮宏大，音色高亢刚劲，富有浓郁的乡土气息。经过长时间的发展，现已发展为独奏乐器，并常用于民族乐队中的高音乐器。\n" +
                        "最早的柳琴，构造较简单，只有两条丝弦，7个用高粱秆做成的品位，音域很窄，仅有一个半八度，还不便转调。1958年底，第一代新型柳琴－－三弦柳琴诞生了。三弦柳琴由原来的两根弦变成了三根弦，音柱也由7个增加到24个。\n" +
                        "70年代，出现了第二代新型柳琴－－四弦高音柳琴。第二代新型柳琴除了在琴弦和音柱的数量上又有所增加外，最主要的变化是用竹子代替了高粱秆，用钢丝代替了丝弦。这些改革大大改善了柳琴各方面的性能，丰富了表现力。从而使柳琴结束了200余年来仅仅作为伴奏乐器的历史，走上了独奏乐器的发展道路。\n ");
                instrument.setPic_position(R.drawable.position_liuqin);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%89%91%E5%99%A8-%20%E5%90%B4%E5%BC%BA.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%93%B6%E6%B9%96%E9%87%91%E6%B3%A2%20-%20%E7%8E%8B%E7%BA%A2%E8%89%BA.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%B9%BD%E7%87%95%E6%98%A5%E6%97%A9%20-%20%E5%BC%A0%E5%A4%A7%E6%A3%AE.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《剑器》");
                instrument.setMusic_name2("《银湖金波》");
                instrument.setMusic_name3(" 《幽燕春早》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t在民乐队中，柳琴是弹拨乐器的高音乐器，其音响效果独特，不易被其它乐器所掩盖，常用来演奏高音区的主旋律，有时也演奏华丽、技巧性高的华彩乐段。它既适于演奏欢快、对比强烈、节奏鲜明、富有弹性和活泼的曲调，也适于演奏优美、抒情的旋律，在乐队中能与琵琶、阮、筝和二胡等乐器和谐默契地合作。柳琴还具有西洋乐器曼陀林的音响效果，它与西洋乐队合作时更别有风味，在音色上也能水乳交融、相得益彰。在民间乐队——常州丝弦中，柳琴能与主奏的笛子密切配合，起到陪衬、增强对比和装饰作用。在器乐合奏中，有时它还处于领奏地位，能很好地调节音色变化。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏柳琴时，奏者端坐，将琴斜置于胸前，左手持琴按弦，右手执拨弹奏。演奏技巧右手有弹、挑、双弹、双挑、扫拂和轮奏等，左手有吟弦、打弦、带弦、推拉弦和泛音等，其指法符号均与琵琶的指法符号相同。柳琴可以演奏各种度数的和音与和弦。自然泛音灵敏清晰，效果良好。它的震音奏法也具特色，强奏时紧张热烈，弱奏时安静甜美。");
                break;
            case "古筝":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">古筝");
                instrument.setName("古筝");
                instrument.setPic_spe(R.drawable.guzheng);
                instrument.setPic_struct(R.drawable.struct_guzheng);
                instrument.setBrief1("\t\t古筝，民族弹拨弦乐，又名“秦筝”。有十六弦、十八弦、二十一弦等。");
                instrument.setBrief0("\t\t琴一般长约三尺六寸五（约120—125公分），象征一年三百六十五天（一说象周天365度）；一般宽约六寸（20公分左右）；厚约二寸（6公分左右）。琴体下部扁平，上部呈弧形凸起，分别象征天地，与古时的天圆地方之说相应，整体形状依凤身形而制成，其全身与凤身相应。");
                instrument.setContent("\t\t古筝是一件古老的民族乐器。唐宋时有弦十三根，后最多增至二十五弦。目前最常用的规格为21弦。通常古筝的型号用S163-21，S代表S形岳山，是筝父徐振高发明。163代表古筝长度为163厘米，21代表古筝弦数21根。自秦、汉以来，古筝从我国西北地区流传到全国各地，在不同地域逐渐形成了各具浓郁地方特色的九个流派，分别为：山东筝、河南筝、潮州筝、客家筝、浙江筝、福建筝、内蒙筝（即雅托葛）、朝鲜族的伽揶琴（即延边筝）和被称为真秦之声的陕西筝。\n ");
                instrument.setPic_position(R.drawable.position_guzheng);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%B8%94%E8%88%9F%E5%94%B1%E6%99%9A%20%E5%8F%A4%E7%AD%9D.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%98%A5%E6%B1%9F%E8%8A%B1%E6%9C%88%E5%A4%9C%20-%20%E7%BE%A4%E6%98%9F.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%81%AF%E6%9C%88%E4%BA%A4%E8%BE%89%20-%20%E7%BE%A4%E6%98%9F.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《平沙落雁》");
                instrument.setMusic_name2("《春江花月夜 - 群星》");
                instrument.setMusic_name3("《灯月交辉 - 群星》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t古筝是一种极富表现力的乐器，其音色委婉动听并富有神韵。它可以细致微妙地表达人们的内在情感，无论是如泣如诉、还是高歌吟唱它都可以表现得淋漓尽致。  ");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%8F%A4%E5%8A%8D%E5%A5%87%E8%AD%9A%20%E5%A4%A9%E6%B7%A8%E6%B2%99%20%E5%8F%A4%E7%AE%8F.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：传统的常用演奏采用右手大、食、中、无名四指拨弦，弹奏旋律、掌握节奏，左手在筝柱左侧顺应弦的张力，控制弦音的变化，以调整音高、完善旋律。古筝的指法颇多，右手有勾、托、劈、挑、抹、剔、打、摇、撮等，左手有按、滑、揉、颤等。 \n");
                break;
            case "锣":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">打");
                instrument.setGuide4(">锣");
                instrument.setName("锣");
                instrument.setPic_spe(R.drawable.luo);
                instrument.setPic_struct(R.drawable.struct_luo);
                instrument.setBrief1("\t\t锣是中国传统的打击乐器，在中国的民族乐队中占有非常重要的地位，而且应用范围也很广泛，它不仅在民族乐队、民间器乐合奏、各种戏曲、曲艺以及歌舞伴奏中使用，而且也是庆祝集会中不可缺少的乐器。");
                instrument.setBrief0("\t\t锣结构简单，由锣体、锣架(锣绳)、锣棰三部分组成。锣体铜制，因用“响铜”制成，故也有“响器”之称。锣体呈一圆盘形，四周以本身边框固定，用锣棰敲击中央部分振 动发音。");
                instrument.setContent("\t\t最早使用铜锣的是居住在中国西南地区的少数民族，云南是中国古代铜鼓的发祥地。到了公元前二世纪左右，铜锣在战争中应用比较广泛，中国古代的军事术语“鸣金收兵”中的“金”就是古代铜锣的别称。到了宋代，锣在民间音乐形式“ 鼓板”中被应用。到了元代，除民间的迎赛神社常常鸣锣外，锣还是杂剧的主要伴奏乐器。近百年来，锣在地方戏曲、民间音乐、民间娱乐和节庆活动中被广泛应用。\n ");
                instrument.setPic_position(R.drawable.position_luo);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xiao.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xiao.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("独奏");
                instrument.setMusic_name2("合奏");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t锣属于金属体鸣乐器，发音宽宏，深沉而雄厚，音色柔和，余音比较长；在大型乐队中，大锣往往起到渲染气氛和增强节奏的作用，而在戏剧中则用以增强气氛和突出人物性格，具有十分独特的艺术效果。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：大锣发音较低，锣边钻孔系绳，左手提起或挂于架上，右手执棰击奏；小锣发音较高，锣面呈坡形，锣脐分大、中、小三种，有高音、中音和低音之分，锣边无孔，不系锣绳，以左手食指关节处提锣内缘 ，右手执锣板击奏；掌锣是锣中最小的一种，锣面平坦无脐，形如盘状，置于左手掌中，右手执锣板击奏；云锣是锣中可演奏旋律的乐器，由十面小锣组成，用绳系于木架上，左手执 架柄，右手用锣棰击奏 。 \n");
                break;
            case "钹":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">打");
                instrument.setGuide4(">钹");
                instrument.setName("钹");
                instrument.setPic_spe(R.drawable.bo);
                instrument.setPic_struct(R.drawable.struct_xiao);
                instrument.setBrief1("\t\t钹，互击体鸣乐器，古称铜钹、铜盘，民间称镲。打击乐器。碰奏体鸣乐器的一种。中国、外国乐队中都使用。中国古代把铜钹、铜铙或铜盘等，统称为铙钹。");
                instrument.setBrief0("\t\t钹的构造简单，钹体为一圆形金属板，用“响铜”制成，中部隆起的半球形部分称“碗”或“帽”，碗根与钹边之间叫作“堂”，碗是钹的固定点，顶部钻有小孔，用绸或布拴系，叫“钹巾”，演奏者须取站姿，用双手通过钹巾持住钹身，相击后振动发音。也可以悬挂在支架上，用鼓槌滚奏，表现力很丰富。\n" +
                        "钹属于金属体鸣乐器，无固定音高。其音响洪亮而强烈，穿透力很强，善于烘托气氛，是各种管弦乐队和地方吹打乐队中必不可少的色彩性打击乐器，在吹打乐等地方乐种中在用于强奏时，极富气势，通常表现一种激情；用于弱奏时，其作用类似大鼓，属于节拍乐器。\n");
                instrument.setContent("\t\t钹源于西亚，最早在埃及、叙利亚，以后在波斯、罗马等古国都有流传；在东方，先见于印度，后而中亚，据《北帝书.神武记》记载，钹大约是在公元350年随《天竺乐》传入我国中原。南北朝时有钹，6世纪初期，铜钹在北魏民间已很流行，并很早就在梵乐中使用。明清后成为戏曲的重要伴奏乐器。\n ");
                instrument.setPic_position(R.drawable.position_bo);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xiao.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xiao.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("独奏");
                instrument.setMusic_name2("1、铁龙山（京剧）");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t钹属于金属体鸣乐器，无固定音高。（有些音色柔软而优雅，而有些尖锐响亮。）其音响洪亮而强烈，穿透力很强，善于烘托气氛，是各种管弦乐队和地方吹打乐队中必不可少的色彩性打击乐器，在吹打乐等地方乐种中在用于强奏时，极富气势，通常表现一种激情；用于弱奏时，其作用类似大鼓，属于节拍乐器。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏时，双手各持一面互击。有轻击、重击、磨击、扑击等手法。另有单击音，用小棰敲击单片钹沿，获其特殊音响效果，演唱者右手执钹，拇指上套一瓷环，可碰击钹的边缘作响，左手持一小棍敲击，以击节说唱。\n");
                break;
            case "排鼓":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">打");
                instrument.setGuide4(">排鼓");
                instrument.setName("排鼓");
                instrument.setPic_spe(R.drawable.paigu);
                instrument.setPic_struct(R.drawable.struct_paigu);
                instrument.setBrief1("\t\t排鼓，鼓类乐器的新品种，属于打击乐器。");
                instrument.setBrief0("\t\t排鼓由鼓皮、鼓胆、鼓架、鼓棒组成。排鼓由五个大小不同、发音有别的鼓组成一套。鼓身高29至33.3厘米，上口面直径16.7至37厘米，下口面直径11.7至37厘米。吉林省歌舞剧院于延河与苏州民族乐器三厂合作，研制成由十三面鼓组成的排鼓，鼓身用玻璃钢制作，鼓和架为插口式结合，结构新颖，已用于舞台演出。");
                instrument.setContent("\t\t1959年中央广播民族乐团根据浙江吹打乐中鼓的组合特点，在堂鼓基础上研製而成的一种“套鼓”，鼓框二端厚度不等，有效振动面积大小不一，发音高度相差一个小三度，把鼓框固定於“U”型鼓架上，可以随意升高或降低，亦可改变敲击角度。排鼓一套四个，各鼓大小不一，称一号鼓、二号鼓、三号鼓、四号鼓，或中堂鼓、次中堂鼓、小堂鼓和高音堂鼓，由低音到高音依次排列。1963年又增加了一个花盆鼓。以后再经改进，扩大了音域，每鼓均能在四至六度以内的调定音。\n ");
                instrument.setPic_position(R.drawable.position_paigu);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xiao.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%90%88%E5%A5%8F%20%E7%8B%AE%E5%AD%90%E6%88%8F%E9%93%83.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%90%88%E5%A5%8F%20%E6%8E%92%E5%B1%B1%E5%80%92%E6%B5%B7.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("独奏");
                instrument.setMusic_name2(" 《狮子戏铃》");
                instrument.setMusic_name3("《排山倒海》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t每个鼓的两面鼓框外径相同而内径不一，可发出音高不同的两个音来，故五个鼓有十个音。每个鼓的两面都装有调音设备，调音幅度可达四或五度，可根据实际需要定音。排鼓发音激烈、跳荡，高音坚实有力，中、低音宽厚宏亮，尤擅于表现热烈欢腾的情绪。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：排鼓的击鼓要领和动作与大鼓相同。手指、腕、臂的力量协调运动的发力之源来自腰部。换言之，腰部力量是敲击排鼓的发力之源。“人之驱，腰为中”腰部在行走，立走时起着平衡身体的作用，而发力时，则反映在大脑指挥下的力量储备，腰部力量为发力点。并使鼓皮自上而下地充分振动，（似乎要让大地发出声音，这就是通常所说的把声音打透）。用力方式主要体现于形式不同的触击速度；传力方式主要体现于触击手指或手部的支撑形式，这都是决定击鼓速度的关键的因素。 \n");
                break;
            case "大鼓":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">打");
                instrument.setGuide4(">大鼓");
                instrument.setName("大鼓");
                instrument.setPic_spe(R.drawable.dagu);
                instrument.setPic_struct(R.drawable.struct_dagu);
                instrument.setBrief1("\t\t大鼓是民族打击乐器，属于双面膜鸣乐器。");
                instrument.setBrief0("\t\t由鼓身、鼓皮、鼓圈、鼓卡和 鼓棰等部分组成。使用材质：鼓身：原来木质或轻金属材料，现改用较轻的合成纤维材料制造；鼓皮：原来用动物皮革制作，近年已全改用塑胶或纤维鼓面；鼓圈和鼓卡：目前多用铝合金制成。鼓棰：短而粗的木棰，一端包以皮条、布料或绒毡，呈球状。");
                instrument.setContent("\t\t现代大鼓起源于古代土耳其，因此又称大军鼓，中世纪时传入欧洲。是军乐队、管弦乐队和交响乐队中最重要的打击乐器，几乎不作独奏，而是参与合奏或衬托乐队和声的伴奏乐器。此外大鼓的地位非常重要，它不仅使乐队的低音声部更加充实、丰满，而且可以为整个乐队带来一种气势。\n ");
                instrument.setPic_position(R.drawable.position_dagu);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xiao.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xiao.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("独奏");
                instrument.setMusic_name2("合奏");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t大鼓属于双面膜鸣乐器，无固定音高，但可控制发音的强弱变化。用鼓锤敲击发音，通过用力的变化来表现出不同的音乐情绪。轻滚奏时会营造深沉或不安的感觉；重击则制造惊吓、恐俱、愤怒或激动的内心情感，或是表达炮火、雷电的景象；至于在进行曲中大鼓可以营造出威武、整齐的感觉。 ");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/dagu.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：右手执槌（桴）打鼓，左手执槌敲吊钟，敲打的时候，必须注意“节拍、板眼”，不可错乱。\n" +
                        "“手鼓”的拿法和敲法是：不敲时，两手捧持；椎横摆在鼓的外面，用两食指与两中指托住，两大指挟在鼓内，其余四指（两无名指与两小指）环摆着。敲击时左手持鼓，右手执槌。持鼓是以左手大指和食指，中指托之。执槌是以右手大指、食指和中指合持，向内敲之。另有一种如团扇形有柄的单面“手鼓”，则用左手握持其柄便可。\n \n");
                break;
            case "木鱼":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">打");
                instrument.setGuide4(">木鱼");
                instrument.setName("木鱼");
                instrument.setPic_spe(R.drawable.muyu);
                instrument.setPic_struct(R.drawable.struct_muyu);
                instrument.setBrief1("\t\t木鱼，打击乐器,原为佛教“龚吹”（宗教歌曲）的民族乐器。木鱼之名称由来，盖取“鱼日夜不合目”，故刻木象鱼，击之，用以诫昼夜思道。");
                instrument.setBrief0("\t\t木鱼由樟树制成，呈团鱼形，腹部中空，头部正中开口，尾部盘绕，其状昂首缩尾，背部（敲击部位）呈斜坡形，两侧三角形，底部椭圆；木制棰，棰头橄榄形。寺庙中使用的木鱼，大致分为两种：一种为圆形，另一种是长条形的。一般来说，圆形木鱼的规格多种多样（直径范围在5-58cm），而长条形的木鱼大多在一米左右。木鱼本身的材料发声，不需要弦或者拉伸的表面。");
                instrument.setContent("\t\t根据历代崇道记的记载 ，木鱼是出自唐代，明皇帝时期，是道教召集教众，讲经设斋用得法器，源于道教。现今台北金山乐园中，安有一高七尺半、宽六尺的巨型木鱼，并撘配一支长八尺四寸，重六十公斤的大木槌，全部由樟木雕造而成，堪称一绝。木鱼用于保持佛教诵经的节奏，另外也被运用到爵士乐。小号的木鱼可以拿在手里进行演奏，大号的则是放在毯子上的。\n ");
                instrument.setPic_position(R.drawable.position_muyu);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xiao.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xiao.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("独奏");
                instrument.setMusic_name2("合奏");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t木鱼大小不一，音高不同。 发音短促，音色清脆洪亮，是富有特色的节奏乐器。常用于戏剧、曲艺伴奏、器乐合奏、民族乐队和宗教音乐中。木鱼在戏剧中，用于昆曲、京剧、晋剧(山西中路梆子)和藏戏等剧种的伴奏。广东音乐使用的是长鱼形木鱼，在合奏中有时要使用大小两个木鱼，大木鱼发低音，小木鱼发高音。在民族乐队中，常备有音高不同、数量不等的整套团鱼形木鱼，它们按五声、七声音阶或十二平均律编排成套，多用于配合轻快活泼的曲调，有时也用以敲出简短的独奏乐句，还可用来模仿战马奔驰的音响效果。在佛教、道教音乐中，木鱼既是法器，又是离不开的节奏乐器。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/19Muyu.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏时，大团鱼形木鱼需置于地面上，小圆鱼形木鱼则用左手托持，右手执棰头呈橄榄形的木棰敲击。 \n");
                break;
            case "扬琴":
                instrument.setGuide2(">民族乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">扬琴");
                instrument.setName("扬琴");
                instrument.setPic_spe(R.drawable.yangqin);
                instrument.setPic_struct(R.drawable.struct_yangqin);
                instrument.setBrief1("\t\t扬琴，民族击弦乐器，又称洋琴、打琴、铜丝琴、扇面琴、蝙蝠琴、蝴蝶琴，是中国民族音乐中，一种兼具打击乐器及弦乐器特点的乐器，是中国民族乐队中必不可少的乐器，与钢琴同宗。");
                instrument.setBrief0("\t\t扬琴由共鸣箱、山口、弦钉、弦轴、马子、琴弦和琴竹等构成。传统扬琴框架用色木、桦木或榆木制，上蒙白松或桐木面板，下蒙胶合板，音箱呈蝴蝶形或扁梯形。扬琴在演奏时，演奏者双手使用两支琴笕（也叫作“琴竹”）弹击琴弦，琴弦因弹击振动而发音后，通过琴码传导，引起面板和梯形共鸣箱内的空气共振，而产生音响共鸣发声。");
                instrument.setContent("\t\t扬琴是明朝末期由波斯传入，最初是为曲艺伴奏，并形成多种流派。据史书记载，中世纪以前，亚叙、波斯等古代中东国家，流行着一种弦击乐器，名叫萨泰里琴。明朝（1368~1644年），随着中国和西亚、东亚间日趋密切的友好往来，萨泰里琴由波斯经海路传入我国，最初只流行在广东一带，后来逐渐扩散到中国各地。后来经过中国民间艺人的改造，萨泰里琴渐渐演化成为中国的民族乐器──扬琴。清末民初，许多民间器乐演奏形式，作为独立的乐种兴起，扬琴又成为广东音乐、江南丝竹和山东琴曲等乐种的主要乐器之一。扬琴在我国经过近400年的流传和演进。\n ");
                instrument.setPic_position(R.drawable.position_yangqin);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/duzou_xiao.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/hezou_xiao.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("独奏");
                instrument.setMusic_name2("合奏");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t扬琴音色具有鲜明的特点，声音宏大且 刚柔并济。慢奏时，音色如叮咚的山泉，快奏时又如潺潺流水。扬琴的音色丰富多彩，低音区发音朦胧、雄厚而深沉；中音区柔和、纯净而透明；高音区清脆、明亮；最高音区则较紧张。演奏旋律时主要用中音和高音区，有时也接触到最高音区，但很少使用。 ");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/32Yangqin.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：我国扬琴已自成一体，具有丰富多彩的演奏技巧和表现手法。归纳起来，大致可分为七类：单音技术、双音、轮音、弹轮、分解和弦、两声部配置和色彩技巧。其中单音技术和轮音系扬琴的基本核心技巧。扬琴的基本竹法是两手轮流交替。传统竹法有“左竹法”和“右竹法”两种。五十年代未王沂甫先生总结出弹、轮、颤、滑、点、拔、揉、勾”扬琴八法。随着扬琴的发展，过去单一竹法已变成充分发挥两手主动性、灵活方便的混合竹法。 \n");
                break;
            case "小号":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">小号");
                instrument.setName("小号");
                instrument.setPic_spe(R.drawable.xiaohao);
                instrument.setPic_struct(R.drawable.struct_xiaohao);
                instrument.setBrief1("\t\t\t小号，俗称小喇叭，属铜管乐器，常负责演奏旋律部分或高亢节奏部分，是铜管乐器家族中音域最高的乐器。");
                instrument.setBrief0("\t\t\t小号由号嘴，管体和机械三部分组成，管长1.355米，通常由带一个或两个弯的长圆筒形金属管构成,其终端呈喇叭形。机械部分由活塞和活塞套组成，通过按下活塞接通旁路管以达到延长号管的目的。活塞分为直升式和回旋式两种。");
                instrument.setContent("\t\t\t小号是种古老的乐器，它的首次记载是在公元前15世纪的古埃及人和日尔曼部落的图画中被提及。中世纪出现了大量新形式的小号。像基督教使用的乐器，专门用来使敌人受到惊恐。文艺复兴提高了小号在皇家宫廷的地位，这种乐器更多的被用来作为“音乐的”来演奏。 巴洛克时期，18世纪中叶活塞和按键的增加，使其在管弦乐作品中被频繁使用。1827年德国出现了活塞式小号。直到18世纪末，才逐步形成现在这种带有三个活塞，能演奏半音阶的小号和短号。 \n ");
                instrument.setPic_position(R.drawable.position_xiaohao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Flag%20%28trumpet%20solo%29.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E8%AF%95%E9%9F%B3%E7%A2%9F%20-%20%E5%B0%8F%E5%8F%B7%20-%20%E5%8D%A1%E9%97%A8%E5%BA%8F%E6%9B%B2.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%B0%8F%E5%8F%B7%20%E8%A5%BF%E7%8F%AD%E7%89%99%E6%96%97%E7%89%9B%E5%A3%AB%E8%BF%9B%E8%A1%8C%E6%9B%B2.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《Flag (trumpet solo)》");
                instrument.setMusic_name2("《试音碟 - 小号 - 卡门序曲》");
                instrument.setMusic_name3("《西班牙斗牛士进行曲》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t小号音色强烈、锐利、极富辉煌感，声音嘹亮、清脆、高亢，具有高度的演奏技巧和丰富的表现力，是铜管族中的高音乐器。小号作为独奏或重奏乐器，可以演奏辉煌的号召性的音调，也可以演奏宽广的、抒情的或技巧难度大的华彩性乐段。小号的音色能较好地同其他乐器的音色融合在一起。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/video_xiaohao.mp4");
                instrument.setSkill("\t\t\t\t\t\t\t\t演奏技巧：演奏者可以通过控制嘴唇间的空隙、呼气量及震动的力度来改变音调、音量及音饰。小号可自如地吹奏八度内各种音程的跳动，可以自如地演奏音阶、半音阶以及分解和弦。快速演奏时，上行的连音比下行的连音自如。舌奏有三种方法：单吐法，双吐法，三吐法。 \n");

                break;
            case "短笛":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">短笛");
                instrument.setName("短笛");
                instrument.setPic_spe(R.drawable.duandi);
                instrument.setPic_struct(R.drawable.struct_duandi);
                instrument.setBrief1("\t\t\t短笛长约33cm，直径13mm，长度是普通长笛的一半。其发音原理是依靠管内空气振动发声。短笛可以是由木、金属、塑胶或化合物构成。");
                instrument.setBrief0("\t\t\t短笛，吹奏气鸣木管乐器。短笛是长笛家族的一种变种乐器，名称来源自于意大利 “flauto piccolo”（缩小的长笛），是音域最高的木管乐器，也是交响乐队中音域最高的乐器之一。");
                instrument.setContent("\t\t\t早期的短笛是没有按键的，这亦是短笛常与另一种同样是横吹的鼓笛（fife）混淆的原因。短笛最初常被用作伴奏乐器，作为“装饰”乐曲之用。但是，在巴洛克时期，已经出现了很多为短笛而写的协奏曲及独奏曲，其中最早将短笛运用于管弦乐团的作品是贝多芬的《第5号交响曲》。现在，短笛已成为交响乐团中的常规木管乐器，自浪漫乐派后期起，更常出现有短笛的独立声部。");
                instrument.setPic_position(R.drawable.position_duandi);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Bach%20and%20Rossini.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Michael%20Copley%20-%20Vivaldi_%20Flautino%20Concerto%20in%20A%20minor,%20R.445%20-%202.%20Larghetto.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Dorothee%20Oberlinger%20-%20Concerto%20In%20E%20Minor%20Per%20Flautino,%20Rv%20445%20Iii.%20Allegro.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《Bach and Rossini》");
                instrument.setMusic_name2("Vivaldi_ Flautino Concerto in A minor, R.445 - 2. Larghetto");
                instrument.setMusic_name3("（Dorothee Oberlinger - Concerto In E Minor Per Flautino, Rv 445 Iii. Allegro）");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t短笛由于音色尖锐， 富于穿透力，有节制，审慎地使用可使整个乐队的乐声更加响亮、有力而辉煌，常用来表现胜利凯旋、热烈欢舞或描写暴风雨中的风声呼啸等。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/video_duandi.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏时双手持笛，坐立皆可，采用胸腹混合式呼吸法，双唇构成一定的基本口型，气流集中冲击吹口盖与孔壁构成的75°锐角发音。\n" +
                        "其特殊技巧有：泛音、滑音、同时哼唱、模拟打击乐、呼啸奏法等。\n");

                break;
            case "长笛":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">长笛");
                instrument.setName("长笛");
                instrument.setPic_spe(R.drawable.changdi);
                instrument.setPic_struct(R.drawable.struct_changdi);
                instrument.setBrief1("\t\t\t\t长笛，气鸣吹奏木管乐器，是现代管弦乐和室乐中主要的高音旋律乐器，也是重要的独奏乐器。奏法繁多，表现力丰富，与弦乐、木管、铜管乐器亲和力强。");
                instrument.setBrief0("\t\t\t\t长笛由笛头、笛尾和管身三部分组成。全长62厘米，笛头闭塞，塞头距管端约5厘米，笛尾开放。为便于携带与调音，由2或3段插接组成。笛身为圆柱体，内径1.9厘米，从与笛身插接处起，其内径至塞头渐缩细为1.71厘米。椭圆吹孔，上覆吹孔盖，盖面与孔壁形成锐角，吹奏时气流即冲击边棱，激棱发音，管壁开指键孔若干，用指尖控制音键启闭，以变换开管长度，产生不同音高。                                                                                                                                                         \n" +
                        "         早期的长笛是乌木或者椰木制，现代多使用金属的材质，比如普通的镍银合金到专业型的银合金，9K和14K金等。\n");
                instrument.setContent("\t\t\t\t据记载，长笛起源于欧洲，初名横笛。最初是以竹子制造的，和我国的笛子相似，后来改为以木质制作。到了18世纪末、19世纪初，随着工业的不断发展，金属材料的长笛开始问世。19世纪初，随着特奥巴尔德·波姆发明的按键装置，使长笛成为十二平均律乐器，在音准、音色、音量及音域等方面，都比老式长笛有了革命性发展，极大地丰富了长笛的演奏技能。在海顿时期（1732-1809），长笛已成为交响乐队中的固定乐器。\n");
                instrument.setPic_position(R.drawable.position_changdi);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%82%B9%E9%9B%AA%E6%A2%85%20-%20%E5%A8%81%E5%B0%BC%E6%96%AF%E7%8B%82%E6%AC%A2%E8%8A%82%28Genin%29.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Le%20Cygne%20%28Saint-Saens%29.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Various%20Artists%20-%20Quartet,%20K.%20285%20D%20Major,%20Allegro.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《Syrinx For Solo Flute》");
                instrument.setMusic_name2("Various Artists - Quartet, K. 285 D Major, Allegro");
                instrument.setMusic_name3("Rotterdam Philharmonic Orchestra - Menuet from L'Arlesienne");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t长笛音色柔美清澈，音域宽广；中、高音区明朗如清晨的第一缕阳光；低音区婉约如冰澈的月光；而且擅长花腔，演奏技巧华丽多样。长笛震慑人心的音色总是和魔性联系在一起，比如莫扎特的歌剧《魔笛》 。 \n");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t长笛在演奏时，演奏者双手持笛，坐立皆可，采用胸腹混合式呼吸法，双唇构成一定的基本口型，气流集中冲击吹口盖与孔壁构成的75度锐角发音。\n");
                break;
            case "短号":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">短号");
                instrument.setName("短号");
                instrument.setPic_spe(R.drawable.duanhao);
                instrument.setPic_struct(R.drawable.struct_duanhao);
                instrument.setBrief1("\t\t\t\t短号，铜管乐器。短号是小号的变形乐器，通常只用于军乐队和舞厅乐队，很少用于管弦乐队。另外还有降E调短号，使用较少。 ");
                instrument.setBrief0("\t\t\t\t短号长度从35.5公分(14英寸)到66公分为(26英寸)不等。短号是唇振动气鸣乐器，常用音域与小号相同，不过因为圆锥管占的比例高，管的弯曲多，所以有圆滑柔和的音，转音也很顺畅。");
                instrument.setContent("\t\t\t\t由法国一名乐器制造商于1820年代在德国的驿车号上添加活塞机制，结果演变为今日的短号。1828年后，巴黎的管弦乐团首先采用短号，1834年，制造商又在短号上加装  「钟锤键」，以便能吹出颤音，从此短号从法国立刻流传到全欧洲与美国。19世纪末叶，许多管弦乐曲的小号声部都用短号代替。");
                instrument.setPic_position(R.drawable.position_duanhao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Herbert%20L.%20Clarke%20From%20The%20Shores%20of%20The%20Mighty%20Specific;%20Rondo%20Caprice%20%28LP%20Version%29%20%281903%29%20%281%29.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Frank%20Simon%20Willow%20Echoes%20%281918%29%20%28LP%20Version%29.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Matthew%20Locke%20Music%20for%20His%20Majesty%27s%20Cornetts%20and%20Sackbuts%20-%20Air.%20Courante.%20Allemande.%20Courante.%20Allemande.%20Sarabande.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("赫伯特L.克拉克的回旋随想曲（Rondo Caprice（唱片版）（1903）Herbert L. Clarke From The Shores of The Mighty Specific; Rondo Caprice (LP Version) (1903)）");
                instrument.setMusic_name2("Matthew Locke Music for His Majesty's Cornetts and Sackbuts - Air. Courante. Allemande. Courante. Allemande. Sarabande");
                instrument.setMusic_name3("《苏格兰御林军皇家礼赞》\n" +
                        "        演奏 苏格兰御林军皇家乐队\n");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t短号音色柔和，优美，富有歌唱性，但不够辉煌；一些抒情动听的旋律往往由它来演奏，像俄罗斯作曲家柴柯夫斯基的著名舞剧“天鹅湖”中一些独奏段落就是用短号演奏的。短号在管乐队里用得比较多，这是因为管乐队硬音乐器比较多，用短号可以调节乐队的音色，有的乐队铜管高音声部全部用短号，使乐队音响效果更柔和动听。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/In%20the%20Gloaming%20-%20featuring%20James%20McCabe%20on%20Bb%20Cornet.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：在管乐演奏中，往往通过舌头达不到一定吐音速度时，就需借助双吐这种演奏方法。简单来说就是TU，KU，TU，KU交替，第二下通过气流阻断声音，达到吐音目的。阀门颤音是快速敲击阀门来演奏两个音。");
                break;
            case "长号":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">长号");
                instrument.setName("长号");
                instrument.setPic_spe(R.drawable.changhao);
                instrument.setPic_struct(R.drawable.struct_changhao);
                instrument.setBrief1("\t\t\t\t长号：铜管乐器。长号是瑶、壮、苗、彝、哈尼、布依、土家、维吾尔、汉等族唇振气鸣乐器。流行于中国各地，尤以广西、云南、贵州、新疆等省、区最为盛行。");
                instrument.setBrief0("");
                instrument.setContent("\t\t\t\t长号是由文艺复兴时期的萨克布号发展来的，第一支长号出现在15世纪中期的勃艮第法庭。在17世纪和18世纪时，长号常被用于一些表现超自然场景的歌剧。\n");
                //
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%92%8C%E5%B9%B3%E9%A5%AD%E5%BA%97%E6%8F%92%E6%9B%B2.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Arthur%20Pryor-%20Polka-Exposition%20Echoes%20%28Ca.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%95%BF%E5%8F%B7%E5%92%8C%E5%A4%A7%E5%8F%B7%E6%BC%94%E5%A5%8F%E7%9A%84%20%E9%A9%AC%E5%88%80%E8%88%9E%E6%9B%B2.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《嘎达梅林》");
                instrument.setMusic_name2("《马刀舞曲》");
                instrument.setMusic_name3("《波尔卡博览会的回声》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t发声原理：管内空气振动发声。音色高亢，辉煌，庄严壮丽而饱满，声音嘹亮而富有威力，弱奏时又温柔委婉。其音色鲜明统一，在乐队中很少能被同化，甚至可以与整个乐队抗衡。能演奏半音音阶和独特的滑音，常演奏雄壮乐曲的中低音声部。军乐队中是用来演奏威武的中低音旋律的主要乐器。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：吹奏不同的音高，一是靠改变嘴唇的压力，可以吹出泛音列，二是靠发音管的伸缩。吐音技巧有单吐、双吐、三吐。音响力度上的音色变换技巧，强奏时宏亮、庄严、辉煌，弱奏时圆润柔和。滑音技巧是长号独有、独特的技巧，其它的管乐器均不能运用此技巧。\n");
                break;
            case "圆号":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">圆号");
                instrument.setName("圆号");
                instrument.setPic_spe(R.drawable.yuanhao);
                instrument.setPic_struct(R.drawable.struct_yuanhao);
                instrument.setBrief1("\t\t\t\t圆号：唇振动气鸣乐器，又称法国号，英语french horn。铜管乐器，铜制螺旋形管身，漏斗状号嘴，喇叭口较大，通常有4个键。圆号被称作交响乐中的乐器之王。圆号声音柔和、丰满，和木管、弦乐器的声音能很好地融合。在交响乐队中 ，通常使用4支圆号。");
                instrument.setBrief0("\t\t\t\t结构组成：号嘴，管体和机械三部分。管长3.930米，管体弯成圆形，整个管体拐弯较多机械部分使用回旋式活塞，通过按下活塞键使活塞回转接通旁路管以达到延长号管的作用。常见有三键，四键和五键圆号。");
                instrument.setContent("\t\t\t\t圆号又称法国号，法语为cor。圆号发源于欧洲，它的祖先可以追溯到三干多年以前。在中古时期，尚以采集野果、狩猎为生的人类，用牛、羊等兽角制成了可以发出声音的器具——号角，用以互相传递信息。\n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Arthur%20Pryor-%20Polka-Exposition%20Echoes%20%28Ca.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Wolfgang%20Amadeus%20Mozart%20Clarinet%20Concerto%20In%20A,%20K.622%20-%202.%20AdagioA%E5%A4%A7%E8%B0%83%E5%8D%95%E7%B0%A7%E7%AE%A1%E5%8D%8F%E5%A5%8F%E6%9B%B2%EF%BC%8C%E4%BD%9C%E5%93%81K.622.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Wolfgang%20Amadeus%20Mozart%20Clarinet%20Concerto%20In%20A,%20K.622%20-%203.%20Rondo%20%28Allegro%29A%E5%A4%A7%E8%B0%83%E5%8D%95%E7%B0%A7%E7%AE%A1%E5%8D%8F%E5%A5%8F%E6%9B%B2%EF%BC%8C%E4%BD%9C%E5%93%81K.622.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《波尔卡博览会的回声》");
                instrument.setMusic_name2("《降E大调4号圆号协奏曲K.495 华彩乐段：彼得•丹姆 快板(庄重)》");
                instrument.setMusic_name3("《降E大调4号圆号协奏曲K.495 华彩乐段：彼得•丹姆 浪漫曲(行板）》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t圆号的音色富于诗意的，表现力很丰富，强奏时饱满有力，其中高音区具有洪亮、辉煌的气质。圆号的音色还能与弦乐组乐器很好地融合。在圆号上还有几种常用的特殊音色，它们是随着演奏手法的不同而产生变化的 。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：细长的圆锥形管身卷曲成圆形，号嘴为漏斗形，喇叭口较大。圆号一般三个阀键，三个阀键综合变换使用，可吹出音域内所有半音阶。\n");
                break;
            case "大号":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">大号");
                instrument.setName("大号");
                instrument.setPic_spe(R.drawable.dahao);
                instrument.setPic_struct(R.drawable.struct_dahao);
                instrument.setBrief1("\t\t\t\t大号是一种管乐，管弦乐队中音域最低的铜管乐器。大号在乐队中主要担任低音部和声或节奏，很少用于独奏。 ");
                instrument.setBrief0("\t\t\t\t大号是铜管乐器中号管最粗、最长的乐器，长度为270厘米至590厘米不等，由喇叭口、吹管、吹嘴、活塞及排水口等部件组成。发声原理为管内空气振动发声。 \n" +
                        "大号的外形大都是椭圆形（苏萨号除外），号管的圆柱形部分与圆椎形部分界限比较明显，吹奏时，号管细的部分是空气柱振动分段的地方，号管粗的部分则是共鸣体。大号使用杯形号嘴，内膛较深，不同型号的号嘴内壁的弯充不一样，因此，发出的声音效果有区别。内壁弯度大的号嘴发音敏感，声音明亮；内壁弯度小的号嘴发音柔和，声音稍暗、宽厚一些。");
                instrument.setContent("\t\t\t\t大号从古老的奥非克莱德号演变而来，奥非克莱德的前身是16世纪末意大利所创制的蛇形大号。\n" +
                        "近代定型的第一个大号，19世纪30年代出现于德国。柏辽兹是第一个在作品中使用大号的作曲家，伏昂．威廉斯曾为大号谱写了一首协奏曲，里姆斯基——科萨科夫、柴科夫斯基、理查．斯特劳斯等作曲家在他们的作品中都很有特色地运用了大号。1945年以后，出现了一个重新起用和发展大号性能的时期，爵士乐师、先锋派和流行音乐作曲家使大号有了新的特点。 \n");
                instrument.setPic_position(R.drawable.position_dahao);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Capriccio%20for%20solo%20tuba.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Paganini%20Three%20Duets%20For%20Violin%20And%20Bassoon%20M.S.130%E5%B8%95%E6%A0%BC%E5%B0%BC%E5%B0%BC%EF%BC%9A%E7%AC%AC%E4%B8%89%E5%8F%B7%E5%B0%8F%E6%8F%90%E7%90%B4%E4%B8%8E%E5%B7%B4%E6%9D%BE%E7%AE%A1%E4%BA%8C%E9%87%8D%E5%A5%8F%20%E4%BD%9C%E5%93%81130.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Antonio%20Vivaldi%20-%20Concerto%20For%20Violin%20And%20Strings%20In%20E,op.8,no.1,r.269la%20Primavera%20-%201.%20Allegro%20-%20%E7%BA%AF%E9%9F%B3%E4%B9%90%E7%89%882.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《大号独奏随想曲》Capriccio for solo tuba");
                instrument.setMusic_name2("《大号波尔卡》");
                instrument.setMusic_name3("《查尔达斯舞曲》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t大号音色低沉、浑厚、饱满，既有辉煌的一面，又有非常柔和、优美的效果。\n" +
                        "大号使用杯形号嘴，内膛较深，不同型号的号嘴内壁的弯充不一样，因此，发出的声音效果有区别。内壁弯度大的号嘴发音敏感，声音明亮；内壁弯度小的号嘴发音柔和，声音稍暗、宽厚一些。\n" +
                        "在世界范围内，降B调大号的使用最广泛，其次是降E调，C调大号等。中国主要用降B调大号。\n");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/Penderecki%20-%20Capriccio%20for%20Tuba%20Solo.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：正确的呼吸方法和最佳的嘴唇振动相配合，就能发出饱满动听的声音。要达到最佳的嘴唇振动就要做出正确的口型。 吹奏大号的基本口型：嘴在自然状态的基础上稍有微笑状，唇尖微张开形成一个枣核形的风孔，下颚稍向前，让上下牙在一条竖线上，唇尖肌肉保持自然放松。");
                break;
            case "单簧管":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">单簧管");
                instrument.setName("单簧管");
                instrument.setPic_spe(R.drawable.danhuangguan);
                instrument.setPic_struct(R.drawable.struct_danhuangguan);
                instrument.setBrief1("\t\t\t\t单簧管，又称黑管或克拉管，有管弦乐队中的“演说家”和木管乐器中的“戏剧女高音”之称。单簧管又细分为：A调单簧管、高音单簧管、中音单簧管、低音单簧管。");
                instrument.setBrief0("\t\t\t\t单簧管似圆柱形，像长笛。机械指键操作部分（上节管与下节管）呈圆柱形，吹口管（笛头）则是呈圆锥形。管体分为吹嘴、卡子、按键、杠杆系统、小指键、喇叭6个部分。");
                instrument.setContent("\t\t\t\t产生于十七世纪末，起源于古希腊，于十九世纪末传入中国。最初的单簧管是欧洲古代的一种叫做芦笛的乐器，呈圆柱形，没有按键，也没有喇叭口，只有七个音孔。后来，芦笛渐渐演变成了单簧管唯一的直系祖先——沙吕莫管（又翻译成夏吕莫管）。当今世界绝大多数演奏家使用的单簧管都为勃姆体系。虽然这一乐器在近代还有新的改进，但从1843年至今历经一个半多世纪，克洛泽发明的这种勃姆体系单簧管的基本构造一直保持到现在。");
                instrument.setPic_position(R.drawable.position_danhuangguan);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Anton%20Stadler%203%20Caprices%20for%20Solo%20Clarinet%20No.%202%20Mark%20Buckingham%20From%20the%20Album%20Solo%20Classical%20Clarinet.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Wolfgang%20Amadeus%20Mozart%20Clarinet%20Concerto%20In%20A,%20K.622%20-%203.%20Rondo%20%28Allegro%29A%E5%A4%A7%E8%B0%83%E5%8D%95%E7%B0%A7%E7%AE%A1%E5%8D%8F%E5%A5%8F%E6%9B%B2%EF%BC%8C%E4%BD%9C%E5%93%81K.622.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Wolfgang%20Amadeus%20Mozart%20Clarinet%20Concerto%20In%20A,%20K.622%20-%202.%20AdagioA%E5%A4%A7%E8%B0%83%E5%8D%95%E7%B0%A7%E7%AE%A1%E5%8D%8F%E5%A5%8F%E6%9B%B2%EF%BC%8C%E4%BD%9C%E5%93%81K.622.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("  1、Anton Stadler 3 Caprices for Solo Clarinet No. 2 Mark Buckingham From the Album Solo Classical Clarinet");
                instrument.setMusic_name2("A小调三重奏，作品Op.114（Trio in A minor,Op.114）\n" +
                        "作曲 勃拉姆斯（Brahms）\t\n" +
                        "演奏 理查德•斯托诺兹曼（Richard Stoltzman）\n");
                instrument.setMusic_name3("A大调单簧管协奏曲，作品K.622（Clarinet Concerto In A, K.622 - 3. Rondo (Allegro）\t\n" +
                        "作曲 莫扎特（Mozart）\n" +
                        "演奏 普林茨（Alfred Prinz）\n");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t适合表现各种音乐性格，无论在乐队演奏或独奏中都极富表现力。高音区嘹亮明朗；中音区浑厚、富于表情，音色纯净，清澈优美；低音区低沉，浑厚而丰满，是木管乐曲家族中应用最广泛的乐器之一。");
                instrument.setVideo_url("");
                instrument.setSkill("");
                break;
            case "双簧管":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">双簧管");
                instrument.setName("双簧管");
                instrument.setPic_spe(R.drawable.shuanghuangguan);
                instrument.setPic_struct(R.drawable.struct_shuanghuangguan);
                instrument.setBrief1("\t\t\t\t双簧管，管弦乐器。双簧管在乐队中常担任主要旋律的演奏， 是出色的独奏乐器，同时也善于合奏和伴奏。此外它还是交响乐队里的调音基准乐器。双簧管是一种具有田园风味或牧歌风味的木管乐器，它的音质甜美纯净，音色很有特点，音色优美带点鼻音，又非常富有表现力，令人叹服，热情飞腾。");
                instrument.setBrief0("\t\t\t\t双簧管的管身由三部分组成，其上有大约20个不同大小的气孔，气孔上装有镀金或镀银的音键，用以覆盖气孔调节音高。发声原理是管内空气振动发声。双簧管体为圆锥形，管长约60～70厘米；吹嘴为一双芦竹片对合而成的双簧,装在管的上端。");
                instrument.setContent("\t\t\t\t肖姆是双簧管的前身，肖姆这种乐器起源于印度。17世纪中叶，法国将一种较小的肖姆作了改进后命名为双簧管，至此，真正的双簧管问世。到了18世纪初，双簧管在欧洲的音乐中心成为脍炙人口的乐器。19世纪是双簧管的机械化时代，在1800年至1825年，乐器上又多出了八个键子。1825年维也纳宫廷乐师约瑟夫•塞尔纳发明了十三键双簧管。1839年，亨利•布罗德将键子设计得平均而简易。从1850年迄今演奏者使用的乐器上节除了全自动泛音键之外还有一个独立存在的第三泛音键或者半自动泛音键。\n");
                instrument.setPic_position(R.drawable.position_shuanghuangguan);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%BD%B1%E8%A7%86%E5%8E%9F%E5%A3%B0%20-%20Dr%EF%BC%8Edolittle%28Oboe%29.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/C%E3%80%81wolfgang%20Amadeus%20Mozart%20-%20%E5%A4%A7%E8%B0%83%E5%8F%8C%E7%B0%A7%E7%AE%A1%E5%8D%8F%E5%A5%8F%E6%9B%B2.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Il%20Giardino%20Armonico%20-%20Oboe%20Concerto%20In%20D%20Minor%20%20Ii%20Adagio.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("影视原声 - Dr．dolittle(Oboe)");
                instrument.setMusic_name2("《C、wolfgang Amadeus Mozart - 大调双簧管协奏曲》");
                instrument.setMusic_name3("《Giardino Armonico - Oboe Concerto In D Minor  Ii Adagio》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t双簧管的音色明晰、清新、响亮，在乐队中总是那么引人注意。双簧管音色带有鼻音似的芦片声，善于演奏徐缓如歌的曲调，被誉为“抒情女高音”。双簧管难度高，是吉尼斯世界纪录大全中最难的乐器，由于音色甜美，被称为“公主”。柴科夫斯基的《天鹅湖》中的忧郁而优美的白天鹅主题就是由双簧管吹奏的。其富于直率和美妙的音色特点，也许没有一种乐器能够与它媲美。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：吹奏双簧管需要身体多方面的配合，与其它管乐一样，吹奏双簧管必须使用腹式呼吸，并通过腹部来控制吹奏时的气压。演奏者吹奏时必须采取先呼气、再吸气的方式来换气，有时甚至需要争取呼出闷气的机会，在吹奏时只呼出部分空气，待有机会时再换气。\n");
                break;
            case "英国管":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">英国管");
                instrument.setName("英国管");
                instrument.setPic_spe(R.drawable.yingguoguan);
                instrument.setPic_struct(R.drawable.struct_yingguoguan);
                instrument.setBrief1("\t\t\t\t英国管，木管乐器，属于双簧管体系中的一种变种。又称中音双簧族乐器，即F调双簧管、中音双簧管，比双簧管的音域低五度，音色比双簧管浓郁而苍凉比较含蓄内在，听起来如泣如诉。");
                instrument.setBrief0("\t\t\t\t英国管长约81cm,结构与双簧管相同，但使用弯曲接管，它是双簧气鸣乐器，靠空气振动发声。");
                instrument.setContent("");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Soliloquy%20for%20Solo%20English%20Horn%20%28Thomas%20Stacy%29%20From%20the%20Album%20Thomas%20Stacy%20plays%20Fuchs,%20Berg,%20Ravel,%20Downey,%20Yvon%20and%20Read.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/English%20Horn%20%28theme%20from%20On%20the%20Steppes%20of%20Central%20Asia,%20Borodin%29.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Piece%20for%20English%20Horn.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1(" 《Soliloquy for Solo English Horn》");
                instrument.setMusic_name2("《在中亚细亚草原》");
                instrument.setMusic_name3("《Piece for English Horn》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t英国管音色近似双簧管，有忧郁、梦幻的情调。音质柔和、圆润，比双簧管更幽暗并带有鼻音，音色比双簧管低沉、含蓄，鼻音较重，缺少双簧管欢愉、甜美的人格化音色，却有着田园、回忆、梦幻的色彩。  ");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：英国管在气息损耗方面略大于双簧管，演奏技巧与双簧管相同，但在技巧的发挥上，由于乐器音色性格特点，应更多地让它演奏悠长舒缓的旋律。\n");
                break;
            case "萨克斯":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">萨克斯");
                instrument.setName("萨克斯");
                instrument.setPic_spe(R.drawable.sakesi);
                instrument.setPic_struct(R.drawable.struct_sakesi);
                instrument.setBrief1("\t\t\t\t萨克斯,是萨克斯风的简称，萨克斯风（音译,英语：Saxophone）是一种木管乐器，但是管体通常是用黄铜制造，使得萨克斯同时具有铜管类乐器的特性。分有上低音萨克斯、中音萨克斯、次中音萨克斯、高音萨克斯。");
                instrument.setBrief0("\t\t\t\t萨克斯由主管、脖管、笛头、哨片、哨箍、盖帽、挂带七部分组成。除笛头、哨片外其余全为铜各部分构造制，因此既有木管的特点又有铜管的亮丽，萨克斯管体上端呈圆锥形（上细下粗），下端管体呈圆柱形（上下一致）喇叭口向上弯曲，与低音单簧管相似。萨克斯在分类上算是木管乐器而不是铜管乐器，是由于它的吹嘴是芦苇制成的。在所有类型的萨克斯中，上低音萨克斯、中音萨克斯、次中音萨克斯、高音萨克斯这四种是最常使用的，他们都是金属圆锥形的管身。");
                instrument.setContent("");
                instrument.setPic_position(R.drawable.position_sakesi);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Misty%20%28Saxophone%20Solo%20Version%29%20%28Nikolay%20Kasakov%29%20From%20the%20Album%20Jazz%20Bar.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Branford%20Marsalis%E3%80%81orpheus%20Chamber%20Orchestra%20-%20Concertino%20Da%20Camera%20For%20Alto%20Saxophone%20And%20Orchestra%20Iii.%20Animato%20Molto.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Eugene%20Rousseau%20-%20Concerto%20In%20E%20Flat%20Op.109%20For%20Alto%20Saxophone%20A.%20String%20Orchestra.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《Misty (Saxophone Solo Version) (Nikolay Kasakov) From the Album Jazz Bar》");
                instrument.setMusic_name2("《E大调协奏曲,作品109》");
                instrument.setMusic_name3("《Branford Marsalis、orpheus Chamber Orchestra - Concertino Da Camera For Alto Saxophone And Orchestra Iii. Animato Molto》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t音色丰富，高音区介于单簧管和圆号间，中音区犹如人声和大提琴音色，低音区像大号和低音提琴。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/Baker%20Street%20-%20Saxophone%20Music%20by%20Johnny%20Ferreira.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：气声吹法其实在大口风笛头上比较容易表现出来，不过难度也比小口风笛头要稍微大一点，需要更多更足的气。\n" +
                        "首先气声吹法最大的要领就是要求含少一些笛头，我们平常吹萨的时候，采用实声吹法的话，一般是含在笛头斜面差不多1/3到1/2左右的地方，而气声吹法则是差不多1/4、1/5左右，甚至更少，会有气声吹法好像是稍微只含了一点点的笛头和哨片的感觉。\n" +
                        "其次气声吹法要求口型必须是正确口型，有一些学习者可能虽然也是有着好几年学萨的功力，嘴型虽然不一，不过在实声吹法上出来的音色好像也还过得去，但是，如果你的嘴型没有绝对的松弛下来，而采用的依然是“咬”笛头的绷紧的嘴型去尝试吹气声的话，你会发现憋得非常难受甚至几乎吹不出音来。\n" +
                        "第三气声吹法的发声是几乎完全通过气来驱动的，而且气声吹法发声时几乎是听不到有音头的，似乎不经意的声音就发出来了，非常忌讳实声吹法中口腔和舌头辅助发声带来的音头感，一定要感觉好这种用气息驱动发声的感觉，这也要求使用气声吹法的时候一定要给足足够的气。\n" +
                        "\t最后气声吹法发出来的声音充满了大量的气声，而且音量比实声吹法出来的音差不多可以小一半，但是一定不要认为自己咬死了笛头，小小心心憋出来的声音就是气吹，这种“死音”在低音区域可能还不是很糟糕，但是上高音是一定上不去的。\n" +
                        "不过实际上气声吹法在上高音的时候也是会越来越难，出来的音也会感觉越来越“脏”以至于影响了其婉约沙哑的音色，也因为如此，使用气声吹法的大师在上到高音部分的时候往往还是会出来几个实音，使得音色听起来不至于太过难受。\n");
                break;
            case "次中音号":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">吹");
                instrument.setGuide4(">次中音号");
                instrument.setName("次中音号");
                instrument.setPic_spe(R.drawable.cizhongyinhao);
                instrument.setPic_struct(R.drawable.struct_cizhongyinhao);
                instrument.setBrief1("\t\t\t\t次中音号属铜管乐器，又名“瓦格纳大号” ，与其名字类似，是一种中音偏高音铜管乐器，一般由黄铜制成。该乐器通常是和其他的管乐器一起演奏");
                instrument.setBrief0("");
                instrument.setContent("\t\t\t\t次中音号在1830年左右出现在德国。在18世纪40年代早期，一位魏玛德国的演奏家Herr Sommer将这个乐器进行改良，成为最初的次中音号。次中音号（Euphonium）的名字来源于德国词汇“Euphonos”，意思为“甜蜜的声音”。\n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Sonata%20in%20E-flat%20for%20Alto%20Horn%20and%20Piano%20%281943%29-%20IV.%20Lebhaft.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Sonata%20in%20E-flat%20for%20Alto%20Horn%20and%20Piano%20%281943%29-%20IV.%20Lebhaft.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("独奏");
                instrument.setMusic_name2("《降E大调中音喇叭和钢琴奏鸣曲》");
                instrument.setMusic_name3("《低音喇叭和降E大调钢琴奏鸣曲》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t低音区的发音稍暗，强奏时尚好。最低的两个音音质不好，声音发虚；中音区：明亮、圆润、优美；高音区，当弱奏时优美，强奏时杂音很多。最高的两个音发音纤细，不能强奏，少用。圆形的号孔使次中音号音色圆润，醇和的音色特点使其适合独奏。 ");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/cizhongyinhao.flv");
                instrument.setSkill("\t\t\t\t演奏技巧：次中音号是一种相当灵巧的中音乐器，可以自如的演奏音阶、半音阶、八度以内音程的跳动，分解和弦以及装饰音。次中音号的舌奏有三种方法。单吐法，双吐法，三吐法。\n");
                break;
            case "小提琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">拉");
                instrument.setGuide4(">小提琴");
                instrument.setName("小提琴");
                instrument.setPic_spe(R.drawable.xiaotiqin);
                instrument.setPic_struct(R.drawable.struct_xiaotiqin);
                instrument.setBrief1("\t\t\t\t小提琴，一种四弦擦奏弦鸣乐器，有“乐器皇后”的美誉，广泛流传于世界各国，是现代管弦乐队弦乐组中最主要的乐器。它在器乐中占有极重要的位置，是现代交响乐队的支柱，也是具有高难度演奏技巧的独奏乐器，与钢琴、古典吉他并称为世界三大乐器。");
                instrument.setBrief0("\t\t\t\t小提琴由30多个零件组成。小提琴琴身（共鸣箱）长约35.5厘米，由具有弧度的面板、背板和侧板粘合而成。小提琴共有四根弦，分为：1弦（E弦）、2弦（A弦）、3弦（D弦）和4弦（G弦）。  面板常用云杉制作，质地较软；背板和侧板用枫木，质地较硬。琴头、琴颈用整条枫木，指板用乌木。");
                instrument.setContent("\t\t\t\t小提琴的起源可以追溯到2000多年前的埃及乐器“里拉”（Lyre），十五世纪，意大利人对其进行了改革，并用马尾制成弓子拉奏，定名为Violin，即小提琴。后又经过多年演变，小提琴的形成与制作才基本固定下来。最早的现代意义上的小提琴大约产生于十六世纪中叶，那时的许多珍品现保存在欧洲一些博物馆内。从16世纪到18世纪，意大利的小提琴制造业随着音乐艺术的空前繁荣而得到了迅速的发展，出现了一些小提琴制作杰出名匠。18世纪以后，世界各国的小提琴制造业都是仿照意大利这些小提琴制作者的琴型和尺寸来制作小提琴。\n");
                instrument.setPic_position(R.drawable.position_xiaotiqin);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Salvatore%20Accardo%20-%20Paganini%2024%20Caprices%20For%20Violin,%20Op.1%20-%20No.%2024%20In%20A%20Minor%20-%20%E5%B0%8F%E6%8F%90%E7%90%B4%E7%89%88%E7%BA%AF%E9%9F%B3%E4%B9%90.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Ludwig%20Van%20Beethoven%20-%20Sonata%20For%20Violin%20And%20Piano%20No.%205%20In%20F%20Major,%20Op.24%20-%20%E7%BA%AF%E9%9F%B3%E4%B9%90%E7%89%88.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《Salvatore Accardo - Paganini 24 Caprices For Violin, Op.1 - No. 24 In A Minor 》");
                instrument.setMusic_name2("Antonio Vivaldi - Concerto For Violin And Strings In E,op.8,no.1,r.269la Primavera - 1. Allegro - 纯音乐版2");
                instrument.setMusic_name3("《春天》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t小提琴音色优美，接近人声，音域宽广，表现力强。小提琴的音色风格可以分为三大类：其一，阳刚之美——浓郁豪放、浑厚深沉、明亮圆润、大气浩然；其二，阴柔之美——含蓄典雅、细腻集中、甘纯华丽、忧郁神秘；其三，中庸之美——宽松温暖、厚亮衡度、刚柔相济、庸蕴诙谐。 具体到每一根弦上则表现为：E弦清晰、明亮，A弦柔美如歌，D弦优雅，G弦浑厚深沉。 ");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：小提琴演奏技巧灵活，表现力十分丰富，可演奏缓慢、宽广、抒情的旋律，亦可演奏技巧性很高的华彩乐段。左手技巧有：手指按弦动作、换弦、换把、移指、滑指、颤指、拨弦等；右手技巧有：持弓、运弓、换弓、换弦、弓段的分配、弓压、弓与弦的接触点的运用，以及各种长、短弓法和跳弓的运用等，技巧比较复杂艰难。小提琴可奏出两种泛音：自然泛音与人工泛音。\n");
                break;
            case "中提琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">拉");
                instrument.setGuide4(">中提琴");
                instrument.setName("中提琴");
                instrument.setPic_spe(R.drawable.zhongtiqin);
                instrument.setPic_struct(R.drawable.struct_white);
                instrument.setBrief1("\t\t\t\t中提琴，擦奏弦鸣乐器，是提琴族中的中音乐器，外形及结构与小提琴基本相同，只是形体略大。");
                instrument.setBrief0("\t\t\t\t中提琴的结构和小提琴相仿, 但是尺寸比例比小提琴来得大，共鸣音箱也比较大且深。中提琴没有标准长度。为了和小提琴的音色和谐，最佳中提琴的长度是21英寸。四条弦是C 、G、D、A，较小提琴低五度，较大提琴高八度。中提琴的弓比小提琴略长一些，是提琴类乐器中最长的弓。");
                instrument.setContent("\t\t\t\t中提琴是现代提琴中最早面世及被采用的，但中提琴在独奏方面的活动可以说是由二十世纪才开始的。事实上自十六世纪到十九世纪末并没有真正的中提琴家。中提琴手都是由小提琴手所兼职，最早的中提琴家，乃是十八世纪德国曼海姆的史塔密兹。在悠久的岁月间，中提琴只担任强化管弦乐低音的任务，演奏内声部的和声，直到近代，才开始演奏重要的旋律或过门乐句，而且有时也担任独奏乐器。\n");
                instrument.setPic_position(R.drawable.position_zhongtiqin);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Paul%20Cortese%20-%20Hindemith%20Sonata%20For%20Viola%20Solo%20No.%204,%20Op.31%20-%203rd%20Movement%20Theme%20Mit%20Variationen%20-%20Schnelle%20Viertel.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Amsterdam%20Baroque%20Orchestra%E3%80%81ton%20Koopman%E3%80%81yo-Yo%20Ma%20-%20Concerto%20For%20Viola%20D%27amore,%20Lute%20And%20Orchestra,%20Rv%20540%20I.%20Allegro.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Il%20Giardino%20Armonico%20-%20Concerto%20For%202%20Violins%20&%20Viola%20In%20G%20Minor%20%20Ii%20Presto.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《中提琴协奏曲 No. 4, Op.31》");
                instrument.setMusic_name2("Amsterdam Baroque Orchestra、ton Koopman、yo-Yo Ma - Concerto For Viola D'amore, Lute And Orchestra, Rv 540 I. Allegro");
                instrument.setMusic_name3("Il Giardino Armonico - Concerto For 2 Violins & Viola In G Minor  Ii Presto");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t中提琴的音色很美，中、低音区尤佳，特别适合演奏抒情性旋律。在弦乐组中，中提琴主要担任内声部、复调及节奏性部分。在乐队中，中提琴的音色很容易同其他乐器融合在一起。中提琴的音色比小提琴更厚实、温暖而丰满。相对小提琴来说由于共鸣箱加大，音色方面也会相对低沉些，略带有鼻音；弦通常也比小提琴粗一些，因此音色更柔和低沉。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：通常中提琴的体积更大，弓弦更长。左手可以演奏出更宽更强的颤音，右臂运弓的距离身体更远。因此当演奏者从小提琴转为中提琴（或大提琴）时，很快就会发现两者的指法有很大区别。演奏者必须将左肘伸得更远甚至弯过来，这样手指才能够到最低的弦。只有手指稳定有力才能发出一个清晰的音。除非演奏者的手特别大，普通人都需要学习不同的指法，如在演奏中经常使用半位（half position）和活动位（shifting position ）。中提琴更多地要求演奏着运用指尖内侧弦。\n");
                break;
            case "大提琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">拉");
                instrument.setGuide4(">大提琴");
                instrument.setName("大提琴");
                instrument.setPic_spe(R.drawable.datiqin);
                instrument.setPic_struct(R.drawable.struct_datiqin);
                instrument.setBrief1("");
                instrument.setBrief0("");
                instrument.setContent("\t\t\t\t大提琴作为大型的小提琴出现在16世纪中期的欧洲。但到了十七世纪，由于广场演奏的机会增加，音量要求增大，故有必要将古大提琴加以改良。经过一段时日的尝试和研究，终于产生一种最完美的乐器---大提琴。其改良成就在于音色柔和有张力，优雅且富有魅力，体积大小适于合奏或行进间的演奏。此后，几乎每个作曲家都把大提琴列入演出目录中，提琴的技巧提升到更高的境界，在弦乐器中，除了小提琴，大提琴是担任独奏最多的乐器。\n");
                instrument.setPic_position(R.drawable.position_datiqin);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Yo-Yo%20Ma%20-%20Unaccompanied%20Cello%20Suite%20No.%201%20In%20G%20Major,%20Bwv%201007%20Pr%C3%A9lude.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Anssi%20Karttunen%20%28Cello%29%20And%20Tuija%20Hakkila%20%28Fortepiano%29%20-%20Sonata%20In%20A%20Major,%20Op.%2069%20-%20I%20Allegro%20Ma%20Non%20Tanto.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Arto%20Noras%20%28Cello%29%20And%20Finnish%20Radio%20Symphony%20Orchestra%20And%20Jukka-Pekka%20Saraste%20%28Conductor%29%20-%20Rhapsody%20No.%201%20-%20Friss.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《Yo-Yo Ma-Unaccompanied Cello Suite No.1 in G Major》");
                instrument.setMusic_name2("Anssi Karttunen (Cello) And Tuija Hakkila (Fortepiano) - Sonata In A Major, Op. 69 - I Allegro Ma Non Tanto");
                instrument.setMusic_name3("Arto Noras (Cello) And Finnish Radio Symphony Orchestra And Jukka-Pekka Saraste (Conductor) - Rhapsody No. 1 - Friss");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t大提琴的音色悠扬，琴弦的音色含情，旋律动人，特别人性和自然，能较好地反映人的情感。大提琴的四根琴弦，具有四种特点：第一根琴弦a弦，发音华丽，富于歌唱性；第二根弦d弦，音色朦胧；第三、第四根弦，G弦C音色低沉响亮。 ");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/Yo-Yo%20Ma%20-%20Bach%20Cello%20Suite%20N%C2%B0.1%20-%20Prelude%20%28HD%29.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：同城采用直立或者坐着的姿势弹奏。靠近琴码sul ponticello：演奏时使琴弓靠近琴码。拨奏pizzicato：通过拨弦来演奏音乐。\n大提琴的发音原理虽然与中、小提琴相同，但其手指的把位在低音区与小提琴迥然不同，尤其是在高音区时能用拇指把位演奏。\n\n");
                break;
            case "低音提琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">拉");
                instrument.setGuide4(">低音提琴");
                instrument.setName("低音提琴");
                instrument.setPic_spe(R.drawable.diyintiqin);
                instrument.setPic_struct(R.drawable.struct_diyintiqin);
                instrument.setBrief1("\t\t\t\t低音提琴又称倍大提琴。提琴家族中体积最大、发音最低的弓弦乐器。它是乐队中音响的支柱，基本节奏的基础。");
                instrument.setBrief0("\t\t\t\t低音提琴约有180～220厘米高，下端有一支柱，形似大提琴。低音提琴使用两种弓子，一种是法国弓，称为博泰西尼弓，琴弓约长68~70公分。另一种称为德式或西曼德尔弓，它有一个较长、较细的杆，很宽的扣手，用手握住棍杆的下面（手掌向上）。");
                instrument.setContent("\t\t\t\t一般来说低音提琴在德国继续沿着维奥琴的形制发展，保持了倾斜的琴肩和平坦的背板。\n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Sonata%20For%20Solo%20Contrabass%20Op.%20108%20%281971%29%20VI.%20Allegro%20Molto%20-%20Joel%20Quarrington.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Four%20Pieces%20For%20Contrabass%20&%20Piano%20Intermezzo,%20Op.%209%20-%20No.%201%20-%20Joel%20Quarrington.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Four%20Pieces%20For%20Contrabass%20&%20Piano%20Scherzo,%20Op.32%20-%20No.%202%20-%20Joel%20Quarrington.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《Sonata For Solo Contrabass Op.108(1971) VI.Allegro Molto-Joel Quarrington》");
                instrument.setMusic_name2("Four Pieces For Contrabass & Piano Intermezzo, Op. 9 - No. 1 - Joel Quarrington");
                instrument.setMusic_name3("Four Pieces For Contrabass & Piano Scherzo, Op.32 - No. 2 - Joel Quarrington");
                instrument.setMusic_name4("");
                instrument.setMusic_content("");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/diyintiqin.flv");
                instrument.setSkill("\t\t\t\t演奏技巧：低音提琴是唯一在低把位只用3个指头按弦的交响弦乐器，其把位距离过大导致无法均匀使用四个手指。低音提琴比其他弓弦乐器更多地用拨奏，这一特点使得它除了可以在管弦乐队中扮演角色也能在歌舞乐队和爵士乐队中成为重要的节奏乐器。\n");
                break;
            case "钢琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">钢琴");
                instrument.setName("钢琴");
                instrument.setPic_spe(R.drawable.gangqin);
                instrument.setPic_struct(R.drawable.struct_gangqin);
                instrument.setBrief1("\t\t\t\t钢琴，键盘敲弦乐器。从外形上主要分成立式钢琴和三角钢琴。钢琴因为它宽广的音域，绝美的音色，被称之“乐器之王”。");
                instrument.setBrief0("\t\t\t\t钢琴由弦列、音板、支架、键盘系统（包括 黑白琴键、击弦音棰、共88个琴键）、踏板机械（包括顶杆 和踏板）和外壳共六大部分组成。演奏者通过按下键盘上的琴键，牵动钢琴里面包着绒毡的小木槌，继而敲击钢丝弦发出声音，通过琴码传递，引起音板和共鸣腔体内的空气振动，产生共鸣。");
                instrument.setContent("\t\t\t\t钢琴发源于欧洲。十八世纪初，意大利人克里斯多佛利（Bartolommeo Cristofori）发明的一种类似现代钢琴的键盘式乐器，至今已有三百多年的历史。现代钢琴是由以拨弦发音的大键琴和以撞弦发音的小键琴演进而成的。钢琴虽诞生在意大利，却在德奥和英国得以发展成长。18世纪中叶，人们对钢琴的制作工艺实行革新，使其演奏性能日益完善。这一时期，西尔伯曼及其子弟在钢琴的变革中起着主导作用。");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%83%8E%E6%9C%97%20_%20La%20campanella%20in%20G-Sharp%20Minor%20from%20Grandes%20%C3%A9tudes%20de%20Paganini,%20S%20141_3%20%28%E5%B8%95%E6%A0%BC%E5%B0%BC%E5%B0%BC%E7%BB%83%E4%B9%A0%E6%9B%B2%E7%AC%AC3%E5%8F%B7%E2%80%9C%E9%92%9F%E2%80%9D%20%E4%BD%9C%E5%93%81141%E5%8F%B7%29.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Peter%20Jablonski%20-%20Paganini%20Variations,%20For%20Piano%20&%20Orchestra.mp33");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Sviatoslav%20Richter%20-%20Introduction%20&%20Allegro%20Appassionato%20For%20Piano%20&%20Orchestra,%20Op.92.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("郎朗 _ La campanella in G-Sharp Minor from Grandes études de Paganini, S 141_3 (帕格尼尼练习曲第3号“钟” 作品141号)");
                instrument.setMusic_name2("Peter Jablonski - Paganini Variations, For Piano & Orchestra");
                instrument.setMusic_name3("Sviatoslav Richter - Introduction & Allegro Appassionato For Piano & Orchestra, Op.92");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t钢琴的音域宽广，音色宏亮、清脆，富于变化，表现力很强。独奏时，可演奏各种气势磅礡、宽广、抒情的音乐，亦可演奏欢快、灵巧、技巧性很高的华彩乐段；钢琴在乐队中，可发挥巨大的作用。它还经常作为伴奏乐器使用。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t    钢琴的演奏技巧十分丰富，可以自如地弹奏各种音阶、半音音阶，各种音程的跳动，各种双音、和弦以及各种复杂的乐曲。钢琴发音是靠人体及其上肢各部位肌肉关节的整体运动和击发动作，因此钢琴演奏是个名副其实的“从头到脚的全身运动”，是全身各部位的高度配合、协调与统一。");
                break;
            case "竖琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">竖琴");
                instrument.setName("竖琴");
                instrument.setPic_spe(R.drawable.shuqin);
                instrument.setPic_struct(R.drawable.struct_shuqin);
                instrument.setBrief1("\t\t\t\t竖琴，世界上最古老的拨弦乐器之一，交响乐队以及歌舞剧中特殊的色彩性乐器。主要担任的是和声伴奏和滑奏式的装饰句，每每奏出画龙点睛之笔，令听众难以忘怀。在室内乐中，竖琴也是重要的独奏乐器。独奏时能奏出柔和优美的抒情段或华彩乐段，极具感染力。");
                instrument.setBrief0("\t\t\t\t现代竖琴都是落地式的，琴身为木制结构，主要由垂直的前柱、斜立的长条形音箱和位于上方的弯曲的琴颈，形成一个三角形琴架，琴弦与前柱平行，自上而下地绷于琴颈与音箱上。 结构组成有琴身（包括琴柱、挂弦板、共鸣箱和底座），琴弦系统（包括琴弦、弦轴、变音传动机件装置和踏板）。");
                instrument.setContent("竖琴用左右手的一至四指演奏，不用小指。乐谱中的高音声部由右手演奏，低音声部由左手演奏。单手可奏单音、双音、和弦，每只手最多奏四个音，最宽不能超出十度。两手交换演奏，可奏出像钢琴一样的单音式的分解和弦。双手还可以如钢琴般在相同音区奏出交错的音符。泛音、煞音、滑奏也是竖琴的特色奏法。");
                instrument.setPic_position(R.drawable.position_shuqin);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Mark%20Isham%20-%20Variation%20On%20A%20Popular%20Theme%20%28%233%29%20For%20Solo%20Harp.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Helga%E3%80%81klaus%20Storck%20-%20Sonata%20For%20Cello%20&%20Harp%20In%20G%20Major%20Op.115%20%20Iii%20Rondo.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Sir%20Colin%20Davis%20-%20Berlioz%20L%27enfance%20Du%20Christ,%20Op.25%20%20Partie%203%20L%27arriv%C3%A9e%20%C3%A0%20Sais%20-%20Trio%20For%20Two%20Flutes%20&%20Harp.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《Mark Isham - Variation On A Popular Theme (#3) For Solo Harp》");
                instrument.setMusic_name2("Helga、klaus Storck - Sonata For Cello & Harp In G Major Op.115  Iii Rondo");
                instrument.setMusic_name3("Sir Colin Davis - Berlioz L'enfance Du Christ, Op.25  Partie 3 L'arrivée à Sais - Trio For Two Flutes & Harp");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t竖琴具有无与伦比的美妙音色，演奏琶音音阶时有行云流水之境界，音量虽不算大，但柔如彩虹，诗意盎然，时而温存时而神秘，是自然美景的集中体现。由于它的丰富的内涵和广阔的音域，其演奏余韵悠长，令人闻之心旷神怡。 ");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/26Shuqin-ALISA%20SADIKOVA%20-%20The%20Fountain%20%E2%80%94%20Marcel%20L.%20Grandjany%20%28%20Harp%20Music%29.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：竖琴用左右手的一至四指演奏，不用小指。乐谱中的高音声部由右手演奏，低音声部由左手演奏。单手可奏单音、双音、和弦，每只手最多奏四个音，最宽不能超出十度。两手交换演奏，可奏出像钢琴一样的单音式的分解和弦。双手还可以如钢琴般在相同音区奏出交错的音符。泛音、煞音、滑奏也是竖琴的特色奏法。\n");
                break;
            case "手风琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">手风琴");
                instrument.setName("手风琴");
                instrument.setPic_spe(R.drawable.shoufengqin);
                instrument.setPic_struct(R.drawable.struct_shoufengqin);
                instrument.setBrief1("\t\t\t\t手风琴是一种既能够独奏，又能伴奏的簧片乐器，不仅能够演奏单声部的优美旋律，还可以演奏多声部的乐曲，更可以如钢琴一样双手演奏丰富的和声。音高固定，易学易懂，体积小，携带方便，因此，手风琴很适合不同年龄的演奏者自娱自乐。");
                instrument.setBrief0("\t\t\t\t手风琴由键盘，风箱，贝司三大部分组成。发声原理：手风琴的声音产生来自风箱，要拉开风箱得靠左手按左边的伴奏钮。");
                instrument.setContent("\t\t\t\t真正用手拉的风琴是由德国人德里克•布斯曼（Friedrdch Buschman，1805—1864 ），他在1821年制造了用口吹的奥拉琴，1822年又在琴上增加了手控风箱和键钮，后来，奥地利人西里勒斯•德米安（Cyrillus Demian 1772—1847）在布斯曼的基础上，集当时手风琴的各种前身乐器之大成，成功地改良了世界上第一架被定名为accordion的手风琴。直到今天，世界各地仍然沿用accordion这个名称。\n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/C%27est%20magnifique%20-%20Various%20Artists.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/No%20Regrets%20-%20Various%20Artists.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%80%AC%E5%B7%9D%E8%8B%B1%E5%8F%B2%20-%20Divorce%20Impossible%20Clarinet%20&%20Accordion%20Duet.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("C'est magnifique - Various Artists");
                instrument.setMusic_name2("《离婚不可能-单簧管与手风琴重奏》");
                instrument.setMusic_name3("《不，我一点都不后悔》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t手风琴声音宏大，音色变化丰富，手指与风箱的巧妙结合，能够演奏出多种不同风格的乐曲，这是许多乐器无法比拟的；除了独立演奏外，也可参加重奏、合奏，可以说一架手风琴就是一个小型乐队。\n" +
                        "俄罗斯巴扬手风琴体积庞大，重量大，音域广，音色深重。\n" +
                        "中西欧钢琴式手风琴体积适中，质量较轻，音域不大，音色高昂。\n" +
                        "爱尔兰巴扬手风琴体积很小，音域较广，音色轻快。\n");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：手风琴的演奏技巧主要分为右手、左手和风箱控制三部分。手指触键的力度不宜过大，手指也不必抬得过高，触键的基本原则是“省力，有效”，左手的触键方法是肩膀放松，小臂自然从风箱皮带中伸出，将手指自然弯曲并垂直地放在低音及和弦的键钮上。\n");
                break;
            case "管风琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">管风琴");
                instrument.setName("管风琴");
                instrument.setPic_spe(R.drawable.guanfengqin);
                instrument.setPic_struct(R.drawable.guanfengqin);
                instrument.setBrief1("\t\t\t\t管风琴是一种键盘乐器，又属于气鸣乐器类的混合型乐器。属簧片乐器族中的自由簧乐器。管风琴在欧洲乐器中占有统治地位，被称为乐器之王（原为莫扎特所说），在音乐艺术发展史上占有重要地位。");
                instrument.setBrief0("\t\t\t\t管风琴的键盘是像台阶般多层的，有用手弹的和脚踏的。手键盘少则2层，一般4-5层，多的6-7层；脚键盘一般为1层，也有两层的。在键盘周围，还有许多变换音色、音高、音量和音响效果的音栓与踏板等装置。管风琴是靠多种不同结构的长短音管发音的，发音系统包括哨管、簧管、管列；供气系统有气室、储气箱、风箱。");
                instrument.setContent("\t\t\t\t最早古希腊城邦出现了一种名为“Double Flute”的乐器，它由两根不同音调的管子组成，后来这件乐器迅速被排箫所取代。但排箫难以手持，因此公元前250年古希腊工程师亚力山德里亚的克特西维奥斯制造的水压式管风琴，这是音乐史上第一架管风琴，到公元3世纪时民间仍使用，它以阿基米德原理，将水汽通入多根音管内，从而可以使键盘放平，发出优美的乐音，因为体积极小（一管一音，音域为一个半八度），所以便于携带。4世纪出现了桌子型的伴唱琴，以风箱式装置替代水压式，增强了音量。5世纪末，管风琴的体积扩充为房间般大小，并引入教堂。直到12世纪，法国才出现两层键盘的管风琴。");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%AE%A1%E9%A3%8E%E7%90%B4%E7%8B%AC%E5%A5%8F%E6%9B%B2%20D%20%E5%B0%8F%E8%B0%83%E6%89%98%E5%8D%A1%E5%A1%94%E4%B8%8E%E8%B5%8B%E6%A0%BC.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/C%20-%20%E5%A4%A7%E8%B0%83%E5%B0%8F%E5%8F%B7%E5%92%8C%E7%AE%A1%E9%A3%8E%E7%90%B4%E5%A5%8F%E9%B8%A3%E6%9B%B2.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("管风琴独奏曲 D 小调托卡塔与赋格");
                instrument.setMusic_name2(" C大调小号和管风琴奏鸣曲");
                instrument.setMusic_name3("《管风琴》c小调第三交响曲");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t管风琴音域最为宽广，有雄伟磅礴的气势，肃穆庄严的气氛，其丰富的和声绝不逊色于一支管弦乐队，是最能激发人类对音乐产生敬畏之情的乐器，也是最具宗教色彩的乐器。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/14Guanfengqin-BWV%20582%20Bach%20-%20Passacaglia%20and%20Fugue%28with%20music%20guide%29.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏时，放松的姿势是弹奏管风琴的基础，坐姿要先求重心的稳固，能使身体灵活的运转，手指与双脚悬空轻放在键盘上，利用双手本身的重量下压弹奏，膝盖与脚掌稍向内顷，用脚内侧来弹奏，脚踝也应该尽量放松，勿使任何一方的弹奏牵动到身体的重心。弹奏时最重要需注意的是：预备好下一个弹奏的位置，特别是对于远距离的音，键盘的转换或段落的开始处，手、特别是脚要事先放在要弹出来的位置上做准备。音量上的问题   ");
                break;

            case "电吉他":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">电吉他");
                instrument.setName("电吉他");
                instrument.setPic_spe(R.drawable.dianjita);
                instrument.setPic_struct(R.drawable.struct_dianjita);
                instrument.setBrief1("\t\t\t\t电吉他是一种拨弦乐器，琴体使用新硬木制成。配有音量、音调调音器以及颤音结构等装置。电吉他有很强的表现力，在现代音乐中有很重要的位置。");
                instrument.setBrief0("\t\t\t\t电吉他的发声原理与传统吉他不同，不是以箱体的的振动发声，而是运用了电磁学原理，它的琴身是实体的木头而非空的音箱，在琴身上装有线圈，它们被称做拾音器。当吉他弦振动时，切割拾音器的磁感线，从而使琴身中的导线中产生不同频率的电流，当这些电流通过电子音箱还原时，就成了电吉他的声音。");
                instrument.setContent("\t\t\t\t在二十世纪二十年代的美国，因为现场演奏扩声的需要，很多人开始尝试将电声转换装置安装到吉他上。很多人认为由美国鞋匠艾维尔•吉布森（Orville Gibson）所创建的Gibson公司于1935年推出的ES-150为世界上第一把真正意义上的空心电吉他，之后为了解决反馈问题开发出半空心电吉他ES-335。在这之后的二十世纪四十年代，莱斯•保罗（Les Paul）和里奥•芬达（Leo Fender）分别发明了两种实心电吉他Les Paul和Telecaster\n" +
                        "，后来Telecaster又演变出经典的Stratocaster。至此，电吉他世界的格局基本奠定。在大半个世纪后的今天，大部分的电吉他也都是基于这几种形式设计制造的。\n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Ilan%20Guetta%20-%20Sonata%20No.%203%20In%20C%20Major%20For%20Solo%20Electric%20Guitar_%20Allegro%20Assai.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/The%20Eagles%20-%20Hotel%20California%20-%20%E7%94%B5%E5%90%89%E4%BB%96%20Solo.mp3");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("Llan Guetta-Sonata No.3 in C Major For Solo Electric Guitar-Allegro Assai");
                instrument.setMusic_name2("《Joe Satriani - Revelation - 电吉他》");
                instrument.setMusic_name3("《加州旅馆》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t电吉他音量可大可小，音值可长可短，比起普通木质吉他，在演奏方面回旋余地更大，在表现滑音、颤音和倚音方面更是游刃有余。而且电吉他的音色可由各种效果器来改变、修饰，达到不同的效果，以演奏各种不同风格的乐曲。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/Hotel%20California%20Solo%20-%20Jason%20Hobbs.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：电吉他的演奏技巧有推弦、连奏（击弦、勾弦、滑弦）、震音、无定向滑弦、制音、跳音、拨片泛音和摇把奏法、点弦，另有从各种风格音乐中发展而来的技巧，如乡村风格吉他中的chicken奏法，布鲁斯音乐中的双音推弦、和音推弦等。当然，从这些风格音乐中发展出来的技巧不会只局限于原本的音乐风格。当今的电吉他演奏更多时候体现了技巧的融合与发展。如利用古典吉他演奏技巧和现代音乐理论发展出来的finger style，就是现在吉他演奏技巧发展的体现。\n");
                break;
            case "电贝司":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">电贝司");
                instrument.setName("电贝司");
                instrument.setPic_spe(R.drawable.dianbeisi);
                instrument.setPic_struct(R.drawable.struct_dianbeisi);
                instrument.setBrief1("\t\t\t\t电贝司，又称为贝斯吉他、低音吉他，现代摇滚乐团组合的主要乐器。它是从低音提琴演变出来的电声乐器。");
                instrument.setBrief0("\t\t\t\t电贝司由琴头、指板、拾音器、音量开关等部分组成。类似电吉他，从外形上看也同电吉他差不多，但只有四根弦，以电吉他的后四根弦低八度定音。\n" +
                        "电贝司已经不仅只有基本的4弦，也有5弦和6弦之别，而5弦的电贝司，从第一弦到第五弦（由细到粗）的空弦音分别为：G、D、A、E、B，也有的空弦音分别为：C、G、D、A、E，依各大厂商自订；至于6弦的电贝斯，从第一弦到第六弦的空弦音分别为：C、G、D、A、E、B。");
                instrument.setContent("\t\t\t\t贝司源于倍低音提琴，起初的倍低音提琴高度超过八尺以上，琴颈有格子，弹奏时必须用琴弓来拉奏；30年代，出现过一种电气化的贝司，这种贝司是没有共鸣箱的，靠一个简单的拾音器来得到声音；1951年福德公司发明了“真正的”电贝司，在体积上比倍低音贝司小了许多，在外型上简直就是四弦的吉他，而且琴颈上的琴格，可使弹奏者弹出准确的音准，因此，这款贝司就叫做精准贝司，1960年，福德又推出新一款的电贝司，指板较窄、有两个拾音器、两个音量控制钮及一个音色调整钮，叫做福德贝司。");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/N.I.B.%20-%20Black%20Sabbath.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%B0%8F%E6%B3%BD%E6%AD%A3%E6%BE%84%20-%20Attraction.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/The%20Fish%20%28Live%29%20-%20Yes.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("黑色安息日（N.I.B. - Black Sabbath）");
                instrument.setMusic_name2("《吸引力》（Attraction）\n" +
                        "作曲家 小泽正澄\n" +
                        "演奏家 小泽正澄\n");
                instrument.setMusic_name3("《The Fish》 ");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t电贝司属电声乐器，音量变化可以调节。中低音区发音厚实响亮， 高音区则较明亮。同吉它一样可以运用多种技巧，演奏出特色旋律来，因此电贝司在合奏中是不仅仅作为低音伴奏乐器而出现的，它往往奏出令人难忘的乐句，音色优美，旋律流畅。\n" +
                        "电贝司几乎只用于现代电声乐队中，作为整个乐队的低音声部。常使用分解和弦伴奏，在乐曲的经过句中，电贝司常奏出过渡性旋律，能大大丰富乐队的音色。\n");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/Bach%20Cello%20Suite%20No.1%20Prelude%20-%20Solo%20Electric%20Bass.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：贝司右手弹奏方法一般来说有两种：轮指和拨片。轮指常见的有二轮指(食指，中指)，三轮指(食指，中指，无名指)。用拨片弹奏一般都靠后，就是靠近琴桥的地方，这样音色会亮一些，而轮指一般在第一块拾音器的上方，得到的音色浑厚一些。轮指需要注意的地方：各个手指的力度要均匀。左手按弦的方法也有两种。一种是指肚按弦。这种方法按弦得到的音色饱满，比较常用。另一种和吉他一样了，指尖按弦。一般来说配合指肚按弦演奏。 ");
                break;
            case "电钢琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">电钢琴");
                instrument.setName("电钢琴");
                instrument.setPic_spe(R.drawable.diangangqin);
                instrument.setPic_struct(R.drawable.struct_diangangqin);
                instrument.setBrief1("\t\t\t\t电钢琴：电气乐器，外形和钢琴类似。");
                instrument.setBrief0("\t\t\t\t电钢琴由谱架、现实控制区、琴键、踏板等部分组成。");
                instrument.setContent("\t\t\t\t当今的人们讨论的“电钢琴”是电子琴家族的一个分支，严格来讲应该叫“数码钢琴”，台湾地区的人称其为“数位钢琴”。在21世纪已经约定俗成地把“数码钢琴”叫做“电钢琴”。早期的电子钢琴是比较专一化地、只有几种钢琴或类钢琴的音色，能调音量，除此之外造价全花在了键盘手感上。电钢琴的键盘经历了三个发展时期，（1）拉簧配重。（2）配重键盘。（3）击槌键盘。\n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/O%20BRIEN%20EDWARD;GREENWOOD%20JONATHAN;GREENWOOD%20COLIN%20-%20High%20And%20Dry%20originally%20perfomed%20by%20radiohead.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Just%20a%20Survivor%20%20-%20%E4%BD%90%E8%97%A4%E7%9B%B4%E7%B4%80.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/O%20BRIEN%20EDWARD;GREENWOOD%20JONATHAN;GREENWOOD%20COLIN%20-%20High%20And%20Dry%20originally%20perfomed%20by%20radiohead.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《High And Dry originally perfomed by radiohead》");
                instrument.setMusic_name2("《Paranoid Android originally perfomed》");
                instrument.setMusic_name3("《Just a Survivor  - 佐藤直紀》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t发声原理是将键盘作为通断开关，一旦按下琴键，内部的晶振开始工作，产生一定频率的波形，接着经过分频器的放大，送入扬声器发声。整个发声过程依靠简单的分频模拟电路，所以键盘没有力度和击弦的感觉，声音也较为机械单调。 一台优秀的电钢琴的音色最大程度上接近了最完美的真钢。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%B8%95%E6%B5%B7%E8%B2%9D%E7%88%BE%E3%80%8A%E5%8D%A1%E8%BE%B2%E3%80%8B-%E5%AD%9F%E5%84%92%E8%80%81%E5%B8%AB%E9%8B%BC%E7%90%B4%E6%BC%94%E5%A5%8F%E7%89%88%20%E7%9B%B8%E4%BF%A1%E9%9F%B3%E6%A8%82%E6%95%99%E5%AE%A4.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：" +
                        "1、找准音阶\n" +
                        "2、通过琶音练习手指之间的扩张和伸缩能力　　\n" +
                        "3、八度有两种手腕技巧和手臂、手腕一起来完成的技巧。　　\n" +
                        "4、轮指，常用的轮指有3个指 有4个指的　　\n" +
                        "5、和弦，不管是几个音的和弦弹下去都要整齐，忌有前有后。P的和弦演奏要非常轻巧 干净利索； F的和弦要有种金属般的声音，弹音要沉下去不发飘。　　\n" +
                        "6、大跳，是很机械的动作，慢练让肌肉记住位置。　　\n" +
                        "7、手指独立练习。　　\n" +
                        "8、三六度音阶，重要是指法、手指柔韧性。\n");
                break;
            case "合成器":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">弹");
                instrument.setGuide4(">合成器");
                instrument.setName("合成器");
                instrument.setPic_spe(R.drawable.hechengqi);
                instrument.setPic_struct(R.drawable.struct_white);
                instrument.setBrief1("\t\t\t\t合成器是一种以加法合成、减法合成、FM、physical modelling或相位调变等电子技术发声的电子乐器。");
                instrument.setBrief0("\t\t\t\t合成器有三种发声方式：直接改变电压（如类比合成器）。利用电脑做数学运算(如软件合成器) \n" +
                        "综合以上二种，最后会产生电压讯号会使扬声器或耳机之薄膜振动。合成器所发之声音和录音设备里的自然声音不同，录音是将声波的机械能转换为讯号，并且可以经由播放把讯息转回机械能(虽然取样技术会导致失真)。合成器通常是以键盘做为操控接口。\n");
                instrument.setContent("\t\t\t\t本世纪的50年代，出现第一台电子合成器。那时还只是一个庞然大物，利用计算机技术，输入信息可以改变音调、音量、速度、波形及包络等。花费很长时间才能产生几分钟的音乐。\n" +
                        "到60年代，合成器装上琴键，进入商品化，并且体积也大大减小。六十年代，美国物理学家Robert Moog 又研制出了小型实用的电子合成器。从此，首先在欧美地区，合成器作为新型的乐器被音乐家尤其是流行音乐家所采用并飞快的流行开来。\n" +
                        "80年代,将计算机与合成器结合起来的“音乐工作站”问世,这就是我们今天常见的自带音序器录音功能的电子合成器。\n" +
                        "到当今90年代，电子合成器已经经过了很多代产品，并且非常完善，可以说是无所不能了。\n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%98%A5%E4%B9%8B%E5%9C%86%E8%88%9E%E6%9B%B2%20-%20%E4%BD%95%E6%96%87%E5%BD%AA.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Easley%20Blackwood%20Microtonal%20Etudes,%20Op.%2028%20-%20VII.%2017%20notes%20Con%20moto%20-%20Easley%20Blackwood.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%A9%BA%E8%B0%B7%E9%9A%8F%E6%83%B3.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《O BRIEN EDWARD - Paranoid Android originally perfomed by  radiohead》");
                instrument.setMusic_name2("Easley Blackwood Microtonal Etudes, Op. 28 - VII. 17 notes Con moto - Easley Blackwood");
                instrument.setMusic_name3("《空谷随想》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t电子音乐合成器的音色合成分三大类： \n" +
                        "    (1)乐音类。这是模拟各种乐器的发声。又分木管、铜管、弦乐(拉奏或弹奏)、人声、敲击乐器(钟琴、钢琴、木琴、鼓、镲等)、宇宙声、口哨声等。 \n" +
                        "    (2)噪声类。其中分有规律的噪声(如机器声、火车轮声、脚步声等)和无规律噪声(如风、雨、海浪、兽吼、枪炮声等)。 \n" +
                        "    (3)乐声与噪声的混合类。这是噪声的音调化，例如用钢板敲击声或狗叫声来演奏旋律。\n");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/15Hechengqi-Roland%20AIRA%20SYSTEM.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：键盘是合成器最重要的操作部位，一般用右手在键盘上弹奏，左手控制音量与滑音轮及各种按钮，必要时才使用双手在键盘上弹奏。所以作曲者需注意，尽量不要使用双手才能完成的技巧交给一只手去完成。");
                break;
            case "镲":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">敲");
                instrument.setGuide4(">镲");
                instrument.setName("镲");
                instrument.setPic_spe(R.drawable.cha);
                instrument.setPic_struct(R.drawable.struct_white);
                instrument.setBrief1("\t\t\t\t镲是一种汉族打击乐器，即小钹。或称镲子、铰子等。汉族民间常用类型一般为黄铜镲和铁镲两种。因为镲是无固定音高乐器，所以 总的来说小镲声音最高，其次是中镲，大镲的声音是最低的。 ");
                instrument.setBrief0("\t\t\t\t镲面较平，厚度比钹稍薄、较铙略厚，中部碗小顶圆。通常面径12厘米～20厘米，碗径为面径的2/5、碗高1.5厘米～2.5厘米，碗顶钻孔系以绸布，两面为一副。厚度比钹稍薄、较铙略厚，中部碗小顶圆。");
                instrument.setContent("\t\t\t\t镲是由钹派生而来的一种乐器。原始人学会拍巴掌是产生节奏的基本方法。漏斗形镲的碰奏是上下运动，两镲的口须略错开互碰，以免影响共鸣而声音发闷。古代的镲一般较小，直径尺寸约6.35厘米（2.5英寸）上下；古代埃及、希腊和罗马的镲也大致如此。较大的，出土有一副约公元前850年的镲，是在一具木乃伊身上发现的，系锤锻制成的青铜镲，直径为6.75英寸（约17.14厘米，收藏于英国博物馆）。还有一种装在一根叉棒上的成对小镲，叫克罗塔尔crotals，出现也很早。 \n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%95%B2.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Zildjian%20Sound%20Lab%20-%20Cymbal%20Comparison%20Video%20-%20Full%20Version.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/Zildjian%20Sound%20Lab%20-%20Cymbal%20Comparison%20Video%20-%20Full%20Version.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《镲》");
                instrument.setMusic_name2("《Zildjian Sound Lab 》");
                instrument.setMusic_name3("《D大调卡农》");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t发音响亮、谐音丰富，属于节拍乐器。");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/Zildjian%20Sound%20Lab%20-%20Cymbal%20Comparison%20Video%20-%20Full%20Version.mp4");
                instrument.setSkill("\t\t\t\t演奏技巧：1、双手举起左右各竖持一片镲，在一片向上一片向下的运动中猛然相互擦碰，这是常用的发单声击法；将一对镲快速反复互碰，即为“双片滚奏”。\n" +
                        "2、将一片镲水平固定，用另一片由上而下扣击，如：（1）在行进乐队中，常在背于胸前的大鼓圈上水平固定一片镲，鼓手持另一片镲由上向下扣击，同时用另一手执槌击鼓。（2）在交谊舞、爵士等乐队中，常用一种踩镲，下面一片固定于镲架上，当踩下踏板，上面一片镲即向下扣击另一片镲。（3）有些民族镲，如印尼的嗪嗪小镲chengcheng和林奇克镲rinchik，系各将一片镲固定于一个小墩子上，双手各持另一片钹向下扣击。    \n" +
                        "3、用槌击奏。一手握住手带将一片镲提起，或将一片镲装在一个支架上，用一根小鼓槌、大鼓或定音鼓软头槌、橡皮头槌敲镲产生不同效果的单音；或用一对鼓槌快速轮替敲镲，即产生滚奏效果。\n");
                break;
            case "木琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">敲");
                instrument.setGuide4(">木琴");
                instrument.setName("木琴");
                instrument.setPic_spe(R.drawable.gray);
                instrument.setPic_struct(R.drawable.struct_muqin);
                instrument.setBrief1("");
                instrument.setBrief0("");
                instrument.setContent("");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("");
                instrument.setMusic_url2("");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("");
                instrument.setMusic_name2("");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("");
                instrument.setVideo_url("");
                instrument.setSkill("");
                break;
            case "定音鼓":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">敲");
                instrument.setGuide4(">定音鼓");
                instrument.setName("定音鼓");
                instrument.setPic_spe(R.drawable.gray);
                instrument.setPic_struct(R.drawable.struct_dingyingu);
                instrument.setBrief1("\t\t\t\t定音鼓：膜鸣乐器。定音鼓是由一个铜制或黄铜制的共鸣胴，通常以两个以上为一组，演奏时使用两支前头包着毛毡的木制鼓棒，常用基本奏法有单奏及滚奏。 ");
                instrument.setBrief0("\t\t\t\t定音鼓由鼓身、鼓皮、定音系统和鼓锤等部分组成，直径：48-81cm。鼓身：金属结构；鼓皮：牛、羊、驴皮均可，或使用合成材料。鼓锤：短木锤。根据演奏需要 决定是否在一端包以弹性材料。 ");
                instrument.setContent("\t\t\t\t定音鼓起源于土耳其骆驼滚筒，并在15世纪途径匈牙利传到欧洲");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("");
                instrument.setMusic_url2("");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("");
                instrument.setMusic_name2("《降E大调第103号交响曲》");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t发声原理：被拉伸表面振动发声 \n" +
                        "定音鼓可发出固定频率 （即音高）的声音，并能够在五度音程范围内改变音高。 音色柔和、丰满，音量可控制，不同的力度可表现 不同的音乐内容，有时甚至可以直接演奏出旋律。\n");
                instrument.setVideo_url("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%B2%99%E7%B1%B3%E6%89%93%E5%87%BB%E4%B9%90%EF%BC%9A01%20%E5%AE%9A%E9%9F%B3%E9%BC%93%E7%BB%84%E6%9B%B2.flv");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏方法分为单奏和滚奏两种，单奏多用于节拍性伴奏，滚奏则可以模仿雷声，且效果逼真。定音鼓作为色彩性打击乐器，其丰富的表现力远非普通打击乐器所能比拟。  \n" +
                        "要想把鼓打的好，在表演中很快的转换音高，需要非常娴熟的技术。敲击时左手持鼓，右手执槌。持鼓是以左手大指和食指，中指托之。执槌是以右手大指、食指和中指合持，向内敲之。\n");
                break;
            case "三角铁":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">敲");
                instrument.setGuide4(">三角铁");
                instrument.setName("三角铁");
                instrument.setPic_spe(R.drawable.sanjiaotie);
                instrument.setPic_struct(R.drawable.struct_sanjiaotie);
                instrument.setBrief1("\t\t\t\t三角铁，民族打击乐器 ");
                instrument.setBrief0("\t\t\t\t三角铁是一种钢制的三角形打击乐器，主体由一根弯成等腰三角形的弹簧钢条 （首尾不连接）组成，另有一根金属棒， 用来敲击主体以发声。三角铁金属的直径约为1cm,每个边边长大概10-25cm。");
                instrument.setContent("\t\t\t\t三角铁最早见于10世纪的乐谱中，当时这乐器的形状是等边或不等边四角形，下挂有铃铛。中世纪时这种乐器发展呈现在这种三角铁的形状，但体积稍大，通常用于教堂音乐，但也使用于世俗音乐中，常是用来为风笛伴奏。18世纪初，三角铁开始应用于歌剧。大型的三角铁在欧洲一些国家和美国被用于火灾的警报。");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("");
                instrument.setMusic_url2("");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("");
                instrument.setMusic_name2("");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t三角铁声音清脆而有穿透力，要奏出不同音量的声音，须敲在三角铁的合适的部位敲击三角铁不同部位。底边音最低，等腰上段的音较高，奏震音则反复快速敲击角隅的两边，或在三角内划圆圈轮击三边，才能取得良好的效果。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：（1）演奏姿势﹕左手手掌弯曲举至胸前，把三角铁上的绳环挂在食指上，再以拇指辅助握持，右手持击槌。\n" +
                        "（2）演奏方法﹕右手持击槌轻敲三角铁缺口的对边中心点（此点为三角铁全器之中心点，声响最匀称优美），或敲击底边的中心点（敲击此点比较简单，适合一、二年级或初学的学生，三角铁最稳定，不会晃动）。演奏颤音时，则是来回敲击三角铁缺口的对角两边。\n" +
                        "（3）消音法﹕三角铁是金属乐器，敲击一个声音以后，它会持续发出共鸣声，所以要用左手五指指尖握持三角铁，以消除馀音。\n");
                break;
            case "钢片琴":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">敲");
                instrument.setGuide4(">钢片琴");
                instrument.setName("钢片琴");
                instrument.setPic_spe(R.drawable.gangpianqin);
                instrument.setPic_struct(R.drawable.struct_gangpianqin);
                instrument.setBrief1("\t\t\t\t钢片琴，击奏体鸣乐器。用于管弦乐队和管乐队的打击乐器。形如小型钢琴的键盘乐器。");
                instrument.setBrief0("\t\t\t\t钢片琴由音条、琴架、木质共鸣板和硬质琴槌组成。其外表看起来类似一架直立式的小钢琴,也有点像小型的簧风琴,是型如小型钢琴的键盘乐器,踏板有一个至两个。踏板的功能与钢琴的延音踏板一样。和键盘形铁琴不同的地方：(1)键盘形铁琴使用硬质琴槌敲奏，钢片琴是使用和钢琴一样的琴槌。(2)键盘形铁琴没有共鸣板，钢片琴有木制共鸣板。(3)钢片琴的音板两头有另和皆有钢块，铁琴则没有。");
                instrument.setContent("\t\t\t\t钢片琴原名是 celesta mustel （ cle. ），celesta的意思是天上之音，钢片琴为法国巴黎mustel . victer发明。最初的发音体用一系列音叉，亦称钢叉琴。 1886年正式命名为钢片琴，实际现在的钢片琴音条和共鸣管均以铝制作。 现在开始有了音域扩增了低一度的乐器。\n" +
                        "柴可夫斯基是第一位使用钢片琴的作曲家。\n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/Goblin%20-%20School%20At%20Night%20%28Lullaby%20-%20Celesta%20Version%29.mp3");
                instrument.setMusic_url2("");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("《Goblin - School At Night (Lullaby - Celesta Version)》");
                instrument.setMusic_name2("");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t钢片琴高音域的音色跟钢琴差不多，天堂般的感受，但低音域的音色却有独特之处。 低音区 淳厚、圆润；中音区 清脆、明亮，效果最佳；高音区 较尖锐，共鸣短促。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：钢片琴与钢琴演奏方法相同，因其发音的机动没有钢琴灵敏，快速度连续反复的乐句不宜演奏，可演奏音阶、半音阶、和弦、分解和弦、琶音及音程跳跃；其力度较弱，可独奏也可伴奏。它是交响乐队中最宁静、最纤雅的乐器，状如小钢琴，音色清净，象星光般皎洁。 ");
                break;
            case "沙槌":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">敲");
                instrument.setGuide4(">沙槌");
                instrument.setName("沙槌");
                instrument.setPic_spe(R.drawable.shachui);
                instrument.setPic_struct(R.drawable.struct_shachui);
                instrument.setBrief1("\t\t\t\t沙槌，亦称沙球，摇奏体鸣乐器，一般归于打击类。砂槌为典型的拉丁美洲节奏乐器，常用于拉丁美洲舞曲音乐之中，更是伦巴乐队必备的乐器，有时也在西方管弦乐队中用作节奏性乐器。");
                instrument.setBrief0("\t\t\t\t多用密封的椰子壳制成，内装沙粒，两个一组，沙槌有木把。");
                instrument.setContent("\t\t\t\t沙槌已经存在了好几个世纪，起源于南美印第安人的节奏性打击乐器。历史上第一个沙槌是由葫芦里面装着种子制成的，以葫芦原有细长颈部为柄，摇动时使硬颗粒撞击葫芦壳壁发声。也有木制、陶制、藤编和塑料制等形状类似的沙槌，内装珠子、铅丸等物。现代管弦乐队和歌舞乐队中使用的沙槌是以古巴变体为基础制作的，多是用一块木头插入葫芦为柄。");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("http://7xkqzu.com1.z0.glb.clouddn.com/%E6%B2%99%E9%94%A4%E7%8B%AC%E5%A5%8F.mp3");
                instrument.setMusic_url2("http://7xkqzu.com1.z0.glb.clouddn.com/Cha%20Cha%20Maracas-%20Phil%20Upchurch.mp3");
                instrument.setMusic_url3("http://7xkqzu.com1.z0.glb.clouddn.com/6%20spoons%20-%20Maraca.mp3");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("沙槌独奏");
                instrument.setMusic_name2("6 spoons - Maraca");
                instrument.setMusic_name3("Cha Cha Maracas- Phil Upchurch");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t沙槌是非固定音高乐器，用一线记谱。沙槌发音清脆而略带沙沙声，通常为急板音乐或快奏音乐伴奏，起烘托气氛的作用。");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：演奏时左右手各握一把，双手交替上下晃动，奏出各种节奏音型。通常用手锄摇动发音。其中一个沙槌比另一个略微倾斜的高一点点。");
                break;
            case "架子鼓":
                instrument.setGuide2(">西洋乐器");
                instrument.setGuide3(">敲");
                instrument.setGuide4(">架子鼓");
                instrument.setName("架子鼓");
                instrument.setPic_spe(R.drawable.jiazigu);
                instrument.setPic_struct(R.drawable.struct_jiazigu);
                instrument.setBrief1("\t\t\t\t架子鼓：一套以鼓为主的组合性打击乐器。");
                instrument.setBrief0("\t\t\t\t架子鼓由低音大鼓、踩镲、小军鼓、桶子鼓（3-7个）、吊镲（2-4面）高音镲所组成。 ");
                instrument.setContent("\t\t\t\t架子鼓形成于20世纪40年代，它包含着各种不同类型、不同音色的手击乐器和脚击乐器。手击乐器有小鼓、嗵鼓、吊钗等，脚击乐器有大鼓、踩钗。\n" +
                        "架子鼓是用以演奏摇滚、扭摆及爵士音乐的打击乐器，在长期的演奏过程中，形成一套固定的节奏类型，如迪斯高、伦巴、探戈、桑巴、恰恰、波莱罗等节奏。这些节奏型气纷强烈、节奏鲜明，各自具有独特的风格。  \n");
                instrument.setPic_position(R.drawable.position_white);
                instrument.setMusic_url1("");
                instrument.setMusic_url2("");
                instrument.setMusic_url3("");
                instrument.setMusic_url4("");
                instrument.setMusic_name1("");
                instrument.setMusic_name2("");
                instrument.setMusic_name3("");
                instrument.setMusic_name4("");
                instrument.setMusic_content("\t\t\t\t架子鼓的音色所因遭的环境气纷强烈、节奏鲜明。 ");
                instrument.setVideo_url("");
                instrument.setSkill("\t\t\t\t演奏技巧：低音大鼓 (Bass drum)用右脚自然平放在踏板上，敲击时脚腕和脚掌松弛自然，脚随踏板上下运动，脚掌不要抬得过高，除连续演奏重音外，脚跟不要离开踏板。\n" +
                        "踩镲 (Hi-hat)用左脚，预备演奏时提起左脚跟，开始演奏时脚跟下、脚掌上，脚掌下、脚跟上，脚跟、脚掌的运动必须自然跟随踏不板，不可抬得过高或动作缓慢。\n" +
                        "小鼓 (Snare drum)一般左右手都可以直扣腕式（手心向下）进行演奏。\n" +
                        "手镲用左手，在踩镲上采用直扣式敲击各种节奏。\n" +
                        "吊镲用右手，是代替手镲演奏各种节奏，采用直腕式或直扣式，一般有槌头敲镲面，在演奏重音渲染强烈气氛时，用槌杆敲击镲的边沿处。大鼓（BD）小鼓（SD）低嗵鼓（FT）耳鼓（TT）踩钗（HH）大中立钗（CC）。\n" +
                        "⑴小鼓击奏法：\n" +
                        "小鼓也称军鼓，是西洋无调打击乐器中最主要的一件乐器，是架子鼓中的一件。小鼓的演奏姿势，也是架子鼓的演奏姿势。在架子鼓演奏中，因脚需同时踩大鼓和踩钗，所以采用坐姿演奏。演奏时要姿势端正，胸、肩、大臂等上身肢体自然放松。击奏时，双臂向上自然弯曲置于鼓面上，双手握槌，右手拇指第二关节和食指二三关节握鼓槌柄部，拇指与食指第三关节自然并拢，中指、无名指、小指掌心弯曲，与槌柄保持一定的间隙以控制鼓槌。左手掌心向内侧，拇指食指虎口处夹持鼓槌柄部，用无名指第三关节托住鼓槌底部。其它手指向掌心方向自然变曲成握球状。\n" +
                        "掌握了正确的持槌姿势，还要有正确的击奏方法。在训练中一定切记击奏二字，也就是说要弹击。鼓槌击打在鼓面后，须立即恢复击鼓时的预备动作。击鼓动作要完成于瞬间，而且有弹性和充分的共振，要奏得明亮、集中、结实、有力度，奏出丰满的音响效果。初学者练习击奏时还应注意击奏位置，应击在小鼓的中心点三至五厘米处。此外，还有边击法、制音边击法、交替击奏法、滚奏等等。在练习时可先单手练，然后双手练，也可双手交替练习。\n" +
                        "⑵低音大鼓踏奏法：\n" +
                        "　　低音大鼓用右脚踏击，在通常情况下，脚跟踩在踏板的后端，以踝关节为轴，用前脚掌踏击踏板而带动鼓槌击打鼓面。踏击时，大腿、小腿、脚部肌肉相应放松，槌头击鼓面后要立即返回，形成循环的踏击动作。在极强击奏时，可将脚悬起后用脚尖踏击踏板，使右腿全部重量落在一个点上，从而加强踏击的力度，得到预想的效果。\n" +
                        "⑶踩钗踏奏法：\n" +
                        "　　踩钗用左脚踏击，它的击奏要领是将脚跟踩在踏板的后端，以踝关节为轴，由脚前掌踏击踏板，当脚前掌击下后，不需要立即返回而需控制延音，造成封闭的音响效果，这也是与右脚大鼓不同之处。　 \n" +
                        "⑷嗵鼓击奏法：\n" +
                        "嗵鼓击奏要领同小鼓，在换鼓击奏时，需用手腕带动小臂和大臂，自然地运动到其它各鼓的部位，形成自然协调的动作。\n" +
                        "持棒方法在控制方面：主要是持棒的三种方式。\n" +
                        "　　1、直腕式：左右手持棒一样，以大拇指、食指、中指捏在鼓棒三分之一的地方，无名 指与小拇指自然并拢轻贴在后面，不要影响棒的运动，两手手心相对，注意双手的对称与平衡，鼓棒敲击点要相对集中。定音鼓、梯形木琴等基本都用此种腕法演奏。\n" +
                        "　　2、标准式：右手如直腕式，左手虎口夹住距离鼓棒棒尾端约三分之一的地方，并搁在无名指与小拇指半握后的关节上，食指与中指自然弯曲，整个手形呈半握拳状。掌心向内。以虎口拇指持棒，并以无名指与小拇指将棒托住，两鼓棒呈九十度左右。左手以翻转力量打击。此种腕法主要用于演奏小军鼓，以及爵士鼓奏法。\n" +
                        "　　3、扣腕式：持棒与直腕式大致相同，但双手要向内翻一下，使手心朝下，两鼓棒集中于敲击点上，两棒呈九十度左右的角度。玛琳巴琴、钢片琴、爵士鼓以及室内演奏小军鼓等均用此腕法。\n" +
                        "不论何种方式控制鼓棒，均须灵活运用手臂、手腕及手指，尤其是手腕及手指，使双手与鼓棒成为一体，自然地运动鼓棒，轻松自如。\n" +
                        "架子鼓 - 滚奏和压奏\n" +
                        "　　滚奏：方法通过控制鼓追均匀密集的击奏形成一定的速度才称之为滚奏。（滚奏的概念在国外一些教材上对滚奏的解释是单击和复击通称滚奏，但要求了单击的速度和复击的速度，有些则分开论述，但到最后还是一个速度问题。）加强单击和复击练习是滚奏得以实现基础。滚奏并不是完全的腕子，有时手指也能起到很大辅助作用，甚至有时手指的功劳更多。\n" +
                        "压奏：这种演奏方法是靠手腕的控制及鼓皮的反弹相结合的方法。这种技巧是表面上看很简单其实很难练习的，开始先用你的鼓锤在鼓皮上反复弹跳，然后要做到均匀，且在不同的演奏中还有很多连音的技巧，可不是想来的这么简单。练习方法正确速度要慢，要求每一下要让鼓锤充分的在鼓面上弹击并控制好鼓追的弹跳高度直至停止，再换另一只手进行相同的练习（这里说的是对称式，标准式道理相同），寻找鼓槌在鼓面弹击的感觉。练习到多次连续敲击时要有腕子控制的配合。 \n");
                break;
        }
        return instrument;
    }
}
