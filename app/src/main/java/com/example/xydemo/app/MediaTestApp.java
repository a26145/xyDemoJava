package com.example.xydemo.app;

import android.content.Context;

import com.danikula.videocache.HttpProxyCacheServer;
import com.example.xydemo.base.BaseApplication;

public class MediaTestApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }
    private HttpProxyCacheServer proxy;

    public static HttpProxyCacheServer getProxy(Context context) {
        MediaTestApp app = (MediaTestApp) context.getApplicationContext();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer(this);
    }
}
