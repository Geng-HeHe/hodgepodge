package com.hehe.base.http.retrofit.config;


import java.util.ArrayList;
import java.util.List;

import retrofit2.CallAdapter;
import retrofit2.Converter;

public class RetrofitConfigManager {
    private List<Converter.Factory> mCustomConverters =  new ArrayList<>();
    private List<CallAdapter.Factory> mCustomCallAdapters =  new ArrayList<>();

    public RetrofitConfigManager(Builder builder) {
        this.mCustomCallAdapters = builder.mCustomCallAdapters;
        this.mCustomConverters = builder.mCustomConverters;
    }

    public List<Converter.Factory> customConverters(){return mCustomConverters;}
    public List<CallAdapter.Factory> customCallAdapters(){return mCustomCallAdapters;}
    public static class Builder{
        private List<Converter.Factory> mCustomConverters =  new ArrayList<>();
        private List<CallAdapter.Factory> mCustomCallAdapters =  new ArrayList<>();
        public Builder addConverter( Converter.Factory cf){
            mCustomConverters.add(cf);
            return this;
        }
        public Builder addCallAdapter( CallAdapter.Factory cf){
            mCustomCallAdapters.add(cf);
            return this;
        }

        public RetrofitConfigManager build(){
            return new RetrofitConfigManager(this);
        }
    }
}
