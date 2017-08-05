package com.fjy.sharemoduledemo;

import com.fjy.sharelib.ShareItem;
import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by fujia on 2017/8/5.
 */

public class GameInfo implements Serializable ,ShareItem{
    private long id;
    private String name;
    private String playUrl;
    private String iconImg;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getSubTitle() {
        return null;
    }

    @Override
    public String getImgUrl() {
        return null;
    }

    @Override
    public String getShareUrl() {
        return null;
    }
}
