package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.zykj.yixiu.R;
import com.zykj.yixiu.widget.UserUtils;

import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static cn.finalteam.toolsfinal.DateUtils.getTime;


/**
 * Created by zykj on 2017/4/13.
 */

public class AttendantCall extends Activity {


    @Bind(R.id.tv_servicetime)
    TextView tvServicetime;
    @Bind(R.id.im_servicetime)
    ImageView imServicetime;
    @Bind(R.id.ll_time)
    LinearLayout llTime;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.iv_address)
    ImageView ivAddress;
    @Bind(R.id.ll_address)
    LinearLayout llAddress;
    @Bind(R.id.bt_service)
    Button btService;
    @Bind(R.id.iv_fanhui)
    ImageView ivFanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendantcall);
        ButterKnife.bind(this);
        tvAddress.setText("山东");
        UserUtils.SERVICE_ADDRESS=tvAddress.getText().toString();

    }

    @OnClick({R.id.im_servicetime, R.id.iv_address, R.id.bt_service, R.id.ll_time, R.id.ll_address, R.id.iv_fanhui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_servicetime:
                break;
            case R.id.iv_address:
                break;
            case R.id.bt_service:
                //判断 控件内容是否为空
                if (!tvAddress.getText().toString().isEmpty() && !tvServicetime.getText().toString().isEmpty()) {
                    Intent intent = new Intent(this, Activity_Main.class);
                    intent.putExtra("1", "1");
                    startActivity(intent);

                }
                break;
            case R.id.ll_time:
                //三级联动 设置时间
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        tvServicetime.setText(getTime(date));
                        UserUtils.SERVICE_TIME=tvServicetime.getText().toString();
                    }
                })
                        .build();
                pvTime.setDate(Calendar.getInstance());
                pvTime.show();
                break;
            case R.id.ll_address:
                //跳转到map地图
//                Intent intent = new Intent(this, MyMap.class);
//                startActivity(intent);
                break;
            case R.id.iv_fanhui:
                //跳转到维修
                Intent intent2 = new Intent(this, Maintain.class);
                startActivity(intent2);
                break;

        }
    }


}
