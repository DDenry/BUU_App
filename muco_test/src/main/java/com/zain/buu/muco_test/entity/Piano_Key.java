package com.zain.buu.muco_test.entity;


/**
 * Created by Zain on 2016/3/21.
 * <p>
 * 钢琴按键实体类
 */
public class Piano_Key {


    private int id;
    private int img;
    private int sound;
    private int img_d;
    private String txt;
    private int tId;
    private int count;


    public Piano_Key(int id, int img, int sound, int img_d, int tId, String txt, int count) {

        this.id = id;
        this.img = img;
        this.sound = sound;
        this.img_d = img_d;
        this.tId = tId;
        this.txt = txt;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getImg_d() {
        return img_d;
    }

    public String getTxt() {
        return txt;
    }

    public int getTId() {
        return tId;
    }

    public int getCount() {
        return count;
    }


}
