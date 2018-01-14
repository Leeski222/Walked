package cn.nju.lee.walked.util;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by 果宝 on 2018/1/13.
 * 专门负责动态权限管理的类
 */

public class PermissionUtil {
    private volatile static PermissionUtil mPermissionUtil;

    private String[] permissions = {
            Manifest.permission.READ_PHONE_STATE,           //获取手机状态的权限
            Manifest.permission.ACCESS_COARSE_LOCATION,     //获取位置信息的权限
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,      //获取读写SD卡的权限
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private PermissionUtil() {
    }

    public static PermissionUtil getInstance() {
        if(mPermissionUtil == null) {
            synchronized (PermissionUtil.class) {
                mPermissionUtil = new PermissionUtil();
            }
        }
        return mPermissionUtil;
    }

    public void getPermissions() {
        if(Build.VERSION.SDK_INT >= 23) {
            new HelpActivity();
        }
    }

    private class HelpActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (EasyPermissions.hasPermissions(this, permissions)) { //检查是否获取该权限
                Log.i("getPermission", "已获取权限");
            } else {
                EasyPermissions.requestPermissions(this, "必要的权限", 0, permissions);
            }
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            //把申请权限的回调交由EasyPermissions处理
            EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        }

        @Override
        public void onPermissionsGranted(int requestCode, List<String> perms) {
            Log.i("PermissionUtil", "获取成功的权限" + perms);
        }

        @Override
        public void onPermissionsDenied(int requestCode, List<String> perms) {
            Log.i("PermissionUtil", "获取成功的权限" + perms);
        }
    }
}
