package com.fc.hft.zjghjiudian.base;

import android.app.Application;

import com.orhanobut.hawk.Hawk;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by whhft on 2018/3/16.
 */
public class BaseApplication extends Application {
    private static BaseApplication instance;

    // 极光注册id
    public static String registrationID;

    // 全局类
    //public AppUserResult.AppUser appUser;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //极光推送调试模式
        JPushInterface.setDebugMode(true);
        //极光推送初始化
        JPushInterface.init(this);
        Hawk.init(this).build();

        registrationID = JPushInterface.getRegistrationID(this);
    }

    public static BaseApplication getInstance() {
        return instance;
    }

   /* public AppUserResult.AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUserResult.AppUser appUser) {
        this.appUser = appUser;
    }*/

}
