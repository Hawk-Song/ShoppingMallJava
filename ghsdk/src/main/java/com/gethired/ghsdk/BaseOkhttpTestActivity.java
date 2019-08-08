package com.gethired.ghsdk;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BaseOkhttpTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void sendRequest(){


        OkHttpClient client=new OkHttpClient();

        //use Builder Pattern  to create a request
        final Request request=new Request.Builder()
                .url("http://www.baidu.com")
                .build();

        //send request to get async object call
        Call call=client.newCall(request);

        //add the request into scheduling, at this time the callback function is in async thread
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    //封装后的使用步骤
//    private void sendJsonTestRequest(){
//        CommonOkHttpClient.sendRequest(CommonRequest.createGetRequest("https://www.baidu.com",null),
//                new CommonJsonCallback(new DisposeDataHandle(new DisposeDataListener() {
//                    @Override
//                    public void onSuccess(Object responseObj) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Object reasonObj) {
//
//                    }
//                }))
//        );
//
//        //默认使用CommonJsonCallback
//        CommonOkHttpClient.get(CommonRequest.createGetRequest("url",null),
//                new DisposeDataHandle(new DisposeDataListener() {
//                    @Override
//                    public void onSuccess(Object responseObj) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Object reasonObj) {
//
//                    }
//                }));
//
//    }
}
