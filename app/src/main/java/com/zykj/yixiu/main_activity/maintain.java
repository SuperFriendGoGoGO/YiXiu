package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zykj.yixiu.R;
import com.zykj.yixiu.widget.MyTopBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @Bind(R.id.ll_type)
    LinearLayout llType;
    @Bind(R.id.phonemodel)
    TextView phonemodel;
    @Bind(R.id.model)
    ImageView model;
    @Bind(R.id.faultpoint)
    TextView faultpoint;
    @Bind(R.id.malfunction)
    ImageView malfunction;
    @Bind(R.id.describe)
    EditText describe;
    @Bind(R.id.picture)
    ImageView picture;
    @Bind(R.id.transfer)
    Button transfer;
    private String mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_maintain);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        //获取首页传来的标示符
        mark = intent.getStringExtra("mark");
        //判断标示符是通过那个按键传来的
        if ("1".equals(mark)) {
            //什么都没改变
        } else if ("2".equals(mark)) {
            //改变文字 文字颜色
            headline.setTitleText("电脑维修");
            llType.setVisibility(View.VISIBLE);
            MobileBrand.setText("联想");
            MobileBrand.setTextColor(Color.parseColor("#00cccc"));
            appliancetype.setText("笔记本");
            appliancetype.setHintTextColor(Color.parseColor("#00cccc"));
            phonemodel.setText("Y460A-ITH");
            phonemodel.setTextColor(Color.parseColor("#00cccc"));
            faultpoint.setText("主板");
            faultpoint.setTextColor(Color.parseColor("#00cccc"));
            describe.setText("开机进不去系统，黑屏白字");
        } else if ("3".equals(mark)) {
            //改变文字
            headline.setTitleText("家电维修");
            llType.setVisibility(View.VISIBLE);
            MobileBrand.setText("请选择你的家电品牌");
            appliancetype.setText("请选择你的家电类型");
            phonemodel.setText("请选择你的家电型号");
            faultpoint.setText("请选择你的家电故障点");
            describe.setText("请对你的家电故障进行简单的描述");
        }

    }


    @OnClick({R.id.brand, R.id.type, R.id.model, R.id.malfunction, R.id.picture, R.id.transfer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.brand:
                break;
            case R.id.type:
                break;
            case R.id.model:
                break;
            case R.id.malfunction:
                break;
            case R.id.picture:
                break;
            case R.id.transfer:
                if (!MobileBrand.getText().toString().isEmpty() && !appliancetype.getText().toString().isEmpty() && !phonemodel.getText().toString().isEmpty() && !faultpoint.getText().toString().isEmpty() && !describe.getText().toString().isEmpty()) {
                    Intent intent = new Intent(this, AttendantCall.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
