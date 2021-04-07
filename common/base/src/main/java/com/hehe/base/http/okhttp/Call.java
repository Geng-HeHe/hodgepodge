package com.hehe.base.http.okhttp;


public interface Call {
    void enqueue(Callback responseCallback);
}
