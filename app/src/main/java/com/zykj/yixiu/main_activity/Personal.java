package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.Y;

import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

/**
 * Created by zykj on 2017/4/19.
 */

public class Personal extends Activity {


    @Bind(R.id.iv_hard)
    ImageView ivHard;
    @Bind(R.id.iv_renzheng)
    ImageView ivRenzheng;
    @Bind(R.id.fl_hard)
    FrameLayout flHard;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.iv_sex)
    ImageView ivSex;
    @Bind(R.id.rl_hard)
    LinearLayout rlHard;
    @Bind(R.id.fl_undone)
    FrameLayout flUndone;
    @Bind(R.id.ll_accomplish)
    LinearLayout llAccomplish;
    @Bind(R.id.abolish)
    LinearLayout abolish;
    @Bind(R.id.iv_material)
    ImageView ivMaterial;
    @Bind(R.id.ll_myziliao)
    LinearLayout llMyziliao;
    @Bind(R.id.wallet)
    ImageView wallet;
    @Bind(R.id.ll_myqianbao)
    LinearLayout llMyqianbao;
    @Bind(R.id.address)
    ImageView address;
    @Bind(R.id.ll_mydizhi)
    LinearLayout llMydizhi;
    @Bind(R.id.tv_approve)
    TextView tvApprove;
    @Bind(R.id.iv_approve)
    ImageView ivApprove;
    @Bind(R.id.ll_renzheng)
    LinearLayout llRenzheng;
    @Bind(R.id.iv_terrace)
    ImageView ivTerrace;
    @Bind(R.id.ll_pingtai)
    LinearLayout llPingtai;
    @Bind(R.id.ll_about)
    TextView llAbout;
    @Bind(R.id.iv_about)
    ImageView ivAbout;
    @Bind(R.id.iv_set)
    ImageView ivSet;
    @Bind(R.id.ll_set)
    LinearLayout llSet;
    @Bind(R.id.iv_fanhui)
    ImageView ivFanhui;
    private String photoPath;
    private String didian;
    private String chengshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcenter);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        didian = intent.getStringExtra("didian");
        chengshi = intent.getStringExtra("chengshi");
        if (!TextUtils.isEmpty(Y.USER.getIcon())){
            ImageOptions imageOptions=new ImageOptions.Builder()
                    .setCircular(true)
                    .build();
            x.image().bind(ivHard,Y.USER.getIcon(),imageOptions);
        }


    }


    @OnClick({R.id.iv_fanhui,R.id.iv_hard, R.id.fl_undone, R.id.ll_accomplish, R.id.abolish, R.id.ll_myziliao, R.id.ll_myqianbao, R.id.ll_mydizhi, R.id.ll_renzheng, R.id.ll_pingtai, R.id.ll_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_hard:
                GalleryFinal.openGallerySingle(100, new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        if (reqeustCode == 100) {
                            PhotoInfo info = resultList.get(0);
                            photoPath = info.getPhotoPath();
                            ImageOptions imageOptions=new ImageOptions.Builder()
                                    .setCircular(true)
                                    .build();
                            x.image().bind(ivHard,photoPath,imageOptions);
                        }

                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {

                    }
                });
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/uploadIcon");
                params.addBodyParameter("icon", photoPath);
                params.addBodyParameter("token", Y.TOKEN);

                Y.post(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if (Y.getRespCode(result)) {
                            Y.USER.setIcon(Y.getData(result));
                            Y.t("上传正常");
                        } else {
                            Y.t("上传异常");
                        }
                    }
                });
                break;
            case R.id.fl_undone:
                //我的订单 未完成
                Intent intent = new Intent(this, MyOrder.class);
                intent.putExtra("wow", "1");
                startActivity(intent);
                break;
            case R.id.ll_accomplish:
                //我的订单 已完成
                Intent intent2 = new Intent(this, MyOrder.class);
                intent2.putExtra("wow", "2");
                startActivity(intent2);
                break;
            case R.id.abolish:
                //我的订单 已取消
                Intent intent3 = new Intent(this, MyOrder.class);
                intent3.putExtra("wow", "3");
                startActivity(intent3);
                break;
            case R.id.ll_myziliao:
                //完善个人资料
                Intent intent4 = new Intent(this, MyZiLiao.class);
                intent4.putExtra("didian", didian);
                intent4.putExtra("chengshi", chengshi);
                startActivity(intent4);
                break;
            case R.id.ll_myqianbao:
                break;
            case R.id.ll_mydizhi:
                //增加地址或查看地址
                Intent intent5 = new Intent(this, MyDizhi.class);
                startActivity(intent5);
                break;
            case R.id.ll_renzheng:
                //跳转页面——————认证身份证
                Intent intent6 = new Intent(this, RenZheng.class);
                startActivity(intent6);
                break;
            case R.id.ll_pingtai:
                //跳转页面——————平台服务
                Intent intent7 = new Intent(this, PingTai.class);
                startActivity(intent7);
                break;
            case R.id.ll_set:
                break;
            case R.id.iv_fanhui:
                Intent intent8=new Intent(this,Activity_Main.class);
                startActivity(intent8);
                break;
        }
    }


}
