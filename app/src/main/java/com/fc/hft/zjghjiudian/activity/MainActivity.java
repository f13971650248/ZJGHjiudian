package com.fc.hft.zjghjiudian.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.base.BaseActivity;
import com.fc.hft.zjghjiudian.ui.Home.HomeFragment;
import com.fc.hft.zjghjiudian.ui.my.MyFragment;
import com.fc.hft.zjghjiudian.ui.order.OrderFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private RadioGroup radioGroup;
    private RadioButton btnHome;
    private RadioButton btnOrder;
    private RadioButton btnMy;
    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private MyFragment myFragment;
    private List<Fragment> lists;
    private FrameLayout frameLayout;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }*/

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        frameLayout = findViewById(R.id.framelayout);
        radioGroup =  findViewById(R.id.radioGroup);
        btnHome =  findViewById(R.id.btn_home);
        btnOrder =  findViewById(R.id.btn_order);
        btnMy = findViewById(R.id.btn_my);

        //创建Fragment对象合集
        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        myFragment = new MyFragment();

        //将fragment对象添加到list中
        lists = new ArrayList<Fragment>();
        lists.add(homeFragment);
        lists.add(orderFragment);
        lists.add(myFragment);

        //设置RadioGroup开始时设置的按钮，设置第一个按钮为默认值
        radioGroup.check(R.id.btn_home);

        btnHome.setOnClickListener(this);
        btnOrder.setOnClickListener(this);
        btnMy.setOnClickListener(this);

        //初始時向容器中添加第一個fargment對象
        addFragment(homeFragment);

    }

   /* private void init() {



    }*/

    private void addFragment(Fragment fragment) {
        //获得fragment管理器
        FragmentManager fragmentManager = getSupportFragmentManager();
        //使用管理器开启事务
        FragmentTransaction ft =fragmentManager.beginTransaction();
        //使用事务替换Fragment容器中Fragment对象
        ft.replace(R.id.framelayout, fragment);
        //提交事务，否则事务不生效
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_home:
                addFragment(homeFragment);
                break;
            case R.id.btn_order:
                addFragment(orderFragment);
                break;
            case R.id.btn_my:
                addFragment(myFragment);
                break;
        }

    }
}
