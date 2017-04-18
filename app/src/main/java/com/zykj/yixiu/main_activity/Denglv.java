package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zykj.yixiu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/18.
 */

public class Denglv extends Activity {
    @Bind(R.id.iv_head)
    ImageView ivHead;
    @Bind(R.id.et_user)
    EditText etUser;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.bt_ensure)
    Button btEnsure;
    @Bind(R.id.tv_login)
    TextView tvLogin;
    @Bind(R.id.tv_forget)
    TextView tvForget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglv);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_ensure, R.id.tv_login, R.id.tv_forget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_ensure:
                break;
            case R.id.tv_login:
                Intent intent=new Intent(this,Login.class);
                intent.putExtra("word","1");
                startActivity(intent);
                break;
            case R.id.tv_forget:
                Intent intent2=new Intent(this,Login.class);
                intent2.putExtra("word","2");
                startActivity(intent2);
                break;
        }
    }
}
