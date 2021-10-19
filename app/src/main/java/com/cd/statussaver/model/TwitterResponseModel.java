package com.cd.statussaver.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TwitterResponseModel implements Serializable {

    @SerializedName("source")
    private String source;
    @SerializedName("text")
    private String text;
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("type")
    private String type;

    @SerializedName("duration")
    private int duration;

    @SerializedName("bitrate")
    private int bitrate;

    @SerializedName("url")
    private String url;
    @SerializedName("size")
    private int size;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
