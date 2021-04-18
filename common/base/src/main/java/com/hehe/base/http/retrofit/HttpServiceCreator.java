package com.hehe.base.http.retrofit;

import androidx.annotation.NonNull;

import com.hehe.base.http.retrofit.calladapter.LiveDataWithResourceCallAdapterFactory;
import com.hehe.base.http.retrofit.config.RetrofitConfigManager;
import com.hehe.base.http.retrofit.constant.HttpConstant;

import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.protobuf.ProtoConverterFactory;

public class HttpServiceCreator {
    private static RetrofitConfigManager sRetrofitConfigManager = new RetrofitConfigManager.Builder().build();
    private Retrofit mRetrofit;
    private static class SingletonHolder{
        private static HttpServiceCreator INSTANCE = new HttpServiceCreator();
    }
    public static void initConfiguration(@NonNull RetrofitConfigManager retrofitConfigManager){
        sRetrofitConfigManager = retrofitConfigManager;
    }
    public static RetrofitConfigManager getsRetrofitConfigManager(){
        return sRetrofitConfigManager;
    }

    private HttpServiceCreator(){
        Retrofit.Builder mRetrofitBuilder = new Retrofit.Builder();
        mRetrofitBuilder.baseUrl(HttpConstant.Base_URL)
                .client(OkHttpClient.getOkHttpClient())
                .addCallAdapterFactory(new LiveDataWithResourceCallAdapterFactory())
                ;

        if(null != sRetrofitConfigManager){
            for (Converter.Factory factory: sRetrofitConfigManager.customConverters()){
                mRetrofitBuilder.addConverterFactory(factory);
            }
            for (CallAdapter.Factory factory: sRetrofitConfigManager.customCallAdapters()){
                mRetrofitBuilder.addCallAdapterFactory(factory);
            }
        }

        //GsonConverter需要最后面加，不然会被拦截
        mRetrofitBuilder.addConverterFactory(ProtoConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        mRetrofit = mRetrofitBuilder.build();

    }

    protected Retrofit getRetrofit(){
        return mRetrofit;
    }

    /**
     * 创建网络请求接口代理类实例
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T create(Class<T> tClass){
        return SingletonHolder.INSTANCE.mRetrofit.create(tClass);
    }

}
