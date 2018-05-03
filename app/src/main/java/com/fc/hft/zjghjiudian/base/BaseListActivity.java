package com.fc.hft.zjghjiudian.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.fc.hft.zjghjiudian.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/12/23.
 */

public abstract class BaseListActivity extends BaseActivity {
    @BindView(R.id.top_iv_back)
    ImageView mTopIvBack;
    @BindView(R.id.top_tv_title)
    public TextView mTopTvTitle;
    @BindView(R.id.base_list_rv)
    RecyclerView mBaseListRv;
    @BindView(R.id.top_iv_right)
    public ImageView topIvRight;//部分activity有标题栏右侧按钮
    @BindView(R.id.smartRefreshLayout)
    public SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.top_tv_right)
    public TextView mTopTvRight;
    @BindView(R.id.error_no_publish)
    ImageView mErrorNoPublish;
    @BindView(R.id.error_internet)
    ImageView mErrorInternet;
    @BindView(R.id.error_message)
    ImageView mErrorMessage;
    @BindView(R.id.error_noOrder)
    ImageView mErrorNoOrder;
    private ArrayList<ImageView> mErrorImgs;

    @Override
    public int getContentViewId() {
        return R.layout.activity_base_list;
    }

    @Override
    public void initView() {
//        ImmersionBarUtils.setTransparentColorStatusBar(this, R.color.normalBgColor);
        mErrorImgs = new ArrayList<>();
        mErrorImgs.add(mErrorNoPublish);
        mErrorImgs.add(mErrorInternet);
        mErrorImgs.add(mErrorMessage);
        mErrorImgs.add(mErrorNoOrder);
        setTitle(mTopTvTitle);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mBaseListRv.setLayoutManager(manager);
        setListAdapter(mBaseListRv);
    }


    @Override
    public void initEvent() {
        super.initEvent();
        setListener();
    }

    /**
     * rv监听
     */
    public void setListener() {

    }

    /**
     * 设置适配器
     */
    public abstract void setListAdapter(RecyclerView baseListRv);


    /**
     * 设置标题
     *
     * @param topTvTitle
     */
//    public void setTitle(String title) {
//        mTopTvTitle.setText(title);
//    }
    public abstract void setTitle(TextView topTvTitle);


    @OnClick(R.id.top_iv_back)
    public void onViewClicked() {
        finish();
    }

    private void setErrorImageShow(int index) {
        for (int i = 0; i < mErrorImgs.size(); i++) {
            if (index == i) {
                if (mErrorImgs.get(index) != null)
                    mErrorImgs.get(index).setVisibility(View.VISIBLE);
            }
//            else if (index == mErrorImgs.size()) {
//                for (int j = 0; j < mErrorImgs.size(); j++) {
//                    if (mErrorImgs.get(j) != null)
//                        mErrorImgs.get(j).setVisibility(View.GONE);
//                }
//            }
            else {
                if (mErrorImgs.get(i) != null)
                    mErrorImgs.get(i).setVisibility(View.GONE);
            }
        }

    }


    public void setErrorNoPublish() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.GONE);
        }
//        mErrorInternet.setVisibility(View.GONE);
//        mErrorNoPublish.setVisibility(View.VISIBLE);
//        mErrorMessage.setVisibility(View.GONE);
//        mErrorNoOrder.setVisibility(View.GONE);
        setErrorImageShow(0);

    }

    public void setErrorInternet() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.GONE);
        }
//        mErrorInternet.setVisibility(View.VISIBLE);
//        mErrorNoPublish.setVisibility(View.GONE);
//        mErrorMessage.setVisibility(View.GONE);
//        mErrorNoOrder.setVisibility(View.GONE);
        setErrorImageShow(1);
    }

    public void setErrorMessage() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.GONE);
        }
//        mErrorInternet.setVisibility(View.GONE);
//        mErrorNoPublish.setVisibility(View.GONE);
//        mErrorMessage.setVisibility(View.VISIBLE);
//        mErrorNoOrder.setVisibility(View.GONE);
        setErrorImageShow(2);
    }

    public void setErrorNoOreder() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.GONE);
        }
//        mErrorInternet.setVisibility(View.GONE);
//        mErrorNoPublish.setVisibility(View.GONE);
//        mErrorMessage.setVisibility(View.GONE);
//        mErrorNoOrder.setVisibility(View.VISIBLE);
        setErrorImageShow(3);
    }

    public void setBaseListRvShow() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.VISIBLE);
        }
//        mErrorInternet.setVisibility(View.GONE);
//        mErrorNoPublish.setVisibility(View.GONE);
//        mErrorMessage.setVisibility(View.GONE);
//        mErrorNoOrder.setVisibility(View.GONE);
        setErrorImageShow(5);

    }

}
