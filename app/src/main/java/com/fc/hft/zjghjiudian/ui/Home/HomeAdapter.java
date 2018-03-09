package com.fc.hft.zjghjiudian.ui.Home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.entiy.JiuDian;

import java.util.List;

/**
 * Created by Administrator on 2018/3/8/008.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<JiuDian> jiuDianList;

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
    }
}
