package com.hehe.base.http.okhttp.chain;


import com.hehe.base.http.okhttp.RealCall;
import com.hehe.base.http.okhttp.Request;
import com.hehe.base.http.okhttp.Response;

import java.io.IOException;
import java.util.List;


/**
 * 责任节点任务管理器
 */
public class ChainManager implements Chain {

    private final List<Interceptor> interceptors;
    private int index;
    private final Request request; // 请求头拦截器 更新Request
    private final RealCall call;

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public int getIndex() {
        return index;
    }

    public RealCall getCall() {
        return call;
    }

    public ChainManager(List<Interceptor> interceptors, int index, Request request, RealCall call) {
        this.interceptors = interceptors;
        this.index = index;
        this.request = request;
        this.call = call;
    }

    @Override
    public Request getRequest() {
        return request;
    }

    @Override
    public Response getResponse(Request request) throws IOException {
        // 判断index++计数  不能大于 size 不能等于
        if (index >= interceptors.size()) throw new AssertionError();

        if (interceptors.isEmpty()) {
            throw new IOException("interceptors is empty");
        }


        // 取出第一个 拦截器
        Interceptor interceptor = interceptors.get(index); // 0，1，

        ChainManager manager = new ChainManager(interceptors, index + 1, request, call);

        Response response = interceptor.doNext(manager);

        return response;
    }
}
