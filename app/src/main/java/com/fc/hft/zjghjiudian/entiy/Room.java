package com.fc.hft.zjghjiudian.entiy;

import java.util.List;

/**
 * 房间信息
 */

public class Room extends  BaseData {


    /**
     * code : 200
     * data : [{"bizId":1,"facilities":",1,2,3,7,","productsBizCategory":1,"productsBizIsHot":1,"productsBizIsNew":1,"productsBizIsRec":1,"productsBriefDescription":null,"productsCategory":"","productsCount":48,"productsCreateTime":1520408356,"productsDescription":"","productsDistributes":"[\"\",\"\",\"\"]","productsId":1,"productsIsAct":1,"productsIsHot":0,"productsIsNew":0,"productsIsRecieve":0,"productsIsRecommend":0,"productsIsShippingFree":0,"productsIsVirtual":1,"productsJSON":"{\"ImgPath\":[\"/uploadfiles/biz/1/image/5a9f9722e6.jpg\"]}","productsName":"高级大床房","productsPeople":2,"productsPriceX":450,"productsPriceY":480,"productsProfit":3,"productsQrcode":"/data/temp/testa8b96cc641931ef4bc0cdfd15de6dd94.png","productsSales":2,"productsSoldOut":0,"productsSquare":42,"productsStatus":1,"productsSupplyPrice":5,"productsType":0,"productsWeight":0,"sign":null,"usersId":"tr3ywykht4"},{"bizId":1,"facilities":",1,2,3,4,6,","productsBizCategory":1,"productsBizIsHot":1,"productsBizIsNew":1,"productsBizIsRec":1,"productsBriefDescription":null,"productsCategory":"","productsCount":25,"productsCreateTime":1520474438,"productsDescription":"","productsDistributes":"[\"\",\"\",\"\"]","productsId":2,"productsIsAct":1,"productsIsHot":0,"productsIsNew":0,"productsIsRecieve":0,"productsIsRecommend":0,"productsIsShippingFree":0,"productsIsVirtual":1,"productsJSON":"{\"ImgPath\":[\"/uploadfiles/biz/1/image/5aa0994387.jpg\"]}","productsName":"豪华大床房","productsPeople":2,"productsPriceX":680,"productsPriceY":780,"productsProfit":5,"productsQrcode":"/data/temp/test8d36b4d63006647f09d4a2b1eb958d06.png","productsSales":5,"productsSoldOut":0,"productsSquare":42,"productsStatus":1,"productsSupplyPrice":5,"productsType":0,"productsWeight":0,"sign":null,"usersId":"tr3ywykht4"}]
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
         * bizId : 1
         * facilities : ,1,2,3,7,
         * productsBizCategory : 1
         * productsBizIsHot : 1
         * productsBizIsNew : 1
         * productsBizIsRec : 1
         * productsBriefDescription : null
         * productsCategory :
         * productsCount : 48
         * productsCreateTime : 1520408356
         * productsDescription :
         * productsDistributes : ["","",""]
         * productsId : 1
         * productsIsAct : 1
         * productsIsHot : 0
         * productsIsNew : 0
         * productsIsRecieve : 0
         * productsIsRecommend : 0
         * productsIsShippingFree : 0
         * productsIsVirtual : 1
         * productsJSON : {"ImgPath":["/uploadfiles/biz/1/image/5a9f9722e6.jpg"]}
         * productsName : 高级大床房
         * productsPeople : 2
         * productsPriceX : 450
         * productsPriceY : 480
         * productsProfit : 3
         * productsQrcode : /data/temp/testa8b96cc641931ef4bc0cdfd15de6dd94.png
         * productsSales : 2
         * productsSoldOut : 0
         * productsSquare : 42
         * productsStatus : 1
         * productsSupplyPrice : 5
         * productsType : 0
         * productsWeight : 0
         * sign : null
         * usersId : tr3ywykht4
         */

        private int bizId;
        private String facilities;
        private int productsBizCategory;
        private int productsBizIsHot;
        private int productsBizIsNew;
        private int productsBizIsRec;
        private Object productsBriefDescription;
        private String productsCategory;
        private int productsCount;
        private int productsCreateTime;
        private String productsDescription;
        private String productsDistributes;
        private int productsId;
        private int productsIsAct;
        private int productsIsHot;
        private int productsIsNew;
        private int productsIsRecieve;
        private int productsIsRecommend;
        private int productsIsShippingFree;
        private int productsIsVirtual;
        private String productsJSON;
        private String productsName;
        private int productsPeople;
        private int productsPriceX;
        private int productsPriceY;
        private int productsProfit;
        private String productsQrcode;
        private int productsSales;
        private int productsSoldOut;
        private int productsSquare;
        private int productsStatus;
        private int productsSupplyPrice;
        private int productsType;
        private int productsWeight;
        private Object sign;
        private String usersId;

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public String getFacilities() {
            return facilities;
        }

        public void setFacilities(String facilities) {
            this.facilities = facilities;
        }

        public int getProductsBizCategory() {
            return productsBizCategory;
        }

        public void setProductsBizCategory(int productsBizCategory) {
            this.productsBizCategory = productsBizCategory;
        }

        public int getProductsBizIsHot() {
            return productsBizIsHot;
        }

        public void setProductsBizIsHot(int productsBizIsHot) {
            this.productsBizIsHot = productsBizIsHot;
        }

        public int getProductsBizIsNew() {
            return productsBizIsNew;
        }

        public void setProductsBizIsNew(int productsBizIsNew) {
            this.productsBizIsNew = productsBizIsNew;
        }

        public int getProductsBizIsRec() {
            return productsBizIsRec;
        }

        public void setProductsBizIsRec(int productsBizIsRec) {
            this.productsBizIsRec = productsBizIsRec;
        }

        public Object getProductsBriefDescription() {
            return productsBriefDescription;
        }

        public void setProductsBriefDescription(Object productsBriefDescription) {
            this.productsBriefDescription = productsBriefDescription;
        }

        public String getProductsCategory() {
            return productsCategory;
        }

        public void setProductsCategory(String productsCategory) {
            this.productsCategory = productsCategory;
        }

        public int getProductsCount() {
            return productsCount;
        }

        public void setProductsCount(int productsCount) {
            this.productsCount = productsCount;
        }

        public int getProductsCreateTime() {
            return productsCreateTime;
        }

        public void setProductsCreateTime(int productsCreateTime) {
            this.productsCreateTime = productsCreateTime;
        }

        public String getProductsDescription() {
            return productsDescription;
        }

        public void setProductsDescription(String productsDescription) {
            this.productsDescription = productsDescription;
        }

        public String getProductsDistributes() {
            return productsDistributes;
        }

        public void setProductsDistributes(String productsDistributes) {
            this.productsDistributes = productsDistributes;
        }

        public int getProductsId() {
            return productsId;
        }

        public void setProductsId(int productsId) {
            this.productsId = productsId;
        }

        public int getProductsIsAct() {
            return productsIsAct;
        }

        public void setProductsIsAct(int productsIsAct) {
            this.productsIsAct = productsIsAct;
        }

        public int getProductsIsHot() {
            return productsIsHot;
        }

        public void setProductsIsHot(int productsIsHot) {
            this.productsIsHot = productsIsHot;
        }

        public int getProductsIsNew() {
            return productsIsNew;
        }

        public void setProductsIsNew(int productsIsNew) {
            this.productsIsNew = productsIsNew;
        }

        public int getProductsIsRecieve() {
            return productsIsRecieve;
        }

        public void setProductsIsRecieve(int productsIsRecieve) {
            this.productsIsRecieve = productsIsRecieve;
        }

        public int getProductsIsRecommend() {
            return productsIsRecommend;
        }

        public void setProductsIsRecommend(int productsIsRecommend) {
            this.productsIsRecommend = productsIsRecommend;
        }

        public int getProductsIsShippingFree() {
            return productsIsShippingFree;
        }

        public void setProductsIsShippingFree(int productsIsShippingFree) {
            this.productsIsShippingFree = productsIsShippingFree;
        }

        public int getProductsIsVirtual() {
            return productsIsVirtual;
        }

        public void setProductsIsVirtual(int productsIsVirtual) {
            this.productsIsVirtual = productsIsVirtual;
        }

        public String getProductsJSON() {
            return productsJSON;
        }

        public void setProductsJSON(String productsJSON) {
            this.productsJSON = productsJSON;
        }

        public String getProductsName() {
            return productsName;
        }

        public void setProductsName(String productsName) {
            this.productsName = productsName;
        }

        public int getProductsPeople() {
            return productsPeople;
        }

        public void setProductsPeople(int productsPeople) {
            this.productsPeople = productsPeople;
        }

        public int getProductsPriceX() {
            return productsPriceX;
        }

        public void setProductsPriceX(int productsPriceX) {
            this.productsPriceX = productsPriceX;
        }

        public int getProductsPriceY() {
            return productsPriceY;
        }

        public void setProductsPriceY(int productsPriceY) {
            this.productsPriceY = productsPriceY;
        }

        public int getProductsProfit() {
            return productsProfit;
        }

        public void setProductsProfit(int productsProfit) {
            this.productsProfit = productsProfit;
        }

        public String getProductsQrcode() {
            return productsQrcode;
        }

        public void setProductsQrcode(String productsQrcode) {
            this.productsQrcode = productsQrcode;
        }

        public int getProductsSales() {
            return productsSales;
        }

        public void setProductsSales(int productsSales) {
            this.productsSales = productsSales;
        }

        public int getProductsSoldOut() {
            return productsSoldOut;
        }

        public void setProductsSoldOut(int productsSoldOut) {
            this.productsSoldOut = productsSoldOut;
        }

        public int getProductsSquare() {
            return productsSquare;
        }

        public void setProductsSquare(int productsSquare) {
            this.productsSquare = productsSquare;
        }

        public int getProductsStatus() {
            return productsStatus;
        }

        public void setProductsStatus(int productsStatus) {
            this.productsStatus = productsStatus;
        }

        public int getProductsSupplyPrice() {
            return productsSupplyPrice;
        }

        public void setProductsSupplyPrice(int productsSupplyPrice) {
            this.productsSupplyPrice = productsSupplyPrice;
        }

        public int getProductsType() {
            return productsType;
        }

        public void setProductsType(int productsType) {
            this.productsType = productsType;
        }

        public int getProductsWeight() {
            return productsWeight;
        }

        public void setProductsWeight(int productsWeight) {
            this.productsWeight = productsWeight;
        }

        public Object getSign() {
            return sign;
        }

        public void setSign(Object sign) {
            this.sign = sign;
        }

        public String getUsersId() {
            return usersId;
        }

        public void setUsersId(String usersId) {
            this.usersId = usersId;
        }
    }
}
