package com.example.lvweihao.dialdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lvweihao on 2018/7/8.
 */

public class TestActitity extends AppCompatActivity {
    @BindView(R.id.dialView)
    DialView dialView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        //初始化（0-100）
        dialView.setAngle(25);

        //事件回调
        dialView.setOnDialViewTouchListener(new OnDialViewTouch() {
            @Override
            public void onTouched(int value) {
                Log.e("lwa", "value:" + value);
                //TODO 业务逻辑
            }
        });
    }

    @OnClick(R.id.btn_open)
    public void onViewClicked() {
        startActivity(new Intent(this, TestActitity1.class));
    }
}
