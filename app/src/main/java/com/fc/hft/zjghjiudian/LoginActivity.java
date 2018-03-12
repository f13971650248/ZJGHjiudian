package com.fc.hft.zjghjiudian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fc.hft.zjghjiudian.entiy.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2018/3/7/007.
 */

public class LoginActivity extends AppCompatActivity {


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
        Bmob.initialize(LoginActivity.this, "60ddbb889ba5307f9ab29d155b116148");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_layout);

        unbinder = ButterKnife.bind(this);
        //获取登录成功后的本地用户信息
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null) {
            //得到当前登陆的用户，如果得到跳转到首页
            intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            LoginActivity.this.finish();
        }
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (TextUtils.isEmpty(etUsername.getText().toString()) || TextUtils.isEmpty(
                        etPassword.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "用户名密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                User user = new User();
                user.setUsername(etUsername.getText().toString());
                user.setPassword(etPassword.getText().toString());
                user.login(new SaveListener<User>() {
                    @Override
                    public void done(User user, BmobException e) {
                        if (e == null) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            LoginActivity.this.finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "登录失败" + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
