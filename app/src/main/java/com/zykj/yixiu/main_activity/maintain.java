package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.OptionsPickerView;
import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.MobileBean;
import com.zykj.yixiu.utils.UserUtils;
import com.zykj.yixiu.utils.Y;
import com.zykj.yixiu.widget.MyTopBar;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

/**
 * Created by zykj on 2017/4/12.
 */

public class Maintain extends Activity {


    @Bind(R.id.headline)
    MyTopBar headline;
    @Bind(R.id.MobileBrand)
    TextView MobileBrand;
    @Bind(R.id.ll_brand)
    LinearLayout llBrand;
    @Bind(R.id.appliancetype)
    TextView appliancetype;
    @Bind(R.id.iv_type)
    ImageView ivType;
    @Bind(R.id.ll_type)
    LinearLayout llType;
    @Bind(R.id.phonemodel)
    TextView phonemodel;
    @Bind(R.id.ll_model)
    LinearLayout llModel;
    @Bind(R.id.faultpoint)
    TextView faultpoint;
    @Bind(R.id.ll_malfunction)
    LinearLayout llMalfunction;
    @Bind(R.id.describe)
    EditText describe;
    @Bind(R.id.picture)
    ImageView picture;
    @Bind(R.id.transfer)
    Button transfer;
    @Bind(R.id.iv_fanhui)
    ImageView ivFanhui;
    @Bind(R.id.ll_picture)
    LinearLayout llPicture;
    private String mark;//表示符
    private int index;//所选的位置对应的数
    private int i;
    private List<MobileBean> lists;
    private int pid = -1;
    private int cacc = -1;
    private UserUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        //获取首页传来的标示符
        mark = intent.getStringExtra("mark");
        utils = (UserUtils) intent.getSerializableExtra("utils");
        //判断标示符是通过那个按键传来的
        if ("1".equals(mark)) {
            llType.setVisibility(View.GONE);
            //什么都没改变
        } else if ("2".equals(mark)) {
            //改变文字 文字颜色
            headline.setTitleText("电脑维修");
            llType.setVisibility(View.VISIBLE);
            MobileBrand.setText("联想");
            MobileBrand.setTextColor(Color.parseColor("#00cccc"));
            appliancetype.setText("笔记本");
            appliancetype.setHintTextColor(Color.parseColor("#00cccc"));
            phonemodel.setText("Y460A-ITH");
            phonemodel.setTextColor(Color.parseColor("#00cccc"));
            faultpoint.setText("主板");
            faultpoint.setTextColor(Color.parseColor("#00cccc"));
            describe.setHint("开机进不去系统，黑屏白字");
        } else if ("3".equals(mark)) {
            //改变文字
            headline.setTitleText("家电维修");
            llType.setVisibility(View.VISIBLE);
            MobileBrand.setText("请选择你的家电品牌");
            appliancetype.setText("请选择你的家电类型");
            phonemodel.setText("请选择你的家电型号");
            faultpoint.setText("请选择你的家电故障点");
            describe.setHint("请对你的家电故障进行简单的描述");
        }


    }


    @OnClick({R.id.ll_brand, R.id.ll_type, R.id.ll_model, R.id.ll_malfunction, R.id.picture, R.id.transfer, R.id.iv_fanhui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_brand:

                //手机 品牌
                if (mark.equals("1")) {
                    MobileBrand.setText("请选择你的手机品牌");
                    phonemodel.setText("请选择你的手机型号");
                    faultpoint.setText("请选择你的手机故障点");
                    Y.post(new RequestParams("http://221.207.184.124:7071/yxg/findPhoneBrand"), new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {
                                lists = JSON.parseArray(Y.getData(result), MobileBean.class);
                                OptionsPickerView opv = new OptionsPickerView.Builder(Maintain.this, new OptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                        pid = lists.get(options1).getId();
                                        MobileBrand.setText(lists.get(options1).getName().toString());
                                        utils.setBrand(lists.get(options1).getName().toString());


                                    }
                                }).build();
                                List<String> list = new ArrayList();
                                for (MobileBean mb : lists) {
                                    list.add(mb.getName());
                                }
                                //添加数据
                                opv.setPicker(list, null, null);
                                //显示选择器

                                opv.show();
                                MobileBrand.setTextColor(Color.parseColor("#00cccc"));


                            } else {
                                Y.t("解析异常");
                            }
                        }
                    });
                } else if (mark.equals("2")) {
                    MobileBrand.setText("请选择你的电脑品牌");
                    appliancetype.setText("请选择你的电脑类型");
                    phonemodel.setText("请选择你的电脑型号");
                    faultpoint.setText("请选择你的电脑故障点");
                    Y.post(new RequestParams("http://221.207.184.124:7071/yxg/findComputerBrand"), new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {
                                lists = JSON.parseArray(Y.getData(result), MobileBean.class);
                                OptionsPickerView opv = new OptionsPickerView.Builder(Maintain.this, new OptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int options2, int options3, View v) {

                                        MobileBrand.setText(lists.get(options1).getName().toString());
                                        pid = lists.get(options1).getId();
                                        utils.setBrand(lists.get(options1).getName().toString());
                                    }
                                }).build();
                                List<String> list = new ArrayList();
                                for (MobileBean mb : lists) {
                                    list.add(mb.getName());
                                }
                                //添加数据
                                opv.setPicker(list, null, null);
                                //显示选择器

                                opv.show();
                                MobileBrand.setTextColor(Color.parseColor("#00cccc"));

                            } else {
                                Y.t("解析异常");
                            }
                        }
                    });

                } else if (mark.equals("3")) {
                    MobileBrand.setText("请选择你的家电品牌");
                    appliancetype.setText("请选择你的家电类型");
                    phonemodel.setText("请选择你的家电型号");
                    faultpoint.setText("请选择你的家电故障点");
                    Y.post(new RequestParams("http://221.207.184.124:7071/yxg/findByApplianceBrand"), new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {
                                lists = JSON.parseArray(Y.getData(result), MobileBean.class);
                                OptionsPickerView opv = new OptionsPickerView.Builder(Maintain.this, new OptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                        MobileBrand.setText(lists.get(options1).getName().toString());
                                        pid = lists.get(options1).getId();
                                        utils.setBrand(lists.get(options1).getName().toString());
                                    }
                                }).build();
                                List<String> list = new ArrayList();
                                for (MobileBean mb : lists) {
                                    list.add(mb.getName());
                                }
                                //添加数据
                                opv.setPicker(list, null, null);
                                //显示选择器

                                opv.show();
                                MobileBrand.setTextColor(Color.parseColor("#00cccc"));

                            } else {
                                Y.t("解析异常");
                            }
                        }
                    });
                }
                break;
            case R.id.ll_type:
                //电脑分类
                if (pid == -1) {
                    Y.t("请先选择品牌");
                    return;
                }

                if (mark.equals("2")) {
                    appliancetype.setText("请选择你的电脑类型");
                    phonemodel.setText("请选择你的电脑型号");
                    faultpoint.setText("请选择你的电脑故障点");
                    Y.l("" + pid);
                    Y.l(lists.toString());
                    RequestParams params1 = new RequestParams("http://221.207.184.124:7071/yxg/findComputerCategory");
                    params1.addBodyParameter("pid", pid + "");
                    Y.post(params1, new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {
                                lists = JSON.parseArray(Y.getData(result), MobileBean.class);
                                OptionsPickerView opv = new OptionsPickerView.Builder(Maintain.this, new OptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                        appliancetype.setText(lists.get(options1).getName().toString());
                                        cacc = lists.get(options1).getId();
                                        utils.setCategory(lists.get(options1).getName().toString());
                                    }
                                }).build();
                                List<String> list = new ArrayList();
                                for (MobileBean mb : lists) {
                                    list.add(mb.getName());
                                }
                                //添加数据
                                opv.setPicker(list, null, null);
                                //显示选择器

                                opv.show();
                                appliancetype.setTextColor(Color.parseColor("#00cccc"));

                            } else {
                                Y.t("解析异常");
                            }
                        }
                    });

                } else if (mark.equals("3")) {
                    appliancetype.setText("请选择你的家电类型");
                    phonemodel.setText("请选择你的家电型号");
                    faultpoint.setText("请选择你的家电故障点");
                    RequestParams params1 = new RequestParams("http://221.207.184.124:7071/yxg/findApplianceCategory");
                    params1.addBodyParameter("pid", lists.get(index).getId() + "");
                    Y.post(params1, new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {
                                lists = JSON.parseArray(Y.getData(result), MobileBean.class);
                                OptionsPickerView opv = new OptionsPickerView.Builder(Maintain.this, new OptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                        appliancetype.setText(lists.get(options1).getName().toString());
                                        cacc = lists.get(options1).getId();
                                        utils.setCategory(lists.get(options1).getName().toString());
                                    }
                                }).build();
                                List<String> list = new ArrayList();
                                for (MobileBean mb : lists) {
                                    list.add(mb.getName());
                                }
                                //添加数据
                                opv.setPicker(list, null, null);
                                //显示选择器

                                opv.show();
                                appliancetype.setTextColor(Color.parseColor("#00cccc"));

                            } else {
                                Y.t("解析异常");
                            }
                        }
                    });
                }

                break;
            case R.id.ll_model:
                //型号
                if (pid == -1) {
                    Y.t("请先选择品牌");
                    return;
                }

                if (mark.equals("1")) {
                    phonemodel.setText("请选择你的手机型号");
                    faultpoint.setText("请选择你的手机故障点");
                    final RequestParams params2 = new RequestParams("http://221.207.184.124:7071/yxg/findPhoneModel");
                    params2.addBodyParameter("pid", pid + "");
                    Y.post(params2, new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {
                                lists = JSON.parseArray(Y.getData(result), MobileBean.class);
                                OptionsPickerView opv = new OptionsPickerView.Builder(Maintain.this, new OptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                        phonemodel.setText(lists.get(options1).getName().toString());
                                        utils.setModel(lists.get(options1).getName().toString());
                                    }
                                }).build();
                                List<String> list = new ArrayList();
                                for (MobileBean mb : lists) {
                                    list.add(mb.getName());
                                }
                                //添加数据
                                opv.setPicker(list, null, null);
                                //显示选择器

                                opv.show();
                                phonemodel.setTextColor(Color.parseColor("#00cccc"));

                            } else {
                                Y.t("解析异常");
                            }
                        }
                    });

                } else if (mark.equals("2")) {
                    if (pid == -1) {
                        Y.t("请先选择品牌");
                        return;
                    }
                    if (cacc == -1) {
                        Y.t("请先选择类型");
                        return;
                    }
                    phonemodel.setText("请选择你的电脑型号");
                    faultpoint.setText("请选择你的电脑故障点");
                    RequestParams params2 = new RequestParams("http://221.207.184.124:7071/yxg/findByComputerModel");
                    params2.addBodyParameter("pid", pid + "");
                    params2.addBodyParameter("category", cacc + "");
                    Y.post(params2, new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {
                                lists = JSON.parseArray(Y.getData(result), MobileBean.class);
                                OptionsPickerView opv = new OptionsPickerView.Builder(Maintain.this, new OptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                        phonemodel.setText(lists.get(options1).getName().toString());
                                        utils.setModel(lists.get(options1).getName().toString());
                                    }
                                }).build();
                                List<String> list = new ArrayList();
                                for (MobileBean mb : lists) {
                                    list.add(mb.getName());
                                }
                                //添加数据
                                opv.setPicker(list, null, null);
                                //显示选择器

                                opv.show();
                                phonemodel.setTextColor(Color.parseColor("#00cccc"));

                            } else {
                                Y.t("解析异常");
                            }
                        }
                    });

                } else if (mark.equals("3")) {
                    if (pid == -1) {
                        Y.t("请先选择品牌");
                        return;
                    }
                    if (cacc == -1) {
                        Y.t("请先选择类型");
                        return;
                    }
                    phonemodel.setText("请选择你的家电型号");
                    faultpoint.setText("请选择你的家电故障点");
                    RequestParams params2 = new RequestParams("http://221.207.184.124:7071/yxg/findByApplianceModel");
                    params2.addBodyParameter("pid", pid + "");
                    params2.addBodyParameter("category", cacc + "");
                    Y.post(params2, new Y.MyCommonCall<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (Y.getRespCode(result)) {
                                lists = JSON.parseArray(Y.getData(result), MobileBean.class);
                                OptionsPickerView opv = new OptionsPickerView.Builder(Maintain.this, new OptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                        phonemodel.setText(lists.get(i).getName().toString());
                                        utils.setModel(lists.get(options1).getName().toString());
                                    }
                                }).build();
                                List<String> list = new ArrayList();
                                for (MobileBean mb : lists) {
                                    list.add(mb.getName());
                                }
                                //添加数据
                                opv.setPicker(list, null, null);
                                //显示选择器

                                opv.show();
                                phonemodel.setTextColor(Color.parseColor("#00cccc"));

                            } else {
                                Y.t("解析异常");
                            }
                        }
                    });
                }

                break;
            case R.id.ll_malfunction:
                Y.post(new RequestParams("http://221.207.184.124:7071/yxg/findPhoneFault"), new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if (Y.getRespCode(result)) {
                            lists = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView opv = new OptionsPickerView.Builder(Maintain.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    faultpoint.setText(lists.get(options1).getName().toString());
                                    utils.setFault(lists.get(options1).getName().toString());
                                }
                            }).build();
                            List<String> list = new ArrayList();
                            for (MobileBean mb : lists) {
                                list.add(mb.getName());
                            }
                            //添加数据
                            opv.setPicker(list, null, null);
                            //显示选择器

                            opv.show();
                            faultpoint.setTextColor(Color.parseColor("#00cccc"));


                        } else {
                            Y.t("解析异常");
                        }
                    }
                });

                break;
            case R.id.picture:
                GalleryFinal.openGallerySingle(101, new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        if (reqeustCode == 101) {
                            PhotoInfo info = resultList.get(0);
                            String photoPath = info.getPhotoPath();
                            utils.setImage1(photoPath);
                            x.image().bind(picture, new File(photoPath).toURI().toString());
                        }

                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {

                    }
                });
                break;
            case R.id.transfer:
                if (!MobileBrand.getText().toString().isEmpty() && !appliancetype.getText().toString().isEmpty() && !phonemodel.getText().toString().isEmpty() && !faultpoint.getText().toString().isEmpty() && !describe.getText().toString().isEmpty()) {
                    Intent intent = new Intent(this, AttendantCall.class);
                    intent.putExtra("utils",utils);
                    startActivity(intent);
                }
                break;
            case R.id.iv_fanhui:
                Intent intent = new Intent(this, Activity_Main.class);
                startActivity(intent);
                break;
        }
    }
}
