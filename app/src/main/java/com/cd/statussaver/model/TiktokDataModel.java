package com.cd.statussaver.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TiktokDataModel implements Serializable {
    @SerializedName("mainvideo")
    String mainvideo;
    @SerializedName("videowithoutWaterMark")
    String videowithoutWaterMark;
    @SerializedName("userdetail")
    String userdetail;
    @SerializedName("thumbnail")
    String thumbnail;

    public String getMainvideo() {
        return mainvideo;
    }

    public void setMainvideo(String mainvideo) {
        this.mainvideo = mainvideo;
    }

    public String getVideowithoutWaterMark() {
        return videowithoutWaterMark;
    }

    public void setVideowithoutWaterMark(String videowithoutWaterMark) {
        this.videowithoutWaterMark = videowithoutWaterMark;
    }

    public String getUserdetail() {
        return userdetail;
    }

    public void setUserdetail(String userdetail) {
        this.userdetail = userdetail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
