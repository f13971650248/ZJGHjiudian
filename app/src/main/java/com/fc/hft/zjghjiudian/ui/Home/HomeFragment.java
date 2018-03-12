package com.fc.hft.zjghjiudian.ui.Home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.entiy.JiuDian;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/6/006.
 */

public class HomeFragment extends Fragment {


    @BindView(R.id.lv_house)
    RecyclerView lvHouse;
    @BindView(R.id.srl_house)
    SwipeRefreshLayout srlHouse;
    Unbinder unbinder;
    private List<JiuDian> list = new ArrayList<>();
    private HomeAdapter homeAdapter;
    //新闻页码 最大为10
    private int pageNumber = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        initJiuDian();
        initUI();
        return view;
    }

    private void initJiuDian() {
        for (int i =0;i<10;i++){
            JiuDian jd = new JiuDian(R.drawable.ic_launcher_background,"大床房","998元","已入住 2000次","剩20间");
            list.add(jd);
        }

    }

    private void initUI() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        lvHouse.setLayoutManager(manager);
        homeAdapter = new HomeAdapter(R.layout.home_item_layout,list);
        lvHouse.setAdapter(homeAdapter);
        //默认下拉刷新
     /*   srlHouse.setColorSchemeColors(Color.parseColor("#000000"));
        srlHouse.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //加载数据
                if (pageNumber<=4){
                    pageNumber++;
                    //获取新闻资讯数据
                    list.add(HomeFragment.this, pageNumber);
                    //停止更新
                    srlHouse.setRefreshing(false);
                }else {
                    //最多加载5页
                    Toast.makeText(getActivity(), "无法加载更多数据", Toast.LENGTH_SHORT).show();
                    //停止更新
                    srlHouse.setRefreshing(false);
                }

            }
        });*/
     /*   homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intentNew = new Intent(getActivity(), DetailNewsActivity.class);
//                        Log.d("00000000000ppppp",comingSoons.get(position).getId()+"");
                intentNew.putExtra("NewsId",list.get(position).getAId()+"");
                startActivity(intentNew);
            }
        });*/
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }
}
