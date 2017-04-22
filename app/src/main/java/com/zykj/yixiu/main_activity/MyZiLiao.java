package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.User;
import com.zykj.yixiu.utils.Y;

import org.xutils.http.RequestParams;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/22.
 */

public class MyZiLiao extends Activity {
    @Bind(R.id.iv_hard)
    ImageView ivHard;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.iv_hongdian)
    ImageView ivHongdian;
    @Bind(R.id.iv_huidian)
    ImageView ivHuidian;
    @Bind(R.id.et_num)
    EditText etNum;
    @Bind(R.id.ll_number)
    LinearLayout llNumber;
    @Bind(R.id.tv_dizhi)
    TextView tvDizhi;
    @Bind(R.id.ll_address)
    LinearLayout llAddress;
    @Bind(R.id.bt_tijiao)
    Button btTijiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymaterial);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_tijiao)
    public void onClick() {
      /*  RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/login");
        params.addBodyParameter("phone", etUser.getText().toString());
        params.addBodyParameter("password", etPassword.getText().toString());

        Y.get(params, new Y.MyCommonCall<String>() {
            @Override
            public void onSuccess(String result) {
                if (Y.getRespCode(result)) {
                    User users = JSON.parseObject(result, User.class);
                    Y.USER=users;
                    Y.TOKEN=users.getToken();
                    JSONObject jsonObject = JSON.parseObject(result);
                    String resp_code = jsonObject.getString("resp_code");
                    if (resp_code.equals("0")) {
                        Y.t("登陆成功");
                        Intent intent=new Intent(Denglv.this,Activity_Main.class);
                        startActivity(intent);

                    }
                } else {
                    Y.t("登录异常");
                }
            }
        });*/

    }
}
