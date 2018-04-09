package com.fc.hft.zjghjiudian.data;

import android.util.Log;

import com.fc.hft.zjghjiudian.api.Api;
import com.fc.hft.zjghjiudian.entiy.BaseData;
import com.fc.hft.zjghjiudian.entiy.Cancle;
import com.fc.hft.zjghjiudian.entiy.Order;
import com.fc.hft.zjghjiudian.utils.SignUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/3/17/017.
 */

public class CancleData extends BaseData {
/*
    public interface CancleListener{
        void cancleOrder(Cancle cancle);
    }
    public static void initCancle(final CancleListener cancleListener ){
        Map<String, String> map = new HashMap<>();
        map.put("backId", "11");
        map.put("orderId", "91");
        map.put("backAmount", "360.00");

        Call<Cancle> call = Api.apiService.cancle("11","91","360.00"
                , SignUtil.getSign(map));
        call.enqueue(new Callback<Cancle>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Cancle> call, Response<Cancle> response) {
                Log.i("TAG","+++++++++++cancle");
                Log.i("TAG", "success: " + response.code());
                Log.i("TAG", "onResponse: " + response.body());
                Gson g = new Gson();
                String s = response.body().toString();
                // cleanErrorCode(s);
                Cancle cancle = g.fromJson(s,Cancle.class);
                if (cancleListener != null && cancle != null) {
                    //接口回调
                    cancleListener.cancleOrder(cancle);
                }
            }
            //请求失败时回调
            @Override
            public void onFailure(Call<Cancle> call, Throwable t) {
                Log.i("TAG", "onFailure: " + "请求失败cancle");
                Log.i("TAG", "onFailure: " + t.getMessage());

            }
        });


    }*/

}
