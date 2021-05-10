package com.hehe.hodgepodge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.hehe.base.base.BaseActivity;
import com.hehe.base.http.okhttp.Call;
import com.hehe.base.http.okhttp.Response;
import com.hehe.base.http.retrofit.HttpServiceCreator;
import com.hehe.base.http.retrofit.bean.ResponseBean;
import com.hehe.base.http.retrofit.common.AbstractObserver;
import com.hehe.base.http.retrofit.livedata.ResourceLiveData;
import com.hehe.base.tracking.drawable.TrackingDrawable;
import com.hehe.hodgepodge.handler.Handler;
import com.hehe.hodgepodge.handler.Message;
import com.hehe.hodgepodge.http.TestBean;
import com.hehe.hodgepodge.http.webService;
import com.hehe.hrouter.annotation.HRouter;
import com.hehe.hrouter.annotation.Parameter;
import com.hehe.hrouter.annotation.model.RouterBean;
import com.hehe.hrouter.api.ParameterManager;
import com.hehe.hrouter.api.RouterManager;
import com.hehe.hrouter.api.core.HRouterLoadPath;
import com.hehe.modular.helpcenter.HelpCenter_MainActivity;
import com.hehe.modular.tracking.Tracking_MainActivity;

import java.io.IOException;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@HRouter(path = "/app/MainActivity")
public class MainActivity extends BaseActivity {

    @Parameter(name = "/tracking/getDrawable")
    TrackingDrawable trackingDrawable;
    private Handler testHandler;

    @Override
    public void initActionBar() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        if (BuildConfig.isRelease) {
            Log.e("hehe", "当前为： 集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e("hehe", "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }
        ParameterManager.getInstance().loadParameter(this);
        int drawableId = trackingDrawable.getDrawable();
        ImageView img = findViewById(R.id.img);
        img.setImageResource(drawableId);
    }

    public void useOkHttp(){
        com.hehe.base.http.okhttp.OkHttpClient okHttpClient = new com.hehe.base.http.okhttp.OkHttpClient.Builder().build();

        com.hehe.base.http.okhttp.Request request = new com.hehe.base.http.okhttp.Request.Builder().build();

        com.hehe.base.http.okhttp.Call call = okHttpClient.newCall(request);

        call.enqueue(new com.hehe.base.http.okhttp.Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

        ResourceLiveData<TestBean> test = HttpServiceCreator.create(webService.class).test();
        test.observe(this,new AbstractObserver<TestBean>(){
                    @Override
                    public void Success(TestBean data) {
                        Log.d("hehe",data.data);
                        //super.Success(data);
                    }

                    @Override
                    public boolean Failed() {
                        return super.Failed();
                    }
                });


        testHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };


    }

    private void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 常规的写法
                Message message = new Message();
                message.obj = "Net163";
                message.what = 163;
                testHandler.sendMessage(message);


            }
        }).start();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void processClick(View v) {

    }

    public void jumpTracking(View view) {

        RouterManager.getInstance()
                .build("/tracking/Tracking_MainActivity")
                .withString("name","simon")
                .navigation(this,100);
    }

    public void jumpHelpCenter(View view) {

        RouterManager.getInstance()
                .build("/helpcenter/HelpCenter_MainActivity")
                .withString("username", "baby")
                .navigation(this, 110);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Log.e("hehe", data.getStringExtra("call"));
        }
    }
}