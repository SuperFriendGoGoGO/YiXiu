package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.UserUtils;
import com.zykj.yixiu.utils.Y;

import org.xutils.http.RequestParams;

import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static cn.finalteam.toolsfinal.DateUtils.getTime;


/**
 * Created by zykj on 2017/4/13.
 */

public class AttendantCall extends Activity {


    @Bind(R.id.iv_fanhui)
    ImageView ivFanhui;
    @Bind(R.id.tv_servicetime)
    TextView tvServicetime;
    @Bind(R.id.im_servicetime)
    ImageView imServicetime;
    @Bind(R.id.ll_time)
    LinearLayout llTime;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.iv_address)
    ImageView ivAddress;
    @Bind(R.id.ll_address)
    LinearLayout llAddress;
    @Bind(R.id.bt_service)
    Button btService;
    private UserUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendantcall);
        ButterKnife.bind(this);
        Intent intent=getIntent();
       utils= (UserUtils) intent.getSerializableExtra("utils");


    }

    @OnClick({R.id.bt_service, R.id.ll_time, R.id.ll_address, R.id.iv_fanhui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_service:
                //判断 控件内容是否为空
                if (!tvAddress.getText().toString().isEmpty() && !tvServicetime.getText().toString().isEmpty()) {
                    //自定义对话框
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.tool_dialog,
                            (ViewGroup) findViewById(R.id.dialog));

                    new AlertDialog.Builder(this).setView(layout)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //上传订单
                                    RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/addOrder");
                                    params.addBodyParameter("order_type", utils.getOrder_type());
                                    params.addBodyParameter("brand", utils.getBrand());
                                    params.addBodyParameter("model",utils.getModel());
                                    params.addBodyParameter("fault", utils.getFault());
                                    params.addBodyParameter("fault_desc",utils.getFault_desc());
                                    params.addBodyParameter("category", utils.getCategory());
                                    params.addBodyParameter("image1",utils.getImage1());
                                    params.addBodyParameter("service_time", utils.getService_time());
                                    params.addBodyParameter("service_address", utils.getService_address());
                                    params.addBodyParameter("custom_phone", utils.getCustom_phone());
                                    params.addBodyParameter("custom_name", Y.USER.getAli_name());
                                    params.addBodyParameter("custom_id", Y.USER.getUser_id()+"");
                                    params.addBodyParameter("address_id", utils.getAddress_id());
                                    Y.post(params, new Y.MyCommonCall<String>() {
                                        @Override
                                        public void onSuccess(String result) {
                                            Y.l(result);

                                            if (Y.getRespCode(result)) {
                                                Y.t("上传成功");

                                            } else {
                                                Y.t("解析异常");
                                            }
                                        }
                                    });

                                }
                            })
                            .setNegativeButton("取消", null).show();


                }
                break;
            case R.id.ll_time:
                //三级联动 设置时间
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        tvServicetime.setText(getTime(date));
                        utils.setService_time(tvServicetime.getText().toString());
                    }
                })
                        .build();
                pvTime.setDate(Calendar.getInstance());
                pvTime.show();
                break;
            case R.id.ll_address:
                //跳转到dizhi
                Intent intent = new Intent(this, MyDizhi.class);
                intent.putExtra("utils",utils);
                startActivity(intent);
                break;
            case R.id.iv_fanhui:
                //跳转到维修
                Intent intent2 = new Intent(this, Maintain.class);
                startActivity(intent2);
                break;

        }
    }


}
