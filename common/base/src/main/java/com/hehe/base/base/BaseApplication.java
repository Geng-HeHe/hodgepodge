package com.hehe.base.base;

import android.app.Application;
import android.util.Log;

import com.hehe.base.utils.Cons;


/**
 * 项目父Application
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(Cons.TAG, "common/BaseApplication");
    }
}
