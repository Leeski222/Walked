package cn.nju.lee.walked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.lzp.floatingactionbuttonplus.FabTagLayout;
import com.lzp.floatingactionbuttonplus.FloatingActionButtonPlus;

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
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initWidget();
//        DemoActivity.activityStart(this, "a");
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
