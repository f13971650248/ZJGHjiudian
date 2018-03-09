package com.fc.hft.zjghjiudian;

import android.app.Application;
import android.content.Context;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2018/3/7/007.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        Bmob.initialize(this,"60ddbb889ba5307f9ab29d155b116148");
    }
}
