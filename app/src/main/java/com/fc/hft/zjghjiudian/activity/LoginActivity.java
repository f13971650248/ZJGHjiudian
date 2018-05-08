package com.fc.hft.zjghjiudian.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.api.Api;
import com.fc.hft.zjghjiudian.base.BaseActivity;
import com.fc.hft.zjghjiudian.base.BaseApplication;
import com.fc.hft.zjghjiudian.entiy.Account;
import com.fc.hft.zjghjiudian.retorfit.ApiProvider;
import com.fc.hft.zjghjiudian.retorfit.RxTransform;
import com.fc.hft.zjghjiudian.utils.SignUtil;
import com.fc.hft.zjghjiudian.utils.ToastUtil;
import com.orhanobut.hawk.Hawk;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;

import static android.content.SharedPreferences.*;


/**
 * Created by Administrator on 2018/3/7/007.
 */

public class LoginActivity extends BaseActivity {
    public BaseApplication baseApp;

    //Intent intent;
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
    public int getContentViewId() {
        return R.layout.login_layout;
    }

    @Override
    public void initView() {
        unbinder = ButterKnife.bind(this);
        baseApp = (BaseApplication) getApplication();
        restoreInfo();
    }


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
                        intentActivity(LoginActivity.this,MainActivity.class);
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
