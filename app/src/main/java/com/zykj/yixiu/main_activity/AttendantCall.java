package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zykj.yixiu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/13.
 */

public class AttendantCall extends Activity {
    @Bind(R.id.et_servicetime)
    EditText etServicetime;
    @Bind(R.id.im_servicetime)
    ImageView imServicetime;
    @Bind(R.id.et_address)
    EditText etAddress;
    @Bind(R.id.iv_address)
    ImageView ivAddress;
    @Bind(R.id.bt_service)
    Button btService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendantcall);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.im_servicetime, R.id.iv_address, R.id.bt_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_servicetime:
                break;
            case R.id.iv_address:
                break;
            case R.id.bt_service:
                if (etAddress.getText().toString().isEmpty()&&etServicetime.getText().toString().isEmpty())
                {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.tool_dialog,
                            (ViewGroup) findViewById(R.id.dialog));

                    new AlertDialog.Builder(this).setView(layout)
                            .setPositiveButton("确定", null)
                            .setNegativeButton("取消", null).show();
                }
                break;
        }
    }
}
