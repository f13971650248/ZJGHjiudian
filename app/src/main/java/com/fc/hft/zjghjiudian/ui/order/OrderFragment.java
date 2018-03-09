package com.fc.hft.zjghjiudian.ui.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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
    private List<Fragment> list;
    private String[] titles = {"全部订单", "未处理", "已处理"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_layout,container,false);
        initFragment();
        initView(view);
        return view;
    }

    private void initFragment() {
        list=new ArrayList<>();
        list.add(new AllFragment());
        list.add(new WeiFragment());
        list.add(new YiFragment());
    }

    private void initView(View view) {
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewPager);

        adapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
