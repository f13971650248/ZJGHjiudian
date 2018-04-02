package com.fc.hft.zjghjiudian.ui.order;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.entiy.Order;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2018/3/15/015.
 */

public class WeiAdapter extends BaseQuickAdapter<Order.DataBean, BaseViewHolder> {

    public WeiAdapter(@Nullable List<Order.DataBean> data) {
        super(R.layout.wei_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Order.DataBean item) {
        if (item.getOrderStatus() == 2) {
            helper.setText(R.id.tv_flag, "未处理");
        }
        if (item.getOrderStatus() == 4) {
            helper.setText(R.id.tv_flag, "已完成");
            helper.setBackgroundRes(R.id.tv_flag, R.drawable.bg_circle);
        }
        Long time = (long) item.getOrderCreateTime() * 1000;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // holder.tvTime.setText(format2.format(time));
        // holder.tvIds.setText(format1.format(time)+userOrder.getOrderId());
        helper.setText(R.id.tv_order_number, format1.format(time) + item.getOrderId() + "");
        helper.setText(R.id.tv_name, item.getAddressName() + "");
        helper.setText(R.id.tv_time, format2.format(time));
        //处理orderCartList数据
//
//        String orderCartList= item.getOrderCartList();
//        String o=orderCartList.replace("\\", "");
//        Log.i(TAG, "convert1: "+o);
//        String a = o.substring(2,3);
//        Log.i(TAG, "convert2: "+a);
//        String b=o.substring(6,o.length()-2);
//        Log.i(TAG, "convert3: "+b);
//        Gson gson  = new Gson();
//        OrderCartList orderCartList1=gson.fromJson(b,OrderCartList.class);
////        Log.i(TAG, "convert: "+orderCartList1.toString());
//        List<OrderCartList>  orderCartLists  = new ArrayList<>();
//      //  orderCartLists.add();

    }
}
