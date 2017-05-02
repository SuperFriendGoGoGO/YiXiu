package com.zykj.yixiu.utils;

import java.io.Serializable;

/**
 * Created by zykj on 2017/5/2.
 */

public class UserUtils implements Serializable {
    //    order_type: 订单类型,1手机,2电脑,3家电
//    brand: 品牌
//    model:型号
//    fault:故障点
//    fault_desc:故障描述
//    category:类别 例如电脑(一体机,笔记本,台式机) 手机此参数为空
//    image1:图片一  必选 必须有一张图片
//    image2:图片二  可选
//    image3:图片一   可选
//    service_time:上门服务时间
//    service_address:服务地址
//    custom_phone:客户电话
//    custom_name:客户姓名
//    custom_id:客户ID
//    address_id:客户关联的地址ID


    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public String getFault_desc() {
        return fault_desc;
    }

    public void setFault_desc(String fault_desc) {
        this.fault_desc = fault_desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getService_time() {
        return service_time;
    }

    public void setService_time(String service_time) {
        this.service_time = service_time;
    }

    public String getService_address() {
        return service_address;
    }

    public void setService_address(String service_address) {
        this.service_address = service_address;
    }

    public String getCustom_phone() {
        return custom_phone;
    }

    public void setCustom_phone(String custom_phone) {
        this.custom_phone = custom_phone;
    }

    public String getCustom_name() {
        return custom_name;
    }

    public void setCustom_name(String custom_name) {
        this.custom_name = custom_name;
    }

    public String getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(String custom_id) {
        this.custom_id = custom_id;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }
    @Override
    public String toString() {
        return "UserUtils{" +
                "order_type='" + order_type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fault='" + fault + '\'' +
                ", fault_desc='" + fault_desc + '\'' +
                ", category='" + category + '\'' +
                ", image1='" + image1 + '\'' +
                ", service_time='" + service_time + '\'' +
                ", service_address='" + service_address + '\'' +
                ", custom_phone='" + custom_phone + '\'' +
                ", custom_name='" + custom_name + '\'' +
                ", custom_id='" + custom_id + '\'' +
                ", address_id='" + address_id + '\'' +
                '}';
    }

    private String order_type;
    private String brand;
    private String model;
    private String fault;
    private String fault_desc;
    private String category;
    private String image1;
    private String service_time;
    private String service_address;
    private String custom_phone;
    private String custom_name;
    private String custom_id;
    private String address_id;


}
