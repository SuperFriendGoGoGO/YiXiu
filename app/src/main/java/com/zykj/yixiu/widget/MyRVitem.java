package com.zykj.yixiu.widget;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zykj on 2017/4/22.
 */

public class MyRVitem {
   String tv_zhonglei,tv_dizhi,tv_shijian,tv_time;

    @Override
    public String toString() {
        return "MyRVitem{" +
                "tv_zhonglei='" + tv_zhonglei + '\'' +
                ", tv_dizhi='" + tv_dizhi + '\'' +
                ", tv_shijian='" + tv_shijian + '\'' +
                ", tv_time='" + tv_time + '\'' +
                '}';
    }

    public String getTv_zhonglei() {
        return tv_zhonglei;
    }

    public void setTv_zhonglei(String tv_zhonglei) {
        this.tv_zhonglei = tv_zhonglei;
    }

    public String getTv_dizhi() {
        return tv_dizhi;
    }

    public void setTv_dizhi(String tv_dizhi) {
        this.tv_dizhi = tv_dizhi;
    }

    public String getTv_shijian() {
        return tv_shijian;
    }

    public void setTv_shijian(String tv_shijian) {
        this.tv_shijian = tv_shijian;
    }

    public String getTv_time() {
        return tv_time;
    }

    public void setTv_time(String tv_time) {
        this.tv_time = tv_time;
    }
}
