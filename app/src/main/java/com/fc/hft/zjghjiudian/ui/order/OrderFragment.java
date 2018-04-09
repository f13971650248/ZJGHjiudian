package com.fc.hft.zjghjiudian.ui.order;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fc.hft.zjghjiudian.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/6/006.
 */

public class OrderFragment extends Fragment {

    private static final String TAG = "OrderFragment";
    private List<Fragment> list;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    FragmentManager mFm;
    private Fragment mContent;
    //private WeiAdapter weiAdapter;
    // private MyAdapter adapter;
    //private List<Order.DataBean> orderData;

    public static OrderFragment getInstance() {
        OrderFragment orderFragment = new OrderFragment();
        orderFragment.setArguments(new Bundle());
        return orderFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_layout, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabs);
        List<Fragment> fragments = new ArrayList<>();
        //未处理
        fragments.add(WeiFragment.newInstance(2, null));
        //已完成
        fragments.add(WeiFragment.newInstance(4, null));
        OrderPageAdapter adapter = new OrderPageAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


   /* private void initFragment() {
        list=new ArrayList<>();
        list.add(new WeiFragment());
        list.add(new OkFragment());
        list.add(new YiFragment());
    }*/

    @Override
    public void onResume() {
        super.onResume();
        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).select();
    }
}
