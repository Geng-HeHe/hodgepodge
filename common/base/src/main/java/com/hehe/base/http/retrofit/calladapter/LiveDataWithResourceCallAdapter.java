package com.hehe.base.http.retrofit.calladapter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hehe.base.http.retrofit.bean.ResponseBean;
import com.hehe.base.http.retrofit.common.Resource;
import com.hehe.base.http.retrofit.livedata.ResourceLiveData;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataWithResourceCallAdapter<T extends ResponseBean> implements CallAdapter<T, LiveData<Resource<T>>> {
    private Type mResponseType;
    private boolean mIsCurrentPageMainApi = false;

    public LiveDataWithResourceCallAdapter(boolean mIsCurrentPageMainApi) {
        this.mIsCurrentPageMainApi = mIsCurrentPageMainApi;
    }

    public LiveDataWithResourceCallAdapter(Type mResponseType, boolean mIsCurrentPageMainApi) {
        this.mResponseType = mResponseType;
        this.mIsCurrentPageMainApi = mIsCurrentPageMainApi;
    }


    @Override
    public Type responseType() {
        return mResponseType;
    }

    @Override
    public MutableLiveData<Resource<T>> adapt( Call<T> call) {
        final ResourceLiveData<T> data = new ResourceLiveData<>(call);

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse( Call<T> call,  Response<T> response) {
                if (response.isSuccessful()){
                    if (null != response.body()){
                        T body = response.body();
                        if (body.success){
                            data.postValue(Resource.success(body));
                        }
                    }
                }else {
                    data.postValue(Resource.<T>errorFailed());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                data.postValue(Resource.<T>errorFailed());

            }

        });

        return data;
    }
}
