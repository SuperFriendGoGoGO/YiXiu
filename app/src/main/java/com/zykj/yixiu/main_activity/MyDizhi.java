package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.Y;
import com.zykj.yixiu.widget.MyTopBar;

import org.xutils.http.RequestParams;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/22.
 */

public class MyDizhi extends Activity {
    @Bind(R.id.ll_add)
    LinearLayout llAdd;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.ll_name)
    LinearLayout llName;
    @Bind(R.id.tv_num)
    TextView tvNum;
    @Bind(R.id.ll_phone)
    LinearLayout llPhone;
    @Bind(R.id.et_dizhi)
    EditText etDizhi;
    @Bind(R.id.ll_xiangxidizhi)
    LinearLayout llXiangxidizhi;
    @Bind(R.id.ll_moren)
    LinearLayout llMoren;
    @Bind(R.id.et_number)
    EditText etNumber;
    @Bind(R.id.ll_num)
    LinearLayout llNum;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.mytopbar)
    MyTopBar mytopbar;
    @Bind(R.id.iv_fanhui)
    ImageView ivFanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        llMoren.setVisibility(View.GONE);
        llName.setVisibility(View.GONE);
        llNum.setVisibility(View.GONE);
        llPhone.setVisibility(View.GONE);
        llXiangxidizhi.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
    }

    @OnClick({R.id.ll_add, R.id.tv_num, R.id.button, R.id.button2,R.id.iv_fanhui})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_add:
                mytopbar.setTitleText("编辑地址");
                llAdd.setVisibility(View.GONE);
                llName.setVisibility(View.VISIBLE);
                llPhone.setVisibility(View.VISIBLE);
                llXiangxidizhi.setVisibility(View.VISIBLE);
                tvNum.setText(Y.USER.getPhone());
                button.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_num:
                mytopbar.setTitleText("编辑地址");
                llAdd.setVisibility(View.GONE);
                llName.setVisibility(View.GONE);
                llPhone.setVisibility(View.VISIBLE);
                llXiangxidizhi.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                llNum.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                break;
            case R.id.button:
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/addaddress");
                params.addBodyParameter("name", etName.getText().toString());
                params.addBodyParameter("address", etDizhi.getText().toString());
                params.addBodyParameter("phone", tvNum.getText().toString());
                params.addBodyParameter("user_id", Y.USER.getUser_id() + "");
                params.addBodyParameter("region", Y.QU);
                params.addBodyParameter("lat", "");
                params.addBodyParameter("lon", "");
                params.addBodyParameter("city_name", "");
                params.addBodyParameter("city_code", "");
                params.addBodyParameter("isdefault", 0 + "");

                Y.post(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if (Y.getRespCode(result)) {
                            Y.t("设置成功----");
                            Intent intent = new Intent(MyDizhi.this, Activity_Main.class);
                            startActivity(intent);


                        } else {
                            Y.t("设置异常");
                        }
                    }
                });
                break;
            case R.id.button2:
                llNum.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                llName.setVisibility(View.VISIBLE);
                llPhone.setVisibility(View.VISIBLE);
                llXiangxidizhi.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                tvNum.setText(etNumber.getText().toString());
                break;
            case R.id.iv_fanhui:
                Intent intent=new Intent(this,Personal.class);
                startActivity(intent);
                break;
        }
    }
}
