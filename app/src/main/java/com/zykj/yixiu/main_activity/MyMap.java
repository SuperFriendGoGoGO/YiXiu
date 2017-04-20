package com.zykj.yixiu.main_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/20.
 */

public class MyMap extends Activity {
    @Bind(R.id.et_dizhi)
    EditText etDizhi;
    @Bind(R.id.bt_dizhi)
    Button btDizhi;
    @Bind(R.id.bmapView)
    MapView bmapView;
    private LatLng latLng;
    private boolean isFirst = true;
    private LocationClient client;
    private BaiduMap baiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        initLocation();
        seletMap();
    }

    public void jieMa(LatLng latLng1) {
        GeoCoder geoCoder = GeoCoder.newInstance();
        geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng1));
        baiduMap.clear();
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
        OverlayOptions overlayOptions = new MarkerOptions().icon(bitmapDescriptor).position(latLng1);
        baiduMap.addOverlay(overlayOptions);
        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult != null) {
                    Toast.makeText(MyMap.this, reverseGeoCodeResult.getAddress(), Toast.LENGTH_SHORT).show();
                    etDizhi.setText(reverseGeoCodeResult.getAddress());

                }
            }
        });
    }

    private void seletMap() {
        baiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng1) {
                jieMa(latLng1);
            }


            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                Toast.makeText(MyMap.this, mapPoi.getName(), Toast.LENGTH_SHORT).show();
                jieMa(mapPoi.getPosition());
                return false;
            }
        });
    }


    private void initLocation() {
        client = new LocationClient(this);//创建定位对象
        LocationClientOption option = new LocationClientOption();//配置
        option.setCoorType("bd09ll");
        option.setOpenGps(true);
        option.setScanSpan(5000);
        option.setIsNeedAddress(true);
        client.setLocOption(option);
        client.registerLocationListener(new BDLocationListener() {//监听事件
            @Override
            public void onReceiveLocation(final BDLocation bdLocation) {
                if (bdLocation == null || baiduMap == null) {
                    Toast.makeText(MyMap.this, "定位失败", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    MyLocationData data = new MyLocationData.Builder()//把定位信息交给百度地图
                            .accuracy(bdLocation.getRadius())
                            .latitude(bdLocation.getLatitude())
                            .longitude(bdLocation.getLongitude())
                            .build();
                    baiduMap.setMyLocationData(data);//把定位信息交给百度地图
                    //更新地图位置
                    //获取经纬度
                    latLng = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
                    if (isFirst) {
                        etDizhi.post(new Runnable() {
                            @Override
                            public void run() {
                                etDizhi.setText(bdLocation.getAddrStr());
                            }
                        });
                        MapStatusUpdate statusUpdate = MapStatusUpdateFactory.newLatLng(latLng);
                        baiduMap.animateMapStatus(statusUpdate);

                        baiduMap.clear();
                        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
                        OverlayOptions overlayOptions = new MarkerOptions().icon(bitmapDescriptor).position(latLng);
                        baiduMap.addOverlay(overlayOptions);

                        isFirst = false;
                    }

                }
            }

            @Override
            public void onConnectHotSpotMessage(String s, int i) {
            }
        });
    }


    public void onClick(View v) {
        String s = etDizhi.getText().toString();
        GeoCoder geoCoder = GeoCoder.newInstance();
        geoCoder.geocode(new GeoCodeOption()
                .city("哈尔滨")
                .address(s));
        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult result) {
                if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                    Toast.makeText(MyMap.this, "没有检索到结果 ", Toast.LENGTH_SHORT).show();
                } else {
                    LatLng location = result.getLocation();
                    baiduMap.clear();
                    BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
                    OverlayOptions overlayOptions = new MarkerOptions().icon(bitmapDescriptor).position(location);
                    baiduMap.addOverlay(overlayOptions);
                    MapStatusUpdate statusUpdate = MapStatusUpdateFactory.newLatLng(location);
                    baiduMap.animateMapStatus(statusUpdate);
                }
            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        baiduMap.setMyLocationEnabled(true);
        if (!client.isStarted()) {
            client.start();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        baiduMap.setMyLocationEnabled(false);
        client.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bmapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bmapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bmapView.onPause();
    }
}
