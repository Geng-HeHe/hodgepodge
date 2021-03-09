package com.hehe.hrouter.api;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hehe.hrouter.api.core.Call;

/**
 * Bundle拼接参数管理类
 */
public final class BundleManager {
    private Bundle bundle = new Bundle();
    //底层业务接口
    private Call call;
    //是否回调setResult()
    private boolean isResult;

    Bundle getBundle(){return bundle;}

    Call getCall(){
        return call;
    }

    void setCall(Call call){
        this.call = call;
    }

    boolean isResult(){return isResult;}

    public BundleManager withString(@NonNull String Key, @Nullable String value){
        bundle.putString(Key,value);
        return this;
    }
    public BundleManager withResultString(@NonNull String key, @Nullable String value) {
        bundle.putString(key, value);
        isResult = true;
        return this;
    }
    public BundleManager withBoolean(@NonNull String key, boolean value) {
        bundle.putBoolean(key, value);
        return this;
    }

    public BundleManager withInt(@NonNull String key, int value) {
        bundle.putInt(key, value);
        return this;
    }

    public BundleManager withBundle(@NonNull Bundle bundle) {
        this.bundle = bundle;
        return this;
    }

    public Object navigation(Context context){
        return RouterManager.getInstance().navigation(context, this, -1);
    }

    public Object navigation(Context context, int code){
        return RouterManager.getInstance().navigation(context, this, code);
    }
}
