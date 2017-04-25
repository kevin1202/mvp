package com.lofty.longan.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initFresco();
    }

    private void initFresco() {
        Fresco.initialize(this);
    }

    public static Context getAppContext() {
        return app;
    }
}