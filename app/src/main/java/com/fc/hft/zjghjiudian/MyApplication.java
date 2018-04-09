package com.fc.hft.zjghjiudian;

import android.app.Application;
import android.util.Log;
import com.orhanobut.hawk.Hawk;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2018/3/7/007.
 */

public class MyApplication extends Application {
    public static String registrationId;

    @Override
    public void onCreate() {
        super.onCreate();
        //极光推送调试模式
        JPushInterface.setDebugMode(true);
        //极光推送初始化
        JPushInterface.init(this);
        registrationId = JPushInterface.getRegistrationID(this);
        Log.e("1099", "run:--------->registrationId： "+registrationId );
        Hawk.init(this).build();
    }
}
