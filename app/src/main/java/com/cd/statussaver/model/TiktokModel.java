package com.cd.statussaver.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class TiktokModel implements Serializable {

    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("responsecode")
    String responsecode;
    @SerializedName("description")
    String description;
    @SerializedName("data")
    TiktokDataModel data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TiktokDataModel getData() {
        return data;
    }

    public void setData(TiktokDataModel data) {
        this.data = data;
    }
}
