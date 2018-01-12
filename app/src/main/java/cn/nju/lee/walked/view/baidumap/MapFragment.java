package cn.nju.lee.walked.view.baidumap;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.R;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by 果宝 on 2018/1/12.
 */

public class MapFragment extends Fragment {
    @BindView(R.id.map_baidu)
    MapView mMapView;

    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);
        initProperty();
        initMyLocationConfig();
        initMyLocationClient();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    private void initProperty() {
        mBaiduMap = mMapView.getMap();
        mLocationClient = new LocationClient(getActivity().getApplicationContext());
    }

    /**
     * 初始化定位图层的配置
     */
    private void initMyLocationConfig() {
        MyLocationConfiguration.LocationMode mCurrentMode =
                MyLocationConfiguration.LocationMode.FOLLOWING;
        boolean enableDirection = true;
        int accuracyCircleFillColor = 0xAAFFFF88;
        int accuracyCircleStrokeColor = 0xAA00FF00;
        BitmapDescriptor mCurrentMarker =
                BitmapDescriptorFactory.fromResource(R.drawable.ic_3d_rotation);

        // 设置定位图层的配置（定位模式，是否允许方向信息，用户自定义定位图标, 自定义精度圈填充颜色, 自定义精度圈边框颜色）
        MyLocationConfiguration config = new MyLocationConfiguration(
                mCurrentMode, enableDirection, mCurrentMarker,
                accuracyCircleFillColor, accuracyCircleStrokeColor);

        mBaiduMap.setMyLocationConfiguration(config);
    }

    /**
     * 初始化定位客户端
     */
    private void initMyLocationClient() {

        LocationClientOption option = new LocationClientOption();

        //设置定位模式，LocationMode.Hight_Accuracy：高精度；
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);

        //设置返回经纬度坐标类型，bd09ll：百度经纬度坐标；
        option.setCoorType("bd09ll");

        //设置发起定位请求的间隔，int类型，单位ms
        //如果设置为0，则代表单次定位，即仅定位一次，默认为0
        //如果设置非0，需设置1000ms以上才有效
        option.setScanSpan(1000);

        //设置是否使用gps，使用高精度和仅用设备两种定位模式的，参数必须设置为true
        option.setOpenGps(true);

        //设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setLocationNotify(true);

        //定位SDK内部是一个service，并放到了独立进程。设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)
        option.setIgnoreKillProcess(false);

        //设置是否收集Crash信息，默认收集，即参数为false
        option.SetIgnoreCacheException(false);

        //如果设置了该接口，首次启动定位时，会先判断当前WiFi是否超出有效期，若超出有效期，会先重新扫描WiFi，然后定位
        option.setWifiCacheTimeOut(5 * 60 * 1000);

        //设置是否需要过滤GPS仿真结果，默认需要，即参数为false
        option.setEnableSimulateGps(false);

        //设置mLocationClient并启动
        mLocationClient.registerLocationListener(new MyLocationListener());
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    /**
     * 内部监听类
     * 用于实时处理定位信息
     */
    private class MyLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            // 构造定位数据
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            // 设置定位数据
            mBaiduMap.setMyLocationData(locData);
        }
    }
}
