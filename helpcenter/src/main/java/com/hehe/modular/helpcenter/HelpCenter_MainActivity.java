package com.hehe.modular.helpcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hehe.base.RecordPathManager;
import com.hehe.base.base.BaseActivity;
import com.hehe.base.utils.Cons;
import com.hehe.hrouter.annotation.HRouter;

@HRouter(path = "/helpcenter/HelpCenter_MainActivity")
public class HelpCenter_MainActivity extends BaseActivity {

    @Override
    public void initActionBar() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.helpcenter_activity_main;
    }

    @Override
    public void initView() {
        if (getIntent() != null) {
            String content = getIntent().getStringExtra("name");
            Log.e(Cons.TAG, "接收参数值：" + content);
        }
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void processClick(View v) {

    }


    public void jumpApp(View view) {

        Class<?> targetClass = RecordPathManager.getTargetClass("app", "MainActivity");

        if (targetClass == null) {
            Log.e(Cons.TAG, "获取跳转targetClass失败！");
            return;
        }

        Intent intent = new Intent(this, targetClass);
        intent.putExtra("name", "hehe");
        startActivity(intent);
    }

    public void jumpTracking(View view) {

        Class<?> targetClass = RecordPathManager.getTargetClass("tracking", "Tracking_MainActivity");

        if (targetClass == null) {
            Log.e(Cons.TAG, "获取跳转targetClass失败！");
            return;
        }

        Intent intent = new Intent(this, targetClass);
        intent.putExtra("name", "hehe");
        startActivity(intent);
    }
}
