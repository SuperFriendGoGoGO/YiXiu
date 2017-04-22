package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.OptionsPicke;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/12.
 */

public class Activity_Main extends Activity {


    @Bind(R.id.tv_didian)
    TextView tvDidian;
    @Bind(R.id.iv_gereb)
    ImageView ivGereb;
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.textView3)
    TextView textView3;
    @Bind(R.id.imageView5)
    ImageView imageView5;
    @Bind(R.id.mobile)
    ImageView mobile;
    @Bind(R.id.u42)
    ImageView u42;
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.computer)
    ImageView computer;
    @Bind(R.id.fl)
    FrameLayout fl;
    @Bind(R.id.textView9)
    TextView textView9;
    @Bind(R.id.appliance)
    TextView appliance;
    @Bind(R.id.appliances)
    ImageView appliances;
    private String sheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        List images = new ArrayList();
        for (int i = 0; i < 100; i++) {
            images.add(R.mipmap.u40);
        }
        Banner banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        tvDidian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionsPicke optionsPicke=new OptionsPicke();
                optionsPicke.showOptionsPicke(Activity_Main.this, new OptionsPicke.OptionsSelectListener() {
                    @Override
                    public void selectListener(String province, String city, String district) {
                        tvDidian.setText(city);
                        sheng = province;
                    }
                });
            }
        });


    }

    //设置传入标识符 让——修理——页面识别
    @OnClick({R.id.mobile, R.id.computer, R.id.appliances,R.id.iv_gereb})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mobile:
                Intent mobileintent = new Intent(this, Maintain.class);
                mobileintent.putExtra("mark", "1");
                startActivity(mobileintent);
                break;
            case R.id.computer:
                Intent computerintent = new Intent(this, Maintain.class);
                computerintent.putExtra("mark", "2");
                startActivity(computerintent);
                break;
            case R.id.appliances:
                Intent appliancesintent = new Intent(this, Maintain.class);
                appliancesintent.putExtra("mark", "3");
                startActivity(appliancesintent);
                break;
            case R.id.iv_gereb:
                Intent gerebintent = new Intent(this, Personal.class);
                gerebintent.putExtra("didian",sheng);
                gerebintent.putExtra("chengshi",tvDidian.getText().toString());
                startActivity(gerebintent);
                break;
        }
    }


}

class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        /**
         注意：
         1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
         2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
         传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
         切记不要胡乱强转！
         */

        //Glide 加载图片简单用法
        Glide.with(context).load(path).into(imageView);

    }


}