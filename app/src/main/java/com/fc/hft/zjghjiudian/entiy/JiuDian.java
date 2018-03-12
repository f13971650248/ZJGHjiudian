package com.fc.hft.zjghjiudian.entiy;



/**
 * Created by Administrator on 2018/3/8/008.
 */

public class JiuDian {
    private int imageID;
    private String type;
    private String price;
    private String ruzhuNum;
    private String shengNum;



    public JiuDian(int imageID, String type, String price, String ruzhuNum, String shengNum) {
        this.imageID = imageID;
        this.type = type;
        this.price = price;
        this.ruzhuNum = ruzhuNum;
        this.shengNum = shengNum;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRuzhuNum() {
        return ruzhuNum;
    }

    public void setRuzhuNum(String ruzhuNum) {
        this.ruzhuNum = ruzhuNum;
    }

    public String getShengNum() {
        return shengNum;
    }

    public void setShengNum(String shengNum) {
        this.shengNum = shengNum;
    }
}
