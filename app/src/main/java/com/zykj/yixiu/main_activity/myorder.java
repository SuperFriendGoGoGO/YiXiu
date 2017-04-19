package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    @Bind(R.id.tv_jiedan)
    TextView tvJiedan;
    @Bind(R.id.textView5)
    TextView textView5;
    @Bind(R.id.bt_chakan1)
    Button btChakan1;
    @Bind(R.id.bt_quxiao1)
    Button btQuxiao1;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.bt_chongfa)
    Button btChongfa;
    @Bind(R.id.bt_chakan2)
    Button btChakan2;
    @Bind(R.id.bt_quxiao2)
    Button btQuxiao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String wow = intent.getStringExtra("wow");
        if (wow.equals("1")){
            tvWei.setTextColor(Color.parseColor("#00cccc"));
            ivWei.setImageResource(R.mipmap.u15_line);
            tvQuxiao.setTextColor(Color.parseColor("#6b6b6b"));
            ivQuxiqao.setImageResource(R.mipmap.u30_line);
            tvYi.setTextColor(Color.parseColor("#6b6b6b"));
            ivYi.setImageResource(R.mipmap.u30_line);
            tvJiedan.setVisibility(View.VISIBLE);
            tvTime.setVisibility(View.VISIBLE);
            btChongfa.setVisibility(View.VISIBLE);

        }else if (wow.equals("2")){
            tvYi.setTextColor(Color.parseColor("#00cccc"));
            ivYi.setImageResource(R.mipmap.u15_line);
            tvQuxiao.setTextColor(Color.parseColor("#6b6b6b"));
            ivQuxiqao.setImageResource(R.mipmap.u30_line);
            tvWei.setTextColor(Color.parseColor("#6b6b6b"));
            ivWei.setImageResource(R.mipmap.u30_line);
            tvJiedan.setVisibility(View.GONE);
            tvTime.setVisibility(View.GONE);
            btChongfa.setVisibility(View.GONE);
        }else if (wow.equals("3")){
            tvQuxiao.setTextColor(Color.parseColor("#00cccc"));
            ivQuxiqao.setImageResource(R.mipmap.u15_line);
            tvYi.setTextColor(Color.parseColor("#6b6b6b"));
            ivYi.setImageResource(R.mipmap.u30_line);
            tvWei.setTextColor(Color.parseColor("#6b6b6b"));
            ivWei.setImageResource(R.mipmap.u30_line);
            tvJiedan.setVisibility(View.GONE);
            tvTime.setVisibility(View.GONE);
            btChongfa.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.tv_wei, R.id.tv_yi, R.id.tv_quxiao, R.id.bt_chakan1, R.id.bt_quxiao1, R.id.bt_chakan2, R.id.bt_quxiao2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_wei:
                tvWei.setTextColor(Color.parseColor("#00cccc"));
                ivWei.setImageResource(R.mipmap.u15_line);
                tvQuxiao.setTextColor(Color.parseColor("#6b6b6b"));
                ivQuxiqao.setImageResource(R.mipmap.u30_line);
                tvYi.setTextColor(Color.parseColor("#6b6b6b"));
                ivYi.setImageResource(R.mipmap.u30_line);
                tvJiedan.setVisibility(View.VISIBLE);
                tvTime.setVisibility(View.VISIBLE);
                btChongfa.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_yi:
                tvYi.setTextColor(Color.parseColor("#00cccc"));
                ivYi.setImageResource(R.mipmap.u15_line);
                tvQuxiao.setTextColor(Color.parseColor("#6b6b6b"));
                ivQuxiqao.setImageResource(R.mipmap.u30_line);
                tvWei.setTextColor(Color.parseColor("#6b6b6b"));
                ivWei.setImageResource(R.mipmap.u30_line);
                tvJiedan.setVisibility(View.GONE);
                tvTime.setVisibility(View.GONE);
                btChongfa.setVisibility(View.GONE);
                break;
            case R.id.tv_quxiao:
                tvQuxiao.setTextColor(Color.parseColor("#00cccc"));
                ivQuxiqao.setImageResource(R.mipmap.u15_line);
                tvYi.setTextColor(Color.parseColor("#6b6b6b"));
                ivYi.setImageResource(R.mipmap.u30_line);
                tvWei.setTextColor(Color.parseColor("#6b6b6b"));
                ivWei.setImageResource(R.mipmap.u30_line);
                tvJiedan.setVisibility(View.GONE);
                tvTime.setVisibility(View.GONE);
                btChongfa.setVisibility(View.GONE);
                break;
            case R.id.bt_chakan1:
                if (tvWei.getTextColors().equals(Color.parseColor("#00cccc")))
                break;
            case R.id.bt_quxiao1:
                break;
            case R.id.bt_chakan2:
                break;
            case R.id.bt_quxiao2:
                break;
        }
    }
}
