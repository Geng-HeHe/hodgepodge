package com.hehe.hodgepodge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.hehe.base.base.BaseActivity;
import com.hehe.base.tracking.drawable.TrackingDrawable;
import com.hehe.hrouter.annotation.HRouter;
import com.hehe.hrouter.annotation.Parameter;
import com.hehe.hrouter.annotation.model.RouterBean;
import com.hehe.hrouter.api.ParameterManager;
import com.hehe.hrouter.api.RouterManager;
import com.hehe.hrouter.api.core.HRouterLoadPath;
import com.hehe.modular.helpcenter.HelpCenter_MainActivity;
import com.hehe.modular.tracking.Tracking_MainActivity;

import java.util.Map;

@HRouter(path = "/app/MainActivity")
public class MainActivity extends BaseActivity {

    @Parameter(name = "/tracking/getDrawable")
    TrackingDrawable trackingDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.isRelease) {
            Log.e("hehe", "当前为： 集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e("hehe", "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }

        ParameterManager.getInstance().loadParameter(this);
        int drawableId = trackingDrawable.getDrawable();
        ImageView img = findViewById(R.id.img);
        img.setImageResource(drawableId);
    }

    public void jumpTracking(View view) {

        RouterManager.getInstance()
                .build("/tracking/Tracking_MainActivity")
                .withString("name","simon")
                .navigation(this,100);
    }

    public void jumpHelpCenter(View view) {

        RouterManager.getInstance()
                .build("/helpcenter/HelpCenter_MainActivity")
                .withString("username", "baby")
                .navigation(this, 110);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Log.e("hehe", data.getStringExtra("call"));
        }
    }
}