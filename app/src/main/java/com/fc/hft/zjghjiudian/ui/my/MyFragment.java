package com.fc.hft.zjghjiudian.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.fc.hft.zjghjiudian.LoginActivity;
import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.entiy.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2018/3/6/006.
 */

public class MyFragment extends Fragment {
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.btn_back)
    Button btnBack;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_layout, container, false);
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
