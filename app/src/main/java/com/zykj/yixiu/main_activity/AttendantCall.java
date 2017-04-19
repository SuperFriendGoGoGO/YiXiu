package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.zykj.yixiu.R;

import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendantcall);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.im_servicetime, R.id.iv_address, R.id.bt_service, R.id.ll_time, R.id.ll_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_servicetime:
                break;
            case R.id.iv_address:
                break;
            case R.id.bt_service:
                if (!tvAddress.getText().toString().isEmpty() && !tvServicetime.getText().toString().isEmpty()) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.tool_dialog,
                            (ViewGroup) findViewById(R.id.dialog));

                    new AlertDialog.Builder(this).setView(layout)
                            .setPositiveButton("确定", null)
                            .setNegativeButton("取消", null).show();
                }
                break;
            case R.id.ll_time:
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                      // tvServicetime.setText();
                    }
                })
                        .build();
                pvTime.setDate(Calendar.getInstance());
                pvTime.show();
                break;
            case R.id.ll_address:
                break;
        }
    }


}
