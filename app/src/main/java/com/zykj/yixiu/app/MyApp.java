package com.zykj.yixiu.app;

import android.app.Activity;
import android.app.Application;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zykj.yixiu.utils.Y;

import org.xutils.x;

import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.ImageLoader;
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
class myImageLoader implements ImageLoader {
    @Override
    public void displayImage(Activity activity, String path, final GFImageView imageView, Drawable defaultDrawable, int width, int height) {
        //借助glide帮galleryfinal加载图片
        Glide.with(activity)
                .load("file://"+path)						//文件地址
                .placeholder(defaultDrawable)				//加载中图片
                .error(defaultDrawable)						//错误图片
                .override(width,height)						//图片宽高
                .diskCacheStrategy(DiskCacheStrategy.NONE)	//禁止磁盘缓存
                .skipMemoryCache(true)						//禁止内存缓存
                .into(imageView);							//加载图片到GalleryFinal
    }
    @Override
    public void clearMemoryCache() { 				//清除缓存不需要搭理
    }
}