package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zykj.yixiu.R;
import com.zykj.yixiu.widget.MyTopBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/18.
 */

public class Login extends Activity {
    @Bind(R.id.mytopbar)
    MyTopBar mytopbar;
    @Bind(R.id.et_num)
    EditText etNum;
    @Bind(R.id.et_yzm)
    EditText etYzm;
    @Bind(R.id.bt_yzm)
    Button btYzm;
    @Bind(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String word = intent.getStringExtra("word");
        if (word.equals("1")) {
        } else if (word.equals("2")) {
            mytopbar.setTitleText("忘记密码");
        }
    }

    @OnClick({R.id.bt_yzm, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_yzm:
                Intent intent3=new Intent(this,Activity_Main.class);
                startActivity(intent3);
                break;
            case R.id.button:
               String title= mytopbar.getTitleText();
                if (title.equals("注册")){
                    mytopbar.setTitleText("密码");
                    etNum.setHint("请输入你的密码");
                    etYzm.setHint("再次输入你的密码");
                    btYzm.setVisibility(View.GONE);
                }else if (title.equals("忘记密码")){
                    Intent intent=new Intent(this,Denglv.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
