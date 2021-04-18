package com.hehe.base.http.retrofit.common;
/**
 * 网络请求状态回调接口
 * @param <T>
 */
public interface ResponseCallBack<T> {

    void Success(T data);
    boolean Failed();
 }
