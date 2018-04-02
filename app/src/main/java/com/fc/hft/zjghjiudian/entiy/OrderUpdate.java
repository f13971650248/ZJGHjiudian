package com.fc.hft.zjghjiudian.entiy;

/**
 * Created by Administrator on 2018/3/15/015.
 */

public class OrderUpdate extends BaseData {


    /**
     * code : 200
     * data : success
     * msg : success
     */

    private int code;
    private String data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
