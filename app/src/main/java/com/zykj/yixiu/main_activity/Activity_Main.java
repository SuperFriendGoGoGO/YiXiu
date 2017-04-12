package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zykj.yixiu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/12.
 */

public class Activity_Main extends Activity {
    @Bind(R.id.mobile)
    ImageView mobile;
    @Bind(R.id.computer)
    ImageView computer;
    @Bind(R.id.appliances)
    ImageView appliances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mobile, R.id.computer, R.id.appliances})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mobile:
                Intent mobileintent=new Intent(this,Maintain.class);
                mobileintent.putExtra("mark","1");
                startActivity(mobileintent);
                break;
            case R.id.computer:
                Intent computerintent=new Intent(this,Maintain.class);
               computerintent.putExtra("mark","2");
                startActivity(computerintent);
                break;
            case R.id.appliances:
                Intent appliancesintent=new Intent(this,Maintain.class);
                appliancesintent.putExtra("mark","3");
                startActivity(appliancesintent);
                break;
        }
    }
}
