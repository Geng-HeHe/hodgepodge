package com.hehe.base.http.okhttp;


public class OkHttpClient {
    Dispatcher dispatcher;

    boolean isCanceled;

    int recount;

    public boolean getCanceled() {
        return isCanceled;
    }

    public int getRecount() {
        return recount;
    }

    public OkHttpClient() {
        this(new OkHttpClient.Builder());
    }

    public OkHttpClient(OkHttpClient.Builder builder) {
        dispatcher = builder.dispatcher;
        isCanceled = builder.isCanceled;
        recount = builder.recount;
    }

    public final static class Builder {

        Dispatcher dispatcher;

        boolean isCanceled;

        int recount = 3; // 重试次数

        public Builder() {
            dispatcher = new Dispatcher();
        }

        public OkHttpClient.Builder dispatcher(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        // 用户取消请求
        public OkHttpClient.Builder canceled() {
            isCanceled = true;
            return this;
        }

        public OkHttpClient.Builder setReCount(int recount) {
            this.recount = recount;
            return this;
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

    }

    public Call newCall(Request request) {
        // RealCall
        return new RealCall(this, request);
    }

    public Dispatcher dispatcher() {
        return dispatcher;
    }
}
