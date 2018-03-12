package com.fc.hft.zjghjiudian.ui.Home;


import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.entiy.JiuDian;

import java.util.List;


/**
 * Created by Administrator on 2018/3/8/008.
 */

public class HomeAdapter extends BaseQuickAdapter<JiuDian, BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<JiuDian> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JiuDian item) {
        helper.setImageResource(R.id.iv_house, item.getImageID());
        helper.setText(R.id.tv_type, item.getType());
        helper.setText(R.id.tv_price, item.getPrice());
        helper.setText(R.id.tv_num,item.getRuzhuNum());
        helper.setText(R.id.tv_number,item.getShengNum());

    }
/*    private List<JiuDian> jiuDianList;

    public HomeAdapter(List<JiuDian> list){
        jiuDianList =list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_layout,parent,
                false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JiuDian jd = jiuDianList.get(position);


    }

    @Override
    public int getItemCount() {
        return jiuDianList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView jdImage;
        TextView tvHouse;
        TextView tvPrice;
        TextView tvNumber;
        public ViewHolder(View itemView) {
            super(itemView);
            jdImage =itemView.findViewById(R.id.iv_house);
            tvHouse =itemView.findViewById(R.id.tv_type);
            tvPrice =itemView.findViewById(R.id.tv_price);
            jdImage =itemView.findViewById(R.id.iv_house);
        }
    }*/
}
