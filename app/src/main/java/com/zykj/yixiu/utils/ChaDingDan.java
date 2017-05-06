package com.zykj.yixiu.utils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zykj on 2017/5/6.
 */

public class ChaDingDan {
    /**
     * model :
     * engineer_id :
     * order_state : 1
     * class :
     * service_address :
     * fault :
     * custom_id : 2
     * custom_name :
     * id : 1
     * service_time :
     * addtime :
     * image2 :
     * price :
     * image1 :
     * pay_type :
     * address_id :
     * isdel : 0
     * brand :
     * fault_desc :
     * image3 :
     * custom_phone :
     * order_type : 1
     * region : 香坊区
     * lat : 45.111
     * lon : 经度
     * city_name : 哈尔滨市
     * city_code : 48
     */

    private String model;
    private String engineer_id;
    private int order_state;
    @SerializedName("class")
    private String classX;
    private String service_address;
    private String fault;
    private int custom_id;
    private String custom_name;
    private int id;
    private String service_time;
    private String addtime;
    private String image2;
    private String price;
    private String image1;
    private String pay_type;
    private String address_id;
    private int isdel;
    private String brand;
    private String fault_desc;
    private String image3;
    private String custom_phone;
    private String order_type;
    private String region;
    private String lat;
    private String lon;
    private String city_name;
    private String city_code;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineer_id() {
        return engineer_id;
    }

    public void setEngineer_id(String engineer_id) {
        this.engineer_id = engineer_id;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public String getClassX() {
        return classX;
    }

    public void setClassX(String classX) {
        this.classX = classX;
    }

    public String getService_address() {
        return service_address;
    }

    public void setService_address(String service_address) {
        this.service_address = service_address;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public int getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(int custom_id) {
        this.custom_id = custom_id;
    }

    public String getCustom_name() {
        return custom_name;
    }

    public void setCustom_name(String custom_name) {
        this.custom_name = custom_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_time() {
        return service_time;
    }

    public void setService_time(String service_time) {
        this.service_time = service_time;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFault_desc() {
        return fault_desc;
    }

    public void setFault_desc(String fault_desc) {
        this.fault_desc = fault_desc;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getCustom_phone() {
        return custom_phone;
    }

    public void setCustom_phone(String custom_phone) {
        this.custom_phone = custom_phone;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

//    {
//        "model": "",  //型号
//            "engineer_id": "",//工程师ID
//            "order_state": 1,   //订单状态:1,4,5,6为未完成,2为已完成,3为已取消//1刚发布的订单 ,4确认订单,5已支付,6已接单
//            "class": "",    //类型
//            "service_address": "", //服务地址
//            "fault": "",    //故障点
//            "custom_id": 2,     //客户id
//            "custom_name": "",  //客户名
//            "id": 1,            //订单ID
//            "service_time": "", //服务时间
//            "addtime": "",      //添加时间
//            "image2": "",       //图片二
//            "price": "",        //维修金额
//            "image1": "",       //图片一
//            "pay_type": "",     //支付类型
//            "address_id": "",   //客户关联地址id
//            "isdel": 0,         //是否已删除
//            "brand": "",        //品牌
//            "fault_desc": "",   //故障描述
//            "image3": "",       //图片三
//            "custom_phone": "", //客户电话
//            "order_type": 1     //订单类型
//        "region":"香坊区"             //区
//        "lat":"45.111"        //纬度
//        "lon":"经度"        //经度
//        "city_name":"哈尔滨市"//城市名
//        "city_code":"48"    //城市编码
//    }

}
