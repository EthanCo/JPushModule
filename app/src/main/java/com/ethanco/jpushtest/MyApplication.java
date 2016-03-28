package com.ethanco.jpushtest;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * @Description Created by EthanCo on 2016/3/28.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        boolean isDebug = BuildConfig.DEBUG;
        //初始化极光推送
        JPushInterface.setDebugMode(isDebug); //是否开启Debug模式
        JPushInterface.init(this);
    }
}
