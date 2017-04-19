package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zykj.yixiu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/19.
 */

public class MyMaterial extends Activity {
    @Bind(R.id.iv_hard)
    ImageView ivHard;
    @Bind(R.id.iv_hongdian)
    ImageView ivHongdian;
    @Bind(R.id.iv_huidian)
    ImageView ivHuidian;
    @Bind(R.id.ll_number)
    LinearLayout llNumber;
    @Bind(R.id.ll_address)
    LinearLayout llAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymaterial);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_hard, R.id.iv_hongdian, R.id.iv_huidian, R.id.ll_number, R.id.ll_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_hard:
                break;
            case R.id.iv_hongdian:
                ivHongdian.setImageResource(R.mipmap.u1108);
                ivHuidian.setImageResource(R.mipmap.u1112);
                break;
            case R.id.iv_huidian:
                ivHuidian.setImageResource(R.mipmap.u1108);
                ivHongdian.setImageResource(R.mipmap.u1112);
                break;
            case R.id.ll_number:
                break;
            case R.id.ll_address:
                break;
        }
    }
}
