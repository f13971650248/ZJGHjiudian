package com.fc.hft.zjghjiudian.entiy;

import java.util.List;

/**
 * Created by Administrator on 2018/3/16/016.
 */

public class BackOrder extends BaseData {

    /**
     * code : 200
     * data : [{"backAmount":360,"backCartId":0,"backCreateTime":"1520925220","backId":11,"backIsCheck":1,"backJson":null,"backQty":0,"backShipping":null,"backShippingId":null,"backSn":"","backStatus":4,"backType":"shop","backUpdateTime":0,"bizId":1,"bizIsRead":0,"buyerIsRead":0,"orderId":91,"productId":2,"sign":null,"userId":2,"usersId":"tr3ywykht4"}]
     * msg : success
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * backAmount : 360
         * backCartId : 0
         * backCreateTime : 1520925220
         * backId : 11
         * backIsCheck : 1
         * backJson : null
         * backQty : 0
         * backShipping : null
         * backShippingId : null
         * backSn :
         * backStatus : 4
         * backType : shop
         * backUpdateTime : 0
         * bizId : 1
         * bizIsRead : 0
         * buyerIsRead : 0
         * orderId : 91
         * productId : 2
         * sign : null
         * userId : 2
         * usersId : tr3ywykht4
         */

        private int backAmount;
        private int backCartId;
        private String backCreateTime;
        private int backId;
        private int backIsCheck;
        private Object backJson;
        private int backQty;
        private Object backShipping;
        private Object backShippingId;
        private String backSn;
        private int backStatus;
        private String backType;
        private int backUpdateTime;
        private int bizId;
        private int bizIsRead;
        private int buyerIsRead;
        private int orderId;
        private int productId;
        private Object sign;
        private int userId;
        private String usersId;

        public int getBackAmount() {
            return backAmount;
        }

        public void setBackAmount(int backAmount) {
            this.backAmount = backAmount;
        }

        public int getBackCartId() {
            return backCartId;
        }

        public void setBackCartId(int backCartId) {
            this.backCartId = backCartId;
        }

        public String getBackCreateTime() {
            return backCreateTime;
        }

        public void setBackCreateTime(String backCreateTime) {
            this.backCreateTime = backCreateTime;
        }

        public int getBackId() {
            return backId;
        }

        public void setBackId(int backId) {
            this.backId = backId;
        }

        public int getBackIsCheck() {
            return backIsCheck;
        }

        public void setBackIsCheck(int backIsCheck) {
            this.backIsCheck = backIsCheck;
        }

        public Object getBackJson() {
            return backJson;
        }

        public void setBackJson(Object backJson) {
            this.backJson = backJson;
        }

        public int getBackQty() {
            return backQty;
        }

        public void setBackQty(int backQty) {
            this.backQty = backQty;
        }

        public Object getBackShipping() {
            return backShipping;
        }

        public void setBackShipping(Object backShipping) {
            this.backShipping = backShipping;
        }

        public Object getBackShippingId() {
            return backShippingId;
        }

        public void setBackShippingId(Object backShippingId) {
            this.backShippingId = backShippingId;
        }

        public String getBackSn() {
            return backSn;
        }

        public void setBackSn(String backSn) {
            this.backSn = backSn;
        }

        public int getBackStatus() {
            return backStatus;
        }

        public void setBackStatus(int backStatus) {
            this.backStatus = backStatus;
        }

        public String getBackType() {
            return backType;
        }

        public void setBackType(String backType) {
            this.backType = backType;
        }

        public int getBackUpdateTime() {
            return backUpdateTime;
        }

        public void setBackUpdateTime(int backUpdateTime) {
            this.backUpdateTime = backUpdateTime;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getBizIsRead() {
            return bizIsRead;
        }

        public void setBizIsRead(int bizIsRead) {
            this.bizIsRead = bizIsRead;
        }

        public int getBuyerIsRead() {
            return buyerIsRead;
        }

        public void setBuyerIsRead(int buyerIsRead) {
            this.buyerIsRead = buyerIsRead;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public Object getSign() {
            return sign;
        }

        public void setSign(Object sign) {
            this.sign = sign;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUsersId() {
            return usersId;
        }

        public void setUsersId(String usersId) {
            this.usersId = usersId;
        }
    }
}
