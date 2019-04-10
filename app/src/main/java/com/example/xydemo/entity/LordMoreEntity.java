package com.example.xydemo.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LordMoreEntity implements Serializable {

    @SerializedName("desc")
    private String mDesc;

    @SerializedName("images")
    private List<String> mImages;

    @SerializedName("publishedAt")
    private Date mPublishedAt;

    @SerializedName("url")
    private String mUrl;

    public String getDesc() {
        return mDesc;
    }

    public List<String> getImages() {
        return mImages;
    }

    public Date getPublishedAt() {
        return mPublishedAt;
    }

    public String getUrl() {
        return mUrl;
    }


    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public List<String> getmImages() {
        return mImages;
    }

    public void setmImages(List<String> mImages) {
        this.mImages = mImages;
    }

    public Date getmPublishedAt() {
        return mPublishedAt;
    }

    public void setmPublishedAt(Date mPublishedAt) {
        this.mPublishedAt = mPublishedAt;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
