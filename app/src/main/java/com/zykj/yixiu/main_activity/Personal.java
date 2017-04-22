package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.Y;

import org.xutils.http.RequestParams;
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
    private String photoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcenter);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.iv_hard, R.id.fl_undone, R.id.ll_accomplish, R.id.abolish, R.id.ll_myziliao, R.id.ll_myqianbao, R.id.ll_mydizhi, R.id.ll_renzheng, R.id.ll_pingtai, R.id.ll_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_hard:
                GalleryFinal.openGallerySingle(100, new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        if (reqeustCode == 100) {
                            PhotoInfo info = resultList.get(0);
                            photoPath = info.getPhotoPath();
                            x.image().bind(ivHard, new File(photoPath).toURI().toString());
                        }

                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {

                    }
                });
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/uploadIcon");
                params.addBodyParameter("icon", photoPath);
                params.addBodyParameter("token", Y.TOKEN);

                Y.get(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if (Y.getRespCode(result)) {
                            Y.t("上传正常");
                        } else {
                            Y.t("上传异常");
                        }
                    }
                });
                break;
            case R.id.fl_undone:
                Intent intent = new Intent(this, MyOrder.class);
                intent.putExtra("wow", "1");
                startActivity(intent);
                break;
            case R.id.ll_accomplish:
                Intent intent2 = new Intent(this, MyOrder.class);
                intent2.putExtra("wow", "2");
                startActivity(intent2);
                break;
            case R.id.abolish:
                Intent intent3 = new Intent(this, MyOrder.class);
                intent3.putExtra("wow", "2");
                startActivity(intent3);
                break;
            case R.id.ll_myziliao:
                Intent intent4 = new Intent(this, MyZiLiao.class);
                startActivity(intent4);
                break;
            case R.id.ll_myqianbao:
                break;
            case R.id.ll_mydizhi:
                break;
            case R.id.ll_renzheng:
                break;
            case R.id.ll_pingtai:
                break;
            case R.id.ll_set:
                break;
        }
    }
}
