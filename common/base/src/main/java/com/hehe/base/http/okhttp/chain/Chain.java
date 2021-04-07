package com.hehe.base.http.okhttp.chain;


import com.hehe.base.http.okhttp.Request;
import com.hehe.base.http.okhttp.Response;

import java.io.IOException;

public interface Chain {
    Request getRequest();

    Response getResponse(Request request) throws IOException;

}
