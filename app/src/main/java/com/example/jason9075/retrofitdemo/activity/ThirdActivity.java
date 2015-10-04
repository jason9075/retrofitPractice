package com.example.jason9075.retrofitdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jason9075.retrofitdemo.API.GithubInterfaceAPIs;
import com.example.jason9075.retrofitdemo.R;
import com.example.jason9075.retrofitdemo.model.GithubDistDto;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/*  Result: https://api.github.com/gists/75ff41983a6ca005d063  */

public class ThirdActivity extends Activity {

    Button clickButton;
    TextView infoTextView;
    EditText idEditText;
    Button backPageButton;
    String APIUrl = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_layout);

        clickButton = (Button) findViewById(R.id.button);
        infoTextView = (TextView) findViewById(R.id.tv);
        idEditText = (EditText) findViewById(R.id.id_edit_text);

        backPageButton = (Button) findViewById(R.id.button_back);

        idEditText.setText("75ff41983a6ca005d063");

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*      節省以下程式碼      */
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint(APIUrl)
                        .build();
                GithubInterfaceAPIs GithubInterfaceAPIs = restAdapter.create(GithubInterfaceAPIs.class);
                /*      節省以上程式碼      */

                GithubInterfaceAPIs.getGist(idEditText.getText().toString(), new Callback<GithubDistDto>() {
                    @Override
                    public void success(GithubDistDto githubDistDto, Response response) {
                        infoTextView.setText("ID:" + githubDistDto.getId());
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

    }
}