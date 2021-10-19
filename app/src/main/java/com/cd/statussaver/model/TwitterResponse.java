package com.cd.statussaver.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TwitterResponse implements Serializable {

    @SerializedName("videos")
    private ArrayList<TwitterResponseModel> videos;

    public ArrayList<TwitterResponseModel> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<TwitterResponseModel> videos) {
        this.videos = videos;
    }
}
