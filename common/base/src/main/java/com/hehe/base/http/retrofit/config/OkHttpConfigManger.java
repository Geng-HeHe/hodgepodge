package com.hehe.base.http.retrofit.config;

import com.hehe.base.http.retrofit.constant.HttpConstant;

import java.util.ArrayList;
import java.util.List;

import okhttp3.CookieJar;
import okhttp3.Interceptor;

/**
 * 网络请求OkHttpClient配置类
 */
public class OkHttpConfigManger {
    private List<Interceptor> mInterceptor;
    private List<Interceptor> mNetworkInterceptor;
    private int mConnectTimeOut;
    private int mReadTimeOut;
    private int mWriteTimeOut;

    public OkHttpConfigManger(Builder builder) {
        this.mInterceptor = builder.mInterceptor;
        this.mNetworkInterceptor = builder.mNetworkInterceptor;
        this.mConnectTimeOut = builder.mConnectTimeOut;
        this.mReadTimeOut = builder.mReadTimeOut;
        this.mWriteTimeOut = builder.mWriteTimeOut;
    }

    public int getConnectTimeOut(){
        return mConnectTimeOut;
    }
    public int getReadTimeOut(){
        return mReadTimeOut;
    }
    public int getWriteTimeOut(){
        return mWriteTimeOut;
    }


    public List<Interceptor> interceptors(){
        return mInterceptor;
    }

    public List<Interceptor> networkInterceptor(){
        return mNetworkInterceptor;
    }

    public static class Builder{
        private List<Interceptor> mInterceptor = new ArrayList<>();
        private List<Interceptor> mNetworkInterceptor = new ArrayList<>();
        private int mConnectTimeOut = HttpConstant.DEFAULT_CONNECT_TIME_OUT;
        private int mReadTimeOut = HttpConstant.DEFAULT_READ_TIME_OUT;
        private int mWriteTimeOut = HttpConstant.DEFAULT_WRITE_TIME_OUT;

        public Builder addInterceptor(Interceptor interceptor){
            mInterceptor.add(interceptor);
            return this;
        }
        public Builder addNetworkInterceptor(Interceptor interceptor){
            mNetworkInterceptor.add(interceptor);
            return this;
        }
        public Builder connectTimeout(int connectTimeOut){
            mConnectTimeOut = connectTimeOut;
            return this;
        }
        public Builder readTimeout(int readTimeOut){
            mConnectTimeOut = readTimeOut;
            return this;
        }
        public Builder writeTimeout(int writeTimeOut){
            mConnectTimeOut = writeTimeOut;
            return this;
        }
        public OkHttpConfigManger build(){
            return new OkHttpConfigManger(this);
        }
    }
}
