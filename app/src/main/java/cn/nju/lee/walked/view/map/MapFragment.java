package cn.nju.lee.walked.view.map;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ZoomControls;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.R;


/**
 * Created by 果宝 on 2018/1/12.
 */

public class MapFragment extends Fragment implements OnUpdateMyLocationData{

    // 是否为初次定位
    private boolean isFirstLoc;

    // 是否请求归位
    private boolean isRequestLoc;

    @BindView(R.id.map_baidu)
    MapView mMapView;

    private BaiduMap mBaiduMap;

    private MyLocationClient myLocationClient;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);
        initProperty();
        initMapConfig();
        initMyLocationConfig();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
        myLocationClient.resumeClient();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
        myLocationClient.pauseClient();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        myLocationClient.stopClient();
    }

    private void initProperty() {
        isFirstLoc = true;
        isRequestLoc = false;
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setOnMapLoadedCallback(new BaiduMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                MapView.setMapCustomEnable(true);
            }
        });
        myLocationClient = new MyLocationClient(getActivity().getApplicationContext(), this);
    }

    /**
     * 初始化地图设置
     */
    private void initMapConfig() {
        // 隐藏地图上的百度LOGO
        View child = mMapView.getChildAt(1);
        if (child != null
                && (child instanceof ImageView
                || child instanceof ZoomControls)) {

            child.setVisibility(View.INVISIBLE);
        }

        // 隐藏地图上比例尺
        mMapView.showScaleControl(false);

        // 隐藏地图缩放控件（按钮控制栏）
        mMapView.showZoomControls(false);

        // 开启定位功能
        mBaiduMap.setMyLocationEnabled(true);
    }

    /**
     * 初始化定位图层的配置
     */
    private void initMyLocationConfig() {
        MyLocationConfiguration.LocationMode mCurrentMode =
                MyLocationConfiguration.LocationMode.NORMAL;
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

        // 设置定位图层的初始层级
        int initLevel = 20;
        MapStatus mMapStatus = new MapStatus.Builder().zoom(initLevel).build();
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        mBaiduMap.setMapStatus(mMapStatusUpdate);
    }

    /**
     * 将地图的视角定位到用户所在位置
     * @param locData
     */
    private void showUserLocation(MyLocationData locData) {
        int initLevel = 20;
        LatLng latLng = new LatLng(locData.latitude, locData.longitude);
        MapStatusUpdate mapStatusUpdate  = MapStatusUpdateFactory.newLatLng(latLng);
        mBaiduMap.animateMapStatus(mapStatusUpdate);
    }

    /**
     * 设置回归用户位置的标志位
     * @param isRequestLoc
     */
    public void setRequestLoc(boolean isRequestLoc) {
        this.isRequestLoc = isRequestLoc;
    }

    /**
     * 供MyLocationClient回调的方法
     * MyLocationClient收到新的定位数据后会立刻回调该方法
     * @param locData
     */
    @Override
    public void updateMyLocationData(MyLocationData locData) {
        // 设置定位数据
        mBaiduMap.setMyLocationData(locData);

        if(isRequestLoc || isFirstLoc) {
            isFirstLoc = false;
            isRequestLoc = false;
            showUserLocation(locData);
        }
    }
}
