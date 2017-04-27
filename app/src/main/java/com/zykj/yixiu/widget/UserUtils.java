package com.zykj.yixiu.widget;

/**
 * Created by zykj on 2017/4/25.
 */

public class UserUtils {
    public static String ORDER_TYPE;
    public static String BRAND;
    public static String MODEL;
    public static String FAULT;
    public static String FAULT_DESC;
    public static String CATEGORY;
    public static String IMAGE1;
    public static String SERVICE_TIME;
    public static String SERVICE_ADDRESS;
    public static String CUSTOM_PHONE;
    public static String CUSTOM_NAME;
    public static String CUSTOM_ID="1";

    public static String getOrderType() {
        return ORDER_TYPE;
    }

    public static void setOrderType(String orderType) {
        ORDER_TYPE = orderType;
    }

    public static String getBRAND() {
        return BRAND;
    }

    public static void setBRAND(String BRAND) {
        UserUtils.BRAND = BRAND;
    }

    public static String getMODEL() {
        return MODEL;
    }

    public static void setMODEL(String MODEL) {
        UserUtils.MODEL = MODEL;
    }

    public static String getFAULT() {
        return FAULT;
    }

    public static void setFAULT(String FAULT) {
        UserUtils.FAULT = FAULT;
    }

    public static String getFaultDesc() {
        return FAULT_DESC;
    }

    public static void setFaultDesc(String faultDesc) {
        FAULT_DESC = faultDesc;
    }

    public static String getCATEGORY() {
        return CATEGORY;
    }

    public static void setCATEGORY(String CATEGORY) {
        UserUtils.CATEGORY = CATEGORY;
    }

    public static String getIMAGE1() {
        return IMAGE1;
    }

    public static void setIMAGE1(String IMAGE1) {
        UserUtils.IMAGE1 = IMAGE1;
    }

    public static String getServiceTime() {
        return SERVICE_TIME;
    }

    public static void setServiceTime(String serviceTime) {
        SERVICE_TIME = serviceTime;
    }

    public static String getServiceAddress() {
        return SERVICE_ADDRESS;
    }

    public static void setServiceAddress(String serviceAddress) {
        SERVICE_ADDRESS = serviceAddress;
    }

    public static String getCustomPhone() {
        return CUSTOM_PHONE;
    }

    public static void setCustomPhone(String customPhone) {
        CUSTOM_PHONE = customPhone;
    }

    public static String getCustomName() {
        return CUSTOM_NAME;
    }

    public static void setCustomName(String customName) {
        CUSTOM_NAME = customName;
    }

    public static String getCustomId() {
        return CUSTOM_ID;
    }

    public static void setCustomId(String customId) {
        CUSTOM_ID = customId;
    }

    public static String getAddressId() {
        return ADDRESS_ID;
    }

    public static void setAddressId(String addressId) {
        ADDRESS_ID = addressId;
    }

    public static String ADDRESS_ID;
//    name: 姓名
//    address: 地址
//    phone: 电话号码
//    user_id:用户ID
//    region:区
//    lat:纬度
//    lon:经度
//    city_name:城市名
//    city_code:城市编码
//    isdefault: 是否是默认 0 不默认  1 默认

}
