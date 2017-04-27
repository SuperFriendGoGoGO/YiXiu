package com.zykj.yixiu.utils;

/**
 * Created by zykj on 2017/4/27.
 */

public class DingDan {
    String name;
    String number;
    String dizhi;

    @Override
    public String toString() {
        return "DingDan{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", dizhi='" + dizhi + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }
}
