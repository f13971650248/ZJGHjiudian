package com.fc.hft.zjghjiudian.retorfit;


import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {


    private static final String TAG = "Retrofit";
    private static ApiProvider instance;
    private OkHttpClient.Builder builder;

    private ApiProvider() {
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i(TAG,message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        builder.readTimeout(8, TimeUnit.SECONDS);
        builder.connectTimeout(8,TimeUnit.SECONDS);
        builder.writeTimeout(8,TimeUnit.SECONDS);
    }
    public static ApiProvider getInstance(){
        if (instance == null) {
            synchronized (ApiProvider.class){
                if (instance == null) {
                    instance=new ApiProvider();
                }
            }
        }
        return instance;
    }

    public ApiService provider(String baseUrl){
        Gson gson = new GsonBuilder()
                //配置Gson
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(ApiService.class);
    }



}
