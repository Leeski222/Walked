package cn.nju.lee.walked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
import cn.nju.lee.walked.view.map.MapFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.multifab)
    FloatingActionButtonPlus mMultiFloatingActionButton;

    private MapFragment mMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        PermissionUtil.getInstance().getPermissions();
        initCustomMap();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initWidget();
//        DemoActivity.activityStart(this, "a");
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
                    case 0 :
                        mMapFragment.setRequestLoc(true);
                        break;
                    case 1 :
                        break;
                    case 2 :
                        break;
                }
            }
        });
    }

}
