package com.example.jason9075.retrofitdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GithubEventDto {

    private String id;
    private String type;

    @SerializedName("public")
    @Expose
    private  Boolean publicBoolean;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Boolean getPublicBoolean() {
        return publicBoolean;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
