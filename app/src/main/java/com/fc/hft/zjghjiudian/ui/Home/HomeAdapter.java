package com.fc.hft.zjghjiudian.ui.Home;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.api.Api;
import com.fc.hft.zjghjiudian.entiy.ProductsImage;
import com.fc.hft.zjghjiudian.entiy.Room;
import com.google.gson.Gson;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8/008.
 */
public class HomeAdapter extends BaseQuickAdapter<Room.DataBean, BaseViewHolder> {

    private Context context;

    public HomeAdapter(Context context, @Nullable List<Room.DataBean> data) {
        super(R.layout.item_room, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Room.DataBean item) {

        ProductsImage image = new Gson().fromJson(item.getProductsJSON(), ProductsImage.class);
        if (null != image.getImgPath() && image.getImgPath().size() > 0) {

            Glide.with(mContext).load(Api.IMAGE_URL + image.getImgPath().get(0)).error(R.drawable.logn).into((ImageView) helper.getView(R.id.iv_products));
        }
        helper.setText(R.id.tv_products_name, item.getProductsName());
        helper.setText(R.id.tv_products_PriceX, "￥" + item.getProductsPriceX() + "");
        helper.setText(R.id.tv_products_PriceY, "￥" + item.getProductsPriceY() + "");
        helper.setText(R.id.tv_products_count, String.valueOf(item.getProductsCount()));
        helper.setText(R.id.tv_products_sales, String.valueOf(item.getProductsSales()));
        TextView tvProductsPrices = helper.getView(R.id.tv_products_PriceY);
        //抗锯齿
        tvProductsPrices.getPaint().setAntiAlias(true);
        //中划线
        tvProductsPrices.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

    }

}
