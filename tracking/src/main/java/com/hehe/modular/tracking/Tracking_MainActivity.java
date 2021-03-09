package com.hehe.modular.tracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hehe.base.RecordPathManager;
import com.hehe.base.base.BaseActivity;
import com.hehe.base.utils.Cons;
import com.hehe.hrouter.annotation.HRouter;
import com.hehe.hrouter.annotation.Parameter;
import com.hehe.hrouter.api.ParameterManager;
import com.hehe.hrouter.api.RouterManager;

@HRouter(path = "/tracking/Tracking_MainActivity")
public class Tracking_MainActivity extends BaseActivity {

    @Parameter
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracking_activity_main);

        ParameterManager.getInstance().loadParameter(this);
        Log.e(Cons.TAG, "hehehehehehe   "+name);

    }

    public void jumpApp(View view) {

        RouterManager.getInstance()
                .build("/app/MainActivity")
                .withResultString("call", "I'am comeback!")
                .navigation(this);
    }

    public void jumpHelpCenter(View view) {

        Class<?> targetClass = RecordPathManager.getTargetClass("helpcenter", "HelpCenter_MainActivity");

        if (targetClass == null) {
            Log.e(Cons.TAG, "获取跳转targetClass失败！");
            return;
        }

        Intent intent = new Intent(this, targetClass);
        intent.putExtra("name", "hehe");
        startActivity(intent);
    }
}
