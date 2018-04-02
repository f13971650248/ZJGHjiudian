package com.fc.hft.zjghjiudian.ui.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fc.hft.zjghjiudian.api.Api;
import com.fc.hft.zjghjiudian.base.BaseListFragment;
import com.fc.hft.zjghjiudian.entiy.Order;
import com.fc.hft.zjghjiudian.retorfit.ApiProvider;
import com.fc.hft.zjghjiudian.retorfit.RxTransform;
import com.fc.hft.zjghjiudian.utils.RefreshUtils;
import com.fc.hft.zjghjiudian.utils.SignUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.reactivex.functions.Consumer;
/**
 * Created by Administrator on 2018/3/8/008.
 */

public class WeiFragment extends BaseListFragment {
    //public BaseApplication baseApp;
    private  WeiAdapter weiAdapter;
   // private int position;
   // private  String type;
    private List<Order.DataBean> orderData;
    private int mPage = 1;
    private static int TYPE_REFRESH = 0;
    private static int TYPE_LOADMORE = 1;
    //订单状态
    private int mState;
    private String mKeywords;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle =getArguments();
        mState = bundle.getInt("state");
        mKeywords = bundle.getString("keywords");
    }

    public static WeiFragment newInstance(int state, String keywords) {
        WeiFragment fragment = new WeiFragment();
        Bundle args = new Bundle();
        args.putInt("state", state);
        args.putString("keywords", keywords);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void setListAdapter(RecyclerView baseListRv) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        baseListRv.setLayoutManager(manager);
        weiAdapter = new WeiAdapter(orderData);
        baseListRv.setAdapter(weiAdapter);
    }

    @Override
    public void initEvent() {
        super.initEvent();
        weiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Order.DataBean bean =weiAdapter.getData().get(position);
                //int status =bean.getOrderStatus();
                //int id = bean.getOrderId();
                //点击item 跳转到未处理界面
              OrderDetailActivity.startUserOrderInfoActivity(getActivity(),String.valueOf(bean.getOrderId()));
            }
        });
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initDataFormNet("1",mState+"","1","10",TYPE_REFRESH);
            }
        });

        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                //initBuyListDatas(++mPage + "", TYPE_LOADMORE);
                initDataFormNet("1",mState+"",++mPage+"","10",TYPE_LOADMORE);
            }
        });
    }
    //刷新界面
    private void initlist(){
        initDataFormNet("1",mState+"","1","10",TYPE_REFRESH);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //可以获取当前fragment的位置
        //position = FragmentPagerItem.getPosition(getArguments());
        //type = position + 1 + "";
    }



    @Override
    public void onStart() {
        super.onStart();
        initDataFormNet("1",mState+"","1","10",TYPE_REFRESH);

    }

    @Override
    public void onResume() {
        super.onResume();
        initlist();
        //initDataFormNet("1",mState+"","1","10",TYPE_REFRESH);
    }

    private void initDataFormNet(String bizID, String status , String currentPage, String numPager, final int type) {
        //网络请求
        Map<String, String> map = new HashMap<>();
        map.put("bizId", bizID);
        map.put("status", status);
        map.put("currentPage",currentPage);
        map.put("numPerPage", numPager);
        String sign = SignUtil.getSign(map);
        ApiProvider.getInstance().provider(Api.BASE_URL)
                .getOrderList(bizID, status, currentPage, numPager, sign)
                .compose(RxTransform.<Order>applyIOM())
                .subscribe(new Consumer<Order>() {
                    @Override
                    public void accept(Order order) throws Exception {
                        RefreshUtils.postDelayedRefresh(smartRefreshLayout, 0);
                        RefreshUtils.postDelayedLoadMore(smartRefreshLayout, 0);
                        if (order.getData() == null){
                            if (mPage ==1){
                                setErrorNoOreder();
                            }
                            return;
                        }
                        mBaseListRv.setVisibility(View.VISIBLE);
                        orderData =order.getData();
                        if (type==0){
                            weiAdapter.getData().clear();
                            weiAdapter.addData(orderData);
                            mPage =1;
                        }else if (type ==1){
                            weiAdapter.addData(orderData);
                        }

                        // weiAdapter.addData(orderData);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        setErrorInternet();
                    }
                });

    }
    /*  @BindView(R.id.lv_order)
    RecyclerView lvOrder;
    @BindView(R.id.srl_order)
    SwipeRefreshLayout srlOrder;
    Unbinder unbinder;
    private List<Order.DataBean> orderData;
    private WeiAdapter weiAdapter;
    //订单状态
    private int mState;
    private String mKeywords;
    private int mPage = 1;
    private static int TYPE_REFRESH = 0;
    private static int TYPE_LOADMORE = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle =getArguments();
        mState = bundle.getInt("state");
        mKeywords = bundle.getString("keywords");
    }

    public static WeiFragment newInstance(int state, String keywords) {
        WeiFragment fragment = new WeiFragment();
        Bundle args = new Bundle();
        args.putInt("state", state);
        args.putString("keywords", keywords);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wei_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initDataFormNet(1,0);
        initUI();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void initDataFormNet(String bizID, String status ,String currentPage,String numPager,final int type) {
        //网络请求
        Map<String, String> map = new HashMap<>();
        map.put("bizId", bizID);
        map.put("status", status);
        map.put("currentPage",currentPage);
        map.put("numPerPage", numPager);
        String sign = SignUtil.getSign(map);
        ApiProvider.getInstance().provider(Api.BASE_URL)
                .getOrderList(bizID, status, currentPage, numPager, sign)
                .compose(RxTransform.<Order>applyIOM())
                .subscribe(new Consumer<Order>() {
                    @Override
                    public void accept(Order order) throws Exception {

                        orderData = order.getData();
                        if (refreshType==0){//刷新
                            weiAdapter.getData().clear();
                            weiAdapter.setNewData(orderData);
                            mPage=1;
                        }else if (refreshType ==1){

                        }

                        // weiAdapter.addData(orderData);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });

    }

    private void initUI() {


        Log.i("TAG", "+++++++++++++++++1");
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        lvOrder.setLayoutManager(manager);
        weiAdapter = new WeiAdapter(orderData);
        lvOrder.setAdapter(weiAdapter);
        Log.i("TAG", "+++++++++++++++++2");
        weiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //点击item 跳转到未处理界面
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);

                startActivity(intent);
            }
        });
        //下拉刷新
        srlOrder.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlOrder.setRefreshing(false);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("TAG", "+++++++++++++++++3");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
*/

}
