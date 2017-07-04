package com.zain.buu.muco_test.entity;

/**
 * Created by Zain on 2016/5/12.
 */
public class Guqin_Key {


    private int id;
    private int img;
    private int img_d;
    private int sound;


    public Guqin_Key(int id, int img, int img_d, int sound) {
        this.id = id;
        this.img = img;
        this.img_d = img_d;
        this.sound = sound;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setImg_d(int img_d) {
        this.img_d = img_d;
    }
}
