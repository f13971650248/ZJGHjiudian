package com.fc.hft.zjghjiudian.ui.my;


import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fc.hft.zjghjiudian.LoginActivity;
import com.fc.hft.zjghjiudian.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;


/**
 * Created by Administrator on 2018/3/6/006.
 */

public class MyFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.iv_showlogo)
    ImageView ivShowlogo;
    @BindView(R.id.tv_shopname)
    TextView tvShopname;
    @BindView(R.id.tv_myaddress)
    TextView tvMyaddress;
    @BindView(R.id.layout_shop_info)
    LinearLayout layoutShopInfo;
    @BindView(R.id.layout_my_shop)
    LinearLayout layoutMyShop;
    @BindView(R.id.layout_myhome_advice)
    LinearLayout layoutMyhomeAdvice;
    @BindView(R.id.iv_forgetpwd)
    ImageView ivForgetpwd;
    @BindView(R.id.layout_update_pwd)
    LinearLayout layoutUpdatePwd;
    @BindView(R.id.iv_version)
    ImageView ivVersion;
    @BindView(R.id.layout_myhome_about)
    LinearLayout layoutMyhomeAbout;
    @BindView(R.id.layout_myhome_set)
    LinearLayout layoutMyhomeSet;
    @BindView(R.id.btn_back)
    Button btnBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myhome, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }


    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        BmobUser.logOut();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);

    }
}
