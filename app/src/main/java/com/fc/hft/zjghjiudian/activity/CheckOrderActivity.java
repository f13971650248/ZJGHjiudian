package com.fc.hft.zjghjiudian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.api.Api;
import com.fc.hft.zjghjiudian.entiy.CheckOrder;
import com.fc.hft.zjghjiudian.entiy.OrderUpdate;
import com.fc.hft.zjghjiudian.retorfit.ApiProvider;
import com.fc.hft.zjghjiudian.retorfit.RxTransform;
import com.fc.hft.zjghjiudian.ui.order.WeiFragment;
import com.fc.hft.zjghjiudian.utils.SignUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckOrderActivity extends AppCompatActivity {

    @BindView(R.id.tv_input)
    TextView tvInput;
    @BindView(R.id.et_input)
    EditText etInput;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_order);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        Map<String, String> map = new HashMap<>();
        map.put("orderId", "28");
        map.put("status", "1");
        String sign =SignUtil.getSign(map);
        ApiProvider.getInstance().provider(Api.BASE_URL)
                .checkOrder("28","1",sign)
                .compose(RxTransform.<CheckOrder>applyIOM())
                .subscribe(new Consumer<CheckOrder>() {
                    @Override
                    public void accept(CheckOrder checkOrder) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        Log.i("TAG","+++++++++++444");

        Intent intent = new Intent(CheckOrderActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
