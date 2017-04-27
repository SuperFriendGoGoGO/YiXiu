package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.Address;
import com.zykj.yixiu.utils.Y;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zykj.yixiu.R.id.textView;

/**
 * Created by zykj on 2017/4/20.
 */

public class MyMap extends Activity {

    EditText etDizhi;

    Button btDizhi;

    MapView mMapView;
    private LatLng latLng;
    private boolean isFirst = true;
    private LocationClient client;
    private BaiduMap map;
    private LocationClient mClient;
    private String addrStr;
    private String address;
    private Address add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_map);
        mMapView = (MapView) findViewById(R.id.bmapView);
        etDizhi = (EditText) findViewById(R.id.et_dizhi);
        btDizhi = (Button) findViewById(R.id.bt_dizhi);
        map = mMapView.getMap();
        initLocation();
        selectMap();

        btDizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city_name = etDizhi.getText().toString();
                if (TextUtils.isEmpty(city_name)) {
                    Toast.makeText(MyMap.this, "请输入或选择地址", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    //发起地理编码
                    GeoCoder geoCoder = GeoCoder.newInstance();
                    //发起地理编码
                    geoCoder.geocode(new GeoCodeOption().city("哈尔滨市").address(city_name));
                    //地理编码监听器
                    geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
                        @Override   //是我啊
                        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                            if (geoCodeResult == null || geoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                                Toast.makeText(MyMap.this, "请输入合法地址", Toast.LENGTH_SHORT).show();
                            } else {


                                Toast.makeText(MyMap.this, "地址添加成功", Toast.LENGTH_SHORT).show();
                                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(geoCodeResult.getLocation());// 更新百度地图对象
                                map.animateMapStatus(msu);  //把更新的信息告诉百度

                            }
                        }

                        @Override
                        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                        }
                    });

                }
                finish();
                Intent intent = getIntent();
                intent.putExtra("add", add);
                MyMap.this.setResult(0, intent);
                MyMap.this.finish();
            }
        });
    }

    //地图选点
    public void selectMap() {
        //添加地图单击事件监听器
        map.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override    // 地图点击回调
            public void onMapClick(LatLng latLng) {


                jieMa(latLng); //反地理

                setBitmap(latLng); // 添加标注
            }

            @Override  //当前位置的兴趣点
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });
    }

    // 添加标注
    public void setBitmap(LatLng latLng) {
        map.clear();
        OverlayOptions options = new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        map.addOverlay(options);
    }

    // 地理编码
    public void jieMa(LatLng latLng) {
        double latitude = latLng.latitude;
        add.setLat(latitude);
        double longitude = latLng.longitude;
        add.setLon(longitude);
        GeoCoder geoCoder = GeoCoder.newInstance();  // 创建地理编码对象

        //发起反地理
        geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        //发起地理编码 //geoCoder.geocode(new GeoCodeOption().address(""));
        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override  //  地理编码的回调
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

            }

            @Override      //反地理编码的回调
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {

                if (reverseGeoCodeResult != null) {
                    Toast.makeText(MyMap.this, reverseGeoCodeResult.getAddress(), Toast.LENGTH_SHORT).show();
                    etDizhi.setText(reverseGeoCodeResult.getAddress());
                    ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
                    Y.l(addressDetail.province);
                    address = reverseGeoCodeResult.getAddress();
                    add.setAddress(address);
                    String city = addressDetail.city;
                    add.setCity_name(city);
                    String district = addressDetail.district;
                    add.setRegion(district);


                }
            }
        });


    }

    //初始化定位
    public void initLocation() {
        //创建定位对象
        mClient = new LocationClient(this);
        //使用 LocationClientOption配置定位的所有信息
        LocationClientOption clientOption = new LocationClientOption();
        clientOption.setCoorType("bd09ll"); //经纬度为百度经纬度
        clientOption.setOpenGps(true);  // 开启GPS吧
        // clientOption.setScanSpan(5000); //定位间隔5000毫秒
        clientOption.setIsNeedAddress(true); // 定位成功后是否返回地址信息

        mClient.setLocOption(clientOption); //配置信息交给LocationClient对象

        //设置一个定位监听事件
        mClient.registerLocationListener(new BDLocationListener() {
            @Override  // 定位成功
            public void onReceiveLocation(BDLocation bdLocation) {

                if (bdLocation == null || map == null) {
                    Toast.makeText(MyMap.this, "定位失败", Toast.LENGTH_SHORT).show();
                    return;
                }
                addrStr = bdLocation.getAddrStr();
                etDizhi.post(new Runnable() {
                    @Override
                    public void run() {
                        etDizhi.setText(addrStr);
                    }
                });


                //获取BDLocation数据转换成MyLocationData
                MyLocationData myLocationData = new MyLocationData.Builder()
                        .accuracy(bdLocation.getRadius()) // 半径
                        .latitude(bdLocation.getLatitude()) //经纬度
                        .longitude(bdLocation.getLongitude())//经纬度
                        .build();
                map.setMyLocationData(myLocationData); // 把定位信息交给百度地图
                //更新地图位置
                //获取经纬度
                latLng = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());

                if (isFirst) {

                    MapStatus.Builder builder = new MapStatus.Builder();
                    builder.target(latLng).zoom(18.0f);


                    jieMa(latLng);
                    String cityCode = bdLocation.getCityCode();
                    add.setCity_code(cityCode);
                    map.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
//                    MapStatusUpdate msu= MapStatusUpdateFactory.newLatLng(latLng);// 更新百度地图对象
//                    map.animateMapStatus(msu);  //把更新的信息告诉百度
                    address = bdLocation.getAddress().address;
                    add.setAddress(address);
                    String city = bdLocation.getAddress().city;
                    add.setCity_name(city);
                    String district = bdLocation.getAddress().district;
                    add.setRegion(district);
                    isFirst = false;  //我已经不是第一次了
                }
                //在当前绘制一个标注
                OverlayOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory
                        .fromResource(R.mipmap.ic_launcher)).position(latLng);
                map.addOverlay(markerOptions);
            }

            @Override  //返回兴趣点信息
            public void onConnectHotSpotMessage(String s, int i) {
            }
        }); //设置监听事件

    }

    //回到我的位置
    public void centerLocation() {
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);// 更新百度地图对象
        map.animateMapStatus(msu);  //把更新的信息告诉百度
    }

    @Override  //调用定位
    protected void onStart() {
        super.onStart();
        map.setMyLocationEnabled(true);
        if (!mClient.isStarted()) {
            mClient.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        map.setMyLocationEnabled(false);
        mClient.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}