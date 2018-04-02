package com.fc.hft.zjghjiudian.ui.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.api.Api;
import com.fc.hft.zjghjiudian.entiy.Room;
import com.fc.hft.zjghjiudian.retorfit.ApiProvider;
import com.fc.hft.zjghjiudian.retorfit.RxTransform;
import com.fc.hft.zjghjiudian.utils.RefreshUtils;
import com.fc.hft.zjghjiudian.utils.SignUtil;
import com.fc.hft.zjghjiudian.utils.StatusBarUtil;
import com.fc.hft.zjghjiudian.utils.ToastUtil;
import com.orhanobut.hawk.Hawk;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/3/6/006.
 */

public class HomeFragment extends Fragment {

    private static int TYPE_REFRESH = 0;
    private static int TYPE_LOADMORE = 1;
    @BindView(R.id.re_view)
    RecyclerView reView;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.no_data)
    LinearLayout linearLayout;
    Unbinder unbinder;
    private int mPage = 1;
    private List<Room.DataBean> dataBeanList;
    private HomeAdapter adapter;
    View mView;
    private Banner banner;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.home_layout, null);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initEvent();
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        reView.setLayoutManager(manager);
        adapter = new HomeAdapter(getContext(),dataBeanList);
        reView.setAdapter(adapter);
        //添加Header
        View header = LayoutInflater.from(getContext()).inflate(R.layout.room_bannner_header, reView, false);
        banner = header.findViewById(R.id.convenientBanner);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(BANNER_ITEMS);
        banner.start();
        adapter.addHeaderView(banner);
        adapter.openLoadAnimation();
        //状态栏透明和间距处理
        StatusBarUtil.immersive(getActivity());
        //StatusBarUtil.setPaddingSmart(this, toolbar);
        StatusBarUtil.setPaddingSmart(getActivity(), reView);
        //StatusBarUtil.setMargin(getActivity(), banner.findViewById(R.id.header));
        //StatusBarUtil.setPaddingSmart(this, findViewById(R.id.blurView));
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setImageResource(((BannerItem) path).pic);
        }
    }

    public static class BannerItem {

        public int pic;
        public String title;

        public BannerItem() {
        }

        public BannerItem(String title, int pic) {
            this.pic = pic;
            this.title = title;
        }
    }

    public static List<BannerItem> BANNER_ITEMS = new ArrayList<BannerItem>() {{
        add(new BannerItem("最后的骑士", R.mipmap.image_movie_header_48621499931969370));
        add(new BannerItem("三生三世十里桃花", R.mipmap.image_movie_header_12981501221820220));
        add(new BannerItem("豆福传", R.mipmap.image_movie_header_12231501221682438));
    }};

    @Override
    public void onStart() {
        super.onStart();
        initData("1", "1", "5", TYPE_REFRESH);
        Log.i("TAG", "++++6+++" + Hawk.get("bizid"));
    }

    @Override
    public void onResume() {
        super.onResume();
        initData("1", "1", "5", TYPE_REFRESH);
    }
    /*  @Override
    public void setListAdapter(RecyclerView baseListRv) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        baseListRv.setLayoutManager(manager);
        adapter = new HomeAdapter(dataBeanList);
        baseListRv.setAdapter(adapter);

    }*/

    // @Override
    public void initEvent() {
        //super.initEvent();
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData("1", "1", "10", TYPE_REFRESH);

            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                initData("1", ++mPage + "", "10", TYPE_LOADMORE);
                Log.i("TAG", "这是第" + ++mPage + "页数据");
            }
        });
    }


    private void initData(String bizID, String currentPage, String numPerPage, final int type) {
        Map<String, String> map = new HashMap<>();
        map.put("bizId", bizID);
        String sign = SignUtil.getSign(map);
        ApiProvider.getInstance().provider(Api.BASE_URL)
                .getRoomList(bizID, currentPage, numPerPage, sign)
                .compose(RxTransform.<Room>applyIOM())
                .subscribe(new Consumer<Room>() {
                    @Override
                    public void accept(Room room) throws Exception {
                        RefreshUtils.postDelayedRefresh(smartRefreshLayout, 0);
                        RefreshUtils.postDelayedLoadMore(smartRefreshLayout, 0);
                        if (room.getData() == null) {
                            if (mPage == 1) {
                                linearLayout.setVisibility(View.VISIBLE);
                                //setErrorNoOreder();
                            }
                            return;
                        }
                        linearLayout.setVisibility(View.GONE);
                        //linearLayout.setVisibility(View.VISIBLE);
                        dataBeanList = room.getData();
                        if (type == 0) {
                            adapter.getData().clear();
                            adapter.addData(dataBeanList);
                            mPage = 1;
                        } else if (type == 1) {
                            adapter.addData(dataBeanList);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //setErrorInternet();
                        ToastUtil.showShort(getContext(), "数据为空");
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        banner.stopAutoPlay();
    }
}


