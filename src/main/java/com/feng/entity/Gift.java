package com.feng.entity;

/**
 * Created by TTfly on 2017/6/12.
 */
public class Gift {

    private int id;
    private String title;
    private String describe;
    private String imgUrl;

    public Gift(int id, String title, String describe, String imgUrl) {
        this.id = id;
        this.title = title;
        this.describe = describe;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
