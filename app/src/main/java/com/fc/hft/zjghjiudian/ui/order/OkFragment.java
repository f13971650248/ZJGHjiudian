package com.fc.hft.zjghjiudian.ui.order;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fc.hft.zjghjiudian.R;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2018/3/8/008.
 */

public class OkFragment extends Fragment {
/*    private  String type;
    public static OkFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        OkFragment fragment = new OkFragment();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //type = getArguments().getString(type);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ok_item_layout, container, false);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
