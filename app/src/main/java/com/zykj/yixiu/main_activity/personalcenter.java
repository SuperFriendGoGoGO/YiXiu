package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zykj.yixiu.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/13.
 */

public class PersonalCenter extends Activity {
    @Bind(R.id.fl)
    FrameLayout fl;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.fl_undone)
    FrameLayout flUndone;
    @Bind(R.id.ll_accomplish)
    LinearLayout llAccomplish;
    @Bind(R.id.abolish)
    LinearLayout abolish;
    @Bind(R.id.iv_material)
    ImageView ivMaterial;
    @Bind(R.id.wallet)
    ImageView wallet;
    @Bind(R.id.address)
    ImageView address;
    @Bind(R.id.tv_approve)
    TextView tvApprove;
    @Bind(R.id.iv_approve)
    ImageView ivApprove;
    @Bind(R.id.iv_terrace)
    ImageView ivTerrace;
    @Bind(R.id.iv_about)
    ImageView ivAbout;
    @Bind(R.id.iv_set)
    ImageView ivSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcenter);
        ButterKnife.bind(this);

    }

    @OnClick({ R.id.fl, R.id.tv_name, R.id.fl_undone, R.id.ll_accomplish, R.id.abolish, R.id.iv_material, R.id.wallet, R.id.address, R.id.iv_approve, R.id.iv_terrace, R.id.iv_about, R.id.iv_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.fl:
                break;
            case R.id.tv_name:
                break;
            case R.id.fl_undone:
                break;
            case R.id.ll_accomplish:
                break;
            case R.id.abolish:
                break;
            case R.id.iv_material:
                break;
            case R.id.wallet:
                break;
            case R.id.address:
                break;
            case R.id.iv_approve:
                break;
            case R.id.iv_terrace:
                break;
            case R.id.iv_about:
                break;
            case R.id.iv_set:
                break;
        }
    }
}
