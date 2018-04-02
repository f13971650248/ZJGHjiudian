package com.fc.hft.zjghjiudian.ui.order;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class OrderPageAdapter extends FragmentPagerAdapter {
    private String[] titles = { "未处理", "已完成"};
    private List<Fragment> mFragments;

    public OrderPageAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
