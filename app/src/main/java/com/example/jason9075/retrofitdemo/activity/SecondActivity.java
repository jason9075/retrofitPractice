package com.example.jason9075.retrofitdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jason9075.retrofitdemo.API.GithubInterfaceAPIs;
import com.example.jason9075.retrofitdemo.R;
import com.example.jason9075.retrofitdemo.model.GithubEventDto;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/*  Result: https://api.github.com/events  */

public class SecondActivity extends Activity {

    Button clickButton;
    TextView infoTextView;
    Button backPageButton;
    Button nextPageButton;
    String APIUrl = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);

        clickButton = (Button) findViewById(R.id.button);
        infoTextView = (TextView) findViewById(R.id.tv);

        backPageButton = (Button) findViewById(R.id.button_back);
        nextPageButton = (Button) findViewById(R.id.button_next);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*      節省以下程式碼      */
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint(APIUrl)
                        .build();
                GithubInterfaceAPIs GithubInterfaceAPIs = restAdapter.create(GithubInterfaceAPIs.class);
                /*      節省以上程式碼      */

                GithubInterfaceAPIs.getEvents(new Callback<ArrayList<GithubEventDto>>() {
                    @Override
                    public void success(ArrayList<GithubEventDto> githubEventDtos, Response response) {
                        String content = "";
                        for (GithubEventDto githubEventDto : githubEventDtos) {
                            content += "id:" + githubEventDto.getId() + "\n";
                        }
                        infoTextView.setText(content);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        infoTextView.setText(error.getMessage());
                    }
                });
            }
        });

        backPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
