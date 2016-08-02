package com.ethanco.jpushlib;

import android.app.Application;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * For developer startup JPush SDK
 * <p/>
 * 一般建议在自定义 Application 类里初始化。也可以在主 Activity 里。
 */
public class ExampleApplication extends Application {
    private static final String TAG = "JPush";

    @Override
    public void onCreate() {
        Log.d(TAG, "[ExampleApplication] onCreate");
        super.onCreate();

        initJPush(BuildConfig.DEBUG);
    }

    /**
     * 初始化极光推送
     *
     * @param isDebug 是否是debug模式
     */
    protected void initJPush(boolean isDebug) {
        JPushInterface.setDebugMode(isDebug); //是否开启Debug模式
        JPushInterface.init(this); //初始化极光推送
        if (isDebug) {
            //设置别名 可在极光推送后台指定别名发送
            TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
            String szImei = TelephonyMgr.getDeviceId();
            JPushInterface.setAlias(this, szImei, new TagAliasCallback() {
                @Override
                public void gotResult(int i, String s, Set<String> set) {
                    Log.i(TAG, "Alias:" + s);
                }
            });
        }
    }
}
