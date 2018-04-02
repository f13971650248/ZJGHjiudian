package com.fc.hft.zjghjiudian.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 签名算法工具类
 * @author whhft
 *
 */
public class SignUtil {
	
	// 前后端约定的密钥
	private static final String KEY = "Rkj3EKYXZ76w6WzvF8AGa7QvJUQ35K3n";
	String registID = "120c83f7602f4c5fc8b";

	/**
	 * 方法：把参数进行签名计算
	 * @param paramMap
	 * @return
	 */
	public static String getSign(Map<String, String> paramMap){
		String result = "";
		try {
			String strA = formatUrl(paramMap);
			String stringForSign = strA+"&key="+KEY;
			byte[] bytes = stringForSign.getBytes("UTF-8");
			result = bytesToHexString(MDCoderUtil.encodeMD5(bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 把bytes[] 转化成16进制字符串
	 * @return
	 */
	public static String bytesToHexString(byte[] data){
		StringBuilder strb = new StringBuilder();
		if(data == null || data.length <= 0){
			return null;
		}
		for (int i = 0; i < data.length; i++) {
			int temp = data[i] & 0xFF;
			String hexString = Integer.toHexString(temp);
			if(hexString.length() < 2){
				strb.append(0);
			}
			strb.append(hexString);
		}
		return strb.toString();
	}
	
	/**
	 * 对所有传入参数按照字段名的ASCII 码从小到大排序（字典序）
	 * 
	 * @param paramMap
	 * @return
	 */
	public static String formatUrl(Map<String, String> paramMap) {
		String buff = "";
		List<Entry<String, String>> infoIds = new ArrayList<Entry<String, String>>(
				paramMap.entrySet());
		// 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
		Collections.sort(infoIds, new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1,
					Entry<String, String> o2) {
				return (o1.getKey()).toString().compareTo(o2.getKey());
			}
		});
		// 构造键值对格式
		StringBuilder buf = new StringBuilder();
		for (Entry<String, String> item : infoIds) {
			buf.append(item.getKey() + "=" + item.getValue());
			buf.append("&");
		}
		buff = buf.toString();
		if (!buff.isEmpty()) {
			buff = buff.substring(0, buff.length() - 1);
		}
		return buff;
	}
}
