package com.fc.hft.zjghjiudian.ui.order;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fc.hft.zjghjiudian.R;

/**
 * Created by Administrator on 2018/3/8/008.
 */

public class YiFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.yi_order_layout,container,false);
        return view;
    }
}
