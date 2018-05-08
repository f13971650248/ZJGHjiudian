package com.fc.hft.zjghjiudian.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.fc.hft.zjghjiudian.utils.WeiboDialogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/21.
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder mBind;

   // public String uid;
    public boolean isInit = false;
    public boolean isLoad = false;
    private Dialog mDialog;

    private Handler mHandler = new Handler();
    //public String imei;
    public String ver;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getInflaterView(inflater, container);
        mBind = ButterKnife.bind(this, view);
        isInit = true;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // uid = Hawk.get(UserInfoUtils.uid, "0");
        //imei = Hawk.get(UserInfoUtils.imei);
        try {
            ver = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        initView();
        initEvent();
        initData();
    }

    public void initData() {
        if (!isInit) {
            return;
        }
    }

    public abstract void initView();

    public void initEvent() {

    }

    public abstract View getInflaterView(LayoutInflater inflater, ViewGroup container);

    /**
     * 添加标题
     */
    public Fragment setTitle(Fragment fragment, String title) {
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    public void contextIntentActivity(Context context, Class clazz) {
        context.startActivity(new Intent(context, clazz));
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
    public void intentActivity(Class<?> c) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), c);
        startActivity(intent);
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }

        if (mDialog!=null){
            mDialog.dismiss();
        }
    }
}
