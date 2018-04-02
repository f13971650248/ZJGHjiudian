package com.fc.hft.zjghjiudian.api;

import com.fc.hft.zjghjiudian.kit.util.ResutFormatJsonUtils;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * api
 */

public class Api {

    //public static final String BASE_URL = "http://192.168.5.122:8080/hotel-app/";
    public static final String BASE_URL = "http://47.104.67.175:8080/hotel-app/";
    //http://47.104.67.175:8080/hotel-app/

    // 图片加载地址
    public static final String IMAGE_URL = "http://test.hotels.huift.com.cn";


    public static Retrofit retrofit;
    public static ApiService apiService;
    public static final int DEFAULT_TIMEOUT = 30;
    public static final boolean DEBUG = Boolean.parseBoolean("true");

    static {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.retryOnConnectionFailure(true);
        httpClientBuilder.addNetworkInterceptor(new HttpInterceptor());

        if (DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addNetworkInterceptor(logging);
        }
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())// 设置数据解析器
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava平台
                .baseUrl(BASE_URL)// 设置网络请求的Url地址
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private static class HttpLogger implements HttpLoggingInterceptor.Logger {
        private StringBuilder mMessage = new StringBuilder();

        @Override
        public void log(String message) {
            // 请求或者响应开始
            if (message.startsWith("--> POST")) {
                mMessage.setLength(0);
            }
            // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
            if ((message.startsWith("{") && message.endsWith("}"))
                    || (message.startsWith("[") && message.endsWith("]"))) {
                message = ResutFormatJsonUtils.formatJson(message);
            }
            mMessage.append(message.concat("\n"));
            // 请求或者响应结束，打印整条日志
            if (message.startsWith("<-- END HTTP")) {
                Logger.d(mMessage.toString());
            }
        }
    }
}
