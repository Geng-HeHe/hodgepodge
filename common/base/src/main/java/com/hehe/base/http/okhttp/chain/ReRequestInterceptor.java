package com.hehe.base.http.okhttp.chain;

import com.hehe.base.http.okhttp.OkHttpClient;
import com.hehe.base.http.okhttp.RealCall;
import com.hehe.base.http.okhttp.Response;

import java.io.IOException;

/**
 * 重试拦截器
 */
public class ReRequestInterceptor implements Interceptor {

    private final String TAG = ReRequestInterceptor.class.getSimpleName();

    @Override
    public Response doNext(Chain chain) throws IOException {

        // Log.d(TAG, "我是重试拦截器，执行了");
        System.out.println("我是重试拦截器，执行了");

        ChainManager chainManager = (ChainManager) chain;

        RealCall realCall = chainManager.getCall();
        OkHttpClient client = realCall.getOkHttpClient();

        IOException ioException = null;

        // 重试次数
        if (client.getRecount() != 0) {
            for (int i = 0; i < client.getRecount(); i++) { // 3
                try {
                    // Log.d(TAG, "我是重试拦截器，我要Return Response了");
                    System.out.println("我是重试拦截器，我要Return Response了");
                    // 如果没有异常，循环就结束了
                    Response response = chain.getResponse(chainManager.getRequest()); // 执行下一个拦截器（任务节点）
                    return response;
                } catch (IOException e) {
                    // e.printStackTrace();
                    ioException = e;
                }

            }
        }
        // return null;
        throw ioException;
    }
}
