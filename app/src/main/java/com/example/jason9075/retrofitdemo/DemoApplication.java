package com.example.jason9075.retrofitdemo;

import android.app.Application;

import com.example.jason9075.retrofitdemo.API.GithubInterfaceAPIs;

import retrofit.RestAdapter;

public class DemoApplication extends Application {

    private static RequestApiSingleton requestApiSingleton;

    @Override
    public void onCreate() {
        super.onCreate();
        final String APIUrl = "https://api.github.com";
        GithubInterfaceAPIs githubInterfaceAPIs;

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(APIUrl)
                .build();
        githubInterfaceAPIs = restAdapter.create(GithubInterfaceAPIs.class);

        requestApiSingleton = new RequestApiSingleton(githubInterfaceAPIs);
    }

    public static RequestApiSingleton getRequestApiSingleton() {
        return requestApiSingleton;
    }

}
