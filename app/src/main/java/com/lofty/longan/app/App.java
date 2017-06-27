package com.lofty.longan.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;

@ReportsCrashes(
        httpMethod = HttpSender.Method.PUT,
        reportType = HttpSender.Type.JSON,
        formUri = "http://47.89.38.207:5984/acra-longan/_design/acra-storage/_update/report",
        formUriBasicAuthLogin = "kevin",
        formUriBasicAuthPassword = "123456"
)

public class App extends Application {

    private static App app;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        ACRA.init(this);
    }

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