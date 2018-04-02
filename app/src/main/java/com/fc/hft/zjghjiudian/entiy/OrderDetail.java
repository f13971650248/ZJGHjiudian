package com.fc.hft.zjghjiudian.entiy;

/**
 * Created by Administrator on 2018/3/17/017.
 */

public class OrderDetail extends BaseData {

    /**
     * code : 200
     * data : {"addressArea":null,"addressCity":null,"addressDetailed":null,"addressMobile":"123","addressName":"xuchao11vbvvbv","addressProvince":null,"backAmount":0,"bizId":1,"couponCash":0,"couponDiscount":0,"couponId":0,"couponTotalAmount":680,"integralConsumption":0,"integralMoney":0,"isBackup":0,"isCommit":0,"messageNotice":0,"orderCartList":"{\"2\":[{\"ProductsName\":\"豪华大床房\",\"ImgPath\":\"/uploadfiles/biz/1/image/5aa0994387.jpg\",\"ProductsPriceX\":\"680.00\",\"ProductsWebTotal\":\"34.00\",\"ProductsPriceY\":\"780.00\",\"ProductsWeight\":\"0.00\",\"OwnerID\":\"2\",\"ProductsIsShipping\":0,\"Qty\":\"1\",\"spec_list\":\"\",\"Property\":[]}]}","orderCode":"","orderCreateTime":1520592687,"orderDefautlPaymentMethod":"0","orderId":27,"orderInvoiceInfo":"","orderIsRead":0,"orderIsRecieve":0,"orderIsVirtual":1,"orderNeedInvoice":0,"orderPaymentInfo":null,"orderPaymentMethod":"0","orderRemark":"入住时间：2018-3-9\r\n退房时间：2018-3-10\r\n123","orderShipping":"","orderShippingID":null,"orderStatus":1,"orderTotalPrice":680,"orderType":"shop","ownerId":2,"sign":null,"userId":"2","usersId":"tr3ywykht4"}
     * msg : success
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * addressArea : null
         * addressCity : null
         * addressDetailed : null
         * addressMobile : 123
         * addressName : xuchao11vbvvbv
         * addressProvince : null
         * backAmount : 0
         * bizId : 1
         * couponCash : 0
         * couponDiscount : 0
         * couponId : 0
         * couponTotalAmount : 680
         * integralConsumption : 0
         * integralMoney : 0
         * isBackup : 0
         * isCommit : 0
         * messageNotice : 0
         * orderCartList : {"2":[{"ProductsName":"豪华大床房","ImgPath":"/uploadfiles/biz/1/image/5aa0994387.jpg","ProductsPriceX":"680.00","ProductsWebTotal":"34.00","ProductsPriceY":"780.00","ProductsWeight":"0.00","OwnerID":"2","ProductsIsShipping":0,"Qty":"1","spec_list":"","Property":[]}]}
         * orderCode :
         * orderCreateTime : 1520592687
         * orderDefautlPaymentMethod : 0
         * orderId : 27
         * orderInvoiceInfo :
         * orderIsRead : 0
         * orderIsRecieve : 0
         * orderIsVirtual : 1
         * orderNeedInvoice : 0
         * orderPaymentInfo : null
         * orderPaymentMethod : 0
         * orderRemark : 入住时间：2018-3-9
         退房时间：2018-3-10
         123
         * orderShipping :
         * orderShippingID : null
         * orderStatus : 1
         * orderTotalPrice : 680
         * orderType : shop
         * ownerId : 2
         * sign : null
         * userId : 2
         * usersId : tr3ywykht4
         */

        private Object addressArea;
        private Object addressCity;
        private Object addressDetailed;
        private String addressMobile;
        private String addressName;
        private Object addressProvince;
        private int backAmount;
        private int bizId;
        private int couponCash;
        private int couponDiscount;
        private int couponId;
        private int couponTotalAmount;
        private int integralConsumption;
        private int integralMoney;
        private int isBackup;
        private int isCommit;
        private int messageNotice;
        private String orderCartList;
        private String orderCode;
        private int orderCreateTime;
        private String orderDefautlPaymentMethod;
        private int orderId;
        private String orderInvoiceInfo;
        private int orderIsRead;
        private int orderIsRecieve;
        private int orderIsVirtual;
        private int orderNeedInvoice;
        private Object orderPaymentInfo;
        private String orderPaymentMethod;
        private String orderRemark;
        private String orderShipping;
        private Object orderShippingID;
        private int orderStatus;
        private int orderTotalPrice;
        private String orderType;
        private int ownerId;
        private Object sign;
        private String userId;
        private String usersId;

        @Override
        public String toString() {
            return "DataBean{" +
                    "addressArea=" + addressArea +
                    ", addressCity=" + addressCity +
                    ", addressDetailed=" + addressDetailed +
                    ", addressMobile='" + addressMobile + '\'' +
                    ", addressName='" + addressName + '\'' +
                    ", addressProvince=" + addressProvince +
                    ", backAmount=" + backAmount +
                    ", bizId=" + bizId +
                    ", couponCash=" + couponCash +
                    ", couponDiscount=" + couponDiscount +
                    ", couponId=" + couponId +
                    ", couponTotalAmount=" + couponTotalAmount +
                    ", integralConsumption=" + integralConsumption +
                    ", integralMoney=" + integralMoney +
                    ", isBackup=" + isBackup +
                    ", isCommit=" + isCommit +
                    ", messageNotice=" + messageNotice +
                    ", orderCartList='" + orderCartList + '\'' +
                    ", orderCode='" + orderCode + '\'' +
                    ", orderCreateTime=" + orderCreateTime +
                    ", orderDefautlPaymentMethod='" + orderDefautlPaymentMethod + '\'' +
                    ", orderId=" + orderId +
                    ", orderInvoiceInfo='" + orderInvoiceInfo + '\'' +
                    ", orderIsRead=" + orderIsRead +
                    ", orderIsRecieve=" + orderIsRecieve +
                    ", orderIsVirtual=" + orderIsVirtual +
                    ", orderNeedInvoice=" + orderNeedInvoice +
                    ", orderPaymentInfo=" + orderPaymentInfo +
                    ", orderPaymentMethod='" + orderPaymentMethod + '\'' +
                    ", orderRemark='" + orderRemark + '\'' +
                    ", orderShipping='" + orderShipping + '\'' +
                    ", orderShippingID=" + orderShippingID +
                    ", orderStatus=" + orderStatus +
                    ", orderTotalPrice=" + orderTotalPrice +
                    ", orderType='" + orderType + '\'' +
                    ", ownerId=" + ownerId +
                    ", sign=" + sign +
                    ", userId='" + userId + '\'' +
                    ", usersId='" + usersId + '\'' +
                    '}';
        }

        public Object getAddressArea() {
            return addressArea;
        }

        public void setAddressArea(Object addressArea) {
            this.addressArea = addressArea;
        }

        public Object getAddressCity() {
            return addressCity;
        }

        public void setAddressCity(Object addressCity) {
            this.addressCity = addressCity;
        }

        public Object getAddressDetailed() {
            return addressDetailed;
        }

        public void setAddressDetailed(Object addressDetailed) {
            this.addressDetailed = addressDetailed;
        }

        public String getAddressMobile() {
            return addressMobile;
        }

        public void setAddressMobile(String addressMobile) {
            this.addressMobile = addressMobile;
        }

        public String getAddressName() {
            return addressName;
        }

        public void setAddressName(String addressName) {
            this.addressName = addressName;
        }

        public Object getAddressProvince() {
            return addressProvince;
        }

        public void setAddressProvince(Object addressProvince) {
            this.addressProvince = addressProvince;
        }

        public int getBackAmount() {
            return backAmount;
        }

        public void setBackAmount(int backAmount) {
            this.backAmount = backAmount;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getCouponCash() {
            return couponCash;
        }

        public void setCouponCash(int couponCash) {
            this.couponCash = couponCash;
        }

        public int getCouponDiscount() {
            return couponDiscount;
        }

        public void setCouponDiscount(int couponDiscount) {
            this.couponDiscount = couponDiscount;
        }

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public int getCouponTotalAmount() {
            return couponTotalAmount;
        }

        public void setCouponTotalAmount(int couponTotalAmount) {
            this.couponTotalAmount = couponTotalAmount;
        }

        public int getIntegralConsumption() {
            return integralConsumption;
        }

        public void setIntegralConsumption(int integralConsumption) {
            this.integralConsumption = integralConsumption;
        }

        public int getIntegralMoney() {
            return integralMoney;
        }

        public void setIntegralMoney(int integralMoney) {
            this.integralMoney = integralMoney;
        }

        public int getIsBackup() {
            return isBackup;
        }

        public void setIsBackup(int isBackup) {
            this.isBackup = isBackup;
        }

        public int getIsCommit() {
            return isCommit;
        }

        public void setIsCommit(int isCommit) {
            this.isCommit = isCommit;
        }

        public int getMessageNotice() {
            return messageNotice;
        }

        public void setMessageNotice(int messageNotice) {
            this.messageNotice = messageNotice;
        }

        public String getOrderCartList() {
            return orderCartList;
        }

        public void setOrderCartList(String orderCartList) {
            this.orderCartList = orderCartList;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public int getOrderCreateTime() {
            return orderCreateTime;
        }

        public void setOrderCreateTime(int orderCreateTime) {
            this.orderCreateTime = orderCreateTime;
        }

        public String getOrderDefautlPaymentMethod() {
            return orderDefautlPaymentMethod;
        }

        public void setOrderDefautlPaymentMethod(String orderDefautlPaymentMethod) {
            this.orderDefautlPaymentMethod = orderDefautlPaymentMethod;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getOrderInvoiceInfo() {
            return orderInvoiceInfo;
        }

        public void setOrderInvoiceInfo(String orderInvoiceInfo) {
            this.orderInvoiceInfo = orderInvoiceInfo;
        }

        public int getOrderIsRead() {
            return orderIsRead;
        }

        public void setOrderIsRead(int orderIsRead) {
            this.orderIsRead = orderIsRead;
        }

        public int getOrderIsRecieve() {
            return orderIsRecieve;
        }

        public void setOrderIsRecieve(int orderIsRecieve) {
            this.orderIsRecieve = orderIsRecieve;
        }

        public int getOrderIsVirtual() {
            return orderIsVirtual;
        }

        public void setOrderIsVirtual(int orderIsVirtual) {
            this.orderIsVirtual = orderIsVirtual;
        }

        public int getOrderNeedInvoice() {
            return orderNeedInvoice;
        }

        public void setOrderNeedInvoice(int orderNeedInvoice) {
            this.orderNeedInvoice = orderNeedInvoice;
        }

        public Object getOrderPaymentInfo() {
            return orderPaymentInfo;
        }

        public void setOrderPaymentInfo(Object orderPaymentInfo) {
            this.orderPaymentInfo = orderPaymentInfo;
        }

        public String getOrderPaymentMethod() {
            return orderPaymentMethod;
        }

        public void setOrderPaymentMethod(String orderPaymentMethod) {
            this.orderPaymentMethod = orderPaymentMethod;
        }

        public String getOrderRemark() {
            return orderRemark;
        }

        public void setOrderRemark(String orderRemark) {
            this.orderRemark = orderRemark;
        }

        public String getOrderShipping() {
            return orderShipping;
        }

        public void setOrderShipping(String orderShipping) {
            this.orderShipping = orderShipping;
        }

        public Object getOrderShippingID() {
            return orderShippingID;
        }

        public void setOrderShippingID(Object orderShippingID) {
            this.orderShippingID = orderShippingID;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public int getOrderTotalPrice() {
            return orderTotalPrice;
        }

        public void setOrderTotalPrice(int orderTotalPrice) {
            this.orderTotalPrice = orderTotalPrice;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }

        public Object getSign() {
            return sign;
        }

        public void setSign(Object sign) {
            this.sign = sign;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
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
