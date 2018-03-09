package com.fc.hft.zjghjiudian;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fc.hft.zjghjiudian.entiy.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2018/3/7/007.
 */

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_reg)
    Button btnReg;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register_layout);
        unbinder = ButterKnife.bind(this);
        Bmob.initialize(RegisterActivity.this, "60ddbb889ba5307f9ab29d155b116148");
    }

    @OnClick(R.id.btn_reg)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_reg:
                if (TextUtils.isEmpty(etUsername.getText().toString()) || TextUtils.isEmpty(etPassword.
                        getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "用户名密码不能为空",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                User user = new User();
                user.setUsername(etUsername.getText().toString());
                user.setPassword(etPassword.getText().toString());
                user.signUp(new SaveListener<User>() {
                    @Override
                    public void done(User user, BmobException e) {
                        if (e == null) {
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                            RegisterActivity.this.finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_LONG
                            ).show();
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
