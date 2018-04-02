package com.fc.hft.zjghjiudian.ui.my;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.activity.LoginActivity;
import com.fc.hft.zjghjiudian.api.Api;
import com.orhanobut.hawk.Hawk;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Administrator on 2018/3/6/006.
 */

public class MyFragment extends Fragment {


    Unbinder unbinder;
    /* @BindView(R.id.iv_showlogo)
     ImageView ivShowlogo;*/
    @BindView(R.id.tv_shopname)
    TextView tvShopname;
    @BindView(R.id.tv_admin)
    TextView tvAdmin;
    @BindView(R.id.tv_myaddress)
    TextView tvMyaddress;
    @BindView(R.id.layout_shop_info)
    LinearLayout layoutShopInfo;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.iv_order)
    ImageView ivOrder;
    @BindView(R.id.layout_my_shop)
    LinearLayout layoutMyShop;
    @BindView(R.id.tv_adress)
    TextView tvAdress;
    @BindView(R.id.iv_adress)
    ImageView ivAdress;
    @BindView(R.id.layout_myhome_advice)
    LinearLayout layoutMyhomeAdvice;
    @BindView(R.id.iv_about)
    ImageView ivAbout;
    @BindView(R.id.layout_myhome_about)
    LinearLayout layoutMyhomeAbout;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.layout_myhome_set)
    LinearLayout layoutMyhomeSet;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.iv_showlogo)
    CircleImageView ivShowlogo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myhome, container, false);
        unbinder = ButterKnife.bind(this, view);
        Glide.with(getActivity()).load(Api.IMAGE_URL + Hawk.get("imagePath")).error(R.drawable.logn).into(ivShowlogo);
        Log.i("TAG", "++++++++" + Hawk.get("imagePath"));
        tvShopname.setText(Hawk.get("name") + "");
        tvAdmin.setText(Hawk.get("phone") + "");


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }


    @OnClick({R.id.iv_order, R.id.iv_adress, R.id.iv_about, R.id.iv_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_order:
                break;
            case R.id.iv_adress:
                break;
            case R.id.iv_about:
                break;
            case R.id.iv_setting:
                break;
        }
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
