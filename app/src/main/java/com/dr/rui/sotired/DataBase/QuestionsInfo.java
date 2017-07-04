package com.dr.rui.sotired.DataBase;

import com.dr.rui.sotired.Entity.Question;

/**
 * Created by rui on 2017/1/4.
 */

public class QuestionsInfo {
    public Question loadQuestionInfo(int type, int id) {
        Question question = new Question();
        switch (type) {
            //独奏题型，就是耳聪目慧
            case 0:
                question.setTitle("请听下面一段独奏，判断为哪种乐器演奏？");
                switch (id) {
                    case 0:
                        question.setUrl("http://7xkqzu.com1.z0.glb.clouddn.com/%E9%99%88%E6%82%A6%20-%20%E5%B9%B3%E6%B9%96%E7%A7%8B%E6%9C%88%20-%20%E8%90%A7.mp3");
                        question.setChoice1("葫芦丝");
                        question.setChoice2("箫");
                        question.setChoice3("笛子");
                        question.setAnswer(1);
                        break;
                    case 1:
                        question.setUrl("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%94%A2%E5%91%90%20%E5%96%9C%E8%BF%8E%E6%98%A5%20Happy%20To%20Greet%20Spring.mp3");
                        question.setChoice1("钵");
                        question.setChoice2("锣");
                        question.setChoice3("笙");
                        question.setAnswer(2);
                        break;
                    case 2:
                        question.setUrl("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%9F%99%E6%9B%B2%20%E5%AF%92%E6%B1%9F%E6%AE%8B%E9%9B%AA.mp3");
                        question.setChoice1("木琴");
                        question.setChoice2("埙");
                        question.setChoice3("三角铁");
                        question.setAnswer(1);
                        break;
                    case 3:
                        question.setUrl("http://7xkqzu.com1.z0.glb.clouddn.com/%E7%96%8F%E7%9F%B3%E5%85%B0%E5%85%AE%28%E7%AB%B9%E7%AC%9B%E7%8B%AC%E5%A5%8F%E7%89%88%29%20-%20%E9%AD%8F%E5%B0%8F%E6%B6%B5.mp3");
                        question.setChoice1("钵");
                        question.setChoice2("竹笛");
                        question.setChoice3("镲");
                        question.setAnswer(1);
                        break;
                    case 4:
                        question.setUrl("http://7xkqzu.com1.z0.glb.clouddn.com/%E5%94%A2%E5%91%90%20%E5%96%9C%E8%BF%8E%E6%98%A5%20Happy%20To%20Greet%20Spring.mp3");
                        question.setChoice1("箫");
                        question.setChoice2("笙");
                        question.setChoice3("唢呐");
                        question.setAnswer(2);
                        break;
                    case 5:
                        question.setUrl("");
                        question.setChoice1("月琴");
                        question.setChoice2("钢琴");
                        question.setChoice3("二胡");
                        question.setAnswer(0);
                        break;
                    case 6:
                        question.setUrl("");
                        question.setChoice1("古筝");
                        question.setChoice2("三角铁");
                        question.setChoice3("萨克斯");
                        question.setAnswer(2);
                        break;
                    case 7:
                        question.setUrl("");
                        question.setChoice1("电贝司");
                        question.setChoice2("钢琴");
                        question.setChoice3("唢呐");
                        question.setAnswer(1);
                        break;
                    case 8:
                        question.setUrl("");
                        question.setChoice1("箫");
                        question.setChoice2("钹");
                        question.setChoice3("排鼓");
                        question.setAnswer(2);
                        break;
                    case 9:
                        question.setUrl("");
                        question.setChoice1("短号");
                        question.setChoice2("沙槌");
                        question.setChoice3("长号");
                        question.setAnswer(1);
                        break;
                }
                break;
            //合奏
            case 1:
                break;
            //文字就是博闻强识
            case 2:
                switch (id) {
                    case 0:
                        question.setTitle("是一种管乐、管弦乐队中音域最低的铜管乐器，在乐队中主要担任低音部和声或节奏");
                        question.setChoice1("大号");
                        question.setChoice2("小号");
                        question.setChoice3("长号");
                        question.setAnswer(0);
                        break;
                    case 1:
                        question.setTitle("下列哪种乐器经常被称为“黑管”？");
                        question.setChoice1("单簧管");
                        question.setChoice2("巴松");
                        question.setChoice3("长笛");
                        question.setAnswer(0);
                        break;
                    case 2:
                        question.setTitle("下列哪种乐器又称为胡琴？");
                        question.setChoice1("二胡");
                        question.setChoice2("古琴");
                        question.setChoice3("三弦");
                        question.setAnswer(0);
                        break;
                    case 3:
                        question.setTitle("下列哪种乐器为西方经典乐器，体积较大，广为流传，被称为“乐器之王”？");
                        question.setChoice1("钢琴");
                        question.setChoice2("小提琴");
                        question.setChoice3("手风琴");
                        question.setAnswer(0);
                        break;
                    case 4:
                        question.setTitle("在民族乐器中，与二胡极为相似的乐器是");
                        question.setChoice1("高胡");
                        question.setChoice2("冬不拉");
                        question.setChoice3("马头琴");
                        question.setAnswer(0);
                        break;
                    case 5:
                        question.setTitle("某种中国蒙古族拉弦乐器，是一种两弦的弦乐器，有梯形的琴身和雕刻成马头形状的琴柄。");
                        question.setChoice1("二胡");
                        question.setChoice2("柳琴");
                        question.setChoice3("马头琴");
                        question.setAnswer(2);
                        break;
                    case 6:
                        question.setTitle("“民族拨弦乐器，中国最古老的弹拨乐器之一。又称瑶琴、玉琴、丝桐和七弦琴，有三千年以上历史，属于八音中的丝。”描述的是下列哪种乐器？");
                        question.setChoice1("古琴");
                        question.setChoice2("三弦");
                        question.setChoice3("阮");
                        question.setAnswer(0);
                        break;
                    case 7:
                        question.setTitle("“一种键盘乐器，属于气鸣乐器类的混合型乐器。在欧洲乐器中占有统治地位，被称为乐器之王的”是下列哪个乐器？");
                        question.setChoice1("管风琴");
                        question.setChoice2("钢琴");
                        question.setChoice3("合成器");
                        question.setAnswer(0);
                        break;
                    case 8:
                        question.setTitle("类似弓形，最古老的拨弦乐器之一，交响乐队以及歌舞剧中音域最宽很广的乐器是下列哪个？");
                        question.setChoice1("管风琴");
                        question.setChoice2("竖琴");
                        question.setChoice3("手风琴");
                        question.setAnswer(1);
                        break;
                    case 9:
                        question.setTitle("是一种管弦乐器，在乐队中常担任主要旋律的演奏，具有田园风味的木管乐器，台湾民间称为鼓吹，广东地区亦将之称为“八音”。");
                        question.setChoice1("长笛");
                        question.setChoice2("英国管");
                        question.setChoice3("双簧管");
                        question.setAnswer(2);
                        break;
                }
                break;
            //识别就是观察入微
            case 3:
                switch (id) {
                    case 0:
                        question.setTitle("二胡在下列哪个位置上？");
                        question.setDrawableStr("position_erhu");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(1);
                        break;
                    case 1:
                        question.setTitle("琵琶在下列哪个位置上？");
                        question.setDrawableStr("position_pipa");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(2);
                        break;
                    case 2:
                        question.setTitle("图中空缺应该是哪种乐器？");
                        question.setDrawableStr("position_dahao");
                        question.setChoice1("琵琶");
                        question.setChoice2("钢琴");
                        question.setChoice3("大号");
                        question.setAnswer(2);
                        break;
                    case 3:
                        question.setTitle("大锣在下列哪个位置上？");
                        question.setDrawableStr("position_luo");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(2);
                        break;
                    case 4:
                        question.setTitle("大锣在下列哪个位置上？");
                        question.setDrawableStr("position_luo");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(2);
                        break;
                    case 5:
                        question.setTitle("大锣在下列哪个位置上？");
                        question.setDrawableStr("position_luo");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(2);
                        break;
                    case 6:
                        question.setTitle("大锣在下列哪个位置上？");
                        question.setDrawableStr("position_luo");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(2);
                        break;
                    case 7:
                        question.setTitle("大锣在下列哪个位置上？");
                        question.setDrawableStr("position_luo");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(2);
                        break;
                    case 8:
                        question.setTitle("大锣在下列哪个位置上？");
                        question.setDrawableStr("position_luo");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(2);
                        break;
                    case 9:
                        question.setTitle("大锣在下列哪个位置上？");
                        question.setDrawableStr("position_luo");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(2);
                        break;
                    case 10:
                        question.setTitle("大锣在下列哪个位置上？");
                        question.setDrawableStr("position_luo");
                        question.setChoice1("A");
                        question.setChoice2("B");
                        question.setChoice3("C");
                        question.setAnswer(2);
                        break;
                }
                break;
            //吹管乐器
            case 4:
                switch (id) {
                    case 0:
                        question.setTitle("下面哪种是吹奏乐器？");
                        question.setChoice1("巴乌");
                        question.setChoice2("古筝");
                        question.setChoice3("锣");
                        question.setAnswer(0);
                        break;
                    case 1:
                        question.setTitle("下列哪种为吹奏乐器？");
                        question.setChoice1("单簧管");
                        question.setChoice2("钢琴");
                        question.setChoice3("小提琴");
                        question.setAnswer(0);
                        break;
                    case 2:
                        question.setTitle("大号属于下列哪一类？");
                        question.setChoice1("木管");
                        question.setChoice2("铜管");
                        question.setChoice3("弦乐");
                        question.setAnswer(1);
                        break;
                    case 3:
                        question.setTitle("短笛的发声原理是哪种？");
                        question.setChoice1("气鸣");
                        question.setChoice2("体鸣");
                        question.setChoice3("弦鸣");
                        question.setAnswer(0);
                        break;
                    case 4:
                        question.setTitle("笙的发生原理是哪种？");
                        question.setChoice1("膜鸣");
                        question.setChoice2("气鸣");
                        question.setChoice3("体鸣");
                        question.setAnswer(1);
                        break;
                    case 5:
                        question.setTitle("下列哪种乐器为木管乐器？");
                        question.setChoice1("短笛");
                        question.setChoice2("钢片琴");
                        question.setChoice3("管风琴");
                        question.setAnswer(0);
                        break;
                    case 6:
                        question.setTitle("下面哪种是吹奏乐器？");
                        question.setChoice1("管风琴");
                        question.setChoice2("埙");
                        question.setChoice3("手风琴");
                        question.setAnswer(1);
                        break;
                    case 7:
                        question.setTitle("下图是哪个乐器的一部分？");
                        question.setDrawableStr("test_blow1");
                        question.setChoice1("笛子");
                        question.setChoice2("箫");
                        question.setChoice3("巴乌");
                        question.setAnswer(2);
                        break;
                    case 8:
                        question.setTitle("下图是哪个乐器的一部分？");
                        question.setDrawableStr("test_blow2");
                        question.setChoice1("葫芦丝");
                        question.setChoice2("箫");
                        question.setChoice3("唢呐");
                        question.setAnswer(0);
                        break;
                    case 9:
                        question.setTitle("下图是哪个乐器的一部分？");
                        question.setDrawableStr("test_blow3");
                        question.setChoice1("笙");
                        question.setChoice2("箫");
                        question.setChoice3("高胡");
                        question.setAnswer(0);
                        break;
                }
                break;
            //拉弦乐器
            case 5:
                switch (id) {
                    case 0:
                        question.setTitle("下列哪种乐器是拉弦类乐器？");
                        question.setChoice1("高胡");
                        question.setChoice2("琵琶");
                        question.setChoice3("巴乌");
                        question.setAnswer(0);
                        break;
                    case 1:
                        question.setTitle("马头琴的演奏方式为？");
                        question.setChoice1("吹");
                        question.setChoice2("拉");
                        question.setChoice3("弹");
                        question.setAnswer(1);
                        break;
                    case 2:
                        question.setTitle("下列哪种乐器是拉弦类乐器？");
                        question.setChoice1("颤音琴");
                        question.setChoice2("月琴");
                        question.setChoice3("冬不拉");
                        question.setAnswer(2);
                        break;
                    case 3:
                        question.setTitle("下列是哪个乐器的一部分？");
                        question.setDrawableStr("test_la1");
                        question.setChoice1("二胡");
                        question.setChoice2("小提琴");
                        question.setChoice3("萨克斯");
                        question.setAnswer(2);
                        break;
                    case 4:
                        question.setTitle("图是哪个乐器的一部分？");
                        question.setDrawableStr("test_la2");
                        question.setChoice1("三弦");
                        question.setChoice2("二胡");
                        question.setChoice3("木吉他");
                        question.setAnswer(0);
                        break;
                    case 5:
                        question.setTitle("图是哪个乐器的一部分？");
                        question.setDrawableStr("test_la3");
                        question.setChoice1("高胡");
                        question.setChoice2("二胡");
                        question.setChoice3("三弦");
                        question.setAnswer(0);
                        break;
                }
                break;
            //弹拨乐器
            case 6:
                switch (id) {
                    case 0:
                        question.setTitle("下列哪种乐器为弹奏乐器？");
                        question.setChoice1("电吉他");
                        question.setChoice2("萨克斯");
                        question.setChoice3("大提琴");
                        question.setAnswer(0);
                        break;
                    case 1:
                        question.setTitle("古琴的演奏方式为？");
                        question.setChoice1("吹");
                        question.setChoice2("拉");
                        question.setChoice3("弹");
                        question.setAnswer(2);
                        break;
                    case 2:
                        question.setTitle("管风琴的演奏方式为？");
                        question.setChoice1("吹");
                        question.setChoice2("拉");
                        question.setChoice3("弹");
                        question.setAnswer(2);
                        break;
                    case 3:
                        question.setTitle("柳琴的演奏方式为？");
                        question.setChoice1("吹");
                        question.setChoice2("拉");
                        question.setChoice3("弹");
                        question.setAnswer(2);
                        break;
                    case 4:
                        question.setTitle("琵琶的演奏方式为？");
                        question.setChoice1("吹");
                        question.setChoice2("拉");
                        question.setChoice3("弹");
                        question.setAnswer(2);
                        break;
                    case 5:
                        question.setTitle("手风琴的演奏方式为？");
                        question.setChoice1("吹");
                        question.setChoice2("拉");
                        question.setChoice3("弹");
                        question.setAnswer(2);
                        break;
                    case 6:
                        question.setTitle("下列哪种乐器为电鸣类？");
                        question.setChoice1("电吉他");
                        question.setChoice2("架子鼓");
                        question.setChoice3("手风琴");
                        question.setAnswer(0);
                        break;
                    case 7:
                        question.setTitle("下列是哪个乐器的一部分？");
                        question.setDrawableStr("test_tan1");
                        question.setChoice1("电吉他");
                        question.setChoice2("竖琴");
                        question.setChoice3("琵琶");
                        question.setAnswer(0);
                        break;
                    case 8:
                        question.setTitle("下列是哪个乐器的一部分？");
                        question.setDrawableStr("test_tan2");
                        question.setChoice1("钢琴");
                        question.setChoice2("古筝");
                        question.setChoice3("唢呐");
                        question.setAnswer(0);
                        break;
                    case 9:
                        question.setTitle("下图是哪个乐器的一部分？");
                        question.setDrawableStr("test_tan3");
                        question.setChoice1("古琴");
                        question.setChoice2("古筝");
                        question.setChoice3("高胡");
                        question.setAnswer(1);
                        break;

                }
                break;
            //打击乐器
            case 7:
                switch (id) {
                    case 0:
                        question.setTitle("下面哪种乐器是敲击乐器？");
                        question.setChoice1("阮");
                        question.setChoice2("巴松");
                        question.setChoice3("排鼓");
                        question.setAnswer(2);
                        break;
                    case 1:
                        question.setTitle("木鱼的演奏方式为？");
                        question.setChoice1("吹");
                        question.setChoice2("拉");
                        question.setChoice3("敲");
                        question.setAnswer(2);
                        break;
                    case 2:
                        question.setTitle("锣的发声原理是？");
                        question.setChoice1("膜鸣");
                        question.setChoice2("气鸣");
                        question.setChoice3("体鸣");
                        question.setAnswer(2);
                        break;
                    case 3:
                        question.setTitle("排鼓的发声原理是?");
                        question.setChoice1("膜鸣");
                        question.setChoice2("气鸣");
                        question.setChoice3("体鸣");
                        question.setAnswer(0);
                        break;
                    case 4:
                        question.setTitle("下列哪种乐器为体鸣乐器？");
                        question.setChoice1("木鱼");
                        question.setChoice2("二胡");
                        question.setChoice3("笙");
                        question.setAnswer(0);
                        break;
                    case 5:
                        question.setTitle("排鼓属于下列哪一类？");
                        question.setChoice1("打击乐");
                        question.setChoice2("弦乐");
                        question.setChoice3("管乐");
                        question.setAnswer(0);
                        break;
                    case 6:
                        question.setTitle("锣属于下列哪一类？");
                        question.setChoice1("打击乐");
                        question.setChoice2("弦乐");
                        question.setChoice3("管乐");
                        question.setAnswer(0);
                        break;
                    case 7:
                        question.setTitle("木鱼属于下列哪一类？");
                        question.setChoice1("打击乐");
                        question.setChoice2("弦乐");
                        question.setChoice3("管乐");
                        question.setAnswer(0);
                        break;
                    case 8:
                        question.setTitle("下面哪种乐器是敲击乐器？");
                        question.setChoice1("镲");
                        question.setChoice2("电钢琴");
                        question.setChoice3("古筝");
                        question.setAnswer(0);
                        break;
                    case 9:
                        question.setTitle("下图是哪个乐器的一部分？");
                        question.setDrawableStr("test_da1");
                        question.setChoice1("排鼓");
                        question.setChoice2("架子鼓");
                        question.setChoice3("钢琴片");
                        question.setChoice4("风琴");
                        question.setAnswer(1);
                        break;

                }
                break;
        }
        return question;
    }
}