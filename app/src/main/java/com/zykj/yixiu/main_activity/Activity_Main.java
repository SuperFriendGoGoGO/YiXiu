package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zykj.yixiu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/12.
 */

public class Activity_Main extends Activity {

    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.textView3)
    TextView textView3;
    @Bind(R.id.imageView5)
    ImageView imageView5;
    @Bind(R.id.mobile)
    ImageView mobile;
    @Bind(R.id.u42)
    ImageView u42;
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.computer)
    ImageView computer;
    @Bind(R.id.fl)
    FrameLayout fl;
    @Bind(R.id.textView9)
    TextView textView9;
    @Bind(R.id.appliance)
    TextView appliance;
    @Bind(R.id.appliances)
    ImageView appliances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
    }

    //设置传入标识符 让——修理——页面识别
    @OnClick({R.id.mobile, R.id.computer, R.id.appliances})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mobile:
                Intent mobileintent = new Intent(this, Maintain.class);
                mobileintent.putExtra("mark", "1");
                startActivity(mobileintent);
                break;
            case R.id.computer:
                Intent computerintent = new Intent(this, Maintain.class);
                computerintent.putExtra("mark", "2");
                startActivity(computerintent);
                break;
            case R.id.appliances:
                Intent appliancesintent = new Intent(this, Maintain.class);
                appliancesintent.putExtra("mark", "3");
                startActivity(appliancesintent);
                break;
        }
    }


}
