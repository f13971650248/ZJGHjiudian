package com.fc.hft.zjghjiudian.entiy;

/**
 * 用户信息
 */

public class Account  extends  BaseData{


    /**
     * code : 200
     * data : {"areaId":1511,"bizAccount":"13866666666","bizAct":2,"bizAddress":"银川火车站","bizBriefIntroduce":null,"bizContact":"xc","bizCreateTime":1520404005,"bizEmail":"","bizHomepage":"","bizId":1,"bizImgPath":"/uploadfiles/tr3ywykht4/image/5a9f86086d.jpg","bizIndex":0,"bizIndexShow":1,"bizIntroduce":"","bizKfcode":null,"bizMaxPrice":680,"bizMinPrice":450,"bizName":"郑州假日酒店","bizPassWord":"e10adc3949ba59abbe56e057f20f883e","bizPhone":"18790081836","bizPreIntroduce":null,"bizPrimaryLat":"38.497981","bizPrimaryLng":"106.181328","bizRecieveAddress":"","bizRecieveArea":0,"bizRecieveCity":0,"bizRecieveMobile":"","bizRecieveName":"","bizRecieveProvince":0,"bizSmsPhone":"18790081836","bizStatus":0,"categoryId":0,"defaultBusiness":"express","defaultShipping":0,"facilities":",1,2,3,","regionId":0,"registrationID":"1234567890","shipping":null,"sign":null,"skinId":1,"starId":0,"usersId":"tr3ywykht4"}
     * msg : success
     */

    private int code;
    private DataBean data;
    private String msg;

    @Override
    public String toString() {
        return "Account{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

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
         * areaId : 1511
         * bizAccount : 13866666666
         * bizAct : 2
         * bizAddress : 银川火车站
         * bizBriefIntroduce : null
         * bizContact : xc
         * bizCreateTime : 1520404005
         * bizEmail :
         * bizHomepage :
         * bizId : 1
         * bizImgPath : /uploadfiles/tr3ywykht4/image/5a9f86086d.jpg
         * bizIndex : 0
         * bizIndexShow : 1
         * bizIntroduce :
         * bizKfcode : null
         * bizMaxPrice : 680
         * bizMinPrice : 450
         * bizName : 郑州假日酒店
         * bizPassWord : e10adc3949ba59abbe56e057f20f883e
         * bizPhone : 18790081836
         * bizPreIntroduce : null
         * bizPrimaryLat : 38.497981
         * bizPrimaryLng : 106.181328
         * bizRecieveAddress :
         * bizRecieveArea : 0
         * bizRecieveCity : 0
         * bizRecieveMobile :
         * bizRecieveName :
         * bizRecieveProvince : 0
         * bizSmsPhone : 18790081836
         * bizStatus : 0
         * categoryId : 0
         * defaultBusiness : express
         * defaultShipping : 0
         * facilities : ,1,2,3,
         * regionId : 0
         * registrationID : 1234567890
         * shipping : null
         * sign : null
         * skinId : 1
         * starId : 0
         * usersId : tr3ywykht4
         */

        private int areaId;
        private String bizAccount;
        private int bizAct;
        private String bizAddress;
        private Object bizBriefIntroduce;
        private String bizContact;
        private int bizCreateTime;
        private String bizEmail;
        private String bizHomepage;
        private int bizId;
        private String bizImgPath;
        private int bizIndex;
        private int bizIndexShow;
        private String bizIntroduce;
        private Object bizKfcode;
        private int bizMaxPrice;
        private int bizMinPrice;
        private String bizName;
        private String bizPassWord;
        private String bizPhone;
        private Object bizPreIntroduce;
        private String bizPrimaryLat;
        private String bizPrimaryLng;
        private String bizRecieveAddress;
        private int bizRecieveArea;
        private int bizRecieveCity;
        private String bizRecieveMobile;
        private String bizRecieveName;
        private int bizRecieveProvince;
        private String bizSmsPhone;
        private int bizStatus;
        private int categoryId;
        private String defaultBusiness;
        private int defaultShipping;
        private String facilities;
        private int regionId;
        private String registrationID;
        private Object shipping;
        private Object sign;
        private int skinId;
        private int starId;
        private String usersId;

        @Override
        public String toString() {
            return "DataBean{" +
                    "areaId=" + areaId +
                    ", bizAccount='" + bizAccount + '\'' +
                    ", bizAct=" + bizAct +
                    ", bizAddress='" + bizAddress + '\'' +
                    ", bizBriefIntroduce=" + bizBriefIntroduce +
                    ", bizContact='" + bizContact + '\'' +
                    ", bizCreateTime=" + bizCreateTime +
                    ", bizEmail='" + bizEmail + '\'' +
                    ", bizHomepage='" + bizHomepage + '\'' +
                    ", bizId=" + bizId +
                    ", bizImgPath='" + bizImgPath + '\'' +
                    ", bizIndex=" + bizIndex +
                    ", bizIndexShow=" + bizIndexShow +
                    ", bizIntroduce='" + bizIntroduce + '\'' +
                    ", bizKfcode=" + bizKfcode +
                    ", bizMaxPrice=" + bizMaxPrice +
                    ", bizMinPrice=" + bizMinPrice +
                    ", bizName='" + bizName + '\'' +
                    ", bizPassWord='" + bizPassWord + '\'' +
                    ", bizPhone='" + bizPhone + '\'' +
                    ", bizPreIntroduce=" + bizPreIntroduce +
                    ", bizPrimaryLat='" + bizPrimaryLat + '\'' +
                    ", bizPrimaryLng='" + bizPrimaryLng + '\'' +
                    ", bizRecieveAddress='" + bizRecieveAddress + '\'' +
                    ", bizRecieveArea=" + bizRecieveArea +
                    ", bizRecieveCity=" + bizRecieveCity +
                    ", bizRecieveMobile='" + bizRecieveMobile + '\'' +
                    ", bizRecieveName='" + bizRecieveName + '\'' +
                    ", bizRecieveProvince=" + bizRecieveProvince +
                    ", bizSmsPhone='" + bizSmsPhone + '\'' +
                    ", bizStatus=" + bizStatus +
                    ", categoryId=" + categoryId +
                    ", defaultBusiness='" + defaultBusiness + '\'' +
                    ", defaultShipping=" + defaultShipping +
                    ", facilities='" + facilities + '\'' +
                    ", regionId=" + regionId +
                    ", registrationID='" + registrationID + '\'' +
                    ", shipping=" + shipping +
                    ", sign=" + sign +
                    ", skinId=" + skinId +
                    ", starId=" + starId +
                    ", usersId='" + usersId + '\'' +
                    '}';
        }

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public String getBizAccount() {
            return bizAccount;
        }

        public void setBizAccount(String bizAccount) {
            this.bizAccount = bizAccount;
        }

        public int getBizAct() {
            return bizAct;
        }

        public void setBizAct(int bizAct) {
            this.bizAct = bizAct;
        }

        public String getBizAddress() {
            return bizAddress;
        }

        public void setBizAddress(String bizAddress) {
            this.bizAddress = bizAddress;
        }

        public Object getBizBriefIntroduce() {
            return bizBriefIntroduce;
        }

        public void setBizBriefIntroduce(Object bizBriefIntroduce) {
            this.bizBriefIntroduce = bizBriefIntroduce;
        }

        public String getBizContact() {
            return bizContact;
        }

        public void setBizContact(String bizContact) {
            this.bizContact = bizContact;
        }

        public int getBizCreateTime() {
            return bizCreateTime;
        }

        public void setBizCreateTime(int bizCreateTime) {
            this.bizCreateTime = bizCreateTime;
        }

        public String getBizEmail() {
            return bizEmail;
        }

        public void setBizEmail(String bizEmail) {
            this.bizEmail = bizEmail;
        }

        public String getBizHomepage() {
            return bizHomepage;
        }

        public void setBizHomepage(String bizHomepage) {
            this.bizHomepage = bizHomepage;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public String getBizImgPath() {
            return bizImgPath;
        }

        public void setBizImgPath(String bizImgPath) {
            this.bizImgPath = bizImgPath;
        }

        public int getBizIndex() {
            return bizIndex;
        }

        public void setBizIndex(int bizIndex) {
            this.bizIndex = bizIndex;
        }

        public int getBizIndexShow() {
            return bizIndexShow;
        }

        public void setBizIndexShow(int bizIndexShow) {
            this.bizIndexShow = bizIndexShow;
        }

        public String getBizIntroduce() {
            return bizIntroduce;
        }

        public void setBizIntroduce(String bizIntroduce) {
            this.bizIntroduce = bizIntroduce;
        }

        public Object getBizKfcode() {
            return bizKfcode;
        }

        public void setBizKfcode(Object bizKfcode) {
            this.bizKfcode = bizKfcode;
        }

        public int getBizMaxPrice() {
            return bizMaxPrice;
        }

        public void setBizMaxPrice(int bizMaxPrice) {
            this.bizMaxPrice = bizMaxPrice;
        }

        public int getBizMinPrice() {
            return bizMinPrice;
        }

        public void setBizMinPrice(int bizMinPrice) {
            this.bizMinPrice = bizMinPrice;
        }

        public String getBizName() {
            return bizName;
        }

        public void setBizName(String bizName) {
            this.bizName = bizName;
        }

        public String getBizPassWord() {
            return bizPassWord;
        }

        public void setBizPassWord(String bizPassWord) {
            this.bizPassWord = bizPassWord;
        }

        public String getBizPhone() {
            return bizPhone;
        }

        public void setBizPhone(String bizPhone) {
            this.bizPhone = bizPhone;
        }

        public Object getBizPreIntroduce() {
            return bizPreIntroduce;
        }

        public void setBizPreIntroduce(Object bizPreIntroduce) {
            this.bizPreIntroduce = bizPreIntroduce;
        }

        public String getBizPrimaryLat() {
            return bizPrimaryLat;
        }

        public void setBizPrimaryLat(String bizPrimaryLat) {
            this.bizPrimaryLat = bizPrimaryLat;
        }

        public String getBizPrimaryLng() {
            return bizPrimaryLng;
        }

        public void setBizPrimaryLng(String bizPrimaryLng) {
            this.bizPrimaryLng = bizPrimaryLng;
        }

        public String getBizRecieveAddress() {
            return bizRecieveAddress;
        }

        public void setBizRecieveAddress(String bizRecieveAddress) {
            this.bizRecieveAddress = bizRecieveAddress;
        }

        public int getBizRecieveArea() {
            return bizRecieveArea;
        }

        public void setBizRecieveArea(int bizRecieveArea) {
            this.bizRecieveArea = bizRecieveArea;
        }

        public int getBizRecieveCity() {
            return bizRecieveCity;
        }

        public void setBizRecieveCity(int bizRecieveCity) {
            this.bizRecieveCity = bizRecieveCity;
        }

        public String getBizRecieveMobile() {
            return bizRecieveMobile;
        }

        public void setBizRecieveMobile(String bizRecieveMobile) {
            this.bizRecieveMobile = bizRecieveMobile;
        }

        public String getBizRecieveName() {
            return bizRecieveName;
        }

        public void setBizRecieveName(String bizRecieveName) {
            this.bizRecieveName = bizRecieveName;
        }

        public int getBizRecieveProvince() {
            return bizRecieveProvince;
        }

        public void setBizRecieveProvince(int bizRecieveProvince) {
            this.bizRecieveProvince = bizRecieveProvince;
        }

        public String getBizSmsPhone() {
            return bizSmsPhone;
        }

        public void setBizSmsPhone(String bizSmsPhone) {
            this.bizSmsPhone = bizSmsPhone;
        }

        public int getBizStatus() {
            return bizStatus;
        }

        public void setBizStatus(int bizStatus) {
            this.bizStatus = bizStatus;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getDefaultBusiness() {
            return defaultBusiness;
        }

        public void setDefaultBusiness(String defaultBusiness) {
            this.defaultBusiness = defaultBusiness;
        }

        public int getDefaultShipping() {
            return defaultShipping;
        }

        public void setDefaultShipping(int defaultShipping) {
            this.defaultShipping = defaultShipping;
        }

        public String getFacilities() {
            return facilities;
        }

        public void setFacilities(String facilities) {
            this.facilities = facilities;
        }

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public String getRegistrationID() {
            return registrationID;
        }

        public void setRegistrationID(String registrationID) {
            this.registrationID = registrationID;
        }

        public Object getShipping() {
            return shipping;
        }

        public void setShipping(Object shipping) {
            this.shipping = shipping;
        }

        public Object getSign() {
            return sign;
        }

        public void setSign(Object sign) {
            this.sign = sign;
        }

        public int getSkinId() {
            return skinId;
        }

        public void setSkinId(int skinId) {
            this.skinId = skinId;
        }

        public int getStarId() {
            return starId;
        }

        public void setStarId(int starId) {
            this.starId = starId;
        }

        public String getUsersId() {
            return usersId;
        }

        public void setUsersId(String usersId) {
            this.usersId = usersId;
        }
    }
}
