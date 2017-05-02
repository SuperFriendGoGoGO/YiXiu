package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zykj.yixiu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/19.
 */

public class MyOrder extends Activity {


    @Bind(R.id.iv_fanhui)
    ImageView ivFanhui;
    @Bind(R.id.tv_wei)
    TextView tvWei;
    @Bind(R.id.tv_yi)
    TextView tvYi;
    @Bind(R.id.tv_quxiao)
    TextView tvQuxiao;
    @Bind(R.id.iv_wei)
    ImageView ivWei;
    @Bind(R.id.iv_yi)
    ImageView ivYi;
    @Bind(R.id.iv_quxiqao)
    ImageView ivQuxiqao;
    @Bind(R.id.rv_xiadan)
    RecyclerView rvXiadan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String wow = intent.getStringExtra("wow");
        if (wow.equals("1")) {
            tvWei.setTextColor(Color.parseColor("#00cccc"));
            ivWei.setImageResource(R.mipmap.u15_line);
            tvQuxiao.setTextColor(Color.parseColor("#6b6b6b"));
            ivQuxiqao.setImageResource(R.mipmap.u30_line);
            tvYi.setTextColor(Color.parseColor("#6b6b6b"));
            ivYi.setImageResource(R.mipmap.u30_line);


        } else if (wow.equals("2")) {
            tvYi.setTextColor(Color.parseColor("#00cccc"));
            ivYi.setImageResource(R.mipmap.u15_line);
            tvQuxiao.setTextColor(Color.parseColor("#6b6b6b"));
            ivQuxiqao.setImageResource(R.mipmap.u30_line);
            tvWei.setTextColor(Color.parseColor("#6b6b6b"));
            ivWei.setImageResource(R.mipmap.u30_line);

        } else if (wow.equals("3")) {
            tvQuxiao.setTextColor(Color.parseColor("#00cccc"));
            ivQuxiqao.setImageResource(R.mipmap.u15_line);
            tvYi.setTextColor(Color.parseColor("#6b6b6b"));
            ivYi.setImageResource(R.mipmap.u30_line);
            tvWei.setTextColor(Color.parseColor("#6b6b6b"));
            ivWei.setImageResource(R.mipmap.u30_line);
        }
        rvXiadan.setLayoutManager(new LinearLayoutManager(this));
        rvXiadan.setItemAnimator(new DefaultItemAnimator());
        //  RvAdapter adapter=new RvAdapter();

    }

    @OnClick({R.id.iv_fanhui, R.id.iv_hard, R.id.tv_wei, R.id.tv_yi, R.id.tv_quxiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_wei:
                tvWei.setTextColor(Color.parseColor("#00cccc"));
                ivWei.setImageResource(R.mipmap.u15_line);
                tvQuxiao.setTextColor(Color.parseColor("#6b6b6b"));
                ivQuxiqao.setImageResource(R.mipmap.u30_line);
                tvYi.setTextColor(Color.parseColor("#6b6b6b"));
                ivYi.setImageResource(R.mipmap.u30_line);

                break;
            case R.id.tv_yi:
                tvYi.setTextColor(Color.parseColor("#00cccc"));
                ivYi.setImageResource(R.mipmap.u15_line);
                tvQuxiao.setTextColor(Color.parseColor("#6b6b6b"));
                ivQuxiqao.setImageResource(R.mipmap.u30_line);
                tvWei.setTextColor(Color.parseColor("#6b6b6b"));
                ivWei.setImageResource(R.mipmap.u30_line);

                break;
            case R.id.tv_quxiao:
                tvQuxiao.setTextColor(Color.parseColor("#00cccc"));
                ivQuxiqao.setImageResource(R.mipmap.u15_line);
                tvYi.setTextColor(Color.parseColor("#6b6b6b"));
                ivYi.setImageResource(R.mipmap.u30_line);
                tvWei.setTextColor(Color.parseColor("#6b6b6b"));
                ivWei.setImageResource(R.mipmap.u30_line);

                break;


        }
    }
}
