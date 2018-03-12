package cn.nju.lee.walked;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.lzp.floatingactionbuttonplus.FabTagLayout;
import com.lzp.floatingactionbuttonplus.FloatingActionButtonPlus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.util.PermissionUtil;
import cn.nju.lee.walked.view.login.LoginActivity;
import cn.nju.lee.walked.view.map.MapFragment;
import cn.nju.lee.walked.view.recordlist.RecordListActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.multifab)
    FloatingActionButtonPlus mMultiFloatingActionButton;

    private MapFragment mMapFragment;

    private final int LOCATION_CODE = 0;
    private final int LOGIN_CODE = 1;
    private final int SEARCH_CODE = 2;

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

            if (input != null) {
                input.close();
            }

            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initWidget() {
        mMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fgm_map);
        mMultiFloatingActionButton.setOnItemClickListener(new FloatingActionButtonPlus.OnItemClickListener() {
            @Override
            public void onItemClick(FabTagLayout tagView, int position) {
                switch (position) {
                    case LOCATION_CODE:
                        mMapFragment.setRequestLoc(true);
                        break;
                    case LOGIN_CODE :
                        Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent1);
                        break;
                    case SEARCH_CODE :
                        Intent intent = new Intent(MainActivity.this, RecordListActivity.class);
                        startActivity(intent);
                        break;
                    case 3 :
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
