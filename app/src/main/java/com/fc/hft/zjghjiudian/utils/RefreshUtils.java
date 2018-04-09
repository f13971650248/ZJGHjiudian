package com.fc.hft.zjghjiudian.utils;

import android.view.View;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * Created by Administrator on 2018/1/4.
 */

public class RefreshUtils {


    public static void autoRefresh(final SmartRefreshLayout mSmartRefreshLayout) {
        if (mSmartRefreshLayout != null) {
            mSmartRefreshLayout.autoRefresh();
        }
    }

    public static void autoLoadMore(final SmartRefreshLayout mSmartRefreshLayout) {
        if (mSmartRefreshLayout != null) {
            if (!mSmartRefreshLayout.isRefreshing()) {
                mSmartRefreshLayout.autoLoadmore();
            }
        }
    }

    public static void postDelayedRefresh(final SmartRefreshLayout mSmartRefreshLayout, long time) {
        if (mSmartRefreshLayout != null) {
            mSmartRefreshLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSmartRefreshLayout.finishRefresh();
                }
            }, time);
        }
    }

    public static void postDelayedRefresh(final RelativeLayout progressBar, long time) {
        if (progressBar != null) {
            progressBar.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                }
            }, time);
        }
    }

    public static void postDelayedLoadMore(final SmartRefreshLayout mSmartRefreshLayout, long time) {
        if (mSmartRefreshLayout != null && !mSmartRefreshLayout.isRefreshing()) {
            mSmartRefreshLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSmartRefreshLayout.finishLoadmore();
                }
            }, time);
        }
    }
}
