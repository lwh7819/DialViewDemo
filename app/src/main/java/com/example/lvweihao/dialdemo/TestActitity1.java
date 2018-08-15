package com.example.lvweihao.dialdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lvweihao on 2018/7/8.
 */

public class TestActitity1 extends AppCompatActivity {
    @BindView(R.id.dialView)
    DialView1 dialView;
    @BindView(R.id.seekBar)
    SeekBar seekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);

        //初始化（0-100）
        dialView.setAngle(45);
        seekBar.setProgress(45);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                dialView.setAngle(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //事件回调
        dialView.setOnDialViewTouchListener(new OnDialViewTouch() {
            @Override
            public void onTouched(int value) {
                Log.e("lwa", "value:" + value);
                int progress = (int) ((value - 2200) / 2800f * 100);
                seekBar.setProgress(progress);
                //TODO 业务逻辑
            }
        });
    }

    @OnClick(R.id.btn_open)
    public void onViewClicked() {
    }
}
