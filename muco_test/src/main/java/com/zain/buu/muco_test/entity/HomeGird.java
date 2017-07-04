package com.zain.buu.muco_test.entity;

/**
 * Created by Zain on 2016/3/21.
 * <p>
 * 首页列表图片的实体类
 */
public class HomeGird {
    private int img; //这是图片
    private String introduce;   //描述


    public HomeGird() {
        super();
    }

    public HomeGird(int img, String introduce) {
        super();
        this.img = img;
        this.introduce = introduce;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

}
