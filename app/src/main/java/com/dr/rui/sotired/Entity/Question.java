package com.dr.rui.sotired.Entity;

/**
 * Created by rui on 2017/1/4.
 */

/***
 * type:
 * 0-独奏
 * 1-合奏
 * 2-文字
 * 3-识别
 */
public class Question {
    private int id;
    private int type;
    private String title;
    private String url;
    private String drawableStr;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private int answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDrawableStr() {
        return drawableStr;
    }

    public void setDrawableStr(String drawableStr) {
        this.drawableStr = drawableStr;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
