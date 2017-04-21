package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.Y;
import com.zykj.yixiu.widget.MyTopBar;

import org.xutils.http.RequestParams;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/18.
 */

public class Login extends Activity {

    @Bind(R.id.et_num)
    EditText etNum;
    @Bind(R.id.et_yzm)
    EditText etYzm;
    @Bind(R.id.bt_yzm)
    Button btYzm;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.mytopbar)
    MyTopBar mytopbar;
    @Bind(R.id.button2)
    Button button2;
    private String word;
    private String data;
    private String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        word = intent.getStringExtra("word");
        if (word.equals("1")) {
        } else if (word.equals("2")) {
            mytopbar.setTitleText("忘记密码");
        }
    }

    @OnClick({R.id.bt_yzm, R.id.button,R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_yzm:

                break;
            case R.id.button:
                if (word.equals("1")) {
                    boolean phoneLegal = isChinaPhoneLegal(etNum.getText().toString());
                    if (phoneLegal){

                    RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/register");
                    params.addBodyParameter("phone", etNum.getText().toString());
                    params.addBodyParameter("vcode", "1111");
                    params.addBodyParameter("tape", "0");
                    Y.get(params, new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {
                                JSONObject jsonObject = JSON.parseObject(result);
                                String message = jsonObject.getString("message");
                                data = jsonObject.getString("data");
                                String resp_code = jsonObject.getString("resp_code");
                                if (resp_code.equals("0")) {
                                    Y.t(message);
                                    num = etNum.getText().toString();
                                    etNum.setText("");
                                    etYzm.setText("");
                                    mytopbar.setTitleText("密码");
                                    etNum.setHint("请输入你的密码");
                                    etYzm.setHint("再次输入你的密码");
                                    btYzm.setVisibility(View.GONE);
                                    button.setVisibility(View.GONE);
                                    button2.setVisibility(View.VISIBLE);

                                }
                            } else {
                                Y.t("注册异常");
                            }
                        }
                    });

                }}else if (word.equals("2")){

                }
                break;
            case R.id.button2:
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/setpassword");
                params.addBodyParameter("password", etNum.getText().toString());
                params.addBodyParameter("token", data);

                Y.get(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if (Y.getRespCode(result)) {
                            JSONObject jsonObject = JSON.parseObject(result);
                            String resp_code = jsonObject.getString("resp_code");
                            if (resp_code.equals("0")) {
                                String yzm = etYzm.getText().toString();
                                Y.t("完成设置");
                                Intent intent=new Intent(Login.this,Denglv.class);
                                intent.putExtra("num",num);
                                intent.putExtra("yzm",yzm);
                                startActivity(intent);
                            }
                        } else {
                            Y.t("注册异常");
                        }
                    }
                });



                break;
        }
    }
    public static boolean isChinaPhoneLegal(String str)
            throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
