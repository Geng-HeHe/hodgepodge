package com.hehe.base.http.okhttp;

import java.util.HashMap;
import java.util.Map;

public class Request {
    public static final String GET = "GET";
    public static final String POST = "POST";

    private String url;
    private String requestMethod = GET; // 默认请求下是GET
    private Map<String, String> mHeaderList = new HashMap<>(); // 请求头 之请求集合
    private RequestBody requestBody;
    public String getUrl() {
        return url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public Map<String, String> getmHeaderList() {
        return mHeaderList;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public Request() {
        this(new Request.Builder());
    }

    public Request(Request.Builder builder) {
        this.url = builder.url;
        this.requestMethod = builder.requestMethod;
        this.mHeaderList = builder.mHeaderList;
        this.requestBody = builder.requestBody;
    }

    public final static class Builder {

        private String url;
        private String requestMethod = GET; // 默认请求下是GET
        private Map<String, String> mHeaderList = new HashMap<>();
        private RequestBody requestBody;

        public Request.Builder url(String url) {
            this.url = url;
            return this;
        }

        public Request.Builder get() {
            requestMethod = GET;
            return this;
        }

        public Request.Builder post(RequestBody requestBody) {
            requestMethod = POST;
            this.requestBody = requestBody;
            return this;
        }

        /**
         * Connection: keep-alive
         * Host: restapi.amap.com
         * @return
         */
        public Request.Builder addRequestHeader(String key, String value) {
            mHeaderList.put(key, value);
            return this;
        }

        public Request build() {
            return new Request(this);
        }

    }
}
