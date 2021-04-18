package com.hehe.base.http.retrofit;

import android.os.Build;

import com.hehe.base.http.retrofit.config.OkHttpConfigManger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.TlsVersion;

/**
 * 提供相同的OkHttpClient 实例，用在所有的网络
 */
public class OkHttpClient {
    /**
     * 默认配置
     */
    private static OkHttpConfigManger sConfigManger = new OkHttpConfigManger.Builder().build();

    private OkHttpClient(){}

    private static volatile okhttp3.OkHttpClient sClient;
    public static okhttp3.OkHttpClient getOkHttpClient(){
        if(null == sClient){
            synchronized (okhttp3.OkHttpClient.class){
                if (null == sClient){
                    sClient = createClient();
                }
            }
        }
        return sClient;
    }

    private static okhttp3.OkHttpClient createClient() {
        return createClientBuilder().build();
    }

    private static okhttp3.OkHttpClient.Builder createClientBuilder() {
        //默认没有超时
        okhttp3.OkHttpClient.Builder client = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(sConfigManger.getConnectTimeOut(), TimeUnit.MILLISECONDS)
                .readTimeout(sConfigManger.getReadTimeOut(), TimeUnit.MILLISECONDS)
                .writeTimeout(sConfigManger.getWriteTimeOut(), TimeUnit.MILLISECONDS);

        for (Interceptor interceptor : sConfigManger.interceptors()){
            client.addInterceptor(interceptor);
        }

        for (Interceptor interceptor : sConfigManger.networkInterceptor()){
            client.addNetworkInterceptor(interceptor);
        }

        return client;
    }

    /**
     * 初始化OkhttpClient配置
     */
    public static void initConfigManger(OkHttpConfigManger configManger){
        sConfigManger = configManger;
    }

 }
