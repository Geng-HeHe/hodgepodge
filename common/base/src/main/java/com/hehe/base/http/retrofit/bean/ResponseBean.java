package com.hehe.base.http.retrofit.bean;

import android.text.TextUtils;

/**
 * 后台返回数据错误信息类
 */
public class ResponseBean {
    public boolean success = false;
    public Error error;
    public static class Error{
        public String code;
        public String message;
    }


}
