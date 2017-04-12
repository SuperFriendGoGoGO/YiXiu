package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zykj.yixiu.R;
import com.zykj.yixiu.widget.MyTopBar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zykj on 2017/4/12.
 */

public class Maintain extends Activity {

    @Bind(R.id.headline)
    MyTopBar headline;
    @Bind(R.id.MobileBrand)
    TextView MobileBrand;
    @Bind(R.id.brand)
    ImageView brand;
    @Bind(R.id.appliancetype)
    TextView appliancetype;
    @Bind(R.id.type)
    ImageView type;
    @Bind(R.id.phonemodel)
    TextView phonemodel;
    @Bind(R.id.model)
    ImageView model;
    @Bind(R.id.faultpoint)
    TextView faultpoint;
    @Bind(R.id.malfunction)
    ImageView malfunction;
    @Bind(R.id.ll_type)
    LinearLayout llType;
    @Bind(R.id.describe)
    TextView describe;
    private String mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintain);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mark = intent.getStringExtra("mark");
        if ("1".equals(mark)) {
        } else if ("2".equals(mark)) {
            headline.setTitleText("电脑维修");
            llType.setVisibility(View.VISIBLE);
            MobileBrand.setText("联想");
            MobileBrand.setTextColor(Color.parseColor("#00cccc"));
            appliancetype.setText("笔记本");
            appliancetype.setTextColor(Color.parseColor("#00cccc"));
            phonemodel.setText("Y460A-ITH");
            phonemodel.setTextColor(Color.parseColor("#00cccc"));
            faultpoint.setText("主板");
            faultpoint.setTextColor(Color.parseColor("#00cccc"));
            describe.setText("开机进不去系统，黑屏白字");
        } else if ("3".equals(mark)) {
            headline.setTitleText("家电维修");
            llType.setVisibility(View.VISIBLE);
            MobileBrand.setText("请选择你的家电品牌");
            appliancetype.setText("请选择你的家电类型");
            phonemodel.setText("请选择你的家电型号");
            faultpoint.setText("请选择你的家电故障点");
            describe.setText("请对你的家电故障进行简单的描述");
        }
    }
}
