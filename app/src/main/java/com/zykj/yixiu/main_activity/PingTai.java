package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zykj.yixiu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/22.
 */

public class PingTai extends Activity {
    @Bind(R.id.ll_zixun)
    LinearLayout llZixun;
    @Bind(R.id.ll_wenti)
    LinearLayout llWenti;
    @Bind(R.id.iv_fanhui)
    ImageView ivFanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terrace);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ll_zixun,R.id.iv_fanhui, R.id.ll_wenti})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_zixun:
                //跳转页面——————咨询
                Intent intent = new Intent(this, ZiXun.class);
                startActivity(intent);
                break;
            case R.id.ll_wenti:
                //跳转页面——————认证身份证
                Intent intent2 = new Intent(this, RenZheng.class);
                startActivity(intent2);
                break;
            case R.id.iv_fanhui:
                Intent intent3=new Intent(this,Personal.class);
                startActivity(intent3);
                break;
        }
    }
}
