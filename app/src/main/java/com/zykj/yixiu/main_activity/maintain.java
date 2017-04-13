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

import com.bigkoo.pickerview.TimePickerView;
import com.zykj.yixiu.R;
import com.zykj.yixiu.widget.MyTopBar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/12.
 */

class Maintain extends Activity {


    @Bind(R.id.headline)
    MyTopBar headline;
    @Bind(R.id.MobileBrand)
    EditText MobileBrand;
    @Bind(R.id.brand)
    ImageView brand;
    @Bind(R.id.appliancetype)
    EditText appliancetype;
    @Bind(R.id.type)
    ImageView type;
    @Bind(R.id.ll_type)
    LinearLayout llType;
    @Bind(R.id.phonemodel)
    EditText phonemodel;
    @Bind(R.id.model)
    ImageView model;
    @Bind(R.id.faultpoint)
    EditText faultpoint;
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
        setContentView(R.layout.maintain);
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
            MobileBrand.setHint("联想");
            MobileBrand.setHintTextColor(Color.parseColor("#00cccc"));
            appliancetype.setHint("笔记本");
            appliancetype.setHintTextColor(Color.parseColor("#00cccc"));
            phonemodel.setHint("Y460A-ITH");
            phonemodel.setHintTextColor(Color.parseColor("#00cccc"));
            faultpoint.setText("主板");
            faultpoint.setHintTextColor(Color.parseColor("#00cccc"));
            describe.setHint("开机进不去系统，黑屏白字");
        } else if ("3".equals(mark)) {
            //改变文字
            headline.setTitleText("家电维修");
            llType.setVisibility(View.VISIBLE);
            MobileBrand.setHint("请选择你的家电品牌");
            appliancetype.setHint("请选择你的家电类型");
            phonemodel.setHint("请选择你的家电型号");
            faultpoint.setHint("请选择你的家电故障点");
            describe.setHint("请对你的家电故障进行简单的描述");
        }

    }

    //摩托罗拉 诺基亚 三星 波导 索尼 爱立信  阿尔卡特 熊猫 海尔 康佳 科健  飞利浦 海信  创维 CECT 金立 长虹  LG NEC 西门子 联想 天时达 夏普  酷派  大显 明基 中兴 华为  步步高 奥克斯 都宝 桑达 唯开 金鹏 德赛 万利达 宝石 天阔  东信 中桥 TCL天语 OPPO 南方高科 多普达 迪比特 苹果
    @OnClick({R.id.brand, R.id.type, R.id.model, R.id.malfunction, R.id.picture})
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
        }
    }
}
