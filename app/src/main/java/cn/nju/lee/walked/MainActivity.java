package cn.nju.lee.walked;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.lzp.floatingactionbuttonplus.FabTagLayout;
import com.lzp.floatingactionbuttonplus.FloatingActionButtonPlus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.util.PermissionUtil;
import cn.nju.lee.walked.view.create.CreateActivity;
import cn.nju.lee.walked.view.login.LoginActivity;
import cn.nju.lee.walked.view.map.MapFragment;
import cn.nju.lee.walked.view.seek.SeekActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.multi_fab)
    FloatingActionButtonPlus mMultiFloatingActionButton;

    private MapFragment mMapFragment;

    private final int LOCATION_CODE = 0;
    private final int LOGIN_CODE = 1;
    private final int SEEK_CODE = 2;
    private final int CREATE_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PermissionUtil.getInstance().getPermissions(this);

        // 初始化地图组件
        SDKInitializer.initialize(getApplicationContext());
        initCustomMap();

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initWidget();
    }

    private void initCustomMap() {
        try {
            String moduleName = getFilesDir().getAbsolutePath();
            File file = new File(moduleName + "/" + "map_style");

            if (file.exists()) {
                file.delete();
            }

            file.createNewFile();

            InputStream input = getAssets().open("custom_config_dark");
            byte[] bytes = new byte[input.available()];
            input.read(bytes);

            FileOutputStream out = new FileOutputStream(file);
            out.write(bytes);

            MapView.setCustomMapStylePath(moduleName + "/map_style");


            input.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initWidget() {
        mMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fgm_map);
        mMultiFloatingActionButton.setOnItemClickListener(new FloatingActionButtonPlus.OnItemClickListener() {
            @Override
            public void onItemClick(FabTagLayout tagView, int position) {
                if(position == LOCATION_CODE) {
                    mMapFragment.setRequestLoc(true);
                }

                boolean isLogin = true;
                if(!isLogin) {
                    LoginActivity.activityStart(MainActivity.this);
                }

                switch (position) {
                    case LOGIN_CODE :
                        LoginActivity.activityStart(MainActivity.this);
                        break;
                    case SEEK_CODE :
                        SeekActivity.activityStart(MainActivity.this);
                        break;
                    case CREATE_CODE :
                        mMapFragment.onPause();
                        MyLocationData locationData = mMapFragment.getUserLocation();
                        Log.e("locationData", locationData.latitude + " " + locationData.longitude);
                        CreateActivity.activityStart(MainActivity.this, locationData.latitude, locationData.longitude);
                        mMapFragment.onResume();
                        break;
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtil.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
