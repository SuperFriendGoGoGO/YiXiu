package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zykj.yixiu.R;
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
    String sex="男";
    private String didian;
    private String chengshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymaterial);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        didian = intent.getStringExtra("didian");
        chengshi = intent.getStringExtra("chengshi");
       UserUtils.CUSTOM_NAME=Y.USER.getUsername();
        UserUtils.CUSTOM_PHONE=Y.USER.getPhone();
               Y.USER.setUsername(etName.getText().toString());
        Y.USER.setPhone(etNum.getText().toString());
        Y.USER.setSex(sex);
        Glide.with(this).load(Y.USER.getIcon()).into(ivHard);
        if (!TextUtils.isEmpty(Y.USER.getUsername())){
          etName.setText(Y.USER.getUsername());
        }

    }


    @OnClick({R.id.iv_hongdian, R.id.iv_huidian, R.id.bt_tijiao})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_hongdian:
                ivHongdian.setImageResource(R.mipmap.u1108);
                ivHuidian.setImageResource(R.mipmap.u1112);
                sex = "男";
                Y.USER.setSex(sex);
                break;
            case R.id.iv_huidian:
                ivHuidian.setImageResource(R.mipmap.u1108);
                ivHongdian.setImageResource(R.mipmap.u1112);
                sex = "女";
                Y.USER.setSex(sex);
                break;
            case R.id.bt_tijiao:
                if (!etName.getText().toString().isEmpty() && !etNum.getText().toString().isEmpty() && !tvDizhi.getText().toString().isEmpty()) {
                    RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/setUserInfo");
                    params.addBodyParameter("username", etName.getText().toString());
                    params.addBodyParameter("sex",sex);
                    params.addBodyParameter("province", didian);
                    params.addBodyParameter("city", didian);
                    params.addBodyParameter("user_id",Y.USER.getUser_id()+"");
                    params.addBodyParameter("token",Y.TOKEN);
                    Y.post(params, new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {



                                    Y.t("上传成功");
                                Intent intent=new Intent(MyZiLiao.this,Personal.class);
                                startActivity(intent);



                            } else {
                                Y.t("上传异常");
                            }
                        }
                    });


                }else {
                    Y.t("请完善资料");
                }
                break;
        }
    }
}
