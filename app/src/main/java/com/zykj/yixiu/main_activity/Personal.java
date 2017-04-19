package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zykj.yixiu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/19.
 */

public class Personal extends Activity {


    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.iv_sex)
    ImageView ivSex;
    @Bind(R.id.iv_renzheng)
    ImageView ivRenzheng;
    @Bind(R.id.fl_hard)
    FrameLayout flHard;
    @Bind(R.id.rl_hard)
    RelativeLayout rlHard;
    @Bind(R.id.fl_undone)
    FrameLayout flUndone;
    @Bind(R.id.ll_accomplish)
    LinearLayout llAccomplish;
    @Bind(R.id.abolish)
    LinearLayout abolish;
    @Bind(R.id.iv_material)
    ImageView ivMaterial;
    @Bind(R.id.ll_myziliao)
    LinearLayout llMyziliao;
    @Bind(R.id.wallet)
    ImageView wallet;
    @Bind(R.id.ll_myqianbao)
    LinearLayout llMyqianbao;
    @Bind(R.id.address)
    ImageView address;
    @Bind(R.id.ll_mydizhi)
    LinearLayout llMydizhi;
    @Bind(R.id.tv_approve)
    TextView tvApprove;
    @Bind(R.id.iv_approve)
    ImageView ivApprove;
    @Bind(R.id.ll_renzheng)
    LinearLayout llRenzheng;
    @Bind(R.id.iv_terrace)
    ImageView ivTerrace;
    @Bind(R.id.ll_pingtai)
    LinearLayout llPingtai;
    @Bind(R.id.ll_about)
    TextView llAbout;
    @Bind(R.id.iv_about)
    ImageView ivAbout;
    @Bind(R.id.iv_set)
    ImageView ivSet;
    @Bind(R.id.ll_set)
    LinearLayout llSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcenter);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.fl_hard, R.id.fl_undone, R.id.ll_accomplish, R.id.abolish, R.id.ll_myziliao, R.id.ll_myqianbao, R.id.ll_mydizhi, R.id.ll_renzheng, R.id.ll_pingtai, R.id.ll_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fl_hard:
                break;
            case R.id.fl_undone:
                Intent intent=new Intent(this,MyOrder.class);
                intent.putExtra("wow","1");
                startActivity(intent);
                break;
            case R.id.ll_accomplish:
                Intent intent2=new Intent(this,MyOrder.class);
                intent2.putExtra("wow","2");
                startActivity(intent2);
                break;
            case R.id.abolish:
                Intent intent3=new Intent(this,MyOrder.class);
                intent3.putExtra("wow","2");
                startActivity(intent3);
                break;
            case R.id.ll_myziliao:
                break;
            case R.id.ll_myqianbao:
                break;
            case R.id.ll_mydizhi:
                break;
            case R.id.ll_renzheng:
                break;
            case R.id.ll_pingtai:
                break;
            case R.id.ll_set:
                break;
        }
    }
}
