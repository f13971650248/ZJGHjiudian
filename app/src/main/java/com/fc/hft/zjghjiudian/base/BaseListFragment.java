package com.fc.hft.zjghjiudian.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fc.hft.zjghjiudian.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/25.
 */
public abstract class BaseListFragment extends BaseFragment {

    @BindView(R.id.base_list_rv)
    public RecyclerView mBaseListRv;
    @BindView(R.id.smartRefreshLayout)
    public SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.error_no_publish)
    ImageView mErrorNoPublish;
    @BindView(R.id.error_internet)
    ImageView mErrorInternet;
    @BindView(R.id.error_message)
    ImageView mErrorMessage;
    @BindView(R.id.error_noOrder)
    ImageView errorNoOrder;
    Unbinder unbinder1;
    @BindView(R.id.error_noFocus)
    ImageView errorNoFocus;
    @BindView(R.id.error_normal)
    TextView mErrorNormal;
    private ArrayList<ImageView> mErrorImages;


    @Override
    public void initView() {
        mErrorImages = new ArrayList<>();
        mErrorImages.add(mErrorNoPublish);
        mErrorImages.add(mErrorInternet);
        mErrorImages.add(mErrorMessage);
        mErrorImages.add(errorNoOrder);
        mErrorImages.add(errorNoFocus);
        setListAdapter(mBaseListRv);
    }

    public abstract void setListAdapter(RecyclerView baseListRv);


    @Override
    public View getInflaterView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_base_list, null, false);
    }

    @Override
    public void initEvent() {
        super.initEvent();
    }

    @Override
    public void initData() {
        super.initData();
    }

    public void setErrorNoPublish() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.GONE);
        }
        controlErrorView(0);
    }

    public void setErrorInternet() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.GONE);
        }
        controlErrorView(1);
    }

    public void setErrorMessage() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.GONE);
        }
        controlErrorView(2);
    }


    public void setErrorNoOreder() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.GONE);
        }
        controlErrorView(3);
    }

    public void setNoFocus() {
        if (mBaseListRv != null) {
            mBaseListRv.setVisibility(View.GONE);
        }
        controlErrorView(4);
    }

    public void setNormalError(String tv) {
        if (mErrorNormal != null) {
            mErrorNormal.setText(tv);
            mErrorNormal.setVisibility(View.VISIBLE);
        }
    }

    public void setShowBaseRv() {
        for (int i = 0; i < mErrorImages.size(); i++) {
            if (mErrorImages.get(i) != null)
                mErrorImages.get(i).setVisibility(View.GONE);
            if (mBaseListRv != null)
                mBaseListRv.setVisibility(View.VISIBLE);

        }
    }


    private void controlErrorView(int poistion) {
        for (int i = 0; i < mErrorImages.size(); i++) {
            if (i == poistion) {
                if (mErrorImages.get(i) != null) {
                    mErrorImages.get(i).setVisibility(View.VISIBLE);
                }
            } else {
                if (mErrorImages.get(i) != null) {
                    mErrorImages.get(i).setVisibility(View.GONE);
                }
            }

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder1 != null) {
            unbinder1.unbind();
        }
    }

}
