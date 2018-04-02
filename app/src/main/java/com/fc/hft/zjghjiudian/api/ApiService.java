package com.fc.hft.zjghjiudian.api;

import com.fc.hft.zjghjiudian.entiy.Account;
import com.fc.hft.zjghjiudian.entiy.BackOrder;
import com.fc.hft.zjghjiudian.entiy.Cancle;
import com.fc.hft.zjghjiudian.entiy.CancleOrderDetail;
import com.fc.hft.zjghjiudian.entiy.CheckOrder;
import com.fc.hft.zjghjiudian.entiy.Order;
import com.fc.hft.zjghjiudian.entiy.OrderDetail;
import com.fc.hft.zjghjiudian.entiy.OrderUpdate;
import com.fc.hft.zjghjiudian.entiy.Room;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 封装接口
 */

public interface ApiService {

    /**
     * 登录
     *
     * @param account        登录账户
     * @param password       密码
     * @param registrationID 极光注册id
     * @param sign           签名
     * @return 用户信息
     */
//    @POST("shop/biz/get")
//    Call<Account> login(@Query("account") String account,
//                        @Query("password") String password,
//                        @Query("registrationID") String registrationID,
//                        @Query("sign") String sign
//    );

    /**
     * 房间列表
     * @param bizId
     * @param currentPage
     * @param numPerPage
     * @param sign
     * @return
     */

    @POST("shop/products/get")
    Call<Room> getRoomList(@Query("bizId") String bizId,
                           @Query("currentPage") String currentPage,
                           @Query("numPerPage") String numPerPage,
                           @Query("sign") String sign
    );

    /**
     * 订单列表
     * @param bizId
     * @param status
     * @param currentPage
     * @param numPerPage
     * @param sign
     * @return
     */
    @GET("user/order/get")
    Call<Order> getOrderList(@Query("bizId") String bizId,
                             @Query("status") String status,
                             @Query("currentPage") String currentPage,
                             @Query("numPerPage") String numPerPage,
                             @Query("sign") String sign
                             );

    /**
     * 订单处理
     * @param orderId
     * @param status
     * @param sign
     * @return
     */
    @POST("user/order/update")
    Call<OrderUpdate> orederUpdate(@Query("orderId") String orderId,
                                  @Query("status") String status,
                                  @Query("sign") String sign
    );

    /**
     * 取消订单
     * @param backId
     * @param orderId
     * @param backAmount
     * @param sign
     * @return
     */
    @POST("user/backorder/cancel")
    Call<Cancle> cancle(@Query("backId") String backId,
                        @Query("orderId") String orderId,
                        @Query("backAmount") String backAmount,
                        @Query("sign") String sign

    );

    /**
     * 确认订单并锁房
     * @param orderId
     * @param extras
     * @param sign
     * @return
     */
    @POST("user/order/checkOrder")
    Call<CheckOrder> checkOrder(@Query("orderId") String orderId,
                            @Query("extras") String extras,
                            @Query("sign") String sign

    );

    /**
     * 退货列表
     * @param bizId
     * @param status
     * @param currentPage
     * @param numPerPage
     * @param sign
     * @return
     */
    @GET("user/backorder/get")
    Call<BackOrder> getBackList(@Query("bizId") String bizId,
                           @Query("status") String status,
                           @Query("currentPage") String currentPage,
                           @Query("numPerPage") String numPerPage,
                           @Query("sign") String sign
    );

    /**
     * 订单详情
     * @param orderId
     * @param sign
     * @return
     */
    @GET("user/order/select")
    Call<OrderDetail> getOrderDetail(@Query("orderId") String orderId,
                                     @Query("sign") String sign
    );

    /**
     * 退款详情
     * @param backId
     * @param sign
     * @return
     */
    @GET("user/backorder/select")
    Call<CancleOrderDetail> getCancleOrderDetail(@Query("backId") String backId,
                                           @Query("sign") String sign
    );






}
