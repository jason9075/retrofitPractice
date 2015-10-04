package com.example.jason9075.retrofitdemo.API;

import com.example.jason9075.retrofitdemo.model.GithubDistDto;
import com.example.jason9075.retrofitdemo.model.GithubEventDto;
import com.example.jason9075.retrofitdemo.model.GithubUserDto;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GithubInterfaceAPIs {

    @GET("/users/{user}")
    void getGithubUserInfo(@Path("user") String user, Callback<GithubUserDto> response);

    @GET("/events")
    void getEvents(Callback<ArrayList<GithubEventDto>> response);

    @GET("/gists/{id}")
    void getGist(@Path("id") String id, Callback<GithubDistDto> response);
}
