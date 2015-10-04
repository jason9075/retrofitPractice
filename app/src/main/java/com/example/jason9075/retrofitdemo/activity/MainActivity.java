package com.example.jason9075.retrofitdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jason9075.retrofitdemo.R;
import com.example.jason9075.retrofitdemo.DemoApplication;
import com.example.jason9075.retrofitdemo.model.GithubUserDto;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/*  Result: https://api.github.com/users/jason9075  */

public class MainActivity extends Activity {

    Button clickButton;
    TextView infoTextView;
    EditText accountEditText;
    Button nextPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_layout);

        clickButton = (Button) findViewById(R.id.button);
        infoTextView = (TextView) findViewById(R.id.tv);
        accountEditText = (EditText) findViewById(R.id.edit);

        nextPageButton = (Button) findViewById(R.id.button_next);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DemoApplication.getRequestApiSingleton().getGithubUserInfo(accountEditText.getText().toString()
                        , new Callback<GithubUserDto>() {
                    @Override
                    public void success(GithubUserDto githubUserDto, Response response) {
                        infoTextView.setText("ID:" + githubUserDto.getId());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        infoTextView.setText(error.getMessage());
                    }
                });
            }
        });

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
