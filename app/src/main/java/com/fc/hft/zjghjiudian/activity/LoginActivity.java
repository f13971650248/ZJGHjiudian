package com.fc.hft.zjghjiudian.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.api.Api;
import com.fc.hft.zjghjiudian.base.BaseApplication;
import com.fc.hft.zjghjiudian.entiy.Account;
import com.fc.hft.zjghjiudian.entiy.AppUserResult;
import com.fc.hft.zjghjiudian.entiy.BackOrder;
import com.fc.hft.zjghjiudian.entiy.CancleOrderDetail;
import com.fc.hft.zjghjiudian.entiy.CheckOrder;
import com.fc.hft.zjghjiudian.entiy.Order;
import com.fc.hft.zjghjiudian.entiy.OrderDetail;
import com.fc.hft.zjghjiudian.entiy.OrderUpdate;
import com.fc.hft.zjghjiudian.retorfit.ApiProvider;
import com.fc.hft.zjghjiudian.retorfit.RxTransform;
import com.fc.hft.zjghjiudian.utils.SignUtil;
import com.fc.hft.zjghjiudian.utils.ToastUtil;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.SharedPreferences.*;


/**
 * Created by Administrator on 2018/3/7/007.
 */

public class LoginActivity extends AppCompatActivity {
    public BaseApplication baseApp;

    Intent intent;
    Unbinder unbinder;
    @BindView(R.id.iv_shop_card)
    ImageView ivShopCard;
    @BindView(R.id.edt_login_username)
    EditText etUsername;
    @BindView(R.id.edt_login_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_layout);
        unbinder = ButterKnife.bind(this);
        baseApp = (BaseApplication) getApplication();
        restoreInfo();

    }


  /*  private void initBackOrder() {
        Map<String, String> map = new HashMap<>();
        map.put("bizId", "1");
        map.put("status", "4");
        map.put("currentPage", "1");
        map.put("numPerPage", "10");
        Log.i("TAG", "+++++++++++3333");
        Call<BackOrder> call = Api.apiService.getBackList("1", "4", "1", "10"
                , SignUtil.getSign(map));
        call.enqueue(new Callback<BackOrder>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<BackOrder> call, Response<BackOrder> response) {
                Log.i("TAG", "success: +++++++BackOrde");
                Log.i("TAG", "success: " + response.code());
                Log.i("TAG", "onResponse: " + response.body());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<BackOrder> call, Throwable t) {
                Log.i("TAG", "onFailure: " + "请求失败2");
                Log.i("TAG", "onFailure: " + t.getMessage());

            }
        });

    }*/

    /*private void initCheckOrder() {
        Map<String, String> map = new HashMap<>();
        map.put("orderId", "28");
        map.put("status", "123");

        Log.i("TAG", "+++++++++++444");
        Call<CheckOrder> call = Api.apiService.checkOrder("28", "123"
                , SignUtil.getSign(map));
        call.enqueue(new Callback<CheckOrder>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<CheckOrder> call, Response<CheckOrder> response) {
                Log.i("TAG", "+++++++++++CheckOrder");
                Log.i("TAG", "success: " + response.code());
                Log.i("TAG", "onResponse: " + response.body());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<CheckOrder> call, Throwable t) {
                Log.i("TAG", "onFailure: " + "请求失败2");
                Log.i("TAG", "onFailure: " + t.getMessage());

            }
        });
    }*/


   /* private void initUp() {
        Map<String, String> map = new HashMap<>();
        map.put("orderId", "28");
        map.put("status", "1");

        Log.i("TAG", "+++++++++++444");
        Call<OrderUpdate> call = Api.apiService.orederUpdate("28", "1"
                , SignUtil.getSign(map));
        call.enqueue(new Callback<OrderUpdate>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<OrderUpdate> call, Response<OrderUpdate> response) {
                Log.i("TAG", "OrderUpdate+++++++++++66666");
                Log.i("TAG", "success: " + response.code());
                Log.i("TAG", "onResponse: " + response.body());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<OrderUpdate> call, Throwable t) {
                Log.i("TAG", "onFailure: " + "请求失败2");
                Log.i("TAG", "onFailure: " + t.getMessage());

            }
        });

    }*/

   /* private void initData() {
        Log.i("TAG", "+++++++++++2222");
        Map<String, String> map = new HashMap<>();
        map.put("bizId", "1");
        map.put("status", "2");
        map.put("currentPage", "1");
        map.put("numPerPage", "10");
        Log.i("TAG", "+++++++++++3333");
        Call<Order> call = Api.apiService.getOrderList("1", "2", "1", "10"
                , SignUtil.getSign(map));
        call.enqueue(new Callback<Order>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                Log.i("TAG", "success: " + response.code());
                Log.i("TAG", "onResponse: " + response.body());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                Log.i("TAG", "onFailure: " + "请求失败2");
                Log.i("TAG", "onFailure: " + t.getMessage());

            }
        });

    }*/

    private void initLogin(String account, String pass) {
        Log.d("TAG", "1111111111");
        Map<String, String> map = new HashMap<>();
        map.put("account", account);
        map.put("password", pass);
        map.put("registrationID", "120c83f7602f4c5fc8b");
        String sign = SignUtil.getSign(map);
        ApiProvider.getInstance().provider(Api.BASE_URL)
                .login(account, pass, "120c83f7602f4c5fc8b", sign)
                .compose(RxTransform.<Account>applyIOM())
                .subscribe(new Consumer<Account>() {
                    @Override
                    public void accept(Account result) throws Exception {
                        Log.d("TAG", "2222222222" + result.getData());
                        Hawk.put("bizid", result.getData().getBizId());
                        Hawk.put("imagePath", result.getData().getBizImgPath());
                        Log.i("TAG", "555555" + result.getData().getBizImgPath());
                        Hawk.put("name", result.getData().getBizName());
                        Hawk.put("contact", result.getData().getBizContact());
                        Hawk.put("phone", result.getData().getBizPhone());
                        //AppUserResult.AppUser appUser = result.getData();
                        // baseApp.setAppUser(appUser);
                        intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        Log.d("TAG", "3333333");
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        LoginActivity.this.finish();
                        ToastUtil.showShort(LoginActivity.this, result.getMsg());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("TAG", "444444");
                        ToastUtil.showShort(LoginActivity.this, "获取数据失败!");
                    }
                });



       /* Call<Account> call = Api.apiService
                .login("13866666666", "123456", "120c83f7602f4c5fc8b",
                        SignUtil.getSign(map));
        // 发送网络请求(异步)
        call.enqueue(new Callback<Account>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                Log.i("TAG", "success: " + "请求成功");
                Log.i("TAG", "onResponse: " + response.body());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.i("TAG", "onFailure: " + "请求失败");
                Log.i("TAG", "onFailure: " + t.getMessage());
            }
        });*/
    }

    private void restoreInfo() {
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        etUsername.setText(sp.getString("username", ""));
        etPassword.setText(sp.getString("password", ""));

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

             /*   if (TextUtils.isEmpty(etUsername.getText().toString()) || TextUtils.isEmpty(
                        etPassword.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "用户名密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }*/

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                initLogin(username, password);
                memInfo(username, password);

        }
    }

    private void memInfo(String username, String password) {
        Editor editor = getSharedPreferences("data", 0).edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
