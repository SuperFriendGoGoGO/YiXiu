package com.zykj.yixiu.widget;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zykj on 2017/4/22.
 */

public class MyRVitem {
    TextView tv_zhonglei,tv_dizhi,tv_shijian,tv_time;
    Button bt_xingqing,bt_shanchu,bt_chongfa;

    @Override
    public String toString() {
        return "MyRVitem{" +
                "tv_zhonglei=" + tv_zhonglei +
                ", tv_dizhi=" + tv_dizhi +
                ", tv_shijian=" + tv_shijian +
                ", tv_time=" + tv_time +
                ", bt_xingqing=" + bt_xingqing +
                ", bt_shanchu=" + bt_shanchu +
                ", bt_chongfa=" + bt_chongfa +
                '}';
    }

    public TextView getTv_zhonglei() {
        return tv_zhonglei;
    }

    public void setTv_zhonglei(TextView tv_zhonglei) {
        this.tv_zhonglei = tv_zhonglei;
    }

    public TextView getTv_dizhi() {
        return tv_dizhi;
    }

    public void setTv_dizhi(TextView tv_dizhi) {
        this.tv_dizhi = tv_dizhi;
    }

    public TextView getTv_shijian() {
        return tv_shijian;
    }

    public void setTv_shijian(TextView tv_shijian) {
        this.tv_shijian = tv_shijian;
    }

    public TextView getTv_time() {
        return tv_time;
    }

    public void setTv_time(TextView tv_time) {
        this.tv_time = tv_time;
    }

    public Button getBt_xingqing() {
        return bt_xingqing;
    }

    public void setBt_xingqing(Button bt_xingqing) {
        this.bt_xingqing = bt_xingqing;
    }

    public Button getBt_shanchu() {
        return bt_shanchu;
    }

    public void setBt_shanchu(Button bt_shanchu) {
        this.bt_shanchu = bt_shanchu;
    }

    public Button getBt_chongfa() {
        return bt_chongfa;
    }

    public void setBt_chongfa(Button bt_chongfa) {
        this.bt_chongfa = bt_chongfa;
    }
}
