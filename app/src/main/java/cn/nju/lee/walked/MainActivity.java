package cn.nju.lee.walked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.view.widget.DemoActivity;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bmapview_demo)
    MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        DemoActivity.activityStart(this, "a");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
}
