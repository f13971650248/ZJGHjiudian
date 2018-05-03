package com.fc.hft.zjghjiudian.base;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import com.fc.hft.zjghjiudian.utils.UserInfoUtils;
import com.fc.hft.zjghjiudian.utils.WeiboDialogUtils;
import com.orhanobut.hawk.Hawk;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2017/12/21.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mBind;
    public String ver;
    public String imei;
    //public String uid;
    public String device_type;
    private Dialog mDialog;

    public Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(getContentViewId());
        mBind = ButterKnife.bind(this);


        try {
            ver = getPackageManager().getPackageInfo(getBaseContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        imei = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        device_type = android.os.Build.MODEL;
        //uid = Hawk.get(UserInfoUtils.uid, "0");
        //Hawk.put(UserInfoUtils.imei, imei);
       // Hawk.put(UserInfoUtils.ver, ver);
//        ImmersionBarUtils.setTransparentStatusBar(this, R.color.bt_login, false);

        //umeng
        //UMConfigure.setLogEnabled(true);
        // SDK在统计Fragment时，需要关闭Activity自带的页面统计，
        // 然后在每个页面中重新集成页面统计的代码(包括调用了 onResume 和 onPause 的Activity)。
        //MobclickAgent.openActivityDurationTrack(false);
       // MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_DUM_NORMAL);


        initView();
        initEvent();
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
       // StatService.onResume(this);
        //MobclickAgent.onPageStart(getClass().getName());
        //MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
       // StatService.onPause(this);
        //MobclickAgent.onPageEnd(getClass().getName());
       // MobclickAgent.onPause(this);
    }

    /**
     * 子类返回布局
     */
    public abstract int getContentViewId();

    /**
     * 初始化view
     */
    public abstract void initView();


    /**
     * 初始化事件
     */
    public void initEvent() {

    }

    /**
     * 初始化数据
     */
    public void initData() {

    }

    public void showRefreshDialog(Context context, String msg) {
        if ("".equals(msg)) {
            mDialog = WeiboDialogUtils.createLoadingDialog(context, "加载中...");
        } else {
            mDialog = WeiboDialogUtils.createLoadingDialog(context, msg);
        }
    }

    public void hideRefreshDialog() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                WeiboDialogUtils.closeDialog(mDialog);
            }
        }, 1000);
    }

    /**
     * Activity跳转intent
     */
    public void intentActivity(Context context, Class clazz) {
        startActivity(new Intent(context, clazz));
    }

    /**
     * 添加标题
     */
    public Fragment setTitle(Fragment fragment, String title) {
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
        if(mDialog!=null){
            mDialog.dismiss();
        }
    }
}
