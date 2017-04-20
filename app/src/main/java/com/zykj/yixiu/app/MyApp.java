package com.zykj.yixiu.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.loader.ImageLoader;
import com.zykj.yixiu.utils.Y;

import org.xutils.x;

import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.finalteam.galleryfinal.widget.GFImageView;

/**
 * Created by zykj on 2017/4/18.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Y.context=this;

        x.Ext.init(this);

        ThemeConfig themeConfig  =new  ThemeConfig.Builder().build();
        FunctionConfig functionConfig =new FunctionConfig.Builder().build();
    }
}
