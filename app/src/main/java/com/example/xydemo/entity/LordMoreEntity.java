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
}
