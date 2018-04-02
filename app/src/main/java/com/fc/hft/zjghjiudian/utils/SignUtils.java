package com.fc.hft.zjghjiudian.utils;


import java.util.HashMap;
import java.util.Map;



/**
 * Created by Administrator on 2018/3/14/014.
 * 	account：登录账户
 password：密码
 registrationID：极光注册id
 sign：签名
 */

public class SignUtils {
    private final static String SIGN_KEY = "Rkj3EKYXZ76w6WzvF8AGa7QvJUQ35K3n";
    String account ="13988888888";
    String passWord ="123456";
    String registID = "120c83f7602f4c5fc8b";
    String signKey = "Rkj3EKYXZ76w6WzvF8AGa7QvJUQ35K3n";
    public static String getSign(String Signkey){
        Map<String,String> map = new HashMap<>();
        map.put("account","13988888888");
        map.put("passWord","123456");
        map.put("registID","120c83f7602f4c5fc8b");
             return Signkey;
    }


    }












