package com.example.jason9075.retrofitdemo;

import com.example.jason9075.retrofitdemo.API.GithubInterfaceAPIs;
import com.example.jason9075.retrofitdemo.model.GithubUserDto;

import retrofit.Callback;

public class RequestApiSingleton {
    private GithubInterfaceAPIs githubInterfaceAPIs;

    public RequestApiSingleton(GithubInterfaceAPIs githubInterfaceAPIs) {
        this.githubInterfaceAPIs = githubInterfaceAPIs;
    }

    public void getGithubUserInfo(String user,Callback<GithubUserDto> response){
         githubInterfaceAPIs.getGithubUserInfo(user, response);
    }

//    public void getEvents(Callback<ArrayList<GithubEventDto>> response){
//        githubInterfaceAPIs.getEvents(response);
//    }
//
//    public void getGist(String id, Callback<GithubDistDto> response){
//        githubInterfaceAPIs.getGist(id, response);
//    }
}
