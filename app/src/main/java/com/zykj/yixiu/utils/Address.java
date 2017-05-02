package com.zykj.yixiu.utils;

import java.io.Serializable;

/**
 * 查询地址  返回数据
 * Created by zykj on 2017/4/27.
 */

public class Address implements Serializable {

    /**
     * region : 南岗区
     * city_name : 哈尔滨市
     * lon : 123.222331
     * phone : 13936550052
     * isdefault : 0
     * address : 炸天省炸天市炸天区炸天路炸天大厦炸炸炸
     * address_id : 1
     * name : 哇咔咔
     * isdel : 0
     * city_code : 48
     * user_id : 2
     * lat : 45.12342
     */

    private String region;
    private String city_name;
    private double lon;
    private String phone;
    private int isdefault;
    private String address;
    private int address_id;
    private String name;
    private int isdel;
    private String city_code;
    private int user_id;
    private double lat;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(int isdefault) {
        this.isdefault = isdefault;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
