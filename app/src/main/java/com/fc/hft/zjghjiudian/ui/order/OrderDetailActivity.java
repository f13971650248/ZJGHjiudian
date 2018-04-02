package com.fc.hft.zjghjiudian.ui.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.activity.CheckOrderActivity;
import com.fc.hft.zjghjiudian.activity.MainActivity;
import com.fc.hft.zjghjiudian.api.Api;
import com.fc.hft.zjghjiudian.entiy.Cancle;
import com.fc.hft.zjghjiudian.entiy.OrderDetail;
import com.fc.hft.zjghjiudian.retorfit.ApiProvider;
import com.fc.hft.zjghjiudian.retorfit.RxTransform;
import com.fc.hft.zjghjiudian.utils.SignUtil;
import com.fc.hft.zjghjiudian.utils.ToastUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class OrderDetailActivity extends AppCompatActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_cancle)
    Button btnCancle;
    @BindView(R.id.btn_confir)
    Button btnConfir;
    @BindView(R.id.tv_order_ids)
    TextView tvOrderIds;
    @BindView(R.id.tv_order_total_price)
    TextView tvOrderTotalPrice;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.tv_order_status)
    TextView tvOrderStatus;
    @BindView(R.id.tv_order_user_name)
    TextView tvOrderUserName;
    @BindView(R.id.tv_user_phone)
    TextView tvUserPhone;
    @BindView(R.id.tv_order_remark)
    TextView tvOrderRemark;
    private String cancleData;
    private String orderId;
    // 传递数据
    private int status = -1;
    private List<OrderDetail.DataBean> dataBeans= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wei_detail_item);
        ButterKnife.bind(this);
        orderId =getIntent().getStringExtra("orderId");

    }

    @Override
    protected void onStart() {
        super.onStart();
        getData(orderId);

    }

    private void getData(String orderId) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("orderId", orderId);
        String sign =SignUtil.getSign(map);
        ApiProvider.getInstance().provider(Api.BASE_URL)
                .getOrderDetail(orderId,sign)
                .compose(RxTransform.<OrderDetail>applyIOM())
                .subscribe(new Consumer<OrderDetail>() {
                    @Override
                    public void accept(OrderDetail orderDetail) throws Exception {
                        // 成功获取数据
                        if (200 == orderDetail.getCode()) {
                            OrderDetail.DataBean data = orderDetail.getData();
                            setData(data);
                        } else {
                            ToastUtil.showShort(OrderDetailActivity.this, orderDetail.getMsg());
                        }

                    }

                });
    }
    private void setData(OrderDetail.DataBean data) {
        if(null!=data ){
            Long time = (long)data.getOrderCreateTime() * 1000;
            SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tvOrderIds.setText(format1.format(time)+data.getOrderId());
            tvOrderTotalPrice.setText("￥"+data.getOrderTotalPrice());
            tvOrderTime.setText(format2.format(time));
            if(2== data.getOrderStatus()){
                status = 2;
                tvOrderStatus.setText("待处理");
               // btnCheckOrder.setText("订单处理");
            }else if(3 == data.getOrderStatus()){
                status = 3;
                tvOrderStatus.setText("待消费");
                //btnCheckOrder.setText("确认已消费");
            }else if(4 == data.getOrderStatus()){
                status = 4;
                tvOrderStatus.setText("已消费");
                //btnCheckOrder.setVisibility(View.GONE);
            }
            tvOrderUserName.setText(data.getAddressName());
            tvUserPhone.setText(data.getAddressMobile());
            tvOrderRemark.setText(data.getOrderRemark());
            //etOrderExtra.setText(data.getExtras());
        }
    }

    @OnClick({R.id.iv_back, R.id.btn_cancle, R.id.btn_confir})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

            case R.id.btn_cancle:
                Map<String, String> map = new HashMap<>();
                map.put("backId", "11");
                map.put("orderId", "91");
                map.put("backAmount", "360.00");
                String sign = SignUtil.getSign(map);
                ApiProvider.getInstance().provider(Api.BASE_URL)
                        .cancle("11", "91", "360.00", sign)
                        .compose(RxTransform.<Cancle>applyIOM())
                        .subscribe(new Consumer<Cancle>() {
                            @Override
                            public void accept(Cancle cancle) throws Exception {
                                cancleData = cancle.getData();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                            }
                        });
                Intent intent = new Intent(OrderDetailActivity.this, MainActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_confir:
                Intent intent2 = new Intent(OrderDetailActivity.this, CheckOrderActivity.class);
                startActivity(intent2);

                finish();
        }
    }

    public static void startUserOrderInfoActivity(Context context, String orderId) {
        Intent intent = new Intent();
        intent.setClass(context, OrderDetailActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivity(intent);
    }
}
