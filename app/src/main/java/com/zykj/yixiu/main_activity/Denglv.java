package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.User;
import com.zykj.yixiu.utils.Y;

import org.xutils.http.RequestParams;

import java.util.List;

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
        Intent intent=getIntent();
        String num = intent.getStringExtra("num");
        String yzm = intent.getStringExtra("yzm");
        etUser.setText(num);
        etPassword.setText(yzm);
        startActivity(intent);
    }


    @OnClick({R.id.bt_ensure, R.id.tv_login, R.id.tv_forget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_ensure:
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/login");
                params.addBodyParameter("phone", etUser.getText().toString());
                params.addBodyParameter("password", etPassword.getText().toString());

                Y.get(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if (Y.getRespCode(result)) {
                            User users = JSON.parseObject(result, User.class);
                            Y.USER=users;
                            Y.USER.setUser_id(users.getUser_id());
                            Y.TOKEN=users.getToken();

                                Y.t("登陆成功----");
                                Intent intent=new Intent(Denglv.this,Activity_Main.class);
                                startActivity(intent);


                        } else {
                            Y.t("登录异常");
                        }
                    }
                });
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
