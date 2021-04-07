package com.hehe.base.http.okhttp;


import com.hehe.base.http.okhttp.chain.ChainManager;
import com.hehe.base.http.okhttp.chain.ConnectionServerInterceptor;
import com.hehe.base.http.okhttp.chain.Interceptor;
import com.hehe.base.http.okhttp.chain.ReRequestInterceptor;
import com.hehe.base.http.okhttp.chain.RequestHeaderInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RealCall implements Call {
    private OkHttpClient okHttpClient;
    private Request request;

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public Request getRequest() {
        return request;
    }

    public boolean isExecuted() {
        return executed;
    }

    public RealCall(OkHttpClient okHttpClient, Request request) {
        this.okHttpClient = okHttpClient;
        this.request = request;
    }

    private boolean executed;

    @Override
    public void enqueue(Callback responseCallback) {
        // 不能被重复的执行 enqueue
        synchronized (this) {
            if (executed) {
                executed = true;
                throw new IllegalStateException("不能被重复的执行 enqueue Already Executed");
            }
        }

        okHttpClient.dispatcher().enqueue(new RealCall.AsyncCall(responseCallback));

    }

    final class AsyncCall implements Runnable {

        public Request getRequest() {
            return RealCall.this.request;
        }

        private Callback callback;

        public AsyncCall(Callback callback) {
            this.callback = callback;
        }

        @Override
        public void run() {
            // 执行耗时操作
            boolean signalledCallback = false;
            try {
                Response response = getResponseWithInterceptorChain();
                // 如果用户取消了请求，回调给用户，说失败了
                if (okHttpClient.getCanceled()) {
                    signalledCallback = true;
                    callback.onFailure(RealCall.this, new IOException("用户取消了 Canceled"));
                } else {
                    signalledCallback = true;
                    callback.onResponse(RealCall.this, response);
                }

            } catch (IOException e) {
                // 责任的划分
                if (signalledCallback) { // 如果等于true，回调给用户了，是用户操作的时候 报错
                    System.out.println("用户再使用过程中 出错了...");
                } else {
                    callback.onFailure(RealCall.this, new IOException("OKHTTP getResponseWithInterceptorChain 错误... e:" + e.toString()));
                }
            } finally {
                // 回收处理
                okHttpClient.dispatcher().finished(this);
            }
        }

        /**
         * 责任链模式设计的拦截器
         * @return
         * @throws IOException
         */
        private Response getResponseWithInterceptorChain() throws IOException {
//            Response response = new Response();
//            response.setBody("流程走通....");
//            return response;

            List<Interceptor> interceptorList = new ArrayList<>();
            interceptorList.add(new ReRequestInterceptor()); // 重试拦截器 Response
            interceptorList.add(new RequestHeaderInterceptor()); // 请求头拦截器 Response
            interceptorList.add(new ConnectionServerInterceptor()); // 连接服务器的拦截器 Response

            ChainManager chainManager = new ChainManager(interceptorList, 0, request, RealCall.this);
            return chainManager.getResponse(request); // 最终返回的Response
        }

    }
}