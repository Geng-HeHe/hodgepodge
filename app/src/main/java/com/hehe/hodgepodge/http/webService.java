package com.hehe.hodgepodge.http;

import com.hehe.base.http.retrofit.livedata.ResourceLiveData;

import retrofit2.http.GET;

public interface webService {
    /**
     * test
     */
    @GET("test")
    ResourceLiveData<TestBean> test();


}
