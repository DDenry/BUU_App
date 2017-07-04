package com.zain.buu.muco_test.entity;

/**
 * Created by Zain on 2016/4/17.
 */
public class Music {

    private String key;
    private int id;


    public Music(int id, String key) {
        this.id = id;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getId() {
        return id;
    }

}
