package com.hehe.hodgepodge.base;


import com.hehe.base.RecordPathManager;
import com.hehe.base.base.BaseApplication;
import com.hehe.hodgepodge.MainActivity;
import com.hehe.modular.helpcenter.HelpCenter_MainActivity;
import com.hehe.modular.tracking.Tracking_MainActivity;

import org.greenrobot.eventbus.EventBus;

public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        RecordPathManager.joinGroup("app", "MainActivity", MainActivity.class);
        RecordPathManager.joinGroup("tracking", "Tracking_MainActivity", Tracking_MainActivity.class);
        RecordPathManager.joinGroup("helpcenter", "HelpCenter_MainActivity", HelpCenter_MainActivity.class);

        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();

    }
}
