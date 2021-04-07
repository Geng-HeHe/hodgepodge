package com.hehe.base.http.okhttp.chain;

import com.hehe.base.http.okhttp.Request;
import com.hehe.base.http.okhttp.RequestBody;
import com.hehe.base.http.okhttp.Response;
import com.hehe.base.http.okhttp.SocketRequestServer;

import java.io.IOException;
import java.util.Map;

/**
 * 请求头拦截器处理
 */
public class RequestHeaderInterceptor implements Interceptor {

    @Override
    public Response doNext(Chain chain) throws IOException {

        // 拼接请求头之 请求集
        ChainManager manager = (ChainManager) chain; // chain ChainManager
        Request request = manager.getRequest();

        Map<String, String> mHeaderList = request.getmHeaderList();

        // get post  hostName    Host: restapi.amap.com
        mHeaderList.put("Host", new SocketRequestServer().getHost(manager.getRequest()));

        if ("POST".equalsIgnoreCase(request.getRequestMethod())) {
            // 请求体   type lang
            /**
             * Content-Length: 48
             * Content-Type: application/x-www-form-urlencoded
             */
            mHeaderList.put("Content-Length", request.getRequestBody().getBody().length()+"");
            mHeaderList.put("Content-Type", RequestBody.TYPE);
        }

        // ChainManager.getResponse(更新后的Request)
        return chain.getResponse(request); // 执行下一个拦截器（任务节点）
    }
}
