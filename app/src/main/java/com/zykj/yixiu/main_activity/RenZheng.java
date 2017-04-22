package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
 * Created by zykj on 2017/4/22.
 */

public class RenZheng extends Activity {
    @Bind(R.id.iv_zhengmian)
    ImageView ivZhengmian;
    @Bind(R.id.iv_fanmian)
    ImageView ivFanmian;
    @Bind(R.id.bt_ok)
    Button btOk;
    @Bind(R.id.iv_fanhui)
    ImageView ivFanhui;
    private String photoPath;
    private String photoPath2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_zhengmian, R.id.iv_fanmian, R.id.bt_ok,R.id.iv_fanhui})
    public void onClick(View view) {
        switch (view.getId()) {
            //身份证正面 加载
            case R.id.iv_zhengmian:
                GalleryFinal.openGallerySingle(100, new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        if (reqeustCode == 100) {
                            PhotoInfo info = resultList.get(0);
                            photoPath = info.getPhotoPath();//图片地址
                            x.image().bind(ivZhengmian, new File(photoPath).toURI().toString());//设置到控件上
                        }

                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {

                    }
                });
                break;
            case R.id.iv_fanmian:
                //身份证反面 加载
                GalleryFinal.openGallerySingle(100, new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        if (reqeustCode == 100) {
                            PhotoInfo info = resultList.get(0);
                            photoPath2 = info.getPhotoPath();//图片地址
                            x.image().bind(ivFanmian, new File(photoPath).toURI().toString());//设置到控件上
                        }

                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {

                    }
                });
                break;
            case R.id.bt_ok:
                //上传图片
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/uploadIcon");
                params.addBodyParameter("idcard_image1", photoPath);//添加参数
                params.addBodyParameter("idcard_image2", photoPath2);//添加参数
                params.addBodyParameter("token", Y.TOKEN);//添加参数

                Y.get(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if (Y.getRespCode(result)) {
                            //上传成功
                            Y.t("上传正常");
                            //跳转页面————————个人中心
                            Intent intent = new Intent(RenZheng.this, Personal.class);
                            startActivity(intent);
                        } else {
                            Y.t("上传异常");
                        }
                    }
                });
                break;
            case R.id.iv_fanhui:
                Intent intent=new Intent(this,Personal.class);
                startActivity(intent);
                break;
        }
    }
}
