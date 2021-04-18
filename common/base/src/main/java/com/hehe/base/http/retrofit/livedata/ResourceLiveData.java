package com.hehe.base.http.retrofit.livedata;

import androidx.lifecycle.MutableLiveData;

import com.hehe.base.http.retrofit.common.Resource;

import retrofit2.Call;

/**
 * 带有取消功能的LiveData
 * @param <T>
 */
public class ResourceLiveData<T> extends MutableLiveData<Resource<T>> {
    private Call<T> mCall;

    public ResourceLiveData(Call<T> call){mCall = call;}


}