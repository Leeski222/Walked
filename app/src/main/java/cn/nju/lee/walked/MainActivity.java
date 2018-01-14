package cn.nju.lee.walked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.baidu.mapapi.SDKInitializer;

import cn.nju.lee.walked.util.PermissionUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        PermissionUtil.getInstance().getPermissions();
        setContentView(R.layout.activity_main);

//        DemoActivity.activityStart(this, "a");
    }
}
