package com.hehe.base.http.okhttp.chain;


import com.hehe.base.http.okhttp.Response;

import java.io.IOException;

public interface Interceptor {

    Response doNext(Chain chain) throws IOException;

}
